package www.exercises.Test3_28;

public class Test3_28 {
    public static void main(String[] args) {
        String str = "We Are Happy";
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace(new StringBuffer(str)));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.Fibonacci(9));

        System.out.println();
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.NumberOf1(Integer.MIN_VALUE));
        //2147483648
        System.out.println(Integer.MIN_VALUE);

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.Power(2.0,-1));
    }
}

class Solution { //将所有空格替换为 %20
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}

class Solution1 { //求第n个斐波那契数
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }else if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        while (n > 3) {
            a = b;
            b = c;
            c = a + b;
            n--;
        }
        return c;
    }
}

class Solution2 {
    public int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == Integer.MIN_VALUE) {
            n = 1;
        }
        int[] arr = new int[32];
        if (n > 0) {
            int num = 0;
            int i = arr.length - 1;
            while (n > 0) {
                arr[i] = n % 2;
                if (arr[i] == 1) {
                    num++;
                }
                i--;
                n /= 2;
            }
            return num;
        } else {
            n = -n;
            arr[0] = 1;
            int i = arr.length - 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
                i--;
                n /= 2;
            }
        }
        int sum = 1;
        int flag = 0;
        int i = arr.length - 1;
        while (i >= 1) {
            int value = arr[i] + 1 + flag;
            if (value >= 2) {
                arr[i] = value % 2;
                flag = value - arr[i];
            }else {
                arr[i] = value;
                flag = 0;
            }
            if (arr[i] == 1) {
                sum++;
            }
            i--;
        }
        return sum;
    }
}

class Solution3 {
    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
    public double Power(double base, int exponent) {
        double value = base;
        if (exponent > 0) {
            for (int i = 1; i < exponent; i++) {
                base *= value;
            }
            return base;
        }else if (exponent < 0) {
            exponent = -exponent;
            for (int i = 1; i < exponent; i++) {
                base *= value;
            }
            return 1/base;
        }else {
            return 1.0;
        }
    }
}