package Test5_13;

import java.util.*;

public class practice5_13 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(solution.search(new int[]{-1,0,3,5,9,12},2));


        Solution1 solution1 = new Solution1();
        String[] arr = solution1.findRelativeRanks(new int[]{5,4,3,2,1});
        String[] arr1 = solution1.findRelativeRanks(new int[]{10,3,8,9,4});
        for (String s : arr1) {
            System.out.print(s+",");
        }
        System.out.println();

        System.out.println("---------------------");
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findContentChildren(new int[]{1,2,3}
        ,new int[]{1,1}));
        System.out.println(solution2.findContentChildren(new int[]{1,2}
                ,new int[]{1,2,3}));
        System.out.println(solution2.findContentChildren1(new int[]{1,2,3}
                ,new int[]{3}));
    }
}

class Solution {
    /**
     * 二分查找
     *
     * @param nums   查找的数组
     * @param target 查找目标
     * @return 返回目标的下标。如果不存在，返回-1
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

class Solution1 {
    /**
     * 相对名次
     * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
     * 前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”
     * （"Gold Medal", "Silver Medal", "Bronze Medal"）。
     *
     * (注：分数越高的选手，排名越靠前。)
     * @param nums N名运动员的乘积
     * @return 返回符合要求的数组
     */
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new String[]{};
        }
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],"");
        }
        int flag = 1;
        int size = map.size();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (flag == size - 2) {
                map.put(key,"Bronze Medal");
            } else if (flag == size - 1) {
                map.put(key,"Silver Medal");
            } else if (flag == size) {
                map.put(key,"Gold Medal");
            } else {
                map.put(key,String.valueOf(size- flag + 1));
            }
            flag++;
        }
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = map.get(nums[i]);
        }
        return arr;
    }
}

class Solution2 {
    /**
     * 分发饼干
     *
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，
     * 每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
     * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，
     * 都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j
     * 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，
     * 并输出这个最大数值。
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (g[i] <= list.get(j)) {
                    count++;
                    list.remove(j);
                    j--;
                    break;
                }
            }
        }
        return count;
    }

    public int findContentChildren1(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        int childs = 0;
        int cookies = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (childs < g.length && cookies < s.length) {
            if (g[childs] <= s[cookies]) {
                childs++;
            }
            cookies++;
        }
        return childs;
    }
}
