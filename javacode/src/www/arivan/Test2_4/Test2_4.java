package www.arivan.Test2_4;
import java.util.Scanner;

public class Test2_4 {
    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        if(n <= 0 || w == 0) {
            System.out.println("0.0");
            return;
        }
        Main.good[] A = new Main.good[n];
        for(int i = 0;i < n;i++) {
            int g = in.nextInt();
            int p = in.nextInt();
            double v = p * 1.0 / g;
            A[i] = new Main.good(g, v);
        }
        test.printResult(w, A);

    }
}



class Main {

//    现在知道了汽车核载重量为w，可供选择的物品的数量n。每个物品的重量为gi,价值为pi。
//    求汽车可装载的最大价值。（n<10000,w<10000,0<gi<=100,0<=pi<=100)
    static class good {
        public int weight;  //重量
        public double value;  //单价

        good(int weight, double value) {
            this.weight = weight;
            this.value = value;
        }
    }
    //使用合并排序，按照物品的单价value，对A进行从大到小排序
    public void mergeSort(good[] A) {
        if(A.length > 1) {
            good[] leftA = getHalfArray(A, 0);   //获取A的左半部分对象
            good[] rightA = getHalfArray(A, 1);  //获取A的右半部分对象
            mergeSort(leftA);
            mergeSort(rightA);
            getMerge(A, leftA, rightA);
        }
    }
    //根据judge判断，获取A的一半对象
    public good[] getHalfArray(good[] A, int judge) {
        good[] half;
        int len = A.length;
        if(judge == 0) {
            half = new good[len / 2];
            for(int i = 0;i < len / 2;i++)
                half[i] = A[i];
        } else {
            half = new good[len - len / 2];
            for(int i = 0;i < len - len / 2;i++)
                half[i] = A[len / 2 + i];
        }
        return half;
    }
    //对A进行合并，获取从大到小排序
    public void getMerge(good[] A, good[] leftA, good[] rightA) {
        int i = 0, j = 0, count = 0;
        int lenLeftA = leftA.length, lenRightA = rightA.length;
        while(i < lenLeftA && j < lenRightA) {
            if(leftA[i].value >= rightA[j].value)
                A[count++] = leftA[i++];
            else
                A[count++] = rightA[j++];
        }
        while(i < lenLeftA)
            A[count++] = leftA[i++];
        while(j < lenRightA)
            A[count++] = rightA[j++];
    }

    public void printResult(int w, good[] A) {
        mergeSort(A);
        int sumW = 0, i = 0;
        double result = 0;
        for(;i < A.length;i++) {
            if(sumW + A[i].weight <= w) {
                sumW += A[i].weight;
                result += A[i].weight * A[i].value;
            }
            else
                break;
        }
        if(i < A.length)   //此处要特别注意，唯有还有物品剩余，才可以进行下面语句执行
            result += (w - sumW) * A[i].value;
        System.out.printf("%.1f", result);
        return;
    }


}