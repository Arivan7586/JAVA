// public class Test12_8{
//     public static void main(String[] args){
//         Person per = new Person();
//         Student stu = new Student();
//         //stu.name = "小黑";  //隐式继承
//         stu.setName("小黑"); 
//         //per.name = "小白";
//         System.out.println(stu.getName());
//     }
// }

class Person{
    private String name;
    public String country = "China";

    public Person(){
        System.out.println("*****************");
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void print(){
        System.out.println("1-父类方法");
    }
    // private void run(){               //由 private 修饰的方法，无法被覆写,只能被父类使用
    //     System.out.println("111--父类中的Run（）方法");
    // }
    public void run(){
        System.out.println("111--父类中的run（）方法");
    }
}

class Student extends Person{

    // public Person(){                   构造方法不能被覆写
    //     System.out.println("-----------------------------");
    // }
    
    public String country = "America";  //属性的覆写
    public void print(){  //父类方法的重写
        System.out.println("2-子类方法");
    }
    public void run(){
        System.out.println("222-子类中的Run（）方法");
    }
}

// public class Test12_8{
//     public static void main(String[] args){
//         Student stu = new Student(); 
//         stu.print();  //调用被覆写（override）后的方法
//         //Person per = new Person();  //实例化的对象属于Person类，则调用的方法是Person中的方法。
//         //per.print();

//         stu.run();
//         System.out.println(stu.country);
//     }
// }

class People{
   public String name = "父类小白";
    public void fun(){
        System.out.println("父类小黑在学习！");
    }
    public void jump(){
        System.out.println("父类大黄在跳绳！");
    }
    public final void drive(){
        System.out.println("司机大聪明在开车！");
    }
}

class Work extends People{

    public void fun(){
        System.out.println("子类小黑在搬砖！");
        //super.fun(); 
        super.jump();      // super.（） 调用父类方法
        System.out.println(super.name+"在睡觉！"); //super 访问父类属性
    }
}

class Driver extends People{
    // public void drive(){
    //     System.out.println("子类小傻子想开车！");   被final限制的方法无法被覆写
    // }
}

// public class Test12_8{
//     public static void main(String[] args){
//         Work w = new Work();
//         w.fun();
//     }
// }

public class Test12_8{
    public static void main(String[] args){
        Driver d = new Driver();
        d.drive();
    }
}