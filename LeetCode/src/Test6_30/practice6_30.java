package Test6_30;

import java.util.ArrayList;
import java.util.Arrays;

public class practice6_30 {

    public static void main(String[] args) {

        String[] str = new String[]{"flower","flow","flight"};
        String[] str1 = new String[]{"dog","racecar","car"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(str1));
//        String[] v = Arrays.copyOf(str,str.length - 1);
//        for (String s : v) {
//            System.out.println(s);
//        }
    }
}

//最长公共前缀

class Solution {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs 给定字符串数组
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        int n = strs.length;
        if (n == 1) {
            return strs[0];
        }
        String[] arr = Arrays.copyOf(strs,n-1);
        String value = longestCommonPrefix(arr);
        int i = 0;
        String res = "";
        while (i < value.length() && i < strs[n-1].length()) {
            if (value.charAt(0) != strs[n-1].charAt(0)) {
                return "";
            }
            if (value.charAt(i) == strs[n-1].charAt(i)) {
                res += value.charAt(i);
            }
            i++;
        }
        return res;
    }
}


//二叉搜索树中第K小的元素

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        add(root,list);
        return list.get(k-1);
    }
    private void add(TreeNode node,ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        add(node.left,list);
        list.add(node.val);
        add(node.right,list);
    }
}