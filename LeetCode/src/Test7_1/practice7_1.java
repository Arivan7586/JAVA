package Test7_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class practice7_1 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("aaaaaaaabbcaaab"));


        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getRow(6));
    }
}

//删除字符串中所有相邻重复项
class Solution {
    public String removeDuplicates(String S) {
        if (S.length() == 1) {
            return S;
        }
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i+1)) {
                if (i == 0) {
                    if (i+2 < S.length()) {
                        S = S.substring(i+2);
                    } else {
                        return "";
                    }
                } else {
                    String value = S.substring(0,i);
                    if (i+2 < S.length()) {
                        S = value + S.substring(i+2);
                    } else {
                        S = value;
                    }
                }
                i = -1;
            }
        }
        return S;
    }
    //方法二，使用栈解决
    public String removeDuplicates1(String S) {
        if (S.length() == 1) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
                continue;
            }
            if (S.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return String.valueOf(sb.reverse());

    }
}

//杨辉三角II
class Solution1 {

    //给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        if (rowIndex == 0) {
            list.add(1);
        } else if (rowIndex == 1) {
            list.add(1);
            list.add(1);
        } else {
            List<Integer> list1 = getRow(rowIndex-1);
            list.add(1);
            for (int i = 0; i < list1.size()-1; i++) {
                list.add(list1.get(i) + list1.get(i+1));
            }
            list.add(1);
        }
        return list;
    }
}

//二叉搜索树的最小绝对差
class Solution2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int getMinimumDifference(TreeNode root) {
        if (root.left == null && root.right == null) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            int value1 = Math.abs(root.val - maxNode(root.left).val);
            min = min < value1 ? min : value1;
            int value2 = getMinimumDifference(root.left);
            min = min < value2 ? min : value2;
        }
        if (root.right != null) {
            int value1 = Math.abs(root.val - minNode(root.right).val);
            min = min < value1 ? min : value1;
            int value2 = getMinimumDifference(root.right);
            min = min < value2 ? min : value2;
        }
        return min;
    }
    //取得二叉搜索树中值最大的节点
    private TreeNode maxNode(TreeNode node) {
        return node.right == null ? node : maxNode(node.right);
    }
    //取得二叉搜索树中值最小的节点
    private TreeNode minNode(TreeNode node) {
        return node.left == null ? node : minNode(node.left);
    }
}