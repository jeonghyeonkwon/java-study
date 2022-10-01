# Item9. try-finally보다는 try-with-resources를 사용하라
* 자원닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어지기 쉽다.
* finalizer로 자원을 닫을수 있지만 그리 믿을만 하지 못하다
* 그래서 try-finally를 활용할수 있지만 실수를 저지르기 쉽다.

```java
import java.io.*;

class Main {
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
        /*
         * 하나일 때는 어렵지 않다
         * */
    }

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n ;
                while((n= in.read(buf))>=0){
                    out.write(buf,0,n);
                }
            } finally {
                out.close();
            }
        }finally {
            in.close();
        }
        /*
         * 사용하는 자원이 많아질 수록 close 구현이 복잡하다
         * */
    }
}
```

* 꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, try-with-resources를 사용하자

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class Main {
    static void copy(String src, String dst) throws IOException {
        try (
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dst)
        ){
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while((n=in.read(buf)) >= 0){
                out.write(buf,0,n);
            }
        }
    }
}
```

