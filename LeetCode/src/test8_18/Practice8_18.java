package test8_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice8_18 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
//        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
//        Solution.TreeNode node = solution.reConstructBinaryTree(pre, in);
//        Solution.TreeNode node1 = solution.reConstructBinaryTree(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});
//        printTree(node1);

        Solution2.solution();
    }

    private static void printTree(Solution.TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }
}


//重建二叉树
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length <= 3) {
            if (pre.length == 1) {
                return new TreeNode(pre[0]);
            }
            if (pre.length == 2) {
                TreeNode root = new TreeNode(pre[0]);
                if (in[0] == pre[0]) {
                    root.right = new TreeNode(pre[1]);
                } else {
                    root.left = new TreeNode(pre[1]);
                }
                return root;
            }
            TreeNode root = new TreeNode(pre[0]);
            if (in[0] == pre[0]) {
                root.right = reConstructBinaryTree(new int[]{pre[1], pre[2]}, new int[]{in[1], in[2]});
            } else if (in[1] == pre[0]) {
                root.left = new TreeNode(in[0]);
                root.right = new TreeNode(in[2]);
            } else {
                root.left = reConstructBinaryTree(new int[]{pre[1], pre[2]}, new int[]{in[0], in[1]});
            }
            return root;
        } else {
            int flag = pre[0];
            TreeNode root = new TreeNode(flag);
            int count = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == flag) {
                    break;
                }
                count++;
            }
            //重构左子树
            int[] arr1 = new int[count];
            int[] arr2 = new int[count];
            System.arraycopy(pre, 1, arr1, 0, count);
            System.arraycopy(in, 0, arr2, 0, count);
            root.left = reConstructBinaryTree(arr1, arr2);
            //重构右子树
            int[] arr3 = new int[in.length - count - 1];
            int[] arr4 = new int[in.length - count - 1];
            System.arraycopy(pre, count + 1, arr3, 0, in.length - count - 1);
            System.arraycopy(in, count + 1, arr4, 0, in.length - count - 1);
            root.right = reConstructBinaryTree(arr3, arr4);
            return root;
        }
    }
}

//回文数
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.next();
            int l = 0;
            int r = value.length() - 1;
            int flag = 1;
            while (l <= r) {
                if (value.charAt(l++) != value.charAt(r--)) {
                    flag = 0;
                    break;
                }
            }
            System.out.println(flag);
        }
        in.close();
    }
}

//字典压缩算法
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String string = in.next();
            System.out.println(add(string,""));
        }
        in.close();
    }
    private static String add(String string, String res) {
        if (string == null || string.equals("")) {
            return res;
        }
        int sum = 0;
        char value = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == value) {
                sum++;
            } else {
                break;
            }
        }
        if (sum > 0) {
            res += sum + "" + value;
        } else {
            res += value;
        }
        if (sum < string.length() - 1) {
            res = add(string.substring(sum+1),res);
        }
        return res;
    }
}