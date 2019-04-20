package www.exercises.Test4_20;

public class Test4_20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bitwiseComplement(5));
        System.out.println(solution.bitwiseComplement(7));
        System.out.println(solution.bitwiseComplement(10));

        System.out.println("---------------");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.reverse(123));
        System.out.println(solution1.reverse(-123));
        System.out.println(solution1.reverse(120));
        System.out.println(solution1.reverse((int)Math.pow(2,31)-1));
        System.out.println(solution1.reverse((int)Math.pow(-2,31)));

        System.out.println("---------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.reverseBits(43261596));
        System.out.println(solution2.reverseBits(25472524));

        System.out.println("---------------");
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.hammingWeight(7));
        System.out.println(solution3.hammingWeight(128));
    }
}

class Solution {
    /**
     * 十进制整数的反码
     * @param N 给定的十进制整数
     * @return 返回反码对应的十进制整数
     */
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        StringBuilder str = decimalToBinary(N);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                str.replace(i,i+1,"1");
            }else {
                str.replace(i,i+1,"0");
            }
        }
        return binaryToDecimal(str);
    }

    /**
     * 将十进制整数转为二进制数
     * @param n 给定的十进制数
     * @return 返回转换后的二进制字符串
     */
    private StringBuilder decimalToBinary(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append(n%2);
            n >>= 1;
        }
        return stringBuilder;
    }

    /**
     * 将二进制字符串转换为对应的十进制整数
     * @param str 给定的二进制字符串
     * @return 返回对应的整数
     */
    private int binaryToDecimal(StringBuilder str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            value += Integer.parseInt(String.valueOf(str.charAt(i)))*Math.pow(2,i);
        }
        return value;
    }
}

class Solution1 {
    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x 给定整数
     * @return 返回反转后的值
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        boolean flag = false;
        if (stringBuilder.charAt(0) == '-') {
            stringBuilder.replace(0,1,"");
            flag = true;
        }
        stringBuilder.reverse();
        while (stringBuilder.charAt(0) == '0') {
            stringBuilder.replace(0,1,"");
        }
        long value = Long.parseLong(String.valueOf(stringBuilder));
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        }
        if (flag) {
            return -(int)value;
        }
        return (int)value;
    }
}

class Solution2 {
    // you need treat n as an unsigned value

    /**
     * 颠倒二进制位
     * @param n 给定的无符号十进制整数
     * @return 返回点到后的无符号二进制整数
     */
    public int reverseBits(int n) {
        int value = 0;
        for (int i = 0; i <= 31; i++) {
            value += (1&(n>>i)) << (31-i);
        }
        return value;
    }
}

class Solution3 {
    // you need to treat n as an unsigned value

    /**
     * 位1的个数
     * 编写一个函数，输入是一个无符号整数，
     * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while (n != 0 && i < 32) {
            if ((n&1) == 1) {
                count++;
            }
            n >>= 1;
            i++;
        }
        return count;
    }
}