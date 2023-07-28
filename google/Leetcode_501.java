package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode_501 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int[] findMode(TreeNode root) {

        if(root == null) return new int[] {};
        Map<Integer, Integer> map = new HashMap<>();
        while(root!=null){

            if(map.containsKey(root.val)){
                map.put(root.val, map.get(root.val) + 1);
            }else{
                map.put(root.val, 1);
            }

            if(root.left!=null){
                root = root.left;
            }else if( root.right!=null){
                root = root.right;
            }
        }

        int n = - 1;
        int cnt = 0;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>cnt){
                n = entry.getKey();
                cnt = entry.getValue();
            }
        }

        return new int[] {n};
    }

    public static void main(String[] args) {
        List<String> pairList = new ArrayList<>();
        pairList.stream().filter(str->str.equals("")).collect(Collectors.toList());
    }
}
