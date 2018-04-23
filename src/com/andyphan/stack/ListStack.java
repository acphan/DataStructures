package com.andyphan.stack;

public class ListStack<T> implements IStack<T> {

	Node<T> headNode = null;
	
	public ListStack() {
		
	}
	
	@Override
	public void push(T data) {
		headNode = new Node(data, headNode);
	}

	
	//Big O = 
	@Override
	public T pop() {
		
		Node<T> currentNode = headNode;
		
		if (isEmpty())
		{
			return null;
		}
		else
		{
			headNode = headNode.getNextNode();
		}	
		return currentNode.getData();
	}

	@Override
	public T peek() {
		
		if (isEmpty())
		{
			return null;
		}
	
		return headNode.getData();
	}
	

	@Override
	public boolean isEmpty() {
		return headNode == null;
	}

	@Override
	public void clear() {
		headNode = null;
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
