package Test6_24;

import java.util.LinkedList;
import java.util.List;

public class practice6_24 {

    public static void main(String[] args) {



    }
}

//将有序数组转换为二叉搜索树.
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
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点
     * 的左右两个子树的高度差的绝对值不超过 1
     * @param nums 给定的有序数组
     * @return 返回转化后的二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int n = nums.length;
        return addNode(nums,0,n-1);
    }
    private TreeNode addNode(int[] arr, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = addNode(arr,l,mid-1);
        node.right = addNode(arr,mid+1,r);
        return node;
    }
}


//有序链表转换为二叉搜索树
class Solution1 {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 
     * 的左右两个子树的高度差的绝对值不超过 1。
     *
     * @param head 给定单链表的头结点
     * @return 返回转换后的二叉树
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return addNode(list,0,list.size()-1);
    }
    private TreeNode addNode(LinkedList<Integer> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = addNode(list,l,mid-1);
        node.right = addNode(list,mid+1,r);
        return node;
    }

    /**
     * 双指针法（先找到有序链表的中间结点，再进行转换操作）
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode node = head;
        ListNode l = node.next;
        ListNode r = l.next;;
        while (r != null && r.next != null) {
            node = node.next;
            l = node.next;
            r = r.next.next;
        }
        node.next = null;
        TreeNode root = new TreeNode(l.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(l.next);
        return root;

    }
}
