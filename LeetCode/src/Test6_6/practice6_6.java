package Test6_6;

import java.util.Scanner;

public class practice6_6 {

    public static void main(String[] args) {

//        Solution.solution();

//        Solution1.solution();

        Solution2.solution();
    }
}

// 3 3 1 1 2 3 4 5 6 3 2 1 2 3 4 5 6 2 2 1 1 1 1
//饥饿的小易
class Solution {

    /**
     * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。
     * 最开始小易在一个初始位置x_0。对于小易所处的当前位置x，
     * 他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。
     * 因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
     * 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，
     * 位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(times(x));
    }

    private static int times(int x) {
        int count = 0;
        while (count <= 300000) {
            if (x % 1000000007 == 0) {
                break;
            }
            x = x * 2 + 1;
            x %= 1000000007;
            count++;
        }
        if (count % 3 == 0) {
            count /= 3;
        } else {
            count = count / 3 + 1;
        }
        return count > 100000 ? -1 : count;
    }
}

//统计同成绩学生的人数
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            int value = in.nextInt();
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (value == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

//洗牌
class Solution2 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n * 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < k; i++) {
                run(arr);
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i != arr.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void run(int[] arr) {
        int[] res = new int[arr.length];
        int i = arr.length - 1;
        int j = arr.length / 2 - 1;
        for (int l = 0; l < res.length; l++) {
            if (l % 2 == 0) {
                res[l] = arr[i--];
            } else {
                res[l] = arr[j--];
            }
        }
        for (int k = 0; k < res.length; k++) {
            arr[k] = res[res.length - 1 - k];
        }
    }
}