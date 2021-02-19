package hackerrank.blackRock;
import java.util.*;
import java.util.stream.IntStream;


public class TextEditor {
    public static int textFormatting2(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        HashSet<Integer> selected = new HashSet<>();
        // Assumption is both starting and ending list are of same size
        for(int index = 0 ; index < starting.size(); index ++){

            if(!selected.contains(starting.get(index))){
                int startVal = starting.get(index);
                for(int s = startVal-1; s < ending.get(index); s++){
                    selected.add(startVal+s);
                }
                count++;
            }
            if(!selected.contains(ending.get(index))){
                int endVal = ending.get(index);
                int startVal = starting.get(index);
                int i = 0;
                for(int s = endVal; s > starting.get(index); s--){
                    if(!selected.contains(endVal-i)){
                        selected.add(endVal - i);
                    }
                    i++;
                }
                count++;
            }
            count++;
        }


        return count;

    }
    public static int textFormatting1(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        HashSet<Integer> selected = new HashSet<>();
        // Assumption is both starting and ending list are of same size
        for(int index = 0 ; index < starting.size(); index ++){

            if(!selected.contains(starting.get(index))){
                int startVal = starting.get(index);
                for(int s = startVal-1; s < ending.get(index); s++){
                    selected.add(startVal+s);
                }
                count++;
            }
            if(!selected.contains(ending.get(index))){
                int endVal = ending.get(index);
                int startVal = starting.get(index);
                int i = 0;
                for(int s = endVal; s > starting.get(index); s--){
                    if(!selected.contains(endVal-i)){
                        selected.add(endVal - i);
                    }
                    i++;
                }
                count++;
            }
            count++;
        }


        return count;

    }
    public static int textFormatting4(List<Integer> starting, List<Integer> ending, List<Character> style) {
            int count = 0;
            Map<Integer, List<Character>> selectedMap = new HashMap<>();
            // Assumption is both starting and ending list are of same size
            for (int i = 0; i < starting.size(); i++) {
                int startVal = starting.get(i);
                Character c = style.get(i);
                boolean selected = false;
                boolean styled = false;
                for (int s = 0; s <= (ending.get(i) - starting.get(i)); s++) {
                    if(!selectedMap.containsKey(startVal+s)){
                        List<Character> chList = new ArrayList<>();
                        chList.add(c);
                        selectedMap.put(startVal+s, chList);
                        if(!selected)
                            selected = true;
                        if(!styled)
                            styled = true;
                        continue;

                    } else {
                       List<Character> chList = (selectedMap.get(startVal+s));
                       if(!chList.contains(c)){
                           chList.add(c);
                           selectedMap.put(startVal, chList);
                           if(!styled)
                            styled = true;

                       }


                    }
                }
                if(selected && styled)
                    count +=2;
                else if(!selected && styled)
                    count +=1;
            }
            return count;
        }

    public static int textFormatting7(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        Map<Integer, List<Character>> selectedMap = new HashMap<>();
        int prevStart = 0, prevEnd = 0;
        Character prevStyle = null;
        // Assumption is both starting and ending list are of same size
        for (int i = 0; i < starting.size(); i++) {
            int startVal = starting.get(i);
            int endVal = ending.get(i);
            Character c = style.get(i);
            boolean isStyleApplied = false;

            if((prevStyle != null && prevStyle.equals(c))
                    && prevStart == startVal
                    && prevEnd == endVal){
                continue;
            }
            for(int index = startVal ; index <= endVal; index++){
                List<Character> chList = new ArrayList<>();
                if(selectedMap.containsKey(index)){
                    chList = selectedMap.get(index);
                }
                if(!chList.contains(c)) {
                    chList.add(c);
                    selectedMap.put(index, chList);
                    if(!isStyleApplied) {
                        isStyleApplied = true;
                    }
                }

            }
            if(isStyleApplied) {

                if (prevStyle == null && prevStart == 0 && prevEnd == 0) {
                    count += 2;
                } else {
                    if (prevStyle.equals(c)) {
                        if (prevStart != startVal && startVal > (prevEnd + 1)) {
                            count += 2;
                        } else if(prevStart != startVal && startVal < (prevEnd+1)){
                            startVal = prevStart;
                        }
                    } else {
                        count++;
                        if (startVal != prevStart || endVal != prevEnd) {
                            count++;
                        }
                    }
                }

            }
            prevStart = startVal;
            prevEnd = endVal;
            prevStyle = c;


        }
        return count;
    }




