package Test5_30;

import java.util.Scanner;

public class practice5_30 {

    public static void main(String[] args) {

//        Solution.solution();
//        Solution1.solution();
//        Robot robot = new Robot();
//        System.out.println(robot.countWays(2,2));

        Solution2.solution();
    }
}

class Solution {
    /**
     * 末尾0的个数
     *
     * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = n/5 + n/25 + n/125 + n/625;
        System.out.println(sum);
    }
}

class Solution1 {
    /**
     *回文解码
     *
     * 现在有一个字符串，你要对这个字符串进行 n 次操作，每次操作给出两个数字：(p, l)
     * 表示当前字符串中从下标为 p 的字符开始的长度为 l 的一个子串。
     * 你要将这个子串左右翻转后插在这个子串原来位置的正后方，求最后得到的字符串是什么。
     * 字符串的下标是从 0 开始的，你可以从样例中得到更多信息。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            StringBuilder str = new StringBuilder(in.nextLine());
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = start + in.nextInt();
                String value = str.substring(start,end);
                StringBuilder s = new StringBuilder(value);
                str.insert(end,s.reverse());
            }
            System.out.println(str);
        }
    }
}

class Robot {
    /**
     * 机器人走方格
     *
     * 有一个X*Y的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角
     * 。请设计一个算法，计算机器人有多少种走法。
     * 给定两个整数int X， int Y，请返回机器人的走法数目。保证x+y小于等于12
     *
     * @param x 给定x
     * @param y 给定y
     * @return 返回走法
     */
    public int countWays(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        return run(0,0,x,y);
    }
    private int run(int i, int j, int x, int y) {
        if (i == x - 1 && j == y - 1) {
            return 1;
        }
        int count = 0;
        if (i < x - 1) {
            count += run(i+1,j,x,y);
        }
        if (j < y - 1) {
            count += run(i, j+1,x,y);
        }
        return count;
    }
}

class Solution2 {
    /**
     * Fibonacci数列
     *
     * 在Fibonacci数列中的数我们称为FiBonacci数。
     * 给定一个N，你想让其变为一个Fibonacci数。每一步你可以把当前数X变为X-1或者
     * X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= 30; i++) {
            int sum = Math.abs(n - fibonacci(i));
            count = count < sum ? count : sum;
        }
        System.out.println(count);
    }
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n - 2);
        }
    }
}