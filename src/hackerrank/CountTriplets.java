package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        long count = 0;

        for(int i = 0; i <= arr.size(); i++) {
                int count3 = 1;
                int missedIndex = 0;
                for (int j = i + 1; j < arr.size(); j++) {

                        if ((arr.get(j - 1) * r) == arr.get(j)) {
                            count3++;
                        } else {
                            if(missedIndex == 0)
                                missedIndex = j;
                        }
                       if (count3 >= 3) {
                            count++;
                            count3 = 1;
                        }
                }

        }
        return count;

    }
    public static void main(String args[]){
        List<Long> arr = new ArrayList<>();
//        arr.add((long) 1);
//        arr.add((long) 4);
//        arr.add((long) 16);
//        arr.add((long) 64);
//        long r = 4;
//        long count = countTriplets(arr,r);

        arr.add((long) 1);
        arr.add((long) 2);
        arr.add((long) 2);
        arr.add((long) 4);
        long r = 2;
        long count = countTriplets(arr,r);

    }
}
