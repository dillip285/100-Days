
/*
Check if a s2 is a rotation of s1
 */


public class Rotation {
    public static void main(String[] args) {
        String s1 = "tterbottle";
        String s2 = "erbottlett";
        System.out.println(isRotation(s1,s2));
    }

    public static boolean isRotation(String s1, String s2){
        // if two strings are different in length then they cannot be rotation of each other
        if ( s1.length()!=s2.length()) return false;
        /*
        We will use two pointer method first we will try to find the index first character of s1 in s2 and then
        p2 will point to that index and p1 will be regular index starting form the first character of s1
        Our goal is to compare every char by incrementing pointer by 1;
        if anything doesn't match then return false
        if whole length of s1 character matches s2 character then return true;

        Note *
        the pointer p2 can run out of index as it could be starting for middle of the sting s2 so we have to bring the
        p2 to 0 ance it reaches the end of the string
         */

        int p2 = s2.indexOf(s1.charAt(0));
        for(int p1 = 0; p1<s1.length();p1++){

            if(p2==s1.length()) p2=0;
            System.out.println(p1+":"+p2);
            if(s1.charAt(p1)!=s2.charAt(p2)) return false;
            p2++;
        }
        return true;



    }
}