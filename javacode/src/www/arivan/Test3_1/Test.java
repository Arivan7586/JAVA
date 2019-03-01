package www.arivan.Test3_1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Sequence sequence = new SequenceArrayImpl(2);
        //测试add方法
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(null);

        sequence.remove(2);
        sequence.add(4);
        System.out.println(sequence.get(2));

        //测试contains方法
//        System.out.println(sequence.contains(null));
//        System.out.println(sequence.contains(20));

        //测试add、set方法
//        System.out.println(sequence.get(2));
//        System.out.println(sequence.set(1,20));
//        System.out.println(sequence.get(1));

        //System.out.println(sequence.get(10));
    }
}
