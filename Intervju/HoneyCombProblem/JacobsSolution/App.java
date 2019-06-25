package com.mycompany.honeycombproblem;

/**
 * Hello world!
 *
 */
public class App {

    static String in1 = "6 6 1 45 11\n"
            + "15 16 17 19 26 27 52 53 58 65 74";
    static String in2 = "6 3 1 45 11\n"
            + "15 16 17 19 26 27 52 53 58 65 74";

    public static void main(String[] args) {
        
        long startTime = System.nanoTime();
        Input input = new Input(in2);
        HoneyComb comb = new HoneyComb(input);
        String result = Solver.getResult(comb);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime) / 1000000;
        System.out.println("result: " + result + ", time: " + elapsedTime + " ms");
    }
}
