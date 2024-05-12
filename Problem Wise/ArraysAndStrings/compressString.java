


public class compressString {

    public static void main(String[] args) {
        String s = "aabbcccdddaaa";
        System.out.println(String.format("Original: %s, Compressed: %s",s, compress(s)));
    }
    public static String compress(String s){
        StringBuilder compressed = new StringBuilder();
        char current = s.charAt(0);
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=current){
                compressed.append(current);
                if ( count > 1){
                    compressed.append(count);
                }
                current = s.charAt(i);
                count = 1;
            }else{
                count ++;
            }
        }
        compressed.append(current);
        if ( count > 1){
            compressed.append(count);
        }
        return compressed.toString();
    }
}