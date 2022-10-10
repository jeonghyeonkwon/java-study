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

## ArrayList<E>

## LinkedList<E>

## Vector<E>

##Stack<E>