package linkedList;

/**
 * Implementação de lista duplamente encadeada
 * @author Jonatha Kennedy
 *
 */
public class LinkedList {
	private Node head;

	public LinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	public void addLast(int elemento) {
		if (this.isEmpty()) {
			this.head = new Node(elemento);
		} else {
			this.addLast(this.head, elemento);
		}
	}

	private void addLast(Node node, int elemento) {
		if (node.getNext() == null) {
			Node newNode = new Node(elemento);
			node.setNext(newNode);
			newNode.setPrevious(node);
			return;
		} else {
			addLast(node.getNext(), elemento);
		}
	}

	public int size() {
		if (this.isEmpty()) {
			return 0;
		}
		return size(this.head.getNext());
	}

	private int size(Node node) {
		if (node == null) {
			return 1;
		}
		return 1 + size(node.getNext());
	}

	public int soma() {
		return soma(this.head);
	}

	private int soma(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.getValue() + soma(node.getNext());
		}
	}

	public boolean isSorted() {
		if (this.isEmpty() || this.size() == 1) {
			return true;
		}
		return isSorted(this.head);
	}

	private boolean isSorted(Node node) {
		if (node.getNext() == null) {
			return true;
		} else {
			if (node.getValue() > node.getNext().getValue()) {
				return false;
			} else {
				return isSorted(node.getNext());
			}
		}
	}

	public void add(int index, int elemento) {
		if (index > this.size() || index < 0) {
			return;
		}
		if (!this.isEmpty()) {
			if (index == 0) {
				Node newNode = new Node(elemento);
				newNode.setNext(this.head);
				this.head.setPrevious(newNode);
				this.head = newNode;
				return;
			}

			if (index == this.size()) {
				this.addLast(elemento);
				return;
			}

			int pos = 0;
			Node node = this.head;
			while (pos != index) {
				pos++;
				node = node.getNext();
			}

			Node newNode = new Node(elemento);
			newNode.setNext(node);
			newNode.setPrevious(node.getPrevious());
			newNode.getNext().setPrevious(newNode);
			newNode.getPrevious().setNext(newNode);
		} else {
			this.addLast(elemento);
		}
	}

	public void remove(int index) {
		if (!this.isEmpty()) {

			if (index == 0) {
				this.head = this.head.getNext();
				return;
			}

			int pos = 0;
			Node node = this.head;
			while (pos != index) {
				pos++;
				node = node.getNext();
			}

			if (index == this.size() - 1) {
				node.getPrevious().setNext(null);
				return;
			}

			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
		}
	}

	public String toString() {
		return this.toString(this.head);
	}

	private String toString(Node node) {
		if (node == null) {
			return "";
		} else {
			return node.getValue() + " " + toString(node.getNext());
		}
	}
}
