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
/*
 * Thread의 다른 메소드를 재정의 할 것이 있다. 그떄 사용
 * */
class WorkerThread extends Thread{
    @Override
    public void run() {
        // ...
    }
}
```
* 현재 스레드 이름 출력
  * Thread.currentThread().getName()
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

#### 스레드 상태 제어 메소드
| 상태 변경                       | 메소드 명                                                   | 내용                                                                                                            |
|-----------------------------|---------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| 일시 정지 -> 실행 대기, 일시 정지 -> 종료 | interrupt()                                             | InterruptedException을 발생시켜 중단 한다. 예외 처리 코드에서 '실행 대기' 또는 '종료' 상태로 갈수 있다                                        |
| 일시 정지 -> 실행 대기              | notify(), notifyAll()                                   | 동기화 블럭 내에서 wait() 로 인해 '일시 정지' 상태의 메소드 들을 실행 대기 상태로 변환 시킨다.                                                   |
| 일시 정지 -> 실행 대기              | resume() - deprecated                                   | notify(), notifyAll()로 사용해야 됨                                                                                 |
| 실행 -> 일시 정지                 | sleep(long millis), sleep(long millis, int nanos)       | 주어진 시간 동안 일시 정지, 시간이 지나면 자동으로 실행 대기 상태가 됨                                                                     |
| 실행 -> 일시 정지                 | join(), join(long millis), join(long millis, int nanos) | 호출한 스레드는 일시 정지 됨, 실행 대기로 갈려면 join()를 멤버로 가진 스레드 종료 또는 주어진 시간 지나야 됨                                            |
| 실행 -> 일시 정지                 | wait(), wait(long millis), wait(long millis, int nanos) | 동기화 블록 내에 스레드를 일시 정지, 시간을 매개 값으로 받으면 그 시간 이후 자동으로 실행 대기, 시간이 매개 변수가 없다면 notify(), notifyAll()로 실행 대기로 변경 해야 됨 |
| 실행 -> 일시 정지                 | suspend() - deprecated                                  | wait()로 사용해야 됨                                                                                                |
| 실행 -> 실행 대기                 | yield()                                                 | 우선 순위가 동일한 스레드에게 양보                                                                                           |
| 실행 -> 종료                    | stop() - deprecated                                     | |

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
* 데몬 스레드
  * 주 스레드의 작업을 돕는 보조역할 하는 스레드
  * setDaemon(true); 로 적용
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

### 스레드 그룹
* 스레드를 묶어 관리할 목적으로 사용
* 그룹 이름 얻기
```java
ThreacGroup group = Thread.currentThread().getThreadGroup();
String groupName = group.getName();

// or
Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces(); // key값으로 이름 얻기
```

### 스레드 풀 (ExecutorService)
* 스레드 폭증을 막을려면 스레드 풀을 사용해야 된다.
* 스레드풀 생성
```java
ExecutorService service = Executors.newCachedThreadPool();

ExecutorService service = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors() );

ExecutorService service = new ThreadPoolExecutor(
        3, // 코어 스레드 갯수
        100,    // 최대 스레드 갯수
        120L,
        // 놀고 있는 시간(120초 동안 놀고 있는 경우 해당 스레드를 제거해서 스레드 수 관리
        TimeUnit.SECONDS, // 놀고 있는 시간 단위
        new SynchronousQueue<Runnable>() // 작업 큐
        );
```

|메소드(매개 변수)|초기 스레드 수|코어 스레드 수|최대 스레드 수|
|---|---|---|---|
|newCachedThreadPool()|0|0|Integer.MAX_VALUE|
|newFixedThreadPool(int nThreads)|0|nThreads|nThreads|

### Critical Path
* 어떠한 작업들이 끝나고 다음 작업이 실행 되는 작업들에 대해서 가장 긴 작업을 해야하는 것들
* 동시에 실행 되는 작업A(시간 3, 시간 5, 시간 2), 작업B(시간 1, 시간 6, 시간 7), 작업C(시간 8, 시간 123, 시간 4)에서 5, 7, 123이 ciritical path이다 
* 위에 저것들을 줄여야 작업이 빨라진다


### race condtion
* 어떠한 작업의 우선 순위에 따라 작업 결과가 다르게 나오는 것
### 참고 자료
* 도서 - 이것이 자바다