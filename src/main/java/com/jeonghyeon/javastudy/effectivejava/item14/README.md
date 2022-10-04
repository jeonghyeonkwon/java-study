# Item14. Comparable을 구현할 지 고려하라
* compareTo는 Object 메서드가 아니다
  * 단순 동치성 비교와 순서까지 비교 가능

### compareTo 규약
1. 두 객체 참조의 순서를 바꿔 비교해도 예상한 결과가 나와야 된다.
2. 첫번째가 두 번째보다 크고 두 번째가 세 번째보다 크면 첫 번째는 세 번째보다 커야 한다
3. 크기가 같은 객체들끼리는 어떤 객체와 비교하더라도 항상 같아야 한다


* 메서드를 비교할 때 < 와 >를 사용하지 마라!
### HashSet과 TreeSet

```java
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

class Init {

  public static void main(String[] args) {
    BigDecimal num1 = new BigDecimal("1.0");
    BigDecimal num2 = new BigDecimal("1.00");
    HashSet<BigDecimal> hashSet = new HashSet<>();
    hashSet.add(num1);
    hashSet.add(num2);
    System.out.println(hashSet.size()); // 2 <- equals로 비교 하기 때문에

    TreeSet<BigDecimal> treeSet = new TreeSet<>();
    treeSet.add(num1);
    treeSet.add(num2);
    System.out.println(treeSet.size()); // 1 <- compareTo로 비교
  }

}

```

### 기본 타입 필드가 여럿일 때의 비교자
```java
public int compareTo(PhoneNumber pn){
    int result = Short.compare(areaCode, pn.areaCode);
    if(result == 0){
        result = Short.compare(prefix, pn.prefix);
        if( result == 0 ){
            result = Short.compare(lineNum, pn.lineNum);
        }
    }
    return result;
}
```


### 간결하지만 성능이 조금 느려진다
```java
private static final Comparator<PhoneNumber> COMPARATOR = 
        comparingInt((PhoneNumber pn) -> pn.areaCode)
        .thenComparingInt(pn -> pn.prefix)
        .thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn){
    return COMPARATOR.compare(this,pn);
}
```

### 값의 차에 대한 방식
```java
// 잘못된 방식
static Comparator<Object> hashCodeOrder = new Comparator<>(){
    public int compare(Object o1, Object o2){
        return o1.hashCode() - o2.hashCode();    
    }    
}

// 아래의 두 방식 중 택 1


static Comparator<Object> hashCodeOrder = new Comparator<>(){
    public int compare(Object o1, Object o2){
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

static Comparator<Object> hashCodeOrder = 
    Comparator.comparingInt(o->o.hashCode());
```