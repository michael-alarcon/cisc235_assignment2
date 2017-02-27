package cisc235_assignment2;

/**
 * @author Michael Alarcon Student ID - 10172841 I confirm that this submission
 * is my own work and is consistent with the Queen's regulations on Academic
 * Integrity.
 */
public class RedBlackTree {

    public RedBlackVertex root;
    public int totalRotations = 0;

    //Constructors
    public RedBlackTree() {
        this.root = new RedBlackVertex();
    }

    public RedBlackTree(RedBlackVertex node) {
        this.root = node;
    }

    public void insert(int value) {
        root = insert(root, value);
        root.setColour("Black");
    }

    /**
     * Inserts a new value to the red black tree
     *
     * @param tree tree the value is being inserted into
     * @param newValue the value being inserted
     * @return returns the updated tree
     */
    private RedBlackVertex insert(RedBlackVertex tree, int newValue) {
        if (tree.isLeaf) {
            tree = new RedBlackVertex(newValue);
            return tree;
        } else if (newValue <= tree.getValue()) {
            tree.left = insert(tree.left, newValue);
            if (tree.getColour().equals("Red")) {
                return tree;
            } else if (tree.left.getColour().equals("Red")) {
                if (tree.left.left.getColour().equals("Red")) {
                    return fixTree(tree, "ll");
                } else if (tree.left.right.getColour().equals("Red")) {
                    return fixTree(tree, "lr");
                } else {
                    return tree;
                }
            }
        } else {
            tree.right = insert(tree.right, newValue);
            if (tree.getColour().equals("Red")) {
                return tree;
            } else if (tree.right.getColour().equals("Red")) {
                if (tree.right.right.getColour().equals("Red")) {
                    return fixTree(tree, "rr");
                } else if (tree.right.left.getColour().equals("Red")) {
                    return fixTree(tree, "rl");
                } else {
                    return tree;
                }
            }
        }
        return tree;
    }

    /**
     * Fixes the red black tree depending on the situation.
     *
     * @param tree the tree to be fixed
     * @param fixType type of fixed needed to be implemented
     * @return the fixed tree
     */
    private RedBlackVertex fixTree(RedBlackVertex tree, String fixType) {
        RedBlackVertex grandChild;
        RedBlackVertex child;
        RedBlackVertex sibling;

        switch (fixType) {
            case "rr":
                child = tree.right;
                sibling = tree.left;
                if (sibling.getColour().equals("Red")) {
                    child.setColour("Black");
                    sibling.setColour("Black");
                    tree.setColour("Red");
                    return tree;
                } else {
                    totalRotations++;
                    tree.right = child.left;
                    child.left = tree;
                    child.setColour("Black");
                    tree.setColour("Red");
                    return child;
                }
            case "rl":
                child = tree.right;
                sibling = tree.left;
                if (sibling.getColour().equals("Red")) {
                    child.setColour("Black");
                    sibling.setColour("Black");
                    tree.setColour("Red");
                    return tree;
                } else {
                    totalRotations++;
                    grandChild = child.left;
                    child.left = grandChild.right;
                    tree.right = grandChild.left;
                    grandChild.left = tree;
                    grandChild.right = child;
                    grandChild.setColour("Black");
                    tree.setColour("Red");
                    return grandChild;
                }
            case "ll":
                child = tree.left;
                sibling = tree.right;
                if (sibling.getColour().equals("Red")) {
                    child.setColour("Black");
                    sibling.setColour("Black");
                    tree.setColour("Red");
                    return tree;
                } else {
                    totalRotations++;
                    tree.left = child.right;
                    child.right = tree;
                    child.setColour("Black");
                    tree.setColour("Red");
                    return child;
                }
            default:
                child = tree.left;
                sibling = tree.right;
                if (sibling.getColour().equals("Red")) {
                    child.setColour("Black");
                    sibling.setColour("Black");
                    tree.setColour("Red");
                    return tree;
                } else {
                    totalRotations++;
                    grandChild = child.right;
                    child.right = grandChild.left;
                    tree.left = grandChild.right;
                    grandChild.right = tree;
                    grandChild.left = child;
                    grandChild.setColour("Black");
                    tree.setColour("Red");
                    return grandChild;
                }
        }
    }

    public String searchPath(int value) {
        return searchPath(root, value);
    }

    /**
     * Searches for the path of a desired value.
     *
     * @param tree tree to be searched
     * @param value value to be searched
     * @return a string which displays the path to get to the value
     */
    private String searchPath(RedBlackVertex tree, int value) {
        if (tree == null) {
            return "";
        } else if (tree.getValue() == value) {
            return value + " (" + tree.getColour() + ")";
        } else if (value > tree.getValue()) {
            return tree.value + " (" + tree.getColour() + ")" + ", " + searchPath(tree.right, value);
        } else {
            return tree.value + " (" + tree.getColour() + ")" + ", " + searchPath(tree.left, value);
        }
    }

    public int totalDepth() {
        return totalDepth(root, 0);
    }

    /**
     * Returns the sum of the depths of all the values in the tree
     *
     * @param tree tree to be used
     * @param level the level of the value in the tree where the root is level 0
     * @return the total depth
     */
    private int totalDepth(RedBlackVertex tree, int level) {
        if (tree.isLeaf) {
            return 0;
        } else {
            return level + totalDepth(tree.left, level + 1) + totalDepth(tree.right, level + 1);
        }
    }

    public void resetRotations() {
        totalRotations = 0;
    }

    /**
     * Gets the total number of rotations
     *
     * @return total rotations.
     */
    public int getRotations() {
        return this.totalRotations;
    }

    /**
     * Inner class used only for the RedBlackTree class.
     */
    protected class RedBlackVertex {

        public Integer value;
        public RedBlackVertex left;
        public RedBlackVertex right;
        public String colour;
        public Boolean isLeaf;

        //Constructors
        public RedBlackVertex() {
            this.value = null;
            this.left = null;
            this.right = null;
            this.colour = "Black";
            this.isLeaf = true;
        }

        public RedBlackVertex(int value) {
            this.value = value;
            this.left = new RedBlackVertex();
            this.right = new RedBlackVertex();
            this.colour = "Red";
            this.isLeaf = false;
        }

        /**
         * Sets the colour of a vertex
         *
         * @param colour Red or Black
         */
        public void setColour(String colour) {
            this.colour = colour;
        }

        /**
         * Gets the value stored in the vertex
         *
         * @return the value
         */
        public int getValue() {
            return this.value;
        }

        /**
         * Gets the colour of the vertex
         *
         * @return Red or black
         */
        public String getColour() {
            return this.colour;
        }
    }
}
