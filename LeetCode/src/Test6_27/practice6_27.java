package Test6_27;

import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class practice6_27 {

    public static void main(String[] args) {


    }
}

//二叉树的所有路径
class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        run(root,"",list);
        return list;
    }
    private void run(TreeNode node, String str,List<String> list) {
        if (node == null) {
            if (str.length() > 0) {
                list.add(str);
            }
            return;
        }
        if (node.left == null && node.right == null) {
            str += node.val;
            list.add(str);
            return;
        }
        str += (node.val + "->");
        if (node.left != null) {
            run(node.left,str,list);
        }
        if (node.right != null) {
            run(node.right,str,list);
        }

    }
}


//把二叉搜索树转换为累加树

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}