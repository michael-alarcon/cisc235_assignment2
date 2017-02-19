package cisc235_assignment2;

/**
 *
 * @author Michael Alarcon
 */
public class BinarySearchTree {

    BinaryTreeVertex root;

    protected BinarySearchTree() {
        this.root = null;
    }

    protected BinarySearchTree(BinaryTreeVertex node) {
        this.root = node;
    }

    protected void insert(int value) {
        root = insert(root, value);
    }

    private BinaryTreeVertex insert(BinaryTreeVertex tree, int newValue) {
        if (tree == null) {
            tree = new BinaryTreeVertex(newValue);
            return tree;
        } else {
            if (newValue <= tree.getValue()) {
                tree.left = insert(tree.left, newValue);
            } else {
                tree.right = insert(tree.right, newValue);
            }
            return tree;
        }
    }

    protected void searchPath(int value) {
        System.out.println(searchPath(root, value));
    }

    private String searchPath(BinaryTreeVertex tree, int value) {
        if (tree == null) {
            return "";
        } else if (tree.getValue() == value) {
            return value + "";
        } else if (value > tree.getValue()) {
            return tree.value + ", " + searchPath(tree.right, value);
        } else {
            return tree.value + ", " + searchPath(tree.left, value);
        }
    }

    protected void totalDepth() {
        System.out.println(totalDepth(root, 0));
    }
    
    public int totalDepth(BinaryTreeVertex tree, int level) {
        if (tree == null) {
            return 0;
        } else {
            return level + totalDepth(tree.left, level+1) + totalDepth(tree.right, level+1);
        }
    }
    
    protected class BinaryTreeVertex {

        Integer value;
        BinaryTreeVertex left;
        BinaryTreeVertex right;

        public BinaryTreeVertex() {
            this.value = null;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeVertex(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public int getValue() {
            return this.value;
        }
    }
}
