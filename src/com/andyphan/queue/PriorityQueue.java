package com.andyphan.queue;

import java.util.Arrays;

public class PriorityQueue<T extends Comparable<T>> implements IQueue<T>{

	int capacity;
	static final int DEFAULT_ARRAY_SIZE = 20;
	static final int MAX_ARRAY_SIZE = 100;
	int index;
	T[] myQueue;
	
	public PriorityQueue() {
		this(DEFAULT_ARRAY_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int initialCapacity) {
		capacity = initialCapacity;
		this.myQueue = (T[]) new Comparable[capacity];
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
	
	public Comparable<T> dequeueHighPriority() {
		if (index == 0) return null; 

        int priorityIndex = 0; 

        for (int i=1; i<index; i++) { 
            if (myQueue[i].compareTo (myQueue[priorityIndex]) > 0) { 
            	priorityIndex = i; 
            } 
        } 
        
        Comparable<T> result = myQueue[priorityIndex]; 

        index--; 
        myQueue[priorityIndex] = myQueue[index]; 
        return result; 
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

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		myQueue = (T[]) new Comparable[capacity];
	}
	
	public void doubleCapacity()
	{
		System.out.println("Increasing array capacity");
		
		int newCapacity = 2 * capacity;

		this.myQueue = Arrays.copyOf(this.myQueue, newCapacity);
		capacity = newCapacity;
	}

}
