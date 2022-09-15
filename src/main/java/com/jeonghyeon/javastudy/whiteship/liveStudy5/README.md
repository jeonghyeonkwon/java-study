# 백기선님 자바 라이브 스터디 5일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 클래스 정의하는 방법
* 객체 만드는 방법(new 키워드 이해하기)
* 메소드 정의하는 방법
* 생성자 정의하는 방법
* this 키워드 이해하기

### 클래스 정의하는 방법
* 객체지향 특성
  * 추상화
  * 캡슐화
  * 상속
  * 다형성

```java
public class Init{
    private int number;

    {
        this.number = 10;
    }
    
    public Init(){
        this.number = 100;
    }
    
    
    public static void main(String[] args){
        Init init = new Init();
        System.out.println(init.number); // 100이 출력 (좀 더 명시적인 것을 출력) 
    }
}

class Init{
    static int number;
    {
        number = 20;
    }
    
    //or
    static int number = 20;
    
}


```
#### 접근 제한자
| 접근 제한자                 |범위|
|------------------------|---|
| public                 |모든 패키지 다|
| protected              | 같은 패키지 or 상속 받은 클래스|
| default or 아무것도 안 붙일 시 | 같은 패키지|
|private|해당 클래스 내부|

### 객체 만드는 방법(new 키워드 이해하기)
```java
class Init{
    private int number;
    
    public static void main(String[] args){
        Init init = new Init(); // 생성자가 없으면 기본 생성자를 자동으로 만든다
    }
}

class Init{
    private int number;
    
    public Init(int number){
        super();// 이것이 생략되어 있다
        this.number = number;
    }
    
    public static void main(String[] args){
        Init init = new Init(5); // new 를 통해서 인스턴스를 생성한다.
    }
}
```
### 메소드 정의하는 방법

```java
    접근_제한자 리턴_타입 메소드_명(타입){
    
        return 리턴_타입;
    } 
```
### 생성자 정의하는 방법

```java
class Init{
    private int num1;
    private int num2;
    private int num3;
    private int num4;
    public Init(){
        
    }
    public Init(int num1){
        ...
    }
    public Init(int num1,int num2){
        ...
    }
    public Init(int num1,int num2,int num3){
        ...
    } 
    
}    
```
### this 키워드 이해하기
* 참조 변수로 인스턴스 자신을 가리킬수 있다
  * 생성자, 메소드에서 자신의 변수를 접근할 수 있다
### 추가
1. import 없이 필드 명 꺼내기
```java
Field[] declaredFields = Class.forName("패키지경로.클래스명").getDeclaredFields();
```