/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_11_girig;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class ChangeTest {
    
    public ChangeTest() {
    }

    //@Test
    public void testSolve_77() {
        int[] change = {50, 20, 5, 1, 1};
        int startSum = 77;
        int[] sol = Change.solve(startSum, change);
        int endSum = 0;
        for (int i = 0; i < change.length; i++) {
            System.out.println("(" + change[i] + "): "+ sol[i]);
            endSum += (change[i]*sol[i]);
        }
        assertEquals(startSum, endSum);
    }
    
   // @Test
    public void testSolve_30() {
        int[] change = {1, 25, 10};
        int startSum = 30;
        int[] sol = Change.solve(startSum, change);
        int endSum = 0;
        for (int i = 0; i < change.length; i++) {
            System.out.println("(" + change[i] + "): "+ sol[i]);
            endSum += (change[i]*sol[i]);
        }
        assertEquals(startSum, endSum);
    }
    
    //@Test
    public void testSolve_1000() {
        System.out.println("1000:");
        int[] change = {1000, 500, 100, 50, 20, 10, 5, 1};
        int startSum = 789;
        int[] sol = Change.solve(startSum, change);
        int endSum = 0;
        for (int i = 0; i < change.length; i++) {
            System.out.println("(" + change[i] + "): "+ sol[i]);
            endSum += (change[i]*sol[i]);
        }
        assertEquals(startSum, endSum);
    }
    
    @Test
    public void testChange() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(10, 100));
        products.add(new Product(2, 50));
        List<Product> packedProducts = Packing.solve(25, products);
        System.out.println("Packed: ");
        int totPrice = 0;
        int totWeight = 0;
        for (Product p : packedProducts) {
            totPrice += p.price;
            totWeight += p.weight;
            System.out.println(p.toString());
        }
        System.out.println("totPrice " + totPrice + ", totWeight " + totWeight);
    }
}
