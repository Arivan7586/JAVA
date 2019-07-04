package Test7_4;

import java.util.HashMap;
import java.util.Scanner;

public class practice7_4 {

    public static void main(String[] args) {

//        Solution.solution();

//        System.out.println(Solution1.changeToBin("193"));

//        System.out.println('5' - 48 + 3);

//        System.out.println(Solution1.ipChangeToNum("10.0.3.193"));
        System.out.println(Solution1.numChangeToIp(String.valueOf(Integer.MAX_VALUE)));

        Solution1.Solution();

        System.out.println(Integer.parseInt("1111111111111111111111111111111",2));
    }
}


//找X
class Solution {
    /**
     * 输入一个数n，然后输入n个数值，各不相同。在输入一个x。输出这个值在这个数组中的
     * 下标（从0开始，若不在数组中，则输出-1）
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
//            int[] arr = new int[n];
            int flag = 0;
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                map.put(value,flag++);
//                arr[i] = in.nextInt();
            }
            int value = in.nextInt();
            if (map.containsKey(value)) {
                System.out.println(map.get(value));
            } else {
                System.out.println(-1);
            }
//            System.out.println(find(arr,value));
        }
        in.close();
    }
    private static int find(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (value > arr[mid]){
                l = mid + 1;
            } else if (value < arr[mid]) {
                r = mid - 1;
            } else {
                res = mid;
                break;
            }
        }
        return res;
    }
}


class Solution1 {
    public static void Solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String ip = in.nextLine();
            System.out.println(ipChangeToNum(ip));
            String num = in.nextLine();
            System.out.println(numChangeToIp(num));
        }
        in.close();
    }

    /**
     * 将ip地址转换为数值
     * @param ip 给定ip地址
     * @return 返回数值
     */
    private static long ipChangeToNum(String ip) {
        if (ip != null && ip.length() > 0) {
            String[] arr = ip.trim().split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append(changeToBin(arr[0],8)).append(changeToBin(arr[1],8)).
                    append(changeToBin(arr[2],8)).append(changeToBin(arr[3],8));
            long sum = binToDecimal(sb.toString());
            return sum;
        }
        return -1;
    }

    /**
     * 将给定十进制数值转换为ip地址
     * @param num 给定十进制数值
     * @return 返回ip地址
     */
    public static String numChangeToIp(String num) {
        String bin = changeToBin(num,32);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bin.length(); i += 8) {
            sb.append(binToDecimal(bin.substring(i,i+8)));
            if (i < 24) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    /**
     * 将给定十进制数值转换为二进制字符串
     * @param value 给定十进制数值
     * @return 返回转换后的二进制字符串
     */
    private static String changeToBin(String value,int length) {
        long num = Long.parseLong(value);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        while (sb.length() < length) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }

    /**
     * 将二进制字符串转换为十进制数值
     * @param bin 给定二进制字符串
     * @return 返回十进制数值
     */
    private static long binToDecimal(String bin) {
        long sum = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            int value = bin.charAt(i) - 48;
            sum += value * Math.pow(2,bin.length()-1-i);
        }
        return sum;
    }
}