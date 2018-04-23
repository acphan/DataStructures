package com.andyphan.queue;

public interface IQueue<T> {

	public boolean enqueue(T anEntry);
	
	public T dequeue();
	
	public T peek();
	
	public boolean isEmpty();
	
	public int getLength();
	
	public void clear();
}

