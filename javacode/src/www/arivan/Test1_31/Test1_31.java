package www.arivan.Test1_31;
import java.util.Scanner;

public class Test1_31 {
    public static void main(String[] args) {
        Array.juZhen();
    }
}

class Array {
    public static void juZhen(){ //矩阵乘法
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[] = new int[1010];
        for (int i = 0; i < n + 1; i++) {
            a[i] = x.nextInt();
        }
        if (n == 1)
            System.out.println(a[0] * a[1]);
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
                    if (sum < dp[i][j])
                        dp[i][j] = sum;
                }
            }
        }
        System.out.println(dp[1][n]);
    }

    public static void multiple(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] a = new long[n][n];
        long[][] b = new long[n][n];
        int i, j;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                b[i][j] = a[i][j] = sc.nextLong();
        if (m == 0)
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (i == j)
                        System.out.print(1 + " ");
                    else
                        System.out.print(0 + " ");
                }
                System.out.println();
            }
        else if (m == 1)
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
        else {
            for (int z = 1; z < m; z++) {
                long[][] tmp = new long[n][n];
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        long add = 0;
                        for (int y = 0; y < n; y++) {
                            add += a[i][y] * b[y][j];
                        }
                        tmp[i][j] = add;
                    }
                }
                b = tmp;
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    System.out.print(b[i][j] + " ");
                System.out.println();
            }
        }
    }
}