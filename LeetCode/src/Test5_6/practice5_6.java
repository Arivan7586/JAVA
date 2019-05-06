package Test5_6;

import java.util.LinkedList;
import java.util.List;

public class practice5_6 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimeSetBits(6, 10));
        System.out.println(solution.countPrimeSetBits(10, 15));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.readBinaryWatch(1));
        System.out.println(solution1.readBinaryWatch(0));
    }
}

class Solution {
    /**
     * 二进制表示中质数个计算位置
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * <p>
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101
     * 有 3 个计算置位。还有，1 不是质数。）
     *
     * @param L 左区间
     * @param R 右区间
     * @return 返回符合要求的数的个数
     */
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isCorresponding(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断给定数字的二进制数中1的个数是否是质数
     *
     * @param value 给定数字
     * @return 符合条件返回true，否则返回false
     */
    private boolean isCorresponding(int value) {
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
            }
            value >>= 1;
        }
        if (isPrimes(count)) {
            return true;
        }
        return false;
    }

    /**
     * 判断给定的数是否是质数
     *
     * @param value 给定的数
     * @return 是质数返回true，否则返回false
     */
    private boolean isPrimes(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    /**
     * 二进制手表
     * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
     *
     * 每个 LED 代表一个 0 或 1，最低位在右侧。
     * @param num 给定LED亮的个数
     * @return 返回对应的时间
     */
    public List<String> readBinaryWatch(int num) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (numberOfOne(i) + numberOfOne(j) == num) {
                    String time = i + ":" + (j >= 10 ? j : "0" + j);
                    list.add(time);
                }
            }
        }
        return list;
    }

    /**
     * 算出给定整数对应二进制数中1的个数
     * @param value 给定整数
     * @return 返回1的个数
     */
    private int numberOfOne(int value) {
        int count = 0;
        while (value > 0) {
            if ((value & 1) == 1) {
                count++;
            }
            value >>= 1;
        }
        return count;
    }
}

