package Test6_2;

import java.util.*;

public class practice6_2 {

    public static void main(String[] args) {

        GrayCode grayCode = new GrayCode();
        String[] arr = grayCode.getGray(4);
        for (String i : arr) {
            System.out.println(i);
        }

    }
}

//无缓存交换
class Exchange {
    /**
     * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值，给定一个int数组AB
     * ，其第0个元素和第1个元素为待交换的值，请返回交换后的数组。
     * @param AB 待交换的数组
     * @return 返回交换后的数组1
     */
    public int[] exchangeAB(int[] AB) {
        if (AB == null || AB.length <= 1) {
            return AB;
        }
        AB[0] = AB[0]^AB[1];
        AB[1] = AB[0]^AB[1];
        AB[0] = AB[0]^AB[1];
        return AB;
    }
}

//生成格雷诺码
class GrayCode {
    /**
     * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码
     * 为格雷码，请编写一个函数，使用递归的方法生成n位的格雷码。
     * @param n 给定整数N
     * @return 返回n位的格雷码，顺序从0开始
     */
    public String[] getGray(int n) {
        LinkedList<String> list = new LinkedList<>();
        if (n == 1) {
            list.add("0");
            list.add("1");
            return list.toArray(new String[2]);
        } else {
            String[] str = getGray(n - 1);
            for (int i = 0; i < str.length; i++) {
                list.add("0" + str[i]);
            }
            for (int i = str.length-1; i >= 0; i--) {
                list.add("1" + str[i]);
            }
            return list.toArray(new String[list.size()]);
        }
    }
}

//二叉树中序遍历（非递归实现）
class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }

        }
        return list;
    }
}

//二叉树的层次遍历
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> value = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                value.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            list.add(value);
        }
        return list;
    }
}