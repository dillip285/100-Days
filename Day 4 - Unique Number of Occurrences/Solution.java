import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution{

    public static void main(String[] args){
        int[] input = new int[] {1,2};
        System.out.println(solution(input));
    }

    public static boolean solution(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (map.get(arr[i])!=null){
                map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
            }else{
                map.put(arr[i],1);
            }

        }
        System.out.println(map);
        Set<Integer> keys = map.keySet();
        Set<Integer> value = new HashSet<Integer>();
        for (Integer key : keys) {
           if (value.contains(map.get(key))){
               return false;
           }else{
               value.add(map.get(key));
           }
        }
        return true;
        }

    }

