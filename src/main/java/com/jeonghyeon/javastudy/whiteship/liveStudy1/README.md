# 백기선님 자바 라이브 스터디 1일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습 내용
* JVM이란 무엇인가
* 컴파일 하는 방법
* 실행하는 방법
* 바이트코드란 무엇인가
* JIT 컴파일러란 무엇이며 어떻게 동작하는지
* JVM 구성 요소
* JDK와 JRE 차이

### JVM이란 무엇인가
* 자바를 실행해주는 머신
* 운영체제(MAC, Window, ...)가 바뀌어도 그 코드 그대로 실행해 줌

### 컴파일 하는 방법
### 실행하는 방법

```shell

# 내 노트북 기준(homebrew로 openjdk 설치)
# /opt/homebrew/Cellar/openjdk/{java version}/libexec/openjdk.jdk/Contents/Home/bin
# 안에 javac라는 것이 Hello.java -> Hello.class 
javac Hello.java

# bytecode로 컴파일 한다

java Hello.class
# 실행하면 된다

```
* 상위 버전으로 컴파일 한 것은 하위 버전에서 실행 할 수 없다. (상위 컴파일 -> 하위 실행 )[X]
  * 컴파일 시 옵션으로 해결 가능 
```shell 
javac Hello.java -source 1.8 -target 1.8
```
* 하위 버전으로 컴파일 한 것은 상위 버전에서 실행 할 수 있다. (하위 컴파일 -> 상위 실행 )[O]


### 바이트코드란 무엇인가
* JVM이 이해하는 언어로 번역된 자바 소스코드
* 자바 컴파일러에 의해 변환되는 코드의 명령어의 크기가 1바이트라서 자바 바이트코드라 불림
```shell
javap -c Hello.class
```

### JIT 컴파일러란 무엇이며 어떻게 동작하는지
* Just In Time 컴파일러
* 런타임시 작동
* 바이트코드를 기계어로 번역하는 역할
* 일종의 쓰레드로 동작
* 이전 실행한 코드가 있으면 캐싱해서 사용 

### JVM 구성 요소
* Class Loader
  * 런타임 시점에 클래스 로딩
  * 클래스 인스턴스 생성시 클래스 로더를 통해 메모리에 로드
* Runtime Data Area
  * 자바의 핵심적인 부분
  * Method Area
    * 모든 쓰레드가 공유하는 메모리 영역
      * Class, Interface, Method, field, static 변수 등의 바이트코드 보관
  * Heap Area
    * 런타임시 동적으로 사용되는 공간 인스턴스 생성시 여기에 저장
  * Stack Area
    * 실행과정에서 임시 할당후 메소드가 끝나면 바로 소멸되는 특성의 데이터 저장(ex: 지역 변수 등)
    * 쓰레드별로 각각 독립정 생성
  * PC Registers
  * native method stack
* Execution Engine
  * GC(Garbage Collector)가 여기에 포함
    * 힙 메모리에 참조하지 않는 객체를 제거해주는 역할
  * Interpreter
  * JIT 컴파일러
* Class Loader <--> Runtime Data Area <--> Execution Engine

### JDK와 JRE 차이
* Java Development Kit(JDK) - 자바 개발 도구 
  * javac 같은 것들이 들어 있는 곳
  * JDK 안에 JRE가 포함되어 있다.
* Java Runtime Environment(JRE) - 자바 실행 환경 
* java9버전 부터는 구분할 필요없다.