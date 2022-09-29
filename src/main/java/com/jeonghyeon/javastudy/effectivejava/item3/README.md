# Item3. private 생성자나 열거 타입으로 싱글턴임을 보증하라
* 싱글턴 예
  * 객체나 설계상 유일해야 하는 시스템 컴포넌트
* 클래스를 싱글턴으로 만들면 테스트하기 어렵다.

* [싱글톤 생성 방법](https://github.com/jeonghyeonkwon/java-study/blob/main/src/main/java/com/jeonghyeon/javastudy/effectivejava/item3/SingletonField.java)
  1. 필드로 생성
     * 장점
       * 간결하다
  2. [팩토리 메소드로 생성](https://github.com/jeonghyeonkwon/java-study/blob/main/src/main/java/com/jeonghyeon/javastudy/effectivejava/item3/SingletonFactory.java)
     * 장점
       * api를 바꾸지 않고도 싱글턴이 아니게 변경 가능 하다.
       * 공급자(supplier) 사용 가능
         * 꺼낼때 get()으로 가능
  3. 열거 타입으로 생성
    * 아직 제대로 된 이해하지 못함... 나중에 다시 [이해 못함]
    * 장점
      * 직렬화된 인스턴스를 역직렬화할 때 마다 새로운 인스턴스가 만들어 진다. 그것을 방지 하기 위해 사용
    * 단점
      * 상속은 불가(열거 타입이 다른 인터페이스를 구현하도록 선언은 할수 있다)
  