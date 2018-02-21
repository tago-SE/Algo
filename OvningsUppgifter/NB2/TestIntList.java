/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB2;

/**
 *
 * @author Jacob
 */
public class TestIntList {

    public static void main(String[] args) {
        IntList listOfIntegers = new IntList(10);

        //Lägger till 5 i listan
        listOfIntegers.add(5);
        System.out.println(listOfIntegers.toString());

        //lägger till 1 och tar bort 5
        listOfIntegers.add(1);
        System.out.println(listOfIntegers.toString());
        listOfIntegers.remove(0);
        System.out.println(listOfIntegers.toString());

        //test to see if reallocates works 
        for (int i = 0; i < 15; i++) {
            listOfIntegers.add(i);
        }
        System.out.println(listOfIntegers.toString());

        System.out.println(listOfIntegers.set(4, 55)); //the item that gets replaced
        System.out.println(listOfIntegers.toString());

        System.out.println(listOfIntegers.get(4));

        System.out.println(listOfIntegers.indexOf(6));

        System.out.println("before adding: " + listOfIntegers.toString());
        listOfIntegers.add(4, 102);
        System.out.println(listOfIntegers.toString());
    }

}
