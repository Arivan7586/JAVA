package Test7_2;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class practice7_2 {

    public static void main(String[] args) {

//        Solution.solution();
//        Scanner scanner = new Scanner(System.in);
//        double value = scanner.nextDouble();

//        String val = "15132.651";
//        String[] arr = val.split("\\.");
//        System.out.println(arr[0]);


//        System.out.println(Solution1.change(532));
//        System.out.println(Solution1.change(9999));
//        System.out.println(Solution1.change(9001));
//        System.out.println(Solution1.change(9101));
//        System.out.println(Solution1.change(9010));
//        System.out.println(Solution1.change(0));

//        System.out.println(Solution1.change(1315));
//        System.out.println(Solution1.change(1001));
//        System.out.println(Solution1.change(1010));
//        System.out.println(Solution1.change(1100));
//        System.out.println(Solution1.change(1110));
//        System.out.println(Solution1.change(1199));
//        System.out.println(Solution1.change(1));

        Solution1.solution();

    }

}


//学分绩点
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        double sum1 = 0.0;
        double sum2 = 0.0;
        for (int i = 0; i < n; i++) {
            double value1 = 0;
            if (arr2[i] >= 90 && arr2[i] <= 100) {
                value1 = 4.0;
            } else if (arr2[i] >= 85 && arr2[i] <= 89) {
                value1 = 3.7;
            } else if (arr2[i] >= 82 && arr2[i] <= 84) {
                value1 = 3.3;
            } else if (arr2[i] >= 78 && arr2[i] <= 81) {
                value1 = 3.0;
            } else if (arr2[i] >= 75 && arr2[i] <= 77) {
                value1 = 2.7;
            } else if (arr2[i] >= 72 && arr2[i] <= 74) {
                value1 = 2.3;
            } else if (arr2[i] >= 68 && arr2[i] <= 71) {
                value1 = 2.0;
            } else if (arr2[i] >= 64 && arr2[i] <= 67) {
                value1 = 1.5;
            } else if (arr2[i] >= 60 && arr2[i] <= 63) {
                value1 = 1.0;
            } else {
                value1 = 0.0;
            }
            sum1 += value1 * arr1[i];
            sum2 += arr1[i];
        }
        System.out.println(String.format("%.2f",sum1/sum2));
    }
}


//人民币转换
class Solution1 {
    private static String[] Money = new String[]{"零","壹","贰","叁","肆","伍",
    "陆","柒","捌","玖"};
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double money = in.nextDouble();
            StringBuilder sb = new StringBuilder();
            int yi = (int)(money / 100000000);
            int wan = (int)(money / 10000) % 10000;
            int ge = (int)(money % 10000);
            if (yi != 0) {
                sb.append(change(yi) + "亿");
            }
            if (wan != 0) {
                sb.append(change(wan) + "万");
            }
            if (ge != 0) {
                sb.append(change(ge) + "元");
            }

            int decimal = (int) ((money - (int)(money/1) + 0.001) * 100);
            int jiao = decimal / 10;
            int fen = decimal % 10;
            if (jiao != 0 && fen != 0) {
                sb.append(Money[jiao] + "角" + Money[fen] + "分");
            } else if (jiao == 0 && fen != 0) {
                sb.append("零" + Money[fen] + "分");
            } else if (jiao != 0 && fen == 0) {
                sb.append(Money[jiao] + "角");
            } else if (jiao == 0 && fen == 0) {
                sb.append("整");
            }
            System.out.println("人民币" + sb);
        }
    }

    /**
     * 将小于10000的金额转换为字符串
     * @param money 金额
     * @return
     */
    public static String change(int money) {
        int tho = money / 1000;
        int hun = (money % 1000) / 100;
        int ten = (money % 100) / 10;
        int uni = money % 10;
        StringBuilder sb = new StringBuilder();
        if (tho != 0) {
            sb.append(Money[tho] + "仟");
        }
        if (hun != 0) {
            sb.append(Money[hun] + "佰");
        } else if (tho != 0 && hun == 0 && (ten != 0 || uni != 0)) {
            sb.append("零");
        }
        if (ten != 0 ) {
            sb.append(Money[ten] + "拾");
        } else if (hun != 0 && uni != 0) {
            sb.append("零");
        }else if (ten == 1 && tho == 0 && hun == 0) {
            sb.append("拾");
        }
        if (uni != 0) {
            sb.append(Money[uni]);
        }
        return sb.toString();
    }
}