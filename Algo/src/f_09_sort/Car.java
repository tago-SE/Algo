package f_09_sort;


import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tiago
 */
public class Car implements Comparable<Car>{
    public String model;
    public int year;
    public int traveled;
    
    public Car (String model, int year, int traveled) {
        this.model = model;
        this.year = year;
        this.traveled = traveled;
    }
   
    @Override
    public String toString() {
        return model + " " + year + " " + traveled;
    }
    
    public static void sortCarsByArg(List<Car> l, String arg) {
        if (arg.equals("MODEL")) {
            Collections.sort(l, Car.Comparators.MODEL);
        } 
        else if (arg.equals("AGE")) {
            Collections.sort(l, Car.Comparators.AGE);
        }
        else if (arg.equals("TRAVELED")) {
            Collections.sort(l, Car.Comparators.TRAVELED);
        } else {
            throw new IllegalArgumentException("Invalid: " + arg);
        }
    }
    public static class Comparators {
        public static Comparator<Car> MODEL = (Car o1, Car o2) -> o1.model.compareTo(o2.model);
        public static Comparator<Car> AGE = (Car o1, Car o2) -> o1.year - o2.year;
        public static Comparator<Car> TRAVELED = (Car o1, Car o2) -> o1.traveled - o2.traveled;
    }
   
    @Override
    public int compareTo(Car o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
