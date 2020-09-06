package com.guyot.study.algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                //在Put之后，满足这个条件，会删除链表的头结点
                return this.size() > 5;
            }
        };

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
