import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution{

    public static void main(String[] args){
        int input = 4;
        solution(input);
    }

    public static void solution(int n){
        System.out.println("Ways:"+ recur(n));

    }

    public static int recur(int left){
        if( left ==0 ) return 1;
        if( left < 0 ){
            return 0;
        }
        return recur(left-1)+recur(left-2);
    }
}