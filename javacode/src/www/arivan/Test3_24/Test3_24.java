package www.arivan.Test3_24;

import java.util.Arrays;

public class Test3_24 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.canConstruct("a", "b"));
//        System.out.println(solution.canConstruct("aa","ab"));
//        System.out.println(solution.canConstruct("aa", "aab"));
//
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.reverseVowels("hello"));
//        System.out.println(solution1.reverseVowels("leetcode"));

//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.reverseOnlyLetters("a-bC-dEf-ghIj"));
//        String ss = "mksnfdjkgn";
//        StringBuffer stringBuffer = new StringBuffer(ss);
//        System.out.println(ss.substring(0,10));
        String A = "aaaaaaabc", B = "aaaaaaacb";

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.buddyStrings(A,B));
        System.out.println(solution4.buddyStrings("ab","ab"));
        System.out.println(solution4.buddyStrings("ab","ba"));
        System.out.println(solution4.buddyStrings("aa","aa"));
    }
}


class Solution {
//    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
//    判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
//    如果可以构成，返回 true ；否则返回 false。
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null && magazine == null) {
            return true;
        }else if (ransomNote == null || magazine == null) {
            return false;
        }else if (magazine.length() < ransomNote.length()) {
            return false;
        }
        StringBuffer s1 = new StringBuffer(ransomNote);
        StringBuffer s2 = new StringBuffer(magazine);
        for (int i = 0; i < s1.length(); i++) {
            char val = s1.charAt(i);
            boolean flag = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s2.charAt(j) == val) {
                    flag = true;
                   s2.replace(j,j+1," ");
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    //编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    public String reverseVowels(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuffer s1 = new StringBuffer(s);
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'A' ||
                    s1.charAt(i) == 'E' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' ||
                    s1.charAt(i) == 'I' || s1.charAt(i) == 'O' || s1.charAt(i) == 'u'
                    || s1.charAt(i) == 'U') {
                str.append(s1.charAt(i));
            }
        }
        str.reverse();
        String val = s1.toString();
        char[] arr = val.toCharArray();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'
                    || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'A'
                    || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O'
                    || arr[i] == 'U') {
                arr[i] = str.charAt(k);
                k++;
            }
        }
        return new String(arr);
    }
}

class Solution2 {
//    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    private class ListNode {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode s = dummyHead;
        int i = 1;
        while (i < n) {
            head = head.next;
            if (head == null) {
                return dummyHead.next;
            }
            i++;
        }
        ListNode f = head;
        while (f != null && f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummyHead.next;
    }
}

class Solution3 {
    public String reverseOnlyLetters(String S) {
        if (S == null) {
            return S;
        }
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < S.length(); i++) {
            char val = S.charAt(i);
            if ((val >= 'a' && val <= 'z') || (val >= 'A' && val <= 'Z')) {
                str.append(val);
            }
        }
        str.reverse();
        StringBuffer s1 = new StringBuffer(S);
        int k = 0;
        for (int i = 0; i < s1.length(); i++) {
            char val = s1.charAt(i);
            if ((val >= 'a' && val <= 'z') || (val >= 'A' && val <= 'Z')) {
                String value = "" + str.charAt(k);
                s1.replace(i,i+1,value);
                k++;
            }
        }
        return s1.toString();
    }
}

class Solution4 {
//    给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
//    就返回 true ；否则返回 false 。
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2){
            return false;
        }
        char[] arr1 = A.toCharArray();
        char[] arr2 = B.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!new String(arr1).equals(new String(arr2))){
            return  false;
        }
        if (A.equals(B)){
            for (int i = 0; i < A.length()-1; i++){
                for (int k = i+1; k < A.length(); k++){
                    if (A.charAt(i) == A.charAt(k)){
                        return true;
                    }
                }
            }
            return false;
        }
        int i = 0;
        for (int j = 0; j < A.length(); j++){
            if (A.charAt(j) != B.charAt(j)){
                i++;
            }
        }
        if (i == 2){
            return  true;
        }
        return false;
    }
}