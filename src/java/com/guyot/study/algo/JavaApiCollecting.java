package com.guyot.study.algo;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc java api整理
 * @date 2020/12/14
 */
public class JavaApiCollecting {
    public static void main(String[] args) {
        Set<String> set = getClassDeclaredMethodsNames(Arrays.class);
        set.stream().sorted().forEach((s) -> System.out.println(s));
    }


    public static Set<String> getClassDeclaredMethodsNames(Class<?> clz) {
        Set<String> methods = new HashSet<>();
        if (clz == null) {
            return methods;
        }
        Method[] objClz = clz.getDeclaredMethods();
        for (Method method : objClz) {
            methods.add(method.getName());
        }
        return methods;
    }
}
