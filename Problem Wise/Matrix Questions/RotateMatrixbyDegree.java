import java.util.Arrays;


public class RotateMatrixbyDegree {

    public static void main(String[] args) {
        int[][] input = {
                {1,   2,  3,  4},
                {5,   6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };
     System.out.println(Arrays.deepToString(rotate(input, 90)));
    }

    public static int[][] rotate(int[][] matrix, int degree){
        if (degree % 90 !=0) {
            System.out.println("Valid degrees are in multiple of 90.");
        }
        if (matrix.length!= matrix[0].length){
            System.out.println("Matrix is not a square, please enter a square matrix.");
        }
        int rotationTarget = degree/90;
        int n = matrix.length;
        int l, r, rotation;
        rotation = l = 0;
        r = n - 1;
        while (rotation<rotationTarget) {
            while (l < r) {
                int t=l,b=r;
                for(int offset=0; offset < r-l ;offset++) {
                    int temp = matrix[t][l+offset];
                    matrix[t][l+offset] = matrix[b-offset][l];
                    matrix[b-offset][l] = matrix[b][r-offset];
                    matrix[b][r-offset] = matrix[t+offset][r];
                    matrix[t+offset][r] = temp;
                    System.out.println(Arrays.deepToString(matrix));
                }
                l++;
                r--;
            }
            rotation++;
        }





        return matrix;

    }
}