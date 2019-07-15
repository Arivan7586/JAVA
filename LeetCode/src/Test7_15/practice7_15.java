package Test7_15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class practice7_15 {

    public static void main(String[] args) {

//        Solution.solution();

        Solution1.solution();
    }
}

//木棒拼图
class Solution {
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] op = new int[n][2];
            for (int i = 0; i < n; i++) {
                op[i][0] = scanner.nextInt();
                op[i][1] = scanner.nextInt();
            }
            stickPuzzle(n, op);
        }
    }

    public static void stickPuzzle(int n, int[][] op) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (op[i][0] == 1) {
                list.add(op[i][1]);
            } else {
                list.remove(new Integer(op[i][1]));
            }
            if (canFormPoly(list)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean canFormPoly(ArrayList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i++) {
            int temp = list.remove(i);
            int sum = 0;
            for (int j = 0; j < len - 1; j++) {
                sum += list.get(j);
            }
            if (sum <= temp) { //判断是否任意len-1条边之和大于剩余一条边
                list.add(i, temp);
                return false;
            }
            list.add(i, temp);
        }
        return true;
    }
}

//地下迷宫
class Solution1 {
    private static int n, m, maxRemainEnergy = 0;
    private static int[][] map;
    private static boolean flag = false;
    private static String path = "";
    private static LinkedList<String> linkedlist = new LinkedList<>();

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int P = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        runMap(0, 0, P);
        if (!flag) {
            System.out.println("Can not escape!");
        }
        else {
            System.out.println(path);
        }
    }

    private static synchronized void runMap(int x, int y, int energy) {
        if (energy < 0 || x<0 || y<0 || x>=n || y>= m || map[x][y] != 1) {
            return;
        } else {
            linkedlist.offer("[" + x + "," + y + "]");
            map[x][y] = 0;
            if (x == 0 && y == m - 1) {
                if (energy >= maxRemainEnergy) {
                    maxRemainEnergy = energy;
                    updatePath();
                }
                map[x][y] = 1; linkedlist.removeLast();
                flag = true; return;
            }
            runMap(x, y+1, energy-1);
            runMap(x+1, y, energy);
            runMap(x-1, y, energy-3);
            runMap(x, y-1, energy-1);
            map[x][y] = 1;linkedlist.removeLast();
        }
    }

    private static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = linkedlist.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next() + ",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        path = sb.toString();
    }
}