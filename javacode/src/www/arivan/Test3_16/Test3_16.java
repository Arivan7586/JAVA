package www.arivan.Test3_16;

public class Test3_16 {
    public static void main(String[] args) {
//        System.out.println(add(1,2,3,4,5,6));
//        System.out.println(add1(new int[]{1,2,3,4,5,6}));
//        add2("和为：",1,2,3,4,5,6);

//          Point<String> point = new Point<>();
//          point.setValue1("hahaha");
//        System.out.println(point.getValue1());
//        System.out.println(point.getValue2());

//        MyClass<String,Integer> myClass = new MyClass<>();
//        myClass.setValue1("小黑");
//        myClass.setValue2(12);
//        System.out.println(myClass.getValue1());
//        System.out.println(myClass.getValue2());

        //泛型方法
//        A a = new A();
//        System.out.println(a.add(12));
//        System.out.println(a.add("小黑"));

        //泛型类和泛型方法同时存在
        B<String> b = new B<>();
        b.print("小黑");
        System.out.println(b.test(32));
        System.out.println(b.test(6.1));
        System.out.println(b.test(1.5f));
        System.out.println(b.test(5L)+b.test("小黑"));
    }

    //可变参数求和
    public static int add(int ... data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }
    //数组求和
    public static int add1(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static void add2(String str, int ... data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println(str + (sum));
    }
}

//泛型类
class Point<T> {
    private T value1;
    private T value2;

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public void setValue2(T value2) {
        this.value2 = value2;
    }

    public T getValue1() {
        return this.value1;
    }

    public T getValue2() {
        return this.value2;
    }
}

class MyClass<T,E> {
    private T value1;
    private E value2;

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public E getValue2() {
        return value2;
    }

    public void setValue2(E value2) {
        this.value2 = value2;
    }
}

//泛型方法
class A {
    public <T> T add(T t) {
        return t;
    }
}

//泛型类和泛型方法同时存在
class B<T> {
    public void print(T t) {
        System.out.println(t);
    }

    public <E> E test(E e) {
        return e;
    }
}