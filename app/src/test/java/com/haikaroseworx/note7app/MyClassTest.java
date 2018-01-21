package com.haikaroseworx.note7app;

import com.haikaroseworx.note7app.testpackage.MyClass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyClassTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is before class creation");
    }

	int[] a;
	@Before
	public void setUp() throws Exception {
		a = new int[] {2,3,4};
		System.out.println("Hello this is before , the setup!!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Hello there this is after");
	}

	@Test
	public final void testSearch() {
		boolean val = new MyClass().search(a,3);
		assertTrue(val);
	}

	@Test
	public final void testSearchNoItem() {
		boolean val = new MyClass().search(a,5);
		assertFalse(val);
	}

	@Test
	public void testArrayCounts(){
		assertEquals(3,a.length);
	}

}
