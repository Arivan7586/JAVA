package www.arivan.Test1_28;
import java.util.Scanner;

public class Test1_28 {
    public static void main(String[] args) {
//        Area.ballArea(3.0);

        Person ag = new Person("小黑");
        //ag.print();
        ag.setName("阿怪");
        ag.setAge(22);
        ag.setAddress("西安");
        System.out.print(ag.getName());
        System.out.print(ag.getAge()+"岁，");
        System.out.print("在"+ag.getAddress()+"上大学");
    }
}

class Area {

//    问题描述
//　　使用宏实现计算球体体积的功能。用户输入半径，系统输出体积。不能使用函数，
//      pi=3.1415926,
//    结果精确到小数点后五位。
    public static void ballArea(double n){
        final double Pi = 3.1415926;
        double v = (4/3)*Pi*n*n*n;
        System.out.printf("%.5f",v);
    }
}

class Person{

    // String name = "阿怪";
    // public static void print(){
    //     System.out.println(Name);  静态方法不可以调用非静态属性
    // }

    // public void print(){  //非静态方法可以调用静态属性
    //     System.out.println(name);
    // }

    private String name ;
    private Integer age;
    private String address;

    public Person(){
        System.out.println("谁长得最帅？");
    }

    public Person(String name){  //构造方法的重载
        this();
        System.out.println(name+"最帅");
    }

    public void print(){  //非静态方法可以调用静态属性
        System.out.println(name);
    }

    //setter方法访问，修改private属性，getter方法获取private属性
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        if(age >= 0 && age < 150){
            this.age = age;
        }else{
            this.age = -1;
        }
    }
    public int getAge(){
        return this.age;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
}

//class Math1 {
//    public static void multiplication(){
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//
//        char[] arr1 = s1.toCharArray();
//        char[] arr2 = s2.toCharArray();
//        int num = 1;
//        long sum = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            int m = arr1[i] - '0';
//            for (int j = arr2.length-1; j >= 0; j--) {
//                int n = arr2[j] - '0';
//                sum += m*n*num;
//            }
//            num *= 10;
//        }
//        System.out.println(sum);
//    }
//}