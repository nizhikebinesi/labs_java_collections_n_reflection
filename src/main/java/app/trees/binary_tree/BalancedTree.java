package app.trees.binary_tree;

public abstract class BalancedTree extends BinarySearchTree {
    public BalancedTree() {
    }

    public BalancedTree(int key) {
        super(key);
    }

    protected static Node rightRotate(Node y) {
        Node
                x = y.getLeft(),
                t2 = x.getRight();
        x.setRight(y);
        y.setLeft(t2);
        return x;
    }

    protected static Node leftRotate(Node x) {
        Node
                y = x.getRight(),
                t2 = y.getLeft();
        y.setLeft(x);
        x.setRight(t2);
        return y;
    }

    protected static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.getLeft()) - height(root.getRight());
    }

    protected static Node rotateLeftThenRight(Node root) {
        root.setLeft(leftRotate(root.getLeft()));
        return rightRotate(root);
    }

    protected static Node rotateRightThenLeft(Node root) {
        root.setRight(rightRotate(root.getRight()));
        return leftRotate(root);
    }

    /*protected Node minValueNode(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }*/
}
