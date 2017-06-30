package app.trees.binary_tree;

import static app.trees.Helper.*;

public class AVLTree extends BalancedTree {
    public AVLTree() {
    }

    public AVLTree(int key) {
        super(key);
    }

    @Override
    public void insert(int key) {
        root = insert(root, key);
        //super.insert(key);
    }

    @Override
    protected Node insert(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }
        if (node.getKey() > key) {
            node.setLeft(insert(node.getLeft(), key));
        } else if (node.getKey() < key) {
            node.setRight(insert(node.getRight(), key));
        } else {
            return node;
        }
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        int balance = getBalance(node);
        if (balance > 1 && key < node.getLeft().getKey()) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.getRight().getKey()) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.getLeft().getKey()) {
            return rotateLeftThenRight(node);
        }
        if (balance < -1 && key < node.getRight().getKey()) {
            return rotateRightThenLeft(node);
        }
        //node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;
    }

    @Override
    public void remove(int key) {
        root = remove(root, key);
    }

    @Override
    protected Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (root.getKey() > key) {
            root.setLeft(remove(root.getLeft(), key));
        } else if (root.getKey() < key) {
            root.setRight(remove(root.getRight(), key));
        } else {
            if (root.getLeft() == null || root.getRight() == null) {
                Node tmp = null;
                if (tmp == root.getLeft()) {
                    tmp = root.getRight();
                } else {
                    tmp = root.getLeft();
                }
                root = tmp;
                /*if (tmp == null) {
                    tmp = root;
                    root = null;
                } else {
                    root = tmp;
                }*/
            } else {
                Node tmp = minValueNode(root.getRight());
                root.setKey(tmp.getKey());
                root.setRight(remove(root.getRight(), tmp.getKey()));
                /*int val = minValueForRoot(root);
                root.setKey(val);
                root.setHeight(0);
                root.setRight(remove(root.getRight(), val));*/
            }
        }
        if (root == null) {
            return root;
        }
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.getLeft()) >= 0) {
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.getRight()) <= 0) {
            return leftRotate(root);
        }
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            return rotateLeftThenRight(root);
        }
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            return rotateRightThenLeft(root);
        }

        //root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);
        return root;
    }
}
