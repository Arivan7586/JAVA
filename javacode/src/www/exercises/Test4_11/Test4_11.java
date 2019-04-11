package www.exercises.Test4_11;

import java.util.ArrayList;
import java.util.List;

public class Test4_11 {
    public static void main(String[] args) {
//        String s = "abcde";
//        StringBuffer stringBuffer = new StringBuffer(s);
//        System.out.println(stringBuffer.reverse());
//        System.out.println(('5'- 48) + 3);

        Solution solution = new Solution();
        System.out.println(solution.StrToInt("+1")+124);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.contains(2));

        Solution1 solution1 = new Solution1();
        int[] arr = new int[1];
        System.out.println(solution1.duplicate(new int[]{2,3,1,0,2,5,3},7,arr));
        System.out.println(solution1.duplicate(new int[]{2,1,3,1,4},7,arr));

        System.out.println("---------------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPalindrome(121));
        System.out.println(solution2.isPalindrome(-121));
        System.out.println(solution2.isPalindrome(10));

        System.out.println("--------------------");
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.addDigits(38));
        System.out.println(solution3.addDigits(54));

    }
}

class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        StringBuffer s = new StringBuffer(str);
        s.reverse();
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int value = s.charAt(i) - 48;
                res += value*flag;
                flag *= 10;
            }else {
                if (i == s.length()-1 && s.charAt(i) == '-') {
                    res = -res;
                } else if (i == s.length()-1 && s.charAt(i) == '+'){
                    return res;
                } else {
                    return 0;
                }
            }
        }
        return res;
    }
}

class Solution1 {
    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
     * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * @param numbers 给定数组
     * @param length 给定数组的长度
     * @param duplication 存放重复元素的数组
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length <= 1) {
            return false;
        }
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }else {
                list.add(numbers[i]);
            }
        }
        return false;
    }

    public int duplicate1(int numbers[],int length,int [] duplication) {
        if (length <= 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return duplication[0];
            }else {
                list.add(numbers[i]);
            }
        }
        return -1;
    }
}

class Solution2 {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x 需要判断的数字
     * @return 是回文数，返回true，否则返回false；
     */
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int l = 0;
        int r = str.length() - 1;
        while (r >= l) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }
}

class Solution3 {
    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * @param num 给定的非负整数
     * @return
     */
    public int addDigits(int num) {
        while (num >= 10) {
            String str = String.valueOf(num);
            int value = 0;
            for (int i = 0; i < str.length(); i++) {
                value += str.charAt(i) - 48;
            }
            num = value;
        }
        return num;

//        if (num >= 10) {
//            num = num % 9;
//            if (num == 0) {
//                return 9;
//            }
//        }
//        return num;
    }
}