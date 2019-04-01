package www.exercises.Test4_1;

import java.util.Arrays;

public class Test4_1 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr1 = new int[]{61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,
//                31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,
//                98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
//        int[] arr2 = new int[]{5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
//        System.out.println(solution.ensureNumber(arr2,8));
//        int[] arr = solution.intersection(arr1,arr2);
//        int[] arr3 = solution.intersection(new int[]{1}, new int[]{1});
//        for (int i : arr3) {
//            System.out.print(i+" ");
//        }
//        System.out.println();

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(solution1.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m < 1 || n < 1) {
            return new int[]{};
        }else if (m < 1 && n < 1) {
            return nums1;
        }
        int num = m<n?m:n;
        int[] arr = new int[num];
        int k = 0;
        int count = 0; //交集元素的个数
        Arrays.sort(nums1);
        if (ensureNumber(nums2,nums1[0])) {
            arr[k++] = nums1[0];
            count++;
        }
        for (int i = 1; i < m; i++) {
            if (nums1[i] != nums1[i-1] && ensureNumber(nums2,nums1[i])) {
                arr[k++] = nums1[i];
                count++;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * 检查给定数组中是否有指定数值
     * @param arr 给定数组
     * @param value 给定数值
     * @return 如果存在，返回true，否则返回false
     */
    public boolean ensureNumber(int[] arr, int value) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] > value) {
                r = mid - 1;
            }else if (arr[mid] < value) {
                l = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}

class Solution1 {
//    你现在是棒球比赛记录员。
//    给定一个字符串列表，每个字符串可以是以下四种类型之一：
//            1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
//            2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
//            3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
//            4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
//
//    每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
//    你需要返回你在所有回合中得分的总和。
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int i = 0;
        for(String k : ops){
            switch (k){
                case "+":
                    arr[i] = arr[i-1] + arr[i-2];
                    i++;
                    break;
                case "D":
                    arr[i] = 2*arr[i-1];
                    i++;
                    break;
                case "C":
                    arr[i-1] = 0;
                    i--;
                    break;
                default:
                    arr[i]=Integer.parseInt(k);
                    i++;
            }
        }
        int sum=0;
        for (int j = 0; j <arr.length; j++) {
            sum+=arr[j];
        }
        return sum;
    }
}