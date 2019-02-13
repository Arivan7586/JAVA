package www.arivan.Test2_13;
import java.util.Scanner;

public class Test2_13 {  //矩阵乘法
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[] = new int[1010];
        for (int i = 0; i < n + 1; i++) {
            a[i] = x.nextInt();
        }
        if (n == 1) {
            System.out.println(a[0] * a[1]);
        }
        long dp[][] = new long[1010][1010];
        long sum;
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 1000000000;
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                dp[i][i] = dp[j][j] = 0;
                for (int k = i; k < j; k++) {
                    sum = dp[i][k] + dp[k + 1][j] + a[i - 1] * a[k] * a[j];
                    if (sum < dp[i][j]) {
                        dp[i][j] = sum;
                    }
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
