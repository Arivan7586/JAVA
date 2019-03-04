package www.arivan.Test3_4;

/**
 * 支持动态扩容的线性表（链表）
 */

public class SequenceLinkImpl implements Sequence {
    // 虚拟头节点，不存储元素，专门作为头节点使用
    private Node dummyHead;
    private int size;

    public SequenceLinkImpl() {
        dummyHead = new Node(null, null);
    }

    private class Node {
        Object data;
        Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(Object data) {
            this.data = data;
        }
    }

    @Override
    public void add(Object data) { //增加元素
        addFirst(data);
    }

    @Override
    public boolean remove(int index) { //删除节点
        rangCheck(index);
        //找到旧节点
        Node oldNode = findNode(index);

        //找到旧节点的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = oldNode.next;
        return true;
    }

    @Override
    public Object get(int index) { //取得指定下标节点的元素
        rangCheck(index);

        Node node = findNode(index); //找到指定坐标的节点
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
//        Node prev = dummyHead.next;
//        while (prev != null) {
//            if (data.equals(prev.data)) {
//                return true;
//            }
//            prev = prev.next;
//        }
//        return false;
        Object[] arr = toArray();
        if (data == null) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0; i < arr.length; i++) {
                if (data.equals(arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {  //更改元素
        rangCheck(index);
        // 取得相应index的Node节点
        Node ret = findNode(index);
        Object olaData = ret.data;
        ret.data = newData;
        return olaData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node prev = dummyHead.next;
        while (prev != null) {
            prev.data = null;
            Node nextNode = prev.next;
            prev.next = null;
            prev = nextNode;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node prev = dummyHead.next;
        int i = 0;
        while (prev != null) {
            arr[i++] = prev.data;
            prev = prev.next;
        }
        return arr;
    }

    public void add(int index, Object data) {
        //在指定位置插入
        rangCheck(index);
        //找到上一个下标
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node now = new Node(data);
        now.next = prev.next;
        prev.next = now;
        size++;
    }

    private void addFirst(Object data) {
        //头插法
        add(0,data);
    }

    private void addEnd(Object data) {
        //尾插法
        add(size, data);
    }
    private void rangCheck(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Illegal index!");
        }
    }

    private Node findNode(int index) {
        //根据指定下标寻找节点

        rangCheck(index);
        Node result = dummyHead.next;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    public void printNode() {
        Object[] arr = toArray();
        for (Object o : arr) {
            System.out.print(o+" ");
        }
    }
}
