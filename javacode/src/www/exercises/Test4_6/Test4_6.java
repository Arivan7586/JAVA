package www.exercises.Test4_6;

public class Test4_6 {
    public static void main(String[] args) {
        Solution.ListNode p1 = new Solution.ListNode(1);
        Solution.ListNode p2 = new Solution.ListNode(2);
        Solution.ListNode p3 = new Solution.ListNode(2);
        Solution.ListNode p4 = new Solution.ListNode(3);
        Solution.ListNode p5 = new Solution.ListNode(4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        printNode(p1);
        Solution solution = new Solution();
        printNode(solution.deleteDuplication(p1));

        System.out.println(solution.hasCycle(p1));
    }
    public static void printNode(Solution.ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
}

class Solution {
//    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
//    返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {

            this.val = val;
        }
    }

    /**
     * 删除给定链表中重复的节点
     * @param pHead 给定链表的头节点
     * @return 返回删除操作后链表的头节点
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode head = dummyHead;
        ListNode temp = pHead;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                ListNode nextNode = temp;
                while (nextNode != null && nextNode.val == temp.val) {
                    nextNode = nextNode.next;
                }
                temp = nextNode;
                head.next = temp;
            }else {
                temp = temp.next;
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * @param head 给定链表的头节点
     * @return 如果给定链表是环形的，返回true，否则返回false
     */
    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null) {
             return false;
         }
         ListNode f = head.next;
         ListNode s = head;
         while (s != f) {
             if (f == null || f.next == null) {
                 return false;
             }
             s = s.next;
             f = f.next;
         }
         return true;
    }
}