/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB23;

/**
 *
 * @author Jacob
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hej!");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);

        System.out.println(tree.numerOfLeaves());
        
    }
}
