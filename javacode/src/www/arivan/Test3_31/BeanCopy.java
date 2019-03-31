package www.arivan.Test3_31;

import java.lang.reflect.Field;

public class BeanCopy {
    /**
     * 将源对象中与目的对象相同属性，源对象的属性值copy赋值给目的对象
     * <p>
     * source:
     * name
     * age
     * birthday
     * <p>
     * target:
     * name
     * age
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void beanCopy(Object source, Object target) {
        //取得对象
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        //取得对象中的属性
        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        for (Field s : sourceFields) {
            for (Field t : targetFields) {
                if (s.getName().equals(t.getName())) {
                    s.setAccessible(true);
                    t.setAccessible(true);
                    try {
                        t.set(target,s.get(source));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Techer techer = new Techer();
        techer.setName("小黑");
        techer.setAge(20);
        techer.setGender("男");
        System.out.println(techer);
        Student student = new Student();
        System.out.println(student);
        beanCopy(techer,student);
        System.out.println(student);
    }
}

class Techer {
    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Tercher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Student {
    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}