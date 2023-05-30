package org.accekll.tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: ZKL
 * @CreateTime: 2023/5/30 22:11
 * @Description:
 **/
//@SpringBootTest
public class MTest implements SonClass {

    @Override
    public void test1() {
        SonClass.super.test1();
    }

    @Test
    void test2() {
        test1();
    }
}
