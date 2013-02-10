package node;

public class CycleDetector {
	private Linked head;

	public CycleDetector(Linked head) {
		this.head = head;
	}

	public Linked getHead() {
		return head;
	}

	public Linked detect() {
		Linked current = head;
		Boolean visited;

		do {
			visited = hasNextBeenVisited(current);
			current = current.next();
		} while (null != current && false == visited);

		if (visited)
			return current;

		return null;
	}

	private Boolean hasNextBeenVisited(Linked parent) {
		Linked needle = parent.next();
		if (null == needle)
			return false;

		Linked current = head;
		Boolean isFound, isEnd;
		do {
			isFound = current.equals(needle);
			isEnd = current.equals(parent);
			current = current.next();
		} while (false == isEnd && false == isFound);

		return isFound;
	}
}