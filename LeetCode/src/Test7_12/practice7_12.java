package Test7_12;

import java.util.Scanner;

public class practice7_12 {

    public static void main(String[] args) {

//        Solution.solution();

//        String s = "fsadsadsadaaadsaa";
//        System.out.println(s.replace('a','0'));

        Solution1.solution();

    }
}

//broke KeyBoard
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value1 = in.next();
            String value2 = in.next();
            value1 = value1.toUpperCase();
            value2 = value2.toUpperCase();
            for (int i = 0; i < value2.length(); i++) {
                if (value1.contains(String.valueOf(value2.charAt(i)))) {
                    value1 = value1.replace(value2.charAt(i), ',');
                }
            }
            String res = "";
            for (int i = 0; i < value1.length(); i++) {
                if (value1.charAt(i) != ',' && !res.contains(String.valueOf(value1.charAt(i)))) {
                    res += value1.charAt(i);
                }
            }
            System.out.println(res);
        }
        in.close();
    }
}

//球的半径和体积
class Solution1 {
    /**
     * 输入球的中心点和球上某一点的坐标，计算球的半径和体积
     */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            double distance = Math.sqrt(Math.pow(x - a, 2) + Math.pow(y - b, 2)
                    + Math.pow(z - c, 2));
            double bulk = Math.acos(-1) * Math.pow(distance,3) * 4 / 3;
            System.out.print(String.format("%.3f",distance));
            System.out.print(String.format(" "));
            System.out.print(String.format("%.3f",bulk));
        }
        in.close();
    }
}