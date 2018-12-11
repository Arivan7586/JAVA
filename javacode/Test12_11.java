        //复习多态（向上、向下转型）
class People{
    public void say(){
        System.out.println("我是人类！");
    }
}

class Worker extends People{
    public void say(){
        System.out.println("我是工人！");
    }
}

class Student extends People{
    public void say(){
        System.out.println("我是学生！");
    }
}

class H_Worker extends Worker{
    public void say(){
        System.out.println("我是环卫工人！");
    }

    public void active(){
        System.out.println("我需要扫马路");
    }
}

class HighSchool_Student extends Student{
    public void say(){
        System.out.println("我是高中生！");
    }
}

public class Test12_11{
    public static void main(String[] srgs){

             //向上转型
        // People p1 = new Worker();  
        // p1.say();
        // People p2 = new Student();
        // p2.say();
        // People p3 = new H_worker();
        // p3.say();
        // People p4 = new HighSchool_Student();
        // p4.say();

        print(new Worker());
        print(new Student());
        print(new H_Worker());
        print(new HighSchool_Student());

        System.out.println("*****************************");
        People per = new H_Worker();
        per.say();
        H_Worker h = (H_Worker)per;  //向下转型，需要强转。前提是发生过向上转型。
        h.active();
    }

    public static void print(People p){
        p.say();
    }
}

//     //复习代码块和继承
// class Test{
//     {
//         System.out.println("1、父类构造块！");
//     }
//     public Test(){
//         System.out.println("2、父类构造方法代码块！");
//     }
//     static{
//         System.out.println("3、父类静态代码块！");
//     }
// }

// public class Test12_11 extends Test{
//     {
//         System.out.println("4、子类构造块！");
//     }
//     public Test12_11(){
//         System.out.println("5、子类构造方法代码块！");
//     }
//     static{
//         System.out.println("6、子类静态代码块！");
//     }
//     public static void main(String[] args){
//         System.out.println("7、main方法开始！");
//         new Test12_11();
//         new Test12_11();
//         System.out.println("8、main方法结束!");
//         //运行结果：3、6、7、1、2、4、5、1、2、4、5、8
//     }
// }