package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC662 {

    public static int widthOfBinaryTree(TreeNode root) {


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int width = 0;
        while(!q.isEmpty()){

            int qSize = q.size();
            int minIndex = q.peek().index;
            int leftMostIndex = 0;
            int rightMostIndex = 0;
            for(int i = 0; i< qSize; i++) {

                Pair pair = q.poll();
                TreeNode currNode = pair.node;
                if( i == 0) leftMostIndex = pair.index;
                if(i == qSize -1 ) rightMostIndex  = pair.index;
                if(currNode.left != null){
                    int newIndex = (pair.index - minIndex) * 2 + 1;
                    q.add(new Pair(currNode.left, newIndex));
                }

                if(currNode.right != null){
                    int newIndex = (pair.index - minIndex) * 2 + 2;
                    q.add(new Pair(currNode.right, newIndex));
                }
            }


            int newWidth = rightMostIndex - leftMostIndex + 1;
            width = Math.max(width, newWidth);
        }

        return width;

    }

     static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

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
        TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        widthOfBinaryTree(root);

    }
}
