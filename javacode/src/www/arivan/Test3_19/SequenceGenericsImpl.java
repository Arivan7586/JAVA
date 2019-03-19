package www.arivan.Test3_19;

import java.util.ArrayList;
import java.util.List;

/**
 * 支持动态扩容的泛型线性表
 * @param <T>
 */
public class SequenceGenericsImpl<T> implements Sequence<T> {
    private ListNode head; //头节点
    private int size; //元素个数
    private class ListNode {
        T data;
        ListNode next;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public SequenceGenericsImpl() {
        this.head = new ListNode(null,null);
    }

    @Override
    public void add(T data) {
        headAdd(data);
    }

    @Override
    public T remove(int index) {
        rangCheck(index);
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        T oldData = temp.data;
        temp.next = temp.next.next;
        return oldData;
    }

    @Override
    public T get(int index) {
        rangCheck(index);
        ListNode temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public boolean contains(T data) {
        ListNode temp = head.next;
        if (data == null) {
            while (temp != null) {
                if (temp.data == null) {
                    return true;
                }
                temp = temp.next;
            }
        }else {
            while (temp != null) {
                if (data.equals(temp.data)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        rangCheck(index);
        ListNode temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        T oldNode = temp.data;
        temp.data = newData;
        return oldNode;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        ListNode temp = head.next;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.data = null;
            temp.next = null;
            temp = nextNode;
        }
        size = 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    public void addData(T data, int index) {
        rangCheck(index);
        ListNode newNode = new ListNode(data);
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void headAdd(T data) {  //头插法
        addData(data,0);
    }

    public void tailAdd(T data) {  //尾插法
        ListNode temp = head;
        for (int i = 0; i < size; i++) {
            temp = temp.next;
        }
        ListNode newNode = new ListNode(data);
        temp.next = newNode;
        size++;
    }

    private void rangCheck(int index){
        //检查下标是否合法
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("此下标非法！");
        }
    }
}
