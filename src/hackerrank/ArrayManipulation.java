package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class ArrayManipulation {
    static long arrayManipulation1(int n, int[][] queries) {

//        5 3
//        1 2 100
//        2 5 100
//        3 4 100
        long count = 0L;
        int len = queries.length;
        int[][] maniuplated = new int[len][n];
        for(int index = 0; index < len; index++){

                for(int i = 0 ; i < n ; i++){
                    int start = queries[index][0] -1;
                    if(i < start){
                        if(index == 0){
                            maniuplated[index][i] = maniuplated[index][i];
                        } else {
                            maniuplated[index][i] = maniuplated[index - 1][i];
                        }
                        continue;
                    }
                    int end = queries[index][1]-1;
                    int add = queries[index][2];
                    if(i > end){
                        if(index == 0) {
                            maniuplated[index][i] = maniuplated[index][i];
                        } else {
                            maniuplated[index][i] = maniuplated[index - 1][i];
                        }
                        continue;
                    }
                    while(start <= end) {
                        if(index == 0 ) {
                            maniuplated[index][start] =  add;
                        } else {
                            maniuplated[index][start] = maniuplated[index-1][start] + add;
                        }
                        if(maniuplated[index][start] > count){
                            count = maniuplated[index][start];

                        }
                        start++;
                        i++;
                    }
                }



        }
        return count;
    }
    // Complete the arrayManipulation function below.
    static long arrayManipulation2(int n, int[][] queries) {

        long count = 0L;
        int len = queries.length;
        int[] maniuplated = new int[n];
        for(int index = 0; index < len; index++){

                int start = queries[index][0] -1;
                int end = queries[index][1]-1;
                int add = queries[index][2];
                while(start <= end) {
                      maniuplated[start] = maniuplated[start] + add;

                    if(maniuplated[start] > count){
                        count = maniuplated[start];

                    }
                    start++;

            }



        }
        return count;
    }

    static long arrayManipulation(int n, int[][] queries) {

        long count = 0L;
        long len = queries.length;
        long[] maniuplated = new long[n];
        Map<Long, Long> map = new HashMap<>();
        for(int index = 0; index < len; index++){

            long start = queries[index][0];
            long end = queries[index][1];
            long add = queries[index][2];
            /* while(start <= end) {
                 maniuplated[(int)start] = maniuplated[(int)start] + add;
                 if (maniuplated[(int)start] > count) {
                     count = maniuplated[(int)start];

                 }
                 start++;
             }*/
            //LongStream.rangeClosed(start, end).forEach(i -> maniuplated[(int) i]+=add);
            map.put(start, (map.containsKey(start) ? map.get(start) : 0) + add);
            map.put(end + 1, (map.containsKey(end + 1) ? map.get(end + 1) : 0) - add);
        }
        //count = Arrays.stream(maniuplated).max().getAsLong();
//        for(int j = 0; j < maniuplated.length; j ++){
//            if(maniuplated[j] > count){
//                count = maniuplated[j];
//
//            }
//        }
        long value = 0;
        for (long i = 0; i < n; i++) {
            value += (map.containsKey(i + 1) ? map.get(i + 1) : 0);
            count = Math.max(count, value);
        }

        return count;
    }

    public static void main(String args[]) {

        int n = 10;
        int m = 4;
        int[][] queries = new int [m][3];
        queries[0][0] = 2;
        queries[0][1] = 6;
        queries[0][2] = 8;

        queries[1][0] = 3;
        queries[1][1] = 5;
        queries[1][2] = 7;

        queries[2][0] = 1;
        queries[2][1] = 8;
        queries[2][2] = 1;

        queries[3][0] = 5;
        queries[3][1] = 9;
        queries[3][2] = 15;

//        10 4
//        2 6 8
//        3 5 7
//        1 8 1
//        5 9 15
        //5 3
//        1 2 100
//        2 5 100
//        3 4 100

        long result = arrayManipulation(n, queries);

    }
}

