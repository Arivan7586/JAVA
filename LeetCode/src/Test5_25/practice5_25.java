package Test5_25;

import java.util.Arrays;
import java.util.Scanner;

public class practice5_25 {

    public static void main(String[] args) {
//        Solution.solution();
//        Solution1.solution();
    }
}

class Solution {
    /**
     * 计算糖果
     *
     * A,B,C三个人是好朋友，每个人手里都有一些糖果，我们不知道他们每个人手上具体
     * 有多少糖果，但是我们直到以下信息：A-B,B-C,A+B,B+C。这四个数值，每个字母代表
     * 每个人拥有的糖果数，现在需要通过这四个数值计算出每个人手里有多少个糖果，即
     * A,B,C。这里保证最多只有一组整数满足所有条件
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.trim().split(" ");
        int value1 = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
        int value2 = Integer.parseInt(arr[1]) + Integer.parseInt(arr[3]);
        if (value1 < 0 || value2 < 0 || value1%2 == 1 || value2%2 == 1) {
            System.out.println("No");
        } else {
            int A = value1 / 2;
            int B = value2 / 2;
            int C = B - Integer.parseInt(arr[1]);
            if (C < 0) {
                System.out.println("No");
            } else {
                System.out.println(A + " " + B + " " + C);
            }
        }
    }
}

class Solution1 {
    /**
     * n个数里面出现次数大于等于n/2的数字
     *
     * 输入n个整数，输出出现次数大于等于数组长度一半的数字
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.trim().split(" ");
        Arrays.sort(arr);
        int n = arr.length;
        if (n%2 == 1) {
            System.out.println(arr[n/2]);
        } else {
            if (arr[n/2-1].equals(arr[0])) {
                System.out.println(arr[n/2-1]);
            } else {
                System.out.println(arr[n/2]);
            }
        }
    }
}