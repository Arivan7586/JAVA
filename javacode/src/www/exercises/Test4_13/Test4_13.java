package www.exercises.Test4_13;
import java.util.Iterator;
import java.util.*;


public class Test4_13 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.change(100));
//        System.out.println(solution.isHappy(19));
//
//        System.out.println("------------------");
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.isUgly(6));
//        System.out.println(solution1.isUgly(8));
//        System.out.println(solution1.isUgly(14));
//
//        System.out.println("----------------------");
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.isPrimeNumber(2));
//        System.out.println(solution2.isPrimeNumber(11));
//        System.out.println(solution2.isPrimeNumber(89));
//        System.out.println(solution2.isPrimeNumber(88));
//        System.out.println(solution2.countPrimes(10));
//        System.out.println(solution2.countPrimes(499979));
//        System.out.println(solution2.countPrimes(1500000));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.findComplement(5));
        System.out.println(solution3.findComplement(1));
    }
}

class Solution {
    /**
     * 编写一个算法来判断一个数是不是“快乐数”。
     *
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
     * 那么这个数就是快乐数。
     * @param n 要判断的数字
     * @return
     */
    public boolean isHappy(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (true) {
            if (change(n) == 1) {
                return true;
            }else {
                if (list.contains(n)) {
                    return false;
                }
                list.add(n);
                n = change(n);
            }
        }
    }
    public int change(int n) {
        int value = 0;
        while (n > 0) {
            value += Math.pow(n%10,2);
            n /= 10;
        }
        return value;
    }
}

class Solution1 {
    /**
     * 编写一个程序判断给定的数是否为丑数。
     *
     * 丑数就是只包含质因数 2, 3, 5 的正整数。
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (true) {
            if (num == 1 || num == 2 || num == 3 || num == 5) {
                return true;
            }
            if (num%2 == 0) {
                num /= 2;
            }else if (num%3 == 0) {
                num /= 3;
            }else if (num%5 == 0) {
                num /= 5;
            }else {
                return false;
            }
        }
    }
}

class Solution2 {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i++) {
            if (i%2 != 0 && isPrimeNumber(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断一个数是否是质数
     * @param n
     * @return
     */
    public boolean isPrimeNumber(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution3 {
    /**
     * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
     * 给定的整数保证在32位带符号整数的范围内。
     * 你可以假定二进制数不包含前导零位。
     * @param num
     * @return
     */
    public int findComplement(int num) {
        if (num <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        //将给定数字转为二进制
        while (num > 0) {
            list.add(num % 2);
            num /= 2;
        }
        //二进制取反并转换为10进制，再求和
        int flag = 1;
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                list.set(i,0);
            }else {
                list.set(i,1);
            }
            res += list.get(i)*flag;
            flag *= 2;
        }
        return res;
    }
}