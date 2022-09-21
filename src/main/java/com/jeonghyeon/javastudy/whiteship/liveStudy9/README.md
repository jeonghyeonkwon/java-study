# 백기선님 자바 라이브 스터디 9일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
* 자바가 제공하는 예외 계층 구조
* Exception과 Error의 차이는?
* RuntimeException과 RE가 아닌 것의 차이는?
* 커스텀한 예외 만드는 방법

## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
```java
class Init{
    public static void main(String[] args){
        try{
            // 예외가 발생 할 것 같은 코드 
        }catch (Exception e){
            // 예외 발생시 실행 될 부분
        }finally {
            // 정상적 실행 OR 예외 처리 이후 실행될 부분
            // ex : DB 커넥션 종료
        }
        
        // 예외 발생 시키기
        throw new RuntimeException("예외 발생");
    
    }
    
    // 다른 곳에서 예외를 처리해라 
    public int methodA(String b) throws Exception{
        
    }
}
```

* catch에도 계층이 있다.

```java



class Init {
    public static void main(String[] args) {
        try {
            
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException은 RuntimeException을 상속 받은 클래스이다
            // 자바 7 이상 부터는 multi catch도 가능
            // catch (다른 exception | IllegalArgumentException e)
            // 상속 관계는 안됨
        } catch (RuntimeException e) {
            e.printStackTrace();
            
        }
    }


}
```
### Try-with-resources (java 7 이상 부터)
* 자동으로 자원을 해제
* 무조건 자원을 해제 해주는 것이 아닌 내부에 AutoCloseable 인터페이스를 구현한 객체여야 한다
```java
public interface AutoCloseable{
    void close() throws Exception;
}
```
* try-catch-finally

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class Init {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream("file.txt");
            bis = new BufferedInputStream(fis);
            // ... 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 이것도 문제가 많다 close()도 예외가 발생하기 때문에 try로 감싸고 해야 된다...
            if (fis == null) fis.close();
            if (bis == null) bis.close();
        }
    }
}
```

* try-with-resource

```java
import java.io.BufferedInputStream;
import java.io.FileInputStream;

class Init {
    public static void main(String[] args) {
        try (
            FileInputStream fis = new FileInputStream("file.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
        ) {
            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 자바가 제공하는 예외 계층 구조
* 모든 클래스의 조상은 Object이다. Object의 Throwable로 부터 Excpeiton과 Error로 나눠 진다.
* Throwable
  * 모든 예외와 에러의 상위 클래스
  * getMessage, printStackTrace, ... 가 구현되어져 있다
* Exception 내부의 RuntimeException(Unchecked Exception)과 RuntimeException을 상속 받은예외, 나머지 예외 2가지로 나눠진다.

## Exception과 Error의 차이는?
* Exception
  * 예외는 발생하더라도 적절한 조치를 취하면 비정상 적인 종료가 발생하지 않는다
* Error
  * 회복 불가능 
  * 컴파일 에러
    * IDE에 의해 잡아 줄 수 있다.
    * 문법 오류
  * 런타임 에러
    * OutOfMemory
    * 시스템 충돌 오류

## RuntimeException과 RE가 아닌 것의 차이는?
* RuntimeException
  * UnChecked Exception 
    * 컴파일 시 체크 하지 않음
  * 코드로 어떻게 할 수 없는 경우
  * 예
    * NullPointerException
    * IllegalStateException
    * ...
* RuntimeException이 아닌 것
  * Checked Exception 
    * 컴파일 시 체크 
    * 반드시 에러에 관련된 처리를 해줘야 됨
  * 코드로 어떻게 조작할 수 있는 것(새로운 것으로 교체 하거나)
  * 예
    * IOException
    * SQLException
    * ...
## 커스텀한 예외 만드는 방법
[검증 에러 만든 것](https://github.com/jeonghyeonkwon/protfolio-blog/blob/main/back-end/src/main/java/com/jeonghyeon/blog/exhandler/CustomValidationException.java)

* 예외는 이렇게 만들어야 된다.
```java
public class YummiException extends RuntimeException{
    //최초의 예외가 발생했을 때
    public YummiException(String message){
        super(message);
    }
    // 다른 예외발생 했고 바꿔서 보내고 싶을 때 
    public YummiException(String message, Throwable cause){
        super(message,cause);
    }
}
```

### 추가
* 예외 처리 비용은 비싸다
  * stackTrace에 정보를 메모리에 담고 있어야 된다.  
  * return 타입이나 입력값으로 처리하는게 낫다.
