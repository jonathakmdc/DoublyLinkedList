package linkedList;

/**
 * Representa um nó de uma lista duplamente encadeada
 * @author Jonatha Kennedy
 *
 */
public class Node {
	private Node next;
	private Node previous;
	private int value;
	
	public Node(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
