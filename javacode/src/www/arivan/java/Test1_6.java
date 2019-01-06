package www.arivan.java;

//匿名内部类
//interface MyInterface {
//    void test();
//}
//
//class Outer {
//    private Integer num;
//    public void display(int para){
//        //匿名内部类，实现了MyInterface接口
//        new MyInterface(){
//            public void test(){
//                System.out.println("匿名内部类"+para);
//            }
//        }.test();
//    }
//}
//
//public class Test1_6 {
//    public static void main(String[] args) {
//        Outer outter = new Outer();
//        outter.display(20);
//    }
//}

//class A {
//    private String name = "A类的私有域";
//
//    public String getName() {
//        return name;
//    }
//}
//
//class B {
//    private Integer age = 20;
//    public int getAge(){
//        return age;
//    }
//}
//
////可以只用内部类来实现多继承
//class Outer {  //内部类方法可以访问该类定义所在作用域中的数据，包括private属性
//    private class InnerClassA extends A {
//        public String name(){
//            return super.getName();
//        }
//    }
//
//    private class InnerClassB extends B {
//        public int age(){
//            return  super.getAge();
//        }
//    }
//
//    public String name(){
//        return new InnerClassA().name();
//    }
//
//    public int age(){
//        return new InnerClassB().age();
//    }
//}
//
//public class Test1_6 {
//    public static void main(String[] args){
//        Outer out = new Outer();
//        System.out.println(out.name());
//        System.out.println(out.age());
//    }
//}

//内部类可以直接访问外部类的所有元素（包括private）
class Outer {
    private String name = "arivan";
    private Integer value = 100000;

    private void print(){
        System.out.println(name+" is so handsome");
    }

    class Inner {
        private String address = "America";
        public void run(){

            //内部类可以直接访问外部类的元素
            System.out.println(name);
            print();
            name = "小黑";
            System.out.println(name);
            print();
        }
    }

    public void display(){
        Inner in = new Inner();
        //in.run();
        System.out.println(in.address);
        in.address = "China"; //外部类可以通过内部类引用间接访问内部类元素（包括private元素）
        System.out.println(in.address);
    }
}

public class Test1_6 {
    public static void main(String[] args){
        Outer out = new Outer();
        out.display();
    }
}