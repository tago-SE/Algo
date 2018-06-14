package TEN180607;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tiago
 */
public class AlgoTen180607 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        StringQueue myQ = new StringQueue();
        System.out.println(myQ.enqueue(null));
        for (int i = 0; i < 8; i++) {
            myQ.enqueue("s" + (i + 1));
        }
        while (!myQ.isEmpty()) {
            System.out.println(myQ.dequeue());
        }
        System.out.println(myQ.dequeue().equals(""));
        */
        
            BinarySearchTree<String> bst = new BinarySearchTree<>();
            System.out.println("max: " + bst.max());
            System.out.println("num leaves " + bst.numberOfLeaves());
            bst.add("L");
            bst.add("D");
            bst.add("F");
            bst.add("O");
            bst.add("R");
            bst.add("N");
            bst.add("P");
            bst.add("U");
            bst.add("C");
            bst.add("A");
            System.out.println("max: " + bst.max());
            System.out.println("number of leaves: " + bst.numberOfLeaves());
            bst = new BinarySearchTree<>();
            bst.add("L");
            bst.add("D");
            bst.add("B");
            bst.add("F");
            bst.add("E");
            bst.add("O");
            bst.add("N");
            bst.add("M");
            bst.add("S");
            System.out.println("2nd max: " + bst.secondMax());
    }
}
