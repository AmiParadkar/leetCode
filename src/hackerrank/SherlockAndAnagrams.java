package hackerrank;

import java.util.*;

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        HashMap<String, Integer> strMap = new HashMap<>();

        //int runner = 0;
        for (int i = 0; i <= s.length(); i++) {
           // runner = i;
            for (int j = i+1; j <= s.length(); j++) {

                char[] key = ((s.substring(i,j)).toCharArray());
                if(key.length > 1) {
                    Arrays.sort(key);
                }
                String strKey =  new String(key);
                if (strMap.containsKey(strKey)) {
                    strMap.put(strKey, strMap.get(strKey)+1);
                    count++;
                } else {
                    strMap.put(strKey, 1);
                }
//                if(i == 0)
//                    runner++;
            }
        }
//        char[] charS = s.toCharArray();
//        boolean equal = true;
//        for (int i = 0 ; i < charS.length; i ++ ){
//            for (int j = charS.length; j > i; j --){
//                if(equal && charS[i] == charS[j]){
//                    if (strMap.containsKey((String.valueOf(charS[i])))) {
//                        strMap.put((String.valueOf(charS[i])), strMap.get((String.valueOf(charS[i]))) + 1);
//                        count++;
//                    }
//
//                }else {
//                    equal = false;
//                    break;
//                }
//            }
//            if(!equal)
//                break;
//        }
        return count;
    }

    public static void main(String args[]) {

        // sherlockAndAnagrams("mom");
        // sherlockAndAnagrams("abba");
//        System.out.println("Count -=== " + sherlockAndAnagrams("ifailuhkqq"));
        System.out.println("Count -=== " + sherlockAndAnagrams("cdcd"));
    }
}
