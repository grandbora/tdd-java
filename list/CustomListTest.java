package list;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		String firstEl = "firstElement";
		customList.add(firstEl);

		String[] expectedList = { firstEl };
		assertArrayEquals(expectedList, customList.toArray(new String[0]));
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

}
