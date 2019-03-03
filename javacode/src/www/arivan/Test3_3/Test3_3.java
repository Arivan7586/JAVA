package www.arivan.Test3_3;
import java.util.Arrays;

public class Test3_3 {
    public static void main(String[] args) {
//        int[] arr = new int[]{0,1,0,3,12};
//        Solution solution = new Solution();
//        solution.moveZeroes(arr);
//        for (int i : arr) {
//            System.out.print(i+" ");
//        }

        int[] arr = new int[]{1,1,0,1,1,1};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.findMaxConsecutiveOnes(arr));
    }
}

class Solution {
    //    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }
        int i = 0;
        while (count > 0) {
            if (nums[i] == 0) {
                moveData(nums,i);
                count--;
            }else {
                i++;
            }
        }
    }

    private void moveData(int[] arr, int index) {
        int oldData = arr[index];
        int moveSize = arr.length - index -1;
        if (moveSize > 0) {
            System.arraycopy(arr,index+1,arr,index,moveSize);
        }
        arr[arr.length-1] = oldData;
    }
}

class Solution1 {
    //给定一个二进制数组， 计算其中最大连续1的个数 例如{1,1,0,1,1,1}

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int nowMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nowMax++;
            }else {
                // max = max > nowMax ? max : nowMax;
                if (max < nowMax) {
                    max = nowMax;
                }
                nowMax = 0;
            }
        }
        return max > nowMax ? max : nowMax;
    }
}