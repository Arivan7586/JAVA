package Test7_30;

import java.util.Arrays;
import java.util.Scanner;

public class practice7_30 {

    public static void main(String[] args) {

//        Solution.solution();
//
//        Solution1.solution();

        Solution2.solution();

    }
}


//俄罗斯方块
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String str = "";
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int value = in.nextInt();
            arr[value-1] += 1;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}

//瞌睡
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int[] arr2 = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
            if (arr2[i] == 1) {
                sum += arr1[i];
            }
        }
        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            int value = 0;
            for (int j = 0; j < k; j++) {
                if (arr2[i+j] == 0) {
                    value += arr1[i+j];
                }
            }
            max = value >= max ? value : max;
        }
        System.out.println(sum + max);
    }
}


//丰收
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int value = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt() + value;
            value = arr[i];
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            System.out.println(run(arr,num));
        }
        in.close();
    }
    private static int run(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (value > arr[mid]) {
                if (mid + 1 < arr.length && value <= arr[mid+1]) {
                    return mid + 2;
                }
                l = mid + 1;
            } else if (value < arr[mid]) {
                if (mid - 1 >= 0 && value >= arr[mid-1]) {
                    return mid + 1;
                }
                r = mid - 1;
            }
        }
        return -1;
    }
}