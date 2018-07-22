package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	
	T[] tArray = (T[]) new Object[0];
	
	public ArrayList() {
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		return tArray[loc];
	}
	
	public void add(T val) {
		Object[] temp = new Object[ta.length];
		 for (int j = 0; j < ta.length; j++) {
			temp[j] = ta[j];
		 }
		 ta = (T[]) new Object[ta.length + 1];
		 for (int j = 0; j < temp.length; j++) {
				ta[j] = (T) temp[j];
			 }
		 ta[ta.length - 1] = (T) i;
		 lengthT = ta.length;
		
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		
	}
	
	public boolean contains(T val) {
		
		return false;
	}
}