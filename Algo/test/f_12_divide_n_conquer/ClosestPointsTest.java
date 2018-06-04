/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_12_divide_n_conquer;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class ClosestPointsTest {
    
    public ClosestPointsTest() {
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 1);
        int d = (int) ClosestPoints.distance(p1, p2);
        //assertEquals(1, d);
    }

    @Test
    public void testSolve() {
    }
    
}
