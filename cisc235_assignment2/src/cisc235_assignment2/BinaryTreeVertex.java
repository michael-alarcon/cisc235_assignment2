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
public class BinaryTreeVertex {

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
}
