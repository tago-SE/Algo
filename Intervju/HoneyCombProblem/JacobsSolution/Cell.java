/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.honeycombproblem;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Cell {

    public Type type;
    public int id;
    private ArrayList<Cell> neighbors;
    private int x, y;
    private float f, g, h;
    private Cell cameFrom;

    public Cell(Type t, int id, int x, int y) {
        this.x = x;
        this.y = y;
        neighbors = new ArrayList<>();
        this.type = t;
        this.id = id;

        f = Float.MAX_VALUE / 2;
        g = Float.MAX_VALUE / 2;
        h = Float.MAX_VALUE / 2;

        cameFrom = null;
    }

    public Cell getCameFrom() {
        return cameFrom;
    }

    public void setCameFrom(Cell cameFrom) {
        this.cameFrom = cameFrom;
    }

    //manhattan distance
    public float dist(Cell other) {
        int xDelta = x - other.getX();
        int yDelta = y - other.getY();

        return Math.abs(xDelta) + Math.abs(yDelta);
    }

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addNeighbor(Cell neighbor) {
        neighbors.add(neighbor);
        neighbor.attach(this);
    }

    public void attach(Cell neighbor) {
        neighbors.add(neighbor);
    }

    public ArrayList<Cell> getNeighbors() {
        return (ArrayList<Cell>) neighbors.clone();
    }

    @Override
    public String toString() {
        String myNeighbors = "";
        for (Cell c : neighbors) {
            myNeighbors += c.id + ",";
        }
        return "Cell{" + "type=" + type + ", id=" + id + ", neighbors=" + myNeighbors + ", pos=[" + x + "," + y + "]" + '}';
    }
}
