import java.lang.Integer;


public class Solution{

    public static void main(String[] args){
        int[][] input = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(solution(input));
    }

    public static int solution(int[][] input ){
        int result = Integer.MAX_VALUE;
        for(int i=0;i<input.length;i++){

            result = Math.min(nextPath(input, 0,i),result);
        }
        return result;

    }

    public static int nextPath(int[][] input, int r, int c) {
        if (r == input.length - 1) {
            return input[r][c];
        } else {
            int left = c - 1 >= 0 ? nextPath(input, r + 1, c - 1) : Integer.MAX_VALUE;
            int mid = nextPath(input, r + 1, c);
            int right = c + 1 < input[0].length ? nextPath(input, r + 1, c + 1) : Integer.MAX_VALUE;
            return input[r][c] + Math.min(Math.min(left, mid), right);
        }
    }




}