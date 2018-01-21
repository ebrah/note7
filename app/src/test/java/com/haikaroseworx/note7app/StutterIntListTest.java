package com.haikaroseworx.note7app;


import com.haikaroseworx.note7app.testpackage2.StutterIntList;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StutterIntListTest {
	// Tests that the add method works for a single element.
	@Test
	public void testAdd1() {
    	StutterIntList stut = new StutterIntList(3);
    	stut.add(7);     // [7, 7, 7]
    	assertEquals(3, stut.size());
    	assertEquals(7, stut.get(0));
    	assertEquals(7, stut.get(1));
    	assertEquals(7, stut.get(2));
	}
	
	// Tests that the add method works for many elements and removals.
	@Test
	public void testAdd2() {
    	StutterIntList stut = new StutterIntList(3);
    	stut.add(7);     // [7, 7, 7]
    	stut.add(-1);    // [7, 7, 7, -1, -1, -1]
    	stut.add(2, 5);  // [7, 7, 5, 5, 5, 7, -1, -1, -1]
    	stut.remove(4);  // [7, 7, 5, 5, 7, -1, -1, -1]
    	assertEquals(8, stut.size());
    	assertEquals(7, stut.get(0));
    	assertEquals(7, stut.get(1));
    	assertEquals(5, stut.get(2));
    	assertEquals(5, stut.get(3));
    	assertEquals(7, stut.get(4));
    	assertEquals(-1, stut.get(5));
    	assertEquals(-1, stut.get(6));
    	assertEquals(-1, stut.get(7));
	}
	
	// Tests the basic functionality of the getStretch method.
	@Test
	public void testGetStretch() {
		StutterIntList list1 = new StutterIntList(4);
		assertEquals(4, list1.getStretch());
		StutterIntList list2 = new StutterIntList(777);
		assertEquals(777, list2.getStretch());
	}
	
}
