import java.util.Stack;


public class Solution{

    public static void main(String[] args){
        int [] input = new int[] {3, 1, 2, 4};
        System.out.println(soultion(input));
    }

    public static int soultion(int[] input){
        int n = input.length;
        int res = 0;
        int[] left = new int[n]; // array to store the index of the closest smaller element to the left
        int[] right = new int[n]; // array to store the index of the closest smaller element to the right
        Stack<Integer> s = new Stack<>();

        // Calculate the index of the closest smaller element to the left
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the top element of the stack is greater than the current element
            while (!s.isEmpty() && input[s.peek()] > input[i]) {
                s.pop(); // pop the top element from the stack
            }
            // If the stack is empty, set the left[i] to -1, otherwise set it to the top element of the stack
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i); // push the current index to the stack
        }

        // Clear the stack for the next iteration
        s.clear();

        // Calculate the index of the closest smaller element to the right
        for (int i = n - 1; i >= 0; i--) {
            // While the stack is not empty and the top element of the stack is greater than or equal to the current element
            while (!s.isEmpty() && input[s.peek()] >= input[i]) {
                s.pop(); // pop the top element from the stack
            }
            // If the stack is empty, set the right[i] to n, otherwise set it to the top element of the stack
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i); // push the current index to the stack
        }

        // Calculate the sum of the minimum values in all subarrays
        for (int i = 0; i < n; i++) {
            // The number of subarrays that have A[i] as the minimum value is (i - left[i]) * (right[i] - i)
            // So, add A[i] * (i - left[i]) * (right[i] - i) to the result
            res += input[i] * (i - left[i]) * (right[i] - i);
        }

        return res;


    }

}