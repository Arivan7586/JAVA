package Test7_8;

import java.net.Socket;
import java.util.Comparator;
import java.util.Scanner;

public class practice7_8 {

    public static void main(String[] args) {

//        System.out.println('3' - 0);
//        Solution.solution();

//        System.out.println(Solution1.compare("123456","123456"));
//        System.out.println(Solution1.compare("023456","123456"));
//        System.out.println(Solution1.compare("023456","1234"));
        Solution1.solution();


//        3
//        11111111111111111111111111111
//        2222222222222222222222222222222222
//        33333333


    }
}

//奇偶校验
class Solution {
    /**
     * 输入一个字符串，然后对每个字符串进行奇校验，最后输出校验后的二进制数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            run(input);
        }
        in.close();
    }
    private static void run(String str) {
        if (str == null) {
            return;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i] - 0;
            System.out.println(toBinary(value));
        }
    }
    private static String toBinary(int value) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (value > 0) {
            int flag = value & 1;
            if (flag == 1) {
                count++;
            }
             sb.append(flag);
            value >>= 1;
        }
        while (sb.length() < 7) {
            sb.append(0);
        }
        if (count % 2 == 0) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}

//大整数排序
class Solution1 {
    /**
     * 对N个长度最长可达到1000的数进行排序
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i= 0; i < n; i++) {
                arr[i] = in.next();
            }
            sort(arr);
            for (String str : arr) {
                System.out.println(str);
            }
        }
        in.close();
    }

    /**
     * 使用shell排序
     * @param arr 待排序数组
     */
    public static void sort(String[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n/2; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                String value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (compare(arr[k],value) > 0) {
                        arr[k+i] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k+i] = value;
            }
        }
    }

    /**
     * 对比两个字符串整数的大小
     * @param value1 字符串整数1
     * @param value2 字符串整数2
     * @return 1大于2，返回1，小于返回-1，相等返回0
     */
    public static int compare(String value1, String value2) {
        if (value1.equals(value2)) {
            return 0;
        }
        for (int i = 0; i < value1.length(); i++) {
            if (value1.charAt(i) != '0') {
                value1 = value1.substring(i);
                break;
            }
        }
        for (int i = 0; i < value2.length(); i++) {
            if (value2.charAt(i) != '0') {
                value2 = value2.substring(i);
                break;
            }
        }
        if (value1.length() < value2.length()) {
            return -1;
        } else if (value1.length() > value2.length()) {
            return 1;
        }
        for (int i = 0; i < value1.length(); i++) {
            if (value1.charAt(i) < value2.charAt(i)) {
                return -1;
            } else if (value1.charAt(i) > value2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }
}