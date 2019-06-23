/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package honeycombproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class HoneyCombProblem {

    /**
     * @param args the command line arguments
     */
    private static class Cell {
        
        public int id;
        private ArrayList<Cell> neighbors = new ArrayList<>();    
        
        public Cell(int id) {
            this.id = id;
        }
        
        public void addAdjacent(Cell c) {
            if (c == null)
                return;
            neighbors.add(c);
        }
        
        public List<Cell> getNeighbors() {
            return neighbors;
        }
        
        public boolean isEdge() {
            return neighbors.size() != 6;
        }
        
        public boolean isCorner() {
            return neighbors.size() == 3;
        } 

        @Override
        public String toString() {
            String s = "Cell{" + "id=" + id + ", neighbors={";
            boolean first = true;
            for (Cell c : neighbors) {
                if (first) {
                    first = false;
                    s += c.id;
                } else {
                    s += "," + c.id;
                }
            }
            return s + "}, isEdge=" + isEdge() + "}";
        }
        
    }
    
    private static class Grid {
        
        public Cell[][] cells;              // Lookup table by column, row
        private ArrayList<Cell> cellsList;  // Lookup table by id
        
        public final int rows;
        public final int cols;
        public final int R;
        
        
        
        public Grid(int R) {
            this.rows = this.cols = 2*R - 1;
            this.R = R;
            cells = new Cell[cols][rows];
            cellsList  = new ArrayList<>();
        }
        
        public boolean sanityCheck(int col, int row) {
            return col >= 0 && row >= 0 && col <= 2*R - 2 && row <= 2*R - 2;
        }
        
        public Cell get(int id) {
            return cellsList.get(id - 1);
            /*
            int maxCol = R;
            int c = 0;
            int r = 0;
            for (int i = 0; i < R*R*R - (R - 1)*(R - 1)*(R - 1); i++) {
                if (cells[c][r].id == id) {
                    return cells[c][r];
                }
                c++;
                if (c == maxCol) {
                    c = 0;
                    if (r < R - 1) 
                        maxCol++;
                    else 
                        maxCol--;
                    r++;
                }
             }
            return null;
            */
        }
     
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    if (cells[x][y] != null)
                        sb.append(cells[x][y]).append(",");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    
    
    public static void main(String[] args) {
      
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter R: ");
        int R = scan.nextInt();
        Grid grid = new Grid(R);
        
        // Setup Grid   
        int maxCol = R;
        int row = 0;
        int col = 0;

        // Allocate cells
        for (int i = 0; i < R*R*R - (R - 1)*(R - 1)*(R - 1); i++) {
           Cell c = new Cell(i + 1);
           grid.cells[col][row] = c;
           grid.cellsList.add(c);
           
           col++;
           if (col == maxCol) {
               col = 0;
               if (row < R - 1) 
                   maxCol++;
               else 
                   maxCol--;
               row++;
           }
        }
        
        // Setup Adjacency List
        maxCol = R;
        row = 0;
        col = 0;
        for (int i = 0; i < R*R*R - (R - 1)*(R - 1)*(R - 1); i++) {
            Cell c = grid.cells[col][row];
            // Left and Right
            if (grid.sanityCheck(col - 1, row))
                c.addAdjacent(grid.cells[col - 1][row]);
            if (grid.sanityCheck(col + 1, row))
                c.addAdjacent(grid.cells[col + 1][row]);
            if (row < R) {
                // Upper
                if (grid.sanityCheck(col - 1, row - 1))
                    c.addAdjacent(grid.cells[col - 1][row - 1]);
                if (grid.sanityCheck(col, row - 1))
                    c.addAdjacent(grid.cells[col][row - 1]);
                
            } else {
                // Upper
                if (grid.sanityCheck(col, row - 1))
                    c.addAdjacent(grid.cells[col][row - 1]);
                if (grid.sanityCheck(col + 1, row - 1))
                    c.addAdjacent(grid.cells[col + 1][row - 1]);
               
                
            }
            // Lower 
            if (row < R - 1) {
                if (grid.sanityCheck(col, row + 1))
                    c.addAdjacent(grid.cells[col][row + 1]);
                if (grid.sanityCheck(col + 1, row + 1))
                    c.addAdjacent(grid.cells[col + 1][row + 1]);
            } else {
                if (grid.sanityCheck(col - 1, row + 1))
                    c.addAdjacent(grid.cells[col - 1][row + 1]);
                if (grid.sanityCheck(col, row + 1))
                    c.addAdjacent(grid.cells[col][row + 1]);
            }
            
 
           col++;
           if (col == maxCol) {
               col = 0;
               if (row < R - 1) 
                   maxCol++;
               else 
                   maxCol--;
               row++;
           }
        }

        // Display Grid
       System.out.println(grid.toString());
       
       for (;;) {
           System.out.println("Enter id:");
           int id = scan.nextInt();
           Cell c = grid.get(id);
           System.out.println(c.toString());
       }
       

    }
    
}
