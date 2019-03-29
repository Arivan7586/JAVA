package www.exercises.Test3_29;

public class Test3_29 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0,9,1};
        int[] arr1 = new int[]{2,1};
        print(arr);
        Solution solution = new Solution();
        solution.reOrderArray(arr);
        print(arr);

//        Solution1.ListNode p1 = new Solution1.ListNode(1);
//        Solution1.ListNode p2 = new Solution1.ListNode(2);
//        Solution1.ListNode p3 = new Solution1.ListNode(3);
//        Solution1.ListNode p4 = new Solution1.ListNode(4);
//        Solution1.ListNode p5 = new Solution1.ListNode(5);

        Solution3.ListNode p1 = new Solution3.ListNode(1);
        Solution3.ListNode p2 = new Solution3.ListNode(2);
        Solution3.ListNode p3 = new Solution3.ListNode(3);
        Solution3.ListNode p4 = new Solution3.ListNode(4);
        Solution3.ListNode p5 = new Solution3.ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        Solution3.ListNode m1 = new Solution3.ListNode(3);
        Solution3.ListNode m2 = new Solution3.ListNode(7);
        Solution3.ListNode m3 = new Solution3.ListNode(9);
        Solution3.ListNode m4 = new Solution3.ListNode(15);
        Solution3.ListNode m5 = new Solution3.ListNode(21);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;

        Solution1 solution1 = new Solution1();
        //System.out.println(solution1.FindKthToTail(p1,4).val);
        System.out.println();

        Solution3 solution3 = new Solution3();
        printNode(solution3.Merge1(m1,p1));
    }
    public static void printNode(Solution3.ListNode head) {
        Solution3.ListNode node = head;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }
    public static void print(int[] arr) {
        for (int i: arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Solution {
//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
//    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) { //插入排序思想
        int n = array.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            if (array[i]%2 == 1) {
                int j = i - 1;
                int value = array[i];
                while (j >= 0) {
                    if (array[j]%2 == 0) {
                        array[j+1] = array[j];
                        j--;
                    }else {
                        break;
                    }
                }
                array[j+1] = value;
            }
        }
    }
}

class Solution1 {
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
    public ListNode FindKthToTail(ListNode head,int k) {
        //双指针法
        if (head == null) {
            return head;
        }
        if (k < 1) {
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        int i = 1;
        while (i < k) {
            f = f.next;
            if (f == null) {
                return null;
            }
            i++;
        }
        while (f != null && f.next != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}

class Solution2 { //反转链表
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
    public ListNode ReverseList(ListNode head) {
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
}

class Solution3 {
    //题目描述
    //输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
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
    public ListNode Merge(ListNode list1,ListNode list2) { //递归实现
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
    public ListNode Merge1(ListNode list1,ListNode list2) { //非递归实现
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //拼接两个链表
        ListNode s = list1;
        while (s.next != null) {
            s = s.next;
        }
        s.next = list2;
        //给拼接后的链表排序（升序）
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = list1;
        while (list1 != null) {
            ListNode nextNode = list1.next;
            while (nextNode != null) {
                if (list1.val > nextNode.val) {
                    int t = list1.val;
                    list1.val = nextNode.val;
                    nextNode.val = t;
                }
                nextNode = nextNode.next;
            }
            list1 = list1.next;
        }
        return dummyHead.next;
    }
}