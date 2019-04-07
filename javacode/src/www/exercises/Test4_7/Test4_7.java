package www.exercises.Test4_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test4_7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
//        System.out.println(solution.findMaxAverage(new int[]{-1},1));

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.add(0);
//
//        List<Integer> integerList = new LinkedList<>();
//        integerList.add(1);
//        integerList.add(2);
//        integerList.add(0);
//        integerList.add(0);
//        System.out.println(integerList);
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.addToArrayForm(new int[]{1,2,0,0},34));
//        System.out.println(solution1.addToArrayForm(new int[]{2,7,4},181));
//        System.out.println(solution1.addToArrayForm(new int[]{9,9,9},999));
//        System.out.println(solution1.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
//        System.out.println(solution1.addToArrayForm(new int[]{2,1,5},806));
//        System.out.println(solution1.addToArrayForm(new int[]{1,1},999));

        Solution2.ListNode p1 = new Solution2.ListNode(1);
        Solution2.ListNode p2 = new Solution2.ListNode(2);
        Solution2.ListNode p3 = new Solution2.ListNode(3);
        Solution2.ListNode p4 = new Solution2.ListNode(4);
        Solution2.ListNode p5 = new Solution2.ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.printListFromTailToHead(p1));
    }
}

class Solution {
    //给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0.0;
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for (int i = 1; i+k <= nums.length; i++) {
            sum = sum - nums[i-1] + nums[i+k-1];
            max = max>sum ? max : sum;
        }
        return (double)max/k;
    }
}

class Solution1 {
//    对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，
//    那么其数组形式为 [1,2,3,1]。
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        List<Integer> list = new LinkedList<>();
        int flag = 0;
        while (i >= 0) {
            if (K > 0) {
                int value = flag + A[i] + K%10;
                ((LinkedList<Integer>) list).addFirst(value%10);
                flag = value / 10;
                K /= 10;
            }else {
                int value = flag + A[i];
                ((LinkedList<Integer>) list).addFirst(value%10);
                flag = value / 10;
            }
            i--;
        }
        while (K > 0) {
            int value = K%10 + flag;
            ((LinkedList<Integer>) list).addFirst(value%10);
            K /= 10;
            flag = value / 10;
        }
        if (flag == 1) {
            ((LinkedList<Integer>) list).addFirst(flag);
        }
        return list;
    }
}

class Solution2 {
    //输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
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
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }else if (listNode.next == null) {
            list.add(listNode.val);
            return list;
        }
        //反转链表
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = listNode;
        ListNode f = listNode;
        ListNode s = f.next;
        while (s != null) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        ListNode temp = dummyHead.next;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }
}