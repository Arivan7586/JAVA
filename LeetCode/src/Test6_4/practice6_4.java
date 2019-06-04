package Test6_4;

import java.util.Arrays;
import java.util.Scanner;

public class practice6_4 {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        System.out.println(solution.AddLongInteger("123" , "456"));

//        Solution1.solution();

//        Solution2.solution();

        Solution3.solution();

    }
}

//超长正整数相加
class Solution {
    public String AddLongInteger(String addend,String augend) {
        if (addend == null) {
            return augend;
        } else if (augend == null) {
            return addend;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder str1 = new StringBuilder(addend);
        StringBuilder str2 = new StringBuilder(augend);
        int length = Math.max(str1.length(),str2.length());
        str1.reverse();
        str2.reverse();
        int flag = 0;
        int i = 0;
        while (i < length) {
            int a,b;
            if (i >= str1.length()) {
                a = 0;
            } else {
                a = str1.charAt(i) - 48;
            }
            if (i >= str2.length()) {
                b = 0;
            } else {
                b = str2.charAt(i) - 48;
            }
            int value = flag + a + b;
            res.append(value % 10);
            flag = value / 10;
            i++;
        }
        res = flag == 1 ? res.append(1) : res;
        return String.valueOf(res.reverse());
    }
}

//跟奥巴马一起编程
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] value = input.trim().split(" ");
        int n = Integer.parseInt(value[0]);
        if (n == 0) {
            return;
        }
        int row = n%2 == 0 ? n/2 : n/2 + 1;
        char flag = value[1].toCharArray()[0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == row - 1) {
                    System.out.print(flag);
                } else {
                    if (j == 0 || j == n - 1) {
                        System.out.print(flag);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}

//组个最小数（20）
class Solution2 {
    /**
     * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
     * 目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
     * 给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
     * 现给定数字，请编写程序输出能够组成的最小的数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(changeToMin(input));
    }
    private static String changeToMin(String value) {
        String[] strings = value.trim().split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            addChar(str,Integer.parseInt(strings[i]),i);
        }
        char[] arr = String.valueOf(str).toCharArray();
        Arrays.sort(arr);
        if (arr[0] != '0') {
            return String.valueOf(arr);
        }
        for (int i = 0; i < arr.length - 1;i++) {
            if (arr[i] != arr[i+1]) {
                char temp = arr[0];
                arr[0] = arr[i+1];
                arr[i+1] = temp;
                break;
            }
        }
        return String.valueOf(arr);
    }
    private static void addChar(StringBuilder str, int n, int c) {
        for (int i = 0; i < n; i++) {
            str.append(c);
        }
    }
}

//尼科彻斯定理
class Solution3 {
    /**
     * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     *
     * 例如：
     *
     * 1^3=1
     *
     * 2^3=3+5
     *
     * 3^3=7+9+11
     *
     * 4^3=13+15+17+19
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int value = in.nextInt();
            System.out.println(GetSequeOddNum(value));
        }
    }
    private static String GetSequeOddNum(int m) {
        StringBuilder str = new StringBuilder();
        int start = 0;
        if (m % 2 == 1) {
            start = m*m - 2*(m / 2);
        } else {
            start = m*m + 1 - 2*(m / 2);
        }
        for (int i = 0; i < m; i++) {
            str.append(start);
            if (i != m - 1) {
                str.append("+");
            }
            start += 2;
        }
        return String.valueOf(str);
    }
}