package Test6_26;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice6_26 {

    public static void main(String[] args) {


    }
}

//二叉树的层平均值
class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组
     * @param root 给定二叉树的根节点
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double avg = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                avg += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(avg/n);
        }
        return list;
    }
}

//叶子相似的树
class Solution2 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
     *
     * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     *
     * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     *
     * @param root1 二叉树1的根节点
     * @param root2 二叉树2的根节点
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        run(root1,list1);
        run(root2,list2);

        if (list1.size() != list2.size()) {
            return false;
        }
        if (list1.size() == 0) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
    private void run(TreeNode node,LinkedList<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        run(node.left,list);
        run(node.right,list);
    }
}