package app.trees.binary_tree;

/**
 * Created by 1 on 27.06.2017.
 */
public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree() {
    }

    public BinarySearchTree(int key) {
        super(key);
    }

    @Override
    public void insert(int key) {
        root = insert(root, key);
    }

    @Override
    protected Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (node.getKey() < key) {
            node.setRight(insert(node.getRight(), key));
        }
        if (node.getKey() > key) {
            node.setLeft(insert(node.getLeft(), key));
        }
        return node;
    }

    @Override
    protected Node find(Node node, int x) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == x) {
            return root;
        }
        if (root.getKey() < x) {
            return find(root.getLeft(), x);
        } else {
            return find(root.getRight(), x);
        }
    }

    @Override
    public Node find(int x) {
        return find(root, x);
    }
}
