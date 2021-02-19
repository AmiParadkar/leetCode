package hackerrank;

import java.io.IOException;


    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class CountingValley {


    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

        public static int countingValleys(int steps, String path) {
            // Write your code here
            int sl = 0;
            int count = 0;
            int i = 0;
            if(steps <= 0 || path == null || path.length() == 0){
                return -1;
            }
            if(steps != path.length()){
                return -1;
            }
            char[] ch = path.toCharArray();
            while(i < steps){
                if(ch[i] == 'D'){
                    sl =  -1;
                    count ++;
                } else {
                    sl = 1;
                }

                i++;
            }
            return count;
            
        }



        public static void main(String[] args) throws IOException {
            String path = "DDUUUUDD";
            int result = countingValleys(8, path);


        }


}
