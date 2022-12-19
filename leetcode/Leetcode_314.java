package leetcode;
import java.util.*;

public class Leetcode_314 {

    public static List<List<Integer>> verticalOrder(TreeNode root) {

        Map<Integer, Map<Integer, List<Integer>>> verticalLevelMap = new TreeMap<>();
        traverseTree(root, 0, 0, verticalLevelMap);
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer,  List<Integer>>> verticalEntry: verticalLevelMap.entrySet()){

            List<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> horizontalEntry: verticalEntry.getValue().entrySet()){
                list.addAll(horizontalEntry.getValue());
            }

            ans.add(list);
        }

        List<List<Integer>> output = new ArrayList<>();
        verticalLevelMap.forEach((verticalIndex, horizontalMap)->{

            List<Integer> newList = new ArrayList<>();
            horizontalMap.forEach((horizontalIndex, list)->{
                newList.addAll(list);
            });
            output.add(newList);
        });

        return ans;

    }

    public static void traverseTree(TreeNode root, int verticalIndex, int horizontalIndex, Map<Integer, Map<Integer, List<Integer>>> verticalLevelMap){

        if(root == null) return;

        if(!verticalLevelMap.containsKey(verticalIndex)){
            Map<Integer, List<Integer>> horizontalLevelMap = new LinkedHashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            horizontalLevelMap.put(horizontalIndex, list);
            verticalLevelMap.put(verticalIndex, horizontalLevelMap);
        }else{

            Map<Integer, List<Integer>> horizontalLevelMap = verticalLevelMap.get(verticalIndex);
            List<Integer> list = horizontalLevelMap.get(horizontalIndex);
            if(list == null){
                list  = new ArrayList<>();
            }
            list.add(root.val);

            horizontalLevelMap.put(horizontalIndex, list);
            verticalLevelMap.put(verticalIndex, horizontalLevelMap);
        }

        traverseTree(root.left,  verticalIndex - 1,  horizontalIndex + 1, verticalLevelMap);
        traverseTree(root.right,  verticalIndex + 1,  horizontalIndex + 1, verticalLevelMap);

        return;
    }
    
      public static class TreeNode {
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
    static Scanner scanner = new Scanner(System.in);
    private static TreeNode createTree() {

        TreeNode node = null;

        System.out.println("Enter data");
        int data = scanner.nextInt();

        //base condition
        if(data == -1) return null;

        node = new TreeNode(data);

        System.out.println("Enter data for left of "+data);
        node.left = createTree();

        System.out.println("Enter data for right of "+data);
        node.right =createTree();

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        List<List<Integer>> ans = verticalOrder(root);
        System.out.println(ans);
    }
}
