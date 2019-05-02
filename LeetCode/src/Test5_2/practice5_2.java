package Test5_2;

import java.util.ArrayList;
import java.util.List;

public class practice5_2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        Solution solution = new Solution();
        System.out.println(solution.largestTriangleArea(arr));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.arrangeCoins(0));
        System.out.println(solution1.arrangeCoins(5));
        System.out.println(solution1.arrangeCoins(8));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.fizzBuzz(15));

    }
}

class Solution {
    /**
     * 最大三角形面积
     * 给定包含多个点的集合，从其中取出三个点组成三角形，返回能组成的最大三角形的面积
     *
     * @param points 给定的集合
     * @return 返回最大三角形的面积
     */
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int length = points.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    double area = (points[i][0] * points[j][1]
                            + points[j][0] * points[k][1] + points[k][0] * points[i][1]
                            - points[i][0] * points[k][1] - points[j][0] * points[i][1]
                            - points[k][0] * points[j][1]) / 2.0;
                    area = Math.abs(area);
                    maxArea = maxArea >= area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }
}

class Solution1 {
    /**
     * 排列硬币
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * <p>
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * <p>
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * @param n 给定硬币个数
     * @return 返回行数
     */
    public int arrangeCoins(int n) {
        int k = 1;
        while (k <= n) {
            n -= k;
            k++;
        }
        return k == n ? k : (k - 1);
    }
}

class Solution2 {
    /**
     * Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     * @param n 给定数字
     * @return 返回符合要求的List
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        if (n == 0) {
            return list;
        }
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0) {
                list.add("FizzBuzz");
            } else if (i%3 == 0) {
                list.add("Fizz");
            } else if (i%5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}