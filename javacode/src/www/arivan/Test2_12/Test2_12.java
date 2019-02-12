package www.arivan.Test2_12;
import java.util.Scanner;

public class Test2_12 {
    public static  void main(String[] args) {
        A test = new A();
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        test.printResult(n);
    }
}

class A {  //参考

//    已知递推公式：
//
//            　　F(n, 1)=F(n-1, 2) + 2F(n-3, 1) + 5,
//
//            　　F(n, 2)=F(n-1, 1) + 3F(n-3, 1) + 2F(n-3, 2) + 3.
//
//            　　初始值为：F(1, 1)=2, F(1, 2)=3, F(2, 1)=1, F(2, 2)=4,
//    F(3, 1)=6, F(3, 2)=5。
//            　　输入n，输出F(n, 1)和F(n, 2)，由于答案可能很大，
//    你只需要输出答案除以99999999的余数。

    public final static long[][] UNIT = {{0,1,1,0,0,0,0,0},
            {1,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0},
            {0,0,0,0,0,1,0,0},
            {2,3,0,0,0,0,0,0},
            {0,2,0,0,0,0,0,0},
            {0,1,0,0,0,0,1,0},
            {1,0,0,0,0,0,0,1}};   //根据递推公式构造的矩阵
    public final static long[][] ZERO = new long[8][8];  //元素全为0
    public final static long p = 99999999L;
    //获取矩阵NUIT的n次方结果
    public long[][] getNofMatrix(long n) {
        if(n == 0) {
            return ZERO;
        }
        if(n == 1) {
            return UNIT;
        }
        if((n & 1) == 0) {  //当n为偶数时
            long[][] matrix = getNofMatrix( n >> 1);
            return multiOfMatrix(matrix, matrix);
        }
        //当n为奇数时
        long[][] matrix = getNofMatrix((n - 1) >> 1);
        return multiOfMatrix(multiOfMatrix(matrix, matrix), UNIT);
    }
    //计算矩阵A*B取余99999999的值
    public long[][] multiOfMatrix(long[][] A, long[][] B) {
        long result[][] = new long[A.length][B[0].length];
        for(int i = 0;i < A.length;i++) {
            for(int j = 0;j < B[0].length;j++) {
                for(int k = 0;k < A[0].length;k++)
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % p;
            }
        }
        return result;
    }

    public void printResult(long n) {
        long[][] start = {{6,5,1,4,2,3,3,5}};
        if(n == 1) {
            System.out.println(start[0][4]+"\n"+start[0][5]);
            return;
        } else if(n == 2) {
            System.out.println(start[0][2]+"\n"+start[0][3]);
            return;
        } else if(n == 3) {
            System.out.println(start[0][0]+"\n"+start[0][1]);
            return;
        }
        long[][] A = getNofMatrix(n - 3);
        start = multiOfMatrix(start, A);
        System.out.println(start[0][0]+"\n"+start[0][1]);
        return;
    }
}