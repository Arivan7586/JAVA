package Test7_28;

import java.util.ArrayList;
import java.util.List;

public class practice7_28 {

    public static void main(String[] args) {

//        int[] arr = {4,9,6,8,0,1,3,7,5,2};
//        Sort.heapSort(arr);

        Solution.TreeNode root = new Solution().new TreeNode(2);
        Solution.TreeNode root1 = new Solution().new TreeNode(0);
        Solution.TreeNode root2 = new Solution().new TreeNode(3);
        Solution.TreeNode root3 = new Solution().new TreeNode(-4);
        Solution.TreeNode root4 = new Solution().new TreeNode(1);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;

        Solution solution = new Solution();
        System.out.println(solution.findTarget(root,-1));

    }
}

//两数之和IV-输入BST
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        add(root,list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == k) {
                    return true;
                } else if (list.get(i) + list.get(j) > k) {
                    break;
                }
            }
        }
        return false;
    }
    //二叉树的中序遍历
    private void add(TreeNode node,List<Integer> list) {
        if (node == null) {
            return;
        }
        add(node.left,list);
        list.add(node.val);
        add(node.right,list);
    }
}

//左叶子之和
class Solution1 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            TreeNode node = root.left;
            //判断左子节点是否为叶子结点
            if (node.left == null && node.right == null) {
                res += node.val; //如果是叶子结点、则加上该左子节点的值
            } else {
                res += sumOfLeftLeaves(node); //如果不是叶子结点，则进入递归
            }
        }
        if (root.right != null) {
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }
}

//堆排序
class Sort {

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        printArray(arr);
        //将数组转换为大顶堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr,n,i);
        }
        printArray(arr);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr,i,0);
            siftDown(arr,i,0);
        }
        printArray(arr);
    }

    /**
     * 元素下沉操作，将小元素往下移动
     * @param arr 给定数组
     * @param n 给定数组的长度
     * @param index 下沉操作元素的下标
     */
    private static void siftDown(int[] arr, int n, int index) {
        while (index * 2 + 1 < n) {
            //满足此条件，说明当前下标的节点不是叶子节点
            int i = index * 2 + 1;
            if (i + 1 < n) {
                //满足此条件，说明当前节点存在右子节点
                if (arr[i] < arr[i+1]) {
                    i++;
                }
            }
            //如果当前节点的值比左右子树都大，则直接返回，无需继续下沉
            if (arr[index] >  arr[i]) {
                break;
            }
            swap(arr,i,index);
            index = i;
        }
    }

    //交换数据
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}