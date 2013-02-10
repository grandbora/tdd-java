package stack;

import java.util.Arrays;

public class CustomStack<T> {

	Object[] elementList = new Object[0];

	public Boolean empty() {
		return 0 == elementList.length;
	}

	public void push(T o) {
		elementList = Arrays.copyOf(elementList, elementList.length + 1);
		elementList[elementList.length - 1] = o;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		T returnValue = (T) elementList[elementList.length - 1];
		elementList = Arrays.copyOf(elementList, elementList.length - 1);
		return returnValue;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) elementList[elementList.length - 1];
	}

	public int search(T o) {
		for (int i = elementList.length - 1; i > -1; i--) {
			if (elementList[i].equals(o))
				return elementList.length - 1 - i;
		}

		return -1;
	}
}
