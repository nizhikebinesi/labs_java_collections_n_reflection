package app.trees.binary_tree;

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

    @Override
    public void remove(int key) {
        root = remove(root, key);
        //Node parent = root, current = root;
        //remove(parent, current, key);
    }

    @Override
    protected Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (root.getKey() < key) {
            root.setLeft(remove(root.getLeft(), key));
        } else if (root.getKey() > key) {
            root.setRight(remove(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setKey(minValueForRoot(root.getRight()));
            root.setRight(remove(root.getRight(), root.getKey()));
        }
        return root;
    }

    protected int minValueForRoot(Node root) {
        int minVal = root.getKey();
        while (root.getLeft() != null) {
            minVal = root.getLeft().getKey();
            root = root.getLeft();
        }
        return minVal;
    }

    /*@Override
    protected Node remove(Node parent, Node current, int key) {
        if (parent == null) {
            return parent;
        }
        boolean isLeftChild = true;
        while (current.getKey() != key) {
            parent = current;
            if (key < current.getKey()) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return root;
            }
        }
        // if count of descendants == 0
        if (
                current.getLeft() == null && current.getRight() == null
                ) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // if count of descendants == 1
        else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        }
        else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        // if count of descendants == 2
        else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
        }
        return parent;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode, successor = delNode, current = delNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != delNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(delNode.getRight());
        }
        return successor;
    }*/
}
