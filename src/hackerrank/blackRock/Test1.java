package hackerrank.blackRock;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static int textFormatting(List<Integer> starting, List<Integer> ending, List<Character> style) {
        int count = 0;
        List<Integer> newStarting = new ArrayList<>();
        List<Integer> newEnding = new ArrayList<>();
        List<Character> newStyle = new ArrayList<>();
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
                int j = 0,  newSize = newStarting.size();
                while(j < newSize) {
                    if(newStyle.get(j).equals(c)) {

                        // Check if the start and end is withing the range of already present array
                        if (startVal >= newStarting.get(j) && endVal <= newEnding.get(j)) {
                            j++;
                            break;

                        } else if (startVal <= newStarting.get(j) && endVal >= newEnding.get(j)) {
                            newStarting.set(j, startVal);
                            newEnding.set(j, endVal);
                            break;
                        } else if (startVal <= newStarting.get(j)
                                && (endVal >= newStarting.get(j) && endVal <= newEnding.get(j))) {
                            newStarting.set(j, startVal);
                            break;
                        } else if ((startVal >= newStarting.get(j) && startVal <= newEnding.get(j))
                                && endVal >= newEnding.get(j)) {
                            newEnding.set(j, endVal);
                            break;
                        } else {
                            newStarting.add(startVal);
                            newEnding.add(endVal);
                            newStyle.add(c);
                            break;

                        }
                    }
                    j++;
                }
            }

        }
        int oldSize = newStarting.size();
        int newSize = 0;
        do {
            List<Integer> newStarting1 = new ArrayList<>();
            List<Integer> newEnding1 = new ArrayList<>();
            List<Character> newStyle1 = new ArrayList<>();
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
                                newStarting.remove(j);
                                newEnding.remove(j);
                                newStyle.remove(j);
                                accountedFor = true;
                                j++;

                                break;

                            } else if (startVal <= newStarting1.get(j) && endVal >= newEnding1.get(j)) {
                                newStarting1.set(j, startVal);
                                newEnding1.set(j, endVal);
                                newStarting.remove(j);
                                newEnding.remove(j);
                                newStyle.remove(j);
                                accountedFor = true;
                                break;
                            } else if (startVal <= newStarting1.get(j)
                                    && (endVal >= newStarting1.get(j) && endVal <= newEnding1.get(j))) {
                                newStarting1.set(j, startVal);
                                newStarting.remove(j);
                                newEnding.remove(j);
                                newStyle.remove(j);
                                accountedFor = true;
                                break;
                            } else if ((startVal >= newStarting1.get(j) && startVal <= newEnding1.get(j))
                                    && endVal >= newEnding1.get(j)) {
                                newEnding1.set(j, endVal);
                                newStarting.remove(j);
                                newEnding.remove(j);
                                newStyle.remove(j);
                                accountedFor = true;
                                break;
                            }
//                            else {
//                                newStarting1.add(startVal);
//                                newEnding1.add(endVal);
//                                newStyle1.add(c);
//
//                                break;
//
//                            }
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
}
