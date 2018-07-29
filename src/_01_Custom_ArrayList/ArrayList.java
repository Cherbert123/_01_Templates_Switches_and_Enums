package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList<T> {

	T[] tArray = (T[]) new Object[0];

	public ArrayList() {
	}

	public T get(int loc) throws IndexOutOfBoundsException {
		return tArray[loc];
	}

	public void add(T val) {
		Object[] temp = new Object[tArray.length];
		for (int j = 0; j < tArray.length; j++) {
			temp[j] = tArray[j];
		}
		tArray = (T[]) new Object[tArray.length + 1];
		for (int j = 0; j < temp.length; j++) {
			tArray[j] = (T) temp[j];
		}
		tArray[tArray.length - 1] = (T) val;

	}

	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		Object[] temp = new Object[tArray.length + 1];
		for (int i = 0; i < loc; i++) {
			temp[i] = tArray[i];
		}
		temp[loc] = val;
		for (int i = loc + 1; i < temp.length; i++) {
			temp[i] = tArray[i - 1];
		}
		tArray = (T[]) temp;
	}

	public void set(int loc, T val) throws IndexOutOfBoundsException {
		tArray[loc] = val;
	}

	public void remove(int loc) throws IndexOutOfBoundsException {

		T[] aRay = (T[]) new Object[tArray.length - 1];
		for (int j = 0; j < loc; j++) {
			aRay[j] = tArray[j];
		}
		int ctr = loc;
		for (int j2 = loc + 1; j2 < tArray.length; j2++) {
			aRay[ctr++] = tArray[j2];
		}
		tArray = aRay;
	}

	public boolean contains(T val) {
		boolean contain = false;
		for (int i = 0; i < tArray.length; i++) {
			if (tArray[i] == val) {
				contain = true;
			}
		}
		return contain;
	}
}