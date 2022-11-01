₩₩# 백기선님 자바 라이브 스터디 4일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 선택문
* 반복문

## 과제 (옵션)
1. JUnit5 학습 하세요
2. live-study 대시 보드를 만드는 코드를 작성하세요
3. LinkedList를 구현하세요
   1. LinkedList에 대해 공부하세요
   2. 정수를 저장하는 ListNode클래스를 구현하세요
   3. ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요
   4. ListNode remove(ListNode head, int positionToRemove)를 구현하세요
   5. boolean contains(ListNode head, ListNode nodeToCheck)를 구현하세요
4. Stack를 구현하세요
   1. int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
   2. void push(int data)를 구현하세요.
   3. int pop()을 구현하세요.
5. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요
   1. ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
   2. void push(int data)를 구현하세요.
   3. int pop()을 구현하세요.
6. Queue를 구현하세요
   1. 배열을 사용해서 한번
   2. ListNode를 사용해서 한번.

### 선택문
   * if문
   * switch/case 문

### 반복문
   * for문
   * while문
   * do-while문
     * 무조건 한번 실행 후(do) 조건을 탄다 (while) 
   * 향상된 for문

### 과제
* 자료구조 좀더 공부 후 추가 예정... 
### 추가
1. Queue의 메소드 차이
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueSample {
   public static void main(String[] args) {
      Queue<Integer> queue = new LinkedList<>();

      boolean offer = queue.offer(1); // 사이즈 때문에 못들어 가면 false
      boolean add = queue.add(1); // 사이즈 때문에 못들어 가면 예외

      queue.poll(); // 아무것도 없는데 꺼내면 null
      queue.remove(); // 아무것도 없는데 꺼내면 예외

      queue.peek(); // 아무것도 없는데 값을 보면(꺼내지 않음) null
      queue.element(); // 아무것도 없는데 보면(꺼내지 않음) 예외
   }
}

```
2. 테스트 코드 상태 유지

```java

// default 는 PER_METHOD이다
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//순서도 주고 싶다면
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StateFulTest {

   private int number;

   @Test
   @Order(1)
   void test1() {
      System.out.println(number++);
   }

   @Test
   @Order(1)
   void test2() {
      System.out.println(number++);
   }
}
```