# Item6. 불필요한 객체 생성을 피하라

* 똑같은 객체를 생성하기 보다 객체 하나를 재사용하는 편이 나을 때가 많다

```java
class Init{
    
    public static void main(String[] args){
        String str = new String("string1");
        //이 코드를 실행할 때 마다 새로운 인스턴스가 생성된다.

        //개선된 버전
        String str2 = "string2";
        
        boolean bool = new Boolean(false);// 방식은 자바 9부터 사용 자제되었다
        
        // 이 방식 사용
        Boolean bool2 = Boolean.valueOf(false);    
    }
    
}
```
* 정규 표현식 성능 관련

```java
import java.util.regex.Pattern;

public class MatcherClass {
    static boolean isRomanNumeral(String s) {
        return s.matches("정규 표현식");

    }
    /*
     * 가장 쉬운 방법이지만 반복해야 되는 상황이라면 적합하지 않음
     * Pattern 인스턴스는 한 번 쓰고 사라지기 때문에
     * */
}

public class MatcherClass2 {
    private static final Pattern ROMAN = Pattern.compile("정규 표현식");
    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
    /*
     * 한번도 호출하지 않는 다면 쓸데없이 초기화 된 꼴이다.
     * 코드를 복잡하게 만드는데 성능은 크게 개선되지 않을 때가 많기 때문이다.
     * */
}

```

* 오토 박싱 관련
```java
class Init{
    private static long sum(){
        Long sum = 0L;
        
        for(long i = 0; i<= Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;
    }
    /*
     * 박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토 박싱이 숨어 들지 않도록 주의하자
     * Long을 long으로 바꿔주면 6.3초에서 0.59로 빨라진다.
     * */
}


```

