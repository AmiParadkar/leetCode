package hackerrank;

import java.io.IOException;
import java.util.HashMap;

public class CountValley {
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int sl = 0;
        int count = 0;
        int i = 0;
        boolean isDown = false;
        if(steps <= 0 || path == null || path.length() == 0){
            return -1;
        }
        if(steps != path.length()){
            return -1;
        }
        char ch[] = path.toCharArray();
        while(i < steps){
            if(sl == 0 && ch[i] == 'D'){
                isDown = true;
            }
            if(ch[i] == 'D'){
                sl--;

            } else {
                sl++;
            }
            if(sl == 0 && isDown == true){
                count ++;
                isDown = false;
            }
            i++;
        }
        int sum = -1;
        int sum1 = -5;
        if(sum < sum1){
            System.out.print("WRONG");
        }else{
            System.out.print("rIGHT");
        }
        return count;
    }
    static void minimumBribes(int[] q) {
    HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    int cnt = 0;
        for(int i = 0; i <= q.length ; i++){
        map1.put(i+1,i);
        map2.put(q[i],i);
    }
    Integer two = 2;
    int i = map1.size();
        while (i > 0){
        if(map2.get(i) == map1.get(i)){
            continue;
        } else if(map2.get(i) == (map1.get(i)) - 2){
            cnt+=2;
        } else if(map2.get(i)== (map1.get(i))-1){
            cnt++;
        }
        i--;
    }
        System.out.println(cnt);


}

    public static void main(String[] args) throws IOException {
        String path = "DDUUUUDD";
        int result = countingValleys(8, path);


    }

}
