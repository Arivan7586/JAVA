package Test5_22;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class practice5_22 {

    public static void main(String[] args) {
//        Solution.solution();

//        int[] arr = new int[]{1, 2, 3, 5, 6, 8};
//        int[] a = new int[3];
//        System.arraycopy(arr, 0, a, 0, 3);
//        for (int i : a) {
//            System.out.println(i);
        AntiOrder antiOrder = new AntiOrder();
        System.out.println(antiOrder.count1(new int[]{1, 2, 3, 5, 6, 0},6));

    }
}


class AntiOrder {
    /**
     * 数组中的逆序对
     *
     * @param A 给定数组
     * @param n 数组的长度
     * @return 返回逆序对的个数
     */
    public int count(int[] A, int n) {
        if (A == null || n <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //暴力遍历
    public int count1(int[] A, int n) {
        if (A == null || n <= 1) {
            return 0;
        }
        return solution(A, 0, n - 1);
    }

    //分治思想（采用归并排序的思路）
    private int solution(int[] a, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int count = 0;
        count += solution(a, l, mid);
        count += solution(a, mid + 1, r);
        count += merge(a, l, mid, r);
        return count;
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int index = 0;
        int i = l;
        int j = mid + 1;
        int inverseNum = 0;// 新增，用来累加数组逆序对
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= r) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[l++] = temp[k];
        }
        return inverseNum;
    }
}


class Solution {
    /**
     * 汽水瓶
     * <p>
     * 三个空汽水瓶可以换一瓶汽水，给定空汽水瓶的个数，求出一共可以喝多少汽水
     */
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(solution(n));
        }

//        LinkedList<Integer> list = new LinkedList<>();
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            int value = scanner.nextInt();
//            if (value == 0) {
//                break;
//            }
//            list.add(value);
//        }
//        if (list.isEmpty()) {
//            return;
//        }
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(solution(iterator.next()));
//        }
    }

    private static int solution(int value) {
        int sum = 0;
        while (value > 1) {
            int count = value / 3;
            sum += count;
            value = value % 3 + count;
            if (value == 2) {
                sum++;
                break;
            }
        }
        return sum;
    }
}
