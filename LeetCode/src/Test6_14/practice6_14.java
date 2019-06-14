package Test6_14;

import java.util.Scanner;

public class practice6_14 {

    public static void main(String[] args) {

        Plus.ListNode l1 = new Plus.ListNode(7);
        Plus.ListNode l2 = new Plus.ListNode(8);
        Plus.ListNode l3 = new Plus.ListNode(3);
        l1.next = l2;
        l2.next = l3;

        Plus.ListNode l4 = new Plus.ListNode(3);
        Plus.ListNode l5 = new Plus.ListNode(2);
        Plus.ListNode l6 = new Plus.ListNode(7);
        l4.next = l5;
        l5.next = l6;

        Plus plus = new Plus();
        print(plus.plusAB(l1,l4));

        Solution.solution();

    }
    private static void print(Plus.ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

//链式A+B
class Plus {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，
     * 也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
     *
     * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
     * @param a
     * @param b
     * @return
     */
    public ListNode plusAB(ListNode a, ListNode b) {
        if (a == null) {
            return reverseNode(b);
        }
        if (b == null) {
            return reverseNode(a);
        }
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode t = head;
        while (true) {
            if (a == null && b == null) {
                if (flag != 0) {
                    ListNode node = new ListNode(flag);
                    t.next = node;
                }
                break;
            }
            int value = 0;
            if (a == null) {
                value = (flag + b.val) % 10;
                flag = (flag + b.val) / 10;
                b = b.next;
            } else if (b == null) {
                value = (flag + a.val) % 10;
                flag = (flag + a.val) / 10;
                a = a.next;
            } else {
                value = (flag + a.val + b.val) % 10;
                flag = (flag + a.val + b.val) / 10;
                a = a.next;
                b = b.next;
            }
            ListNode node = new ListNode(value);
            t.next = node;
            t = t.next;
        }
        return reverseNode(head.next);
    }
    public static ListNode reverseNode(ListNode head) {
        if (head == null) {
            return null;
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

//到底买不买
class Solution {
    /**
     * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，
     * 但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
     * 下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；
     * 如果不是，那么告诉她缺了多少珠子。
     * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。
     * 例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
     * 全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，
     * 因为没有黑色珠子，并且少了一颗红色的珠子。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String goods = in.nextLine();
            String value = in.nextLine();
            System.out.println(buy(goods,value));
        }
        in.close();
    }
    private static String buy(String goods, String value) {
        if (value == null) {
            return "No" + " " + 0;
        }
        if (goods == null) {
            return "No" + " " + value.length();
        }
        int count = value.length();
        for (int i = 0; i < value.length(); i++) {
            String str = String.valueOf(value.charAt(i));
            if (goods.contains(str)) {
                count--;
                goods = goods.replaceFirst(str,"");
            }
        }
        return count == 0 ? "Yes " + goods.length() : "No " + count;
    }
}