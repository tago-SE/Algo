package ten140522;

import java.util.Arrays;

public class Uppg4 {

    public static void main(String[] args) {
        int matris[][]
                = {
                    {2, 6, 8, 0, 5, 4, 7, 9, 3, 6, 8, 1, 5, 8, 3},
                    {7, 4, 5, 7, 8, 1, 2, 7, 8, 4, 5, 2, 8, 9, 6},
                    {1, 2, 5, 9, 6, 5, 6, 1, 1, 2, 7, 1, 4, 6, 4},
                    {7, 8, 9, 8, 8, 6, 8, 1, 7, 1, 2, 1, 5, 6, 7},
                    {5, 6, 7, 7, 5, 7, 7, 2, 8, 9, 6, 7, 9, 5, 5},
                    {9, 7, 9, 6, 8, 8, 8, 1, 8, 6, 8, 9, 8, 6, 8}};

        int[][] mat2 = {{1, 0, 1}, {6, 2, 5}}; //test mat for dev

        int res = solve(matris);
        System.out.println("Resultat: " + res);

    }

    public static int solve(int[][] matris) {
        int yLength = matris.length;
        int xLength = matris[0].length;
        int realRes = Integer.MAX_VALUE;

      //  System.out.println("xlen: " + xLength + ", yLength: " + yLength);
        
       for (int i = 0; i < matris[0].length; i++) {
             int res = solve(matris, i, 0, matris[0][i], "", 0);
             if (res < realRes)
                 realRes = res;
        }
        return realRes;
    }
    
    private static void printMat(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mat.length; i ++) {
            for (int j = 0; j < mat[0].length; j++) {
                sb.append(mat[j][i] + ",");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int[][] copy(int[][] matris) {
        int[][] tmp = new int[matris.length][];

        for (int i = 0; i < matris.length; i++) {
            tmp[i] = matris[i].clone();
        }
        return tmp;
    }

    private static String pathToStr(int y, int x) {
        return "[" + y + x + "]";
    }

    private static boolean containsPos(String path, int y, int x) {
        if (path.contains("[" + y + x + "]")) {
            return true;
        }
        return false;
    }

    static int result = Integer.MAX_VALUE;

    private static int solve(int[][] matris, int x, int y, int value, String currPath, int count) {
        if (y == matris.length - 1) {
           // System.out.println("path: " + currPath);
            //System.out.println("value: " + value + "x,y" + x + ":" + y);
            if (value < result) {
                result = value;
            }
        } else {

            if (value < result) {
                //System.out.println("currVal: " + value + "x,y:" + x + ":" + y);
                if ((x + 1) < matris[0].length && !containsPos(currPath, y, x + 1)) //go right
                {
                    currPath += pathToStr(y, x + 1);
                    solve(matris, x + 1, y, value + matris[y][x + 1], currPath, count + 1);
                }
                if ((y + 1) < matris.length && !containsPos(currPath, y + 1, x)) //go down
                {
                    currPath += pathToStr(y + 1, x);
                    solve(matris, x, y + 1, value + matris[y + 1][x], currPath, count + 1);
                }

                if (x > 0 && !containsPos(currPath, y, x - 1)) //go left
                {
                    currPath += pathToStr(y, x - 1);
                    solve(matris, x-1, y, value + matris[y][x - 1], currPath, count + 1);
                }
                if (y > 0 && !containsPos(currPath, y - 1, x)) //go up
                {
                    currPath += pathToStr(y - 1, x);
                    solve(matris, x, y - 1, value + matris[y - 1][x], currPath, count + 1);
                }
            }
        }
        return result;
    }

}
