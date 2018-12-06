// class Person{
//     private String name;
//     private int age;
//     private static String country;  //静态属性，可共享
//     public void setName(String name){
//         this.name = name;
//     }
//     public String getName(){
//         return this.name;
//     }
//     public void setAge(int age){
//         this.age = age;
//     }
//     public int getAge(){
//         return this.age;
//     }
//     public void setCountry(String country){
//         this.country = country;
//     }
//     public String getCountry(){
//         return this.country;
//     }
// }

class A{
    static{
        System.out.println("1、父类静态代码块");
    }
    {
        System.out.println("2、父类构造块");
    }
    public A(){
        System.out.println("3、父类构造方法代码块");
    }
}

public class Test12_6 extends A{   //子类继承父类，先实例化父类，再实例化子类
    static {
        System.out.println("4、子类静态代码块");  //主类中的静态代码块，先于主方法（main方法）执行
    }
    {
        System.out.println("5、子类构造块");
    }
    public Test12_6(){
        System.out.println("6、子类构造方法代码块");
    }
    // public static void main(String[] args){
    //     Person p = new Person();
    //     Person pp = new Person();
    //     p.setCountry("中国");
    //     p.setName("小黑");
    //     p.setAge(18);
    //     System.out.println(p.getName());
    //     System.out.println(p.getAge());
    //     System.out.println(p.getCountry());
    //     System.out.println(pp.getCountry());
    // }
    public static void main(String[] args){
        System.out.println("7、main方法开始！");
        new Test12_6();
        new Test12_6();
        System.out.println("8、main方法结束！");
    }

}