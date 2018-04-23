package com.andyphan.dictionary;

import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {

	private Entry<K, V>[] dictionary;
	private int numberOfEntries;
	private boolean initialized = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static int MAX_CAPACITY = 10000;
	
	public ArrayDictionary() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayDictionary(int initialCapacity) {
		Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
		initialized = true;
	}
	
	@Override
	public V add(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> getValueIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	private class Entry<S, T> {
		private S key;
		private T value;
		
		private Entry(S searchKey, T dataValue) {
			key = searchKey;
			value = dataValue;
		}
		
		private S getKey() {
			return key;
		}
		
		private T getData() {
			return value;
		}
		
		private void setValue(T newValue) {
			value = newValue;
		}
	}

}
