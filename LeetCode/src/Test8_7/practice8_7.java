package Test8_7;

import java.util.*;

public class practice8_7 {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,4,2,6,2,5,1};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxInWindows(arr,3));

        System.out.println("1.1.1.1".replaceAll("\\.","[.]"));

    }
}

//把二叉树打印成多行（剑指offer）
class Solution {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(arrayList);
        }
        return list;
    }
}

class Solution1 {
    private ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int n = list.size();
        if (n % 2 == 0) {
            return  (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
        }
        return list.get(n / 2) * 1.0;
    }
}

//二叉搜索树的第k个节点
class Solution2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (k <= 0) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        add(list,pRoot);
        if (k > list.size()) {
            return null;
        }
        return list.get(k-1);

    }
    private void add(ArrayList<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        add(list,node.left);
        list.add(node);
        add(list,node.right);
    }
}

//滑动窗口的最大值
class Solution3 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size) {
            return list;
        }
        if (size == num.length) {
            Arrays.sort(num);
            list.add(num[num.length - 1]);
            return list;
        }
        for (int i = 0; i <= num.length - size; i++) {
            int[] values = new int[size];
            System.arraycopy(num,i,values,0,size);
            Arrays.sort(values);
            list.add(values[size - 1]);
        }
        return list;
    }
}
