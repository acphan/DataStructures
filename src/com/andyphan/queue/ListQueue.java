package com.andyphan.queue;

public class ListQueue<T> implements IQueue<T> {

	private int length = 0;
	Node<T> headNode;
	Node<T> tailNode;
	
	public ListQueue() {
		headNode = new Node<>(null, null);
		tailNode = new Node<>(null, headNode);
		length = 0;
	}
	
	@Override
	public boolean enqueue(T anEntry) {
		Node<T> newNode = new Node<>(anEntry);
		Node<T> nodeBefore = tailNode.getNextNode();
		
		tailNode.setNextNode(newNode);
		newNode.setNextNode(nodeBefore);
		
		if (tailNode.getNextNode() == newNode)
		{
			length++;
			return true;
		}
		
		return false;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
		{
		 return null;
		}
		
		Node<T> removedNode = tailNode;
		Node<T> nodeAfter = null;
		
		 while (removedNode.getNextNode() != headNode)
		 {
			nodeAfter = removedNode; 
			removedNode = removedNode.getNextNode();
		 }
		 
		 nodeAfter.setNextNode(headNode);
		 length--;
		 
		 return removedNode.getData();
	}

	@Override
	public T peek() {
		if (isEmpty())
		{
		 return null;
		}
		
		Node<T> frontNode = tailNode;
		
		while (frontNode.getNextNode() != headNode)
		{
			frontNode = frontNode.getNextNode();
		}
		
		return frontNode.getData();	
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int getLength() {
		return length;
	}
	
	@Override
	public void clear()
	{
		length = 0;
		tailNode.setNextNode(headNode);
	}
	
	private class Node<T>
	{
		T data;
		Node<T> nextNode;
		
		public Node(T data) {
			this.data = data;
		}

		public Node(T data, Node<T> nextNode) {
			this.data = data;
			this.nextNode = nextNode;
		}

		/**
		 * @return the data
		 */
		public T getData() {
			return data;
		}
		/**
		 * @param data the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}
		/**
		 * @return the nextNode
		 */
		public Node<T> getNextNode() {
			return nextNode;
		}
		/**
		 * @param nextNode the nextNode to set
		 */
		public void setNextNode(Node<T> nextNode) {
			this.nextNode = nextNode;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
	}
}
