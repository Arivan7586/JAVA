package Test6_25;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice6_25 {

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        String text = "alice is a good girl she is a good student";

        String[] arr = solution2.findOcurrences(text,"a","good");
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

//修剪二叉树
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
     * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
     * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
     * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。

     * @param root 给定二叉树的根节点
     * @param L 左边界
     * @param R 右边界
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (L > root.val) {
            return trimBST(root.right,L,R);
        }
        if (R < root.val) {
            return trimBST(root.left,L,R);
        }
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;

        // if (L == R) {
        //     if (L == root.val) {
        //         root.left = null;
        //         root.right = null;
        //     } else if (L < root.val) {
        //         root = trimBST(root.left,L,R);
        //     } else {
        //         root = trimBST(root.right,L,R);
        //     }
        //     return root;
        // }
        // if (L > root.val) {
        //     return trimBST(root.right,L,R);
        // } else if (R < root.val) {
        //     return trimBST(root.left,L,R);
        // } else if (L == root.val) {
        //     root.left = null;
        //     root.right = trimBST(root.right,L+1,R);
        // } else if (R == root.val) {
        //     root.right = null;
        //     root.left = trimBST(root.left,L,R-1);
        // } else if (L < root.val && R > root.val) {
        //     root.left = trimBST(root.left,L,R);
        //     root.right = trimBST(root.right,L,R);
        // }
        // return root;
    }
}



//Bigram分词
class Solution2 {
    /**
     * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以
     * "first second third" 形式出现的情况，其中 second 紧随 first 出现，
     * third 紧随 second 出现。
     *
     * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
     *
     * @param text 给定文本
     * @param first 第一个词
     * @param second 第二个词
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        if (text.length() <= first.length() || text.length() <= second.length()) {
            return new String[]{};
        }
        List<String> list = new LinkedList<>();
        String[] arr = text.trim().split(" ");
        for (int i = 2; i < arr.length; i++) {
            if (arr[i-2].equals(first) && arr[i-1].equals(second)) {
                list.add(arr[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

//二叉树的层序遍历Ⅱ
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
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root 给定二叉树的根节点
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> l = new LinkedList<>();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(l);
        }
        Collections.reverse(list);
        return list;
    }
}