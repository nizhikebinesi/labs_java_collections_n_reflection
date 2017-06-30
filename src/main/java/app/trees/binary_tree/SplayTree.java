package app.trees.binary_tree;

// not good implementation
public class SplayTree extends BalancedTree {
    public SplayTree() {
    }

    public SplayTree(int key) {
        super(key);
    }

    protected static Node splay(Node root, int key) {
        if (root == null || root.getKey() == key) {
            return root;
        }
        if (root.getKey() > key) {
            if (root.getLeft() == null) {
                return root;
            }
            if (root.getLeft().getKey() > key) {
                root.getLeft().setLeft(splay(root.getLeft().getLeft(), key));
                root = rightRotate(root);
            } else if (root.getLeft().getKey() < key) {
                root.getLeft().setRight(splay(root.getLeft().getRight(), key));
                if (root.getLeft().getRight() != null) {
                    root.setLeft(leftRotate(root.getLeft()));
                }
            }
            return root.getLeft() == null ? root : rightRotate(root);
        }

        if (root.getRight() == null) {
            return root;
        }
        if (root.getRight().getKey() > key) {
            root.getRight().setLeft(splay(root.getRight().getLeft(), key));
            if (root.getRight().getLeft() != null) {
                root.setRight(rightRotate(root.getRight()));
            }
        } else if (root.getRight().getKey() < key) {
            root.getRight().setRight(splay(root.getRight().getLeft(), key));
            root = leftRotate(root);
        }
        //if (root != null)
        return root.getRight() != null ? root : /*left*/rightRotate(root);
        //return null;
    }

    @Override
    protected Node find(Node node, int x) {
        return splay(root, x);
    }

    @Override
    public Node find(int x) {
        return find(root, x);
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
        node = splay(node, key);
        if (node.getKey() == key) {
            return node;
        }
        Node tmp = new Node(key);
        if (node.getKey() > key) {
            tmp.setRight(node);
            tmp.setLeft(node.getLeft());
            node.setLeft(null);
        } else {
            tmp.setLeft(root);
            tmp.setRight(root.getRight());
            root.setRight(null);
        }
        return tmp;
    }

    @Override
    public void remove(int key) {
        root = remove(root, key);
    }

    @Override
    protected Node remove(Node root, int key) {
        Node tmp = null;
        if (root == null) {
            return root;
        }
        root = splay(root, key);
        if (key != root.getKey()) {
            return root;
        }
        if (root.getLeft() == null) {
            tmp = root;
            root = root.getRight();
        } else {
            tmp = root;
            root = splay(root.getLeft(), key);
            root.setRight(tmp.getRight());
        }

        return root;
    }
}
