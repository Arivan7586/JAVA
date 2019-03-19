package www.arivan.Test3_19;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Sequence<String> sequence = new SequenceGenericsImpl<>();
        ((SequenceGenericsImpl<String>) sequence).tailAdd("1");
        ((SequenceGenericsImpl<String>) sequence).tailAdd("2");
        ((SequenceGenericsImpl<String>) sequence).tailAdd("3");
        sequence.add("2");
        sequence.add("3");
        System.out.println(sequence.get(0));
        System.out.println(sequence.size());
        sequence.remove(1);
//        System.out.println(sequence.get(1));
//        System.out.println(sequence.size());
//        sequence.set(2,"999");
//        System.out.println(sequence.get(2));




    }
}
