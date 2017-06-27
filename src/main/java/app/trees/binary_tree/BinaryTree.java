package app.trees.binary_tree;

import static app.trees.Constants.*;

public abstract class BinaryTree {
    protected class Node {
        int key;
        Node left, right;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    protected Node root;

    public BinaryTree() {
    }

    public BinaryTree(int key) {
        root = new Node(key);
    }

    private String inOrderTraversal(Node node) {
        if (node == null) {
            return NULL;
        }
        String
                left = inOrderTraversal(node.getLeft()),
                right = inOrderTraversal(node.getRight()),
                middle = "" + node.getKey();
        return (left.equals(NULL) ? NULL : left + SPACE) + middle + (right.equals(NULL) ? NULL : SPACE + right);
    }

    public String inOrderTraversal() {
        return inOrderTraversal(root);
    }

    private String preOrderTraversal(Node node) {
        if (node == null) {
            return NULL;
        }
        String
                left = preOrderTraversal(node.getLeft()),
                right = preOrderTraversal(node.getRight()),
                middle = "" + node.getKey();
        return middle + (left.equals(NULL) ? NULL : SPACE + left) + (right.equals(NULL) ? NULL : SPACE + right);
    }

    public String preOrderTraversal() {
        return preOrderTraversal(root);
    }

    private String postOrderTraversal(Node node) {
        if (node == null) {
            return NULL;
        }
        String
                left = postOrderTraversal(node.getLeft()),
                right = postOrderTraversal(node.getRight()),
                middle = "" + node.getKey();
        return (left.equals(NULL) ? NULL : left + SPACE) + (right.equals(NULL) ? NULL : right + SPACE) + middle;
    }

    public String postOrderTraversal() {
        return postOrderTraversal(root);
    }

    public abstract void insert(int key);

    protected abstract Node insert(Node node, int key);

    public abstract Node find(int x);

    protected abstract Node find(Node node, int x);
}
