package Test7_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practice7_20 {

    public static void main(String[] args) {

//        Solution.solution();

//        System.out.println((char)('a' - 32));
//        System.out.println((char) (('a' - 97 + 1) % 26 + 65));
//        System.out.println((char) (('Z' - 65 + 1) % 26 + 97));
//        System.out.println((char) (('0' + 1 - 48) % 10 + 48));
//
//        System.out.println((char) (('a' - 97 - 1) % 26 + 65)); //Z
//        System.out.println((char) (('B' - 65 - 1) % 26 + 97)); //y
//        System.out.println((char) (('0' - 1 - 48) % 10 + 48)); //9

        Solution1.solution();

    }
}

//计算日期到天数的转换
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            System.out.println(change(year,month,day));;
        }
        in.close();
    }

    private static int change(int year, int month, int day) {
        if (year < 0 || month <= 0 || month > 12 || day > 31 || day <= 0) {
            return -1;
        }
        //如果给定年份是闰年
        if (isLeapYear(year)) {
            if (month == 2 && day > 29) {
                return -1;
            }
            return addDay(year,month,day);
        } else {
            if (month == 2 && day > 28) {
                return -1;
            }
            return addDay(year,month,day);
        }
    }

    /**
     * 判断给定年份是否为闰年
     * @param year 给定年份
     * @return 闰年返回true，否则返回false
     */
    private static boolean isLeapYear(int year) {
        return year % 4 == 0 || year % 400 == 0;
    }

    /**
     * 计算某年某月某日是本年中的第多少天
     * @param year 年
     * @param month 月
     * @param day 日
     * @return
     */
    private static int addDay(int year, int month, int day) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                sum += 31;
            } else if (i == 2) {
                if (isLeapYear(year)) {
                    sum += 29;
                } else {
                    sum += 28;
                }
            } else {
                sum += 30;
            }
        }
        return sum + day;
    }
}


//字符串加密与解密
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value1 = in.nextLine();
            String value2 = in.nextLine();
            System.out.println(encode(value1));
            System.out.println(decode(value2));
        }
        in.close();
    }

    /**
     * 加密字符串
     * @param target
     * @return
     */
    private static String encode(String target) {
        StringBuilder sb = new StringBuilder();
        char[] arr = target.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char value = arr[i];
            if (value >= 'a' && value < 'z') {
                value = (char) (value + 1 - 32);
            } else if (value == 'z') {
                value = 'A';
            } else if (value >= 'A' && value < 'Z') {
                value = (char) (value + 1 + 32);
            } else if (value == 'Z') {
                value = 'a';
            } else if (value >= '0' && value < '9') {
                value = (char) (value + 1);
            } else if (value == '9') {
                value = '0';
            }
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * 解密字符串
     * @param target
     * @return
     */
    private static String decode(String target) {
        StringBuilder sb = new StringBuilder();
        char[] arr = target.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char value = arr[i];
            if (value > 'a' && value <= 'z') {
                value = (char) (value - 1 - 32);
            } else if (value == 'a') {
                value = 'Z';
            } else if (value > 'A' && value <= 'Z') {
                value = (char) (value - 1 + 32);
            } else if (value == 'A') {
                value = 'z';
            } else if (value > '0' && value <= '9') {
                value = (char) (value - 1);
            } else if (value == '0') {
                value = '9';
            }
            sb.append(value);
        }
        return sb.toString();
    }
}