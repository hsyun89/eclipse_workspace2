package suyongs_stackqueue;

class LinkedNode {// LinekedList�� �����ϴ� node Ŭ����
	int val;
	LinkedNode next; // ���� node�� ����Ű�� ���� ��ü

	LinkedNode(int val) {
		next = null;
		this.val = val;
	}
}

class LinkedList {
	LinkedNode first; // LinekedList�� ù node
	LinkedNode last; // LinekedList�� ������ node

	LinkedList() {
		first = null;
		last = null;
	}

	protected void addFirst(int val) {
		LinkedList list = new LinkedList();
	}

	protected void addLast(int val) {
		// ���⸦ �����ϼ���
	}

//	protected Boolean removeFirst() {
//		// ���⸦ �����ϼ���
//	}
//
//	protected Boolean removeLast() {
//		// ���⸦ �����ϼ���
//	}

	protected void printList() {
		LinkedNode current = first;
		while (current != null) { // current ��尡 null �ƴҶ� ���� ����
			System.out.println(current.val);
			current = current.next; // next ��带 current�� ���� ����
		}
	}
}

class Queue extends LinkedList {
	Queue() {
		super();
	}

	public void add(int val) {
		super.addLast(val);
	}

	public void remove() {
//		System.out.println("���� ��� : " + super.removeFirst());
	}

	public void printList() {
		System.out.println("----------queue print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}

class Stack extends LinkedList {
	Stack() {
		super(); // LinkedList�� �����ڸ� ����
	}

	public void add(int val) {
		super.addFirst(val);
	}

	public void remove() {
//		System.out.println("���� ��� : " + super.removeFirst());
	}

	public void printList() {
		System.out.println("----------stack print----------");
		super.printList();
		System.out.println("------------------------------");
	}
}

public class Main {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.printList();
		s.remove();
		s.remove();
		s.remove();
		s.printList();

		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.printList();
		q.remove();
		q.remove();
		q.printList();
	}
}
/*
 * -----------����-------------- �������� ��� stack, queue�� ���� ���� 1. ��� : �ڹ� 2. �����
 * �ڷᱸ�� : ���Ḯ��Ʈ
 * 
 * ÷���� Ŭ�������̾�׷� ������ �ҽ��ڵ忡 ÷���� �ּ��� �����ϸ� ���ذ� ��
 * 
 * �� �ڵ带 �� �а� ���ذ� �ȴٸ� �������ϴ� ����! 1. �ڷᱸ���� ���Ḯ��Ʈ 2. �ڹ��� ���ٱ����� 3. �ڹ��� Ŭ������ ��� 4.
 * ���ð� ť ----------------------------
 */