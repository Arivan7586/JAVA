package www.arivan.Test3_25;

import javax.lang.model.element.NestingKind;

public class Test3_25 {
    public static void main(String[] args) {
        String name = "kikcxmvzi", typed = "kiikcxxmmvvzz";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isLongPressedName(name,typed));
        System.out.println(solution3.isLongPressedName(name = "alex", typed = "aaleex"));
        System.out.println(solution3.isLongPressedName(name = "saeed", typed = "ssaaedd"));
        System.out.println(solution3.isLongPressedName(name = "leelee", typed = "lleeelee"));
        System.out.println(solution3.isLongPressedName(name = "laiden", typed = "laiden"));

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.strStr("hello", "ll"));
        System.out.println(solution4.strStr("aaaaa", "bba"));
        System.out.println(solution4.strStr("mississippi","pi"));

    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

}

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.equals("0")) {
            return num2;
        }else if (num2 == null || num2.equals("0")) {
            return num1;
        }
        StringBuffer s1 = new StringBuffer(num1);
        StringBuffer s2 = new StringBuffer(num2);
        s1.reverse();
        s2.reverse();
        if (s1.length() > s2.length()) {
            for (int i = s2.length(); i < s1.length(); i++) {
                s2.append("0");
            }
        }else if (s1.length() < s2.length()) {
            for (int i = s1.length(); i < s2.length(); i++) {
                s1.append("0");
            }
        }
        int flag = 0;
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < s1.length(); i++) {
            int value1 = s1.charAt(i) - '0';
            int value2 = s2.charAt(i) - '0';
            int value = flag + value1 + value2;
            if (value >= 10) {
                flag = 1;
                value = value - 10;
                str.append(value);
            }else {
                str.append(value);
                flag = 0;
            }
        }
        if (flag != 0) {
            str.append(flag);
        }
        str.reverse();
        return str.toString();
    }
}

class Solution1 {
    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int i = 0;
        while (i < k) {
            int value = nums[n-1];
            System.arraycopy(nums,0,nums,1,n-1);
            nums[0] = value;
            i++;
        }
    }
}

class Solution2 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int value = 1;
        for (int i = n-1; i >= 0; i--) {
            if (value == 1) {
                digits[i] += value;
                if (digits[i] >= 10) {
                    digits[i] -= 10;
                    value = 1;
                }else {
                    value = 0;
                    break;
                }
            }
        }
        if (value == 1) {
            int[] arr = new int[n+1];
            arr[0] = value;
            System.arraycopy(digits,0,arr,1,n);
            return arr;
        }
        return digits;
    }
}

class Solution3 {
//    你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
//    而字符可能被输入 1 次或多次。
//    你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），
//    那么就返回 True。
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        int oldIndex = 0;
        for (int i = 0; i < name.length(); i++) {
            char value = name.charAt(i);
            int j = oldIndex;
            boolean flag = false;
            for (; j < typed.length(); j++) {
                if (typed.charAt(j) == value) {
                    flag = true;
                    oldIndex = j + 1;
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

class Solution4 {
//    实现 strStr() 函数。
//
//    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
//    字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= m-n; i++) {
            if (haystack.substring(i,i+n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
