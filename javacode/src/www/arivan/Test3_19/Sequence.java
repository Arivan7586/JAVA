package www.arivan.Test3_19;

public interface Sequence<T> {
    /**
     * 向线性表中添加元素
     * @param data 要添加的元素
     */
    void add(T data);

    /**
     * 在线性表中删除元素
     * @param index 要删除的元素下标
     * @return 返回被删除的元素
     */
    T remove(int index);

    /**
     * 在线性表中查找指定索引的元素
     * @param index 要查找的索引
     * @return
     */
    T get(int index);

    /**
     * 判断线性表中是否有指定元素
     * @param data 要查找的元素内容
     * @return
     */
    boolean contains(T data);

    /**
     * 修改线性表中指定索引的内容
     * @param index 要修改的元素下标
     * @param newData 修改后的内容
     * @return
     */
    T set(int index, T newData);

    /**
     * 返回当前线性表元素个数
     * @return
     */
    int size();

    /**
     * 直接清空线性表内容
     */
    void clear();

    /**
     * 将线性表转为数组
     * @return
     */
    T[] toArray();
}
