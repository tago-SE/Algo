/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB36;


/**
 *
 * @author Jacob
 */
public class Aktivitet implements Comparable<Aktivitet> {

    private int startTid, slutTid;

    public Aktivitet(int start, int slut) {
        startTid = start;
        slutTid = slut;
    }

    public int getStart() {
        return startTid;
    }

    public int getSlut() {
        return slutTid;
    }

    @Override
    public String toString() {
        return "Start: " + startTid + ", slut: " + slutTid + "\n";
    }

    @Override
    public int compareTo(Aktivitet t) {
        return this.slutTid - t.slutTid;
    }

    public boolean overLap(Aktivitet t) {
        if ((t.startTid > this.startTid) && (t.startTid < this.slutTid)) {
            return true;
        } else if ((t.slutTid > this.startTid) && (t.slutTid < this.slutTid)) {
            return true;
        }
        return false;
    }
}
