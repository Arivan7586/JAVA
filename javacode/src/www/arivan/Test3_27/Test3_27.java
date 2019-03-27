package www.arivan.Test3_27;

public class Test3_27 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
//        System.out.println(solution.maxDistToClosest(new int[]{1,1,0,0,1,0,0}));
//        System.out.println(solution.maxDistToClosest(new int[]{0,0,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0}));

        int[][] arr = new int[][]{{0,0,0,1,2,3},{3,3,3,4,4,4},
                                {5,6,7,8,9,10},{11,12,13,14,15,16},
                                {17,18,19,20,21,22},{23,24,25,26,27,28}};
        int[][] arr2 = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        Solution1 solution1 = new Solution1();

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.Find(15,arr2));
//        System.out.println(Solution2.binaryFind(6,arr2,3));


    }
    //二分查找

}

class Solution {
//    在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
//
//    至少有一个空座位，且至少有一人坐在座位上。
//
//    亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//
//    返回他到离他最近的人的最大距离
    public int maxDistToClosest(int[] seats) {
        int flag = 0;
        int start = -1;
        int end = -1;
        int Max = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                if(start < 0){
                    Max = end - start;
                    start = end = i;
                }else{
                    Max = Math.max(Max,(end-start+1)/2);
                    start = end = i;
                }
            }else{
                end++;
            }
        }
        if(start < seats.length-1){
            Max = Math.max(Max,(seats.length-1-start));
        }
        return Max;
    }
}

class Solution1 {
    public boolean Find(int target, int [][] array) {
        //先找到target所在的行
        int low = 0;
        int high = array.length - 1;
        int row = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid][0] > target) {
                high = mid - 1;
            }else if (array[mid][array[0].length-1] < target){
                low = mid + 1;
            }else {
                row = mid;
                break;
            }
        }
        low = 0;
        high = array[row].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[row][mid] > target) {
                high = mid - 1;
            }else if (array[row][mid] < target) {
                low = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}

class Solution2 {
    public boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int l = 0;
            int r = array[i].length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (array[i][mid] > target) {
                    r = mid - 1;
                }else if (array[i][mid] < target) {
                    l = mid + 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}