package www.exercises.Test4_5;

public class Test4_5 {
    public static void main(String[] args) {
//        Person person = new Person("小黑","清华");
//        //person.print();
//        System.out.println(person);

        A a = new A(1);
        B b = new B();
        b.print();

        new D("str");

        new F();
    }
}

class Person {
    private String name;
    private String school;

    public Person(String name, String school) {
        this.name = name;
        this.school = school;
    }
    public void print() {
        System.out.println("普通方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

class A {
    public A() {
        System.out.println("无参构造");
    }
    public A(String string) {
        this();
        System.out.println("有参构造，参数类型为:"+string);
    }
    public A(int n) {
        this("String");
        System.out.println("有参构造，构造参数为整形");
    }
    public void print() {
        System.out.println();
    }
}

class B {
    public void print() {
        System.out.println(this);
    }
}

class C {
    public C (String name) {
        System.out.println("我是父类无参构造方法");
    }
}

class D extends C {
    public D () {
        super("小黑");
        System.out.println("我是子类无参构造方法");
    }
    public D(String str) {
        this();
        System.out.println("我是子类有参构造方法");
    }
}

class E {
    public String name;
    public int age;

    public E(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("父类普通方法");
    }
}

class F extends E {
    public F () {
        super("小黑");
        System.out.println("父类的name是:"+super.name);
        super.age = 20;
        System.out.println("父类的age是："+super.age);
    }
}
