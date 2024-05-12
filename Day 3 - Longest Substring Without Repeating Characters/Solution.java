import java.lang.Math;
import java.util.HashSet;

public class Solution{

    public static void main(String[] args){
        String input = "bbbbb";
        System.out.println(solution(input));
    }

    public static int solution(String input){
        int max=0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<input.length();i++){  /*'a' 'b' 'c' 'a' 'b' 'c' 'b' 'b'*/
            char c = input.charAt(i); // 0 - > a ,  1 -> b , 2 -> c, 3 -> a
            if(!set.contains(c)){
                set.add(c); // set: a, b, c | a
            }else{
                max=Math.max(max,set.size());
                set.clear();
                set.add(c); // | set: a
            }
        }
        return max;
    }
}