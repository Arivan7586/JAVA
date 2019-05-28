package Test5_28;

import java.util.Arrays;
import java.util.Scanner;

public class practice5_28 {

    public static void main(String[] args) {

        Solution1.solution();
    }
}

class Solution {
    /**
     * 保持城市天际线
     * <p>
     * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量
     * （不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
     * <p>
     * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”
     * 必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形
     * 的外部轮廓。 请看下面的例子。
     * <p>
     * 建筑物高度可以增加的最大总和是多少？
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] value = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                value[i][j] = secondMax(grid, i, j);
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += Math.abs(value[i][j] - grid[i][j]);
            }
        }
        return sum;
    }

    private int secondMax(int[][] arr, int i, int j) {
        int value1 = 0;
        int value2 = 0;
        for (int m = 0; m < arr.length; m++) {
            value1 = arr[m][j] > value1 ? arr[m][j] : value1;
        }
        for (int m = 0; m < arr[i].length; m++) {
            value2 = arr[i][m] > value2 ? arr[i][m] : value2;
        }
        return value1 < value2 ? value1 : value2;
    }
}

class Solution1 {
    /**
     * 删数
     *
     * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
     * 求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，
     * 0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(findValue(n));
        }
    }
    private static int findValue(int n) {
        if (n < 0) {
            return -1;
        } else if (n > 1000) {
            n = 999;
        }
        char[] arr = new char[n];
        int i = 0;
        int flag = 0;
        while (n > 1) {
            if (arr[i] != '1') {
                if (flag == 2) {
                    arr[i] = '1';
                    n--;
                    flag = 0;
                } else {
                    flag++;
                }
            }
            i++;
            if (i >= arr.length) {
                i = 0;
            }
        }
        return String.valueOf(arr).indexOf((char)0);
    }
}

class Solution2 {
    /**
     * 求数组中最小的k个数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] arr = input.trim().split(" ");
        int n = arr.length;
        int k = Integer.parseInt(arr[n - 1]);
        int[] value = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            value[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(value);
        for (int i = 0; i < k; i++) {
            System.out.print(value[i] + " ");
        }
    }
}