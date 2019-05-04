package Test5_4;

import java.util.*;

public class practice5_4 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(
                new String[]{"hello","leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"));

        System.out.println(solution.isAlienSorted(
                new String[]{"word","world","row"},
                "worldabcefghijkmnpqstuvxyz"));

        System.out.println(solution.isAlienSorted(
                new String[]{"apple","app"},
                "abcdefghijklmnopqrstuvwxyz"));

        System.out.println(solution.isAlienSorted(
                new String[]{"kuvp","q"},
                "ngxlkthsjuoqcpavbfdermiywz"));

        Solution1 solution1 = new Solution1();
        int[] arr = solution1.findErrorNums(new int[]{1,2,2,4});
        int[] arr1 = solution1.findErrorNums(new int[]{3,2,3,4,6,5});
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("-----------------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(solution2.findDuplicate(new int[]{3,1,3,4,2}));
    }
}

class Solution {

    /**
     * 验证外星语词典
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。
     * 字母表的顺序（order）是一些小写字母的排列。
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
     * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
     * @param words  给定单词表
     * @param order 外星语词典
     * @return 通过验证返回true，否则返回false
     */
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),(char) (i+97));
        }
        String[] arr = new String[words.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stringToNumber(words[i],map);
        }
        String[] arr1 = new String[arr.length];
        int k = 0;
        for (String s : arr) {
            arr1[k++] = s;
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if (!arr[i].equals(arr1[i])) {
                return false;
            }
        }
        return true;
    }

    private String stringToNumber(String str, HashMap<Character,Character> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(map.get(str.charAt(i)));
        }
        return String.valueOf(stringBuilder);
    }
}

class Solution1 {
    /**
     * 错误的集合
     * @param nums 给定集合
     * @return 返回符合条件的数组
     */
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[2];
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            flag = set.add(nums[i]);
            if (!flag) {
                arr[0] = nums[i];
            }
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                arr[1] = i;
                break;
            }
            i++;
        }
        return arr;
    }
}

class Solution2 {
    /**
     * 寻找重复数
     * @param nums 给定数组
     * @return 返回重复的数字
     */
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            arr[value]++;
            if (arr[value] > 1) {
                return value;
            }
        }
        return 0;
    }
}