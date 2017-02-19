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
public class BinarySearchTree {

    BinaryTreeVertex root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(BinaryTreeVertex node) {
        this.root = node;
    }

    public void insert(int value) {
//        System.out.println(value + " current: " + root.value);
        root = insert(root, value);
    }

    public BinaryTreeVertex insert(BinaryTreeVertex tree, int newValue) {
        if (tree.value == null) {
            return new BinaryTreeVertex(newValue);
//            return tree;
        } else {
            if (newValue < tree.getValue()) {
                tree.left = insert(tree.left, newValue);
            } else {
                tree.right = insert(tree.right, newValue);
            }
            return tree;
        }
    }

    public void searchPath(int value) {
        System.out.println(searchPath(root, value));
    }

    private String searchPath(BinaryTreeVertex tree, int value) {
        if (tree.value == null) {
            return "";
        } else if (tree.getValue() == value) {
            return value + "";
        } else if (value > tree.getValue()) {
            return tree.value + ", " + searchPath(tree.right, value);
        } else {
            return tree.value + ", " + searchPath(tree.left, value);
        }
    }

    public int totalDepth(BinaryTreeVertex tree) {
        return 0;
    }
    
    class BinaryTreeVertex {

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
