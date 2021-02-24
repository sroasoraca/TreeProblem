/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageClasses;

/**
 *
 * @author Sebastian Roa S
 */
public class Node {

    int value;
    Node right;
    Node left;
    

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
    
}
