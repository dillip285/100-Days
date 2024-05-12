
import java.util.*;

public class SetZeros {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
        };

        System.out.println(Arrays.deepToString(makeZero(input)));
    }

    public static int[][] makeZero(int[][] m) {
        int c0 = -1;
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                if (m[r][c] == 0) {
                    m[r][0] = 0;
                    if (c == 0) {
                        c0 = 0;
                    } else {
                        m[0][c] = 0;
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(m));
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                if(getRow(m,r) == 0 || getCol(m,c,c0 ) == 0){
                    m[r][c] = 0;
                }

            }
        }


        return m;
    }

    public static int getRow(int[][] m, int row ){
        return m[row][0];
    }
    public static int getCol(int[][]m,  int col, int c0){
        if(col==0)
            return c0;
        return m[0][col];
    }


}