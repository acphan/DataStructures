package com.andyphan.linkedlist;

public class DoubleLinkedList<T> implements ListInterface<T> {

	int count;
	Node<T> firstNode;
	Node<T> lastNode;
	
	public DoubleLinkedList()
	{
		firstNode = new Node(null, null, null);
		lastNode = new Node(null, null, firstNode);
		firstNode.setNextNode(lastNode);
		count = 0;
	}
	
	@Override
	public void add(T newEntry) {
		Node<T> currentNode = firstNode;
		Node<T> prevNode = null;
		
		if (firstNode.getData() == null)
		{
			addStart(newEntry);
		}
		else
		{
			while (currentNode != lastNode) {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
				
			addEnd(newEntry);
		}

	}
	
	public void addStart(T newEntry) {

		Node<T> addedNode = new Node<T>(newEntry);
		
		if (firstNode != null)
		{
			firstNode.setPreviousNode(addedNode);
			addedNode.setNextNode(firstNode);
		}
		
		firstNode = addedNode;

			lastNode = addedNode;

		count++;
	}

	public void addEnd(T newEntry) {

		Node<T> addedNode = new Node<T>(newEntry);
		
		if (lastNode != null)
		{
			lastNode.setNextNode(addedNode);
			addedNode.setPreviousNode(lastNode);
		}
		
		lastNode = addedNode;
		
		if (firstNode == null)
		{
			firstNode = addedNode;
		}
		
		count++;
	}

	@Override
	public boolean add(int newPosition, T newEntry) {
		Node<T> currentNode = firstNode;
		Node<T> prevNode = null;
		int i = 1;
		
		if ((newPosition < 1) || (newPosition > getLength() + 1))
		{
			return false;
		}
		else
		{
			while ( i <= getLength() + 1)
			{
				if (newPosition == i)
				{
					if (newPosition == 1)
					{
						addStart(newEntry);
						return true;
					}
					else if (i == getLength()+1)
					{
						addEnd(newEntry);
						return true;
					}
					else 
					{
						Node<T> addedNode = new Node<>(newEntry);
						addedNode.setNextNode(currentNode);
						prevNode.setNextNode(addedNode);
						
						currentNode.setPreviousNode(addedNode);
						addedNode.setPreviousNode(prevNode);
						count++;
						return true;
					}
				}
				
				prevNode = currentNode;
				currentNode = currentNode.getNext();
				i++;
				
			}
		}
		
		return false;
	}


	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		Node<T> currentNode = firstNode;
		Node<T> prevNode = null;
		
		while (currentNode != null)
		{	
			if (currentNode.getData() == anEntry)
			{
				if (currentNode == firstNode)
				{
					firstNode = currentNode.getNext();
				}
				else if (currentNode == lastNode)
				{
					prevNode.setNextNode(null);
					lastNode = prevNode;
				}
				else
				{
					prevNode.setNextNode(currentNode.getNext());
					currentNode.getNext().setPreviousNode(prevNode);
					currentNode.setPreviousNode(null);
					currentNode.setNextNode(null);
					
				}
				count--;
				return true;
			}
			
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		Node<T> currentNode = firstNode;
		Node<T> prevNode = null;
		int i = 1;
		
		while (currentNode != null)
		{
			if (i == givenPosition)
			{
				if (i == 1)
				{
					firstNode = currentNode.getNext();
				
				}
				else if (i == getLength())
				{
					prevNode.setNextNode(null);
					lastNode = prevNode;
					
				}
				else 
				{
					prevNode.setNextNode(currentNode.getNext());
					currentNode.getNext().setPreviousNode(prevNode);
					currentNode.setPreviousNode(null);
					currentNode.setNextNode(null);
				}
				
				count--;
				return currentNode.getData();
			}
			
			prevNode = currentNode;
			currentNode = currentNode.getNext();
			i++;
		}
		
		return null;
	}

	@Override
	public void clear() {
		firstNode = new Node<>(null, null, null);
		lastNode = new Node<>(null, null, firstNode);
		firstNode.setNextNode(lastNode);
		count = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		Node<T> currentNode = firstNode;
		int i = 1;
		
		if ((givenPosition < 1) || (givenPosition > getLength()))
		{
			return null;
		}
		
		while (currentNode != null)
		{
			if (givenPosition == i)
			{
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
			i++;
		}
		
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		Node<T> currentNode = firstNode;
		
		while (currentNode != null)
		{
			if (currentNode.getData() == anEntry)
			{
				return true;
			}
			
			currentNode = currentNode.getNext();
		}

		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}

	@Override
	public void display() {
		Node<T> currentNode = firstNode;
		
		while (currentNode != null)
		{
			System.out.println(currentNode.getData().toString());
			currentNode = currentNode.getNext();
		}
	}
	
	@Override
	public void displayBackward() 
	{
		_displayBackward(firstNode);
	}

	private void _displayBackward(Node<T> node) {
		if (node == null)
		{
			return;
		}
		else
		{
			_displayBackward(node.getNext());
			System.out.println(node.getData().toString());
		}
	}
	
	private class Node<T>
	{
		private T data;
		private Node<T> next = null;
		private Node<T> previous = null;
			
		Node(T newEntry)
		{
			this(newEntry, null, null);
		}
			
		Node(T newEntry, Node<T> next, Node<T> prev) {
			data = newEntry;
			this.next = next;
			this.previous = prev;
		}
			
		public void setNextNode(Node<T> nextNode)
		{
			next = nextNode;
		}
		
		public Node<T> getNext()
		{
			return next;
		}
	
		public void setPreviousNode(Node<T> previousNode)
		{
			previous = previousNode;
		}

		public Node<T> getPrevious()
		{
			return previous;
		}
			
		public T getData()
		{
			return data;
		}
		
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
}
