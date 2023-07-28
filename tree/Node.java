package tree;

import java.util.*;
class Node1 {
    int val;
    Node1 left;
    Node1 right;
    Node1(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
class TUF {
    public static List < List < Integer >> zigzagLevelOrder(Node1 root) {
        Queue < Node1 > queue = new LinkedList<> ();
        List<List<Integer >> wrapList = new ArrayList<> ();
        if (root == null) return wrapList;
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList < Integer > subList = new ArrayList <> (size);
            for (int i = 0; i < size; i++) {
                Node1 currNode = queue.poll();
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null)  queue.offer(currNode.right);
                if (flag == true)
                    subList.add(currNode.val);
                else
                    subList.add(0,currNode.val);
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String args[]) {
        int i, j;
        Node1 root = new Node1(3);
        root.left = new Node1(9);
        root.right = new Node1(20);
        root.right.left = new Node1(15);
        root.right.right = new Node1(7);
        List < List < Integer >> ans;
        ans = zigzagLevelOrder(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}