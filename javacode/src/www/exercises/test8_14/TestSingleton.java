package www.exercises.test8_14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestSingleton {

    public static void main(String[] args) {

        System.out.println(Singleton.getSingleton());
    }
}


//回顾单例模式

//双重检验单例模式
class Singleton {
    private static volatile Singleton singleton = null;
    private Singleton() {}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//枚举单例模式
enum Singleton1 {
    SINGLETON_1;
    public static Singleton1 getSingleton1() {
        return SINGLETON_1;
    }

    public void print() {
        System.out.println("哈哈哈");
    }
}
//懒汉式单例模式
class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();
    public static Singleton2 getInstance() {
        return singleton2;
    }
}
