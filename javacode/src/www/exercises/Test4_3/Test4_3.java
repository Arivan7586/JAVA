package www.exercises.Test4_3;

import java.util.Arrays;

public class Test4_3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int arr = solution.compress(new char[]{'a','a','b','b','c','c','c'});
//        int arr = solution.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
//        int a = solution.compress(new char[]{'a','a','a','b','b','a','a'});
//        int b = solution.compress(new char[]{'a','b','c'});
        int cc = solution.compress(new char[]{'a','a','a','a','b','a'});
        System.out.println(cc);

        Solution1 solution1 = new Solution1();
        System.out.println("----------------------");
        System.out.println(solution1.findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(solution1.findLengthOfLCIS(new int[]{2,2,2,2,2}));
        System.out.println(solution1.findLengthOfLCIS(new int[]{2}));
        System.out.println(solution1.findLengthOfLCIS(new int[]{2,1,3}));

        Solution2 solution2 = new Solution2();
        System.out.println("-------------------");
        System.out.println(solution2.numPairsDivisibleBy60(new int[]{60,60,60}));
        System.out.println(solution2.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        System.out.println(solution2.numPairsDivisibleBy60(new int[]{}));
        System.out.println(solution2.numPairsDivisibleBy60(new int[]
                {418,204,77,278,239,457,284,263,372,279,476,416,360,18}));

        Solution3 solution3 = new Solution3();
        System.out.println("-------------------------");
        System.out.println(solution3.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution3.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution3.pivotIndex(new int[]{-1,-1,1,1,0,0}));

    }
}

class Solution {
//    给定一组字符，使用原地算法将其压缩。
//
//    压缩后的长度必须始终小于或等于原数组长度。
//
//    数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//
//    在完成原地修改输入数组后，返回数组的新长度
    public int compress(char[] chars) {
        int index = 1;
        int count = 1;
        char value = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == value) {
                count++;
                if (i == chars.length -1) {
                    String str = String.valueOf(count);
                    for (int j = 0; j < str.length(); j++) {
                        chars[index++] = str.charAt(j);
                    }
                }
            } else {
                if (count != 1) {
                    String str = String.valueOf(count);
                    for (int j = 0; j < str.length(); j++) {
                        chars[index++] = str.charAt(j);
                    }
                }
                chars[index++] = chars[i];
                count = 1;
                value = chars[i];
            }
        }
        return index;
    }
}

class Solution1 {
    //给定一个未经排序的整数数组，找到最长且连续的的递增序列,并返回最长序列的长度
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        int max = 1;
        int count = 1;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] < nums[i+1]) {
                count++;
                max = max > count ? max : count;
            }else {
                count = 1;
            }
        }
        return max;
    }
}

class Solution2 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        if (n < 1) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((time[i]+time[j])%60 == 0) {
                    num++;
                }
            }
        }
        return num;
    }
}

class Solution3 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return -1;
        }
        int index = 1;
        if (Add(nums,1,n-1) == 0) {
            return 0;
        }
        while (index+1 < n) {
            if (Add(nums,0,index-1) == Add(nums,index+1,n-1)) {
                return index;
            }
            index++;
        }
        if (Add(nums,0,n-2) == 0) {
            return n-1;
        }
        return -1;
    }

    /**
     * 计算给定数组中指定区间元素的和
     * @param arr 给定数组
     * @param l 给定区间的左起点
     * @param r 给定区间的右终点
     * @return
     */
    public int Add(int[] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }
}