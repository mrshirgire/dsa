package tree;


import java.util.*;

public class Tree {

    static Scanner scanner = new Scanner(System.in);
    static int max = 0;
    public static void main(String[] args) {
        Node root = createTree();
       /* printInOrder(root);

        System.out.println();
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(min(root));*/

        //printNodeLevelWise(root);
        List<Integer> ans = iterativeInOrder(root);
        System.out.println(ans);
        printLeftView(root);
        printRightView(root);
        printTopView(root);
        printBottomView(root);
        int diameter = longestPath(root);
        System.out.println("diameter: "+diameter);


    }

    static ArrayList<Integer> iterativeInOrder(Node root) {

        Stack<Node> st = new Stack<>();
        st.push(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            Node currNode = st.peek();
            if(currNode.left != null) {
                st.push(currNode.left);
            }else{
                ans.add(st.pop().data);
                if(currNode.right != null) st.push(currNode.right);
            }
        }

        return ans;
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

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1+ Math.max(leftHeight, rightHeight);

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

        getRightViewMap(root.right, levelMap, level + 1);
        getRightViewMap(root.left, levelMap, level + 1);

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

    private boolean isSymmetric(Node root){

        return root == null || isSymmetricUtil(root.left, root.right);
    }

    private boolean isSymmetricUtil(Node leftNode, Node rightNode){

        if( leftNode == null || rightNode == null)
            return leftNode == rightNode;

        if(leftNode.data != rightNode.data){
            return false;
        }

        boolean check1 = isSymmetricUtil(leftNode.left, rightNode.right);
        boolean check2 = isSymmetricUtil(leftNode.right, rightNode.left);

        return check1 && check2;

    }


    public List<List<Integer>> zigzagTraversal(Node node){

        int riverseFlag = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        List<List<Integer>> ans = new LinkedList<>();
        while(!q.isEmpty()){

            int qSize = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < qSize; i++){

                Node currentNode = q.poll();
                subList.add(currentNode.data);
                if(currentNode.left != null) q.add(currentNode.left);
                if(currentNode.right != null) q.add(currentNode.right);
            }

            boolean b = riverseFlag == 1 ? ans.add(reverseList(subList)) : ans.add(subList);
        }

        return ans;
    }


    private List<Integer> reverseList(List<Integer> list){

     return null;
    }



    private static List bottomView(Node root){


        Queue<Tuple> tupleQueue = new LinkedList<>();
        Map<Integer, Integer> vertivalMap = new TreeMap<>();
        tupleQueue.offer(new Tuple(root, 0));

        while(!tupleQueue.isEmpty()){

            Tuple tuple = tupleQueue.peek();

            Node node = tuple.getNode();
            int verticalIndex = tuple.getVeritialIndex();

            if(node.left != null){
                tupleQueue.offer(new Tuple(node.left, verticalIndex - 1));
            }

            if(node.right != null){
                tupleQueue.offer(new Tuple(node.right, verticalIndex + 1));
            }

            vertivalMap.put(verticalIndex, node.data);
            tupleQueue.poll();

        }

        List<Integer> ans = new LinkedList<>();
        vertivalMap.forEach((key, val)->{
            ans.add(val);
        });

        return ans;

    }


    public static void printBottomView(Node root){

        Map<Integer, Integer> map = getBottomViewMap(root, new LinkedHashMap<>(), 0);
        map.forEach((k, v)-> {
            System.out.print(v+"->");
        });
        System.out.println();
    }


    public Node convertToDLL(Node root, Node head, Node prev){

        if(root == null)
            return  head;

        convertToDLL(root.left, head, prev);
        if(prev == null){
            head = root;
        }else {
            root.left = prev;
            prev.right = root;

        }
        prev = root;

        return convertToDLL(root.right, head, prev);
    }

    static int longestPath = 0;
    public static int longestPath(Node root){

        if(root == null) return 0;

        int leftHeight = longestPath(root.left);
        int rightHeight = longestPath(root.right);

        int newPath = leftHeight + rightHeight;
        longestPath = newPath > longestPath? newPath: longestPath;

        return 1 + Math.max(leftHeight, rightHeight);

    }

    static int maxSum = 0;
    public static int maxSumPath(Node node){
        if(node == null) return 0;

        int leftSum = maxSumPath(node.left);
        int rightSum = maxSumPath(node.right);

        int newSum = node.data + leftSum + rightSum;
        maxSum = Math.max(maxSum,newSum);

        return node.data + Math.max(leftSum, rightSum);

    }

    public static boolean isBalance = true;
    public static int isBalance(Node root){

        if(root == null)
            return 0;

        int leftHeight = isBalance(root.left);
        int rightHeight = isBalance(root.right);
        if(leftHeight == -1 || rightHeight == -1
            || Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    List<Integer> path = new LinkedList<>();
    private boolean rootToNodePath(TreeNode node, int target){

        if(node == null) return false;

        path.add(node.val);
        if(node.val == target){
            return true;
        }

        path.add(node.val);
        boolean left = rootToNodePath(node.left, target);
        if(left) return left;
        boolean right = rootToNodePath(node.right, target);
        if(right) return right;

        path.remove(node.val);
        return false;
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