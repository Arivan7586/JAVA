package Test6_16;

import java.util.Scanner;

public class practice6_16 {

    public static void main(String[] args) {

//        Solution1.solution();

        Solution2 solution2 = new Solution2();
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(solution2.findKthLargest(arr,4));
    }
}

//小易的升级之路
class Solution {
    /**
     * 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.
     * 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
     * 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,
     * 并且使得自己的能力值增加bi;如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi
     * 与c的最大公约数.那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(run(arr,a));
        }
        in.close();
    }
    private static int run(int[] arr, int a) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= a) {
                a += arr[i];
            } else {
                a += maxCommonDivisor(a,arr[i]);
            }
        }
        return a;
    }
    private static int maxCommonDivisor(int a, int b) {
        int n = a < b ? a : b;
        int max = 1;
        for (int i = 1; i <= n; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i > max ? i : max;
            }
        }
        return max;
    }
}

//最高分是多少
class Solution1 {
    /**
     * 输入包括多组测试数据。
     * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,
     * 分别代表学生的数目和操作的数目。
     * 学生ID编号从1编到N。
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
     * 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
     * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                String value = in.next();
                int A = in.nextInt();
                int B = in.nextInt();
                if (value.equals("Q")) {
                    System.out.println(max(arr,A,B));
                } else {
                    arr[A - 1] = B;
                }
            }
        }
        in.close();
    }
    private static int max(int[] arr, int A, int B) {
        int i = Math.min(A,B) - 1;
        int j = Math.max(A,B);
        int max = arr[i];
        while (i < j) {
            max = arr[i] > max ? arr[i] : max;
            i++;
        }
        return max;
    }
}

//数组中的第K个最大元素（使用大顶堆）
class Solution2 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k
     * 个最大的元素，而不是第 k 个不同的元素
     * @param nums 给定数组
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return findValue(nums,0,nums.length - 1,k);
    }
    private int findValue(int[] arr, int l, int r, int k) {
        int index = find(arr,l,r);
        int res = 0;
        if (index + 1 > k) {
            res = findValue(arr,l,index-1,k);
        } else if(index + 1 < k) {
            res = findValue(arr,index+1,r,k);
        } else {
            res = arr[index];
        }
        return res;
    }
    private int find(int[] arr, int l, int r) {
        int randomIndex = (int)(Math.random() * (r-l+1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] > value) {
                swap(arr,i,++j);
            }
            i++;
        }
        swap(arr,l,j);
        return j;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}