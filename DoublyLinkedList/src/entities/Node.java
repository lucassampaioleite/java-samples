package entities;

import java.util.Objects;

public class Node {

	private Node previous;
	private Node next;
	private Object object;

	public Node(Node previous, Node next, Object object) {
		this.previous = previous;
		this.next = next;
		this.object = object;
	}

	public Node(Node next, Object object) {
		this.next = next;
		this.object = object;
	}

	public Node(Object object) {
		this.object = object;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public int hashCode() {
		return Objects.hash(next, object, previous);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(next, other.next) && Objects.equals(object, other.object)
				&& Objects.equals(previous, other.previous);
	}

}
