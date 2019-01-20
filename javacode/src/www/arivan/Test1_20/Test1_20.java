package www.arivan.Test1_20;
import java.util.Scanner;

public class Test1_20 {
    public static void main(String[] args){
        //Array.getMath();
        RabbitAndTortoiseRun.run();
    }
}

//回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，
//        则左转90度。一开始位于矩阵左上角，方向向下。
class Array {
    public static void getMath(){
        //int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if(m > 0 && m <= 200){
            int n = scanner.nextInt();
            if(n > 0 && n <= 200){
                int[][] a = new int[m][n];
                int[][] arr = intTwoArray(a);
                int tot = 0, x = -1, y = 0;
                while (tot < m * n) {
                    while (x + 1 < m && arr[x + 1][y] != -1) {
                        System.out.print(arr[++x][y]+" ");
                        arr[x][y] = -1;
                        ++tot;
                    }
                    while (y + 1 < n && arr[x][y + 1] != -1) {
                        System.out.print(arr[x][++y]+" ");
                        arr[x][y] = -1;
                        ++tot;
                    }
                    while (x - 1 >= 0 && arr[x - 1][y] != -1) {
                        System.out.print(arr[--x][y]+" ");
                        arr[x][y] = -1;
                        ++tot;
                    }

                    while (y - 1 >= 0 && arr[x][y - 1] != -1) {
                        System.out.print(arr[x][--y]+" ");
                        arr[x][y] = -1;
                        ++tot;
                    }
                }
            }else {
                System.out.println("输入错误！正确范围是(0-200)");
            }
        }else {
            System.out.println("输入错误！正确范围是(0-200)");
        }

    }

    public static int[][] intTwoArray(int[][] arr){ //初始化矩阵
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    public static int zeroTimes(int[][] arr, int n){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == n){
                    count++;
                }
            }
        }
        return count;
    }

    public static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
    }
}


//兔子的速度v1（表示每秒兔子能跑v1米），乌龟的速度v2，以及兔子对应的t，s值，
//        以及赛道的长度l——就能预测出比赛的结果。
//        在与乌龟的比赛中，一旦任一秒结束后兔子发现自己领先t米或以上，它们就会停下来休息s秒。
class RabbitAndTortoiseRun { //龟兔赛跑问题
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        int t = scanner.nextInt();
        int s = scanner.nextInt();
        int l = scanner.nextInt();

        int t1 = 0; //t1表示比赛所用时间
        int s1 = 0; //表示兔子已经跑的距离
        int s2 = 0; //表示乌龟已经跑的距离
        while(s1 < l && s2 < l){
            if (s1 - s2 >= t){
                s2 = s2 + v2 * s;
                t1 += s;
            }else {
                s1 = s1 + v1;
                s2 = s2 + v2;
                t1++;
            }
        }
        if(s1 > s2){
            System.out.println("兔子会赢！");
        }else if (s2 > s1){
            System.out.println("乌龟会赢！");
        }else {
            System.out.println("同时到达终点！");
        }
        System.out.println("用时:"+t1+"秒");
    }
}