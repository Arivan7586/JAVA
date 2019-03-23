package www.arivan.Test3_23;

public class Test3_23 {
    public static void main(String[] args) {
        String s1 =  "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String s2 =  "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        // "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
        //  110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000

//        StringBuffer stringBuffer = new StringBuffer("12345789");
//        System.out.println(stringBuffer.length());
//        System.out.println(stringBuffer.substring(7));

        System.out.println(addBinary(s1,s2));
        System.out.println(addBinary("11","1"));  // 100

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.checkRecord("PPALLL"));

    }
    //二进制求和
    public static String addBinary(String a, String b) {
        StringBuffer s1 = new StringBuffer(a);
        s1.reverse();
        StringBuffer s2 = new StringBuffer(b);
        s2.reverse();
        if (s1.length() > s2.length()) {
            int n = s1.length() - s2.length();
            for (int i = 0; i < n; i++) {
                s2.append('0');
            }
        }else if (s1.length() < s2.length()) {
            int n = s2.length() - s1.length();
            for (int i = 0; i < n; i++) {
                s1.append('0');
            }
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int i = 0;
        char flag = '0';
        while (i < s1.length() && i < s2.length()) {
            if (flag == '0') {
                if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '1') {
                    flag = '1';
                    stringBuffer.append('0');
                }else if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '0') {
                    stringBuffer.append('0');
                }else {
                    stringBuffer.append('1');
                }
            } else {
                if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '1') {
                    flag = '1';
                    stringBuffer.append('1');
                }else if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i) == '0'){
                    flag = '0';
                    stringBuffer.append('1');
                }else {
                    flag = '1';
                    stringBuffer.append('0');
                }
            }
            i++;
        }
        if (flag == '1') {
            stringBuffer.append(flag);
        }
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}

class Solution {
//    给定一个单词，你需要判断单词的大写使用是否正确。
//    全部字母都是大写，比如"USA"。
//    单词中所有字母都不是大写，比如"leetcode"。
//    如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
//    否则，我们定义这个单词没有正确使用大写字母
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if (arr.length <= 1) {
            return true;
        }
        if (arr[0] >= 'A' && arr[0] <= 'Z') {
            if (arr[1] >= 'A' && arr[1] <= 'Z') {
                for (int i = 2; i < arr.length; i++) {
                    if (arr[i] >= 'a' && arr[i] <= 'z') {
                        return false;
                    }
                }
                return true;
            }else if (arr[1] >= 'a' && arr[1] <= 'z') {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] >= 'A' && arr[i] <= 'Z') {
                        return false;
                    }
                }
                return true;
            }
        }else if (arr[0] >= 'a' && arr[0] <= 'z') {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] >= 'A' && arr[i] <= 'Z') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

class Solution1 {
    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    public int firstUniqChar(String s) {
        if (s == "") {
            return -1;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

class Solution2 {
//    给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
//            'A' : Absent，缺勤
//            'L' : Late，迟到
//            'P' : Present，到场
//    如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
//    你需要根据这个学生的出勤记录判断他是否会被奖赏。
    public boolean checkRecord(String s) {
        if (s == null) {
            return false;
        }
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
            }
            if (a > 1) {
                return false;
            }
            if (i >= 2 && s.charAt(i) == 'L' && s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') {
                return false;
            }
        }
        return true;
    }
}