package Test7_19;

import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class practice7_19 {

    public static void main(String[] args) {

//        Solution.solution();

//        Solution2.solution();

        Solution3.solution();

        System.out.println(Solution3.isTrue("A10"));
    }
}

//删除公共字符串
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String sourse = in.nextLine();
            String target = in.nextLine();
            for (int i = 0; i < target.length(); i++) {
                char value = target.charAt(i);
                sourse = sourse.replace(String.valueOf(value),"");
            }
            System.out.println(sourse);
        }
        in.close();
    }
}

//句子逆序
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String sentence = in.nextLine();
            String[] arr = sentence.trim().split(" ");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.print(arr[i]);
                if (i != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        in.close();
    }
}

//连续最大和
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                if (i > 0) {

                }
            }
            int max = arr[0];
            int sum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (sum >= 0) {
                    sum += arr[i];
                } else {
                    sum = arr[i];
                }
                max = sum > max ? sum : max;
            }
            System.out.println(max);
        }
        in.close();
    }
}

//坐标移动
class Solution3 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            String[] arr = input.trim().split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < arr.length; i++) {
                String value = arr[i];
                if (isTrue(value)) {
                    char flag = value.charAt(0);
                    int distance = Integer.parseInt(value.substring(1));
                    switch (flag) {
                        case 'A':
                            x -= distance;
                            break;
                        case 'D':
                            x += distance;
                            break;
                        case 'S':
                            y -= distance;
                            break;
                        case 'W':
                            y += distance;
                            break;
                            default:
                                break;
                    }
                }
            }
            System.out.println("(" + x + "," + y + ")");
        }
        in.close();
    }

    /**
     * 校验输入的移动命令是否合法
     * @param str 给定移动命令
     * @return 合法返回true，否则返回false
     */
    public static boolean isTrue(String str) {
        if (str == null || str == "") {
            return false;
        }
        if (str.length() > 3 || str.length() <= 1) {
            return false;
        }
        if (str.charAt(0) != 'A' && str.charAt(0) != 'D' &&
                str.charAt(0) != 'S' && str.charAt(0) != 'W') {
            return false;
        }
        if (str.charAt(1) == '0' && str.length() == 3 && str.charAt(2) != '0') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }
}