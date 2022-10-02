# Item10. equals는 일반 규약을 지켜 재정의하라

## equals 재정의 하지 않은 것이 최선인 방법인 경우
* 각 인스턴스가 본질적으로 고유하다.
  * 값을 표현하는 게 아니라 동작하는 개체를 표현하는 클래스가 여기 해당
* 인스턴스의 '논리적 동치성'을 검사할 일이 없다
* 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어 맞는다.
  * Set 구현체는 AbstractSet, List 구현체는 AbstractList, Map 구현체는 AbstractMap들은 equals를 상속받아 그대로 쓰고 있다.
* 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.
  * 실수라도 호출되는 걸 막고 싶다면 
```java
@Override
public boolean equals(Object o){
    throw new AssertionError();
}
```

## equals 재정의해야 할 때
* 객체가 물리적으로 같은가가 아니라 논리적 동치성을 확인해야 하는데 상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의하지 않았을 때
  * 주로 값 클래스들로 판별(Integer, String 으로)
  * 값 클래스라고 해도 Item1 처럼 인스턴스 통제 클래스는 equals를 재정의 할 필요 없다.

## equals 재정의 규약
* 반사성 
  * null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true이다
* 대칭성
  * null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)가 true면 y.equals(x)도 true다
```java
public final class CaseInsensitiveString{
    private final String s;
    
    public CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }
    
    // 대칭성 위배
    @Override
    public boolean equals(Object o){
        if(o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s 
            );
        if(o instanceof String) // 한 방향으로만 작동한다
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}

class Main{
    public static void main(String[] args){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        cis.equals(s); // true
        s.equals(cis); // false
    }
}
```

* 추이성
  * null이 아닌 모든 참조 값 x, y, z에 대해 x.equals(y)가 true면 y.equals(z), x.equals(z)도 true다
  * 구체 클래스를 확장해 새로운 값ㅇ르 추가하면서 equals 구약을 만족시킬 방법은 존재하지 않는다.
    * 객체 지향적 추상화의 이점을 포기하지 않는 한

```java
public class Point{
    private final int x;
    private final int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
  public boolean equals(Object o){
        if(!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

public class ColorPoint extends Point{
    private final Color color;
    
    public ColorPoint(int x,int y, Color color){
        super(x, y);
        this.color = color;
    }
    
    // 잘못된 코드 - 대칭성 위배
  @Override
  public boolean equals(Object o){
        if(!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color = color;
  }
}

class Main{
    public static void main(String[] args){
        Point p = new Point(1,2);
        ColorPoint cp = new ColorPoint(1,2,Color.RED);
        
        p.equals(cp); // true
        cp.equals(p); // false
    }
}
```

  

* 일관성
  * null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)를 반복해서 호출해도 항상 일정한 boolean값이 반환 된다.
  * equals의 판단에 신뢰할 수 없는 자원이 끼어들게 해서는 안 된다.
* null-아님
  * null이 아닌 모든 참조 값 x에 대해 x.equals(null)은 false다
```java
@Override
public boolean equals(Object o){
    if(!(o instanceof MyType))
        return false;
      //...
}
```
### 양질의 equals 메서드 구현하는 방법
1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.
```java
@Override
public boolean equals(Object o){
    if(o==this)
        return true;
}
```
2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
  * 가끔은 그 클래스가 구현한 인터페이스가 될 수도 있다.

```java
@Override
public boolean equals(Object o){
    // ...
    if(!(o instanceof PhoneNumber)) return false;
}
```
3. 입력을 올바른 타입으로 형변환한다.
* instanceof 검사를 했기 때문에 이 단계는 100% 성공한다.
4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.

#### equals를 재정의할 땐 hashCode도 반드시 재정의하자
#### 너무 복잡하게 해결하려 들지 말자.