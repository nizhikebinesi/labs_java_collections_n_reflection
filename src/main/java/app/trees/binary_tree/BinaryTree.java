package app.trees.binary_tree;

import static app.trees.Constants.*;
import static app.trees.Helper.*;

public abstract class BinaryTree {
    protected class Node {
        private int key, countOfDescendant;
        private int height = 1;
        private boolean actualCountOfDescendant = true;
        private Node left, right;

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
            height = max(height(left), height(right)) + 1;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
            height = max(height(left), height(right)) + 1;
        }

        public int getCountOfDescendant() {
            if (actualCountOfDescendant) {
                return countOfDescendant;
            }
            countOfDescendant = (left != null ? 1 : 0) + (right != null ? 1 : 0);
            return countOfDescendant;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (key != node.key) return false;
            if (countOfDescendant != node.countOfDescendant) return false;
            if (!left.equals(node.left)) return false;
            return right.equals(node.right);
        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + countOfDescendant;
            result = 31 * result + left.hashCode();
            result = 31 * result + right.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", countOfDescendant=" + countOfDescendant +
                    ", height=" + height +
                    ", actualCountOfDescendant=" + actualCountOfDescendant +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
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

    public abstract void remove(int key);

    protected abstract Node remove(Node root, int key);

    public Node getRoot() {
        return root;
    }

    public int height() {
        return height(root);
    }

    protected static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }
}
