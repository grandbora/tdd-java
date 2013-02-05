package Set;
import static org.junit.Assert.*;
import org.junit.Test;

public class CustomSetTest {

	@Test
	public void testEmptySet() {
		CustomSet customSet = new CustomSet();
		assertArrayEquals(new String[0], customSet.toArray());
	}
	
	@Test
	public void testAddOneElement() {
		String elementOne = "elementOne"; 
		String[] expectedArray = {elementOne};
		
		CustomSet customSet = new CustomSet();
		customSet.add(elementOne);
		
		assertArrayEquals(expectedArray, customSet.toArray());
	}
	
	@Test
	public void testAddSameElement() {
		String elementOne = "elementOne"; 
		String[] expectedArray = {elementOne};
		
		CustomSet customSet = new CustomSet();
		customSet.add(elementOne);
		customSet.add(elementOne);
		
		assertArrayEquals(expectedArray, customSet.toArray());
	}
	
	@Test
	public void testContains() {
		String el1 = "asd1";
		String el2 = "asd2";
		String el3 = "asd3";
		String el4 = "asd4";
		
		CustomSet customSet = new CustomSet();
		customSet.add(el1);
		customSet.add(el2);
		customSet.add(el3);
		
		assertTrue(customSet.contains(el1));
		assertTrue(customSet.contains(el3));
		assertFalse(customSet.contains(el4));
	}
	
	@Test
	public void testRemoveNonExisting() {
		CustomSet customSet = new CustomSet();
		assertFalse(customSet.remove("hereme"));
	}
	
	@Test
	public void testRemoveExisting() {
		String el1 = "asd1";
		String el2 = "asd2";
		String el3 = "asd3";
		
		CustomSet customSet = new CustomSet();
		customSet.add(el1);
		customSet.add(el2);
		customSet.add(el3);
		
		String[] expected = {el1, el3};
		assertTrue(customSet.remove(el2));
		assertArrayEquals(expected , customSet.toArray());
	}
	
	@Test
	public void testRemoveOnlyItem() {
		String el1 = "asd1";
		
		CustomSet customSet = new CustomSet();
		customSet.add(el1);
		
		assertTrue(customSet.remove(el1));
		assertArrayEquals(new String[0], customSet.toArray());
	}
	
	@Test
	public void testClear() {
		CustomSet customSet = new CustomSet();
		customSet.add("sdfsg");
		customSet.add("sdfsg2");
		customSet.add("2ter");
		
		customSet.clear();
		
		String[] expectedArray = {};
		assertArrayEquals(expectedArray, customSet.toArray());
	}
	
	@Test
	public void testIsEmpty() {
		String el1 = "asd1";
		String el2 = "asd2";
		String el3 = "asd3";
		
		CustomSet customSet = new CustomSet();
		
		assertTrue(customSet.isEmpty());
		
		customSet.add(el1);
		customSet.add(el2);
		customSet.add(el3);
		
		assertFalse(customSet.isEmpty());
	}
	
	@Test
	public void testIsSize() {
		String el1 = "asd1";
		String el2 = "asd2";
		String el3 = "asd3";
		
		CustomSet customSet = new CustomSet();
		assertEquals(0, customSet.size());
		
		customSet.add(el1);
		customSet.add(el2);
		customSet.add(el3);
		
		assertEquals(3, customSet.size());
	}
}