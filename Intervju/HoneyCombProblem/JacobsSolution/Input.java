/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.honeycombproblem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * R = Length of edge cells
 * N = Limit to how many one can chew
 * A = Entrance
 * B = Exit
 * X = Number of wax hardned cells
 * @author Jacob
 */
public class Input {
    
    public final int R, N, A, B, X;
    private ArrayList<Integer> waxCells;

    public Input(String in) {
        String[] inFormatted = in.split("\n");
        String firstLine = inFormatted[0];
        String secondLine = inFormatted[1];

        String[] splittedFirst = firstLine.split(" ");
        String[] splittedSecond = secondLine.split(" ");
        R = Integer.valueOf(splittedFirst[0]);
        N = Integer.valueOf(splittedFirst[1]);
        A = Integer.valueOf(splittedFirst[2]);
        B = Integer.valueOf(splittedFirst[3]);
        X = Integer.valueOf(splittedFirst[4]);

        waxCells = new ArrayList<>();
        for (String x : splittedSecond) {
            waxCells.add(Integer.valueOf(x));
        }
    }
        
    public ArrayList<Integer> getWaxCells() {
        return (ArrayList<Integer>) waxCells.clone();
    }
    
    public void setWaxCells(ArrayList<Integer> cells) {
        this.waxCells = cells;
    }

    @Override
    public String toString() {
        return "Input{" + "R=" + R + ", N=" + N + ", A=" + A + ", B=" + B + ", X=" + X + ", waxCells=" + waxCells + '}';
    }
    
    
    
    
}
