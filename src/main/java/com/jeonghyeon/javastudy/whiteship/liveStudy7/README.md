# 백기선님 자바 라이브 스터디 7일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* package 키워드
* import 키워드
* 클래스패스
* CLASSPATH 환경변수
* -classpath 옵션
* 접근지시자

### package 키워드

* 클래스를 구분하는 폴더
* 모두 소문자로 짓는것이 관례
* 숫자로 시작, 언더바('_'), $ 표시 사용 금지
* 예약어 사용 금지(int, static,...)
* FQCN(Fully Qualified Class Name)
  * 클래스 명만 아니라 패키지 경로를 포함해야 된다.


### import 키워드
* 다른 클래스를 사용하는 방법
* 방법 1 
```java
// 라이브러리의 클래스 명이 같은 경우 풀패키지 경로를 써줘야 한다.
class Init{
    public static void main(String[] args){
        com.jeonghyeon.javastudy.클래스_명 clazz = new com.jeonghyeon.javastudy.클래스_명; 
    }
}
```
* 방법 2
```java
import com.jeonghyeon.javastudy.*;

import com.jeonghyeon.javastudy.클래스_명;
```

#### static import
* 메소드나 변수를 패키지, 클래스 명 없이 접근가능하게 해준다.

```java
class Init {
    public static void main(String[] args) {
        double pi = Math.PI;
    }
}

```
#### 빌트 인 클래스
* 기본 import 없이 사용 가능(System, String)
```java
import java.lang.*;


```
### 클래스패스
* 클래스를 찾는 경로
1. 자바 컴파일러에 의해 class파일로 변환
   1. javac JavaClazz.java
2. JVM이 런타임 시 class 파일을 클래스 로더에 로딩하기 위해 경로를 알아야 됨. 그때 사용됨

* 지정하는 방법
  * CLASSPATH 환경변수
  * -classpath 옵션
### CLASSPATH 환경변수

* CLASSPATH=경로1;경로2
* 환경변수로 사용 할 수도 있지만(모든 애플리케이션이 실행할 때 똑같은 라이브러리를 써야됨, 버전이 안맞을 수도 있음) IDE, 빌드 도구를 통해 클래스패스를 설정

### -classpath 옵션
* -cp도 가능
  * javac -cp(-classpath) 참조할_클래스_디렉토리 컴파일할_자바_클래스.java  
* java, javac 두곳 다 옵션을 쓸 수 있다
### 접근지시자
| 접근 제한자                 |범위|
|------------------------|---|
| public                 |모든 패키지 다|
| protected              | 같은 패키지 or 상속 받은 클래스|
| default or 아무것도 안 붙일 시 | 같은 패키지|
|private|해당 클래스 내부|


### 추가
1. Constants 인터페이스
```java
public interface Constants{
    int NUMBER = 100;  // public static final 붙이는 것이랑 같다
    public static final int NUMER = 100;
    String NAME = "NAME";
    
    
}

// 안티패턴이라 쓰지 않는다

public class Init implements Constants{
    private static final String NAME = "NAME2";
    public static void main(String[] args){
        System.out.println(Init.NAME);
        // 이렇게 하면 NAME2가 뜬다
    }
}
```