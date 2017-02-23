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
            } else {
                if (tree.left.getColour().equals("Red")) {
                    if (tree.left.left.getColour().equals("Red")) {
                        return fixTree(tree, "ll");
                    } else if (tree.left.right.getColour().equals("Red")) {
                        return fixTree(tree, "lr");
                    } else {
                        return tree;
                    }
                }
            }
        } else {
            tree.right = insert(tree.right, newValue);
            if (tree.getColour().equals("Red")) {
                return tree;
            } else {
                if (tree.right.getColour().equals("Red")) {
                    if (tree.right.right.getColour().equals("Red")) {
                        return fixTree(tree, "rr");
                    } else if (tree.right.left.getColour().equals("Red")) {
                        return fixTree(tree, "rl");
                    } else {
                        return tree;
                    }
                }
            }
        }
        return tree;
    }
    
    private RedBlackVertex fixTree(RedBlackVertex tree, String fixType) {
        return tree;
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

        public RedBlackVertex() {
            this.value = null;
            this.left = null;
            this.right = null;
            this.colour = "Red";
        }

        public RedBlackVertex(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.colour = "Red";
        }

        public int getValue() {
            return value;
        }
        
        public String getColour() {
            return colour;
        }
    }
}