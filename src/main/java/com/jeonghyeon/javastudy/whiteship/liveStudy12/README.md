# 백기선님 자바 라이브 스터디 12일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 애노테이션 정의하는 방법
* @retention
* @target
* @documented
* 애노테이션 프로세서


### 애노테이션 정의하는 방법
* 애노테이션 기능
  * 컴파일러에게 코드 문법 에러를 체크하도록 정보 제공
  * 개발 툴이 빌드나 배치 시 코드를 자동으로 생성할 수 있도록 정보를 제공
  * 런타임시 특정 기능을 생성하도록 정보 제공

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Taget({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AAnnotation {
  String value() default "&";

  int number() default 14;
}

public class Service {
  @AAnnotation(value = "@", number = 12)
  method() {
    System.out.println("실행");
  }
}

class Main {
  public static void main(String[] args) {
    Method[] declaredMethods = Service.class.getDeclaredMethods();
    for (Method method : declaredMethods) {
      AAnnotation annotation = method.getAnnotation(AAnnotation.class);
      System.out.println(annotation.number());
      System.out.println(annotation.value());
    }
  }
}

```

### @retention
* 어노테이션 유지 정책 정하는 것
  * 언제까지 정보를 남길 것인지

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationClass {

}
```

| enum    | 내용                                                                                              |
|---------|-------------------------------------------------------------------------------------------------|
| SOURCE  | 소스 상에서만 어네테이션 정보 유지, 소스 코드 분석할 때만 의미 있음, 바이트 코드에는 정보를 남기지 않음, 컴파일 이후에는 쓰지 않겠다. 진짜 주석, @Override |
| CLASS   | 바이트 코드 파일 안에 어노테이션 정보 유지, 런타임 시 클래스의 메타 정보 읽을 수 없음                                        |
| RUNTIME | 바이트 코드 파일 안에 어노테이션 정보 유지, 런타임 시 에도 클래스 파일의 메타 정보 얻기 가능                                          |

### @target
* 어노테이션 적용 대상 정하는 것

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationClass {

}
```
| enum            | 적용 대상                  |
|-----------------|------------------------|
| TYPE            | class, interface, enum |
| ANNOTATION_TYPE | 어노테이션                  |
| FIELD           | 필드                     |
| CONSTRUCTOR     | 생성자                    |
| METHOD          | 메소드                    |
| LOCAL_VARIABLE  | 지역 변수                  |
| PACKAGE         | 패키지                    |
| PARAMETER       | 파라미터로 주입               |
### @documented
* 자바doc를 만들 때 사용
* 문서에 어노테이션에 대한 정보를 남길 수 있다.

### 애노테이션 프로세서
* 롬복 처럼 @Data 붙어주는 것 만으로도 메소드를 만들어 주는 것

* ServiceLoader
  * 인터페이스를 정의한 것의 서로 다른 구현체(jar)를 가져오는 것
  

### 애노테이션 만드신 분 참고 자료
* https://catch-me-java.tistory.com/49
### 스프링에서 어노테이션 활용
* 시큐리티에서 세션에 로그인한 유저 객체 쉽게 가져오기

어노테이션
```java
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    // 리턴값이 true 일 밑에 resolveArgument가 실행 된다.
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LogginUser.class) != null;
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return null;
    }
}

```
Config 등록
```java
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
  private final LoginUserArgumentResolver loginUserArgumentResolver;
  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(loginUserArgumentResolver);
  }
}

```