package com.guyot.study.algo.datastructure;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 动态数组
 * @date 2020/12/17
 */
public class ArrayList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    private Object[] data;
    private int size;

    public ArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * @param i
     * @param e
     * exam: 1,2,3,4,5
     */
    public void add(int i, E e) {
        if (i > size) {
            throw new IllegalArgumentException("下标越界");
        }
        ensureCapacity();
        for (int j = size - 1; j >= i; j++) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
    }


    public void add(E e) {
        this.add(this.size, e);
    }

    public void remove(E e) {

    }

    public void remove(int i) {

    }

    public E get(int i) {
        return null;
    }

    public void set(int i, E e) {

    }


    private void ensureCapacity() {
        if (size >= capacity) {
            final int newCap = this.capacity * 2;
            java.lang.Object[] array = new Object[newCap];
            for (int i = 0; i < size; i++) {
                array[i] = this.data[i];
            }
            this.data = array;
            this.capacity = newCap;
        }
    }

    public static <E> void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        for (int i = 0; i < list.size; i++) {
            System.out.println(list.data[i]);
        }
    }

}

