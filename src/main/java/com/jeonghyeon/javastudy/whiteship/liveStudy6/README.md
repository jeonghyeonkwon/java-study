# 백기선님 자바 라이브 스터디 5일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 자바 상속의 특징
* super 클래스
* 메소드 오버라이딩
* 다이나믹 메소드 디스패치
* 추상 클래스
* final 키워드
* Object 클래스

### 자바 상속의 특징
* 다중 상속 안됨
  * extends 뒤에 하나의 클래스만
  * 상속의 상속은 됨
```java
class Parent{
    
}

class Children extends Parent{
    
}


```
### super 클래스
* 부모 클래스의 생성자를 호출하는 메소드
```java
class Parent{
    private String title;
    
    public Parent(String title){
        this.title = title;
    }
}

class Children extends Parent{
    public Children(String title){
        super(title);
    }
}
```
```java
class Parent{
    public void print(String message){
        
    }
}

class Children extends Parent{
    @Override
    public void print(String message){
        super.print(message);
    }
}
```
### 메소드 오버라이딩
* 상속 받은 클래스를 재정의 하는 것
  * 리턴 값, 메소드명, 파라미터 모두 같아야 됨

### 다이나믹 메소드 디스패치
* 컴파일때는 어떤 메서드가 실행 될 지 모르고 런타임시 어떤 메서드가 실행되는지 결정되는 것
* 관련 내용 
  * https://www.youtube.com/watch?v=s-tXAHub6vg
### 추상 클래스
* 대상
  * 클래스
    * 클래스 내에 추상 메서드가 있을 때 선언 해줘야 됨
  * 메서드
    * 구현부를 작성하지 않은 추상 메서드임을 선언
  
```java
abstract class AbstractCl{
    int number;
    
    AbstractCl(){
        this.number = 10;
    }
    
    abstract void print();
}
```
### final 키워드
* 대상
  * 클래스
    * 더 이상 확장할 수 없는 클래스
      * 다른 클래스가 상속 받을수 없다
  * 메서드
    * 오버라이딩을 통해 재정의 불가
  * 멤버 변수, 지역 변수
    * 변경할 수 없는 상수가 됨 그러므로, 초기값을 넣어 줘야 됨
    
### Object 클래스
* 최상위 클래스 ( 모든 클래스는 Object 클래스를 상속 받은 것이다.)

