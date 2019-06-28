package Test6_28;

public class practice6_28 {

    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.change("1211"));

        System.out.println(solution2.countAndSay(10));
    }
}

//最小差值I
class Solution {
    /**
     * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，
     * 并将 x 加到 A[i] 中。
     *
     * 在此过程之后，我们得到一些数组 B。
     *
     * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
     * @param A 给定数组
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        K = Math.abs(K);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = max > A[i] ? max : A[i];
            min = min < A[i] ? min : A[i];
        }
        if (max - min <= 2*K) {
            return 0;
        }
        return max-min-K-K;
    }
}

//除数博弈
class Solution1 {
    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     *
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     *
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     *
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。
     * 假设两个玩家都以最佳状态参与游戏。

     * @param N
     * @return 如果先走的人，数字为奇数，必输。偶数则必赢
     */
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}

//报数
class Solution2 {
    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
     * 其前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * @param n 需要输出的第n项
     * @return
     */
    public String countAndSay(int n) {
        String value = "1";
        for (int i = 1; i < n; i++) {
            value = change(value);
        }
        return value;
    }
    public String change(String value) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        int n = value.length();
        char flag = value.charAt(0);
        for (int i = 0; i < n; i++) {
            if (flag == value.charAt(i)) {
                sum++;
                if (i < n - 1) {
                    if (value.charAt(i+1) != flag) {
                        res.append(sum).append(flag);
                        sum = 0;
                        flag = value.charAt(i+1);
                    }
                } else {
                    res.append(sum).append(flag);
                }
            }
        }
        return String.valueOf(res);
    }
}