package www.arivan.Test2_26;
import java.util.Scanner;

// 单例设计模式

public class Test2_26 {
    public static void main(String[] args){
        Singleton singleton = null; // 声明对象
        singleton = Singleton.getSingleton();
        singleton.print();
    }
}

class Singleton {
    private static Singleton singleton;

    private Singleton(){  // private声明构造

    }

    public static Singleton getSingleton(){
        if (singleton == null){  // 表示此时还没有实例化
            singleton = new Singleton();
        }
        return singleton;
    }

    public void print(){
        System.out.println("Hello World");
    }
}

//class Singleton {
//    // 在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
//    private static Singleton singleton = new Singleton();
//
//    private Singleton(){ // private声明构造
//
//    }
//
//    public static Singleton getSingleton(){
//        return singleton;
//    }
//
//    public void print(){
//        System.out.println("Hello world");
//    }
//}