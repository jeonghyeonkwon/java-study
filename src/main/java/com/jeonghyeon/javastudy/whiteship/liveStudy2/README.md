# 백기선님 자바 라이브 스터디 2일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습 내용
* 프리미티브 타입 종류와 값의 범위 그리고 기본값
* 프리미티브 타입과 레퍼런스 타입
* 리터럴
* 변수 선언 및 초기화하는 방법
* 변수의 스코프와 라이프타임
* 타입 변환, 캐스팅 그리고 타입 프로모션
* 1차 및 2차 배열 선언하기
* 타입 추론, var

### 프리미티브 타입 종류와 값의 범위 그리고 기본값
* primitive type, 원시 타입, 기본형 타입 이라고 불림

| 구분  | primitive type | 메모리 크기 | 기본값      | 범위                                                     |
|-----|----------------|--------|----------|--------------------------------------------------------|
| 논리형 | boolean        | 1 byte | false    | true, false                                            |
| 정수형 | byte           | 1 byte | 0        | -128 ~ 127                                             |
| 정수형 | short          | 2 byte | 0        | -32,768 ~ 32,767                                       |
| 정수형 | int            | 4 byte | 0        | -2,147,483,648 ~ 2,147,483,647                         |
| 정수형 | long           | 8 byte | 0L       | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 |
| 실수형 | float          | 4 byte | 0.0F     | (3.4 * 10^-38) ~ (3.4 * 10^38)의 근사값                    |
| 실수형 | double         | 8 byte | 0,0      | (1.7 * 10^-308) ~ (1.7 * 10^308)의 근사값                  |
| 문자형 | char           | 2 byte | '\u0000' | 0 ~ 65,535                                             |

* 자바 8 이전 까지는 unsigned가 없다 
  * 음수를 없애고 양수를 두배로 늘린다.
```java
int unsigned = Integer.parseUnsignedInt("220000000");

System.out.println(Integer.toUnsignedString(unsigned));

// System.out.println(unsigned);는 안된다
```
* 변수는 stack 영역에 쌓인다
### 프리미티브 타입과 레퍼런스 타입
* Primitive Type
  * byte, short, signed/unsigned long, float, double boolean, char
  * not object
  * 값 저장
* Reference Type
  * class, interface, enum, array, String type
  * 주소 저장
### 리터럴
* 변수나 상수에 저장되는 값 자체
```java
int number = 1_000_000; //가능
```
#### 정수 리터럴
```java
// int 타입
int binary = 0b10101000 // 2진법 앞에 0b붙으면
int decimal = 77; // 10진법
int octal = 077; //8진법 앞에 0을 붙이면 됨. 단 8이상의 수가 들어가있으면 컴파일 에러
int hexaDecimal = 0x77; //16진법 0x가 붙으면

// long 타입 뒤에 L 또는 l
long longNumber = 1L; 
long longNumber = 1l;

```
#### 실수 리터럴
```java
//double 타입
double doubleNumber = 0.1;
double doubleNumber = 1E-1; 


// float 타입 뒤에 F 또는 f
float floatNumber = 0.1f; 
float floatNumber = 0.1F;

```
#### 문자 리터럴

```java
// 특수문자
'/b' // 백 스페이스
'/n' // 줄바꿈
'/t' // 탭
'/f' // 폼 피드
'\"' //쌍 따옴포
'\'' // 따옴표
'\\' //역슬래시
```
### 변수 선언 및 초기화하는 방법
```java

int number = 10;

number = 11;

```
### 변수의 스코프와 라이프타임

```java
class ScopeClass{
    // 클래스 변수
    static int classVariable = 123;
    // 클래스가 메모리에 올라갈 때
    // static 을 붙이면 됨
    
  
    // 인스턴스 변수
    int instanceVariable = 123;
    // 인스턴스가 생성 되었을 때

    //지역 변수
    void methodA(){
        int localVariable = 123;
        // 변수 선언문이 수행 되었을 때
    }
}
```
```java
public class TestClass{
    private static int number = helloNumber();
    
    public int helloNumber(){
        return 10;
    }
    // 이거는 안됨 
    // 클래스 변수는 클래스가 만들어진 시점이고
    // helloNumber 메소드는 new로 인스턴스를 생성했을 때라 안됨

    private static int number = 100;
  
    public int helloNumber(){
      return TestClass.number;
    }
    // 이거는 됨
  
}
```
### 타입 변환, 캐스팅 그리고 타입 프로모션
```java

long a = 100l;
int b = (int) a;

// 이런 식으로 타입을 변경해 주는 것
// 상속 받은 클래스도 가능
class Parent{
    
}
class ChildA extends Parent{
    
}

public class Main{
    public static void main(String[] args){
        ChildA child = new ChildA();
        Parent parent = new Parent();
        parent = (Parent) child;
    }
}
```
### 1차 및 2차 배열 선언하기
* 힙 영역에 생성된다.
```java
//타입[] 변수명 = new 타입[크기]{값1,값2,값3,값4};

// 1차원 배열
int[] a = new int[4]{1,2,3,4};

// 2차원 배열
int[][] a  = new int[2][3]{{1,2,3},{4,5,6}};
```
### 타입 추론, var


* var
  * 자바 10 부터 추가
  * 컴파일러에게 타입 추론 책임을 위임하는 것
```java

var arr = Arrays.asList(1,2,3,4,5);

```
### 추가 
```java
//돈 계산 관련된 것 달러(소수점)
//float, double로 하면 안되고
BigDecimal number = BigDecimal.ZERO;
for(int i=0; i<10; i++){
    number = number.add(BigDecimal.valueOf(0.1)); 
    //number에 더해진 것이 아니라 더한 새로운 객체를 리턴함 
}
```