


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ahmed Yassin
 */
public class HoneyCombProblem {

    /**
     * @param args the command line arguments
     */
    private static class Cell {
        
        public int id;
        public boolean isHardened;
        private ArrayList<Cell> neighbors = new ArrayList<>();    
        
        private boolean burrowed;
        
        public Cell(int id) {
            this.id = id;
            isHardened = false;
            burrowed = false;
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
        
        public boolean isHardened(){
            return isHardened;
        }
        
        public void setHardened(){
            isHardened = true;
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
            return s + "}, isEdge=" + isEdge() + ", isHardened=" + isHardened + "}";
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
                
        public Cell getById(int id) {
            return cellsList.get(id - 1);
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
    
    private static int R = 20;
    private static int N = 125;   // max steps
    private static int A = 1;   // Starting position
    private static int B = 512;   // Honey position
    private static int X = 11;
    public static void main(String[] args) {
      
        Scanner scan = new Scanner(System.in);
        
        Grid grid = null;
        
        while (true) {
            /*String line1 = scan.nextLine();
            String[] lineParams1 = line1.split(" ");
               if (lineParams1.length != 5){
                   System.out.println("Invalid line input");
                   continue;
               }
               
            
            try{
                R = Integer.parseInt(lineParams1[0]);
                N = Integer.parseInt(lineParams1[1]);
                A = Integer.parseInt(lineParams1[2]);
                B = Integer.parseInt(lineParams1[3]);
                X = Integer.parseInt(lineParams1[4]);
            } catch (NumberFormatException e){
                System.out.println("Error parsing line 1 integers");
                continue;
            }*/

            if (!(R <= 20 && R >= 2)){
                System.out.println("R must be between 2 and 20!");
                continue;
            }

           grid = new Grid(R);

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

            if ((N < 1 || (N >= (R*R*R - (R - 1)*(R - 1)*(R - 1))))){
                System.out.println("Invalid ant steps!");
                continue;
            }

            if (B == A || X == B){
                System.out.println("A, B and X must be distinct integers!");
                continue;
            }

            if ((A < 1 || (A > (R*R*R - (R - 1)*(R - 1)*(R - 1))))){
                System.out.println("Invalid starting input!");
                continue;
            }
            if ((grid.getById(A).isEdge() == false)){
                System.out.println("The starting position must be an edge cell!");
                continue;
            }

            if ((B < 1 || (B > (R*R*R - (R - 1)*(R - 1)*(R - 1))))){
                System.out.println("Invalid honey placement!");
                continue;
            }

            if ((X < 0 || (X >= (R*R*R - (R - 1)*(R - 1)*(R - 1))))){
                System.out.println("Invalid number of hardened cells!");
                continue;
            }
                
            break;
        }
        
        if (X > 0) {
            while (true) {
                /*String line2 = scan.nextLine();
                String[] lineParams2 = line2.split(" ");
                
                if (lineParams2.length != X){
                   System.out.println("Invalid line input");
                   continue;
               }
                int[] hardenedCellIds = new int[X];
                try{
                    for (int i = 0; i < lineParams2.length; i++){
                        hardenedCellIds[i] = Integer.parseInt(lineParams2[i]);
                    }
                } catch(NumberFormatException e){
                    System.out.println("Error parsing line 2 integers");
                    continue;
                }*/
                
                int[] hardenedCellIds = {15, 16, 17, 19, 26, 27, 52, 53, 58, 65, 74};
                boolean doContinue = false;
                for (int i = 0; i < hardenedCellIds.length; i++){
                    if (hardenedCellIds[i] == 0){
                        System.out.println("Amount of integers in line 2 must be the same as X!");
                        doContinue = true;
                        break;
                    }

                    if (hardenedCellIds[i] == A || hardenedCellIds[i] == B){
                        System.out.println("A cell containing honey or a starting cell can not be hardened!");
                        doContinue = true;
                        break;
                    }
                }
                if (doContinue)
                    continue;

                boolean notDistinctLine2 = false; 
                
                doContinue = false;
                
                for (int i = 0; i < hardenedCellIds.length; i++){
                    for (int j = i+1; j < hardenedCellIds.length; j++){
                        if (hardenedCellIds[i] == hardenedCellIds[j]){
                            notDistinctLine2 = true;
                            break;
                        }
                    }

                    if (notDistinctLine2){
                        System.out.println("Integers in line 2 must be distinct!");
                        doContinue = true;
                        break;
                    }
                }
                if (doContinue)
                    continue;

                try{
                    for (int i = 0; i < hardenedCellIds.length; i++){
                        grid.getById(hardenedCellIds[i]).setHardened();
                    }   
                } catch (Exception e){
                    System.out.println("Id input for hardened cells was out of bounds!");
                    continue;
                }
                break;
            }
        }
        
       Cell startCell = grid.getById(A);
       startCell.burrowed = true;
       int K = solve(grid, startCell, 0);
       
       if (K > N){
           System.out.println("No");
       } else{
           System.out.println(K);
       }
    }
    
    private static int curMin = Integer.MAX_VALUE;
    
    public static int solve(Grid grid, Cell curCell, int steps) {
        if (steps > N || steps > curMin) {
            return steps;
        }
        if (curCell.id == B) {
            return steps;
        }
        for (Cell neighbor : curCell.neighbors) {
            if (!neighbor.burrowed && !neighbor.isHardened) {
                neighbor.burrowed = true;
                int stepsTaken = solve(grid, neighbor, steps + 1);
                if (stepsTaken < curMin) {
                    curMin = stepsTaken;
                }
                neighbor.burrowed = false;
            }
        }
        return curMin;
    }
}   