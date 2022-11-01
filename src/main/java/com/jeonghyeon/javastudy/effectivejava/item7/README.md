# Item7. 다 쓴 객체를 해제하라
* 자바는 가비지 컬렉터가 알아서 처리해 주지만 신경쓰지 않아도 된다는 말이 아니다.

```java
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /*
     *  문제점
     * 아직 배열은 활성 영역이라 가비지 컬렉터가 지우지 않는다
     *  */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /*
     * 문제점 개선
     * */
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }


    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```
* 위 코드 처럼 null로 처리하는 일은 예외적인 경우여야 한다.
  * 가장 좋은 방법은 변수를 scope 범위 밖으로 밀어 내는 것이다.
  * 자기 메모리를 직접 관리하는 클래스라면 항상 메모리 누수에 주의해야 한다.
* 캐시 역시 메모리 누수를 일으키는 주범이다.
  * 아직 제대로 이해하지 못함... 나중에 다시 [이해 못함]
* 리스터 혹은 콜백이라 부르는 것도 메모리 누수의 원인중 하나다
  * 아직 제대로 이해하지 못함... 나중에 다시 [이해 못함]