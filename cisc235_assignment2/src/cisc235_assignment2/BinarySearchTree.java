package cisc235_assignment2;

/**
 * @author Michael Alarcon Student ID - 10172841 I confirm that this submission
 * is my own work and is consistent with the Queen's regulations on Academic
 * Integrity.
 */
public class BinarySearchTree {

    private BinaryTreeVertex root;

    //Constructors
    protected BinarySearchTree() {
        this.root = null;
    }

    protected BinarySearchTree(BinaryTreeVertex node) {
        this.root = node;
    }

    protected void insert(int value) {
        root = insert(root, value);
    }

    /**
     * Inserts a new value to the red black tree
     * @param tree tree the value is being inserted into
     * @param newValue the value being inserted
     * @return returns the updated tree
     */
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

    protected String searchPath(int value) {
        return searchPath(root, value);
    }

    /**
     * Searches for the path of a desired value.
     * @param tree tree to be searched
     * @param value value to be searched
     * @return a string which displays the path to get to the value
     */
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

    protected int totalDepth() {
        return totalDepth(root, 0);
    }
    
    /**
     * Returns the sum of the depths of all the values in the tree
     * @param tree tree to be used
     * @param level the level of the value in the tree where the root is level 0
     * @return the total depth
     */
    public int totalDepth(BinaryTreeVertex tree, int level) {
        if (tree == null) {
            return 0;
        } else {
            return level + totalDepth(tree.left, level+1) + totalDepth(tree.right, level+1);
        }
    }
    
    /**
     * Inner class used only by the BinarySearchTree class
     */
    protected class BinaryTreeVertex {

        private Integer value;
        private BinaryTreeVertex left;
        private BinaryTreeVertex right;

        //Constructors
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

        /**
         * Gets the value stored in the vertex
         * @return the value
         */
        public int getValue() {
            return this.value;
        }
    }
}
