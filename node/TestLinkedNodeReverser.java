package node;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestLinkedNodeReverser {

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
	public void testGetHead() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);
		assertSame(linkedNode0, linkedNodeReverser.getHead());
	}

	@Test
	public void testGetTailWithMockedObjects() {
		
		LinkedNode linkedNode0 = Mockito.mock(LinkedNode.class);
		Mockito.when(linkedNode0.next()).thenReturn(null);

		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);

		assertSame(linkedNode0, linkedNodeReverser.getTail());
	}
	
	@Test
	public void testGetTail() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNode linkedNode1 = new LinkedNode("node1");
		LinkedNode linkedNode2 = new LinkedNode("node2");
		LinkedNode linkedNode3 = new LinkedNode("node3");
		LinkedNode linkedNode4 = new LinkedNode("node4");
		LinkedNode linkedNode5 = new LinkedNode("node5");

		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);
		assertSame(linkedNode0, linkedNodeReverser.getTail());

		linkedNode0.setNext(linkedNode1);
		assertSame(linkedNode1, linkedNodeReverser.getTail());

		linkedNode1.setNext(linkedNode2);
		assertSame(linkedNode2, linkedNodeReverser.getTail());

		linkedNode2.setNext(linkedNode3);
		assertSame(linkedNode3, linkedNodeReverser.getTail());

		linkedNode3.setNext(linkedNode4);
		assertSame(linkedNode4, linkedNodeReverser.getTail());

		linkedNode4.setNext(linkedNode5);
		assertSame(linkedNode5, linkedNodeReverser.getTail());
	}

	@Test
	public void testReverseOneNode() {
		LinkedNode linkedNode0 = new LinkedNode("node0");

		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);
		linkedNodeReverser.reverse();

		assertSame(linkedNode0, linkedNodeReverser.getHead());
		assertSame(linkedNode0, linkedNodeReverser.getTail());
		assertNull(linkedNode0.before());
		assertNull(linkedNode0.next());
	}

	@Test
	public void testReverseTwoNodes() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNode linkedNode1 = new LinkedNode("node1");

		linkedNode0.setNext(linkedNode1);

		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);
		linkedNodeReverser.reverse();

		assertSame(linkedNode1, linkedNodeReverser.getHead());
		assertSame(linkedNode0, linkedNodeReverser.getTail());

		assertNull(linkedNode1.before());
		assertSame(linkedNode0, linkedNode1.next());

		assertSame(linkedNode1, linkedNode0.before());
		assertNull(linkedNode0.next());

	}

	@Test
	public void testReverseMultipleNodes() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNode linkedNode1 = new LinkedNode("node1");
		LinkedNode linkedNode2 = new LinkedNode("node2");
		LinkedNode linkedNode3 = new LinkedNode("node3");
		LinkedNode linkedNode4 = new LinkedNode("node4");
		LinkedNode linkedNode5 = new LinkedNode("node5");

		linkedNode0.setNext(linkedNode1);
		linkedNode1.setNext(linkedNode2);
		linkedNode2.setNext(linkedNode3);
		linkedNode3.setNext(linkedNode4);
		linkedNode4.setNext(linkedNode5);

		LinkedNodeReverser linkedNodeReverser = new LinkedNodeReverser(
				linkedNode0);
		linkedNodeReverser.reverse();
		
		assertSame(linkedNode5, linkedNodeReverser.getHead());
		assertSame(linkedNode0, linkedNodeReverser.getTail());

		assertNull(linkedNode5.before());
		assertSame(linkedNode4, linkedNode5.next());

		assertSame(linkedNode5, linkedNode4.before());
		assertSame(linkedNode3, linkedNode4.next());

		assertSame(linkedNode4, linkedNode3.before());
		assertSame(linkedNode2, linkedNode3.next());

		assertSame(linkedNode3, linkedNode2.before());
		assertSame(linkedNode1, linkedNode2.next());

		assertSame(linkedNode2, linkedNode1.before());
		assertSame(linkedNode0, linkedNode1.next());

		assertSame(linkedNode1, linkedNode0.before());
		assertNull(linkedNode0.next());
	}
}