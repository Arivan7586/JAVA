package Test5_27;

import java.util.Scanner;

public class practice5_27 {

    public static void main(String[] args) {
        Solution.solution();
//        Solution1.solution();
    }

}

class Solution {
    /**
     * 不要二
     *
     * 二货小易有一个W*H的网格盒子，网格的行编号为0-H-1，网格的列编号为0-W-1.每个格子
     * 至少可以放一块蛋糕，任意两个蛋糕的欧几里得距离不能等于2.
     * 对于两个格子坐标（x1，y1），（x2,y2）的欧几里得距离为：
     * （x1-x2）*（x1-x2）+（y1-y2）*（y1-y2）的算术平方根，小易想知道最多可以放多少块
     * 蛋糕在网格盒子里。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int[][] arr = new int[W][H];
        int count = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (isTrue(arr,i,j)) {
                    count++;
                    arr[i][j] = 2;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean isTrue(int[][] arr, int i, int j) {
        if (j + 2 < arr[i].length && arr[i][j+2] == 2) {
            return false;
        }
        if (j - 2 >= 0 && arr[i][j-2] == 2) {
            return false;
        }
        if (i + 2 < arr.length && arr[i+2][j] == 2) {
            return false;
        }
        if (i - 2 >= 0 && arr[i-2][j] == 2) {
            return false;
        }
        return true;
    }
}

class Solution1 {
    /**
     * 求最小公倍数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        if (A == B) {
            System.out.println(A);
        } else if (A % B == 0) {
            System.out.println(A);
        } else if (B % A == 0) {
            System.out.println(B);
        } else {
            int value1 = A > B ? A : B;
            int value2 = A < B ? A : B;
            int i = 2;
            while (true) {
                if ((value1 * i) % value2 == 0) {
                    break;
                }
                i++;
            }
            System.out.println(value1 * i);
        }
    }
}

class Solution2 {
    /**
     * 比特位计数
     *
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
     * 计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * @param num 给定非负整数
     * @return 返回符合条件的数组
     */
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i <= num; i++) {
            arr[i] = countOne(i);
        }
        return arr;
    }
    private int countOne(int n) {
        int count = 0;
        while (n > 0) {
            if ((n&1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}