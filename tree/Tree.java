package tree;

import java.util.Scanner;

public class Tree {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createTree();
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
}


class Node{

    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}