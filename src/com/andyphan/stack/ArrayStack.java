package com.andyphan.stack;

import java.util.Arrays;

public class ArrayStack<T> implements IStack<T>
{
	int capacity;
	static final int DEFAULT_ARRAY_SIZE = 20;
	static final int MAX_ARRAY_SIZE = 100;
	int topIndex;
	T[] myStack;
	
	public ArrayStack()
	{
		this(DEFAULT_ARRAY_SIZE);
	}
	
	public ArrayStack(int initialCapacity)
	{
		capacity = initialCapacity;
		this.myStack = (T[]) new Object[capacity];
		topIndex = -1;
	}
	
	@Override
	public void push(T data) {
		
		if (topIndex == capacity - 1)
		{
			doubleCapacity();
		}
		
		topIndex++;
		myStack[topIndex] = data;
		
	}
	
	public void doubleCapacity()
	{
		System.out.println("Increasing array capacity");
		
		int newCapacity = 2 * capacity;

		this.myStack = Arrays.copyOf(this.myStack, newCapacity);
		capacity = newCapacity;
	}

	@Override
	public T pop() {

		T data;
		
		if (isEmpty())
		{
			return null;
		}
		
		data = myStack[topIndex];
		myStack[topIndex] = null;
		topIndex--;
		
		return data;
		
	}

	@Override
	public T peek() {

		if (isEmpty())
		{
			return null;
		}
		
		return myStack[topIndex];
	}

	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	@Override
	public void clear()
	{
		if (topIndex != -1)
		{
			pop();
			clear();
		}
	}
	
	public int getCapacity() {
		return capacity;
	}

}
