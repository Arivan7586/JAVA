//String类扩展功能实现
class Strings{

     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
        if(count <= 0){
            return "";
        }else{
            char[] arr = new char[count];
            for(int i = 0; i < count; i++){
                arr[i] = c;
            }      
            return new String(arr);
        }
    }
     
    /**
     * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 2  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
       if(str.length() >= len){
            return str;
       }else{
            char[] arr = str.toCharArray();
            char[] arr1 = new char[len];
            int n = len - str.length();
            for(int i = 0; i < len; i++){
                if(i < n){
                    arr1[i] = filledChar;
                }else{
                    arr1[i] = arr[i - n];
                }
            }
            return new String(arr1);
       }
    }
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
        if(str.length() >= len){
            return str;
        }else{
            char[] arr = str.toCharArray();
            char[] arr1 = new char[len];           
            for(int i = 0; i < len; i++){
                if(i < str.length()){
                    arr1[i] = arr[i];
                }else{
                    arr1[i] = filledChar;
                }
            }
            return new String(arr1);
        }
    }

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(String str, String strToRemove) {
        String[] arr = str.split(strToRemove);
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
           s =  s.append(arr[i]);
        }        
        return s.toString();
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        char[] arr1 = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr1[i] = arr[arr.length - 1 - i];
        }
        return new String(arr1);
    }
}

public class StringUtils{
    public static void main(String[] args){
        System.out.println(new Strings().repeat('s', 1));

        System.out.println(new Strings().fillBefore("abcdefg",'哈',10));
        System.out.println(new Strings().fillAfter("abcd",'哈',9));
        System.out.println(new Strings().removeAll("aa-bb-cc-dd", "-"));
        System.out.println(new Strings().reverse("abcdef"));
    }
}