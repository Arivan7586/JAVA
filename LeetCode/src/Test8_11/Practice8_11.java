package Test8_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Practice8_11 {

    public static void main(String[] args) {

        Solution.solution();

        Solution1.solution();


    }
}

//城市修建（360）
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                maxX = x > maxX ? x : maxX;
                maxY = y > maxY ? y : maxY;
                minX = Math.min(minX,x);
                minY = Math.min(minY,y);
            }
            long width = Math.max(maxX - minX,maxY-minY);
            System.out.println(width * width);
        }
        in.close();
    }
}

//圈地运动（360）
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            if (n <= 2) {
                System.out.println(-1);
            } else {
                boolean flag = true;
                for (int i = 2; i < arr.length; i++) {
                    int[] values = new int[i + 1];
                    System.arraycopy(arr,0, values,0,i+1);
                    if (sum(values,i)) {
                        System.out.println(i + 1);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(-1);
                }
            }
        }
        in.close();
    }
    private static boolean sum(int[] arr, int index) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += arr[i];
        }
        return sum > arr[index];
    }
}

//平衡二叉树
class Solution2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right)) + 1;
    }
}


//二叉树的最大深度
class Solution3 {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }
}
