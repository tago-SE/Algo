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
public class Change {
   
  
    public static int[] solve(int totMoney, int[] change) {
        int n = 0;
        int[] solution = new int[change.length];
        while (totMoney > 0) {
            int curChange = 0;
            for (int i = 0; i < change.length; i++) {
                if (change[i] <= totMoney) {
                    curChange = change[i];
                    totMoney -= curChange;
                    solution[i]++; 
                    break;
                }
            }
        }
        return solution;
    }
    
}
