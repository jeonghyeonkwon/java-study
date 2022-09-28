# Item1. 생성자 대신 정적 팩터리 메서드를 고려하라.

* public 생성자 말고도 정적 팩터리 메서드도 있다.
* 팩터리 메서드가 생성자보다 좋은 장점
  1. 이름을 정할 수 있다
```java
public enum UserRole {
  BASIC, ADMIN, SELLER
}

public class User {
  private String userName;
  private Integer age;
  private UserRole userRole;

  public User(String userName, Integer age,UserRole userRole){
    this.userName = userName;
    this.age = age;
    this.userRole = userRole;
  }

  public static User ofBasic(String userName,Integer age){
    User user = new User(userName,age,UserRole.BASIC);

    return user;
  }
  public static User ofAdmin(String userName,Integer age){
    User user = new User(userName,age,UserRole.ADMIN);
    return user;
  }
}

```
  2. 호출 될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    * 새로운 인스턴스를 생성하는 것이 아닌 기존에 생성해 놓은 객체를 꺼내서 사용한다.
```java
class User{
  private static final User USER = new USER();

  public static User getUser(){
    return USER;
  }    
}

class Init{
    public static void main(String[] args){
        USER.getUser();
    }    
}

```
  3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.
```java
public interface Parent {
     void methodA();

}


public class ChildClass implements Parent {
  private String str = "자식";
  @Override
  public void methodA() {
    System.out.println("자식A");
  }

  @Override
  public String toString() {
    return "ChildClass{" +
            "str='" + str + '\'' +
            '}';
  }
}
public interface ChildInter {
  static Parent child(){
    return new ChildClass();
  }
}

```
  4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
```java
public interface ChildInter {
  static Parent child(boolean flag){
    return flag ? new ChildClass1() : new ChildClass2();
  }
}
```
  5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

* 팩터리 메서드가 생성자보다 좋은 단점
  * 상속을 하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
  * 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.

* 자주 사용하는 메서드 명 방식
  * from
    * 파라미터 하나 받아서 해당 타입의 인스턴스를 반환
  * of
    * 여러 파라미터를 받아 적합한 타입의 인스턴스 반환하는 집계 메서드
  * valueOf
    * from 과 of의 더 자세한 버전
  * instance OR getInstance
    * 파라미터를 받는다면 명시된 인스턴스를 리턴 하지만, 같은 인스턴스임을 확실히 보장하지 않는다.
  * create OR newInstance
    * 매번 새로운 인스턴스를 생성해 반환함을 보장
  * getType
    * getInstance 와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다.
  * newType
    * newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다.
  * type
    * getType과 newType의 간결한 버전