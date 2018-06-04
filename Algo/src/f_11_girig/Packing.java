/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_11_girig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tiago
 */
public class Packing {
    
    public static List<Product> solve(int maxWeight, List<Product> products) {
        Collections.sort(products);
        List<Product> packedProducts = new ArrayList<>();
        int remaining = maxWeight;
        for (Product p : products) {
            while (remaining - p.weight >= 0) {
                packedProducts.add(p);
                remaining -= p.weight;
            }
        }
        return packedProducts;
    }
}
