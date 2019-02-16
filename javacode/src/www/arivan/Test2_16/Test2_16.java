package www.arivan.Test2_16;
import java.util.Scanner;

//简单工厂模式
public class Test2_16 {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args) {
        Test2_16 t = new Test2_16();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想要的电脑型号……");
        String type = scanner.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        t.buyComputer(computer);
    }
}

interface Computer {
    void printComputer();
}

class MacbookProComputer implements Computer{
    @Override
    public void printComputer() {
        System.out.println("This is a MacbookPro");
    }
}

class SurfaceBookComputer implements Computer{
    @Override
    public void printComputer() {
        System.out.println("This is a SurfaceBook");
    }
}

class ComputerFactory {
    public static Computer getInstance(String type){
        Computer computer = null;
        if (type.equals("macbook")){
            computer = new MacbookProComputer();
        }else if (type.equals("surface")){
            computer = new SurfaceBookComputer();
        }
        return computer;
    }
}

//工厂方法模式
//interface Computer {
//    void printComputer();
//}
//
//class MacbookProComputer implements Computer {
//    @Override
//    public void printComputer() {
//        System.out.println("This is a Macbook");
//    }
//}
//
//class SurfaceBookComputer implements Computer {
//    @Override
//    public void printComputer() {
//        System.out.println("This is a SurfaceBook");
//    }
//}
//
//interface ComputerFactory{
//    Computer creatComputer();
//}
//
//class MsFactory implements ComputerFactory {
//    @Override
//    public Computer creatComputer() {
//        return new SurfaceBookComputer();
//    }
//}
//
//class AppleFactory implements ComputerFactory{
//    @Override
//    public Computer creatComputer() {
//        return new MacbookProComputer();
//    }
//}
//
//public class Test2_16 {
//    public void buyComputer(Computer computer){
//        computer.printComputer();
//    }
//
//    public static void main(String[] args) {
//        Test2_16 t = new Test2_16();
//        ComputerFactory factory = new AppleFactory();
//        t.buyComputer(factory.creatComputer());
//    }
//}