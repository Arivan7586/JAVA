package Test5_5;

import java.util.ArrayList;

public class practice5_5 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(10));
        System.out.println(solution.rotatedDigits(857));

        Solution1 solution1 = new Solution1();
        int[] arr = solution1.diStringMatch("IDID");
        int[] arr1 = solution1.diStringMatch("III");
        int[] arr2 = solution1.diStringMatch("DDI");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Solution {

    /**
     * 旋转数字
     * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
     * 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
     *
     * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
     * 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9
     * 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
     *
     * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
     * @param N
     * @return 返回符合要求的数的个数
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isGoodNumber(int value) {
        String str = String.valueOf(value);
        if (str.contains("3") || str.contains("4") || str.contains("7")) {
            return false;
        }
        if (str.contains("2") || str.contains("5")
                || str.contains("6") || str.contains("9")) {
            return true;
        }
        return false;
    }
}

class Solution1 {

    /**
     * 增减字符串匹配
     * @param S 给定字符串
     * @return 返回符合要求的数组
     */
    public int[] diStringMatch(String S) {
        int first = 0;
        int end = S.length();
        int[] res = new int[end + 1];
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[index++] = first++;
            }else {
                res[index++] = end--;
            }
        }
        res[S.length()] = end;
        return res;
    }
}