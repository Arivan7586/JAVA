package Test6_22;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice6_22 {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

    }
}

//N叉树的层序遍历
class Solution {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * @param root 给定二叉树的根节点
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new LinkedList<>();
            while (size-- > 0) {
                Node node = queue.poll();
                list1.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node n : node.children) {
                        queue.add(n);
                    }
                }
            }
            list.add(list1);
        }
        return list;
    }
}

//二叉搜索树的最近公共祖先
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
     * （一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * @param root 带查找的二叉搜索树的根节点
     * @param p 需要找根节点的节点1
     * @param q 需要找根节点的节点2
     * @return 返回最近的父节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (haveNode(root.left,p) && haveNode(root.left,q)) {
            return lowestCommonAncestor(root.left,p,q);
        }
        if (haveNode(root.right,p) && haveNode(root.right,q)) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    private boolean haveNode(TreeNode node,TreeNode value) {
        if (node == null) {
            return false;
        }
        if (node == value) {
            return true;
        }
        return haveNode(node.left,value) ? true : haveNode(node.right,value);
    }
}