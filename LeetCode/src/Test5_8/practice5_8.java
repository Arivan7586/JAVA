package Test5_8;

public class practice5_8 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        char[] arr = "+100".toCharArray();
        char[] arr1 = "5e2".toCharArray();
        char[] arr2 = "-123".toCharArray();
        char[] arr3 = "3.1416".toCharArray();
        char[] arr4 = "-1E-16".toCharArray();
        char[] arr5 = "12e".toCharArray();
        char[] arr6 = "1a3.14".toCharArray();
        char[] arr7 = "1.2.3".toCharArray();
        char[] arr8 = "+-5".toCharArray();
        char[] arr9 = "12e+4.3".toCharArray();
        System.out.println(solution.isNumeric(arr));
        System.out.println(solution.isNumeric(arr1));
        System.out.println(solution.isNumeric(arr2));
        System.out.println(solution.isNumeric(arr3));
        System.out.println(solution.isNumeric(arr4));
        System.out.println(solution.isNumeric(arr5));
        System.out.println(solution.isNumeric(arr6));
        System.out.println(solution.isNumeric(arr7));
        System.out.println(solution.isNumeric(arr8));
        System.out.println(solution.isNumeric(arr9));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.GetUglyNumber_Solution(10));
//        System.out.println(solution1.isUglyNumber(8));
    }
}

class Solution {
    /**
     * 表示数值的字符串
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        try {
            double value = Double.parseDouble(String.valueOf(str));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

class Solution1 {
    /**
     * 丑数
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        int count = 0;
        int i = 1;
        while (count < index) {
            if (isUglyNumber(i)) {
                count++;
            }
            i++;
        }
        return i - 1;
    }

    private boolean isUglyNumber(int index) {
        if (index <= 0) {
            return false;
        }
        while (true) {
            if (index == 1 || index == 2 || index == 3 || index == 5) {
                return true;
            }
            if (index%2 == 0) {
                index /= 2;
            } else if (index%3 == 0) {
                index /= 3;
            } else if (index%5 == 0) {
                index /= 5;
            } else {
                return false;
            }
        }
    }
}