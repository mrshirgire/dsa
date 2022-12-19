package recursive;

import java.util.ArrayList;
import java.util.List;

public class SubSeq {

    private  static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        //subSeq("", "abc");

        //System.out.println(list.toString());
        System.out.println( subSeqReturn("", "abc"));

    }

    public static void subSeq(String p, String up){
        if(up.isEmpty()){
            list.add(p);
            System.out.println(p);
            return;
        }

        char c =  up.charAt(0);

        subSeq(p + c, up.substring(1));
        subSeq(p, up.substring(1));

    }

    public static List<String> subSeqReturn(String p, String up){
        if(up.isEmpty()){
            List list1 =  new ArrayList<String>();
            list1.add(p);

            return list1;
        }

        char c =  up.charAt(0);

        List<String> left = subSeqReturn(p + c, up.substring(1));
        List<String> right = subSeqReturn(p, up.substring(1));

        left.addAll(right);

        return left;

    }
}
