package www.arivan.Test2_14;

//抽象类***********************************

//public class Test2_14 {
//    public static void main(String[] args) {
//        Person person = new Student(); //向上转型,实例化子类
//        person.getPersonInfo();
//        person.setName("xiaohei");
//        System.out.println(person.getName());
//    }
//}

abstract class Person { //抽象类
    private String name;
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract void getPersonInfo(); //抽象方法
}

class Student extends Person{
    @Override
    public void getPersonInfo() { //子类覆写抽象方法
        System.out.println("I am a student");
    }
}

abstract class A {
    public A(){   //3.调用父类构造
        this.print();  //4.调用被子类覆写的方法
    }

    public abstract void print();
}

class B extends A {
    private Integer num = 100;
    public B(int num){  //2.调用子类实例化对象
        super();   //3.隐含一行语句，实际要先调用父类构造
        this.num = num;   //7.为类中属性初始化
        this.print();
    }

    @Override
    public void print() {  //5.此时子类对象的属性还没有被初始化
        System.out.println(this.num); //6.对应其数据类型的默认值
    }
}

//public class Test2_14{
//    public static void main(String[] args) {
//        new B(30); //1.实例化子类对象
//    }
//}

// 接口***************************
interface IMessage {
    public static final String MSG = "T am a Chinese"; //全局常量
    public abstract void print(); //抽象方法
}

interface Inews {
    public abstract String getNews();  //抽象方法,接口中的抽象方法可以省略abstract
}

class MessageImpl implements IMessage, Inews { //接口可以多继承
    public void print(){  //接口中只允许 public权限
        System.out.println(IMessage.MSG);
    }
    public String getNews(){
        return IMessage.MSG;  // 访问常量都建议加上类名称
    }
}

//public class Test2_14{
//    public static void main(String[] args) {
//        IMessage m = new MessageImpl();   //子类向上转型,为父接口实例化对象
//        m.print();   // 调用被子类覆写过的方法
//        Inews n = (Inews) m; //向下转型
//        System.out.println(n.getNews());
//    }
//}

interface IM {
    public void print();
}

abstract class News {
    // 抽象类中方法前面的abstract不能省略，否则就是普通方法
    public abstract void getNews();
}

class MeImpl extends News implements IM {
    public void print() {
        System.out.println("I am a IM");
    }

    public void getNews() {
        System.out.println("I am a News");
    }
}

public class Test2_14 {
    public static void main(String[] args){
        IM m = new MeImpl() ;
        m.print();
        // MessageImpl是抽象类和接口的共同子类
        News news = (News) m;
        news.getNews();
    }
}