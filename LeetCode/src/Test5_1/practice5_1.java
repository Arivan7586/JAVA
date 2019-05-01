package Test5_1;

import java.util.HashSet;
import java.util.LinkedList;

public class practice5_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = solution.shortestToChar("loveleetcode", 'e');
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.distributeCandies(new int[]{1,1,2,2,3,3}));
        System.out.println(solution1.distributeCandies(new int[]{1,1,2,3}));

        System.out.println("----------------------");
        Solution2 solution2 = new Solution2();
        int[] res = solution2.nextGreaterElement(
                new int[]{4,1,2},new int[]{1,3,4,2});
        int[] res1 = solution2.nextGreaterElement(
                new int[]{2,4},new int[]{1,2,3,4});
        for (int i : res1) {
            System.out.print(i+",");
        }
        System.out.println();

    }
}

class Solution {
    /**
     * 字符的最短距离
     * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S
     * 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
     *
     * @param S 给定字符串
     * @param C 给定字符
     * @return 返回最短距离数组
     */
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.equals("")) {
            return new int[]{};
        }
        int[] arr = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = shortestDistance(S, C, i);
        }
        return arr;
    }

    /**
     * 求出给定字符串中给定下标的字符距离目标字符的最短距离
     * @param s 给定字符串
     * @param c 给定字符
     * @param index 给定下标
     * @return 返回最小距离
     */
    private int shortestDistance(String s, char c, int index) {
        int l = 0;
        int r = 0;
        if (s.charAt(index) == c) {
            return 0;
        }
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                r = i - index;
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                l = index - i;
                break;
            }
        }
        if (r == 0 || l == 0) {
            return r == 0 ? l : r;
        }
        return r <= l ? r : l;
    }
}

class Solution1 {
    /**
     * 分糖果
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，
     * 每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
     * 返回妹妹可以获得的最大糖果的种类数。
     * @param candies 给定代表糖果的数组
     * @return 返回妹妹最大糖果的种类数
     */
    public int distributeCandies(int[] candies) {
//        LinkedList<Integer> list = new LinkedList<>();
//        int i = 0;
//        int count = 0;
//        int length = candies.length;
//        while (count < length/2 && i < length) {
//            int value = candies[i++];
//            if (!list.contains(value)) {
//                list.add(value);
//                count++;
//            }
//        }
//        return count == length ? length/2 : list.size();

        int length = candies.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 2*length; i++) {
            set.add(candies[i]);
            if (set.size() == length) {
                return length;
            }
        }
        int count = set.size();
        return count >= length ? length : count;
    }
}

class Solution2 {
    /**
     * 下一个更大元素Ⅰ
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的
     * 第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * @param nums1 给定数组1
     * @param nums2 给定数组2
     * @return 返回符合条件的元素
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0
        || nums2.length == 0) {
            return new int[]{};
        }
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nextLargestNumber(nums1[i],nums2);
        }
        return arr;
    }
    private int nextLargestNumber(int value, int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                flag = true;
            }
            if (arr[i] > value && flag) {
                return arr[i];
            }
        }
        return -1;
    }
}