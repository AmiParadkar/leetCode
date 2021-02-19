package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQuery {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        //int count3 = 0;
        for (List<Integer> innerList : queries) {
            Integer operation = innerList.get(0);
            Integer value = innerList.get(1);
//            if (count3 == 998) {
//                System.out.println(" operation == "+ operation + "   value = " + value);
//                break;
//            }
            switch (operation) {

                case 1:
                    if (countMap.containsKey(value))
                        countMap.put(value, countMap.get(value) + 1);
                    else
                        countMap.put(value, 1);
                    break;
                case 2:
                    if (countMap.containsKey(value) && countMap.get(value) > 0)
                        countMap.put(value, countMap.get(value) - 1);
                    else
                        countMap.remove(value);
                    break;
                case 3:


//                    count3++;
//                    if ( count3 == 998) {
//                        System.out.println("Value == "+ value);
//                        System.out.println("------------------- Start count -----------" + count3);
//                        for (Integer map : countMap.keySet()) {
//                            System.out.println("key = " + map + "  value = " + countMap.get(map));
//                        }
//                        System.out.println("------------------- End count -----------" + count3);
//                    }
                    if (countMap.containsValue(value)) {

                        result.add(1);
                    } else {

                        result.add(0);
                    }

                    break;
            }
        }


        return result;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> queries = new ArrayList<>();

//        queries.add(buildInnerArr(1, 1));
//        queries.add(buildInnerArr(2, 2));
//        queries.add(buildInnerArr(3, 2));
//        queries.add(buildInnerArr(1, 1));
//        queries.add(buildInnerArr(1, 1));
//        queries.add(buildInnerArr(2, 1));
//        queries.add(buildInnerArr(3, 2));

//        queries.add(buildInnerArr(1, 5));
//        queries.add(buildInnerArr(1, 6));
//        queries.add(buildInnerArr(3, 2));
//        queries.add(buildInnerArr(1, 10));
//        queries.add(buildInnerArr(1, 10));
//        queries.add(buildInnerArr(1, 6));
//        queries.add(buildInnerArr(2, 5));
//        queries.add(buildInnerArr(3, 2));


//        queries.add(buildInnerArr(1, 3));
//        queries.add(buildInnerArr(2, 3));
//        queries.add(buildInnerArr(3, 2));
//        queries.add(buildInnerArr(1, 4));
//        queries.add(buildInnerArr(1, 5));
//        queries.add(buildInnerArr(1, 5));
//        queries.add(buildInnerArr(1, 4));
//        queries.add(buildInnerArr(3, 2));
//        queries.add(buildInnerArr(2, 4));
//        queries.add(buildInnerArr(3, 2));

        result = freqQuery(queries);
        for (Integer re : result) {
            System.out.println(re);
        }


        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/Sameer/ami/projects/src/hackerrank/Input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        // List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static List<Integer> buildInnerArr(Integer i1, Integer i2) {
        List<Integer> innerList = new ArrayList<>();
        innerList.add(i1);
        innerList.add(i2);
        return innerList;
    }
}
