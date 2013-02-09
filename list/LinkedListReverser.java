package list;

import java.util.LinkedList;

public class LinkedListReverser<T> {

	LinkedList<T> linkedList;

	public LinkedListReverser(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public LinkedList<T> reverse() {
		
		LinkedList<T> reverseLinkedList = new LinkedList<T>();
		for (int i = linkedList.size() - 1; i > -1; i--) {
			reverseLinkedList.add(linkedList.get(i));
		}

		return reverseLinkedList;
	}
}
