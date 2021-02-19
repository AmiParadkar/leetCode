package com.leetcode;
import java.util.HashMap;

public class ContestGoal {

        public static  String interpret(String command) {
            HashMap<String,String> map =  new HashMap<String, String>();
            map.put("G", "G");
            map.put("()","o");
            map.put("(al)", "al");
            char[] ch = command.toCharArray();
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i < ch.length){
                if(ch[i] == 'G'){
                    sb.append(map.get("G"));
                    i++;
                } else if(ch[i] == '('){
                    if(ch[i+1]== ')'){
                        sb.append(map.get("()"));
                        i+=2;
                    }else {
                        sb.append(map.get("(al)"));
                        i+=4;
                    }

                }

            }
            return sb.toString();

        }
    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
        System.out.println(interpret("G()()()()(al)"));
        System.out.println(interpret("(al)G(al)()()G"));

    }

}
