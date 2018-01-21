package com.haikaroseworx.note7app;


import com.haikaroseworx.note7app.testpackage.MyClass2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MyClass2Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected = IllegalArgumentException.class)
	  public void testExceptionIsThrown() {
	    MyClass2 tester = new MyClass2();
	    tester.multiply(1000, 5);
	  }

	  @Test
	  public void testMultiply() {
	    MyClass2 tester = new MyClass2();
	    assertEquals(50, tester.multiply(10, 5));
	  }

}
