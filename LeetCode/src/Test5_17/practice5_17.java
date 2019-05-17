package Test5_17;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class practice5_17 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(2001));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.optimalDivision(new int[]{1000, 100, 10, 2}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.canWinNim(4));
        System.out.println(solution2.canWinNim(5));
    }
}

class Solution {
    /**
     * 整数转罗马数字
     *
     * @param num 给定整数
     * @return 返回对应的罗马数字
     */
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[] value = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] key = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < 13; i++) {
            while (num >= key[i]) {
                res.append(value[i]);
                num -= key[i];
            }
        }
        return String.valueOf(res);
    }
}

class Solution1 {
    /**
     * 最优除法
     * <p>
     * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
     * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，
     * 才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
     *
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        } else if (n == 2) {
            return nums[0] + "/" + nums[1];
        } else {
            StringBuilder str = new StringBuilder(String.valueOf(nums[0]));
            str.append("/(");
            for (int i = 1; i < n; i++) {
                str.append(nums[i]);
                if (i != n - 1) {
                    str.append("/");
                }
            }
            str.append(")");
            return String.valueOf(str);
        }
    }
}

class Solution2 {
    /**
     * Nim游戏
     *
     * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，
     * 每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。
     * 你作为先手。
     * 你们是聪明人，每一步都是最优解。 编写一个函数，
     * 来判断你是否可以在给定石头数量的情况下赢得游戏。
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
//        if (n <= 3) {
//            return true;
//        }
        return !(n % 4 == 0);
    }
}

/**
 * 利用读写锁和HashMap实现缓存
 *
 * @param <K>
 * @param <V>
 */
class TestCache<K, V> {
    //存放具体数据
    private HashMap<K, V> map;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //并发读锁
    private Lock readLock = lock.readLock();
    //互斥写锁
    private Lock writeLock = lock.writeLock();

    public V getValue(K k) {
        readLock.lock();
        return map.get(k);
    }

    public void setValue(K k, V v) {
        writeLock.lock();
        map.put(k, v);
    }
}