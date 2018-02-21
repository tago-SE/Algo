/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB16;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jacob
 */
public class Myntmaskin {

    //For vi lagger bara till varden
    public static void main(String[] args) {
        int res = findSmallestOre(109);
        System.out.println("RESULT: " + res);
    }

    public static int findSmallestOre(int target) {
        Queue<Tillstand> q = new LinkedList<Tillstand>();
        Tillstand t = new Tillstand(1, 0);

        while (t.currentValue != target) {
            if (t.currentValue + 4 <= target) {
                q.offer(new Tillstand(t.currentValue + 4, t.leastVal + 5));
            }
          //  System.out.println("current, least: " + t.currentValue + " : " + t.leastVal);

            if (t.currentValue * 3 <= target) {
                q.offer(new Tillstand(t.currentValue * 3, t.leastVal + 10));
            }

            if (t.currentValue == target) {
                return t.leastVal;
            }
            t = q.poll();
        }

        return t.leastVal;
    }
}
