package www.arivan.Test1_26;
import java.util.Scanner;

public class Test1_26 {
    public static void main(String[] args){
        //System.out.println(Strings.judgeStrings());
        //Time.getTime();
        Math1.interval();
    }
}

class Strings {

//    给定两个仅由大写字母或小写字母组成的字符串(长度介于1到10之间)，它们之间的关系是以下4中情况之一：
//            　　1：两个字符串长度不等。比如 Beijing 和 Hebei
//　　2：两个字符串不仅长度相等，而且相应位置上的字符完全一致(区分大小写)，比如 Beijing 和 Beijing
//　　3：两个字符串长度相等，相应位置上的字符仅在不区分大小写的前提下才能达到完全一致
// （也就是说，它并不满足情况2）。比如 beijing 和 BEIjing
//　　4：两个字符串长度相等，但是即使是不区分大小写也不能使这两个字符串一致。比如 Beijing 和 Nanjing
//　　编程判断输入的两个字符串之间的关系属于这四类中的哪一类，给出所属的类的编号。

    public static int judgeStrings(){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        int m = str1.length();
        int n = str2.length();
        int count = 0;
        if(m == n){
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]){
                    if(arr1[i]-32 != arr2[i] && arr1[i]+32 != arr2[i]){
                        return 4;
                    }else if(arr1[i]-32 == arr2[i] || arr1[i]+32 == arr2[i]){
                        count++;
                    }
                }else {
                    count++;
                }
            }
            if(count == m){
                return 3;
            }
            return 2;
        }else {
            return 1;
        }
    }
}

class Time{

//    给定一个以秒为单位的时间t，要求用“<H>:<M>:<S>”的格式来表示这个时间。
//    <H>表示时间，<M>表示分钟，而<S>表示秒，它们都是整数且没有前导的“0”。例如，若t=0，
//    则应输出是“0:0:0”；若t=3661，则输出“1:1:1”。
    public static void getTime(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入时间：");
        int n = scanner.nextInt();
        int i = n % 60; //秒
        int j = (n / 60) % 60; //分
        int k = (n - i - j) / 3600; //时
        System.out.println(k+":"+j+":"+i);
    }
}

class Math1 {
    public static void interval(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        if(n > 0 && n < 100){
            int m = scanner.nextInt();
            if(m > 0 && m < 100){
                int[][] arr = new int[n][m];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = scanner.nextInt();
                        sum += arr[i][j];
                    }
                }
//                for (int i = 0; i < arr.length; i++) {
//                    for (int j = 0; j < arr[i].length; j++) {
//                        sum += arr[i][j];
//                    }
//                }
                System.out.println(sum);
            }else {
                System.out.println("输入错误！正确范围是(0-100)");
            }
        }else {
            System.out.println("输入错误！正确范围是(0-100)");
        }
    }
}