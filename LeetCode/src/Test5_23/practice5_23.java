package Test5_23;

import java.util.Scanner;
import java.util.Stack;

public class practice5_23 {

    public static void main(String[] args) {
//        Solution1.solution();

        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.chkParenthesis("(()())",6));
        System.out.println(parenthesis.chkParenthesis("()a()()",7));
        System.out.println(parenthesis.chkParenthesis("()(()()",7));
    }
}

class Solution {
    /**
     * 有序数组中的单一元素
     *
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，
     * 唯有一个数只会出现一次，找出这个数。
     * @param nums 给定有序数字
     * @return 返回单一的元素
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int j = 1;
        while (i < nums.length-1 && j < nums.length) {
            if (nums[i] != nums[j]) {
                return nums[i];
            }
            i += 2;
            j += 2;
        }
        if (i == nums.length-1) {
            return nums[i];
        }
        return 0;
    }
}

class Solution1 {
    /**
     * 字符串中找出连续最长的数字串
     *
     * 读入一个字符串str，输出字符串str中的连续最长的数字串
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String maxLength = "";
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                s.append(str.charAt(i));
            } else {
                maxLength = maxLength.length()<s.length()? String.valueOf(s) : maxLength;
                s = new StringBuilder();
            }
            if (i == str.length() - 1) {
                maxLength = maxLength.length()<s.length()? String.valueOf(s) : maxLength;
            }
        }
        System.out.println(maxLength);
    }
}

class Parenthesis {
    /**
     * 合法括号序列判断
     * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
     *
     * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串
     *
     * @param A 给定字符串
     * @param n 给定字符串的长度
     * @return
     */
    public boolean chkParenthesis(String A, int n) {
        if (A == null || A.equals("") || n%2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char value = A.charAt(i);
            if (value != '(' && value != ')') {
                return false;
            }
            if (value == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(value);
            }
        }
        return stack.isEmpty();
    }
}