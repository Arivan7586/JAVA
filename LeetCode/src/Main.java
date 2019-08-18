//自从零食间开始免费供应上好的咖啡豆，小杰每天午休后都会来到零食间，按下咖啡机的按钮，等待着杯里弥漫开来的香气把自己淹没，纷乱的思绪也渐渐在水雾中模糊。"小杰，你还有N个bug没修，别摸鱼了，快来解bug！"，一个不合时宜的声音往往会在此时响起，小杰的脑海中瞬间闪过了无数个文件，无数行代码随着咖啡的香气不断滚动。
//
//        "我是不可能写bug的，这辈子都不可能写bug的...", 小杰一边念叨着，一边开始在脑海里盘算起来。
//
//        假设每喝一杯咖啡（喝咖啡的时间忽略不计），就能让自己一小时内的debug效率提升到原来的A倍，一小时内重复喝没用，最多只能喝X杯，太多了晚上会睡不着，并且为了保证可持续发展，每天最多只能专注工作8个小时，而在没喝咖啡的状态下解决每个bug所需要的时间为 t1,t2...tN 分钟。
//
//        小杰的咖啡还没有喝完，你能帮他计算出他今天能解完所有bug吗？如果能，最少需要多长时间？

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int A = in.nextInt();
            int X = in.nextInt();
            int[] arr = new int[N];
            double sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
                sum += arr[i];
            }
            int maxTime = 60 * A * X;
            double minTime = 0;
            if (sum <= maxTime) {
                minTime = Math.ceil(sum/A);

            } else {
                minTime += 60 * X;
                sum -= maxTime;
                minTime += sum;
            }
            if (minTime > 60*8) {
                System.out.println(0);
            } else {
                System.out.println((int) minTime);
            }
        }
        in.close();
    }
}
*/

//在零食间里有一个零食柜，里面会半价供应很多好吃的零食，柜子被隔成了一个个小格子，类似一个矩阵，每个格子里会放置由前台小姐姐们精心挑选的零食，并且标上相应的价格。
//
//        小A是一个大吃货，每天他都要光顾一次零食间，但是他又要减肥，于是他便对自己做了一个约束，每次只能从里面拿走总价格少于V的零食。这时候问题来了，对于每种零食，小A都有一个内心的满意度，小A希望每次都能吃上让自己最满意的零食。
//
//        假设零食柜里每个格只放置一种零食，每种零食的数量是有限的，买完就没有了，零食只能按照整数倍购买，不能只买半件。问小A在有限价格内买到的零食的总满意度最高是多少？

//public class Main {
//    static class God implements Comparable{
//        int price;
//        double satisfied;
//        int num;
//        double value;
//        public God(int price, double satisfied , int num) {
//            this.price = price;
//            this.satisfied = satisfied;
//            this.num = num;
//            if (price != 0) {
//                this.value = satisfied / price;
//            }
//        }
//
//        @Override
//        public int compareTo(Object o) {
//            God god = (God)o;
//            if (this.value > god.value) {
//                return 1;
//            } else if (this.value < god.value) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int N = in.nextInt();
//            int T = in.nextInt();
//            ArrayList<God> list = new ArrayList<>();
//            int allNum = 0;
//            int minPrice = Integer.MAX_VALUE;
//            for (int i = 0; i < N; i++) {
//                int price = in.nextInt();
//                int satisfied = in.nextInt();
//                int num = in.nextInt();
//                allNum += num;
//                minPrice = price < minPrice ? price : minPrice;
//                if (satisfied > 0) {
//                    list.add(new God(price,satisfied,num));
//                }
//            }
//            Collections.sort(list);
//            if (minPrice > T || allNum <= 0) {
//                System.out.println(0);
//            } else {
//                int res = 0;
//                for (int i = list.size() - 1; i >= 0; i--) {
//                    God god = list.get(i);
//                    int n = god.num;
//                    boolean flag = false;
//                    for (int j = 1; j <= n; j++) {
//                        if (god.price <= T) {
//                            res += god.satisfied;
//                            T -= god.price;
//                        } else {
//                            break;
//                        }
//                        if (T == 0) {
//                            flag = true;
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        break;
//                    }
//                }
//                System.out.println(res);
//            }
//        }
//        in.close();
//    }
//}

/*
最近DJI发布了一款Robomaster S1机器人，小伙伴们都沉迷其中不能自拔。小J为了能够在竞速比赛中迅速获胜，他决定利用开发的优势，在里面植入一套最优化的寻路算法。

小伙伴们为了提高难度，决定调整规则如下: 在比赛场地内预先设置N个路标，路标编号从0到N-1，S1只能沿直线在两个路标之间移动，且规定部分路标点之间是不能进行移动的。

比赛场地内的S1机器人从编号为0的路标出发，然后裁判给出随机一个路标，要求S1机器人以尽可能快的速度达到路标位置，每轮比赛都会从头开始，最终总时间最短者获胜。

其中会确保每两个路标之间肯定存在至少一条路径是可以到达的。

小J在比赛开始前就已经得知了所有路标的具体位置，和相互之间的距离和移动需要的时间。但是他需要编写一个程序，以确保能够随时响应裁判的命令。你能比小J更快吗
 */

//public class Main {
//    static class Way {
//        int start;
//        int end;
//        int times;
//
//        public Way(int start, int end, int times) {
//            this.start = start;
//            this.end = end;
//            this.times = times;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int N = in.nextInt();
//            int P = in.nextInt();
//            int C = in.nextInt();
//            ArrayList<Way> list = new ArrayList<>();
//            for (int i = 0; i < P; i++) {
//                int A = in.nextInt();
//                int B = in.nextInt();
//                int T = in.nextInt();
//                list.add(new Way(A,B,T));
//            }
//            int[] arr = new int[C];
//            for (int i = 0; i < C; i++) {
//                arr[i] = in.nextInt();
//            }
//        }
//        in.close();
//    }
//}


public class Main {
    public static void main(String[] args) {

        Test test = (Test)null;
        test.run();
        
    }
}

class Test {
    public void run() {
        System.out.println("hello");
    }
}

