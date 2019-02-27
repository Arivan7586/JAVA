package www.arivan.Test2_27;
import java.util.Scanner;

public class Test2_27 {
    public static void main(String[] args){
        int[] arr = new int[]{5,3,4,7,0,1,9,6,8,2};
        //Sorting.maoPaoSort(arr);
        //Sorting.chooseSort(arr);
        //Sorting.insertionSort(arr);
        Sorting.shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

//排序算法练习
class Sorting {
    //通过相邻的两个数的比较, 根据需要决定是否将两个数互换位置, 然后将比较往前(或往后)推进.
    public static void maoPaoSort(int[] arr){ //冒泡排序
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //选择排序"就是第0个逐步和后面全部的比,比完0位置就得到最小的数,
    // 紧接着再从1位置对比后面的元素,以此类推,逐步得到从小到大的值.
    public static void chooseSort(int[] arr){  //选择排序
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

//    首先对数组的前两个数据进行从小到大的排序。
//    接着将第三个数据与排好序的两个数据比较，将第三个数据插入合适的位置。
//    然后将第四个数据插入到已排好序的前3个数据中。
    public static void insertionSort(int[] arr){ //插入排序
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i]; //保存数据
            while (j > 0 && target < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
                count++;
            }
            arr[j] = target;
        }
        System.out.println(count);
    }

//    Shell排序是基于插入排序的思想。
//            1.将有n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对，...
//            2.一次循环使每一个序列对排好顺序。
//            3.然后，变为n/4个序列，在次排序。
//            4.直到序列变为1个
    public static void shellSort(int[] arr){ //shell排序
        for(int r = arr.length/2; r >= 1; r/=2){

            for(int i = r; i < arr.length; i++){

                int temp = arr[i];
                int j = i - r;

                while(j >= 0 && temp < arr[j]){
                    arr[j+r] = arr[j];
                    j -= r;
                }

                arr[j+r] = temp;
            }
        }
    }
}