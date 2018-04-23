package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.andyphan.linkedlist.CircularLinkedList;

import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class CircularLinkedListTests {
	CircularLinkedList<String> list;
	private String data;

	
	public CircularLinkedListTests(String data) {
		//System.out.println("Constructor");
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		this.data = data;
		
	}
	
	@Parameters
	public static Collection<Object[]> dataStrings() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return Arrays.asList(new Object[][] {
			{""},
			{"morning"},
			{"afternoon"}
		});
	}
	
	@Before
	public void setup() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		list = new CircularLinkedList<>();
	}
	
	//===============================
	// Test Initialization
	//===============================
	
	@Test
	public void testInitialization_IsEmptyMustBeTrue() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		assertTrue("IsEmpty is expected to be true", list.isEmpty());
	}
	
	@Test
	public void testInitialization_GetLengthMustBe0() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		assertEquals("getLength is expected to be 0", 0, list.getLength());
	}
	
	@Test
	public void testInitialization_GetEntryMustBeNull() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		assertNull("getEntry is expected to be null", list.getEntry(1));
	}
	
	//==========================
	// Test General Methods
	//===========================
	
	@Test
	public void testGetEntry_EmptyListReturnsNull() {
		assertNull("getEntry is expected to be null", list.getEntry(0));
	}
	
	@Test 
	public void testGetLength_EmptyListMustBe0() {
		assertEquals("getLength is expected to be 0", 0, list.getLength());
	}
	
	@Test
	public void testIsEmpty_EmptyListMustReturnTrue() {
		assertTrue("isEmpty is expected to return true", list.isEmpty());
	}
	
	//=============================
	// Test Adding One Node
	//=============================

	@Test
	public void testAdd_AddOneNode_IsEmptyMustBeFalse() {
		list.add(data);
		
		assertFalse("isEmpty is expected to be false, but is " + list.isEmpty(), list.isEmpty());
	}
	
	@Test
	public void testAdd_AddOneNode_getLengthMustBeOne() {
		list.add(data);
		
		assertEquals("getLength is expected to be 1, but is " + list.getLength(), 1, list.getLength());
	}
	
	@Test
	public void testAdd_AddOneNode_getEntryReturnSameItem() {
		list.add(data);
		
		assertEquals("getEntry is expected to be " + data + " but is " + list.getEntry(1), data, list.getEntry(1));
	}
	
	//==============================
	// Test Adding Multiple Nodes
	//==============================

	@Test
	public void testAdd_AddMultipleNodes(){
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {				
			list.add(insertedData[i]);
		}
			
		for (int i = 0; i < insertedData.length; i++) {
			assertEquals("Items are not added correctly.", insertedData[i], list.getEntry(i+1));
		}
	}
		
	@Test
	public void testAdd_AddMultipleNodes_IsEmptyMustBeFalse() {
		String[] insertedData = {"", "hi", "hello", "night"};
			
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
			
		assertFalse("isEmpty must be false, but is " + list.isEmpty(), list.isEmpty());
	}
		
	@Test
	public void testAdd_AddMultipleNodes_GetLengthMustBeAmountAdded() {
		String[] insertedData = {"", "hi", "hello", "night"};
			
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
			
		assertEquals("getLength must be " + insertedData.length + " but is " + list.getLength(), insertedData.length, list.getLength());
	}
	
	@Test
	public void testContains_MultipleNodeList_Returntrue() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {				
			list.add(insertedData[i]);
		}
		
		assertTrue("List should contain 'hi'. but does not.", list.contains("hi"));
	}
	
	//=========================================================
	//Adding a node in given position
	//========================================================
	
	@Test
	public void testAdd_AddMultipleNodes_GivenPosition(){
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {				
			list.add(insertedData[i]);
		}
		
		list.add(2, "afternoon");
		
		assertTrue("List should contain 'afternoon'. but does not.", list.contains("afternoon"));
		
	}
	//=========================================
	// Removing a Node in single node list
	//=========================================

	@Test
	public void testRemove_OneNodeList_IsEmptyMustBeTrue() {
		list.add(data);
		list.remove(data);
		
		assertTrue("isEmpty is expected to be true, but is " + list.isEmpty(), list.isEmpty());
	}
	
	@Test
	public void testRemove_OneNodeList_getLengthMustBe0() {
		list.add(data);
		list.remove(data);
		
		assertEquals("getLength is expected to be 0, but is " + list.getLength(), 0, list.getLength());
	}
	
	@Test
	public void testRemove_OneNodeList_getEntryReturnSNull() {
		list.add(data);
		list.remove(data);
		
		assertNull("getEntry is expected to be " + data + " but is " + list.getEntry(1),list.getEntry(1));
	}
	
	//============================================
	// Removing a Node in multiple node list
	//============================================
	
	@Test
	public void testRemove_NodeList_IsEmptyMustBeFalse() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove("hi");
		
		assertFalse("isEmpty is expected to be false, but is " + list.isEmpty(), list.isEmpty());
	}
	
	@Test
	public void testRemove_NodeList_getLengthMustBeReducedBy1() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove("hi");
		
		assertEquals("getLength is expected to be " + (insertedData.length - 1) + ", but is " + list.getLength(), insertedData.length-1, list.getLength());
	}
	
	//============================================
	// Remove node in given position
	//============================================
	
	@Test
	public void testRemove_NodeList_GivenPosition() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.display();
		
		list.remove(3);
		
		assertFalse("'hi' is still contained in the list", list.contains("hi"));
	}
}
