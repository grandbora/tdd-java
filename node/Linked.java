package node;

public interface Linked {
	
	Linked next();
	
	Linked before();
	
	void setNext(Linked linked);
	void setBefore(Linked linked);
}
