package tree;

import javax.swing.tree.TreeNode;

public class Tuple {

    Node node;
    int verticalIndex;

    Tuple(Node node, int verticalIndex){
        this.node = node;
        this.verticalIndex = verticalIndex;
    }

    public int getVerticalIndex(){
        return this.verticalIndex;
    }

    public Node getNode(){
        return this.node;
    }
}


