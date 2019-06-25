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
public class HoneyComb {

    private ArrayList<Cell> cells;
    private int N;
    private Cell start;
    private Cell goal;

    public HoneyComb(Input in) {
        this.N = in.N;
        cells = new ArrayList<>();
        ArrayList<Integer> blockedCells = in.getWaxCells();

        int currentWidth = in.R;
        int width = getWidth(in.R);

        Cell previousCell = null;
        boolean increaseSize = true;
        int counter = 0;
        int yVal = 0;

        for (int id = 1; id <= getSize(in.R); id++) {
            Cell newCell = null;
            if (id == in.A) {
                newCell = new Cell(Type.START, id, counter, yVal);
                start = newCell;
            } else if (id == in.B) {
                newCell = new Cell(Type.GOAL, id, counter, yVal);
                goal = newCell;
            } else if (blockedCells.contains(id)) {
                newCell = new Cell(Type.BLOCKED, id, counter, yVal);
            } else {
                newCell = new Cell(Type.OPEN, id, counter, yVal);
            }

            cells.add(newCell);
            addNeighbors(newCell, currentWidth, increaseSize, in.R, counter);
            counter++;

            if (currentWidth == counter) {
                yVal++;
                counter = 0;

                if (currentWidth == width) {
                    increaseSize = false;
                }

                if (increaseSize) {
                    currentWidth++;
                } else {
                    currentWidth--;
                }
            }
        }
    }
    
    public Cell getStart() {
        return start;
    }

    public Cell getGoal() {
        return goal;
    }

    public int getN() {
        return N;
    }

    private void addNeighbors(Cell me, int currentWidth, boolean increaseSize, int R, int counter) {
        ArrayList<Integer> aboveCells = getIdsOfNeighborsAbove(me, currentWidth, increaseSize, R, counter);
        if (aboveCells != null) {
            for (Integer id : aboveCells) {
                me.addNeighbor(cells.get(id - 1));
            }
        }

        int idLeft = getIdToLeft(me, counter);
        if (idLeft != 0) {
            me.addNeighbor(cells.get(idLeft - 1));
        }
    }

    private int getIdToLeft(Cell me, int counter) {
        if (counter != 0 && me.id != 1) {
            return me.id - 1;
        }

        return 0;
    }

    private ArrayList<Integer> getIdsOfNeighborsAbove(Cell me, int currentWidth, boolean increaseSize, int R, int counter) {
        ArrayList<Integer> above = new ArrayList<>();

        if (increaseSize && currentWidth == R) {
            return null;
        }

        if (increaseSize) {
            if (counter == 0) {
                above.add(me.id - currentWidth + 1);
            } else if (counter + 1 == currentWidth) {
                above.add(me.id - currentWidth);
            } else {
                above.add(me.id - currentWidth);
                above.add(me.id - currentWidth + 1);
            }
        } else {
            above.add(me.id - currentWidth - 1);
            above.add(me.id - currentWidth);
        }

        return above;
    }

    private int getWidth(int R) {
        return (R * 2) - 1;
    }

    public int getSize(int R) {
        int totalSize = (int) (Math.pow(R, 3) - Math.pow(R - 1, 3));
        return totalSize;
    }

    @Override
    public String toString() {
        return "HoneyComb{" + "cells=" + cells + '}';
    }

}
