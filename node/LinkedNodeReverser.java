package node;

public class LinkedNodeReverser {

	private Linked head;

	public LinkedNodeReverser(Linked head) {
		this.head = head;
	}

	public Linked getHead() {
		return head;
	}

	public Linked getTail() {
		Linked tail;
		Linked next = head;

		do {
			tail = next;
			next = tail.next();
		} while (null != next);

		return tail;
	}

	private Linked popTail() {

		Linked tail = getTail();

		if (null == tail.before())
			return tail;

		tail.before().setNext(null);
		tail.setBefore(null);

		return tail;
	}

	public void reverse() {

		Linked newHead = popTail();
		if (head.equals(newHead))
			return;

		Linked lastAdded = newHead;

		do {
			lastAdded.setNext(popTail());
			lastAdded = lastAdded.next();

		} while (false == head.equals(lastAdded));

		head = newHead;
	}
}