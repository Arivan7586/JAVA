package www.exercises.test8_14;

import java.util.Scanner;

public class TestFactory {

    public static void buyComputer(Computer computer) {
        computer.buyComputer();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //简单工厂模式
//        System.out.println("请输入要买的电脑名称:");
//        String computerName = in.nextLine();
//        Computer computer = ComputerFactory.getInstance(computerName);
//        if (computer != null) {
//            buyComputer(computer);
//        }

        //工厂方法模式
        ComputerFactory1 computerFactory1 = new MacFactory();
        buyComputer(computerFactory1.getInstance());
        ComputerFactory1 computerFactory2 = new SurfaceFactory();
        buyComputer(computerFactory2.getInstance());

    }
}



//回顾工厂模式
interface Computer {
    void buyComputer();
}

class MacComputer implements Computer {

    @Override
    public void buyComputer() {
        System.out.println("buy a MacPro");
    }
}

class SurfaceComputer implements Computer {

    @Override
    public void buyComputer() {
        System.out.println("buy a SurfacePro");
    }
}

//简单工厂模式
class ComputerFactory {
    public static Computer getInstance(String computerName) {
        if ("Mac".equals(computerName)) {
            return new MacComputer();
        } else if ("Surface".equals(computerName)) {
            return new SurfaceComputer();
        } else {
            return null;
        }
    }
}

interface ComputerFactory1 {
    Computer getInstance();
}

class MacFactory implements ComputerFactory1 {

    @Override
    public Computer getInstance() {
        return new MacComputer();
    }
}

class SurfaceFactory implements ComputerFactory1 {

    @Override
    public Computer getInstance() {
        return new SurfaceComputer();
    }
}