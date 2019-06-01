package Test6_1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class practice6_1 {

    public static void main(String[] args) {
        Solution.solution();

    }
}

class Solution {
    /**
     * 个位数统计
     * <p>
     * 给定一个k为整数，请编写程序统计每种不同的个位数字出现的次数。例如
     * N = 100311，则有2个0，3个1，和1个3
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String value = in.nextLine();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < value.length(); i++) {
            int index = value.charAt(i) - 48;
            if (map.containsKey(index)) {
                map.put(index, map.get(index) + 1);
            } else {
                map.put(index, 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.println(i + ":" + map.get(i));
        }
    }
}


class Solution1 {
    /**
     * 构建乘积数组
     * <p>
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
     * 不能使用除法。
     *
     * @param A 给定数组
     * @return 返回符合条件的数组
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            int value = 1;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    value *= A[j];
                }
            }
            B[i] = value;
        }
        return B;
    }
}

/**
 * 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (isSameTree(s, t)) {
                return true;
            }
        }
        if (isSubtree(s.left, t)) {
            return true;
        } else {
            return isSubtree(s.right, t);
        }
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && q == null) {
            return true;
        } else if (p == null && q != null || p != null && q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            if (isSameTree(p.left, q.left)) {
                return isSameTree(p.right, q.right);
            }
            return false;
        }
    }
}

/**
 * 二叉树的最大深度
 */
class Solution3 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int maxDepth(TreeNode root) {
        // return max(root);

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    // private int max(TreeNode node) {
    //     int depth = 0;
    //     if (node == null) {
    //         return depth;
    //     }
    //     depth++;
    //     int d1 = depth + max(node.left);
    //     int d2 = depth + max(node.right);
    //     return d1 >= d2 ? d1 : d2;
    // }
}