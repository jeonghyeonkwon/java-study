# 백기선님 자바 라이브 스터디 3일차

[백기선님 유튜브](https://www.youtube.com/watch?v=peEXNN-oob4&list=PLfI752FpVCS96fSsQe2E3HzYTgdmbz6LU)

## 학습 내용
* 산술 연산지
* 비트 연산자
* 관계 연산자
* 논리 연산자
* instanceof
* assignment(=) operator
* 화살표 (->) 연산자
* 3항 연산자
* 연산자 우선 순위
* (optional) java 13. switch 연산자

### 산술 연산지

| 산술 연산자 | 설명           |
|--------|--------------|
| `+`      | 더하기          |
| `-`      | 빼기           |
| `*`      | 곱하기          |
| `/`      | 나누기 - 몫 반환   |
| `%`      | 나누기 - 나머지 반환 |

### 비트 연산자
| 구분            | 설명                       | 연산자 |
|---------------|--------------------------|---|
| AND (논리곱)     | 둘 다 참이면 참, 나머지는 거짓       | & |
| OR (논리합)      | 둘 중 하나라도 참이면 참           | &#124; |
| XOR (배타적 논리합) | 둘 다르면 참                  | ^ |
| NOT (논리 부정)   | 거짓 -> 참, 참 -> 거짓 (결과 반대) | ~ |

|설명| 연산자 |
|---|-----|
|왼쪽으로 이동(0으로 채워짐)| `<<`  |
|오른쪽으로 이동(최상위 비트로 채워짐 음수는 1 양수는 0)| `>>`  |
|오른쪽으로 이동(0으로 채줘짐)| `>>>` |

### 관계 연산자
* ==, =!, <, > <=, >=
* 문자열 비교는 .equals로
### 논리 연산자
| 구분            | 설명                       | 연산자                    |
|---------------|--------------------------|------------------------|
| AND (논리곱)     | 둘 다 참이면 참, 나머지는 거짓       | & 또는 &&                |
| OR (논리합)      | 둘 중 하나라도 참이면 참           | &#124; 또는 &#124;&#124; |
| XOR (배타적 논리합) | 둘 다르면 참                  | ^                      |
| NOT (논리 부정)   | 거짓 -> 참, 참 -> 거짓 (결과 반대) | !          |
### instanceof
* 캐스팅 하기 전에 확인하기 위해 사용
```java

class Parent{
    
}
class ChildClass extends Parent{
    
}

public class Main{
    void method(ChildClass child){
        if(child instanceof Parent){
            // ...
        }
    }
}
```
### assignment(=) operator
* =, +=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>= 이 있다
* 값1 = 값1 (+, -, *, /, %, &, |, ^, <<, >>, >>>) 값2를 줄인 것
### 화살표 (->) 연산자
```java
class Main{
    public static void main(String[] args){
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("hello world");
            }
        });
        
        new Thread(()->{
            System.out.println("hello world");
        });
    }    
}

```
### 3항 연산자
```java
boolean flag = true;

if(flag){
    return 1;
}else{
    return  2;
}


// OR
boolean flag = true;

return flag ? 1 : 2;
```
### 연산자 우선 순위
* 우선 순위( 위가 높음 )
* 괄호
  * (), []
* 증감 연산자
  * !, ++, --
* 곱셈 나눗셈
  * *, /, %
* 덧셈, 뺼셈
  * +, -
* 비트 쉬프트
  * <<, >>, >>>
* 관계 연산자
  * <, >, >=, <=
* 비교 연산자
  * ==, !=
* &
* ^
* |
* &&
* ||
* 삼항 연산자
  * ? :
* 대입 연산자
### (optional) java 13. switch 연산자
```java
class Main{
    
    int method(int num){
        return number = switch(num){
            case 1 : yield 3;
            default : throw new RuntimeException("에러 발생"); 
        };
    }
}



```
### 추가
1.
```java
public class Main{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        if(i++ == 0 || j++ == 0){
            System.out.println("Hello");
        }
        
        System.out.println("i : " + i + " j : " + j);
        // i : 1 j : 0
        // i++ == 0 이 만족 해버리므로 j++ ==0을 실행하지 않기 때문에

        int i = 0;
        int j = 0;
        if(i++ == 0 | j++ == 0){
            System.out.println("Hello");
        }

        System.out.println("i : " + i + " j : " + j);
        // i : 1 j : 1
        // 둘 다 평가 하므로
    } 
}

```

2. 안전하게 중간값 구하기
```java
public class Main{
   public static void main(String[] args){
        int start = 0;
        int end = 10;
        
        int mid = (start + end) / 2;
        //이렇게 구하면 start + end 했을때 int 범위를 넘어가서 오버플로우 발생 가능성 있음
       
       
       // 방법 1
       int start = 2_000_000_000;
       int end = 2_100_000_000;
       
       int mid = start + (end - start) / 2;
       
       // 방법 2 비트 연산자 사용 (양수만 됨)

       int start = 2_000_000_000;
       int end = 2_100_000_000;

       int mid = (end + start) >>> 1;
       
       // >> signed shift
       // >>> unsigned shift
   }
}

```

3.
```java
public class Hello{
    // TODO numbers라는 int형 배열이 있다.
    // 해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번씩 들어있다
    // 오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라
    public static void main(String[] args){
        Hello hello = new Hello();
        int result = hello.solution(new int[] {5, 2, 4, 1, 2, 4, 5});
        System.out.println(result);
    }
    
    // TODO XOR
    // 5 ^ 0 = 5
    // 5 ^ 5 = 0;
    
    // 101
    // 101
    // ---
    // 000
    // 5 ^ 1 ^ 5 => (5 ^ 5) ^ 1 = 0 ^ 1 = 1
    
    
    private int solution(int [] numbers){
        // iter (향상된 for문)
        // itar (그냥 for문)
        int result = 0;
        for (int number  : numbers) {
            result ^= number;
        }
        return result;
    }
}
```

