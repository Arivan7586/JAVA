package Test5_10;

import java.util.*;

public class practice5_10 {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] arr2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] arr3 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] arr4 = new String[]{"KFC","Burger King","Tapioca Express","Shogun"};
        Solution solution = new Solution();
        String[] res = solution.findRestaurant1(arr3,arr4);
        for (String s : res) {
            System.out.println(s);
        }

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.convertToBase7(100));
        System.out.println(solution1.convertToBase7(-7));

        System.out.println("----------------------");
        Solution2 solution2 = new Solution2();
        String[] str = new String[]{"a1 9 2 3 1","g1 act car",
                "zo4 4 7","ab1 off key dog","a8 act zoo"};
        String[] arr = solution2.reorderLogFiles(str);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}

class Solution {
    /**
     * 两个列表的最小索引总和
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示
     * 最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     *
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。
     * 如果答案不止一个，则输出所有答案并且不考虑顺序。
     * 你可以假设总是存在一个答案。
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        LinkedList list = new LinkedList();
        int min = 0;
        int flag = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if ((i+j) < min && flag != 0) {
                        min = i + j;
                    } else if (flag == 0) {
                        min = i + j;
                        flag++;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if ((i+j == min) && list1[i].equals(list2[j])) {
                    list.add(list1[i]);
                    break;
                }
            }
        }
        return (String[]) list.toArray(new String[]{});
    }

    public String[] findRestaurant1(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                    min = sum;
                    list.clear();
                    list.add(list2[i]);
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[]{});
    }
}

class Solution1 {
    /**
     * 七进制数
     * 给定一个整数，将其转化为7进制，并以字符串形式输出。
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            int value = num % 7;
            stringBuilder.append(value);
            num /= 7;
        }
        if (flag) {
            stringBuilder.append("-");
        }
        stringBuilder.reverse();
        return String.valueOf(stringBuilder);
    }
}

class Solution2 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String[] strs1 = s1.split(" ");
                String[] strs2 = s2.split(" ");
                //忽略第一位
                for(int i = 1; i < strs1.length && i < strs2.length; i++){
                    //都是数字，相等
                    if( (strs1[i].charAt(0) >= '0' && strs1[i].charAt(0) <= '9') && (strs2[i].charAt(0) >= '0' && strs2[i].charAt(0) <= '9') ){
                        return 0;
                    }
                    //2是字母 1是数字 2<1
                    else if( (strs1[i].charAt(0) >= '0' && strs1[i].charAt(0) <= '9') && (strs2[i].charAt(0) >= 'a' && strs2[i].charAt(0) <= 'z')){
                        return 1;
                    }
                    //2是数字 1是字母 2>1
                    else if( (strs2[i].charAt(0) >= '0' && strs2[i].charAt(0) <= '9') && (strs1[i].charAt(0) >= 'a' && strs1[i].charAt(0) <= 'z') ){
                        return -1;
                    }
                    //都是字母
                    else{
                        int res = strs1[i].compareTo(strs2[i]);
                        if(res == 0){
                            continue;
                        }
                        //1 < 2
                        else if(res < 0){
                            return -1;
                        }
                        else{
                            return 1;
                        }
                    }
                }
                if(strs1.length == strs2.length){
                    //当相等的时候，查看标识符

                    return strs1[0].compareTo(strs2[0]);
                }
                else if(strs1.length < strs2.length){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        return logs;
    }
}