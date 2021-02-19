package hackerrank;

import java.util.*;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> m = new HashMap<String, Integer>();
        for (String a: magazine) {
            if (m.containsKey(a)) {
                m.put(a, m.get(a)+1);
            } else {
                m.put(a, 1);
            }

        }

        boolean found = false;
        for (String n : note) {
            found = (m.containsKey(n) && m.get(n) > 0);
            if (found) {
                m.put(n, m.get(n)-1);
            } else {
                break;
            }
        }

        System.out.println(found ? "Yes":"No");
    }

    public static void main(String args[]) {

//        String [] mag = {"give", "me", "one", "grand", "today", "night"};
//        String [] note = {"give", "one", "grand", "today"};

//        String [] mag = {"two", "times", "three", "is", "not", "four"};
//        String [] note = {"two", "times", "two", "is", "four"};
        String [] mag = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        String [] note = {"ive", "got", "some", "coconuts"};
        checkMagazine(mag,note);
    }

}
