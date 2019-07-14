package Test7_14;

import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class practice7_14 {

    public static void main(String[] args) {

//        System.out.println((int)'Z');
//        Solution.solution();

//        System.out.println('5' - '0');

        Solution1.soliton();
        System.out.println(Solution1.add("123456",123));
        System.out.println(Solution1.add("123456",123456));

    }
}

//字母统计
class Solution {
    /**
     * 输入一行字符串，计算其中A-Z大写字母出现的次数
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.next();
            LinkedHashMap<String,Integer> map = new LinkedHashMap();
            for (int i = 65; i <= 90; i++) {
                map.put(String.valueOf((char)i),0);
            }
            for (int i = 0; i < input.length(); i++) {
                String key = String.valueOf(input.charAt(i));
                if (map.containsKey(key)) {
                    int value = map.get(key);
                    map.put(key,value+1);
                }
            }
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
        }
        in.close();
    }
}


class Solution1 {
    public static void soliton() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String input = in.nextLine();
            if (input == null) {
                break;
            }
            String[] arr = input.trim().split(" ");
            for (String s : arr) {
                change(s);
            }
        }
        in.close();
    }
    private static void change(String str) {
        String res = "0";
        int i = str.length() - 1;
        int k = 0;
        while (i >= 0) {
            char value = str.charAt(i);
            if (value == 'x') {
                break;
            }
            int num = 0;
            switch (value) {
                case 'A':
                    num = 10;
                    break;
                case 'B':
                    num = 11;
                    break;
                case 'C':
                    num = 12;
                    break;
                case 'D':
                    num = 13;
                    break;
                case 'E':
                    num = 14;
                    break;
                case 'F':
                    num = 15;
                    break;
                default:
                    num = value - '0';
                    break;
            }
            res = add(res, (int) (num * Math.pow(16,k++))) ;
            i--;
        }
        System.out.println(res);
    }
    public static String add(String value1, int value2) {
        if (value1 == null || value1.equals("0")) {
            return String.valueOf(value2);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(value2));
        StringBuilder res = new StringBuilder();
        value1 = new StringBuilder(value1).reverse().toString();
        sb.reverse();
        int i = 0;
        int flag = 0;
        while (i < value1.length() || i < sb.length()) {
            int num1 = 0;
            int num2 = 0;
            if (i < value1.length()) {
                num1 = value1.charAt(i) - '0';
            }
            if (i < sb.length()) {
                num2 = sb.charAt(i) - '0';
            }
            int sum = num1 + num2 + flag;
            flag = sum >= 10 ? 1 : 0;
            res.append(sum%10);
            i++;
        }
        return res.reverse().toString();
    }
}