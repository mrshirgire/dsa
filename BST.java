class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class BST {
    
    BSTNode root = null;

    public BSTNode add(BSTNode root, int data){
       
        if(root == null){
            BSTNode newNode = new BSTNode(data);
            root = newNode;
        }

        if(data < root.data){
            root.left = add(root.left, data);
            
        }
        
        if(data > root.data){
            root.right = add(root.right, data);    
        }

        return root;
    }

    public void add_(BSTNode root, int data){

        BSTNode prev = null;
        
        while(root!=null){
            prev = root;
        
            if(data < root.data){
                root = root.left;
            }
            
            if(data > root.data){
                root = root.right;    
            }
        }

        BSTNode newNode = new BSTNode(data);
        if(prev == null){
            prev = newNode;
        }else{
            if(data > prev.data)
                prev.right = newNode;
            if(data < prev.data)
                prev.left = newNode;
        }
        

    }

    public BSTNode leftTreeMax(BSTNode bstNode){
        
        while(bstNode.right!=null){
            bstNode = bstNode.right;
        }
        return bstNode;

    }


    public BSTNode delete(BSTNode root, int data){
        
        BSTNode temp = null;
        if(root == null){
            System.out.println("Element not found");
            return null;
        }else if(data > root.data)
            delete(root.right, data);
        else if(data < root.data)
            delete(root.left, data);
        else{
            temp = root;
            if(temp.left != null && temp.right != null){
                BSTNode leftTreeMax = leftTreeMax(temp.left);
                temp = leftTreeMax;
                temp.left = delete(temp.left, leftTreeMax.data);
            }else{
                if(temp.left != null)
                    temp = temp.left;
                else
                    temp = temp.right;
            }
        }

        return temp;
    }


    public int search(BSTNode root, int data){

        if(root == null)
            return 0;
        if(root.data == data)
            return 1;
        
        if(data > root.data)
            return search(root.right, data);
        if(data < root.data)
            return search(root.left, data);
        
        return 0;
    }
    public BSTNode searchIter(BSTNode root, int data){

        while(root != null){
            if(root.data == data)
                return root;
        
            if(data > root.data)
                root = root.right;
            else
                root = root.left;
        }

        return null;
    }


    public void printBSTInOrder(BSTNode root){
        
        if(root == null)
            return;

        printBSTInOrder(root.left);
        System.out.print(root.data+">");
        printBSTInOrder(root.right);
    }

    public void printBSTPreOrder(BSTNode root){
        
        if(root == null)
            return;
        
        System.out.print(root.data+">");
        printBSTPreOrder(root.left);
        printBSTPreOrder(root.right);
    }

    public void printBSTPostOrder(BSTNode root){
        
        if(root == null)
            return;
        
        printBSTPostOrder(root.left);
        printBSTPostOrder(root.right);
        System.out.print(root.data+">");
    }
    
}
