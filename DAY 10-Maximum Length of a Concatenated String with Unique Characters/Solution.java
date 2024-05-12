import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>(Arrays.asList("un", "iq", "ue"));
        System.out.println(maxLength(input));
    }

    public static int maxLength(List<String> arr) {
//        List<String> list = new ArrayList<>();
//        for (String s : arr) {
//            if (isUnique(s)) {
//                list.add(s);
//            }
//        }
        return backtrack(arr, 0, "");
    }

    private static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    private static int backtrack(List<String> list, int index, String current) {
        if (index == list.size()) {
            return current.length();
        }
        int maxLen = 0;
        for (int i = index; i < list.size(); i++) {
            if (isUnique(current + list.get(i))) {
                maxLen = Math.max(maxLen, backtrack(list, i + 1, current + list.get(i)));
            }
        }
        return maxLen;
    }
}