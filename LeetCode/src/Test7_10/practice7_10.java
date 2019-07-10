package Test7_10;

import java.util.Scanner;

public class practice7_10 {

    public static void main(String[] args) {

//        Solution.solution();
//        System.out.println(Solution.run("14.16.27", "14.1.28"));
//        System.out.println(Solution.run("14.16.27", "0.0.0"));
//        System.out.println(Solution.run("0.0.0", "14.1.28"));

        Count2 count2 = new Count2();
        System.out.println(count2.countNumberOf2s(10));
        System.out.println(count2.countNumberOf2s(20));

    }
}


//在霍格沃茨找零钱
class Solution {
    /**
     * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的
     * ：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
     *
     * 十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，
     * 你的任务是写一个程序来计算他应该被找的零钱。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int[] money = new int[]{29 * 17, 29, 1};
        while (in.hasNext()) {
            String[] P = in.next().trim().split("\\.");
            String[] A = in.next().trim().split("\\.");
            int[] arr1 = new int[3];
            int[] arr2 = new int[3];
            for (int i = 0; i < P.length; i++) {
                arr2[i] = Integer.parseInt(P[i]);
                arr1[i] = Integer.parseInt(A[i]);
            }
            int ta = arr1[0] * money[0] + arr1[1] * money[1] + arr1[2] * money[2];
            int tp = arr2[0] * money[0] + arr2[1] * money[1] + arr2[2] * money[2];
            int value = ta - tp;
            if (value < 0) {
                System.out.print("-");
                value = -value;
            }
            System.out.println(value / money[0] + "." + value % money[0] / money[1]
                    + "." + value % money[0] % money[1] / money[2]);
        }
        in.close();
    }

    public static void solution1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String P = in.next();
            String A = in.next();
            System.out.println(run(P, A));
        }
        in.close();
    }

    public static String run(String p, String a) {
        String[] arr1 = p.trim().split("\\.");
        String[] arr2 = a.trim().split("\\.");
        int[] res = new int[3];
        int flag = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            int value1 = Integer.parseInt(arr1[i]);
            int value2 = Integer.parseInt(arr2[i]) - flag;
            if (value1 < value2) {
                res[i] = value2 - value1;
                flag = 0;
            } else if (value1 > value2) {
                flag = 1;
                if (i == 2) {
                    value2 += 29;
                } else if (i == 1) {
                    value2 += 17;
                }
                res[i] = value2 - value1;
            } else {
                res[i] = 0;
                flag = 0;
            }
        }
        return res[0] + "." + res[1] + "." + res[2];
    }
}

//2的个数
class Count2 {
    public int countNumberOf2s(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '2') {
                    sum++;
                }
            }
        }
        return sum;
    }
}