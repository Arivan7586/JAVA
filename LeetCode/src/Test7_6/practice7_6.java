package Test7_6;

import java.util.Scanner;

public class practice7_6 {

    public static void main(String[] args) {

//        Solution.solution();

        Solution1.solution();
    }
}

//年会抽奖
class Solution {
    /**
     * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
     * 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
     * 2. 待所有字条加入完毕，每人从箱中取一个字条；
     * 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
     * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double n = in.nextDouble();
            double res = 1;
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
            res = chance(n) / res * 100;
            System.out.println(String.format("%.2f", res) + "%");
        }
        in.close();
    }

    private static double chance(double n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }
        return (n - 1) * (chance(n - 1) + chance(n - 2));
    }
}

//数字和为sum的方法数
class Solution1 {
    /**
     * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和
     * 为sum的方案数。
     * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(run(arr, 0, sum));
        }
        in.close();
    }

    private static int run(int[] arr, int i, int sum) {
        int res = 0;
        if (i >= arr.length) {
            return 0;
        }
        if (sum == arr[i]) {
            res += 1;
            res += run(arr, i + 1, sum);
        } else {
            res += run(arr, i + 1, sum);
            res += run(arr, i + 1, sum - arr[i]);
        }
        return res;
    }

    public static void solution1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = in.nextInt();
            int i, j;
            int arr[] = new int[n];
            for (i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(bag(arr, n, sum));
        }
        in.close();
    }

    public static long bag(int[] weight, int n, int sum) {
        long dp[] = new long[sum + 1];
        dp[0] = 1;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = sum; j >= weight[i]; j--) {
                dp[j] = dp[j - weight[i]] + dp[j];
            }
        }
        return dp[sum];
    }
}