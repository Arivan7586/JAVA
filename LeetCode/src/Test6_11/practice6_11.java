package Test6_11;

import java.util.*;

public class practice6_11 {

    public static void main(String[] args) {
//        Solution.solution();

        Substr substr = new Substr();
        boolean[] arr = substr.chkSubStr(new String[]{"a","b","c","d"},
                4,"abc");
        for (boolean b : arr) {
            System.out.print(b+" ");
        }


    }
}

//成绩排序
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int flag = in.nextInt();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                int value = in.nextInt();
                list.add(value);
                map.put(str + " " + value,value);
            }
            Collections.sort(list);
            if (flag == 0) {
                Collections.reverse(list);
            }
            int f = -1;
            for (int i : list) {
                if (f == i) {
                    continue;
                }
                for (String k : map.keySet()) {
                    if (map.get(k).equals(i)) {
                        System.out.println(k);
                    }
                }
                f = i;
            }
        }
    }
}

//子串判断
class Substr {
    /**
     * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，
     * 请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。
     *
     * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，
     * 每个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，
     * 且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
     *
     * @param p 给定字符串数组
     * @param n 给定字符串数组长度
     * @param s 给定字符串
     * @return
     */
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] arr = new boolean[n];
        for (int i = 0; i < p.length; i++) {
            if (s.contains(p[i])) {
                arr[i] = true;
            }
        }
        return arr;
    }
}