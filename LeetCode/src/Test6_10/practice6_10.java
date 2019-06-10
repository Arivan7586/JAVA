package Test6_10;

import java.util.Scanner;

public class practice6_10 {

    public static void main(String[] args) {

//    Solution.TreeNode s1 = new Solution.TreeNode(8);
//    Solution.TreeNode s2 = new Solution.TreeNode(6);
//    Solution.TreeNode s3 = new Solution.TreeNode(10);
//    Solution.TreeNode s4 = new Solution.TreeNode(5);
//    Solution.TreeNode s5 = new Solution.TreeNode(7);
//    Solution.TreeNode s6 = new Solution.TreeNode(9);
//    Solution.TreeNode s7 = new Solution.TreeNode(11);
//
//    s1.left = s2;
//    s1.right = s3;
//    s2.left = s4;
//    s2.right = s5;
//    s3.left = s6;
//    s3.right = s7;
//
//        System.out.println();
//        Solution solution = new Solution();
//        solution.Mirror(s1);
//        System.out.println();

//        Solution2.solution();

        Solution3.solution();

        //AACTGTGCACGACCTGA
        //5


    }
}

//二叉树的镜像
class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 操作给定二叉树，将其变换成源二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
        if (root.left == null && root.right == null) {
            return;
        } else {
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
        }
    }
}

//百万富翁问题
class Solution2 {
    /**
     *
     * 一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：
     * 我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
     * 第三天4 分钱……
     * 这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？
     * （注意一个是万元，一个是分）
     */
    public static void solution() {
        int sumRich = 0;
        int sumPoor = 0;
        int value = 1;
        for (int i = 0; i < 30; i++) {
            sumRich += 10;
            sumPoor += value;
            value <<= 1;
        }
        System.out.println(sumRich + " " + sumPoor);
    }
}

//DNA序列
class Solution3 {

    /**
     * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）
     * 是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
     * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
     *
     * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中
     * 找出GC-Ratio最高的子序列。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = in.nextInt();
        int count = 0;
        String res = null;
        for (int i = 0; i <= str.length()-length; i++) {
            String value = str.substring(i,i + length);
            if (count(value) > count) {
                res = value;
                count = count(value);
            }
        }
        System.out.println(res);
    }
    private static int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if (value == 'G' || value == 'C') {
                count++;
            }
        }
        return count;
    }
}