import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(permutation("", "abcd"));
    }

    public static List<String> permutation(String processed, String unProcessed){

        if(unProcessed.isEmpty()) {

            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char c = unProcessed.charAt(0);

        List<String> ans = new ArrayList<>();

        for(int i = 0; i <= processed.length(); i++){

            int processedLen = processed.length();
            String f = processed.substring(0, i);
            String s = processed.substring(i, processedLen);
            String processed_ = f + c + s;
            List<String> list = permutation(processed_, unProcessed.substring(1));
            ans.addAll(list);
        }

        return ans;

    }
}
