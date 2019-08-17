package Test8_17;

import java.util.Arrays;
import java.util.Scanner;

public class Practice8_17 {

    public static void main(String[] args) {

//        Solution.solution();

//        Solution1.solution();

        Solution2.solution();
    }
}

//翻转数列
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long n = in.nextLong();
            long m = in.nextLong();
            long sum = 0;
            sum = n / (2*m) * m * m;
            System.out.println(sum);
        }
        in.close();
    }
}

//纸牌游戏
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            long sum = 0;
            int i = n - 1;
            for (; i > 0; i -= 2) {
                sum += arr[i] - arr[i-1];
            }
            if (i == 0) {
                sum += arr[i];
            }
            System.out.println(sum);
        }
        in.hasNext();
    }
}

//贪吃的小Q
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            System.out.println(run(N,M));
        }
        in.close();
    }
    private static int sum(int count, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += count;
            count = (count + 1) / 2;
        }
        return sum;
    }
    private static int run(int n, int m) {
        if (n == 1) {
            return m;
        }
        int l = 1;
        int r = m;
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            if (sum(mid,n) == m) {
                return mid;
            } else if (sum(mid,n) < m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}