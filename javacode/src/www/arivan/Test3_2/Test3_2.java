package www.arivan.Test3_2;
import java.util.Scanner;

public class Test3_2 {
    public static void main(String[] args) {
//        int[][] A = new int[][]{{1,2},{3,4}};
//        Solution solution = new Solution();
//        int[][] arr = solution.matrixReshape(A,1,4);
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]+" ");
//            }
//        }

//        Solution1 solution1 = new Solution1();
//        int[] arr = new int[]{2,2,1,1,1,2,2};
//        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,5,3,2,3,2,3};
//        System.out.println(solution1.majorityElement(arr));

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        Solution3 solution3 = new Solution3();
        int n = solution3.removeDuplicates(nums);
        System.out.println(n);

    }
}

class Solution {
//    给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
//
//    重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
//
//    如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (m*n == r*c) {
            int[][] arr = new int[r][c];
            int a = 0;
            int b = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (b < c && a < r) {
                        arr[a][b] = nums[i][j];
                        b++;
                    }
                    if (b == c && a < r) {
                        a++;
                        b = 0;
                    }
                }
            }
            return arr;
        }
        return nums;
    }
}

class Solution1 {
    //给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
        // for (int i = 0; i < nums.length; i++) {
        //     int count = 1;
        //     for (int j = i+1; j < nums.length; j++) {
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if (count > nums.length/2) {
        //         return nums[i];
        //     }
        // }
        // return 0;
    }
}

class Solution2 {
//    如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
//
//    给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!(isSame(matrix,i,0))) {
                return false;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (!(isSame(matrix,0,i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isSame(int[][] arr,int m ,int n){
        //判断由左上到右下的对角线上具有相同元素
        int target = arr[m][n];
        int i = 1;
        int j = 1;
        while (m+i < arr.length && n+j < arr[i].length) {
            if (arr[m+i][n+j] != target) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}

class Solution3 {
    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int num = 0;
        int i = 0;
        int j = 1;
        while (i+j < nums.length) {
            if (nums[i] == nums[i+j]) {
                num++;
                j++;
            }else {
                i += j;
                j = 1;
            }
        }

        int a = 0;
        int leng = num;
        int b = 0;
        while (a < leng) {
            if (nums[b] == nums[b+1]) {
                a++;
                deleteDate(nums, b+1);
            } else {
                b += 1;
            }
        }
        return nums.length - num;
    }
    private void deleteDate(int[] arr, int index) {
        int moveSize = arr.length - index - 1;
        System.arraycopy(arr, index+1, arr, index, moveSize);
    }
}