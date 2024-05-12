


public class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{2,1,9,14,1};
        System.out.println(findMaxThatCanBeRobbed(input));
    }

    public static int findMaxThatCanBeRobbed(int[] input){
//        int[] output = new int[input.length];
//        for(int i=0;i<input.length;i++){ // 0, 1, 2
//            int j=i; // 0, 1, 2
//            while(j>=0){
//                output[j]+=input[i]; // [ 4 | 2 | 3 | 1 ]
//                j=j-2;
//            }
//
//        }
//        int max=0;
//        for(int i = 0;i<output.length;i++){
//            max=Math.max(max,output[i]);
//        }
//        return max;
        if(input.length<1)return 0;
        if(input.length==1)return input[0];
        int[] dp = new int[input.length];

        dp[0]=input[0];
        dp[1]=Math.max(input[0],input[1]);

        for(int i=2; i<input.length;i++)
        {
            dp[i]=Math.max(dp[i-2]+input[i],dp[i-1]);
        }
        return dp[input.length-1];
    }
}