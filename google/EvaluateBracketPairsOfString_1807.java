package google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EvaluateBracketPairsOfString_1807 {
    public static void main(String[] args) {

//        List<List<String>> knowledge = new ArrayList<>();
//        List<String> firstList = new ArrayList<>();
//        firstList.add("name");
//        firstList.add("bob");
//
//        List<String> secondList = new ArrayList<>();
//        secondList.add("age");
//        secondList.add("two");
//
//        knowledge.add(firstList);
//        knowledge.add(secondList);

        //String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> firstList = new ArrayList<>();
        firstList.add("a");
        firstList.add("b");

        List<String> secondList = new ArrayList<>();
        secondList.add("b");
        secondList.add("a");

        knowledge.add(firstList);
        knowledge.add(secondList);



        String s = "(a)(b)";


        System.out.println(evaluate(s,knowledge));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();){

            if(s.charAt(i) == '('){
                int index = s.indexOf(")",i+1);
                if(index == i+1){
                    sb.append("?");
                }else{

                    String str = s.substring(i+1, index);
                    List<String> matchList = null;
                    String value = null;
                    for(List<String> list: knowledge){
                        if(list.get(0).equals(str)){
                            value = list.get(1);
                            break;
                        }
                    }

                    if(value!=null){
                        sb.append(value);
                    }else{
                        sb.append("?");
                    }
                }

                i = index + 1;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
