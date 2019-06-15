package Test6_15;

import java.util.Scanner;

public class practice6_15 {

    public static void main(String[] args) {

        Solution.solution();

    }
}

//二叉树平衡检查
class Balance {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，
     * 其两颗子树的高度差不超过1。
     *
     * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
     * @param root 给定二叉树的根节点
     * @return 返回是否为平衡二叉树
     */
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) <= 1) {
            if (isBalance(root.left)) {
                return isBalance(root.right);
            }
        }
        return false;
    }

    //计算二叉树的最大深度
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}

//数学分类
class Solution {
    /**
     * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
     *
     * A1 = 能被5整除的数字中所有偶数的和；
     *
     * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
     *
     * A3 = 被5除后余2的数字的个数；
     *
     * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
     *
     * A5 = 被5除后余4的数字中最大数字。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(run(arr));
        }
    }
    private static String run(int[] arr) {
        int n = arr.length;
        int[] res = new int[4];
        boolean flag = true;
        int count1 = 0;
        double count2 = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0 && arr[i] % 5 == 0) {
                res[0] += arr[i];
            }
            if (arr[i] % 5 == 1) {
                res[1] += flag ? arr[i] : -arr[i];
                flag = flag ? false : true;
            }
            if (arr[i] % 5 == 2) {
                count1++;
            }
            if (arr[i] % 5 == 3) {
                sum += arr[i];
                count2++;
            }
            if (arr[i] % 5 == 4) {
                res[3] = arr[i] > res[3] ? arr[i] : res[3];
            }
        }
        res[2] = count1;
        double value = count2 != 0 ? sum / count2 : 0.0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (res[i] != 0) {
                str.append(res[i]);
            } else {
                str.append("N");
            }
            str.append(" ");
        }
        if (value == 0.0) {
            str.append("N").append(" ");
        } else {
            str.append(String.format("%.1f", value)).append(" ");
        }
        if (res[3] == 0) {
            str.append("N");
        } else {
            str.append(res[3]);
        }
        return String.valueOf(str);
    }
}