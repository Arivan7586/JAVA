package Test5_18;

import java.net.Socket;
import java.util.ArrayList;

public class practice5_18 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(solution.maxProfit(new int[]{3,3}));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.LastRemaining_Solution(7,3));
        System.out.println(solution1.LastRemaining_Solution(10,3));

    }
}

class Solution {
    /**
     * 买卖股票的最佳时机Ⅱ
     * @param prices 给定股票价格数组
     * @return 返回最大利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] > min && prices[i] > prices[i+1]) {
                max = prices[i];
                sum += max - min;
                min = prices[i+1];
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        if (prices[prices.length-1] > min) {
            sum += prices[prices.length-1] - min;
        }
        return sum;
    }
}

class Solution1 {
    /**
     * 孩子们的游戏（圆圈中最后剩下的数）
     * @param n 孩子人数
     * @param m 给定的数
     * @return 返回最后一个孩子的编号
     */
    public int LastRemaining_Solution(int n, int m) {
        int flag = 0;
        int count = n;
        char[] arr = new char[n];
        int i = 0;
        while (count > 1) {
            if (arr[i] != '1') {
                if (flag == m-1) {
                    arr[i] = '1';
                    count--;
                    flag = 0;
                } else {
                    flag++;
                }
                if (count == 1) {
                    break;
                }
            }
            i++;
            if (i == n) {
                i = 0;
            }
        }
        return String.valueOf(arr).indexOf((char)0);
    }
}

class Solution2 {
    /**
     * 和为S的两个数
     *
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     *
     * @param array 给定数字
     * @param sum 给定的和
     * @return 返回符合条件的list
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>(2);
        if (array == null || array.length == 0) {
            return list;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]+array[j] == sum) {
                    int value = array[i]*array[j];
                    if (value < min) {
                        a = array[i];
                        b = array[j];
                        min = value;
                    }
                }
            }
        }
        if (a+b == sum) {
            list.add(a);
            list.add(b);
        }
        return list;
    }
}