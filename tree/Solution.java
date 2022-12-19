package tree;

import java.util.*;

class TreeNode {
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
class Solution {
    Map<Integer, Map<Integer, List<Integer>>> verticalLevelMap = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        

          traverseTree(root, 0, 0);
          List<List<Integer>> ans = new ArrayList<>();
          for(Map.Entry<Integer, Map<Integer,  List<Integer>>> verticalEntry: verticalLevelMap.entrySet()){

              List<Integer> list = new ArrayList<>();
              for(Map.Entry<Integer, List<Integer>> horizontalEntry: verticalEntry.getValue().entrySet()){
                  list.addAll(horizontalEntry.getValue());
              }

              ans.add(list);
          }  

            return ans;

    }

    public void traverseTree(TreeNode root, int verticalIndex, int horizontalIndex){
        
        if(root == null) return;

        if(!verticalLevelMap.containsKey(verticalIndex)){
            Map<Integer, List<Integer>> horizontalLevelMap = new LinkedHashMap<>();
            horizontalLevelMap.put(horizontalIndex, new ArrayList<>(root.val));
            verticalLevelMap.put(verticalIndex, horizontalLevelMap);
        }else{

            Map<Integer, List<Integer>> horizontalLevelMap = verticalLevelMap.get(verticalIndex);
            List<Integer> list = horizontalLevelMap.get(horizontalIndex);
            list.add(root.val);
            horizontalLevelMap.put(horizontalIndex, list);
            verticalLevelMap.put(verticalIndex, horizontalLevelMap);
        }

        traverseTree(root.left,  verticalIndex - 1,  horizontalIndex + 1);
        traverseTree(root.right,  verticalIndex + 1,  horizontalIndex + 1);

        return;
    }


}