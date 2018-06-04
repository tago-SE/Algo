/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_12_divide_n_conquer;

import java.awt.Point;

/**
 *
 * @author tiago
 */
public class ClosestPoints {
        
    public static double distance(Point p1, Point p2) {
        int deltaX = p1.x - p2.x;
        int deltaY = p1.y - p2.y;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }
  
}
