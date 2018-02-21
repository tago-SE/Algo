/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB35;

/**
 *
 * @author Jacob
 */
public class Vara implements Comparable<Vara> {
    private int vikt;
    private int pris;
    
    public Vara() {
        this(0,0);
    }
    
    public Vara(int v, int p) {
        vikt = v;
        pris = p;
    }
    
    public int getVikt() {
        return vikt;
    }
    
    public int getPris() {
        return pris;
    }

    @Override
    public int compareTo(Vara t) {
        double thisVal = (double) this.pris / this.vikt;
        double tVal = (double) t.pris / t.vikt;

        if (thisVal > tVal) {
            return -1;
        } else if(thisVal < tVal) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return "Pris: " + pris + ", vikt: " + vikt;
    }
}
