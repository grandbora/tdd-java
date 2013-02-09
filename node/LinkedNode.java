package node;

public class LinkedNode implements Linked {

	private String label;
	private Linked next;
	private Linked before;

	public LinkedNode(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public Linked next() {
		return next;
	}

	@Override
	public Linked before() {
		return before;
	}

	@Override
	public void setNext(Linked linked) {
		next = linked;
		if (null != linked)
			linked.setBefore(this);
	}

	@Override
	public void setBefore(Linked linked) {
		before = linked;
	}
}
