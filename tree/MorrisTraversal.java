package tree;

public class MorrisTraversal {

    public static void inOrder(TreeUtils.TreeNode root){

        TreeUtils.TreeNode currNode  = root;
        if(currNode.left == null){
            System.out.println(currNode.val);
            inOrder(currNode.right);
        }else{
            TreeUtils.TreeNode rightMostNode = rightMost(currNode.left, currNode);

            if(rightMostNode.right == null){
                rightMostNode.right = currNode;
                inOrder(currNode.left);
            }else{
                rightMostNode.right = null;
                inOrder(currNode.right);
            }
        }
    }

    public static TreeUtils.TreeNode rightMost(TreeUtils.TreeNode node, TreeUtils.TreeNode currentNode){

        while(node.right !=null && node.right!=currentNode){
            node = node.right;
        }

        return node;
    }

    public static void main(String[] args) {
        TreeUtils.TreeNode root = TreeUtils.createTree();
        inOrder(root);

    }


}
