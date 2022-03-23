package com.rwoo.test.rwdatabasedemo.misc;

import com.rwoo.rwdatabasedemo.misc.MyMath;

import org.junit.jupiter.api.*;

import static org.testng.Assert.assertEquals;

public class MyMathTest {
    @BeforeEach
    public void before(){
        System.out.println("Before");
    }

    @AfterEach
    public void after(){
        System.out.println("After");
    }

    @BeforeAll
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Test
    public void test(){
        int myNumber[] = {1,2,3};
        int result;
        int expected = 6;

        System.out.println("test");

        MyMath myMath = new MyMath();
        result = myMath.sum(myNumber);

        assertEquals(expected, result);

    }

}
