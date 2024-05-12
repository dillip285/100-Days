




public class LCS {

    public static void main(String[] args) {
        LCS obj = new LCS();
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(String.format("The Longest common subsequence of %s and %s is %d",s1,s2,obj.getLcs(s1,s2)));
    }

    public int getLcs(String s1, String s2){
        return lcs(s1,s2,0,0);
    }

    private int lcs(String s1, String s2, int indexS1, int indexS2){
        if(indexS1>=s1.length() || indexS2 >= s2.length()){
            return 0;
        }
        int mlcs = 0;
        // if the characters are matching then we found one character we need to find lcs in rest of the substring.
        if(s1.charAt(indexS1) == s2.charAt(indexS2)){
            mlcs = Math.max(mlcs,lcs(s1,s2, indexS1+1, indexS2+1)+1);
        }else{
            mlcs = Math.max(mlcs,lcs(s1,s2, indexS1,indexS2+1));
            mlcs = Math.max(mlcs,lcs(s1,s2, indexS1+1, indexS2));
        }

        return mlcs;

    }
}