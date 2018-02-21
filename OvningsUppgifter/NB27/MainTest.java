/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Jacob
 */
public class MainTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Car c1 = new Car("Audi", 1992, 10);
        Car c2 = new Car("Audi", 2000, 10);
        System.out.println(c1.compareTo(c2));

        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Jacob\\OneDrive\\Dokument\\Skolan\\Diskret Matematik\\Laborationer\\Delad mapp\\AlgoritmFörelasning1\\src\\NB27\\car.txt"));
        int cars = Integer.parseInt(in.readLine());

        Car[] carArr = new Car[cars];
        for (int i = 0; i < carArr.length; i++) {
            String[] res = in.readLine().split(",");
            carArr[i] = new Car(res[0], Integer.parseInt(res[1]), Integer.parseInt(res[2]));
        }
        
        in.close();

        System.out.println("Unsorted:\n" + toString(carArr));
        Arrays.sort(carArr);
        System.out.println("\nSorted:\n" + toString(carArr));
        writeToFile("carWrite.txt", carArr);

        //Second test
        CompareCar comp = new CompareCar();
        comp.sort(carArr);
        System.out.println("\nSorted by year:\n" + toString(carArr));
        writeToFile("carYear.txt", carArr);
    }

    public static void writeToFile(String fileEnd, Car[] arr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Jacob\\OneDrive\\Dokument\\Skolan\\Diskret Matematik\\Laborationer\\Delad mapp\\AlgoritmFörelasning1\\src\\NB27\\" + fileEnd));
        System.out.println(arr.length);
        writer.write(String.valueOf(arr.length) + "\n");
        
        String newC = null;
        for (int i = 0; i < arr.length; i++) {
            newC = arr[i].getBrand() + "," + arr[i].getYear() + "," + arr[i].getMiles() + "\n";
            writer.write(newC);
        }
        writer.close();
    }

    public static String toString(Car[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i] + "\n");
        }
        return ("[" + sb.toString().substring(0, sb.length() - 2) + "]");
    }
}
