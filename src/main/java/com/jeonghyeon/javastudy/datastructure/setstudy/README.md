# Set 관련 정리
* 삽입 순서를 보장하지 않으며, 중복을 허용하지 않는다.

## Set 기본 메소드
* List와 동일하나 인덱스로 검색 불가하므로 관련된 메소드는 없음

## Set 구현 클래스
### HashSet
* iterator로 돌면 오름차순으로 객체를 꺼낼수 있다
```java
Set<E> set = new HashSet<>();
set.add("내용");
```
### 중복 판단 순서
* hashCode가 같은지 판단
* hashCode가 다르다면 다른 객체로 판단 해서 저장
* hashCode가 같다면 equals로 판단
* equals가 true 라면 저장 안함
* equals가 false라면 저장

```java
import java.util.Objects;

class User {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
        // 판단할 핵심 필드를 판단하여 재정의 하면 됨
    }
}
```
### LinkedHashSet
* 삽입 순서를 보장하면서, 중복도 제거 해준다
```java
Set<E> linkedHashSet = new LinkedHashSet<>();
```
### TreeSet
* 검색 기능을 강화 시킨 Set 구현체
* 이진 트리 구조로 되어 있다.
* Integer 같은 숫자, String 같은 문자 타입이 아닌 엔티티에서 순서를 정의해야 된다면 Comparable의 compareTo() 메소드를 재정의 하면 된다.

|리턴 타입| 메소드 명        | 내용                                      |
|---|--------------|-----------------------------------------|
|E| first()      | 제일 낮은 객체                                |
|E| last()       | 제일 높은 객체                                |
|E| lower(E e)   | 파라미터 바로 밑 객체 리턴(return < E)             |
|E| higher(E e)  | 파라미터 바로 위 객체 리턴(E < return)             |
|E| floor(E e)   | 파라미터 값이 있다면 리턴 또는 바로 밑 객체 (target <= E) |
|E| ceiling(E e) | 파라미터 값이 있다면 리턴 또는 바로 위 객체 (E <= target) |
|E| pollFirst()  | 가장 낮은 객체 가져오고 그 객체 삭제                   |
|E| pollLast()   | 가장 높은 객체 가져오고 그 객체 삭제                   |

#### TreeSet 범위 검색 관련 메소드

|리턴| 메소드 명                                                                          | 내용                                                  |
|---|--------------------------------------------------------------------------------|-----------------------------------------------------|
|NavigableSet<E>| headSet(E toElement, boolean inclusive)                                        | 첫 번째 파라미터로 받은 타입을 기준으로 2번째 boolean 여부에 따라 낮은 객체를 리턴 |
|NavigableSet<E>| tail(E fromElement, boolean inclusive)                                         | 첫 번째 파라미터로 받은 타입을 기준으로 2번째 boolean 여부에 따라 높은 객체를 리턴 |
|NavigableSet<E>| subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) | 첫 번째 세 번째 파라미터 사이에 객체를 리턴 두 번째 네 번째 파라미터로 포함 여부 결정  |

#### TreeSet 정렬 관련 메소드
|리턴|메소드 명| 내용                         |
|---|---|----------------------------|
|Iterator<E>|descendingIterator()| 내림차순으로 정렬된 Iterator 반환     |
|NavigableSet<E>|descendingSet()| 내림차순으로 정렬된 NavigableSet 반환 |

* NavigableSet
  * TreeSet의 first(), last(), lower(), higher(), floor(), ceiling() 제공 + 정렬 순서 바꾸는 메소드 제공(descendingSet())
```java
NavigableSet<E> descendingSet = treeSet.descendingSet(); // 내림차순
NavigableSet<E> ascendingSet = treeSet.descendingSet().descendingSet()// 오름차순 = 정렬 메소드 2번 호출
```
## 참고 자료
[도서 - 이것이 자바다]