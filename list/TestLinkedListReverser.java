package list;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinkedListReverser {

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
	public void testReverse() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add(el0);
		linkedList.add(el1);
		linkedList.add(el2);
		linkedList.add(el3);
		
		LinkedListReverser<String> linkedListReverser = new LinkedListReverser<String>(
				linkedList);
		LinkedList<String> reverseLinkedList = linkedListReverser.reverse();

		String[] expectedList = { el3, el2, el1, el0 };
		assertArrayEquals(expectedList,
				reverseLinkedList.toArray(new String[0]));
		assertSame(linkedList.getFirst(), reverseLinkedList.getLast());
		assertSame(linkedList.getLast(), reverseLinkedList.getFirst());
	}

}
