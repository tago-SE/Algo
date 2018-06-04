/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

/**
 *
 * @author tiago
 */
public class Edge {
    private int weight;
    private int source;
    private int dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public Edge(int source, int dest, int weight) {
        this.weight = weight;
        this.source = source;
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.source;
        hash = 23 * hash + this.dest;
        return hash;
    } 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        return true;
    }


    @Override
    public String toString() {
        return "Edge{" + "weight=" + weight + ", source=" + source + ", dest=" + dest + '}';
    }
}
