import java.util.ArrayList;
import java.util.List;

public class AllPossibleSubString {

    public static void main(String[] args) {

        List<String> list = getAllPossibleSubString("aba");

        int count = 0;
        for(String str: list){
            if(isPalindrom(str)) count++;
        }
        System.out.println(count);
    }

    private static List<String> getAllPossibleSubString(String input) {

        List<String> list = new ArrayList<>();
        for(int i = 0; i< input.length(); i++){
            for(int j = i; j<input.length();j++){
                list.add(input.substring(i, j+1));
            }
        }

        return list;
    }

    public static boolean isPalindrom(String str){
        StringBuffer sbf = new StringBuffer(str);
        return str.endsWith(String.valueOf(sbf.reverse()));
    }

}
