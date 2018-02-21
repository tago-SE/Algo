/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB42;

import java.util.Comparator;

/**
 *
 * @author Jacob
 */
public class Punkt implements Comparable<Punkt>, Comparator<Punkt>{

    private float x, y;
    
    public Punkt() {
        
    }

    public Punkt(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    @Override
    public int compareTo(Punkt t) {
        return (int) ((this.x * 100) - (t.getX() * 100));
    }

    @Override
    public int compare(Punkt t, Punkt t1) {
        return (int) ((t.getY() * 100) - (t1.getY() * 100));
    }

}
