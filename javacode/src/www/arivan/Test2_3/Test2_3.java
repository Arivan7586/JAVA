package www.arivan.Test2_3;
import java.util.Scanner;

public class Test2_3 {
    public static void main(String[] args){
        //System.out.println(A.simpleAdd(1000));
       // A.sorting();

        B.IDnumber();
    }
}

class A {
    //    问题描述
//　　小于10的自然数中有四个数字能除尽3或5（3， 5， 6， 9），它们的和为23。
//            　　请计算所有小于1000的自然数中能除尽3或5的数字的合。然后使用标准
//    输出cout，输出你的结果。
    public static int simpleAdd(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void sorting() { //输入三个数，比较其大小，并从大到小输出。
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
            if (a < c) {
                temp = a;
                a = c;
                c = temp;
            }
        }
        if (b < c) {
            temp = b;
            b = c;
            c = temp;
        }

        System.out.println(a + "," + b + "," + c);
    }
}

class B {
//    问题描述
//　　从1999年10月1日开始，公民身份证号码由15位数字增至18位。(18位身份证号码简介)。升级方法为：
//            　　1、把15位身份证号码中的年份由2位(7,8位)改为四位。
//            　　2、最后添加一位验证码。验证码的计算方案：
//            　　将前 17 位分别乘以对应系数 (7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2) 并相加，然后除以
//    11 取余数，0-10 分别对应 1 0 x 9 8 7 6 5 4 3 2。
//            　　请编写一个程序，用户输入15位身份证号码，程序生成18位身份证号码。假设所有要升级的身份证
//    的四位年份都是19××年

    public static void IDnumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入十五位的身份证号码：");
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        int[] arr1 = new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[18];

        for (int i = 0; i < arr.length; i++) { //将char类型的数组转换为int类型
            arr2[i] = charToInt(arr[i]);
        }
        for (int i = 0; i < arr3.length-1; i++) {
            if(i < 6){
                arr3[i] = arr2[i];
            }else if (i == 6){
                arr3[i] = 1;
            }else if (i == 7) {
                arr3[i] = 9;
            }else {
                arr3[i] = arr2[i-2];
            }
        }

        int sum = 0;
        System.out.println("十八位的身份证号码为：");
        for (int i = 0; i < arr3.length-1; i++) {
            if(i < 17){
                sum += arr3[i]*arr1[i];
            }
            System.out.print(arr3[i]);
        }
        char result = 0;
        switch (sum % 11){
            case 0:
                result = '1';
                break;
            case 1:
                result = '0';
                break;
            case 2:
                result = 'x';
                break;
            case 3:
                result = '9';
                break;
            case 4:
                result = '8';
                break;
            case 5:
                result = '7';
                break;
            case 6:
                result = '6';
                break;
            case 7:
                result = '5';
                break;
            case 8:
                result = '4';
                break;
            case 9:
                result = '3';
                break;
            case 10:
                result = '2';
                break;
                default:
                    break;
        }
        System.out.print(result);
    }

    public static int charToInt(char c){
        return c - '0';
    }
}