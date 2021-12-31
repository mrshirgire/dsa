package tree;

import java.util.*;

public class Tree {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Node root = createTree();
       /* printInOrder(root);

        System.out.println();
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(min(root));*/

        //printNodeLevelWise(root);
        printLeftView(root);
        printRightView(root);
        printTopView(root);
        printBottomView(root);

    }

    private static Node createTree() {

        Node node = null;

        System.out.println("Enter data");
        int data = scanner.nextInt();

        //base condition
        if(data == -1) return null;

        node = new Node(data);

        System.out.println("Enter data for left of "+data);
        node.left = createTree();

        System.out.println("Enter data for right of "+data);
        node.right =createTree();

        return node;
    }

    public static void printInOrder(Node root){

        if(root == null) return;

        printInOrder(root.left);
        System.out.print(root.data+"->");
        printInOrder(root.right);
    }

    public static void printPreOrder(Node root){

        if(root == null) return;

        System.out.println(root.data+"->");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public static void printPostOrder(Node root){

        if(root == null) return;

        printInOrder(root.left);
        printInOrder(root.right);
        System.out.println(root.data+"->");
    }

    public static int height(Node root){
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;

    }

    public static int size(Node root){

        if(root == null)
            return 0;

        return size(root.left) + size(root.right) +1;

    }

    public static int max(Node root){

        if(root == null)
            return Integer.MIN_VALUE;

        int leftMax = max(root.left);
        int max_ = Math.max(leftMax, root.data);
        return Math.max(max_, max(root.right));
    }

    public static int min(Node root){

        if(root == null)
            return Integer.MAX_VALUE;

        int leftMin = min(root.left);
        int min_ = Math.min(leftMin, root.data);
        return Math.min(min_, min(root.right));
    }

    public static void printNodeLevelWise(Node root) {
        Queue<Node> queue = new LinkedList<>();
        do{

            if (root == null)
                return;

            if (queue.isEmpty()){
                System.out.print(root.data+"->");
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            } else {
                root = queue.poll();
                System.out.print(root.data+"->");
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
        }while (!queue.isEmpty());

        System.out.println();
    }

    public static Map<Integer, Integer> getLeftViewMap(Node root, Map<Integer, Integer> levelMap, int level){

         if(root == null)
             return levelMap;

        levelMap.putIfAbsent(level, root.data);

        level+=1;
        getLeftViewMap(root.left, levelMap, level);
        getLeftViewMap(root.right, levelMap, level);

        return levelMap;
    }

    public static void printLeftView(Node root){

        Map<Integer, Integer> map = getLeftViewMap(root, new LinkedHashMap<>(), 0);
        map.forEach((k, v)-> {
            System.out.print(v+"->");
        });
        System.out.println();
    }

    public static Map<Integer, Integer> getRightViewMap(Node root, Map<Integer, Integer> levelMap, int level){

        if(root == null)
            return levelMap;

        levelMap.putIfAbsent(level, root.data);

        level+=1;
        getRightViewMap(root.right, levelMap, level);
        getRightViewMap(root.left, levelMap, level);

        return levelMap;
    }

    public static void printRightView(Node root){

        Map<Integer, Integer> map = getRightViewMap(root, new LinkedHashMap<>(), 0);
        map.forEach((k, v)-> {
            System.out.print(v+"->");
        });
        System.out.println();
    }

    public static Map<Integer, Integer> getTopViewMap(Node root, Map<Integer, Integer> levelMap, int level){

        if(root == null) return levelMap;

        levelMap.putIfAbsent(level, root.data);

        getTopViewMap(root.left, levelMap, level - 1);
        getTopViewMap(root.right, levelMap, level + 1);

        return levelMap;
    }

    public static void printTopView(Node root){

        Map<Integer, Integer> map = getTopViewMap(root, new LinkedHashMap<>(), 0);
        map.forEach((k, v)-> {
            System.out.print(v+"->");
        });
        System.out.println();
    }

    public static Map<Integer, Integer> getBottomViewMap(Node root, Map<Integer, Integer> levelMap, int level){

        if(root == null) return levelMap;

        levelMap.put(level, root.data);

        getBottomViewMap(root.left, levelMap, level - 1);
        getBottomViewMap(root.right, levelMap, level + 1);

        return levelMap;
    }

    public static void printBottomView(Node root){

        Map<Integer, Integer> map = getBottomViewMap(root, new LinkedHashMap<>(), 0);
        map.forEach((k, v)-> {
            System.out.print(v+"->");
        });
        System.out.println();
    }
}


class Node{

    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}