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
        root = insert(root, value);
    }

    private BinaryTreeVertex insert(BinaryTreeVertex tree, int newValue) {
        if (tree.value == null) {
            tree = new BinaryTreeVertex(newValue);
            return tree;
        } else if (tree.value > newValue) {
            return insert(tree.left, newValue);
        } else {
            return insert(tree.right, newValue);
        }
    }

    public void searchPath(int value) {
        System.out.println(searchPath(root, value));
    }

    private String searchPath(BinaryTreeVertex tree, int value) {
        if (tree.value == null) {
            return "";
        } else if (tree.value == value) {
            return value + "";
        } else if (value > tree.value) {
            return tree.value + ", " + searchPath(tree.right, value);
        } else {
            return tree.value + ", " + searchPath(tree.left, value);
        }
    }

    public int totalDepth(BinaryTreeVertex tree) {
        return 0;
    }
}
