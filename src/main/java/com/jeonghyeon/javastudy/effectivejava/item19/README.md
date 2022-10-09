# Item18. 상속을 고려해 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라
* 상속용 클래스는 재정의할 수 있는 메서드들을 내부적으로 어떻게 이용하는지 문서로 남겨야 한다.
  * 클래스의 API로 공개된 메서드에서 클래스 자신의 또 다른 메서드를 호출할 수도 있다.
  * 그런데 그 호출되는 메서드가 재정의 가능 메서드라면 그 사실을 호출하는 메서드의 API 설명을 적시해야 한다.
  * 추가로 어떤 순서로 호출하는지, 각각의 호출 결과가 이어지는 처리에 어떤 영향을 주는지도 담아야 한다.
  
* Api 문서의 메서드 설명 끝에 "Implementation Requirements"로 시작하는 절은 그 메서드의 내부 동작 방식을 설명하는 곳
  * @implSpec 태그를 붙여주면 자바독 도구가 생성해준다.

* 상속용으로 설계한 클래스는 배포 전에 반드시 하위 클래스를 만들어 검증해야 한다.
* 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안된다.

```java
import java.time.Instant;

public class Super {
  // 잘못된 예 - 생성자가 재정의 가능 메서드를 호출한다.
  public Super() {
    overrideMe();
  }
  
  public void overrideMe(){
      
  }
}

public final class Sub extends Super {
  // 초기화되지 않은 final 필드. 생성자에서 초기화한다.
  private final Instant instant;

  Sub() {
    instant = Instant.now();
  }
  
  // 재정의 기능 메서드. 상위 클래스의 생성자가 호출한다.
  @Override
  public void overrideMe(){
    System.out.println(instant);
  }
  
  public static void main(String[] args){
      Sub sub = new Sub();
      sub.overrideMe();
      /*
       * 첫 번째는 null을 출력
       * 상위 클래스의 생성자는 하위 클래스의 생성자가 인스턴스 필드를 초기화하기도 전에
       * overrideMe를 호출하기 때문이다.
       * overrideMe에서 instant객체의 메서드를 호출하려 한다면 상위 클래스의 생성자가 overrideMe
       * 를 호출할 때 NullPointerException을 던진다
       * */
  }
}


```

* clone과 readObject 메서드는 생성자와 비슷한 효과를 낸다 (새로운 객체를 만든다)
  * 상속용 클래스에서 Clonable이나 Serializable을 구현할지 정해야 한다면, 이들을 구현할 때 따르는 제약도 생성자와 비슷하다는 점에 주의하자
  * 즉 clone과 readObject 모두 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안 된다.

### 요약

* 상속을 금지하려면 클래스를 final로 선언하거나 생성자 모두를 외부에서 접근할 수 없도록 만들면 된다.
