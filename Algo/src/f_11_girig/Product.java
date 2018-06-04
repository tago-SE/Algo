/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_11_girig;

/**
 *
 * @author tiago
 */
public class Product implements Comparable<Product> {
    
    public int weight, price;
    public Double priceRatio;
    
    public Product(int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.priceRatio = (double) price/weight;
    }

    @Override
    public int compareTo(Product o) {
        return o.priceRatio.compareTo(this.priceRatio);
    }

    @Override
    public String toString() {
        return "Product{" + "weight=" + weight + ", price=" + price + ", priceRatio=" + priceRatio + '}';
    }
}
