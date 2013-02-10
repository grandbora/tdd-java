package stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCustomStack {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsMepty() {
		CustomStack<String> customStack = new CustomStack<String>();
		assertTrue(customStack.empty());
		customStack.push("element1");
		assertFalse(customStack.empty());
		customStack.pop();
		assertTrue(customStack.empty());
	}

	@Test
	public void testPushPop() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		CustomStack<String> customStack = new CustomStack<String>();

		customStack.push(el0);
		assertSame(el0, customStack.pop());
		customStack.push(el0);
		customStack.push(el0);
		assertSame(el0, customStack.pop());
		customStack.push(el1);
		customStack.push(el2);
		customStack.push(el3);
		customStack.push(el1);
		assertSame(el1, customStack.pop());
		assertSame(el3, customStack.pop());
		assertSame(el2, customStack.pop());
		assertSame(el1, customStack.pop());
		assertSame(el0, customStack.pop());
		assertTrue(customStack.empty());
	}

	@Test
	public void testPeek() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		CustomStack<String> customStack = new CustomStack<String>();

		customStack.push(el0);
		assertSame(el0, customStack.peek());
		customStack.push(el1);
		assertSame(el1, customStack.peek());
		customStack.push(el2);
		assertSame(el2, customStack.peek());
		customStack.push(el3);
		assertSame(el3, customStack.peek());
		customStack.push(el1);
		assertSame(el1, customStack.peek());
		customStack.pop();
		assertSame(el3, customStack.peek());
		customStack.pop();
		assertSame(el2, customStack.peek());
		customStack.pop();
		assertSame(el1, customStack.peek());
		customStack.pop();
		assertSame(el0, customStack.peek());
	}
	
	public void testSearchOnEmpryStack() {
		CustomStack<String> customStack = new CustomStack<String>();
		assertSame(-1, customStack.search("ahoyARandomString"));
	}

	
	@Test
	public void testSearch() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		CustomStack<String> customStack = new CustomStack<String>();

		customStack.push(el0);
		customStack.push(el1);
		customStack.push(el2);
		customStack.push(el3);
		
		assertSame(3, customStack.search(el0));
		assertSame(2, customStack.search(el1));
		assertSame(1, customStack.search(el2));
		assertSame(0, customStack.search(el3));
		assertSame(-1, customStack.search("nonExisting1"));
		
		customStack.push(el3);
		customStack.push(el2);
		customStack.push(el0);
		customStack.push(el1);
		
		assertSame(1, customStack.search(el0));
		assertSame(0, customStack.search(el1));
		assertSame(2, customStack.search(el2));
		assertSame(3, customStack.search(el3));
		assertSame(-1, customStack.search("nonExisting2"));
		
		customStack.pop();
		customStack.pop();
		
		assertSame(5, customStack.search(el0));
		assertSame(4, customStack.search(el1));
		assertSame(0, customStack.search(el2));
		assertSame(1, customStack.search(el3));
		assertSame(-1, customStack.search("nonExisting3"));
		
		customStack.pop();
		customStack.pop();
		customStack.pop();
		customStack.pop();
		
		assertSame(1, customStack.search(el0));
		assertSame(0, customStack.search(el1));
		assertSame(-1, customStack.search(el2));
		assertSame(-1, customStack.search(el3));
	}
}
