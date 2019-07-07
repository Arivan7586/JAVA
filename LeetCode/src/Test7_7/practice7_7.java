package Test7_7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class practice7_7 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        System.out.println(solution.rob(new int[]{1,2,3,1}));

        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] arr1 = Arrays.copyOf(arr,5);
        print(arr1);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.lastStoneWeight(new int[]{4,6,4,10}));

    }
    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

//打家劫舍
class Solution {
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return maxValue(nums,0);
//    }
//    private int maxValue(int[] num,int i) {
//        if (i >= num.length) {
//            return 0;
//        }
//        int value1 = num[i] + maxValue(num,i+2);
//        int value2 = maxValue(num,i+1);
//        return value1 > value2 ? value1 : value2;
//    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        arr[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i - 1]);
        }
        return arr[nums.length];
    }
}


//二叉搜索树中的插入操作
class Solution1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right,val);
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}

//最后一块石头的重量
class Solution2 {
    /**
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * @param stones 记录石头重量的数组
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return stones[0];
        }
        if (n == 2) {
            return Math.abs(stones[1]-stones[0]);
        }
        Arrays.sort(stones);
        int[] arr = new int[]{};
        if (stones[n-1] == stones[n-2]) {
            arr = Arrays.copyOf(stones,n-2);
            return lastStoneWeight(arr);
        } else {
            arr = Arrays.copyOf(stones,n-1);
            arr[arr.length-1] = stones[n-1] - stones[n-2];
            Arrays.sort(arr);
            return lastStoneWeight(arr);
        }
    }
}