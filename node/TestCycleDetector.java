package node;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCycleDetector {

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
	public void testDetectWithOutCycle() {

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

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertNull(cycleHead);
	}

	@Test
	public void testDetectWithOneElementWithoutCycle() {
		LinkedNode linkedNode0 = new LinkedNode("node0");

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertNull(cycleHead);
	}

	@Test
	public void testDetectWithOneElementWithCycle() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		linkedNode0.setNext(linkedNode0);

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertSame(linkedNode0, cycleHead);
	}

	@Test
	public void testDetectWithTwoElementWithCycle() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNode linkedNode1 = new LinkedNode("node1");
		linkedNode0.setNext(linkedNode1);
		linkedNode1.setNext(linkedNode0);

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertSame(linkedNode0, cycleHead);
	}

	@Test
	public void testDetectWithTwoElementWithCycleLastItemToLinksToSelf() {
		LinkedNode linkedNode0 = new LinkedNode("node0");
		LinkedNode linkedNode1 = new LinkedNode("node1");
		linkedNode0.setNext(linkedNode1);
		linkedNode1.setNext(linkedNode1);

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertSame(linkedNode1, cycleHead);
	}
	
	@Test
	public void testDetectWithCycle() {

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
		linkedNode5.setNext(linkedNode2);

		CycleDetector cycleDetector = new CycleDetector(linkedNode0);
		Linked cycleHead = cycleDetector.detect();
		assertSame(linkedNode2, cycleHead);
	}
}
