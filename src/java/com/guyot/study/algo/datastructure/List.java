package com.guyot.study.algo.datastructure;

import org.omg.CORBA.Object;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 动态数组
 * @date 2020/12/17
 */
public class List<E> implements java.util.List<E> {

    private static final int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    private E[] data;
    private int size;


    public List() {
        this.data = (E[]) new Object[capacity];
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(java.lang.Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public java.lang.Object[] toArray() {
        return new java.lang.Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(java.lang.Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(java.lang.Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public java.util.List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
    
