package www.exercises.Test4_22;


public class Test4_22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));

        System.out.println("----------------");
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.binaryGap(22));
        System.out.println(solution1.binaryGap(5));
        System.out.println(solution1.binaryGap(6));
        System.out.println(solution1.binaryGap(8));

        int[] arr = new int[]{5,4,9,0,3,2,8,7,1,6};
        QuickSort.printArray(arr);
        QuickSort.quickSort(arr);
        QuickSort.printArray(arr);
    }
}

class Solution {
    /**
     * 给定一个正整数，检查他是否为交替位二进制数：
     * 换句话说，就是他的二进制数相邻的两个位数永不相等。
     * @param n 给定的正整数
     * @return 是交替二进制数，返回true，否则返回false
     */
    public boolean hasAlternatingBits(int n) {
        if (n == 0) {
            return false;
        }
        int flag = -1;
        while (n > 0) {
            int value = 1&n;
            if (flag == value) {
                return false;
            }else {
                flag = value;
            }
            n >>= 1;
        }
        return true;
    }
}

class Solution1 {
    /**
     * 二进制间距
     * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
     *
     * 如果没有两个连续的 1，返回 0 。
     * @param N 给定的整数
     * @return
     */
    public int binaryGap(int N) {
        if (N == 0 || N == 1) {
            return 0;
        }
        int i = 0;
        int maxGap = 0;
        int flag = 0;
        boolean first = true;
        while (N > 0) {
            if ((1&N) == 1) {
                if (first) {
                    first = false;
                    flag = i;
                }
                maxGap = (i-flag)>maxGap ? (i-flag) : maxGap;
                flag = i;
            }
            N >>= 1;
            i++;
        }
        return maxGap;
    }
}

class QuickSort {
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        sort(arr,0,n-1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int midValue = findIndex3(arr,l,r);
        sort(arr,l,midValue-1);
        sort(arr,midValue+1,r);
    }

    /**
     * 单路快排
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int findIndex1(int[] arr, int l, int r) {
        int randomIndex = (int) Math.random()*(r-l+1) + l;
        swap(arr,l,randomIndex);
        int value = arr[l];

        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] < value) {
                swap(arr,j+1,i);
                j++;
            }
            i++;
        }
        swap(arr,l,j);
        return j;
    }

    /**
     * 二路快排
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int findIndex2(int[] arr, int l, int r) {
        int randomIndex = (int) Math.random()*(r-l+1) + l;
        swap(arr,l,randomIndex);
        int value = arr[l];

        int i = l + 1;
        int k = r;
        while (true) {
            while (i <= k && arr[i] < value) {
                i++;
            }
            while (k >= i && arr[k] > value) {
                k--;
            }
            if (i > k) {
                break;
            }
            swap(arr,i,k);
            i++;
            k--;
        }
        swap(arr,l,k);
        return k;
    }

    private static int findIndex3(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random()*(r-l+1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];

        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] < value) {
                swap(arr,l+1,i);
                i++;
                j++;
            }else if (arr[i] > value) {
                swap(arr,i,k-1);
                k--;
            }else {
                i++;
            }
        }
        swap(arr,l,j);
        return j;
    }

    /**
     * 交换链表中的两个元素
     * @param arr 交换的链表
     * @param i 元素1
     * @param j 元素2
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}