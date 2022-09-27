# 백기선님 자바 라이브 스터디 14일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 람다식 사용법
* 함수형 인터페이스
* Variable Capture
* 메소드, 생성자 레퍼런스

### 람다식 사용법
* 문법
  * (파라미터,...) -> { 실행문; ... }
```java
// return X
(String str) -> {System.out.println(str);}

(str) -> {System.out.println(str);}

str -> {System.out.println(str);}

str -> System.out.println(str);


// return O
(num1, num2) -> num1 + num2;
        
(num1, num2) -> {System.out.println(num1 + num2); return num1+ num2;}

```
* 사용 예제
```java
@FunctionalInterface
public interface FunctionalInter{
    int method(int x);
}

class Init{
    public static void main(String[] args){
        FunctionalInter fi = (x)-> System.out.println(x);
        
        fi.method(10);
    }
}
```

### 함수형 인터페이스

* 자바에서 기본적으로 지원하는 함수형 인터페이스

| 종류        | 내용                         | 요약           |
|-----------|----------------------------|--------------|
| Consumer  | 파라미터가 있고 리턴 값은 없음          | T -> Void    |
| Supplier  | 파라미터가 없고 리턴 값은 있음          | Void -> T    |
| Function  | 파라미터, 리턴 값 둘 다 있음, 타입 변환 용도 | T -> R       |
| Operator  | 파라미터, 리턴 값 둘 다 있음, 계산 용도   | T -> R       |
| Predicate | 파라미터가 있고 리턴 값은 boolean     | T -> Boolean |

### Variable Capture
 * 람다의 (a,b,...)것 이외의 변수에 접근하는 것
   
 * 익명 내부클래스와 람다는 Scope이 다르다. 람다는 실행 시키는 메소드와 Scope이 같다
   * 익명 내부 클래스는 호출하는 메소드의 같은 이름의 변수가 있어도 쉐도잉 처리로 인해 내부 클래스의 값으로 덮어준다.
   * 람다는 같은 Scope이므로 컴파일 에러가 뜬다.

### 메소드, 생성자 레퍼런스
* 정적 메소드 인스턴스 메소드 참조
  * 정적 메소드
    * 클래스 :: 메소드
  * 인스턴스 메소드
    * 참조 변수 :: 메소드

```java
import java.util.function.Function;

public class ReferClass {

  public static int staticMethod(String str) {
    //..
  }

  public int method(String str) {
    //...
  }
}

class InitClass {
  public static void main(String[] args) {
    Function<String, Integer> staticMethod = ReferClass::staticMethod;
    staticMethod.apply("내용");
    
    ReferClass obj = new ReferClass();
    Function<String, Integer> instanceMethod = obj::method;
    instanceMethod.apply("내용");
  }
}
```

* 매게변수의 메소드 참조
  * return값은 Function클래스를 상속 받은 클래스<파라미터1, 파라미터2,...> 
  * (a, b) -> { a.instanceMethod(b);}
  * 클래스 :: instanceMethod

* 생성자 참조
  * return값은 Function클래스를 상속 받은 클래스<파라미터1, 파라미터2,..., 객체>
  * (a, b) -> { return new 클래스(a,b); }
  * 클래스 :: new

### 추가

```java
import java.util.Arrays;

public class Init {
    public static void main(String[] args){
      String[] arr = {"a", "b", "c"};
      // (o1, o2) -> o1.compareTo(o2);
      // String::compareToIgnoreCase
      // (this, o2) -> this.compareTo(o2)
      Arrays.sort(arr,String::compareToIgnoreCase);    
    }
    
}
```
### 참고 자료
* 도서 - 이것이 자바다
