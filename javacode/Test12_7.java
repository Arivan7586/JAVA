// public class Test12_7{
//     public static void main(String[] args){
//         Test t = new Test();      
//         System.out.println(t.n); //类中public权限的int型成员变量的初始值为0；
//         System.out.println(t.m); //public权限char型成员变量的初始值为“ ”（空格）

//         Test1 t1 = new Test1();
//         t1.setCountry("中国");
//         Test1 t2 = new Test1();
//         Test1 t3 = new Test1();
//         System.out.println(t1.getCountry());  //static修饰的类属性，只需定声明一次，之后实例化的对象都可共享。
//         System.out.println(t2.getCountry());
//         System.out.println(t3.getCountry());
//     }
// }

// class Test{
//     public int n;
//     public char m;
// }

// class Test1{
//     private static String country;

//     public void setCountry(String country){
//         this.country = country;
//     }
//     public String getCountry(){
//         return this.country;
//     }
// }

class Fibonacci{
    public void fib(int n){  //求前n个斐波那契数
        int a = 1;
        int b = 1;
        int c = 1;
        if(n <= 1 && n != 0){
            System.out.print(a+"、");
        }else if(n <= 2 && n > 1){
            System.out.print(a+"、");
            System.out.print(b+"、");
        }else{
            System.out.print(a+"、");
            System.out.print(b+"、");
            while(n > 2){
                a = b;
                b = c;
                c = a + b;
                n = n - 1;
                System.out.print(c+"、");
            }
        }
    }
}

public class Test12_7{
    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        f.fib(20);
        System.out.println();
        Test233 t233 = new Test233("小黑");
    }
}

class Test233{
    public Test233(){  //无参构造方法
        System.out.println("Hello Constructor");
    }

    public Test233(String name){  //有一个参数的构造方法
        this();   //调用无参构造方法
        System.out.println(name+"真可爱！");
    }
}