/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB17;

/**
 *
 * @author Jacob
 */
public class TestMain {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        System.out.println("size empty list: " + list.getSize());

        for (int i = 0; i < 10; i++) {
            list.add("e" + i);
        }

        System.out.println("size list 10 elements: " + list.getSize());
        System.out.println("element 5: " + list.get(5));
        System.out.println(list);
    }
}
