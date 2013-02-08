package list;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomListTest {

	CustomList<String> customList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customList = new CustomList<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		String el1 = "firstElement1";
		String el2 = "firstElement2";

		customList.add(el1);
		String[] expectedList = { el1 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));

		customList.add(el1);
		String[] expectedList2 = { el1, el1 };
		assertArrayEquals(expectedList2, customList.toArray(new String[0]));

		customList.add(el2);
		String[] expectedList3 = { el1, el1, el2 };
		assertArrayEquals(expectedList3, customList.toArray(new String[0]));
	}

	@Test
	public void testAddWithIndexToEmptyList() {
		String el0 = "firstElement0";
		customList.add(0, el0);

		String[] expectedList = { el0 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
	}

	@Test
	public void testAddWithIndexToEnd() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";
		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(3, el3);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
	}

	@Test
	public void testAddWithIndexToBeginning() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";
		customList.add(0, el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
	}

	@Test
	public void testAddWithIndexToMiddle() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";
		String el4 = "firstElement4";
		customList.add(el0);
		customList.add(el1);
		customList.add(el3);
		customList.add(el4);
		customList.add(2, el2);

		String[] expectedList = { el0, el1, el2, el3, el4 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
	}

	@Test
	public void testAddAllEmptyCollection() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";

		customList.add(el0);
		customList.add(el1);

		ArrayList<String> toBeAddedList = new ArrayList<String>();

		boolean result = customList.addAll(toBeAddedList);

		String[] expectedList = { el0, el1 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertFalse(result);
	}

	@Test
	public void testAddAllToEmptyList() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el0);
		toBeAddedList.add(el1);
		toBeAddedList.add(el2);

		boolean result = customList.addAll(toBeAddedList);

		String[] expectedList = { el0, el1, el2 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testAddAll() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el2);
		toBeAddedList.add(el3);

		boolean result = customList.addAll(toBeAddedList);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testAddAllWithIndexEmptyCollection() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";

		customList.add(el0);
		customList.add(el1);

		ArrayList<String> toBeAddedList = new ArrayList<String>();

		boolean result = customList.addAll(1, toBeAddedList);

		String[] expectedList = { el0, el1 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertFalse(result);
	}

	@Test
	public void testAddAllWithIndexToEmptyList() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el0);
		toBeAddedList.add(el1);

		boolean result = customList.addAll(0, toBeAddedList);

		String[] expectedList = { el0, el1 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testAddAllWithIndexToBeginning() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el2);
		customList.add(el3);

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el0);
		toBeAddedList.add(el1);

		boolean result = customList.addAll(0, toBeAddedList);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testAddAllWithIndexToMiddle() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el3);

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el1);
		toBeAddedList.add(el2);

		boolean result = customList.addAll(1, toBeAddedList);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testAddAllWithIndexToEnd() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);

		ArrayList<String> toBeAddedList = new ArrayList<String>();
		toBeAddedList.add(el2);
		toBeAddedList.add(el3);

		boolean result = customList.addAll(2, toBeAddedList);

		String[] expectedList = { el0, el1, el2, el3 };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
		assertTrue(result);
	}

	@Test
	public void testClear() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);

		customList.clear();

		assertArrayEquals(new String[0], customList.toArray(new String[0]));
	}

	@Test
	public void testContainsOnEmptyList() {
		Boolean result = customList.contains("randomString");
		assertFalse(result);
	}

	@Test
	public void testContainsReturnTrue() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		Boolean result = customList.contains(el2);
		assertTrue(result);
	}

	@Test
	public void testContainsReturnFalse() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		Boolean result = customList.contains("asdfv");
		assertFalse(result);
	}

	@Test
	public void testContainsAllReturnTrue() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		ArrayList<String> needleList = new ArrayList<String>();
		needleList.add(el1);
		needleList.add(el2);

		Boolean result = customList.containsAll(needleList);
		assertTrue(result);
	}

	@Test
	public void testContainsAllReturnFalseSomeDoesNotExist() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		ArrayList<String> needleList = new ArrayList<String>();
		needleList.add(el1);
		needleList.add("dsffsdsdf");
		needleList.add(el2);

		Boolean result = customList.containsAll(needleList);
		assertFalse(result);
	}

	@Test
	public void testContainsAllReturnFalseAllDoesNotExist() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		ArrayList<String> needleList = new ArrayList<String>();
		needleList.add("dsffsdsdf");
		needleList.add("bullShit");

		Boolean result = customList.containsAll(needleList);
		assertFalse(result);
	}

	@Test
	public void testGet() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		String result = customList.get(0);
		assertSame(el0, result);
		result = customList.get(1);
		assertSame(el1, result);
		result = customList.get(2);
		assertSame(el2, result);
		result = customList.get(3);
		assertSame(el3, result);
	}

	@Test
	public void testIndexOfNonExistingElement() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		int result = customList.indexOf("nonExistingObject");
		assertSame(-1, result);
	}

	@Test
	public void testIndexOfExistingElement() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		int result = customList.indexOf(el0);
		assertSame(0, result);
		result = customList.indexOf(el1);
		assertSame(1, result);
		result = customList.indexOf(el2);
		assertSame(2, result);
		result = customList.indexOf(el3);
		assertSame(3, result);
	}

	@Test
	public void testIndexOfExistingElementAddedtwice() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		int result = customList.indexOf(el1);
		assertSame(1, result);
	}

	@Test
	public void testIsEmptyOnNonEmptyList() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		assertFalse(customList.isEmpty());

		customList.clear();
		assertTrue(customList.isEmpty());
	}

	@Test
	public void testIsEmptyOnEmptyList() {
		assertTrue(customList.isEmpty());
	}

	@Test
	public void testLastIndexOfNonExisting() {
		String el0 = "firstElement0";
		String el1 = "firstElement1";
		String el2 = "firstElement2";
		String el3 = "firstElement3";

		customList.add(el0);
		customList.add(el1);
		customList.add(el2);
		customList.add(el3);

		int result = customList.lastIndexOf("nonExistingStrign");
		assertSame(-1, result);
	}

}