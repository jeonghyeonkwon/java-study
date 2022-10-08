# Item17. 변경 가능성을 최소화하라

* 상속은 코드를 재사용하는 강력한 수단이지만, 항상 최선은 아니다
* 일반적인 구체 클래스를 패키지 경계를 넘어, 즉 다른 패키지의 구체 클래스를 상속하는 일은 위험하다.
  * 여기서 말하는 상속은 클래스가 다른 클래를 확장하는 구현 상속

### 메소드 호출과 달리 상속은 캡슐화를 깨뜨린다.
* 상위 클래스가 어떻게 구현되느냐에 따라 하위 클래스의 동작에 이상이 생길 수 있다.
  * 상위 클래스는 배포때마다 내부 구현이 달라질 수 있으며, 바뀌지 않은 하위 클래스가 오작동 할 수도 있다.
  * 잘못된 예

```java
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

class Init {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱","탁탁","펑"));
        System.out.println(s.getAddCount());
        /*
         * 3이 아닌 6이 호출됨
         * addAll로 3개 추가 후 HashSet의 add의 내부 메서드 호출로 재정의된 add가 다시 호출됨 
         * */
    }
}
```

### 컴포지션 방식
* 새로운 클래스를 만들고 private 필드로 기존 클래스의 인스턴스를 참조한다
* 기존 클래스가 새로운 클래스의 구성요소로 쓰인다는 뜻에서 이러한 설계를 컴포지션이라 한다.
```java
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ForwardingSet <E> implements Set<E> {
  private final Set<E> s;
  public ForwardingSet(Set<E> s){
    this.s = s;
  }
  @Override
  public int size() {
    return s.size();
  }

  @Override
  public boolean isEmpty() {
    return s.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return s.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return s.iterator();
  }

  @Override
  public Object[] toArray() {
    return s.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return s.toArray(a);
  }

  @Override
  public boolean add(E e) {
    return s.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return s.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return s.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return s.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return s.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return s.removeAll(c);
  }

  @Override
  public void clear() {
    s.clear();
  }
}
```

```java
import com.jeonghyeon.javastudy.effectivejava.item18.InstrumentedHashSet;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet<E> extends ForwardingSet<E> {
  private int addCount = 0;

  public InstrumentedSet(Set<E> s) {
    super(s);
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}

class Init {
  public static void main(String[] args) {
    Set<Instant> times = new InstrumentedSet<>(new TreeSet<>(cmp));
    Set<E> s = new InstrumentedHashSet<>(new HashSet<>(INIT_CAPACITY));
  }
}
```

* 다른 Set 인스턴스를 감싸고 있다는 뜻에서 InstrumentedSet 같은 클래스를 래퍼 클래스라고 한다.
  * 다른 Set에 계측 기능을 덧씌운다는 뜻에서 데코레이터 패턴이라고 한다.

### 래퍼 클래스의 단 한가지 단점
* 래퍼 클래스가 콜백 프레임워크와는 어울리지 않는다 
  * 콜백 프레임워크에서는 자기 자신의 참조를 다른 객체에 넘겨서 다음 콜백 때 사용하도록 한다.
  * 내부 객체는 자신을 감싸고 있는 래퍼의 존재를 모르니 대신 자신의 참조를 넘기고, 콜백 때는 래퍼가 아닌 내부 객체를 호출하게 된다.

### 상속
* 상속은 반드시 하위 클래스가 상위 클래스의 '진짜' 하위 타입인 상황에서만 쓰여야 한다.

### 요약
* 상속의 취약점을 피하려면 상속 대신 컴포지션과 전달을 사용하자
* 래프 클래스로 구현할 적당한 인터페이스가 있다면 더욱 그렇다.
* 래퍼 클래스는 하위 클래스보다 견고하고 강력하다
