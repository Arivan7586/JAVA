package www.arivan.java;

//内部类
class Outter {
    private String name;
    private static String country = "China";
    private  Integer age;

    class Inner {
        //static int a ;成员内部类中不可以有静态域
        public void print(){
            System.out.println(age);
            age = 20;  //内部类可以直接访问外部类的私有域
            System.out.println(country);  //成员内部类可以访问外部类的私有域
            System.out.println(age);

        }
    }

    public void fun(){
        Inner i = new Inner(); //在外部类中实例化内部类
        i.print();
    }
}

class Outter1 {
    private String name;
    private static String country = "Russia";
    private Integer age;

    static class Inner1 {
        private long value;  //静态内部类可以拥有静态域
        public void print(){
            //age = 20; 静态内部类不可以访问外部类的非静态域
            this.value = 10000000;
            System.out.println(country);
            System.out.println(this.value);
        }
    }
}

public class Test1_5 {
    public static void main(String[] args) {
        Outter.Inner in = new Outter().new Inner(); //成员内部类的实例化需要依赖于外部类。
        in.print();

        Outter1.Inner1 i = new Outter1.Inner1();  //静态内部类实例化
        i.print();

        Outter o = new Outter();
        o.fun();
    }
}

//class Person {
//    static{
//        System.out.println("1、非主类的静态代码块");
//    }
//    {
//        System.out.println("2、非主类构造块");
//    }
//    public Person(){
//        System.out.println("3、非主类的构造方法代码块");
//    }
//}
//public class Test1_5 extends Person {
//    static{
//        System.out.println("4、主类的静态代码块"); //主类中的静态代码块先于主方法执行，只执行一次。
//    }
//    {
//        System.out.println("5、主类的代码块");  //构造块先于构造方法执行
//    }
//
//    public Test1_5() {
//        System.out.println("6、主类的构造方法代码块");
//    }
//
//    public static void main(String[] args){
//
//        System.out.println("7、主方法开始");
//        new Test1_5();
//        new Test1_5();
//        System.out.println("8、主方法结束");
//        //147235623568
//    }
//}

//********************单例模式
class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return singleton;
    }
}

class Singleton2 {
    private static Singleton2 singleton2;

    private Singleton2(){};

    public static Singleton2 getSingleton2(){
        if(singleton2 == null){
             singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

//--------------------------------------------------------
abstract class People {
    public People(){
        this.print();
    }

    public abstract void print();
}

class Student extends People {
    private int num = 100;

    public Student(int num){
        super();
        this.num = num;
    }

    public void print(){
        System.out.println(this.num);
    }
}

//public class Test1_5 {
//    public static void main(String[] args) {
//        new Student(30);  //输出结果为 0
//    }
//}