# Item2. 생성자에 매개변수가 많다면 빌더를 고려하라

* 정적 팩터리와 생성자는 선택적 매개변수가 많을 때 적절한 대응을 하기 어렵다.
* 점층적 생성자 패턴도 쓸 수는 있지만, 매개변수 개수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.

## 점층적 생성자 패턴 - 확장하기 어렵다
* [생성자 클래스](https://github.com/jeonghyeonkwon/java-study/blob/main/src/main/java/com/jeonghyeon/javastudy/effectivejava/item2/NutritionFactsConstructor.java)
* 단점 
  * 파라미터가 많아지면 작성하거나 읽기 어렵다.

## 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (Setter 방식)
* [Setter 클래스](https://github.com/jeonghyeonkwon/java-study/blob/main/src/main/java/com/jeonghyeon/javastudy/effectivejava/item2/NutritionFactsSetter.java)
* 단점
  * 하나를 만들려면 여러개의 메소드를 호출해야 된다. 
  * 불변 객체로 만들 수 없다. 언제든 setter로 값 변경이 가능하기 때문에

## 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다.
* [Builder 클래스](https://github.com/jeonghyeonkwon/java-study/blob/main/src/main/java/com/jeonghyeon/javastudy/effectivejava/item2/NutritionFactsBuilder.java)
* 계층적으로 설계된 클래스와 함께 쓰이기 좋다.
* 단점
  * 객체를 만들려면, 그에 앞서 빌더부터 만들어야 한다.