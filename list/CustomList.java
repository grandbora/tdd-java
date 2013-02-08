package list;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomList<T> implements List<T> {

	Object[] elementList = new Object[0];

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) {
		return (T[]) elementList;
	}

	@Override
	public boolean add(T e) {
		elementList = Arrays.copyOf(elementList, elementList.length + 1);
		elementList[elementList.length - 1] = e;
		return true;
	}

	@Override
	public void add(int index, T element) {

		Object[] newElementList = new Object[elementList.length + 1];

		for (int i = 0; i < elementList.length; i++)
			newElementList[i < index ? i : i + 1] = elementList[i];

		newElementList[index] = element;

		elementList = newElementList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends T> c) {
		if (c.isEmpty())
			return false;

		Object[] toBeAppended = c.toArray();
		for (int i = 0; i < toBeAppended.length; i++)
			this.add((T) toBeAppended[i]);

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		if (c.isEmpty())
			return false;

		Object[] toBeAppended = c.toArray();
		for (int i = 0; i < toBeAppended.length; i++) {
			this.add(index + i, (T) toBeAppended[i]);
		}

		return true;
	}

	@Override
	public void clear() {
		elementList = new Object[0];
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < elementList.length; i++) {
			if (elementList[i].equals(o))
				return true;
		}

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		Object[] needleList = c.toArray();
		for (int i = 0; i < needleList.length; i++) {
			if (false == this.contains(needleList[i]))
				return false;
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) elementList[index];
	}

	@Override
	public int indexOf(Object o) {

		for (int i = 0; i < elementList.length; i++) {
			if (elementList[i].equals(o))
				return i;
		}

		return -1;
	}

	@Override
	public boolean isEmpty() {
		return 0 == elementList.length;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		return -1;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
