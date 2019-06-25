/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.honeycombproblem;

import java.util.ArrayList;

/**
 * Using the A* algorithm for pathfinding
 * See https://en.wikipedia.org/wiki/A*_search_algorithm
 * @author Jacob
 */
public class Solver {
    
    public static String getResult(HoneyComb comb) {
        String result = "";
        
        ArrayList<Cell> openList = new ArrayList<>();
        ArrayList<Cell> closedList = new ArrayList<>();
        
        Cell start = comb.getStart();
        Cell goal = comb.getGoal();
        
        start.setF(0.0f);
        openList.add(start);
        
        while (!openList.isEmpty()) {
            float minF = Float.MAX_VALUE;
            Cell q = null;
            
            for (Cell c : openList) {
                if (c.getF() < minF) {
                    minF = c.getF();
                    q = c;
                }
            }
            
            if (q.type == Type.GOAL) {
                int steps = 1; //including goal
                while (q.getCameFrom() != start) { //reconstructing path to get number of steps
                    steps++;
                    q = q.getCameFrom();
                }
                
                if (steps <= comb.getN()) {
                    return String.valueOf(steps);
                } else {
                    return "No";
                }
            }
            
            openList.remove(q);
            closedList.add(q);
            
            for (Cell neighbor : q.getNeighbors()) {
                if (closedList.contains(neighbor) || neighbor.type == Type.BLOCKED)
                    continue;
                
                float tentative_gScore = q.getG() + q.dist(neighbor);
                if (!openList.contains(neighbor)) {
                    openList.add(neighbor);
                } else if (tentative_gScore >= neighbor.getG()) {
                    continue;
                }
                
                neighbor.setCameFrom(q);
                neighbor.setG(tentative_gScore);
                neighbor.setF(neighbor.getG() + neighbor.dist(goal));
            }
        }
        
        //No path to goal
        return "No";
    }
}
