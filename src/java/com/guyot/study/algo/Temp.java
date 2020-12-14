package com.guyot.study.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 迭代器demo
 * @date 2020/11/25
 */
public class Temp {

    public static void main(String[] args) {
        List<String> list = getList();
        List<String> myList = new ArrayList<>(list);
        myList.remove(2);
        for (String s : myList) {
            System.out.println(s);
        }
    }

    public static List<String> getList() {
        return Arrays.asList("a", "b", "c");
    }
}
