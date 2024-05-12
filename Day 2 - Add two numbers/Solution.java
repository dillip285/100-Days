
import java.util.ArrayList;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) {
        int[] l1 = new int[] {9,9,9,9,9,9,9};
        int[] l2 = new int[] {9,9,9,9};
        soution(l1,l2);
    }

    public static void soution(int[] num1, int[] num2){
        ArrayList<Integer> output = new ArrayList<Integer>();
        int pointer1 = 0, pointer2 = 0, carry = 0;
        int length = Math.max(num1.length,num2.length);
        for(int i=0;i<length;i++){

            int sum = getValue(num1, pointer1++) + getValue(num2, pointer2++) + carry;
            carry = 0;
            if(sum/10>0){
                carry = sum/10;
            }
            output.add(sum%10);
        }
        if (carry > 0 ){
            output.add(carry);
        }

        System.out.println(output);

    }

    public static int getValue(int[] nums, int index){
        if(index<nums.length){
            return nums[index];
        }
        return 0;

    }

}