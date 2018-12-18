public class Test12_18{
    public static void main(String[] args){
        //Student stu = new Student();

        // stu.setName("小白");
        // System.out.println(stu.getName());
        //stu.print();

        Student s = new Student("中国人");
        s.print();

        // Dog d = new Dog();  
        // d.run();

        People p = new People();
        p.MY_ADDRESS = 456789;     //无法为最终变量ADDRESS分配值
        System.out.println(p.MY_ADDRESS);
    }
}

// final class Animal{   //无法从最终Animal进行继承
//     public void run(){
//         System.out.println("jump");
//     }
// }

// class Dog extends Animal{
// }

class People{
    public static final int MY_ADDRESS = 123123;  //常量
    private String country;
    private String name;

    public People(){
        System.out.println("hello");
    }
    public People(String country){
        System.out.println(country+"最强！");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void print(){
        System.out.println("小黑好帅");
    }
}

class Student extends People{
    public Student(){
        super("中国");   //super调用父类构造方法的时候，必须位于子类构造方法的第一句
        System.out.println("你说的很对");
    }

    public Student(String person){
        this();
        System.out.println(person+"很帅");
    }
    public void print(){
        super.print();       //super调用父类方法
        System.out.println("阿怪也帅");
    }
}

//不可以直接访问父类private属性、方法
// class Worker extends People{
//     public void setCountry(String country){
//         super.country = country;
//     }
//     public String getCountry(){
//         return super.country;
//     }
//     public void print(String a){
//         //country = "China";  //不可以直接访问父类private属性、方法

//         System.out.println(a);
//     }
// }