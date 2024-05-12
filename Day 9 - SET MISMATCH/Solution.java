import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[] {1,2,2,4};
        System.out.println(Arrays.toString(findMismatch(input)));
    }

    public static int[] findMismatch(int[] input){
        int duplicate =-1, missing = -1;
        int[] index = new int[input.length];

        for( int i=0;i<input.length;i++){
            index[input[i]-1]++;
        }
        for( int i=0;i<index.length;i++){
            if (index[i] == 2) {
                duplicate = i+1;
            } else if (index[i] == 0) {
                missing = i+1;
            }
        }
        return new int[]{duplicate, missing};

    }
}