package tree;

import java.util.*;

// Bottom view of binary treee
//class BottomView{
//
//	static class Pair{
//		int horizantalDist;
//		TreeNode node;
//		Pair(int horizantalDist, TreeNode node){
//			this.horizantalDist = horizantalDist;
//			this.node = node;
//		}
//	}
//
//	Map<Integer,Integer> map = new TreeMap<>();
//
//	List<Integer> bottomView(TreeNode root){
//		Queue<Pair> q = new LinkedList<>();
//		q.offer(new Pair(0, node));
//
//		while(!q.isEmpty()){
//			Pair pair = q.poll();
//			int horizantalDist = pair.horizantalDist;
//			TreeNode node = pair.value;
//			map.put(horizantalDist, node.value);
//
//			if(node.left!=null){
//				q.offer(horizantalDist - 1, node.left);
//			}
//
//			if(node.right!=null){
//				q.offer(horizantalDist + 1, node.right);
//			}
//		}
//
//		List<Integer> ans = new ArrayList<>();
//		map.forEach(key, val){
//			ans.add(val);
//		}
//
//		return ans;
//	}
//}