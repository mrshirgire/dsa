package tree;

import java.util.Scanner;

public class TreeUtils {

    static Scanner scanner = new Scanner(System.in);
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode createTree() {

        TreeNode node = null;

        System.out.println("Enter data");
        int data = scanner.nextInt();

        //base condition
        if(data == -1) return null;

        node = new TreeNode(data, null, null);

        System.out.println("Enter data for left of "+data);
        node.left = createTree();

        System.out.println("Enter data for right of "+data);
        node.right =createTree();

        return node;
    }
}


