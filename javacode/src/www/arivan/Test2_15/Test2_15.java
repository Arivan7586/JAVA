package www.arivan.Test2_15;

//子类继承抽象类和实现接口
//public class Test2_15 {
//    public static void main(String[] args) {
//        IMessage m = new MessageImpl() ;
//        m.print() ;
//        // MessageImpl是抽象类和接口的共同子类
//        News news = (News) m ;
//        news.getNews() ;
//    }
//}

interface IMessage {
    public void print() ;
}
abstract class News {
    // 抽象类中方法前面的abstract不能省略，否则就是普通方法
       public abstract void getNews() ;
}

class MessageImpl extends News implements IMessage {
    public void print() {
        System.out.println("I am a biter");
    }

    public void getNews() {
        System.out.println("I am News");
    }
}

//一个抽象类可以使用implements实现多个接口，但是接口不能继承抽象类。
interface IM{
    public void print();
}

abstract class NE implements IM{
    public abstract void getNews();
}

class MeImpl extends NE{
    public void print(){
        System.out.println("hello");
    }
    @Override
    public void getNews() {
        System.out.println("world");
    }
}

public class Test2_15 {
    public static void main(String[] args) {
        IM i = new MeImpl();
        i.print();
        // MeImpl是抽象类和接口的共同子类
        NE ne = (NE) i;
        ne.getNews();
    }
}

//接口多继承------------------------------
interface A {
    public void printA();
}

interface B {
    public void printB();
}

interface C extends A,B{
    public void printC();
}

class Impl implements C {
    @Override
    public void printA() {

    }

    @Override
    public void printB() {

    }

    @Override
    public void printC() {

    }
}