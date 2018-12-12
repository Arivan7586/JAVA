class Outer{  //外部类
    private String s = "hello world";

    class Inner{ //内部类
        public void print(){
            System.out.println(s);  //内部类可以方便的操作外部类的私有访问。
        }
    }
    public void fun(){
        Inner i = new Inner();
        i.print();
    }
}

public class Test12_12{
    public static void main(String[] args){
        Outer mm = new Outer();
        mm.fun();
        pr();
    }

    //复习for（）循环语句
    public static void pr(){
        int i = 0;
        int j = 0;
        int key = 9;
        for(i = 1; i <= key;i++){
            for(j = key - i; j > 0; j--){
                System.out.print(" ");
            }
            for(j = 1; j <= i; j++){
                System.err.print("* ");
            }
            System.out.println();
        }
    }
}

// class Outer{
//     private String ss = "hello world";

//     public String getSs(){  //此方法用于获得ss属性
//         return this.ss;
//     }

//     public void fun(){  //由out对象调用fun（）方法
//         Inner in = new Inner(this);  //this表示当前对象
//         in.print();
//     }
// }

// class Inner{
//     private Outer out;

//     public Inner(Outer out){
//         this.out = out;  //应用传递
//     }

//     public void print(){
//         System.out.println(out.getSs());
//     }
// }

// public class Test12_12{
//     public static void main(String[] args){
//         Outer out = new Outer(); //实例化Outer对象
//         out.fun();  //调用Outer方法
//     }
// }