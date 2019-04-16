package www.exercises.Test4_16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test4_16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] a = solution.findWords(arr);
        for (String s : a) {
            System.out.print(s+" ");
        }

        String ss = "abcdef";
        System.out.println();
        System.out.println(ss.substring(1,4));
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findAnagrams("cbaebabacd","abc"));
        System.out.println(solution1.findAnagrams("abab","ab"));
    }
}

class Solution {
    /**
     * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
     * @param words 给定单词表
     * @return 返回可以使用在键盘同一行的字母打印出来的单词
     */
    public String[] findWords(String[] words) {
        if (words == null || words.length < 1) {
            return words;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isSameRow(words[i])) {
                list.add(words[i]);
            }
        }
        String[] res = list.toArray(new String[]{});
//        String[] res = new String[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
        return res;
    }

    /**
     * 判断给定单词的字母是否都在键盘的同一行
     * @param str 给定单词
     * @return 是，返回true，否则返回false
     */
    public boolean isSameRow(String str) {
        ArrayList<Character> list1 = new ArrayList<>(14);
        ArrayList<Character> list2 = new ArrayList<>(18);
        Collections.addAll(list1,'Z','z','X','x','C','c','V','v',
                'B','b','N','n','M','m');
        Collections.addAll(list2,'A','a','S','s','D','d','F','f',
                'G','g','H','h','J','j','K','k','L','l');
        if (list1.contains(str.charAt(0))) {
            for (int i = 0; i < str.length(); i++) {
                if (!list1.contains(str.charAt(i))) {
                    return false;
                }
            }
        }else if (list2.contains(str.charAt(0))) {
            for (int i = 0; i < str.length(); i++) {
                if (!list2.contains(str.charAt(i))) {
                    return false;
                }
            }
        }else {
            for (int i = 0; i < str.length(); i++) {
                if (list1.contains(str.charAt(i)) || list2.contains(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution1 {
    /**
     * 找到字符串中所有字母异位词
     * @param s 在s中找
     * @param p 需要找p的字母异位词
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int count = p.length();
        for (int i = 0; i <= s.length()-count; i++) {
            if (isEctopyWord(s.substring(i,i+count),p)) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            list.add(0);
        }
        return list;
    }

    /**
     * 判断字符串s是否为字符串p的字母异位词
     * @param s
     * @param p
     * @return 是，返回true，否则返回false
     */
    public boolean isEctopyWord(String s, String p) {
        int valueS = 0;
        int valueP = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!p.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
            valueS += s.charAt(i);
            valueP += p.charAt(i);
        }
        if (valueS == valueP) {
            return true;
        }
        return false;
    }
}