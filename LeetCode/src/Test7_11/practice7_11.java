package Test7_11;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class practice7_11 {

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.println(in.nextLine());

//        Solution.solution();

//        System.out.println((int)'A');
//        System.out.println((char)(65));

        GoUpstairs goUpstairs = new GoUpstairs();
        System.out.println(goUpstairs.countWays(5));

    }
}

//锤子剪刀布
class Solution {
    /**
     * 现给出两人的交锋记录，请统计双方的胜、平、负次数，
     * 并且给出双方分别出什么手势的胜算最大。
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr1 = new String[n];
            String[] arr2 = new String[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = in.next();
                arr2[i] = in.next();
            }
            LinkedList<String> list1 = new LinkedList<>();
            LinkedList<String> list2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (arr1[i].equals("C")) {
                    if (arr2[i].equals("J")) {
                        list1.add(arr1[i]);
                    } else if (arr2[i].equals("B")) {
                        list2.add(arr2[i]);
                    }
                } else if (arr1[i].equals("B")) {
                    if (arr2[i].equals("C")) {
                        list1.add(arr1[i]);
                    } else if (arr2[i].equals("J")) {
                        list2.add(arr2[i]);
                    }
                } else {
                    if (arr2[i].equals("B")) {
                        list1.add(arr1[i]);
                    } else if (arr2[i].equals("C")) {
                        list2.add(arr2[i]);
                    }
                }
            }
            System.out.println(list1.size() + " " + (arr1.length - list1.size() -
                    list2.size()) + " " + list2.size());
            System.out.println(list2.size() + " " + (arr1.length - list1.size() -
                    list2.size()) + " " + list1.size());
            int[] value1 = new int[75];
            int[] value2 = new int[75];
            for (int i = 0; i < list1.size(); i++) {
                int num = list1.get(i).charAt(0);
                value1[num]++;
            }
            for (int i = 0; i < list2.size(); i++) {
                int num = list2.get(i).charAt(0);
                value2[num]++;
            }
            int max = 0;
            int flag = 66;
            for (int i = 65; i < value1.length; i++) {
                if (value1[i] > max) {
                    max = value1[i];
                    flag = i;
                }
            }
            System.out.print((char) flag + " ");
            flag = 66;
            for (int i = 65; i < value2.length; i++) {
                if (value2[i] > max) {
                    max = value2[i];
                    flag = i;
                }
            }
            System.out.print((char) flag);
        }
        in.close();
    }
}

//上楼梯
class GoUpstairs {
    /**
     * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，
     * 计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
     *
     * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
     * @param n 给定正整数n
     * @return
     */
    public int countWays(int n) {
        if (n <= 0) {
            return 0;
        }
        int a = 1;
        int b = 2;
        int c = 4;
        if (n == 1) {
            return a;
        } else if (n == 2) {
            return b;
        } else if (n == 3) {
            return c;
        }
        for (int i = 4; i <= n; i++) {
            int value = c;
            c = ((a + b) % 1000000007 + c) % 1000000007;
            a = b;
            b = value;
        }
        return c;
    }
}