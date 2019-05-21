package Test5_21;

import java.util.Arrays;
import java.util.Scanner;

public class practice5_21 {

    public static void main(String[] args) {
        Main main = new Main();
//        main.test();

        Finder finder = new Finder();
        System.out.println(finder.findKth(new int[]{1,3,5,2,6},5,3));
    }
}

class Main {
    /**
     * 统计回文
     * <p>
     * 给定两个字符串A、B。将B插入A中，输出有多少种插法可以使得最终结果为
     * 回文串
     */
    public void test() {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (isTrueString(A.substring(0, i) + B + A.substring(i))) {
                count++;
            }
        }
        if (isTrueString(B + A)) {
            count++;
        }
        System.out.println(count);
    }

    private static boolean isTrueString(String str) {
        if (str == null || str.length() == 0) {
            return false;
        } else if (str.length() == 1) {
            return true;
        }
        int l = 0;
        int r = str.length() - 1;
        while (r >= l) {
            if (str.charAt(r) != str.charAt(l)) {
                return false;
            }
            r--;
            l++;
        }
        return true;
    }
}

class Finder {
    public int findKth(int[] a, int n, int K) {
        // write code here
//        Arrays.sort(a);
//        return a[a.length-K];
        return partition(a, 0, a.length - 1, K);
    }

    private int partition(int[] arr, int l, int r, int k) {
//        int result;
//        int link = findIndex(arr, l, r);
//        if(link+1 == k) {
//            result =  arr[link];
//        } else if( link + 1 < k) {
//            result = partition(arr, link+1, r,k);
//        } else {
//            result=  partition(arr,l, link-1, k);
//        }
//        return result;

        int index = findIndex(arr, l, r);
        int res = 0;
        if (index + 1 > k) {
            res = partition(arr, l,index - 1, k);
        } else if (index + 1 < k) {
           res =  partition(arr, index + 1, r, k);
        } else {
            res =  arr[index];
        }
        return res;
    }

    private int findIndex(int[] arr, int l, int r) {
//        int pivot = arr[r];
//        int i = l;
//        int j = l;
//        for(; j< r; j++) {
//            if(arr[j] > pivot)     {
//                if( i == j) {
//                    i++;
//                }
//                else {
//                    swap(arr, i, j);
//                    i++;
//                }
//            }
//        }
//        swap(arr, i, r);
//        return i;

        int randomIndex = (int) (Math.random() * (r - l + 1) + l);
        int value = arr[randomIndex];
        swap(arr, l, randomIndex);
        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] > value) {
                swap(arr,i,j+1);
                j++;
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