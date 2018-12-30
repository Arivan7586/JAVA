//字符串查找
public class Test12_30{
    public static void main(String[] args){
        String str = "arivan is so handsome";
        //判断一个字符串是否存在
        System.out.println(str.contains("s"));  //true s存在
        System.out.println(str.contains("g"));  //false g不存在
        System.out.println(str.contains("ss"));  //false

        System.out.println("------------------------------");
        System.out.println(str.indexOf("i"));  //从头开始查找   返回下标
        System.out.println(str.indexOf("i",3));  //从指定位置开始查找
        System.out.println(str.lastIndexOf("o"));  //从后向前开始查找
        System.out.println(str.lastIndexOf("i", 5));  //从指定位置向前查找

        System.out.println("------------------------------");
        //判断是否以指定字符串开头
        System.out.println(str.startsWith("a"));  //true
        System.out.println(str.startsWith("A"));  //false
        System.out.println(str.startsWith("ari"));  //true

        System.out.println("------------------------------");
        //判断是否以指定字符串在指定位置开头
        System.out.println(str.startsWith("is",7)); //true
        System.out.println(str.startsWith("is", 8));  //false

        System.out.println("------------------------------");
        //判断是否以指定字符串结尾
        System.out.println(str.endsWith("me"));  //true
        System.out.println(str.endsWith("a"));   //false
    }
}


// public class Test12_30{
//     public static void main(String[] args){
//         String str1 = "hello";  //直接赋值法
//         String str2 = "Hello";
//         String str3 = new String("hello");   //构造方法赋值
//         System.out.println(str1 == str2);   //结果为false
//         System.out.println(str1 == str3);   //结果为false

//         String str4 = null;
//         // System.out.println(str4.equals("hello")); NullPointerException
//         System.out.println("hello".equals(str4));  //进行比较的时候，把字符串写在前面。 避免发生以上错误
        
//         String s1 = new String("world").intern();
//         String s2 = "world";
//         System.out.println(s1 == s2);   //true
//     }
//}

// //字符串不可变更
// public class Test12_30{
//     public static void main(String[] args){
//         String str = "hello";
//         str = str + "world";
//         str = str + "!!!";
//         System.out.println(str); 
//         //以上字符串的变更是字符串对象的变更而非字符串常量
//         //会产生很多垃圾空间
//     }
// }

//字符串与字符之间的相互转换
// public class Test12_30{
//     public static void main(String[] args) {
//         String str = "hello arivan";
//         System.out.println(str.charAt(0)); //从指定位置获取字符
//         System.out.println(str.charAt(6));

//         char[] arr = new char[]{}; //数组的静态初始化
//         arr = str.toCharArray();  //将字符串全部变为字符数组
//         for(char a : arr){   //for each 语句
//             System.out.print(a);
//         }

//         System.out.println();
//         System.out.println("------------------------");
//         String ss = str.toString(); //将字符数组全部变为字符串
//         System.out.println(ss);

//         System.out.println("------------------------");
//         System.out.println(new String(arr,0,5));  //将字符数组部分变为字符串
//         System.out.println(new String(arr));   //将字符数组全部变为字符串
//     }
// }

//字节与字符串相互转换
// public class Test12_30{
//     public static void main(String[] args){
//         String str = "hello arivan";
//         byte[] arr = new byte[]{};
//         arr = str.getBytes();  //把字符串全部转换为字节数组
//         for(int i : arr){
//             System.out.println(i);
//         }
//         byte[] arr1 = new byte[]{};

//         System.out.println("------------------");
//         System.out.println(new String(arr));   //把字节数组全部转换为字符串
//         System.out.println(new String(arr,0,5));   //把字节数组部分转换为字符串

//     }
// }

//字符串比较
// public class Test12_30{
//     public static void main(String[] args){
//         String str = "arivan is so handsome";
//         String str1 = "Arivan is so handsome";
//         String str2 = "hello arivan";
//         System.out.println(str.equals(str1));  //false  区分大小写比较
//         System.out.println(str.equalsIgnoreCase(str1));  //true 不区分大小写比较

//         //比较字符串的大小关系
//         System.out.println(str.compareTo(str2));  // - 7   小于
//         System.out.println(str2.compareTo(str));  //  7   大于
//         System.out.println(str.compareTo("arivan is so handsome"));  // 0  等于
//     }
// }

// //字符串的替换
// public class Test12_30{
//     public static void main(String[] args){
//         String s = "arivan is so handsome";
//         System.out.println(s.replaceAll("i", "*"));  //将字符串s中的 i 全部替换为 *
//         System.out.println(s.replaceFirst("i", "--"));  //将字符串s中的第一个 i 全部替换为--

//     }
// }
