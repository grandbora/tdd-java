package list;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomListTest {

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
	public void testAdd() {
		CustomList<String> customList = new CustomList<String>();
		
		String firstEl = "firstElement"; 
		customList.add(firstEl);
		
		String[] expectedList = {firstEl };
		assertArrayEquals(expectedList , customList.toArray(new String[0]));
	}

}
