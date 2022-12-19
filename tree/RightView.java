package tree;

import java.util.*;

class RightView{

	static Map<Integer, Integer> map = new LinkedHashMap<>();
      static class TreeNode {
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


	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		rightView(root, 0);
		List<Integer> ans = new LinkedList<>();
		map.forEach((key, value)->{
			ans.add(value);
		});


	}


	
	public static void rightView(TreeNode root, int level){
		if(root == null) return;
		
		if(!map.containsKey(level)){
			map.put(level, root.val);
		}
		
		if(root.right != null){
			rightView(root.right, level + 1);
		}
		
		if(root.left != null){
			rightView(root.left, level + 1);
		}
	}
	
	
}