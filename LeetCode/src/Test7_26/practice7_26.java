package Test7_26;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;


public class practice7_26 {

    public static void main(String[] args) {

//        Solution.test();

//        Solution.solution();

//        MaxGap maxGap = new MaxGap();
//        int[] arr = new int[]{2,7,1,1,3};
//        System.out.println(maxGap.findMaxGap(arr,5));

        Printer printer = new Printer();
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] res = printer.clockwisePrint(arr,3,3);

        for (int i : res) {
            System.out.print(i + " ");
        }

    }

}

//顺时针打印矩阵
class Printer {

    private List<Integer> list = new ArrayList<>();
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] arr = new int[n * m];
        if (mat == null) {
            return arr;
        }
        int i = 0, j = 0, k = 0;
        int sx = 0,sy = 0;
        int ex = n - 1;
        int ey = m - 1;

        while (sx <= ex && sy <= ey) {
            if (sx == ex) {
                while ( j <= ey) {
                    arr[k++] = mat[i][j++];
                }
                return arr;
            }

            if (sy == ey) {
                while (i <= ex) {
                    arr[k++] = mat[i++][j];
                }
                return arr;
            }
            while (j < ey) {
                arr[k++] = mat[i][j++];
            }
            while (i < ex) {
                arr[k++] = mat[i++][j];
            }
            while (j > sy) {
                arr[k++] = mat[i][j--];
            }
            while (i > sx) {
                arr[k++] = mat[i--][j];
            }
            i++;
            j++;
            sx++;
            sy++;
            ex--;
            ey--;
        }
        return arr;
    }

}

class MaxGap {
    public int findMaxGap(int[] A, int n) {
        int leftmax = 0;
        int rightmax = 0;
        int value = 0 ;
        int temp = 0;
        for(int K = 0 ; K < n-1 ; K++){
            if (value != 0 && A[K] > leftmax) {
                leftmax = A[K];
            } else {
                leftmax = A[0];
                for (int i = 0; i <= K; i++) {
                    leftmax = A[i] > leftmax ? A[i] : leftmax;
                }
            }
            rightmax = A[K+1];
            for(int j = K+1 ;j<n ; j++){
                rightmax = A[j]>rightmax?A[j]:rightmax;
            }
            value = leftmax - rightmax;
            value = value<0?-value:value;
            temp = value>temp?value:temp;
        }
        return temp;
    }
}


class Solution {

    static class Entry implements Comparable{
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            Entry entry = (Entry) o;
            if (this.value > entry.value) {
                return 1;
            } else if (this.value < entry.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            List<Entry> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                int value = in.nextInt();
                list.add(new Entry(i,value));
            }
            int k = in.nextInt();
            int d = in.nextInt();
            Collections.sort(list);
            int index = list.size() - 1;
            List<Integer> integerList = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                int key = list.get(i).key;
                int value = list.get(i).value;
                if (k <= 0) {
                    break;
                }
                if (index - key <= d) {
                    integerList.add(value);
                    index = key;
                    k--;
                }
            }
            int res = 1;
            for (int i = 0; i < integerList.size(); i++) {
                res *= integerList.get(i);
            }
            System.out.println(res);
        }
        in.close();
    }
}