package www.arivan.Test2_28;
import java.util.Scanner;

public class Test2_28 {
    public static void main(String[] args){
        int[][] arr = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        Solution solution = new Solution();
        int[][] arr1 = solution.flipAndInvertImage(arr);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

//        int[] arr = new int[]{3,1,2,4};
//        Solution1 solution1 = new Solution1();
//        int[] arr1 = solution1.sortArrayByParity(arr);
//        for(int i : arr1){
//            System.out.print(i+" ");
//        }
    }
}

class Solution {

//    给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//
//    水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//
//    反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
    public int[][] flipAndInvertImage(int[][] A) {

        //首先进行水平翻转
        for(int i = 0; i < A.length; i++){
            int j = 0;
            int length = A[i].length-1;
            while(j < length){
                int temp = A[i][j];
                A[i][j] = A[i][length];
                A[i][length] = temp;
                j++;
                length--;
            }
        }

        //然后进行反转图像
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[i].length; j++){
                switch(A[i][j]){
                    case 1:
                        A[i][j] = 0;
                        break;
                    case 0:
                        A[i][j] = 1;
                        break;
                    default:
                        break;
                }
                // if(A[i][j] == 0){
                //     A[i][j] = 1;
                // }else if(A[i][j] == 1){
                //     A[i][j] = 0;
                // }
            }
        }
        return A;
    }
}


class Solution1 {

//    给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
    public int[] sortArrayByParity(int[] A) {
        int[] arr = new int[A.length];
        int j = 0;
        int n = A.length-1;
        for(int i = 0; i < A.length; i++){
            if(A[i]%2 == 0){
                arr[j] = A[i];
                j++;
            }else{
                arr[n] = A[i];
                n--;
            }
        }
        return arr;
    }
}