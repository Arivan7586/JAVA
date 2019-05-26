package Test5_26;

import java.util.*;

public class practice5_26 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.minAddToMakeValid("())"));
        System.out.println(solution.minAddToMakeValid("((("));
        System.out.println(solution.minAddToMakeValid("()"));
        System.out.println(solution.minAddToMakeValid("()))(("));

        System.out.println("---------------------");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.InversePairs(new int[]{1,2,3,4,5,6,7,0}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subsets(new int[]{1,2,3}));


    }
}

class Solution {
    /**
     * 使括号有效的最少添加
     * @param S 需要操作的字符串
     * @return 返回最少需要添加的字符
     */
    public int minAddToMakeValid(String S) {
        if (S == null || S.equals("")) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char value = S.charAt(i);
            if (value == '(') {
                stack.push(value);
            } else {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    stack.push(value);
                }
            }
        }
        return stack.size();
    }
}

class Solution1 {
    /**
     * 找出给定数组的逆序对的个数
     * @param array 给定数组
     * @return 返回逆序对的个数
     */
    public int InversePairs(int [] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        return findCount(array,0,array.length-1);
    }
    private int findCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int count = 0;
        count += findCount(arr,l,mid);
        count += findCount(arr,mid+1,r);
        count += merge(arr,l,mid,r);
        return count;
    }
    private int merge(int[] arr, int l, int mid, int r) {
        int count = 0;
        int[] a = new int[r-l+1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                a[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                a[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            a[k++] = arr[start++];
        }
        for (int m = 0; m < a.length; m++) {
            arr[l+m] = a[m];
        }
        return count;
    }
}

class Solution2 {
    /**
     * 子集
     *
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     * @param nums 给定的整数数组
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<Integer>());
        if (nums == null || nums.length == 0) {
            return list;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list1 = list.get(j);
                List<Integer> list2 = new LinkedList<>(list1);
                list2.add(nums[i]);
                list.add(list2);
            }
        }
        return list;
    }
}