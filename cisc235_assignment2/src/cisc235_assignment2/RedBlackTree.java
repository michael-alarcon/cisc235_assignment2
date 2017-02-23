/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisc235_assignment2;

/**
 *
 * @author Michael Alarcon
 */
public class RedBlackTree {

    RedBlackVertex root;

    public RedBlackTree() {
        this.root = null;
    }

    public RedBlackTree(RedBlackVertex node) {
        this.root = node;
    }

    protected void insert(int value) {
        root = insert(root, value);
        root.colour = "Black";
    }

    protected RedBlackVertex insert(RedBlackVertex tree, int newValue) {
        if (tree == null) {
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

    private RedBlackVertex fixTree(RedBlackVertex tree, String fixType) {
        RedBlackVertex child;
        RedBlackVertex sibling;
        if (fixType.equals("rr")) {
            child = tree.right;
            sibling = tree.left;
            if (sibling.getColour().equals("Red")) {
                child.setColour("Black");
                sibling.setColour("Black");
                tree.setColour("Red");
                return tree;
            } else {
                tree.right = child.left;
                child.left = tree;
                child.setColour("Black");
                tree.setColour("Red");
                return child;
            }
        } else if (fixType.equals("rl")) {
            child = tree.right;
            sibling = tree.left;
            if (sibling.getColour().equals("Red")) {
                child.setColour("Black");
                sibling.setColour("Black");
                tree.setColour("Red");
                return tree;
            } else {
                RedBlackVertex grandChild = child.left;
                child.left = grandChild.right;
                tree.right = grandChild.left;
                grandChild.left = tree;
                grandChild.right = child;
                grandChild.setColour("Black");
                tree.setColour("Red");
                return grandChild;
            }
        } else if (fixType.equals("ll")) {
            child = tree.left;
            sibling = tree.right;
            if (sibling.getColour().equals("Red")) {
                child.setColour("Black");
                sibling.setColour("Black");
                tree.setColour("Red");
                return tree;
            } else {
                tree.left = child.right;
                child.right = tree;
                child.setColour("Black");
                tree.setColour("Red");
                return child;
            }
        } else { 
            child = tree.left;
            sibling = tree.right;
            if (sibling.getColour().equals("Red")) {
                child.setColour("Black");
                sibling.setColour("Black");
                tree.setColour("Red");
                return tree;
            } else {
                RedBlackVertex grandChild = child.right;
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

    protected void totalDepth() {
        System.out.println(totalDepth(root, 0));
    }

    private int totalDepth(RedBlackVertex tree, int level) {
        if (tree == null) {
            return 0;
        } else {
            return level + totalDepth(tree.left, level + 1) + totalDepth(tree.right, level + 1);
        }
    }

    protected class RedBlackVertex {

        Integer value;
        RedBlackVertex left;
        RedBlackVertex right;
        String colour;
        Boolean isLeaf;

        public RedBlackVertex() {
            this.value = null;
            this.left = null;
//            this.left.isLeaf = true;
            this.right = null;
//            this.right.isLeaf = true;
            this.colour = "Black";
            this.isLeaf = true;
        }

        public RedBlackVertex(int value) {
            this.value = value;
            this.left = null;
//            this.left.isLeaf = true;
            this.right = null;
//            this.right.isLeaf = true;
            this.colour = "Red";
            this.isLeaf = false;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public int getValue() {
            if (this.isLeaf == true) {
                return -1;
            }
            return value;
        }

        public String getColour() {
            return colour;
        }
    }
}
