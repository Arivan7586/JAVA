package Test7_22;

import java.util.*;

public class practice7_22 {

    public static void main(String[] args) {

//        Solution solution = new Solution();
//        System.out.println(solution.JumpFloorII(10));
//
//        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.RectCover(10));
//
//        int[] arr = new int[]{6,-3,-2,7,-15,1,2,2};
//        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.FindGreatestSumOfSubArray(arr));

//        Solution4.solution();



    }
}

//变态青蛙跳台阶（牛客网）
class Solution {
    /*
F(n) = F(n-1) + F(n-2) + F(n-3) + .......+ F(n-n)
F(n-1) = F(n-2) + F(n-3) + ...... + F(n-n)
F(n) = F(n-1) + F(n-1)
F(n) = 2 * F(n-1)
*/

    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        int res = 1;
        for (int i = 2; i <= target; i++) {
            res *= 2;
        }
        return res;
    }
}

// 12
// 4873279
// ITS-EASY
// 888-4567
// 3-10-10-10
// 888-GLOP
// TUT-GLOP
// 967-11-11
// 310-GINO
// F101010
// 888-1200
// -4-8-7-3-2-7-9-
// 487-3279
// 4
// UTT-HELP
// TUT-GLOP
// 310-GINO
// 000-1213

//矩形覆盖(牛客网)
class Solution1 {
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }
}

//最大连续子数组和
class Solution3 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum > 0) {
                sum += array[i];
            }else {
                sum = array[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}

//电话号码
class Solution4 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            Set<String> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(change(arr[i]));
            }
            for (String str : set) {
                System.out.println(str);
            }
            System.out.println();
        }
        in.close();
    }

    /**
     * 将给定字符串转换成电话号码
     * @param str 给定字符串
     * @return 返还转换后的电话号码
     */
    private static String change(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);
            if (value == '-') {
                continue;
            }
            if (value == 'A' || value == 'B' || value == 'C') {
                value = '2';
            } else if (value == 'D' || value == 'E' || value == 'F') {
                value = '3';
            } else if (value == 'G' || value == 'H' || value == 'I') {
                value = '4';
            } else if (value == 'J' || value == 'K' || value == 'L') {
                value = '5';
            } else if (value == 'M' || value == 'N' || value == 'O') {
                value = '6';
            } else if (value == 'P' || value == 'Q' || value == 'R' || value == 'S') {
                value = '7';
            } else if (value == 'T' || value == 'U' || value == 'V') {
                value = '8';
            } else if (value == 'W' || value == 'X' || value == 'Y' || value == 'Z') {
                value = '9';
            }
            sb.append(value);
        }
        return sb.substring(0,3) + "-" + sb.substring(3);
    }
}