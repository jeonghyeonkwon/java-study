# 백기선님 자바 라이브 스터디 8일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 인터페이스 정의하는 방법 
* 인터페이스 구현하는 방법 
* 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법 
* 인터페이스 상속 
* 인터페이스의 기본 메소드 (Default Method), 자바 8 
* 인터페이스의 static 메소드, 자바 8 
* 인터페이스의 private 메소드, 자바 9

### 인터페이스
* 추상 메서드의 집합
* 구현된 것 없는 설계도 껍데기 (default 메소드를 이용하면 기본 메소드 구조를 만들 수 있다)

### 인터페이스 정의하는 방법
```java
interface Weapon{
    public void attack(int damage);
}
```
### 인터페이스 구현하는 방법
```java
class Knife implements Weapon{
    @Override
    public void attack(int damage){
        //...
    }
}
```
### 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
* 인터페이스 변수_명 = (인터페이스명[생략 가능]) new 상속클래스();

```java
interface Weapon{
  public void attack(int damage);
}
class Knife implements Weapon{
  @Override
  public void attack(int damage){
    //...
  }
}
class Main{
    
    public static void main(String [] args){
        Weapon weapon = new Knife();
    }
}

```
### 인터페이스 상속
* 클래스 상속은 오직 하나만 가능하지만 인터페이스는 다중 상속이 가능하다
* 인터페이스는 인터페이스만 상속이 가능하다

### 인터페이스의 기본 메소드 (Default Method), 자바 8
* default method
  * 인터페이스의 여러 메소드 중 구현 클래스가 구현할 필요 없는 메소드 (기본적 구현되어 있으면 안에 로직을 짤 필요 없다.)
  * 재정의 가능
* interface <- abstract(추상) 클래스 <- 상속 받은 클래스들

* 자바 8 이상
```java
interface Weapon{
    public default void attack(int damage){
        System.out.println("공격");
        //...
    }
}
```
#### 추가
```java
public interface JoinMember {
  default void preJoin(){
    System.out.println("pre join member");
  }

  default void afterJoin(){
    System.out.println("after join member");
  }
}
public interface JoinGroup {
    default void preJoin(){
      System.out.println("pre join group");
    }
    
    default void afterJoin(){
      System.out.println("after join group");
    }
}

public class HelloJoinMember implements JoinMember, JoinGroup{
    // 두 인터페이스가 똑같은 메소드명을 가진 default method를 가질 경우 재정의를 하던 한 인터페이스를 가지고 와서 쓰면 됨
    @Override
    public void preJoin(){
        System.out.println("Pre Join Hello member");
    }
    
    @Override
    public void afterJoin(){
        JoinMember.super.afterJoin();
    }
}
```
### 인터페이스의 static 메소드, 자바 8
* 자바 8 이상 부터는 static 메소드도 사용 가능
* 재정의 불가능
```java
interface Weapon {
    static int attack(int damage) {
        System.out.println("공격");
        //...
    }
}

class Main implements Weapon{
    public static main(String[] args){
        Weapon.attack(10);
    }
}
```
### 인터페이스의 private 메소드, 자바 9

* 기본이 public 이다 보니 외부로 노출하기 꺼리는 메소드 존재 그 때 사용(자바 9 이상)

