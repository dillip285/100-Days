/*
Check if two strings are one edit away from the same.
 */

import java.util.*;

public class OneAway {

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "ble";
        String result = isOneEditAway(s1, s2) ? "" : "not ";
        System.out.println(String.format("The string %s and %s is %s one edit away.", s1, s2, result));

    }

    public static boolean isOneEditAway(String s1, String s2) {
        // if the string length are diferent by 2 characters then it is not one edit away
        if (Math.abs(s1.length() - s2.length()) > 1) return false;
        // length could be same then we can match one by one character
        if ((s1.length() == s2.length())&&(checkSameLengthString(s1, s2) > 1)) return false;
        // Length of one string is smaller than other by one char.
        else if (checkDiffLengthString(s1, s2) > 1) return false;
        return true;
    }

    private static int checkDiffLengthString(String s1, String s2) {
        int p1 = 0, p2 = 0, diff = 0;
        while (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) == s2.charAt(p2)) {
                p1++;
                p2++;
            } else {
                diff++;
                if (s1.length() > s2.length()) {
                    p1++;
                } else {
                    p2++;
                }
            }

        }

        return diff;

    }

    private static int checkSameLengthString(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }


}
