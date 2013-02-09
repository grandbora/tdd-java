package node;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinkedNode {

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
	public void testGetLabel() {
		String label = "node1";
		LinkedNode linkedNode1 = new LinkedNode(label);

		assertSame(label, linkedNode1.getLabel());
	}

	@Test
	public void testNextBeforeWithoutLink() {
		LinkedNode linkedNode1 = new LinkedNode("node1");
		assertNull(linkedNode1.next());
		assertNull(linkedNode1.before());
	}

	@Test
	public void testSetNextWithNode() {
		LinkedNode linkedNode1 = new LinkedNode("node1");
		LinkedNode linkedNode2 = new LinkedNode("node2");

		linkedNode1.setNext(linkedNode2);

		assertSame(linkedNode2, linkedNode1.next());
		assertNull(linkedNode1.before());

		assertSame(linkedNode1, linkedNode2.before());
		assertNull(linkedNode2.next());
	}

	@Test
	public void testSetNextWithNull() {
		LinkedNode linkedNode1 = new LinkedNode("node1");
		LinkedNode linkedNode2 = new LinkedNode("node2");

		linkedNode1.setNext(linkedNode2);
		linkedNode1.setNext(null);

		assertNull(linkedNode1.next());
	}

	@Test
	public void testSetNextMultiple() {
		LinkedNode linkedNode1 = new LinkedNode("node1");
		LinkedNode linkedNode2 = new LinkedNode("node2");
		LinkedNode linkedNode3 = new LinkedNode("node3");
		LinkedNode linkedNode4 = new LinkedNode("node4");
		LinkedNode linkedNode5 = new LinkedNode("node5");

		linkedNode1.setNext(linkedNode2);
		linkedNode2.setNext(linkedNode3);
		linkedNode3.setNext(linkedNode4);
		linkedNode4.setNext(linkedNode5);

		assertNull(linkedNode1.before());
		assertSame(linkedNode2, linkedNode1.next());

		assertSame(linkedNode1, linkedNode2.before());
		assertSame(linkedNode3, linkedNode2.next());

		assertSame(linkedNode2, linkedNode3.before());
		assertSame(linkedNode4, linkedNode3.next());

		assertSame(linkedNode3, linkedNode4.before());
		assertSame(linkedNode5, linkedNode4.next());

		assertSame(linkedNode4, linkedNode5.before());
		assertNull(linkedNode5.next());
	}
}
