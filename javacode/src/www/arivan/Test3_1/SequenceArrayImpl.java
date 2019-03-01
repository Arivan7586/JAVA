package www.arivan.Test3_1;

import java.util.Arrays;

/**
 * 支持动态扩容的线性表（数组实现）
 */

public class SequenceArrayImpl implements Sequence {
    private Object[] elementData; //存放元素的对象数组
    private final static Integer DEFAULT_CAPACITY = 10; //默认容量
    private int size; //存放的元素个数
    private final static int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; //线性表的最大容量

    public SequenceArrayImpl() {
        //初始化存储元素数组，初始化为10
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public SequenceArrayImpl(int capaCity){
        if (capaCity > 0) {
            this.elementData = new Object[capaCity];
        }
    }

    @Override
    public void add(Object data) {
        //首先判断添加元素是否会导致数组越界
        //若越界先进行扩容，而后存储元素
        ensureCapacity(size+1);
        elementData[size++] = data;
    }

    @Override
    public Object remove(int index) {
        //在线性表中删除元素
        rangCheck(index);
        //取得修改前的内容
        Object oldData = elementData[index];
        //需要移动的元素个数
        int moveSize = size - index - 1;
        if (moveSize > 0) {
            System.arraycopy(elementData,index+1,elementData,index,moveSize);
        }
        elementData[--size] = null;
        //返回被删除的元素
        return oldData;
    }

    @Override
    public Object get(int index) {
        //在线性表中查找指定索引的元素
        rangCheck(index);
        return elementData[index];
    }

    @Override
    public boolean contains(Object data) {
        //判断线性表中是否有指定元素
        if (data == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (data.equals(elementData[i])) {  //data.equals(elementData[i])，此写法用于防止出现空指针异常
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangCheck(index);
        //取得修改之前的内容
        Object oldData = elementData[index];
        elementData[index] = newData;
        return oldData;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    private void ensureCapacity(int minCap){
        //确保当前数组内部容量够用
        if (minCap - elementData.length > 0) { //大于零，表示不够用，越界
            grow(minCap);
        }
    }

    private void grow(int minCap){
        //数组扩容
        int oldCap = elementData.length;
        int newCap = oldCap << 1; //将原来的数组长度扩容两倍
        if (newCap - minCap < 0) {
            newCap = minCap;
        }
        if (newCap - MAX_ARRAY_SIZE > 0) {
            throw new ArrayIndexOutOfBoundsException("超过数组最大阈值！");
        }
        //数组扩容
        elementData = Arrays.copyOf(elementData,newCap);
    }

    private void rangCheck(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下表不存在！");
        }
    }
}