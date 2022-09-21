# 백기선님 자바 라이브 스터디 10일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습할 것 (필수)
* Thread 클래스와 Runnable 인터페이스
* 쓰레드의 상태
* 쓰레드의 우선순위
* Main 쓰레드
* 동기화
* 데드락

### Thread 클래스와 Runnable 인터페이스
* 쓰레드로 부터 작업 스레드 객체를 생성하려면 Runnable를 넣어 줘야 된다

```java

public class Task implements Runnable {
    @Override
    public void run() {
        //...        
    }
}

class Init {
    public static void main(String args[]) {
        // 방법 1 : Runnable 구현 클래스 
        Runnable task = new Task();
        Thread thread1 = new Thread(task);
        thread1.start();

         
        // 방법 2 : 익명객체 
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // ...
            }
        });
        thread2.start();

        // 방법 3 : 익명객체(람다식)
        Thread thread3 = new Thread(() -> {
            // ...
        });
        thread3.start();
    }
}
// 방법 4 Thread 하위 클래스로부터 생성
class WorkerThread extends Thread{
    @Override
    public void run() {
        // ...
    }
}
```

### 쓰레드의 상태
* 상태 확인 - getState()

|상태| enum          | 내용                       |
|---|---------------|--------------------------|
|객체 생성| NEW           | 스레드 객체가 생성, start() 호출 전 |
|실행 대기| RUNNABLE      | 실행 상태로 갈 수 있는 상태         |
|일시 정지| WAITING       | 다른 스레드가 통지할 때까지 기다리는 상태  |
|일시 정지| TIMED_WAITING | 주어진 시간동안 대기              |
|일시 정지| BLOCKED       | 락 풀릴때 까지 대기              |
|종료| TERMINATED    | 실행을 미친 상태                |
### 쓰레드의 우선순위
* 기본 값 5, 1~10까지 우선 순위 (숫자가 높을수록 우선순위가 높음)
* thread.setPriority(우선 순위)
  * 우선순위
    * Thread.MAX_PRIORITY - 10
    * Thread.NORM_PRIORITY - 5
    * Thread.MIN_PRIORITY - 1
### Main 쓰레드
```java
class Init{
    public static void main(String[] args){} 
    /*
     * 이것이 메인 스레드
     * 다른 쓰레드를 만들지 않으면 싱글 스레드
     * */
    
}
```
### 동기화
* 싱글 스레드가 아닌 멀티 스레드 환경에서는 자원을 공유해서 작업해야 하는 경우가 있다.
  * 값이 엉킬수 있다. 다른 스레드가 접근못하게 막아야 한다

* 동기화 메소드
```java
public synchronized void method(){
    // 내용
}

```

* 동기화 블록

```java

public void method(){
    
    synchronized(공유 객체){ //공유 객체가 객체 자신이면 this
        // 내용       
    }    
}
```
### 데드락
* 스레드1이 A를 물고(Lock) B를 획득 하기 위해 대기, 스레드2가 B를 물고 A를 획득 하기 위해 대기. 두 스레드 모두 획득 하지 못하게 됨
  * 예) DB에서 동시성 문제로 발생 

### 참고 자료
* 도서 - 이것이 자바다