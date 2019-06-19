package Test6_19;

import java.util.LinkedList;

public class practice6_19 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,9,20,15,7};
        print(arr);
    }
    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

//递增顺序查找树
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        add(root,list);
        TreeNode res = new TreeNode(list.get(0));
        TreeNode node = res;
        for (int i = 1; i < list.size(); i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
        return res;
    }
    private void add(TreeNode node,LinkedList<Integer> list) {
        if (node == null) {
            return;
        }
        add(node.left,list);
        list.add(node.val);
        add(node.right,list);
    }
}

//路径总和

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 */
class Solution2 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            val = x;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left,sum - root.val) ? true : hasPathSum(root.right,sum - root.val);
    }
}
