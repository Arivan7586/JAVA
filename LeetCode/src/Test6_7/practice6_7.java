package Test6_7;

import java.util.Stack;

public class practice6_7 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(null));

    }
}

//对称二叉树
class Solution {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的
     * @param root 给定二叉树的根节点
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isTrue(root.left,root.right);
    }
    private boolean isTrue(TreeNode l,TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l != r && (l == null || r == null)) {
            return false;
        }
        if (r.val == l.val) {
            return isTrue(l.left,r.right) && isTrue(r.left,l.right);
        } else {
            return false;
        }
    }
}

//二叉树的最近公共祖先
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        run(root,p.val,q.val,stack);
        return stack.isEmpty() ? null : stack.peek();
    }
    private boolean run(TreeNode node,int p,int q,Stack<TreeNode> stack) {
        if (node == null) {
            return false;
        }
        if (contains(node,p) && contains(node,q)) {
            stack.push(node);
            if (run(node.left,p,q,stack)) {
                return true;
            }
            return run(node.right,p,q,stack);
        } else {
            return false;
        }
    }
    //判断给定根节点的二叉树中是否含有给定节点value
    private boolean contains(TreeNode node,int value) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }
        if (contains(node.left,value)) {
            return true;
        }
        return contains(node.right,value);
    }
}
