package com.assignment;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AssertionDemo {
	
	@Test
	public void booleanconditon() {
		
		int a=3,b=4;
		assertTrue(a<b);
		assertFalse(a>b);
		
	}
	@Test
	public void checknull() {
		String s = null;
		String s1="abc";
		String s2="Abc";
		assertNull(s);
		assertNotNull(s2);
	}
	
	@Test
	public void checksame() {
		
		String s= null;
		String s1 = "abc";
		String s2="abc";
		assertSame(s1, s2);
//		assertNotSame(s1, s2);
	}
	
	@Test
	public void checkequals() {
		
		String s= null;
		String s1 = "abc";
		String s2="abc";
		assertEquals(s1, s2);
//		assertNotEquals(s1, s2);
	}
	
	public void checkArray() {
		
		int[] a= {1,2,3,4};
		int[] b= {1,2,3,4};
		assertArrayEquals(a, b);
//		fail("self failed");
	}
	

}
