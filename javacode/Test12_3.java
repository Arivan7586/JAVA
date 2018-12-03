class animal{
    public String name;
    public int nun;
    public String where;
    public void doll(){
        System.out.println(name+"在"+where+"玩泥巴！");
    }
}

public class Test12_3{
    public static void main(String[] args){
        animal dog = new animal();
        dog.name = "小黑";
        dog.where = "公园";
        dog.doll();
        chengfa();
        System.out.println(jiecheng(20));
    }
    //99乘法表
    public static void chengfa(){
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j+"*"+i+"="+(i*j)+"\t");
            }
            System.out.println();
        }
    }

    //求阶乘
    public static long jiecheng(int n){
        if(n <= 1){
            return 1L;
        }else{
            return n * jiecheng(n - 1);
        }
    }
}
