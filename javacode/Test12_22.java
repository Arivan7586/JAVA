class A{
    int y = 6;
    class Inner{
        static int y = 3;  //成员内部类不能拥有静态域

        void show(){
            System.out.println(y);
        }
    }
}

public class Test12_22{
    public static void main(String[] args){
        A.Inner inner = new A().new Inner();
        inner.show();
    }
}

public class Test12_22{
    public static void main(String[] args){
        //  Child c = new Child();   用于在外部类内部创建成员内部类对象
        Father.Child c = new Father().new Child();  //在外部类外部创建成员内部类对象
        c.introFather();  
    }
}

class Father{
    private String name = "zhangjun";

    class Child{
        public void introFather(){
            System.out.println("我是"+name);  //内部类可以直接访问外部类的私有域
        }
    }
}

class Role{
    private String name;
    private String sex;
    private int age;
    public Role(){
        System.out.println("我是Role类");
    }
    public Role(String ss){
        this();
        for(int i = 1; i <= 20 ; i++){
            System.out.print(ss);
        }
        System.out.println();
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void play(){
        System.out.println("我是"+this.name+"我今年"+this.age+"岁了");

    }
}

class Employee extends Role{
    private int salary;
    private static int ID;
    public Employee(int salary){
        super("*");
        System.out.println("I am a Employee");
        this.salary = salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getSalart(){
        return this.salary;
    }
    public void setID(int id){
        this.ID = id;
    }
    public int getID(){
        return this.ID;
    }

    public void play(){  //play方法的覆写
        super.play();  //super调用父类方法
        System.out.println("岁了,我的年薪是"+this.salary);
    }
}

// public class Test12_22{
//     public static void main(String[] args){
//         // Role r = new Role("*");
//         // r.setName("王大锤");
//         // r.setAge(18);
//         // r.play();

//         Employee e = new Employee(100000);
//         e.setName("小黑");
//         e.setAge(20);
//         e.play();
//     }
// }

// 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
// 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
// public class Test12_22{
//     public static void main(String[] args){
//         for(int i = 100; i <= 999; i++){
//             int a = 0; //a为数字i百位上的数
//             int b = 0; //b为数字i十位上的数
//             int c = 0; //c为数字i个位上的数
//             a = i / 100;
//             b = (i / 10) % 10;
//             c = i % 10;
//             if(i == a*a*a + b*b*b + c*c*c){
//                 System.out.println(i);
//             }
//         }
//     }
// }

// class A{
//     public A(){
//         System.out.println("A");
//     }
// }

// public class Test12_22 extends A {  
//     public Test12_22(){
//         System.out.println("B");
//     }
//     public static void main(String[] args){
//         Test12_22 Test = new Test12_22();  //继承了A类的 构造方法
//     }
// }