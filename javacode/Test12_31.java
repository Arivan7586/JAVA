public class Test12_31{
    public static void main(String[] args){
        String str = "    arivan is very handsome       ";
        String str1 = str.trim();  //去掉字符串开头和结尾处的空格，保留中间的空格
        System.out.println(str1);

        System.out.println("-------------------------");
        String s1 = "arivan";
        String s2 = " is very handsome";  
        System.out.println(s1.concat(s2)); //将两个字符串拼接起来

        System.out.println(str.length());  //取得字符串的长度

        String s3 = "";
        System.out.println(s3.isEmpty());  //true  判断字符串是否为空。

        System.out.println(toUpperFirst(s1));
        System.out.println(toUpperFirst(s3));
    }

    //将字符串的首字母转换为大写
    public static String toUpperFirst(String str){
        if("".equals(str) || str == null){
            return str;
        }else{
            String s = str.substring(0,1);
            s = s.toUpperCase();
            String s1 = str.substring(1);
            s = s + s1;
            return s;
        }
    }
}

// //字符串的拆分
// public class Test12_31{
//     public static void main(String[] args){
//         String str = "arivan is very handsome";
//         String[] arr = new String[]{};
//         arr = str.split(" ");   //将字符串按 空格 全部拆分
//         for(String i : arr){
//             System.out.println(i);
//         }

//         System.out.println("------------------");
//         String[] arr2 = new String[]{};
//         arr2 = str.split(" ",2);   //将字符串按 空格 拆分为2个字符串
//         for(String i : arr2){
//             System.out.println(i);
//         }

//         System.out.println("------------------");
//         String[] arr3 = new String[]{};
//         arr3 = str.split(" ",3);   //将字符串按 空格 拆分为3个字符串
//         for(String i : arr3){
//             System.out.println(i);
//         }

//         System.out.println("------------------");
//         String s = "192.163.1.1";
//         String[] arr4 = new String[]{};
//         arr4 = s.split("\\.");  //拆分IP地址  需要使用 "\"转义
//         for(String i : arr4){
//             System.out.println(i);
//         }
//     }
// }

//字符串的截取
// public class Test12_31{
//     public static void main(String[] args){
//         String str = "arivan is very hansome";
//         String str1 = str.substring(7);   //从指定索引截取到结尾
//         System.out.println(str1);
//         System.out.println(new String(str.substring(7)));

//         System.out.println("--------------------------");
//         //截取部分内容
//         String str2 = str.substring(15,21);   // [)  从第15截取到21之前
//         System.out.println(str2);
//         System.out.println(new String(str.substring(15,22)));
//     }
// }

//字符串的大小写转换
// public class Test12_31{
//     public static void main(String[] args){
//         String str = "arivan is very handsome";
//         System.out.println(str.toUpperCase());  //把字符串全部转换为大写
//         String str1 = str.toUpperCase();
//         System.out.println(str1.toLowerCase());  //把字符串全部转换为小写

//         System.out.println("---------------------");
//         //转换大小写函数只转换字母。
//         String s = "75&^%$***(";
//         System.out.println(s.toUpperCase()); //75&^%$***(
//     }
// }