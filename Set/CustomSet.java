package Set;
import java.util.Arrays;

public class CustomSet {

	private String[] valueList = new String[0];
	
	public CustomSet() {
	}

	public void add(String element) {
		if (true == this.contains(element)) {
			return;
		}
		
		this.valueList = Arrays.copyOf(this.valueList, this.valueList.length + 1);
		this.valueList[this.valueList.length - 1] = element;
	}
	
	public Boolean contains(String element) {
		for (int i = 0; i < this.valueList.length; i++) {
			if (this.valueList[i] == element) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean remove(String element) {
		
		if(false == this.contains(element)) return false;
		
		String[] newValueList = new String[this.valueList.length - 1];
		int newValueListIndex = 0;
		
		for (int i = 0; i < this.valueList.length; i++) {
			if (this.valueList[i] == element) continue;
			newValueList[newValueListIndex] = this.valueList[i];
			newValueListIndex ++;
		}
		
		this.valueList = newValueList;
		return true;
	}
	
	public String[] toArray() {
		return this.valueList.clone();
	}
	
	public void clear() {
		this.valueList = new String[0]; 
	}
	
	public Boolean isEmpty() {
		return this.valueList.length == 0;
	}
	
	public int size() {
		return this.valueList.length;
	}
}