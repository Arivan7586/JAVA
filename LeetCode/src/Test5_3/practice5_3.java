package Test5_3;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class practice5_3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = solution.uncommonFromSentences1(
                "this apple is sweet","this apple is sour");
        String[] arr1 = solution.uncommonFromSentences(
                "apple apple","banana");
        String[] arr2 = solution.uncommonFromSentences(
                null,"banana");
        String[] arr3 = solution.uncommonFromSentences(
                "apple apple",null);
        for (String i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(solution.differentValue(list));

    }
}

class Solution {
    /**
     * 两句话中不常见的单词
     * @param A 句子A
     * @param B 句子B
     * @return 返回符合要求的单词
     */
    public String[] uncommonFromSentences(String A, String B) {
        if (A == null && B == null) {
            return new String[]{};
        } else if ((A == null || A.equals("")) && B != null) {
            return B.trim().split(" ");
        } else if ((B == null || B.equals(""))) {
            return A.trim().split(" ");
        }
        ArrayList<String> list1 = stringArrayToList(A);
        HashSet<String> set1 = differentValue(list1);

        ArrayList<String> list2 = stringArrayToList(B);
        HashSet<String> set2 = differentValue(list2);

        Iterator<String> iterator1 = set1.iterator();
        Iterator<String> iterator2 = set2.iterator();
        HashSet<String> set = new HashSet<>();
        while (iterator1.hasNext()) {
            String value = iterator1.next();
            if (!list2.contains(value)) {
                set.add(value);
            }
        }
        while (iterator2.hasNext()) {
            String value = iterator2.next();
            if (!list1.contains(value)) {
                set.add(value);
            }
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String s : set) {
            res[i++] = s;
        }
        return res;
    }
    public HashSet<String> differentValue(ArrayList<String> list) {
        HashSet<String> set = new HashSet<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : list) {
            if (!linkedList.contains(s)) {
                boolean flag = set.add(s);
                if (!flag) {
                    set.remove(s);
                    linkedList.add(s);
                }
            }
        }
        return set;
    }
    private ArrayList<String> stringArrayToList(String str) {
        String[] arr = str.trim().split(" ");
        ArrayList<String> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
    public String[] uncommonFromSentences1(String A, String B) {
        if (A == null && B == null) {
            return new String[]{};
        }
        String str = A + " " + B;
        String[] arr = str.trim().split(" ");
        HashSet<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        for (String s : arr) {
            if (!list.contains(s)) {
                boolean flag = set.add(s);
                if (!flag) {
                    list.add(s);
                }
            }
        }
        for (String s : list) {
            set.remove(s);
        }
        return set.toArray(new String[]{});
    }
}