    public static int textFormatting6(List<Integer> starting, List<Integer> ending, List<Character> style) {

        int total = 0;
        HashMap<Character,List<List<Integer>>> styles_used = new HashMap();

        for (Character c : style) {
            styles_used.put(c, new ArrayList<>());
        }


        for (int i = 0; i < starting.size(); i++) {
            int s = starting.get(i);
            int e = ending.get(i);
            Character st = style.get(i);

            if(styles_used.get(st).size() == 0) {
                List<Integer> a = new ArrayList<>();
                a.add(s);
                a.add(e);
                List<List<Integer>> b = new ArrayList<>();
                b.add(a);
                styles_used.put(st, b);
                continue;
            }

            for (int j = 0; j < styles_used.get(st).size(); j++) {
                //System.out.println("j = " + j);
                //for (int pcnt = 0; pcnt < styles_used.get(st).size(); pcnt++) {
                //for (List<Integer> pair : styles_used.get(st)) {
                    List<Integer> pair = styles_used.get(st).get(j);
                    //System.out.println("   pair = " + pair);
                    int p_start = pair.get(0);
                    int p_end = pair.get(1);

                    if ((p_start <= s && s <= p_end && p_start <= e && e <= p_end)) {
                        continue;
                    }

                    if (s > p_end + 1) {

                        List<Integer> ab = new ArrayList<>();
                        ab.add(s);
                        ab.add(e);
                        List<List<Integer>> b = styles_used.get(st);
                        b.add(ab);

                        styles_used.put(st,b);
                    } else if ((p_start <= s && e > p_end) || (s == p_start + 1)) {

                        styles_used.get(st).get(j).set(1,e);
                    }

                    //System.out.println("styles_used = " + styles_used);
                //}
            }

        }
        for(Character su: styles_used.keySet()){
            List<List<Integer>> pairs = styles_used.get(su);
            for (List<Integer> pair : pairs){
                total += 2;
                for (Character other: styles_used.keySet()){
                    if(su != other && styles_used.get(other).contains(pair)){
                        total += 1;
                        styles_used.get(other).remove(pair);
                    }
                }
            }
        }

       // System.out.println(total);

        return total;

    }
    public static int textFormatting10(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        // Create a new structure of start end and systle
        List<Integer> newStarting = new ArrayList<>();
        List<Integer> newEnding = new ArrayList<>();
        List<Character> newStyle = new ArrayList<>();
        // Assumption is both starting and ending list are of same size
        for (int i = 0; i < starting.size(); i++) {
            int startVal = starting.get(i);
            int endVal = ending.get(i);
            Character c = style.get(i);
            // If the style is added for the first time add it to new structure
            if(newStyle.isEmpty() || (!newStyle.contains(c))){
                newStarting.add(startVal);
                newEnding.add(endVal);
                newStyle.add(c);
            } else{
                int j = 0,  newSize = newStarting.size();
                boolean accountedFor = false;
                // Traves through the new structure to see if we can consolidate the operations
                while(j < newSize) {
                    if(newStyle.get(j).equals(c)) {

                        // Check if the start and end is within the range of already present array
                        if (startVal >= newStarting.get(j) && endVal <= newEnding.get(j)) {
                            j++;
                            accountedFor = true;
                            break;

                        } else if (startVal <= newStarting.get(j) && endVal >= newEnding.get(j)) {
                            newStarting.set(j, startVal);
                            newEnding.set(j, endVal);
                            accountedFor = true;
                            break;
                        } else if (startVal <= newStarting.get(j)
                                && (endVal >= newStarting.get(j) && endVal <= newEnding.get(j))) {
                            newStarting.set(j, startVal);
                            accountedFor = true;
                            break;
                        } else if ((startVal >= newStarting.get(j) && startVal <= newEnding.get(j))
                                && endVal >= newEnding.get(j)) {
                            newEnding.set(j, endVal);
                            accountedFor = true;
                            break;
                        }
                    }
                    j++;
                }
                if(!accountedFor) {
                    newStarting.add(startVal);
                    newEnding.add(endVal);
                    newStyle.add(c);
                }
            }

        }
        int oldSize = newStarting.size();
        int newSize = 0;
        /**
         TODO Make this recursive
         **/
        do {
            List<Integer> newStarting1 = new ArrayList<>();
            List<Integer> newEnding1 = new ArrayList<>();
            List<Character> newStyle1 = new ArrayList<>();
            List<Integer>indexToRemove = new ArrayList<>();
            for (int i = 0; i < newStarting.size(); i++) {
                int startVal = newStarting.get(i);
                int endVal = newEnding.get(i);
                Character c = newStyle.get(i);
                if (newStyle1.isEmpty() || (!newStyle1.contains(c))) {
                    newStarting1.add(startVal);
                    newEnding1.add(endVal);
                    newStyle1.add(c);

                } else {
                    int j = 0, size = newStarting1.size();
                    boolean accountedFor = false;
                    while (j < size) {
                        if (newStyle1.get(j).equals(c)) {

                            // Check if the start and end is withing the range of already present array
                            if (startVal >= newStarting1.get(j) && endVal <= newEnding1.get(j)) {

                                indexToRemove.add(j);
                                accountedFor = true;
                                j++;
                                break;

                            } else if (startVal <= newStarting1.get(j) && endVal >= newEnding1.get(j)) {
                                newStarting1.set(j, startVal);
                                newEnding1.set(j, endVal);
                                indexToRemove.add(j);
                                accountedFor = true;
                                break;
                            } else if (startVal <= newStarting1.get(j)
                                    && (endVal >= newStarting1.get(j) && endVal <= newEnding1.get(j))) {
                                newStarting1.set(j, startVal);
                                indexToRemove.add(j);
                                accountedFor = true;
                                break;
                            } else if ((startVal >= newStarting1.get(j) && startVal <= newEnding1.get(j))
                                    && endVal >= newEnding1.get(j)) {

                                newEnding1.set(j, endVal);
                                indexToRemove.add(j);
                                accountedFor = true;
                                break;
                            }

                        }
                        j++;
                    }
                    if(!accountedFor) {
                        newStarting1.add(startVal);
                        newEnding1.add(endVal);
                        newStyle1.add(c);
                    }


                }

            }
            for(int k = 0; k< indexToRemove.size() ; k++){
                newStarting.remove(k);
                newEnding.remove(k);
                newStyle.remove(k);
            }
            oldSize = newStarting.size();
            newSize = newStarting1.size();
            newStarting.clear();
            newEnding.clear();
            newStyle.clear();
            newStarting.addAll(newStarting1);
            newEnding.addAll(newEnding1);
            newStyle.addAll(newStyle1);


        }while(oldSize != newSize );

        //Counting
        int prevStart = 0, prevEnd = 0;
        for(int i = 0 ; i < newStarting.size(); i++){

            if(i == 0 ){
                count+=2;
                prevStart = newStarting.get(i);
                prevEnd = newEnding.get(i);
            } else {
                if(newStarting.get(i) == prevStart && newEnding.get(i) == prevEnd){
                    count+=1;
                }else {
                    count+=2;
                }
                prevStart = newStarting.get(i);
                prevEnd = newEnding.get(i);

            }
        }
        return count;

        }

