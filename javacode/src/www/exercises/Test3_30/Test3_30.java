package www.exercises.Test3_30;

import java.util.Arrays;
import java.util.List;

public class Test3_30 {
    public static void main(String[] args) {
//        String s = "123333";
//        StringBuffer stringBuffer = new StringBuffer(s);
//
//        System.out.println(s.replaceAll("3","*"));
//        String str = "zckfnboda";
//        char[] arr = str.toCharArray();
//        Arrays.sort(arr);
//        for (char c : arr) {
//            System.out.print(c+" ");
//        }
        //System.out.println(Integer.parseInt(s)+1);

        Solution solution = new Solution();
        System.out.println(solution.FirstNotRepeatingChar("google"));

        Solution1.ListNode p1 = new Solution1.ListNode(1);
        Solution1.ListNode p2 = new Solution1.ListNode(2);
        Solution1.ListNode p3 = new Solution1.ListNode(3);
        p1.next = p2;
        p2.next = p3;
        Solution1.ListNode m = new Solution1.ListNode(0);
        m.next = p2;
        printNode(p1);
        printNode(m);
        Solution1 s = new Solution1();
        System.out.println(s.ensureNode(p1,m));
        printNode(s.FindFirstCommonNode(p1,m));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.InversePairs(new int[]{1,2,3,4,5,6,7,0}));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.Sum_Solution(100));
    }
    public static void printNode(Solution1.ListNode head) {
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void add(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

class Solution {
    /**
     * 第一个只出现一次的字符
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写
     * @param str 给定字符串
     * @return 返回第一个出现一次的字符的下标
     */
    public int FirstNotRepeatingChar(String str) {
        int n = str.length();
        if (n == 0) {
            return -1;
        }else if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                continue;
            }
            int count = 0;
            for (int j = i+1; j < n; j++) {
                if (str.charAt(j) == '0') {
                    continue;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    String value = "" + str.charAt(j);
                    str = str.replaceAll(value,"0");
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 统计一个数字在排序数组中出现的次数
     * @param array 给定的排序数组
     * @param k 需要统计的数字
     * @return 返回k出现的次数
     */
    public int GetNumberOfK(int [] array , int k) {
        int n = array.length;
        if (n < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }
}

class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {

            this.val = val;
            this.next = next;
        }
    }

    /**
     * 输入连个链表，找出他们的第一个公共节点。
     * @param pHead1 链表1
     * @param pHead2 链表2
     * @return 返回第一个公共节点
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        while (pHead1 != null) {
            if (ensureNode(pHead1,pHead2)) {
                return pHead1;
            }
            pHead1 = pHead1.next;
        }
        return null;
    }

    /**
     * 在给定链表中查找给定节点
     * @param value 给定节点
     * @param head  给定链表
     * @return 如果找到了，返回true
     */
    public boolean ensureNode(ListNode value, ListNode head) {
        while (head != null) {
            if (head.val == value.val) {
                if ((head.next == null && value.next == null) ||
                        value.next.equals(head.next)) {
                    return true;
                }
            }
            head = head.next;
        }
        return false;
    }
}

class Solution2 {
    /**
     * 数组中的逆序对
     * @param array 给确定的数组
     * @return 返回逆序对总数P%1000000007
     */
    public int InversePairs(int [] array) {
        int n = array.length;
        if (n <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (array[i] > array[j]) {
                    sum++;
                }
            }
        }
        return sum%1000000007;
    }
}

class Solution3 {
    /**
     * 求1+2+3+……+n，要求不能使用乘除法、for、while、if、else、switch、case
     * 等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }
}