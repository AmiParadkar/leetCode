package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class RandsomeNote {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,String> mapNote = new HashMap<>();
        boolean found = false;
        for(int i =0; i < note.length; i ++){
            // mapNote.put(note[i],null);
            found = false;
            for(int j = 0 ; j < magazine.length; j ++  ){
                if(magazine[j] == null){
                    continue;
                }
                if(note[i].equals(magazine[j])){
                    mapNote.put(note[i],magazine[j]);
                    magazine[j] = null;
                    found = true;
                    break;
                }

            }
            if(!found){
                break;
            }
        }
        // if(mapNote.containsValue(null)){
        //     System.out.println("No");
        // } else {
        //     System.out.println("Yes");
        // }
        System.out.println(found ? "Yes":"No");


    }
    public static void main(String args[]) {
//        String [] mag = {"give", "me", "one", "grand", "today", "night"};
//        String [] note = {"give", "one", "grand", "today"};

        String [] mag = {"two", "times", "three", "is", "not", "four"};
        String [] note = {"two", "times", "two", "is", "four"};

//        String [] mag = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
//        String [] note = {"ive", "got", "some", "coconuts"};
        checkMagazine(mag,note);
    }
}
