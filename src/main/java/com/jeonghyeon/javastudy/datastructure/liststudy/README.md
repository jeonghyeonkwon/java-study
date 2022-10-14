# List 관련 정리
## List의 기본 메소드
| 리턴              | 메소드 명                                        | 설명                                                                                                                           |
|-----------------|----------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| int             | size()                                       | list의 사이즈                                                                                                                    |
| boolean         | isEmpty()                                    | list의 사이즈가 0인지? (리스트에 아무 값도 없는지)                                                                                             |
| boolean         | contains(Object o)                           | 파라미터로 받은 객체가 포함되어 있는지?                                                                                                       |
| Iterator<E>     | iterator()                                   | List를 Iterator로 변환                                                                                                           |
| Object[]        | toArray()                                    | List를 배열로 변경 (Object 배열로)                                                                                                    |
| T[]             | toArray(T[] a)                               | 배열로 리턴하지만 크기를 파라미터로 넣은 크기 만큼으로 바꿔서 리턴한다. 리스트 현재 사이즈 보다 작다면 현재 리스트 사이즈, 크다면 배열로 할당한 크기만큼 할당하여 배열을 리턴 (ListController test1()) |
| boolean         | remove(Object o)                             | 파라미터로 받은 객체 삭제 (있다면 true 없다면 false) (ListController test2())                                                                 |
| boolean         | containsAll(Collection<?> c)                 | 파라미터로 받은 컬렉션 타입이 모두 포함 되어 있는지 순서 상관 없음 (ListController test3())                                                              |
| boolean         | addAll(Collection<? extends E> c)            | 컬렉션 타입의 객체들을 추가                                                                                                              |
| boolean         | addAll(int index, Collection<? extends E> c) | index 부터 컬렉션 타입의 객체들을 추가                                                                                                     |
| boolean         | removeAll(Collection<?> c)                   | 파라미터로 받은 컬렉션 타입의 객체를 지울떄 사용                                                                                                  |
| boolean         | retainAll(Collection<?> c)                   | 파라미터로 받은 컬렉션과 교집합을 이루어 없는 것들을 지울때 사용                                                                                         |
| void            | clear()                                      | 리스트의 모든 값을 제거                                                                                                                |
| E               | get(int index)                               | index번째 객체 값 보기(꺼내기 아님)                                                                                                      |
| E               | set(int index, E element)                    | index번째에 객체를 대체한다(index번째 데이터 사라짐)                                                                                           |
| boolean         | add(E e)                                     | 제네릭 타입으로 정한 타입 객체 추가 하기                                                                                                      |
| void            | add(int index, E element)                    | index번째에 객체를 추가한다(뒤로 밀림)                                                                                                     |
| E               | remove(int index)                            | index번째 데이터가 삭제된다.                                                                                                           |
| int             | indexOf(Object o)                            | 파라미터로 받은 데이터가 몇번째 index인지 반환                                                                                                 |
| int             | lastIndexOf(Object o)                        | indexOf의 반대로 뒤에서 부터 찾아 인덱스를 반환(중복되는 값이 있을수도 있으니...)                                                                          |
| ListIterator<E> | listIterator()                               | listIterator로 반환(iterator을 확장한 것으로 양방향으로 탐색 지원)                                                                              |
| ListIterator<E> | listIterator(int index)                      | index를 시작점으로 listIterator로 반환(iterator을 확장한 것으로 양방향으로 탐색 지원)                                                                 |
| List<E>         | subList(int fromIndex, int toIndex)          | fromIndex 부터 toIndex까지 리스트를 잘라서 반환                                                                                           | 
## 리스트 구현 클래스

### ArrayList<E>
```java

List<E> list = new ArrayList<E>();
list.add("내용1");
list.remove()
// 이렇게 작성하면 찾아올때 형변환이 계속 일어나므로 단일 종류의 객체로 하는것이 좋다.
```
* ArrayList는 특정 인덱스의 객체를 추가,삭제할 때 마다 바로 그 뒤의 객체가 1씩 뒤로 앞으로 당겨진다.
* 인덱스 검색과 맨 마지막에 객체를 추가할 시 더 좋은 성능을 발휘할 수 있다.
* 삽입과 삭제가 자주 일어난다면 사용하는 것이 바람직하지 않다.
### LinkedList<E>
```java
List<E> list = new LinkedList<>();
```
* ArrayList(내부 배열로 객체 리스트 관리)와 달리 LinkedList는 인접 참조를 연결해서 양방향으로 관리
#### ArrayList VS LinkedList
* 검색, 순차적 삽입 삭제
  * ArrayList > LinkedList
* 중간 삽입, 삭제
  * ArrayList < LinkedList
### Vector<E>
```java
List<E> vector = new Vector<E>();

```
* ArrayList와 동일한 구조를 가지고 있다.
  * 차이점
    * 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드를 실행 불가. 하나의 메소드가 실행 완료해야만 다른 스레드가 실행 가능
    * 즉 멀티 스레드 환경에서 안전하게 객체 추가 삭제 가능
    
