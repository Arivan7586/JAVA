// 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
// 例如6=1＋2＋3.编程 找出1000以内的所有完数。

public class Test1_4{
    public static void main(String[] args){
        Wan_shu w = new Wan_shu(1000);
    }
}

class Wan_shu{
    public Wan_shu(int m){
        System.out.print(m+"以内的完数有：");
        for(int i = 1; i <= m; i++){  //寻找m以内的所有完数
            if(yinShu(i) != 0){
                System.out.print(i+"\t");
            }
        }
    }

    public static int yinShu(int n){ //判断n是否为“完数”
        int sum = 0;
        for(int i = 1; i <= n/2; i++){
            if(0 == n % i){
                sum += i;
            }
        }
        if(sum == n){
            return n;
        }else{
            return 0;
        }
    }
}