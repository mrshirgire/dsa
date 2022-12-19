import java.util.ArrayList;
import java.util.List;

public class ComPer {


    public static List<String> ans = new ArrayList<>();
    public static void main(String[] args) {


        fun("", "abc");
        System.out.println(ans);

    }

    public static void fun(String process, String unprocessed){

        if(unprocessed.isEmpty()){
            ans.add(process);
            return;
        }


        char c = unprocessed.charAt(0);

        fun(process + c  , unprocessed.substring(1));
        fun(process, unprocessed.substring(1));





//        List<String> left = fun(process + c  , unprocessed.substring(1));
//        List<String> right = fun(process, unprocessed.substring(1));

        return;


    }

}
