package hackerrank;


    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountChar {

    // Complete the repeatedString function below.
        static long repeatedString(String s, long n) {
            char[] ch = s.toCharArray();
            int chLen = ch.length;
            int j = 0;
            long cnt = 0;
            if(ch != null && chLen > 0){
                if(chLen > n){
                    for(int i = 0; i < n; i++){
                        if(ch[i] == 'a'){
                            cnt++;
                        }
                    }
                    return cnt;
                }
                for(int i = 0; i <chLen; i++){
                    if(ch[i]== 'a'){
                        cnt++;
                        //chPosition.add(i);
                    }
                }
            }
            if(ch.length < n){
                long diff = n - chLen;
                long addCnt = Double.valueOf(Math.floor(diff / chLen)).longValue();
                cnt += addCnt*cnt;
                if(diff %chLen != 0){
                    for(int k = 0 ; k < diff%chLen; k++){
                        if(ch[k] == 'a'){
                            cnt++;
                        }
                    }

                }
            }
            return cnt;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            String s = "ababa";
            long n = 3;

            long result = repeatedString(s, n);

           System.out.print(result);

        }
    }


