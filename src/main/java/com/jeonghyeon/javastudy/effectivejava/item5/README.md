# Item5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라
* 많은 클래스가 하나 이상의 자원에 의존한다.

* 정적 클래스 잘못 사용 예 - 유연하지 않고 테스트하기 어렵다
```java
public class SpellChecker{
    private static final Lexicon dictionary = ...;
    
    private SellChecker(){}
    
}
```

* 싱글턴 잘못 사용 예 - 유연하지 않고 테스트하기 어렵다
```java
public class SpellChecker{
    private final Lexicon dictionary = ...;
    
    private SellChecker(...){}
    public static SpellChecker INSTANCE = new SpellChecker(...);
    
}
```

* 테스트 용 클래스도 의존 받는 상황이 있다면 적합한 방법은 인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식이 좋다

```java
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
}
```