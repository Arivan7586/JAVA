package Test6_5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class practice6_5 {

    public static void main(String[] args) {
        Solution2.TreeNode root = new Solution2.TreeNode(3);
        Solution2.TreeNode node1 = new Solution2.TreeNode(9);
        Solution2.TreeNode node2 = new Solution2.TreeNode(20);
        Solution2.TreeNode node3 = new Solution2.TreeNode(15);
        Solution2.TreeNode node4 = new Solution2.TreeNode(17);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isBalanced(root));
    }
}

class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSame(root1,root2);
        } else {
            if (HasSubtree(root1.left,root2)) {
                return true;
            } else {
                return HasSubtree(root1.right,root2);
            }
        }
    }
    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == node2 && node1 == null) {
            return true;
        }
        if (node1 == null && node2 != null || node1 != null && node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        } else {
            if (isSame(node1.left,node2.left)) {
                return isSame(node1.right,node2.right);
            }
            return false;
        }
    }
}

//从上往下打印字符串
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     * @param root 给定二叉树的根节点
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}

//平衡二叉树
class Solution2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树
     *
     * 平衡二叉树的定义是：一个二叉树每个节点的左右子树的高度差绝对值不超过1
     * @param root 给定二叉树的根节点
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //如果以当前节点为根节点的二叉树是平衡二叉树。则判断该节点的左子树
        if (isBalance(root.left,root.right)) {
            if (root.left != null) { //如果左子树为空，就判断右子树
                if (isBalanced(root.left)) { //如果左子树为平衡二叉树，就判断右子树
                    return isBalanced(root.right);
                }
                return false; //只要有一个子树不是平衡二叉树，就返回false；
            } else {
                return isBalanced(root.right);
            }
        }
        return false;
    }
    //判断当前二叉树的左右子树最大深度差，如果大于1，则此二叉树不是平衡二叉树
    private boolean isBalance(TreeNode l, TreeNode r) {
        int value = Math.abs(maxDepth(l) - maxDepth(r));
        if (value > 1) {
            return false;
        }
        return true;
    }
    //求得给定根节点的二叉树的最大深度
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}