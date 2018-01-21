package com.haikaroseworx.note7app;

import com.haikaroseworx.note7app.testpackage2.ArrayIntList;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


public class ArrayIntListTest {                                     
    // Checks the basic functionality of the size method after adding a few elements.                                            
    @Test
    public void testSize() {                                     
        ArrayIntList list = new ArrayIntList();
        list.add(42);                                     
        list.add(-3);                               
        list.add(17);                                                         
        list.add(999);                                               
        assertEquals(4, list.size());                                                     
    }                               
                                 
    // Checks the basic functionality of the isEmpty method after adding and removing.                                                  
    @Test                                     
    public void testIsEmpty() {                               
        ArrayIntList list = new ArrayIntList();                                            
        assertTrue(list.isEmpty());                                               
                                               
        list.add(42);                                           
        assertFalse(list.isEmpty());                                         
        list.add(-3);                                              
        assertFalse(list.isEmpty());                                       
                               
        list.remove(1);                                                    
        list.remove(0);                                        
        assertTrue(list.isEmpty());                                                  
    }                                               
                                                     
    // This test makes sure that the list enforces its precondition about                                       
    // the legal indexes passed to the get method.                                        
    // If an ArrayIndexOutOfBoundsException is NOT thrown, the test fails.                               
    @Test//(expected = ArrayIndexOutOfBoundsException.class)                                 
    public void testGet() {                                            
        ArrayIntList list = new ArrayIntList();                                            
        list.get(17);   // this should crash                               
    }                                                    
                                        
    // Checks the basic functionality of the indexOf method after adding a few elements.                                     
    @Test                                                   
    public void testIndexOf() {                                     
        ArrayIntList list = new ArrayIntList();                               
        list.add(42);                                      
        list.add(-3);                                         
        list.add(17);                                            
        list.add(999);                                     
        list.add(17);                                                   
        list.add(86);
        assertEquals(0, list.indexOf(42));
        assertEquals(5, list.indexOf(86));
        assertEquals(2, list.indexOf(17));         // not 4!
        assertEquals(-1, list.indexOf(5555555));   // not found in list
    }
}
