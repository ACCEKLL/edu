package org.accekll.tests;

/**
 * @Author: ZKL
 * @CreateTime: 2023/5/30 22:14
 * @Description:
 **/
public interface SonClass extends FatherClass,FatherClass2{

    @Override
     default void test1() {
        System.out.println("sonInterface");

    }
}
