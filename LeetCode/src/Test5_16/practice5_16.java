package Test5_16;

import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class practice5_16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab"));
        System.out.println(solution.rotateString("abcde", "abced"));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.trailingZeroes(3));
        System.out.println(solution1.trailingZeroes(5));
        System.out.println(solution1.trailingZeroes(13));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.largeGroupPositions("abbxxxxzzy"));
        System.out.println(solution2.largeGroupPositions("abc"));
        System.out.println(solution2.largeGroupPositions("aaa"));
        System.out.println(solution2.largeGroupPositions("abcdddeeeeaabbbcd"));

    }
}

class Solution {
    /**
     * 旋转字符串
     * <p>
     * 给定两个字符串, A 和 B。
     * A 的旋转操作就是将 A 最左边的字符移动到最右边。
     * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
     * 如果在若干次旋转操作之后，A 能变成B，那么返回True。
     *
     * @param A 给定字符串A
     * @param B 给定字符串B
     * @return 符合条件返回true，否则返回false
     */
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        String flag = A;
        for (int i = 0; i < A.length(); i++) {
            StringBuilder str = new StringBuilder(flag.substring(1));
            str.append(flag.charAt(0));
            if (B.equals(String.valueOf(str))) {
                return true;
            }
            flag = String.valueOf(str);
        }
        return false;
    }
}

class Solution1 {
    /**
     * 阶乘后的零
     *
     * 给定一个整数n，返回n！结果尾数中零的数量
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            if (n % 5 == 0) {
                count += n / 5;
                n /= 5;
            } else {
                n--;
            }
        }
        return count;
    }
}

class Solution2 {
    /**
     * 较大分组的位置
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     *
     * 最终结果按照字典顺序输出。
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return list;
        }
        char[] arr = S.toCharArray();
        int l = 0;
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[l]) {
                r = i;
            } else {
                if (r - l >= 2) {
                    List<Integer> list1 = new ArrayList<>(2);
                    list1.add(l);
                    list1.add(r);
                    list.add(list1);
                }
                l = i;
                r = i;
            }
        }
        if (r - l >= 2) {
            List<Integer> list1 = new ArrayList<>(2);
            list1.add(l);
            list1.add(r);
            list.add(list1);
        }
        return list;
    }
}