# Item13. clone 재정의는 주의해서 진행하라

* clone 메서드가 선언된 곳이 Cloneable이 아닌 Object이고 protected이다

### Cloneable 인터페이스
* Object의 protected 메서드인 clone의 동작 방식을 결정한다.
* clone메소드 재정의는 final 인스턴스 배열 말고는 권하지 않는
* 복사 생성자, 복사 팩터리, 직접 객체 생성 하기가 깊은 복사의 최선의 선택이다.
* 아직 제대로 이해하지 못함... 나중에 다시 [이해 못함]