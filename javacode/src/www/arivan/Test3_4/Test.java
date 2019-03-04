package www.arivan.Test3_4;

public class Test {
    public static void main(String[] args) {
        Sequence sequence = new SequenceLinkImpl();
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        ((SequenceLinkImpl) sequence).add(1,5);

        SequenceLinkImpl sequenceLink = (SequenceLinkImpl) sequence;
        ((SequenceLinkImpl) sequence).printNode();

        System.out.println();
        sequence.remove(1);
        ((SequenceLinkImpl) sequence).printNode();
    }
}
