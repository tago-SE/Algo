/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_06_back_tracking;

/**
 *
 * @author tiago
 */
public class Queens {
    private final static int QUEEN = 1;
    
    private static String print(int[][] board, int n) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[x][y] == QUEEN) {
                    sb.append("[Q]"); 
                }
                else {
                    sb.append("[0]"); 
                }
            }
            sb.append("\n"); 
        }
        return sb.toString();
    }
    
    private static boolean canPlaceQueen(int[][] board, int x, int y) {
        int xx, yy;
        // Horizontal
        for (xx = 0; xx < board.length; xx++) {
            if (board[xx][y] == QUEEN) return false;
        }
        // Vertical
        for (yy = 0; yy < board.length; yy++) {
            if (board[x][yy] == QUEEN) return false;
        }
        // Diagonal 1
        for (xx = x, yy = y; xx >= 0 && yy >= 0; xx--, yy--) {
            if (board[xx][yy] == QUEEN) return false;
        }
        for (xx = x, yy = y; xx < board.length && yy < board.length; xx++, yy++) {
            if (board[xx][yy] == QUEEN) return false;
        }
        // Diagonal 2
        for (xx = x, yy = y; xx < board.length && yy >= 0; xx++, yy--) {
            if (board[xx][yy] == QUEEN) return false;
        }
        for (xx = x, yy = y; xx >= 0 && yy < board.length; xx--, yy++) {
            if (board[xx][yy] == QUEEN) return false;
        }
        return true;
    }
    
    public static boolean solve(int queensPlaced, int[][] board, int dimension, int x, int y) {
        if (queensPlaced == dimension) 
            return true;
        if (x >= dimension) {
            x = 0;
            y += 1;
        }
        if (y >= dimension)
            return false;
        
        if (canPlaceQueen(board, x, y)) {
            board[x][y] = 1;
            if (solve(queensPlaced + 1, board, dimension, 0, y + 1))
                return true;
            board[x][y] = 0;
        }
        return solve(queensPlaced, board, dimension, x + 1, y);
    }
    
    public static boolean solve(int queensPlaced, int[][] board, int steps, int dimension, int x, int y) {
        if (queensPlaced == dimension) 
            return true; 
        if (steps == dimension*dimension) {
            return false;
        }
        if (x >= dimension) 
            y += 1;
        x %= dimension;
        y %= dimension;
        if (canPlaceQueen(board, x, y)) {
            board[x][y] = 1;
            if (solve(queensPlaced + 1, board, steps + 1, dimension, 0, y + 1))
                return true;
            board[x][y] = 0;
        }
        return solve(queensPlaced, board, steps + 1, dimension, x + 1, y);
    }
    
    public static String solve() {
        int n = 8, count = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int board[][] = new int[n][n];
                if (solve(0, board, 0, n, x, y)) {
                    System.out.println(print(board, n));
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
            //int board[][] = new int[n][n];
            //solve(0, board, n, 0, 0);
      //  }
        //int board[][] = new int[n][n];
       // solve(0, board, n, 0, 0);
        //System.out.println(print(board, n));
       // return print(board, n);*/
        return "";

    }
    

}
