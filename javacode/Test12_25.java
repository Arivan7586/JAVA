class Out{
    private String name = "阿怪";
    private String country;
    private String sex = "男性";

    class Inner {  //成员内部类
        // static String sex = "man";  内部类中不可以拥有静态属性或或方法
        // public static void ss(){
        //     ;
        // }
        public void print(){
            System.out.println(name+"好帅");  //内部类可以直接访问外部类的私有域
        }

        public void fun(){
            country = "China";
            System.out.println(name+"在"+country);
        }

        public void ss(){
            System.out.println("性别为"+sex);   //成员内部类可以访问外部的静态属性
        }
    }

    static class Inner2{  //静态内部类
        // public void print(){
        //     System.out.println(name+"好帅");   静态内部类不可以访问外部普通域
        // }

        String address = "global";    //静态内部类不能访问外部的普通域，能拥有普通域
        public void print(){
            System.out.println("我来自"+address);
        }
    }

    public void run(){
        Inner i = new Inner();   //在外部类的内部实例化内部类
        i.fun();
    }

    private int num;   
    public void display(final int test){  //形参必须用final声明
        class Animal{  //方法内部类不可以用public private protected 等修饰     方法外部不可以访问
            private void fun(){
                num++;
                System.out.println(num);
                System.out.println(test);
            }
        }
        new Animal().fun();
    }
}

public class Test12_25{
    public static void main(String[] args){
        Out.Inner in = new Out().new Inner();   //在外部类的外部实例化内部类
        in.print();
        in.ss();
        System.out.println("---------------------------");
        Out.Inner2 i = new Out.Inner2();  //  在外部类外部创建静态内部类语法
        i.print();
        System.out.println("---------------------------");
        Out o = new Out();
        o.run();
        o.display(20);
    }
}