# Queue 관련 정리
* 파이프라 생각 (선입 선출, FIFO)
* deque는 queue의 반대가 아닌 양쪽에서 양쪽에서 삽입 삭제 가능한 것이다.
  * Queue를 상속받은 것이다.

## 기본 메서드
|리턴| 메소드 명      | 설명                                   |
|---|------------|--------------------------------------|
|int|size()|크기 확인|
|boolean| offer(E e) | 객체 삽입                                |
|boolean| add(E e)   | 객체 삽입(다 차는 경우 에러)                    |
|E| peek()     | 맨 앞의 객체를 가져온다(가져온 객체 삭제 X)           |
|E| element()  | 맨 앞의 객체를 가져온다(가져온 객체 삭제 X, 없을 경우 에러) |
|E| pool()     | 맨 앞의 객체를 꺼낸다(가져온 객체 삭제 한다)           |
|E| remove()   | 맨 앞의 객체를 꺼낸다(가져온 객체 삭제 한다, 없을 경우 에러) |
|void| clear()   | 내부 모두 삭제 |




## 자주 사용하는 Queue 구현체
### LinkedList
* List의 구현체이기도 하지만 Queue 구현체이기도 하다

```java
Queue<String> queue = new LinkedList<>();

Deque<String> deque = new LinkedList<>();

```

### Priority Queue (우선 순위 큐)
* 우선 순위가 높은 순서로 나가게 한다.
* 값 비교를 위해 null 허용하지 않는다.

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();

PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
});

//이 처럼 생성자에 크기, 비교 등 으로 선언하고 삽입하면 된다. 
```

