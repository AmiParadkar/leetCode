package hackerrank;

import java.util.HashSet;
import java.util.Map;

public class TwoString {
    static String twoStrings(String s1, String s2) {
        boolean found = false;
        HashSet s1Map = new HashSet();
        char[] chars = s2.toCharArray();
        for(Character c : s1.toCharArray()){
            s1Map.add(c);
        }
        for(int i = 0 ;  i < chars.length; i++){
            if(s1Map.contains(chars[i] )){
               found = true;
               break;
            }
        }

        return  found ? "Yes" : "No";


    }
}
