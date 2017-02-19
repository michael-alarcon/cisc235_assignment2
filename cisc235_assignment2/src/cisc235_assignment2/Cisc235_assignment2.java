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
        BinaryTreeVertex a = new BinaryTreeVertex();
        BinarySearchTree x = new BinarySearchTree(a);
        
        x.insert(6);
        x.insert(10);
        x.insert(8);
        x.searchPath(8);
    }
    
}
