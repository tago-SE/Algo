/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB27;

import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class CompareCar extends Car implements Comperator<Car> {

    public CompareCar() {

    }

    @Override
    public int compareTo(Car c1, Car c2) {
        if (c1.getYear() == c2.getYear()) {
            return 0;
        } else if (c1.getYear() < c2.getYear()) {
            return -1;
        } else {
            return 1;
        }
    }

    public void sort(Car[] arrayCar) {
        int minIndex = 0;

        for (int i = 0; i < arrayCar.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arrayCar.length; j++) {
                if (compareTo(arrayCar[j], arrayCar[minIndex]) == -1) {
                    minIndex = j;
                }
            }
            Car tmpCar = arrayCar[i];
            arrayCar[i] = arrayCar[minIndex];
            arrayCar[minIndex] = tmpCar;
        }
    }
}
