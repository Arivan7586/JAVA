package www.exercises.Test4_12;
import java.util.*;

public class Test4_12 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("ZY"));
        System.out.println(solution.titleToNumber("AB"));
        System.out.println(solution.titleToNumber("AAA"));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findTheDifference("abcd","abcde"));
        System.out.println(solution2.findTheDifference("abcde","abecdn"));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.selfDividingNumbers(1,22));

        System.out.println("--------------------------");
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.repeatedNTimes(new int[]{1,2,3,3}));
        System.out.println(solution4.repeatedNTimes(new int[]{2,1,2,5,3,2}));
        System.out.println(solution4.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }
}

class Solution {
    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                int value = s.charAt(i) - 64;
                res = res*26 + value;
            }else {
                return 0;
            }
        }
        return res;
    }
}

class Solution1 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < n-1; i++) {
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        if (nums[n-1] != nums[n-2]) {
            return nums[n-1];
        }
        return 0;
    }
}

class Solution2 {
    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < s.length(); i++) {
            if (arr1[i] != arr2[i]) {
                return arr2[i];
            }
        }
        return arr2[t.length()-1];
    }
}

class Solution3 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDivisionMath(i)) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 判断给定数字是否是自除数
     * @param n 给定数字
     * @return 是自除数，返回true，否则返回false
     */
    public boolean isDivisionMath(int n) {
        int value = n;
        while (value > 0) {
            if (value%10 != 0 && n%(value%10) == 0) {
                value /= 10;
            }else {
                return false;
            }
        }
        return true;
    }
}

class Solution4 {
    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * @param A
     * @return 返回重复了 N 次的那个元素。
     */
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        if (A[0] == A[1]) {
            return A[0];
        }
        return A[A.length/2];
    }
}