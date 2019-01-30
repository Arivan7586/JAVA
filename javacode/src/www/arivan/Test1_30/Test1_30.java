package www.arivan.Test1_30;

public class Test1_30 {
    public static void main(String[] args) {
        System.out.println(new Strings().repeat('s', 1));

        System.out.println(new Strings().fillBefore("abcdefg",'哈',10));
        System.out.println(new Strings().fillAfter("abcd",'哈',9));
        System.out.println(new Strings().removeAll("aa-bb-cc-dd", "-"));
        System.out.println(new Strings().reverse("abcdef"));

    }
}

class Strings{

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

    public static String removeAll(String str, String strToRemove) {
        String[] arr = str.split(strToRemove);
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < arr.length; i++){
            s =  s.append(arr[i]);
        }
        return s.toString();
    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        char[] arr1 = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr1[i] = arr[arr.length - 1 - i];
        }
        return new String(arr1);
    }
}

//字符串相关练习
//public class Test1_30 {
//    public static void main(String[] args) {
//        String str = "jams is so handsome";
//        //判断一个字符串是否存在
//        System.out.println(str.contains("s"));  //true s存在
//        System.out.println(str.contains("g"));  //false g不存在
//        System.out.println(str.contains("ss"));  //false
//
//        System.out.println("------------------------------");
//        System.out.println(str.indexOf("i"));  //从头开始查找   返回下标
//        System.out.println(str.indexOf("i",3));  //从指定位置开始查找
//        System.out.println(str.lastIndexOf("o"));  //从后向前开始查找
//        System.out.println(str.lastIndexOf("i", 5));  //从指定位置向前查找
//
//        System.out.println("------------------------------");
//        //判断是否以指定字符串开头
//        System.out.println(str.startsWith("a"));  //true
//        System.out.println(str.startsWith("A"));  //false
//        System.out.println(str.startsWith("ari"));  //true
//
//        System.out.println("------------------------------");
//        //判断是否以指定字符串在指定位置开头
//        System.out.println(str.startsWith("is",7)); //true
//        System.out.println(str.startsWith("is", 8));  //false
//
//        System.out.println("------------------------------");
//        //判断是否以指定字符串结尾
//        System.out.println(str.endsWith("me"));  //true
//        System.out.println(str.endsWith("a"));   //false
//    }
//}