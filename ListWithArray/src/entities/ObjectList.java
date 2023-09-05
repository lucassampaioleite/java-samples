package entities;

public class ObjectList {

	private Object[] objects;
	private int object_counter = 0;

	public ObjectList(int size) {
		objects = new Object[size];
	}

	public void add(Object obj) {
		objects[object_counter] = obj;
		object_counter++;
	}

	public void add(int position, Object obj) {
		if (!isValidPosition(position))
			throw new IllegalArgumentException("Invalid Position!");
		for (int i = object_counter - 1; i >= position; i -= 1)
			objects[i + 1] = objects[i];
		objects[position] = obj;
		object_counter++;
	}

	private boolean isValidPosition(int position) {
		return position >= 0 && position <= object_counter;
	}

	public Object get(int position) {
		if (!busyPosition(position))
			throw new IllegalArgumentException("Invalid Position!");
		return objects[position];
	}

	private boolean busyPosition(int position) {
		return position >= 0 && position < object_counter;
	}

	public void remove(int position) {
		if (!busyPosition(position))
			throw new IllegalArgumentException("Invalid Position!");
		for (int i = position; i < object_counter - 1; i++)
			objects[i] = objects[i + 1];
		object_counter--;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < object_counter; i++) {
			if (obj.equals(objects[i]))
				return true;
		}
		return false;
	}

	public int size() {
		return object_counter;
	}

	public int limit() {
		return objects.length;
	}

	public String toString() {
		if (object_counter == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < object_counter - 1; i++)
			sb.append(objects[i] + ", ");
		sb.append(objects[object_counter - 1] + "]");
		return sb.toString();
	}

}
