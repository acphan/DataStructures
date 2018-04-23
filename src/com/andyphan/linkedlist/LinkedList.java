/**
 * 
 */
package com.andyphan.linkedlist;

/**
 * @author acpha
 * @param <T>
 *
 */
public class LinkedList<T> implements ListInterface<T> {

	private int length = 0;
	private Node<T> headNode = null;
	
	public LinkedList() {
	}

	@Override
	public void add(T newEntry) {
		
		Node<T> currentNode = headNode;
		Node<T> newNode = new Node<>(newEntry);
		
		if (newNode.getData() == null)
		{
			return;
		}
		else if (headNode == null)
		{
			headNode = newNode;
		}
		else 
		{
			while (currentNode.getNextNode() != null)
			{
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
		
		length++;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		
		Node<T> currentNode = headNode;
		Node<T> newNode = new Node<>(newEntry);
		Node<T> prevNode = null;
		int i = 1;
		boolean status = false;
		
		if (newEntry == null)
		{
			return false;
		}
		else if ((newPosition < 1) || (newPosition > getLength() + 1))
		{
			status = false;
		}
		else
		{
			while (i <= length)
			{
				if (newPosition == i)
				{
					if (i == 1)
					{
						newNode.setNextNode(headNode);
						headNode = newNode;
						length++;
						return true;
					}
					
					else
					{
						prevNode.setNextNode(newNode);	
						newNode.setNextNode(currentNode);
						length++;
						return true;
					}	
				}
				prevNode = currentNode;
				currentNode = currentNode.getNextNode();
				i++;
			}
		}
		
		return status;
	}

	@Override
	public boolean remove(T anEntry) {
		
		Node<T> currentNode = headNode;
		Node<T> prevNode = null;
		
		while (currentNode != null)
		{
			if (currentNode.getData().equals(anEntry)) 
			{
				if (currentNode == headNode)
				{
					headNode = headNode.getNextNode();
					length--;
					return true;
				}
				else 
				{
					prevNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(null);
					length--;
					return true;
				}
			}
			
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		
		Node<T> currentNode = headNode;
		Node<T> prevNode = null;
		int i = 1;
		
		if ((givenPosition < 1) || (givenPosition > getLength()))
		{
			return null;
		}
		
		
		while (currentNode != null)
		{
			if (givenPosition == i)
			{
				if (i == 1)
				{
					headNode = headNode.getNextNode();
					length--;
					return currentNode.getData();
				}
				else
				{
					prevNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(null);
					length--;
					return currentNode.getData();
				}
			}
			
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
			i++;
		}
		
		return null;
		
	}

	@Override
	public void clear() {
		headNode = null;
		length = 0;
		
	}

	@Override
	public T getEntry(int givenPosition) {

		Node<T> currentNode = headNode;
		int nodePosition = 1;
		
		if (givenPosition < 1 || givenPosition > getLength())
		{
			return null;
		}
		else {
			while (nodePosition != givenPosition) {
				currentNode = currentNode.getNextNode();
				nodePosition++;
			}
		}
		
		return currentNode.getData();
	}

	@Override
	public boolean contains(T anEntry) {
		Node<T> currentNode = headNode;
		
		while (currentNode != null)
		{
			if (currentNode.getData().equals(anEntry))
			{
				return true;
			}
			
			currentNode = currentNode.getNextNode();
		}

		return false;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public boolean isEmpty() {
	
		return headNode == null;
	}

	@Override
	public void display() {
		Node<T> currentNode = headNode;
		
		while (currentNode != null)
		{
			System.out.println(currentNode.getData().toString());
			currentNode = currentNode.getNextNode();
		}
	}
	
	@Override
	public void displayBackward() 
	{
		_displayBackward(headNode);
	}

	
	private void _displayBackward(Node<T> node) {
		if (node == null)
		{
			return;
		}
		else
		{
			_displayBackward(node.getNextNode());
			System.out.println(node.getData().toString());
		}
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
