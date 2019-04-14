package www.exercises.Test4_14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test4_14 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        ((LinkedList<Integer>) list).addFirst(7);
        ((LinkedList<Integer>) list).addFirst(8);
        System.out.println(list.get(1));

        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(218));
        System.out.println(solution.isPowerOfTwo(2147483647));
        System.out.println("------------------");
//
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.isPowerOfThree(27));
//        System.out.println(solution1.isPowerOfThree(0));
//        System.out.println(solution1.isPowerOfThree(9));
//        System.out.println(solution1.isPowerOfThree(45));
//
//        System.out.println("-----------------------");
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.isPowerOfFour(16));
//        System.out.println(solution2.isPowerOfFour(5));

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.reverseBits(43261596));

    }
}

class Solution {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == Integer.MAX_VALUE) {
            return false;
        }
        int i = 0;
        int value = 0;
        while (value <= n) {
            value = (int) Math.pow(2,i);
            if (n == value) {
                return true;
            }
            i++;
        }
        return false;
    }
}

class Solution1 {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 3 的幂次方
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == Integer.MAX_VALUE) {
            return false;
        }
        int i = 0;
        int value = 0;
        while (value <= n) {
            value = (int) Math.pow(3,i);
            if (n == value) {
                return true;
            }
            i++;
        }
        return false;
    }
}

class Solution2 {
    /**
     * 给定一个整数，编写一个函数来判断它是否是 4 的幂次方
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        if (num == Integer.MAX_VALUE) {
            return false;
        }
        int i = 0;
        int value = 0;
        while (value <= num) {
            value = (int) Math.pow(4,i);
            if (num == value) {
                return true;
            }
            i++;
        }
        return false;
    }
}

class Solution4 {
    // you need treat n as an unsigned value

    /**
     * 颠倒二进制位
     * 颠倒给定的 32 位无符号整数的二进制位。
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }else if (n < 0) {
            n = -n;
        }
        //将给定的整数转换为二进制
        ArrayList<Integer> list = new ArrayList<>(32);
        while (n > 0) {
            list.add(n%2);
            n /= 2;
        }
        if (list.size() < 32) {
            for (int i = list.size(); i < 32; i++) {
                list.add(0);
            }
        }
        int res = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            res += list.get(i)*Math.pow(2,32-1-i);
        }
        return res;
    }
}