package com.andyphan.queue;

import java.util.Arrays;

public class ArrayQueue<T> implements IQueue<T> {

	int capacity;
	static final int DEFAULT_ARRAY_SIZE = 20;
	static final int MAX_ARRAY_SIZE = 100;
	int index;
	T[] myQueue;
	
	public ArrayQueue() {
		this(DEFAULT_ARRAY_SIZE);
	}
	
	public ArrayQueue(int initialCapacity) {
		capacity = initialCapacity;
		this.myQueue = (T[]) new Object[capacity];
		index = 0;
	}

	@Override
	public boolean enqueue(T anEntry) {

		if (anEntry == null)
		{
			return false;
		}
		
		if (index == capacity)
		{
			doubleCapacity();
		}
		
		myQueue[index] = anEntry;	
		index++;
		return true;
	}

	@Override
	public T dequeue() {
		T removedData;
		
		if (isEmpty())
		{
			return null;
		}
		
		removedData = myQueue[0];
		
		index--;
		
		for (int dataIndex = 0; dataIndex < index; dataIndex++)
		{
			myQueue[dataIndex] = myQueue[dataIndex+1];
		}
		
		myQueue[index] = null;
		
		
		return removedData;
	}

	@Override
	public T peek() {

		if (isEmpty())
		{
			return null;
		}
		
		return myQueue[0];
	}

	@Override
	public boolean isEmpty() {
		return myQueue[0] == null;
	}

	@Override
	public int getLength() {
		return capacity;
	}

	@Override
	public void clear() {
		myQueue = (T[]) new Object[capacity];
	}
	
	public void doubleCapacity()
	{
		System.out.println("Increasing array capacity");
		
		int newCapacity = 2 * capacity;

		this.myQueue = Arrays.copyOf(this.myQueue, newCapacity);
		capacity = newCapacity;
	}

}
