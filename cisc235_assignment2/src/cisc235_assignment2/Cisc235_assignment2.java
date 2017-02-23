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
public class Cisc235_assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        BinarySearchTree sTree = new BinarySearchTree();
//        
//        sTree.insert(6);
//        sTree.insert(10);
//        sTree.insert(8);
//        sTree.insert(3);
//        sTree.insert(20);
//        sTree.searchPath(8);
//        sTree.totalDepth();
        
        RedBlackTree rbTree = new RedBlackTree();
        
        rbTree.insert(6);
        rbTree.insert(1);
        rbTree.insert(10);
        rbTree.insert(20);
        rbTree.insert(30);
        System.out.println(rbTree.root.value + " " + rbTree.root.isLeaf + " " + rbTree.root.colour);
        System.out.println(rbTree.root.left.value + " " + rbTree.root.left.isLeaf + " " + rbTree.root.left.colour);
        System.out.println(rbTree.root.right.value + " " + rbTree.root.right.isLeaf + " " + rbTree.root.right.colour);
        System.out.println(rbTree.root.right.right.value + " " + rbTree.root.right.right.isLeaf + " " + rbTree.root.right.right.colour);
        System.out.println(rbTree.root.right.left.value + " " + rbTree.root.right.left.isLeaf + " " + rbTree.root.right.left.colour);
        rbTree.searchPath(20);
        rbTree.totalDepth();
    }
    
}
