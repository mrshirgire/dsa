package tree;

import java.util.*;

// Top view of binary treee
class TopView{
	
	static class Pair{
		int horizontalDist;
		Node node;
		Pair(int horizontalDist, Node node){
			this.horizontalDist = horizontalDist;
			this.node = node;
		}
	}
	
	Map<Integer,Integer> map = new TreeMap<>();
	
	List<Integer> topView(Node root){

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, root));
		while(!q.isEmpty()){
			Pair pair = q.poll();
			int horizontalDist = pair.horizontalDist;
			Node node = pair.node;
			if(!map.containsKey(horizontalDist)) {
				map.put(horizontalDist, node.data);
			}
			
			if(node.left!=null){
				q.offer( new Pair(horizontalDist - 1, node.left));
			}
			
			if(node.right!=null){
				q.offer(new Pair(horizontalDist + 1, node.right));
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		map.forEach((key,val)->ans.add(val));
		return ans;
	}
}