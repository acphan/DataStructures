package com.andyphan.hashtable;

import java.util.LinkedList;

public class HashTable {

    public static final int DEFAULT_SIZE = 128;
    private LinkedList<HashedItem>[] hashList = new LinkedList[DEFAULT_SIZE];
 
    public HashTable() {
        for(int i = 0; i < DEFAULT_SIZE; i++) {
        	hashList[i] = null;
        }
    }
 
    private HashedItem getItem(String key) {
        if(key == null) {
            return null;
        }
 
        int index = key.hashCode() % DEFAULT_SIZE;
        LinkedList<HashedItem> hashedItems = hashList[index];
 
        if(hashedItems == null) {
            return null;
        }
 
        for(HashedItem hashedItem : hashedItems) {
            if(hashedItem.key.equals(key))
                return hashedItem;
        }
 
        return null;
    }
 
    public Integer getValue(String key) {
    	HashedItem hashedItem = getItem(key);
 
        if(hashedItem == null) {
            return null;
        }
        else {
            return
            	hashedItem.value;
        }
    }
 
    public void addItem(String key, Integer value) {
        int index = key.hashCode() % DEFAULT_SIZE;
        LinkedList<HashedItem> listItems = hashList[index];
 
        if(listItems == null) {
        	listItems = new LinkedList<HashedItem>();
 
            HashedItem hashedItem = new HashedItem();
            hashedItem.key = key;
            hashedItem.value = value;
 
            listItems.add(hashedItem);
 
            hashList[index] = listItems;
        }
        else {
            for(HashedItem hashedItem : listItems) {
                if(hashedItem.key.equals(key)) {
                	hashedItem.value = value;
                    return;
                }
            }
 
            HashedItem hashedItem = new HashedItem();
            hashedItem.key = key;
            hashedItem.value = value;
 
            listItems.add(hashedItem);
        }
    }
 
    public void deleteItem(String key) {
        int index = key.hashCode() % DEFAULT_SIZE;
        LinkedList<HashedItem> hashedItems = hashList[index];
 
        if(hashedItems == null) {
            return;
        }
 
        for(HashedItem hashedItem : hashedItems) {
            if (hashedItem.key.equals(key)) {
            	hashedItems.remove(hashedItem);
                return;
            }
        }
    }
    
    public static class HashedItem {
        public String key;
        public Integer value;
    }
 
}
