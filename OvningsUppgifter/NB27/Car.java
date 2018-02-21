/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB27;

/**
 *
 * @author Jacob
 */
public class Car implements Comparable<Car> {

    private String brand;
    private int year, miles;

    public Car() {
        this("", 0, 0);
    }

    public Car(String b, int y, int m) {
        brand = b;
        year = y;
        miles = m;
    }
    
    public int getYear() {
        return year;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public int getMiles() {
        return miles;
    }
    
    @Override
    public int compareTo(Car t) {
        return this.brand.compareTo(t.brand);
    }

    public String toString() {
        String res = "Brand: " + brand + ", year: " + year + ", miles: " + miles;
        return res;
    }
}
