/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB22;

/**
 *
 * @author Jacob
 */
public class MainBin {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);

        String postOrder = tree.postString();
        String inOrder = tree.toString();
        String preOrder = tree.preString();
        
        System.out.println("post: " + postOrder);
        System.out.println("pre: " + preOrder);
        System.out.println("inO: " + inOrder);
    }
}
