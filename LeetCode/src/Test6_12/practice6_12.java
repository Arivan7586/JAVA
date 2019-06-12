package Test6_12;

import java.util.Arrays;

public class practice6_12 {

    public static void main(String[] args) {
//        Gift gift = new Gift();
//        System.out.println(gift.getValue(new int[]{1,2,3,2,2},5));

        Partition.ListNode l1 = new Partition.ListNode(2);
        Partition.ListNode l2 = new Partition.ListNode(5);
        Partition.ListNode l3 = new Partition.ListNode(3);
        Partition.ListNode l4 = new Partition.ListNode(4);
        Partition.ListNode l5 = new Partition.ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Partition partition = new Partition();
        Partition.ListNode listNode = partition.partition(l1,3);
        print(listNode);

    }
    public static void print(Partition.ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

//微信红包
class Gift {
    public int getValue(int[] gifts, int n) {
        if (n < 1) {
            return 0;
        }
        Arrays.sort(gifts);
        int count = 0;
        for (int i = n/2; i < n; i++) {
            if (gifts[i] == gifts[n/2]) {
                count++;
            } else {
                break;
            }
        }
        for (int i = n/2 - 1; i >= 0; i--) {
            if (gifts[i] == gifts[n/2]) {
                count++;
            } else {
                break;
            }
        }
        return count > n/2 ? gifts[n/2] : 0;
    }
}

//链表分割
class Partition {

public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    /**
     * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的
     * 结点之前
     * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
     * 注意：分割以后保持原来的数据顺序不变。
     * @param pHead 需要分割链表的头节点
     * @param x
     * @return
     */
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);
        ListNode l = h1;
        ListNode r = h2;
        while (pHead != null) {
            ListNode node = new ListNode(pHead.val);
            if (pHead.val < x) {
                l.next = node;
                l = l.next;
            } else {
                r.next = node;
                r = r.next;
            }
            pHead = pHead.next;
        }
        if (h1.next == null) {
            return h2.next;
        } else if (h2.next == null) {
            return h1.next;
        } else {
            l.next = h2.next;
            return h1.next;
        }
    }
}