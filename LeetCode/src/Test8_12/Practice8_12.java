package Test8_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice8_12 {

    public static void main(String[] args) {

//        Solution solution4 = new Solution();
//        System.out.println(solution4.FindContinuousSequence(100));
//        System.out.println(solution4.FindContinuousSequence(3));

//        int[] arr = new int[]{5,7,1,0,6,9,4,3,2,8};
//        Sort.bubbleSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }

        Solution1.ListNode l1 = new Solution1.ListNode(5);
        Solution1.ListNode l2 = new Solution1.ListNode(4);
        Solution1.ListNode l3 = new Solution1.ListNode(0);
        Solution1.ListNode l4 = new Solution1.ListNode(8);
        Solution1.ListNode l5 = new Solution1.ListNode(2);
        Solution1.ListNode l6 = new Solution1.ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        Solution1 solution1 = new Solution1();
//        Solution1.ListNode listNode = solution1.mergeTwoLists(l1,l4);
        printListNode(l1);
        Solution1.listSort(l1);
        printListNode(l1);

//        printListNode(l1);
//        printListNode(Solution1.reverseList(l1));

        Stack stack = new Stack();
        stack.pop();



    }
    private static void printListNode(Solution1.ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

//和为S的连续正数序列(牛客网)
class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum <= 2) {
            return arrayLists;
        }
        for (int i = 1; i <= sum / 2 + 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int value = 0;
            for (int j = i; j <= sum/2 + 1 && value <= sum; j++) {
                list.add(j);
                value += j;
                if (value == sum) {
                    break;
                }
            }
            if (list.size() > 0 && value == sum) {
                arrayLists.add(list);
            }
        }
        return arrayLists;
    }
}


class Solution1 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //反转链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = head;
        ListNode s = f.next;
        while (s != null) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        return dummyHead.next;
    }


    //链表排序
    public static ListNode listSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (head != null) {
            ListNode node = head;
            while (node != null) {
                if (node.val < head.val) {
                    int temp = node.val;
                    node.val = head.val;
                    head.val = temp;
                }
                node = node.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
