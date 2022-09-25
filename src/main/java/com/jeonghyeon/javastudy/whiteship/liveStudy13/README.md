# 백기선님 자바 라이브 스터디 13일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
* InputStream과 OutputStream
* Byte와 Character 스트림
* 표준 스트림 (System.in, System.out, System.err)
* 파일 읽고 쓰기

### 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
#### I/O
* Input/Output 줄임말
    * Input : 메모장 파일 데이터 불러오기(read), Output : 메모장에 글쓰기(write)
* 컴퓨터 내부 또는 외부 장치로 데이터를 주고 받는 것

#### NIO
* non-blocking-io 또는 New I/O 라고도 불림
* buffer 단위로 읽으면 NIO, byte단위로 읽으면 IO

#### 스트림 (Stream)
* 입력에서 출력으로 가는 단방향 흐름으로 보내는 방식

#### 버퍼 (Buffer)
* 중간에 한 개의 저장소에 저장한뒤 한꺼번에 보내는 방식
* 속도가 더 빠름
  * OS 레벨의 시스템 콜 횟수를 줄이기 때문에 속도가 더 빨라짐
  * 시스템 코어와 자바 api 호출의 속도 차이로 시스템 코어의 작업을 추리하는 동안 자바 api가 기다려야 하는 것을 줄여준다.
  * 물을 한 모금씩 떠와라(1byte) -> 물을 한 컵씩 떠와라

#### 채널 (Channel)
* 양방향 통신

### InputStream과 OutputStream

* InputStream
  * 바이트 기반 입력 스트림의 최상위 추상 클래스
  * 종류
    * FileInputStream
    * BufferedInputStream
    * DataInputStream

| 리턴 타입 | 메소드                                       | 내용                                                                                                 |
|-------|-------------------------------------------|----------------------------------------------------------------------------------------------------|
| int   | read()                                    | 1 바이트를 읽고 읽은 바이트를 리턴(읽을 것이 없으면 -1 리턴), 리턴 값이 int(4 바이트)이므로 끝에 1 바이트에만 데이터가 들어가 있다.                 |
| int   | read(byte[] byte)                         | 파라미터 byte[] 에 읽은 데이터가 들어가고 읽은 데이터의 바이트 수를 리턴(읽을 것이 없으면 -1 리턴)                                      |
| int   | read(byte[] byte, int offset, int length) | byte[]에 배열 어디서 부터 시작할 지 offset부터 길이 length까지 데이터를 읽어 들인다.(더 이상 읽을 것이 없으면 -1이고 있다면 length와 리턴값은 동일) |
| void  | close                                     | 사용한 시스템 자원 반납|


* OutputStream
  * 바이트 기반 출력 스트림의 최상위 추상 클래스
  * 종류
    * FileOutputStream
    * PrintStream
    * BufferedOutputStream
    * DataOutputStream
  
| 리턴 타입 | 메소드                                        | 내용                                  |
|-------|--------------------------------------------|-------------------------------------|
| void  | write(int b)                               | 파라미터 b의 값의 1바이트를 보낸다                |
| void  | write(byte[] byte)                         | 파라미터 b의 바이트 배열을 모두 보낸다.             |
| void  | write(byte[] byte, int offset, int length) | byte[offset]부터 길이 length까지 데이터를 보낸다 |
| void  | flush()                                    | 버퍼에 잔류하는 모든 바이트를 보낸다                |
| void  | close()                                    | 시스템 자원 반납하고 출력 스트림 닫기               |

### Byte와 Character 스트림
* 스트림 클래스는 크게 두가지 종류로 구분된다.
    * byte 기반 스트림
      * 그림, 멀티미디어, 문자 등 모든 종류의 데이터 
    * character 기반 스트림
      * 오로지 문자만 받는데 특화
      * byte 기반은 1byte 이지만 character은 2byte

* 보조 스트림을 이용해서 byte 기반에서 character 기반으로 변경 할 수 있다.


|스트림|구분|최상위 클래스| 예시                           |
|---|---|---|------------------------------|
|바이트 기반 스트림|입력 스트림|InputStream| 그림, 멀티미디어, 텍스트 바이트 단위로 읽을 때  |
|바이트 기반 스트림|출력 스트림|OutputStream| 그림, 멀티미디어, 텍스트 바이트 단위로 저장할 때 |
|문자 기반 스트림|입력 스트림|Reader| 문자 단위로 읽을 때         |
|문자 기반 스트림|출력 스트림|Writer| 문자 단위로 저장할 때                 |

### 표준 스트림 (System.in, System.out, System.err)
|종류|방향|내용|
|---|---|---|
|System.in|Input|데이터를 입력 받음|
|System.out|Output|데이터를 출력|
|System.err|Output|에러 출력|

### 파일 읽고 쓰기
* 텍스트 문자 읽기

```java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Init {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("파일 경로/파일.txt")));
            String str = "";
            // 읽은 줄을 str에 넣기 (값이 없을때 까지)
            while((str = bufferedReader.readLine())!=null){
                System.out.println(str);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
}
```

* 텍스트 문자 쓰기

```java

import java.io.*;

class Init {
    public static void main(String[] args) {
        File file = new File("파일 경로/파일.txt");

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("글 쓰기");
            bufferedWriter.newLine();
            bufferedWriter.write("글 쓰기2");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

### 추가
* java.io는 데코레이터 패턴으로 만들어졌다.
  * new BufferedReader(new FileReader(new File("파일 경로/파일.txt")));

* 직렬화, 역직렬화
  * 직렬화
    * 자바 시스템 내부에서 사용되는 객체, 데이터를 외부 자바 시스템에서도 사용하다록 byte 형태로 데이터 변환 시키는 것
    * 객체를 뭉쳐놓고 다른 곳에서 푸는 것
    * 느리다는 이유로 안쓰는 경우도 있음
```java
import java.io.Serializable;

class User implements Serializable{
    private static final long serialVersionUID = 1L;// 없으면 기본 해쉬값으로 사용
    // ...
}
```
