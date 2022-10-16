# Map 관련 정리
* key-value 형태의 컬렉션
* value는 중복 저장될 수 있지만 key는 중복 불가

## Map 기본 메서드
| 기능    | 리턴                  | 메소드 명                       | 내용                                      |
|-------|---------------------|-----------------------------|-----------------------------------------|
| 객체 추가 | V                   | put(K key, V value)         | 주어진 키와 값을 추가, 저장되면 값을 리턴                |
| 객체 검색 | boolean             | containsKey(Object key)     | 주어진 키가 있는지 여부                           |
| 객체 검색 | boolean             | containsValue(Object value) | 주어진 값이 있는지 여부                           |
| 객체 검색 | Set<Map.Entry<K,V>> | entrySet()                  | 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set으로 리턴 |
| 객체 검색 | V                   | get(Object key)             | 주어진 키로 값을 리턴                            |
| 객체 검색 | Set<K>              | keySet()                    | 모든 키를 Set에 담아서 리턴                       |
| 객체 검색 | int                 | size()                      | 주어진 키의 총 수를 리턴                          |
| 객체 검색 | Collection<V>       | values()                    | 저장된 모든 값을 Collection에 담아서 리턴            |
| 객체 삭제 | void                | clear()                     | 모든 Map.Entry(키와 값)을 리턴                  |
| 객체 삭제 | V                   | remove(Object key)          | 주어진 키와 일치하는 Map.Entry를 삭제하고 값을 리턴       |

## Map 구현체
### HashMap

```java
Map<K,V> map = new HashMap<K,V>();
map.put("key","value");

```
#### 중복된 키인지 판단 순서
* hashCode가 같은지 판단
* hashCode가 다르다면 다른 객체로 판단 해서 저장
* hashCode가 같다면 equals로 판단
* equals가 true 라면 같은 키라 판단 - 저장 안함
* equals가 false 라면 다른 키라 판단 - 저장

### LinkedHashMap
* LinkedHashMap은은 삽입 순서대로 저장되지만 LinkedMap은 정렬되어 저장된다
* HashMap은 Create하는데 빠르지만 LinkedHashMap은 Iterator할 때 더 빠르다 
* 성능상 HashMap과 차이는 별로 없지만 순서를 유지하기 때문에 메모리 사용량이 더 높다.


### HashTable
* List의 Vector과 비슷하게 동기화된 메서드로 구성
* 하나의 스레드가 완료 되어야 다른 스레드가 실행할 수 있다.


### Properties
* HashTable의 하위 클래스이므로 특징을 가지고 있지만 key와 value는 String으로 제한
* 스프링의 *.properties 같은 파일의 내용을 가지고 올 때 사용

```java

import java.io.FileReader;
import java.net.URLEncoder;
import java.util.Properties;

class Init {
    public static void main(String[] args) {
        String path = A.class.getResource("Application.properties").getPath();
        path = URLEncoder.encode(path, "utf-8");// 경로의 한글 포함
        Properties properties = new Properties();
        properties.load(new FileReader(path));//파일을 properties에 넣기

        String value = properties.getProperty("key"); // key로 value 값 찾기
        System.out.println(value);
    }
}
```
### TreeMap

* 이진 트리 기반 Map 컬렉션이다.
* Integer 같은 숫자, String 같은 문자 타입이 아닌 엔티티에서 순서를 정의해야 된다면 Comparable의 compareTo() 메소드를 재정의 하면 된다.
* 검색에 관한 HashMap의 시간 복잡도 N(1), TreeMap의 시간 복잡도 N(logN)
  * HashMap이 무조건 좋아보이지만 키가 정렬되지 않는다.

#### 메소드들
* TreeSet과 리턴 값과 약간 메소드 명만 다르고 설명은 같다.


## 참고 자료
[도서 - 이것이 자바다]