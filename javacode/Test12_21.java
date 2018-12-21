class Person{
    static{
        System.out.println("1、非主类的静态代码块");
    }
    {
        System.out.println("2、非主类构造块");
    }
    public Person(){
        System.out.println("3、非主类的构造方法代码块");
    }
}

public class Test12_21 extends Person{
    static{
        System.out.println("4、主类的静态代码块"); //主类中的静态代码块先于主方法执行
    }
    {
        System.out.println("5、主类的代码块");
    }
    public Test12_21(){
        System.out.println("6、主类的构造方法代码块");
    }

    // public static void main(String[] args){
    //    System.out.println("7、主方法开始");
    //     new Test12_21();
    //     new Test12_21();
    //    System.out.println("8、主方法结束");
    // }

    public static void main(String[] args){
        // Dog d = new Dog();
        // d.say();
        // d.run();
        // Cat c = new Cat();
        // c.say();
        // c.run();

        Animal a = new Dog(); //向上转型
        a.run();
        Dog d = (Dog) a;    //向下转型
        d.say();
    } 
}

class Animal{
    private String name;

    public Animal(){
        System.out.println("I am a animal");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void say(){
        System.out.println("动物叫声");
    }
    public void run(){
        System.out.println("动物奔跑");
    }
}

class Dog extends Animal{
    public Dog(){
        super();
        System.out.println("我是一条狗");
    }

    public void say(){
        System.out.println("汪汪汪"); //方法的覆写
    }

    public void run(){
        System.out.println("跑得快");
    }
}

class Cat extends Animal{
    public Cat(){
        super();
        System.out.println("我是一只猫");
    }

    public void say(){
        System.out.println("喵喵喵");
    }
    public void run(){
        System.out.println("跳得高");
    }
}