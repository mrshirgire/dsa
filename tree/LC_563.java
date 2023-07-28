package tree;

public class LC_563 {
    static int tilt = 0;
    public static int findTilt(TreeUtils.TreeNode  root) {


        fun(root);
        return tilt;
    }

    public static int fun(TreeUtils.TreeNode  root){

        if(root == null) return 0;

        int left = fun(root.left );
        int right = fun(root.right );

        tilt = tilt + Math.abs(left - right);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeUtils.TreeNode root = TreeUtils.createTree();
        int ans = findTilt(root);
        System.out.println(ans);
    }
}
