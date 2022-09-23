# 백기선님 자바 라이브 스터디 10일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* enum 정의하는 방법
* enum이 제공하는 메소드 (values()와 valueOf())
* java.lang.Enum
* EnumSet


### enum 정의하는 방법

```java
public enum User {
    BASIC, SELLER, ADMIN;
}

public class Init {
    public static void main(String[] args) {
        User user = User.ADMIN;
        /*
         * User : Method 영역
         * ADMIN : Heap 영역
         * user : Stack 영역
         */
    }
}
```

### enum이 제공하는 메소드 (values()와 valueOf())
* 메소드

|리턴 타입|메소드| 내용                                                             |
|---|---|----------------------------------------------------------------|
|String|name()| 열거 객체를 문자열로 리턴                                                 |
|int|oridinal()| 열거 객체의 순번(0부터 시작) - JPA @Enumerated 기본 값, 중간에 추가 할 수 있으므로 사용 X |
|int|compareTo()| 열거 객체를 비교해서 순번 차이를 리턴                                          |
|열거 타입|valueOf(String name)| 주어진 문자열 열거 객체로 리턴                                              |
|열거 타입 리스트|values()| 모든 열거 객체들을 배열로 리턴                                              |

### java.lang.Enum
* 모든 enum Class는 제목의 Enum클래스를 상속 받아 구현되어져 있다
  * 다른 클래스를 상속 받을 수 없다
* 고정된 상수 값이므로 값을 바꿀 수 없다.

### EnumSet
* Enum의 값을 Set으로 저장 리턴 받고 싶을 때 사용

```java
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

public enum User {
    BASIC, SELLER, ADMIN;
}

public class Init {
    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(User.BASIC);
        users.add(User.SELLER);
        users.add(User.ADMIN);

        //을 한줄로
        EnumSet<User> users = EnumSet.allOf(User.class);
    }
}
```

### 타입 세이프티
* 문자열로 작성하면 한 글자를 잘못써서 에러가 발생하는 경우가 있다. 컴파일 시점에서 오류를 해결할 수 있게 해주는 것