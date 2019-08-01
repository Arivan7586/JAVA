package Test8_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class practice8_1 {

    public static void main(String[] args) {

//        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},
//                {9,10,11,12}, {13,14,15,16}};
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.printMatrix(arr));

        Solution2 solution2 = new Solution2();
        int[] arr1 = {3,32,321};
        System.out.println(solution2.PrintMinNumber(arr1));

    }
}

//树的子结构
class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSameTree(root1,root2)) {
            return true;
        }
        if (HasSubtree(root1.left,root2)) {
            return true;
        }
        return HasSubtree(root1.right,root2);
    }
    //判断两个二叉树是否相等
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (isSameTree(p.left,q.left)) {
            return isSameTree(p.right,q.right);
        }
        return false;
    }
}

//顺时针打印矩阵
class Solution1 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;

        while (startX <= endX && startY <= endY) {
            int x = startX,y = startY;
            if (startX == endX) {
                while (y <= endY) {
                    list.add(matrix[x][y++]);
                }
                break;
            }
            if (startY == endY) {
                while (x <= endX) {
                    list.add(matrix[x++][y]);
                }
                break;
            }
            while (y < endY) {
                list.add(matrix[x][y++]);
            }
            while (x < endX) {
                list.add(matrix[x++][y]);
            }
            while (y > startY) {
                list.add(matrix[x][y--]);
            }
            while (x > startX) {
                list.add(matrix[x--][y]);
            }
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return list;
    }
}

//把数组拍成最小的数
class Solution2 {
    class Compare<Integer> implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 + "" + o2).compareTo(o2 + "" + o1);
        }
    }
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list1.add(numbers[i]);
        }
        Collections.sort(list1,new Compare<>());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            sb.append(list1.get(i));
        }
        return sb.toString();
    }
}