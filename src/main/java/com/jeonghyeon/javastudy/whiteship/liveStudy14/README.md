# 백기선님 자바 라이브 스터디 14일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 제네릭 사용법 
* 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
* 제네릭 메소드 만들기 
* Erasure


### 제네릭 사용법
* 제네릭
  * Java 5 부터 추가
  * 컴파일 시점에서 잘못된 타입 사용 문제를 제거할 수 있다.

```java
class PageDto<T>{
    private Boolean isFirst;
    private Boolean isLast;
    private List<T> data;
    
    public PageDto(boolean isFirst, boolean isLast, List<T> data){
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.data = data;
    }
}

```
* 멀티 타입 파라미터
  * 2개 이상 멀티 타입으로 가능
```java
class Product<T,V>{
    private T t;
    private V v;
    
    public Product(T t, V v){
        this.t = t;
        this.v = v;
    }
}
```
### 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
* 바운디드 타입
  * 특정 타입으로 제한 할 때 사용
  * 잘못된 하위 타입이 들어갈 시 컴파일 에러 발생
```java
public <T extends 상위 타입> 리턴타입 메소드_명(파라미터, ...){...}


```

```java
class BoundedClass {
    public <T extends Number> int method(T t1, T t2) {
        int num1 = t1.intValue();
        int num2 = t2.intValue();
        return num1 + num2;
    }
}

```

* 와일드 카드
  * 구체적인 타입 대신 모든 타입, 하위 타입, 상위 타입으로 제한할 수 있다
  * 종류
```java
<?>
모든 클래스나 인터페이스 타입 다 가능

<? extends 상위 타입> 상위 타입을 X로 표시
X와 X를 상속 받은 클래스들만 가능 (X의 상위 타입은 제한)

<? super 하위 타입> 하위 타입을 Y로 표시
Y와 Y가 상속 받은 클래스들만 가능 (Y의 하위 타입은 제한)

``` 

### 제네릭 메소드 만들기
* 매개타입과 리턴 타입으로 타입 파라미터를 갖는 메소드
```java
public <타입 파라미터, ...> 리턴_타입 메소드_명(매개변수,...){...}
```

```java
class UtilClass {
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }
}
class Init{
    public static void main(String[] args){
        Box<Integer> box = UtilClass.<Integer>boxing(100);
    }
}


```
### Erasure
* 컴파일러에 의해 파일을 체크하고 맞는 코드로 형 변환을 해주지 컴파일 된 class 파일에는 제네릭이 쓰여진 부분은 없다.
* 런타임시 클래스에 대한 정보를 얻고 싶으면
* 
### 추가
* 제내릭 활용

```java


import java.util.ArrayList;

public interface Entity<K> {

  K getId();
}

public class Apple extends Entity {
  public static Apple of(Integer id) {
    Apple apple = new Apple();
    apple.id = id;
    return apple;
  }
}

public class GenericDao<E extends Entity<K>, K> {
  private Map<K, E> datasource = new HashMap<>();

  public void save(E e) {
    datasource.put(e.getId(), e);
  }

  public void delete(E e) {
    datasource.remove(e.getId());
  }

  public void delete(K k) {
    datasource.remove(k);
  }

  public List<E> findAll() {
    return new ArrayList<>(datasource.values());
  }
  
  public E findById(K id) { return datasource.get(id); }
}
```
### 참고 자료
* 도서 - 이것이 자바다
