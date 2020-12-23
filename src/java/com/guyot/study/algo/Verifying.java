package com.guyot.study.algo;

import com.guyot.study.algo.exception.VerifyFailException;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 验证简单想法
 * @date 2020/12/23
 */
public class Verifying {
    public boolean nullInstanceOfSomeType() {
        Object a = (Object) null;
        return a instanceof Object;
    }

    public static void main(String[] args) {

        Verifying verifying = new Verifying();
        if (!verifying.nullInstanceOfSomeType()) {
            throw new VerifyFailException("null is not instance of Object");
        }
    }
}
