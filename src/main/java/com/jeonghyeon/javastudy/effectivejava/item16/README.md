# Item16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라

* public 필드 사용 보다 getter, setter을 사용해라
* package-private 클래스 혹은 pivate 중첩 클래스라면 데이터 필드를 노출한다 해도 하등 문제는 없다
* public 필드로 설계된 대표적인 예
  * java.awt.package의 Point, Dimension