package entities;

public class SingleLinkedList {

	private Node firstNode;
	private Node lastNode;
	private int node_counter;

	public void addFirst(Object obj) {
		Node newNode = new Node(firstNode, obj);
		firstNode = newNode;
		if (node_counter == 0)
			lastNode = firstNode;
		node_counter++;
	}

	public void add(Object obj) {
		if (node_counter == 0)
			addFirst(obj);
		else {
			Node newNode = new Node(obj);
			lastNode.setNext(newNode);
			lastNode = newNode;
			node_counter++;
		}
	}

	public void add(int position, Object obj) {
		if (position == 0)
			addFirst(obj);
		else if (position == node_counter)
			add(obj);
		else {
			Node prevNode = getNode(position - 1);
			Node newNode = new Node(prevNode.getNext(), obj);
			prevNode.setNext(newNode);
			node_counter++;
		}
	}

	private boolean busyPosition(int position) {
		return position >= 0 && position < node_counter;
	}

	private Node getNode(int position) {
		if (!busyPosition(position))
			throw new IllegalArgumentException("Invalid Position!");
		Node currentNode = firstNode;
		for (int i = 0; i < position; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	public Object get(int position) {
		return getNode(position).getObject();
	}

	public void removeFirst() {
		if (!busyPosition(0))
			throw new IllegalArgumentException("List is empty!");
		firstNode = firstNode.getNext();
		node_counter--;
		if (node_counter == 0)
			lastNode = null;
	}

	public void removeLast() {
		if (!busyPosition(0))
			throw new IllegalArgumentException("List is empty!");
		else if (node_counter == 1)
			removeFirst();
		else {
			Node currentNode = firstNode;
			while (currentNode.getNext().getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(null);
			lastNode = currentNode;
			node_counter--;
		}
	}

	public void remove(int position) {
		if (!busyPosition(position))
			throw new IllegalArgumentException("Invalid position!");
		if (position == 0)
			removeFirst();
		else if (position == node_counter - 1)
			removeLast();
		else {
			Node currentNode = firstNode;
			for (int i = 0; i < position - 1; i++) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(currentNode.getNext().getNext());
			node_counter--;
		}
	}

	public boolean contains(Object obj) {
		Node currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode.getObject().equals(obj))
				return true;
			currentNode = currentNode.getNext();
		}
		return false;
	}

	public int size() {
		return node_counter;
	}

	@Override
	public String toString() {
		if (node_counter == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node currentNode = firstNode;
		for (int i = 0; i < node_counter - 1; i++) {
			sb.append(currentNode.getObject() + ", ");
			currentNode = currentNode.getNext();
		}
		sb.append(currentNode.getObject() + "]");
		return sb.toString();
	}

}
