package www.arivan.Test3_31;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3_31 {
    public static void main(String[] args) {
        Person source = new Person();
        System.out.println(source);
        source.setName("阿标");
        source.setAge(45);
        source.setSchool("哈佛大学");
        Class<?> cls = source.getClass();
        try {
            Person target = (Person) cls.newInstance();
            //取得Person类中的所有属性
            Field[] fields = cls.getDeclaredFields();
            String setMethodName1 = setXxxName(fields[0]);
            String setMethodName2 = setXxxName(fields[1]);
            String setMethodName3 = setXxxName(fields[2]);
            try {
                //取得Person类中属性的set方法
                Method setMethod1 = cls.getMethod(setMethodName1,fields[0].getType());
                Method setMethod2 = cls.getMethod(setMethodName2,fields[1].getType());
                Method setMethod3 = cls.getMethod(setMethodName3,fields[2].getType());
                setMethod1.invoke(target,source.getName());
                setMethod2.invoke(target,source.getAge());
                setMethod3.invoke(target,source.getSchool());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            String getMethodName1 = getXxxName(fields[0]);
            String getMethodName2 = getXxxName(fields[1]);
            String getMethodName3 = getXxxName(fields[2]);
            //取得Person类中属性的get方法
            Method getMethod1 = cls.getMethod(getMethodName1);
            Method getMethod2 = cls.getMethod(getMethodName2);
            Method getMethod3 = cls.getMethod(getMethodName3);
            //用setter方法赋值

            System.out.println(getMethod1.invoke(target));
            System.out.println(getMethod2.invoke(target));
            System.out.println(getMethod3.invoke(target));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static String setXxxName(Field field) {
        return "set"+field.getName().substring(0,1).toUpperCase()
                +field.getName().substring(1);
    }
    public static String getXxxName(Field field) {
        return "get"+field.getName().substring(0,1).toUpperCase()
                +field.getName().substring(1);
    }
}

class Person {
    private String name;
    private int age;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}