    public static int textFormatting(List<Integer> starting, List<Integer> ending, List<Character> style) {

        int count = 0;
        int oldSize = starting.size();
        int newSize = 0;
        do {
            List<Integer> newStarting = new ArrayList<>();
            List<Integer> newEnding = new ArrayList<>();
            List<Character> newStyle = new ArrayList<>();
            List<Integer>indexToRemove = new ArrayList<>();

            // Assumption is both starting and ending list are of same size
            for (int i = 0; i < starting.size(); i++) {
                int startVal = starting.get(i);
                int endVal = ending.get(i);
                Character c = style.get(i);
                if(newStyle.isEmpty() || (!newStyle.contains(c))){
                    newStarting.add(startVal);
                    newEnding.add(endVal);
                    newStyle.add(c);
                } else{
                    int j = 0;
                    newSize = newStarting.size();
                    boolean accountedFor = false;
                     // Travis through the new structure to see if we can consolidate the operations
                     while(j < newSize) {
                        if(newStyle.get(j).equals(c)) {
                            // Check if the start and end is withing the range of already present array
                            if (startVal >= newStarting.get(j) && endVal <= newEnding.get(j)) {
                                indexToRemove.add(i);
                                j++;
                                accountedFor = true;
                                break;
                            } else if (startVal <= newStarting.get(j) && endVal >= newEnding.get(j)) {
                                newStarting.set(j, startVal);
                                newEnding.set(j, endVal);
                                indexToRemove.add(i);
                                accountedFor = true;
                                break;
                            } else if (startVal <= newStarting.get(j)
                            && (endVal >= newStarting.get(j) && endVal <= newEnding.get(j))) {
                                newStarting.set(j, startVal);
                                indexToRemove.add(i);
                                accountedFor = true;
                                break;
                            } else if ((startVal >= newStarting.get(j) && startVal <= newEnding.get(j))
                            && endVal >= newEnding.get(j)) {
                                newEnding.set(j, endVal);
                                indexToRemove.add(i);
                                accountedFor = true;
                                break;
                            }
                        }
                        j++;
                     }
                    if(!accountedFor) {
                        newStarting.add(startVal);
                        newEnding.add(endVal);
                        newStyle.add(c);
                    }
                }

            }
            for(int k = 0; k< indexToRemove.size() ; k++){
                starting.remove(indexToRemove.get(k));
                ending.remove(indexToRemove.get(k));
                style.remove(indexToRemove.get(k));
            }
            oldSize = starting.size();
            newSize = newStarting.size();
            starting.clear();
            ending.clear();
            style.clear();
            starting.addAll(newStarting);
            ending.addAll(newEnding);
            style.addAll(newStyle);


        }while(oldSize != newSize );


    //Counting
    int prevStart = 0, prevEnd = 0;
        for(int i = 0 ; i < starting.size(); i++){

        if(i == 0 ){
            count+=2;
            prevStart = starting.get(i);
            prevEnd = ending.get(i);
        } else {
            if(starting.get(i) == prevStart && ending.get(i) == prevEnd){
                count+=1;
            }else {
                count+=2;
            }
            prevStart = starting.get(i);
            prevEnd = ending.get(i);

        }
    }
            return count;
}
    public static void main(String[] args) {

        //int[] arr = { 1, 17, 3, 3, 1,13 };
        //int[] arr = { 1, 1, 3, 3, 3 };
         //int[] arr = { 1, 3, 9, 5, 9 };

//
//        int[] arr = { 50452, 97851, 55771, 18003, 80667,164453,167535,837,62317,38615,24919,147921,818,5274,20344,9354,7908,147273,70301,27958,101706,129756,90059,162582,73788,97782,98905,46352,25452,85936,64737,72010,41530,31763,91712,44518,75950,58266,11516,64748,39562,17882,80393,113219,57722,10552,9932,44770,49456,63415};
//        int[] arr1 = {190824,155521,196108,116643,149609,196753,180929,145669,76638,190998,69463,160280,182291,76274,71259,65876,193000,189723,150798,144360,129731,168112,199182,189238,97578,172966,170343,133462,37446,134252,147120,99517,67558,41088,141179,144411,151630,149328,197788,103083,117845,109792,194661,149213,69864,150686,140245,81992,125463,67024};
//        char[] ch = {'i','u','i','u','u','i','i','u','u','i','u','u','u','u','i','u','i','i','i','u','i','i','u','u','i','u','i','i','i','i','i','i','u','i','u','u','u','i','i','u','u','u','u','u','u','i','u','u','i','i'};

//        int[] arr = { 1, 3, 9, 5, 9 };
//        int[] arr1 = {5, 8, 10, 6,10};
//        char[] ch = {'b','i','b','i','u'};

//        int[] arr = { 1, 1, 3, 3, 3 };
//        int[] arr1 = {6, 6, 8, 8, 8};
//        char[] ch = {'b','b','b','i','u'};

        int[] arr = {4992, 32200, 10113, 49806, 4166, 72698, 72709, 57683, 22903, 660, 62148, 58355, 15830, 20365, 11713, 23209, 85471, 50741, 36662, 72453, 63736, 30508, 22088, 19269, 65198, 73277, 49183, 73494, 22254, 48111, 50256, 10333, 19793, 60165, 2028, 10233, 64083, 32447, 46667, 32361, 65721, 74649, 41377, 5863, 11411, 51643, 81383, 47748, 29130, 1124, 68153, 11253, 81669, 27175, 18213, 54371, 31252, 38297, 41330, 2118, 37944, 1942, 14358, 17898, 32253, 9646, 12216, 24518, 14287, 38392, 29673, 1743, 57808, 37975, 57959, 48949, 10648, 86955, 48668, 14004, 4374, 23549, 3269, 32225, 59850, 1258, 13748, 10848, 41315, 5159, 50669, 1365, 40201, 10996, 52370, 10564, 10326, 14397, 10563, 11587};
        int[] arr1 = {67198, 75221, 88918, 73258, 45020, 74534, 82577, 83106, 30035, 74108, 75112, 79349, 69015, 24851, 38691, 39960, 96267, 96009, 47662, 85576, 72293, 88351, 87865, 70577, 66533, 76407, 95076, 93941, 97533, 80805, 51685, 66064, 63665, 83864, 98922, 60816, 68346, 57180, 84959, 40828, 94172, 88935, 73290, 96327, 93269, 67304, 96707, 83194, 70980, 19396, 75917, 17662, 87601, 95314, 95244, 91203, 52113, 47951, 93941, 62421, 69335, 51122, 44745, 79341, 70933, 61753, 72643, 99817, 22675, 92117, 61283, 98959, 71062, 91593, 84882, 88990, 30750, 98992, 92518, 81471, 96091, 32334, 43901, 59138, 92964, 12579, 60020, 20178, 50019, 91679, 51003, 79581, 85477, 60274, 65157, 70636, 36141, 20989, 74243, 29015};
        char[] ch = {'b','u','b','u','u','b','i','u','i','b','u','u','u','u','i','u','b','b','u','b','u','i','i','u','b','u','b','b','i','b','i','b','u','u','i','u','i','i','u','u','i','u','b','u','u','b','u','b','i','i','u','u','u','i','u','u','u','b','u','i','i','i','b','i','b','i','u','i','u','b','i','b','u','i','i','b','i','u','b','i','i','u','u','u','i','u','u','b','b','u','i','u','u','u','i','u','b','u','b','b'};


//        int[] arr = {531147,852586,171498,946874,852725,168155,356980,63909,419116,188053,962415,162086,913352,62214,695523,402952,121687,833635,77713,909023,54341,376946,798349,527322,746286,953937,534398,804991,977623,596511,251798,955058,112937,981378,148793,207409,796996,177623,800943,652386,897858,638438,539202,628526,495733,780305,574049,796240,429073,720657};
//        int[] arr1 = {532124,853563,172475,947851,853702,169132,357957,64886,420093,189030,963392,163063,914329,63191,696500,403929,122664,834612,78690,910000,55318,377923,799326,528299,747263,954914,535375,805968,978600,597488,252775,956035,113914,982355,149770,208386,797973,178600,801920,653363,898835,639415,540179,629503,496710,781282,575026,797217,430050,721634};
//        char[] ch = {'u','u','b','u','u','b','b','b','b','b','u','b','u','b','u','b','b','u','b','u','b','b','u','u','u','u','u','u','u','u','b','u','b','u','b','b','u','b','u','u','u','u','u','u','b','u','u','u','b','u'};

        List<Integer> starting = new ArrayList<>(arr.length);

        for (int i : arr) {
            starting.add(Integer.valueOf(i));
        }
        //int[] arr1 = {5,20,8,12,1,18};
        //
        //
        //int[] arr1 = {190824,155521,196108,116643,149609,196753,180929,145669,76638,190998,69463,160280,182291,76274,71259,65876,193000,189723,150798,144360,129731,168112,199182,189238,97578,172966,170343,133462,37446,134252,147120,99517,67558,41088,141179,144411,151630,149328,197788,103083,117845,109792,194661,149213,69864,150686,140245,81992,125463,67024};

        List<Integer> ending = new ArrayList<>(arr1.length);

        for (int i : arr1) {
            ending.add(Integer.valueOf(i));
        }
         //char[] ch = {'b','b','i','i','u','u'};
         //
        //
        //char[] ch = {'i','u','i','u','u','i','i','u','u','i','u','u','u','u','i','u','i','i','i','u','i','i','u','u','i','u','i','i','i','i','i','i','u','i','u','u','u','i','i','u','u','u','u','u','u','i','u','u','i','i'};
        List<Character> style = new ArrayList<>(ch.length);

        for (char i : ch) {
            Character character = new Character(i);
            style.add(character);
        }
       System.out.println( textFormatting(starting,ending, style));
    }

}
