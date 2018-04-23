package com.feitian.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: feitian
 * @Date: 2018-04-20  16:53
 * @description:
 */
public class testHQLJoinTest {

    @Test
    public void testLeftJoin() {
        new TestHQLJoin().testLeftJoin();
    }

    @Test
    public void testLeftJoinFetch() {
        new TestHQLJoin().testLeftJoinFetch();
    }

    @Test
    public void testJoin() {
        new TestHQLJoin().testJoin();
    }

    @Test
    public void testImplicitJoin() {
        new TestHQLJoin().testImplicitJoin();
    }
    @Test
    public void testGroup(){
        new TestHQLJoin().testGourp();
    }
}