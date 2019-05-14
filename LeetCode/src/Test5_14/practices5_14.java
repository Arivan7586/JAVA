package Test5_14;

import java.util.Date;

public class practices5_14 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare1(16));
        System.out.println(solution.isPerfectSquare1(14));
        System.out.println(solution.isPerfectSquare1(4));
        System.out.println(solution.isPerfectSquare1(2147483647));
        System.out.println(solution.isPerfectSquare1(808201));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.judgeSquareSum(5));
        System.out.println(solution1.judgeSquareSum(3));
        System.out.println(solution1.judgeSquareSum(Integer.MAX_VALUE));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.mySqrt(4));
        System.out.println(solution2.mySqrt(8));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.climbStairs(44));

    }
}

class Solution {
    /**
     * 有效的完全平方数
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     *
     * 说明：不要使用任何内置的库函数，如  sqrt。
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int i = 1;
        while (i <= num / 2) {
            if (i*i == num) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean isPerfectSquare1(int num) {
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}

class Solution1 {
    /**
     * 平方数之和
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);
        while (r >= l) {
            int sum = l*l + r*r;
            if (sum > c) {
                r--;
            } else if (sum < c) {
                l++;
            } else {
                return true;
            }
        }
        return false;
    }
}

class Solution2 {
    /**
     * x的平方根
     *
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //牛顿迭代法
        if (x == 0) {
            return 0;
        }
        double value1 = 0;
        double value2 = 1;
        while (value1 != value2) {
            value1 = value2;
            value2 = (value2 + x/value1) / 2;
        }
        return (int)value2;
    }
}

class Solution3 {
    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int sum = 0;
            int i = 1;
            int j = 2;
            int k = 3;
            while (k <= n) {
                sum = i + j;
                i = j;
                j = sum;
                k++;
            }
            return sum;
        }
    }
}

