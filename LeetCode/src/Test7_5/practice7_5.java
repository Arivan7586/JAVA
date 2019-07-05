package Test7_5;

import java.util.Scanner;

public class practice7_5 {

    public static void main(String[] args) {

        Solution.solution();
        Solution1.solution();
    }
}

//守形数
class Solution {
    /**
     * 守形数是这样一种整数，它的平方的低位部分等于它本身。 比如25的平方是625，低位部分是25，
     * 因此25是一个守形数。 编一个程序，判断N是否为守形数。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int value = in.nextInt();
            if (isTrue(value)) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
        }
        in.close();
    }

    private static boolean isTrue(int value) {
        String str1 = String.valueOf(value);
        int math = (int) Math.pow(value, 2);
        String str2 = String.valueOf(math);
        if (math == value) {
            return true;
        }
        int n = str1.length();
        String res = str2.substring(str2.length() - n);
        if (str1.equals(res)) {
            return true;
        }
        return false;
    }
}

//密码验证合格程序
class Solution1 {
    /**
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度超2的子串重复
     * 说明:长度超过2的子串
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.nextLine();
            if (isTrue(value)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        in.close();
    }

    /**
     * 判断给定字符串是否为合格的密码
     * @param value 给定字符串
     * @return
     */
    private static boolean isTrue(String value) {
        if (value == null || value.length() <= 8) {
            return false;
        }
        int bigLetter = 0;
        int littleLetter = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c >= 48 && c <= 57) {
                num = 1;
            } else if (c >= 65 && c <= 90) {
                bigLetter = 1;
            } else if (c >= 97 && c <= 122) {
                littleLetter = 1;
            } else {
                other = 1;
            }
        }
        if (bigLetter + littleLetter + num + other < 3) {
            return false;
        }

        for (int i = 0; i < value.length() - 2; i++) {
            String substr1 = value.substring(i, i + 3);
            if (value.substring(i + 1).contains(substr1)) {
                return false;
            }
        }
        return true;
    }
}