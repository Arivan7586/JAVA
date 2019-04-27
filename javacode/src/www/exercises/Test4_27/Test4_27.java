package www.exercises.Test4_27;

import java.util.ArrayList;
import java.util.List;

public class Test4_27 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(solution.removeOuterParentheses("()()"));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getSum(2,3));
        System.out.println(solution1.getSum(1,3));
        System.out.println(solution1.getSum(-2,3));

        System.out.println("---------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.toHex(26));
        System.out.println(solution2.toHex(-1));

        //堆溢出
//        Error.HeapDumpOnOutOfMemoryError();
        // 栈溢出
//        try {
//            StackOverFlow.stackLeak();
//        }catch (Throwable e) {
//            System.out.println(StackOverFlow.stackLength);
//            throw e;
//        }
    }
}

class Solution {
    /**
     * 删除最外层的括号
     * @param S 给定的字符串
     * @return 返回删除操作之后的字符串
     */
    public String removeOuterParentheses(String S) {
        if (S == null || S.equals("")) {
            return S;
        }
        StringBuilder str = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (flag != 0) {
                    str.append(S.charAt(i));
                }
                flag++;
            } else {
                flag--;
                if (flag != 0) {
                    str.append(S.charAt(i));
                }
            }
        }
        return String.valueOf(str);
    }
}

class Solution1 {
    /**
     * 两数之和
     * 不使用运算符 + 和 - ，计算两整数 ​a 、b之和
     * @param a
     * @param b
     * @return 返回运算结果
     */
    public int getSum(int a, int b) {
        int sum;
        while (true) {
            sum = a ^ b;
            int flag = (a & b) << 1;
            if (flag == 0) {
                break;
            }
            a = sum;
            b = flag;
        }
        return sum;
    }
}

class Solution2 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder str = new StringBuilder();
        while (num != 0 && str.length() < 8) {
            int value = num & 0xf;
            switch (value) {
                case 10:
                    str.append("a");
                    break;
                case 11:
                    str.append("b");
                    break;
                case 12:
                    str.append("c");
                    break;
                case 13:
                    str.append("d");
                    break;
                case 14:
                    str.append("e");
                    break;
                case 15:
                    str.append("f");
                    break;
                default:
                    str.append(value);
                    break;
            }
            num >>= 4;
        }
        return String.valueOf(str.reverse());
    }

    /**
     * 将十进制整数转换为十六进制字符串
     * @param num 十进制整数
     * @return 返回十六进制字符串
     */
    private String decimalToHexadecimal(int num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            int value = num % 16;
            switch (value) {
                case 10:
                    str.append("a");
                    break;
                case 11:
                    str.append("b");
                    break;
                case 12:
                    str.append("c");
                    break;
                case 13:
                    str.append("d");
                    break;
                case 14:
                    str.append("e");
                    break;
                case 15:
                    str.append("f");
                    break;
                    default:
                        str.append(value);
                        break;
            }
            num /= 16;
        }
        return String.valueOf(str.reverse());
    }
}

class Error {
    public static void HeapDumpOnOutOfMemoryError() {
        List<Error> list = new ArrayList<>();
        while (true) {
            list.add(new Error());
        }
    }
}

class StackOverFlow {
    public static int stackLength = 0;
    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }
}