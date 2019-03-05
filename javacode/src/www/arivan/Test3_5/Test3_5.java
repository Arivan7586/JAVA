package www.arivan.Test3_5;

public class Test3_5 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode prev1 = new ListNode(1);
        ListNode prev2 = new ListNode(2);
        prev1.next = prev2;
        prev2.next = null;

        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(1);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = null;

        printNode(p1);
        System.out.println();
        printNode(prev1);

        System.out.println();


    }

    public static boolean nodeIsSame(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 != null) {
            return false;
        }else if (head1 != null && head2 == null) {
            return false;
        }else {
            return true;
        }
    }

    public static void printNode(ListNode head) { //输出链表
        if (head == null) {
            System.out.println("当前链表为空！");
        }else {
            while (head != null) {
                System.out.print(head.val+" ");
                head = head.next;
            }
        }
    }
}


class Solution {
    //输入一个链表，输出该链表中倒数第k个结点。

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 0) {
            return null;
        }
        //先找出节点的总个数
        int count = 0;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead.next;
        while (prev != null) {
            count++;
            prev = prev.next;
        }

        //找到第倒数第k个节点
        if (k > count) {
            return null;
        }
        ListNode ret = head;
        for (int i = 0; i < count-k; i++) {
            ret = ret.next;
        }
        return ret;
    }
}

class Solution1 {
    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}