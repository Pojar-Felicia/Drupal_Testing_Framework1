package com.pentalog.core;

import org.testng.Assert;

public class LoggingAssert {

    public static void assertTrue(boolean value, String msg){
        System.out.println(msg);
        Assert.assertTrue(value, msg);
    }

    public static void assertEquals(String v1, String v2){
        System.out.printf("Check 2 values if contains%nExpected:\t'%s'%nActual:\t\t'%s'%n", v1, v2);
        Assert.assertEquals(v1, v2);
    }


}
