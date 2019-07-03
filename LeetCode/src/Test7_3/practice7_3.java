package Test7_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class practice7_3 {

    public static void main(String[] args) {

//        System.out.println(Solution.add(4));

//        Solution.solution();

        Solution1.solution();
    }

}

//数字之和
class Solution {
    /**
     * 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，
     * 并计算其平方的各位数字之和。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int value = in.nextInt();
            System.out.println(add(value) + " " + add((int)Math.pow(value,2)));
        }
        in.close();
    }
    public static int add(int value) {
        int sum = 0;
        while (value > 0) {
            int flag = value % 10;
            sum += flag;
            value /= 10;
        }
        return sum;
    }
}


//记票统计
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            ArrayList<String> list = new ArrayList<>(n);
            String[] name = new String[n];
            for (int i = 0; i < n; i++) {
                String value = in.next();
                if (!list.contains(value)) {
                    list.add(value);
                }
            }
            int m = in.nextInt();
            String[] vote = new String[m];
            for (int i = 0; i < m; i++) {
                vote[i] = in.next();
            }
            LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
            map.put("Invalid",0);
            for (int i = 0; i < vote.length; i++) {
                if (!map.containsKey(vote[i])) {
                    map.put(vote[i],1);
                } else {
                    int num = map.get(vote[i]) + 1;
                    map.put(vote[i],num);
                }
                if (list.contains(vote[i])) {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (list.contains(key)) {
                    System.out.println(key + ":" + map.get(key));
                }
            }
            System.out.println("Invalid : " + map.get("Invalid"));
        }
        in.close();
    }
}