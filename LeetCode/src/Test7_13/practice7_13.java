package Test7_13;

import java.util.Scanner;

public class practice7_13 {

    public static void main(String[] args) {

//        Solution.solution();

        Solution1 solution1 = new Solution1();
        int[] arr = new int[]{3,8,5,1,7,8};
        System.out.println(solution1.calculateMax(arr));

    }
}

//百万富翁问题
class Solution {
    public static void solution() {
        int sum1;
        long sum2 = 1;
        sum1 = 10 * 30;
        for (int i = 0; i < 30; i++) {
            sum2 += Math.pow(2,i);
        }
        System.out.println(sum1 + " " + sum2);
    }
}

//风口的猪-中国牛市

/**
 * 已知一支股票连续n天的价格走势，以长度为n的整数数组表示，
 * 数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，
 * 但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。
 * 输入数值范围：2<=n<=100,0<=prices[i]<=100
 */
class Solution1 {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public int calculateMax(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = getMax(prices,0,i) +
                    getMax(prices,i+1,prices.length-1);
                sum = value > sum ? value : sum;
        }
        return sum;
    }
    private int getMax(int[] arr, int l, int r) {
        if (l >= arr.length) {
            return 0;
        }
        int min = arr[l];
        int value = 0;
        for (int i = l+1; i <= r; i++) {
            min = Math.min(arr[i],min);
            value = Math.max(value,arr[i]-min);
        }
        return value;
    }
}