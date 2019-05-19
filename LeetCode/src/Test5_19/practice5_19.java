package Test5_19;

import java.util.Arrays;
import java.util.HashMap;

public class practice5_19 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.LeftRotateString("abcXYZdef",3));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.ReverseSentence("student. a am I"));
        System.out.println("1"+solution1.ReverseSentence(" ")+"1");
        System.out.println("  ".split(" ").length);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isContinuous(new int[]{0,3,2,6,4}));
        System.out.println(solution2.isContinuous(new int[]{1,3,2,6,4}));
        System.out.println(solution2.isContinuous(new int[]{1,2,3,4,5}));
        System.out.println(solution2.isContinuous(new int[]{1,0,0,1,0}));

    }
}

class Solution {
    /**
     * 左旋转字符串
     *
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
     * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
     * 请你把其循环左移K位后的序列输出。
     * @param str 给定字符串
     * @param n 需要操作的位数
     * @return 返回操作后的字符串
     */
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == n) {
            return str;
        } else if (str.length() > n) {
            return str.substring(n) + str.substring(0,n);
        }
        int length = Math.abs(n-str.length());
        return str.substring(length) + str.substring(0,length-1);
    }
}

class Solution1 {
    /**
     * 翻转单词顺序列
     *
     * @param str 给定句子
     * @return 返回翻转后的句子
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] arr = str.split(" ");
        if (arr.length <= 1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return String.valueOf(stringBuilder);
    }
}

class Solution2 {
    /**
     * 扑克牌顺子
     * @param numbers 给定纸牌数组
     * @return 返回是否能组成顺子
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 3) {
            return false;
        }
        int flag = 0;
        int clount = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                flag++;
            } else {
                if (numbers[i] == numbers[i+1]) {
                    return false;
                }
                clount += numbers[i+1] - numbers[i] - 1;
            }
        }
        if (clount > flag) {
            return false;
        }
        return true;
    }
}