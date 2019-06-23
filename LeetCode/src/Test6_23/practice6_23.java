package Test6_23;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class practice6_23 {

    public static void main(String[] args) {


    }
}

//N叉树的前序遍历（非递归解法）
class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
}

//二叉搜索树中的搜索
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return val < root.val ? searchBST(root.left,val) : searchBST(root.right,val);
    }
}

//N叉树的最大深度
class Solution2 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * N叉树的最大深度
     * @param root 给定N叉树的根节点
     * @return 返回N叉树的最大深度
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int max = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            max = depth > max ? depth : max;
        }
        return max + 1;
    }
}

//单值二叉树
class Solution3 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     * @param root 给定二叉树的根节点
     * @return 是单值二叉树，返回true，否则返回false
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            return root.val ==  root.right.val ? isUnivalTree(root.right) : false;
        }
        if (root.left != null && root.right == null) {
            return root.val ==  root.left.val ? isUnivalTree(root.left) : false;
        }
        if (root.val != root.left.val || root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) ? isUnivalTree(root.right) : false;
    }
}