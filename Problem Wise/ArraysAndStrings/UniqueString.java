/*
* Determine is a string has all unique characters
*
* */
import java.util.Set;
import java.util.HashSet;

public class UniqueString {
    public static void main(String[] args) {
        String input = "abcde";
        System.out.println(String.format("The string %s is %sunique",input,(isUnique(input)?"":"not ")));
    }

    public static boolean isUnique(String str){
        Set<Character> characterSet = new HashSet<>();
        for(char c: str.toCharArray()){
            if (characterSet.contains(c)){
                return false;
            }
            characterSet.add(c);
        }
        return true;

    }

}