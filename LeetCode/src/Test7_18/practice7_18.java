package Test7_18;

import java.util.Scanner;

public class practice7_18 {

    public static void main(String[] args) {

//        LCA lca = new LCA();
//        System.out.println(lca.getLCA(2,3));
//        System.out.println(lca.getLCA(3,4));
//        System.out.println(lca.getLCA(2,4));
//
//        Replacement replacement = new Replacement();
//        System.out.println(replacement.replaceSpace("Mr  John Smith",13));
//        System.out.println(replacement.replaceSpace("Hello  World",12));


        Printer printer = new Printer();
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},
                {9,10,11,12},{13,14,15,16}};
        int[] res = printer.arrayPrint(arr,4);
        for (int i : res) {
            System.out.print(i+" ");
        }
        System.out.println();

//        System.out.println("2562".substring(0,0));

        Solution.solution();
    }
}

//最近公共祖先
class LCA {
    public int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }
}

//空格替换
class Replacement {
    public String replaceSpace(String iniString, int length) {
        if (iniString == null || length < 1) {
            return "";
        }
        iniString = iniString.replace(" ","%20");
        return iniString;
    }
}

//二维数组打印
class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        if (n == 0) {
            return new int[]{};
        }
        int[] res = new int[n*n];
        int k = 0;
        for (int j = n - 1; j >= 0; j--) {
            int a = 0; //行
            int b = j; //列
            while (a <= n-1 && b >= 0 && a >= 0 && b <= n - 1) {
                res[k++] = arr[a++][b++];
            }
        }
        for (int i = 1; i < n; i++) {
            int a = i; //行
            int b = 0; //列
            while (a <= n-1 && b >= 0 && a >= 0 && b <= n - 1) {
                res[k++] = arr[a++][b++];
            }
        }
        return res;
    }
}

//回文串
class Solution {
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str == "") {
                System.out.println("YES");
            } else {
                if (plalindrome(str)) {
                    System.out.println("YES");
                } else {
                    boolean flag = true;
                    for (int i = 0; i < str.length(); i++) {
                        String value = str.substring(0,i) +
                                str.substring(i+1,str.length());
                        if (plalindrome(value)) {
                            System.out.println("YES");
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("NO");
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * 判断一个字符串是否为回文串
     * @return 是，返回true，反之返回false
     */
    private static boolean plalindrome(String string) {
        if (string == null) {
            return false;
        }
        if (string.length() == 1) {
            return true;
        }
        int l = 0;
        int r = string.length() - 1;
        while (l <= r) {
            if (string.charAt(l) != string.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}