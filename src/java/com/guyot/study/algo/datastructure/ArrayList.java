package com.guyot.study.algo.datastructure;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc ADT List implementation using dynamic array inside.
 * Extention:
 * 1.How does equals and hashcode methods work in Java?
 * 2.Similar question on compare and compareTo methods?
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


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            Object ele = data[i];
            if (e == null && ele == null) {
                return true;
            } else {
                if (e.equals(ele)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param i
     * @param e exam: 1,2,3,4,5
     */
    public boolean add(int i, E e) {
        if (i > size || i < 0) {
            throw new IllegalArgumentException("下标不合法: " + i);
        }
        ensureCapacity();
        for (int j = size - 1; j >= i; j--) {
            data[j + 1] = data[j];
        }
        data[i] = e;
        size++;
        return true;
    }


    public boolean add(E e) {
        return this.add(this.size, e);
    }

    public boolean remove(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(int i) {
        checkIndex(i);
        for (int j = i; j < size; j++) {
            data[j] = data[j + 1];
        }
        size--;
        return true;
    }

    public E get(int i) {
        checkIndex(i);
        return (E) data[i];
    }


    public boolean set(int i, E e) {
        checkIndex(i);
        data[i] = e;
        return true;
    }


    private void checkIndex(int i) {
        if (i >= size || i < 0) {
            throw new IllegalArgumentException("下标不合法: " + i);
        }
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            final int newCap = this.capacity * 2;
            Object[] array = new Object[newCap];
            for (int i = 0; i < size; i++) {
                array[i] = this.data[i];
            }
            this.data = array;
            this.capacity = newCap;
        }
    }
}

