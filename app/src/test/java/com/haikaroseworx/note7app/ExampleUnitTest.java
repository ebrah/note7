package com.haikaroseworx.note7app;

import com.haikaroseworx.note7app.pojo.PojoForTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkTruth(){
        assertTrue("checking is value is greater than 0",1>0);
    }

    @Test
    public void checkNumber12(){
        assertEquals("Checking is value is 12",PojoForTest.getNumber(),12);
    }

    @Test
    public void additionTest(){
        assertEquals(8,PojoForTest.addNumber(6,2));
    }
}