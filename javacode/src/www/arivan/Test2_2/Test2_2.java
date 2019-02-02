package www.arivan.Test2_2;
import java.util.Scanner;

public class Test2_2 {
    public static void main(String[] args){
        //System.out.println(Algorithm.charToint('2')*3);

//        int[] arr = new int[]{1,2,3,4,5,6,7,8};
//        int[] arr1 = Algorithm.cheng(arr,3);
//        for (int i : arr1){
//            System.out.print(i);
//        }

        int[] arr1 = new int[]{0,2,0,9,8,7,6,5,2,6,4};
        int[] arr2 = new int[]{6,8,4,5,1,4,7,8,3,2,6};
        int[] arr = Algorithm.arrayAdd(arr1,arr2);
        for(int i : arr){
            System.out.print(i);
        }

//        String m = "62773417";
//        String n = "12345678";
//        Algorithm.p1001(m, n);

    }
}

class Algorithm { //算法提高P001
    public static void p1001(String m, String n){
        Scanner scanner = new Scanner(System.in);
//        String m = scanner.nextLine();
//        String n = scanner.nextLine();
        char[] arr1 = m.toCharArray();
        char[] arr2 = n.toCharArray();
        int[] result1 = new int[arr1.length];
        int[] result2 = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result1[i] = charToint(arr1[i]);
            result2[i] = charToint(arr2[i]);
        }
        int[] result = new int[16];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        int add = 1;
        for (int i = result1.length-1; i >= 0; i--) {
            int num = result1[i]*add;
            int[] result4 = cheng(result2,num);
            result = arrayAdd(result4,result);
            add *= 10;
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j]);
            }
            System.out.println();
        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i]);
//        }
    }

    public static int[] cheng(int[] arr, int n){ //整数乘数组
        int[] arr1 = new int[16];
        int j = arr1.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            int m = arr[i] * n;
            arr1[j] += m % 10;
            arr1[j-1] += m / 10;
            if(arr1[j] == 10){
                arr1[j-1] += 1;
                arr1[j] = 0;
            }
            j--;
        }
        return arr1;
    }

    public static int[] arrayAdd(int[] arr1, int[] arr2){ //数组相加
        int[] arr3 = new int[16];
        int i = arr3.length-1;
        for (int j = arr1.length-1; j >= 0; j--) {
            int sum = arr1[j] + arr2[j];
            arr3[i] += sum % 10;
            if (i > 0) {
                arr3[i-1] += sum / 10;
            }
            if (arr3[i] == 10){
                arr3[i-1] += 1;
                arr3[i] = 0;
            }
            i--;
        }
        return arr3;
    }

    public static int charToint(char c){ //将char转换成int型
        return c - '0';
    }
}

//public class Test2_2 {
//    public int[][] dp = new int[105][200005];
//
//    public final static Integer t = 100001;  //ai或者bi所有输入项和最大为100*1000 = 100000
//    public final static Integer f = -200005;  //ai+bi所有输入项和最小为100*-1000*2 = -200000
//
//    public int getMax(int a, int b) {
//        return a > b ? a : b;
//    }
//    /*
//     * dp[i][j]:i表示符合输入数据中ai + bi > 0的前i项，j表示这i项中ai的和
//     * dp[i][j]：其具体含义为当前i项ai和为j时，存放前i项中bi和的最大值
//     * 那么，可知共有n项满足ai + bi > 0，那么找出dp[n][j] + j最大值即为最终结果
//     */
//    public void printResult(int[] A, int[] B, int len) {
//        for(int i = 0;i < len;i++) {
//            for(int j = -t;j < t;j++)
//                dp[i][j + t] = f;    //初始化为题目所有输入数据和最小值，即前i项中bi的和
//        }
//        for(int i = 0;i < len;i++) {
//            //此处，使用t作为防止数组越界标准数，因为A[i]有可能小于0，而数组下标不可能为负数
//            dp[i][A[i] + t] = B[i];     //初始化当j = A[i] + t时，此时前i项B的和为B[i]
//        }
//        for(int i = 1;i < len;i++) {
//            for(int j = -t;j < t;j++) {
//                dp[i][j + t] = getMax(dp[i - 1][j + t], dp[i][j + t]);
//                if(j + t - A[i] < 0 || j + t - A[i] > 200001)
//                    continue;
//                //此处判定，作为当j + t中不包含第i项A[i]时，更新当前最大值
//                dp[i][j + t] = getMax(dp[i][j + t], dp[i - 1][j + t - A[i]] + B[i]);
//            }
//        }
//        int result = f;
//        for(int i = 0;i < t;i++) {
//            //可知，最终的dp[i][j]中，其中j >= t，dp[i][j] >= 0，才符合对于sum(ai)和sum(bi)均不小于0的要求
//            if(dp[len - 1][i + t] >= 0)
//                result = getMax(result, dp[len - 1][i + t] + i);
//        }
//        if(result <= 0) {
//            System.out.println(0);
//            return;
//        }
//        System.out.println(result);
//        return;
//    }
//
//    public static void main(String[] args) {
//        Test2_2 test = new Test2_2();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int len = 1;
//        int[] A = new int[n + 1];
//        int[] B = new int[n + 1];
//        for(int i = 1;i <= n;i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            if(a + b > 0) { //过滤掉所有a + b <= 0的数据对
//                A[len] = a;
//                B[len] = b;
//                len++;
//            }
//        }
//        test.printResult(A, B, len);
//    }
//}
