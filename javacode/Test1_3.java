interface A{
    Double PI = 3.14;  //在类中定义变量或者常量，应该用包装类
    double area();
}

interface B{
    void setColor(String c);
}

interface C extends A, B{  //接口可以多继承
    void volume();
}

class CylinderImpl implements C{
    private Double radius;  //半径
    private Double height;  //高
    private String color;   //颜色

    public CylinderImpl(double radius, double height, String color){
        this.radius = radius;
        this.height = height;
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public double area(){ //计算圆柱体的表面积
        return (PI*this.radius*this.radius*2) + (PI*2*this.radius*this.height);
    }

    public void setColor(String c){  //设置圆柱体的颜色
        this.color = c;
    }

    public void volume(){  //计算圆柱体的体积
        System.out.println("圆柱体体积为："+PI*this.radius*this.radius*this.radius*this.height);
    }
}

public class Test1_3{
    public static void main(String[] args){
        CylinderImpl cy = new CylinderImpl(3.0, 5.0, "红色");
        System.out.println("圆柱体面积为："+cy.area()+"平方米");
        cy.volume();
        cy.setColor("黑色");
        System.out.println("圆柱体颜色为："+cy.getColor());
    }
}

// interface Calculator{  //计算器接口
//     int calculate(int m, int n);
// }

// class Plus implements Calculator{  //加法
//     public int calculate(int m, int n){
//         return m + n;
//     }
// }

// class Minus implements Calculator{  //减法
//     public int calculate(int m, int n){
//         return m - n;
//     }
// }

// class Multiplication implements Calculator{  //乘法
//     public int calculate(int m, int n){
//         return m * n;
//     }
// }

// class Division implements Calculator{  //除法
//     public int calculate(int m, int n){
//         return m / n;
//     }
// }

// class UseCalculator{
//     public void useCal(Calculator cal, int one, int two){  //调用计算方法
//         System.out.println(cal.calculate(one,two));
//     }
// }

// public class Test1_3{
//     public static void main(String[] args){
//         UseCalculator u = new UseCalculator();
//         u.useCal(new Plus(), 3, 2);  //5 加法操作
//         u.useCal(new Minus(), 3, 2);    // 1 减法操作
//         u.useCal(new Multiplication(), 3, 2);   //6  乘法操作
//         u.useCal(new Division(), 4, 2);         //2  除法操作
//     }
// }

// interface InterfaceA{  //接口InterfaceA
//     String S = "good";
//     void f();
// }

// abstract class ClassA{  //抽象类ClassA
//     abstract void g();
// }

// class ClassB extends ClassA implements InterfaceA{ //继承了抽象类和接口
//     void g(){
//         System.out.println(S);
//     }
//     public void f(){
//         System.out.println(" "+ S);  //此时可以使用接口InterfaceA的参数
//     }
// }

// public class Test1_3{
//     public static void main(String[] args){
//         ClassA a = new ClassB(); 
//         InterfaceA b = new ClassB(); 
//         a.g();  //只能调用ClassA的方法
//         b.f();  //只能调用InterfaceA的方法
//     }
// }