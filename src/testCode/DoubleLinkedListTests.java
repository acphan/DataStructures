package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.andyphan.linkedlist.DoubleLinkedList;

@RunWith(value = Parameterized.class)
public class DoubleLinkedListTests {
	DoubleLinkedList<String> list;
	private String data;

	
	public DoubleLinkedListTests(String data) {
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
		list = new DoubleLinkedList<>();
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

	
		assertEquals("getEntry is expected to be " +  data + ", but is " + list.getEntry(1), data, list.getEntry(1));
	}
	
	@Test
	public void testAdd_AddOneNode_ContainsMustBeTrue() {
		list.add(data);
		
		assertTrue("Contains should be true, but is false", list.contains(data));
	}
	
	//=============================
	// Test Adding Node at Start
	//=============================

	@Test
	public void testAdd_AddNodeAtStart_getEntryReturnSameItem() {
		list.add("");
		list.addStart("hi");
		
		assertEquals("getEntry is expected to be 'hi', but is " + list.getEntry(1), "hi", list.getEntry(1));
	}
	
	@Test
	public void testAdd_AddNodeAtStart_getLengthMustBeTwo() {
		list.add("");
		list.addStart("hi");
		
		assertEquals("getLength is expected to be 2, but is " + list.getLength(), 2, list.getLength());
	}
	
	//=============================
	// Test Adding Node at End
	//=============================

	@Test
	public void testAdd_AddNodeAtEnd_getEntryReturnSameItem() {
		list.add("");
		list.addEnd("hi");
		
		assertEquals("getEntry is expected to be 'hi', but is " + list.getEntry(2), "hi", list.getEntry(2));
	}
	
	@Test
	public void testAdd_AddNodeAtEnd_getLengthMustBeTwo() {
		list.add("");
		list.addEnd("hi");
		
		assertEquals("getLength is expected to be 2, but is " + list.getLength(), 2, list.getLength());
	}
	
	
	//=====================================================
	// Clearing List of Multiple Items
	//=====================================================
	
	@Test
	public void testClear_IsEmptyMustBeTrue() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.clear();
		
		assertTrue("isEmpty must be true, but is " + list.isEmpty(), list.isEmpty());
	}
	
	@Test
	public void testClear_GetLengthMustBe0() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		list.clear();
		
		assertEquals("getLength must be 0, but is " + list.getLength(), 0, list.getLength());
	}
	
	@Test
	public void testClear_GetEntryMustBeNull() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		list.clear();
		
		assertNull("getEntry must be null, but is " + list.getEntry(1), list.getEntry(1));
	}
	
	//================================================
	// Adding Node in Position
	//================================================

	@Test
	public void testAdd_WithPosition_GetLengthMustBeAmountAdded() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.add(2, data);
		
		assertEquals("getLength must be " + list.getLength(), insertedData.length + 1, list.getLength());

	}
	
	@Test
	public void testAdd_WithPosition_GetEntryInPositionMustReturnAddedItem() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.add(2, data);
		assertEquals("Item was not added correctly.", data, list.getEntry(2));
	}
	
	//==============================================
	// Removing A Node From Single Node List
	//==============================================
	
	@Test 
	public void testRemove_SingleNodeList() {
		list.add("midnight");
		list.remove("midnight");
		
		assertNull("GetEntry is expected to be null, but is " + list.getEntry(1), list.getEntry(1));
	}
	@Test
	public void testRemove_SingleNodeListIsEmptyBecomesTrue() {
		list.add("midnight");
		list.remove("midnight");
		
		assertTrue("isEmpty is expected to be true, but is " + list.isEmpty(), list.isEmpty());
	}
	
	@Test
	public void testRemove_SingleNodeListGetLengthBecomes0() {
		list.add("midnight");
		list.remove("midnight");
		
		assertEquals("GetLength is expected to be 0", 0, list.getLength());
	}
	
	//===============================================
	// Removing a Node From List of Multiple Items
	//===============================================
	
	@Test 
	public void testRemove_MultipleNodeListGetLengthIsReducedBy1() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove("hello");
		
		assertEquals("getLength should now return " + (insertedData.length-1) + " but returns " + list.getLength(), insertedData.length-1, list.getLength() );
	}
	
	@Test 
	public void testRemove_ContainsMustBeFalse() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove("hello");
		
		assertFalse("Contains should be false, but is true", list.contains("hello"));
	}
	
	
	//====================================================
	// Remove a Node in Given Position
	//====================================================
	
	@Test
	public void testRemove_GivenPosition_GetLengthReducedBy1() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove(2);
		
		assertEquals("GetLength should now return " + (insertedData.length-1) + " but returns " + list.getLength(), insertedData.length-1, list.getLength());
	}
	
	@Test 
	public void testRemove_GivenPosition_ContainsMustBeFalse() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			list.add(insertedData[i]);
		}
		
		list.remove(2);
		
		assertFalse("Contains should be false, but is true", list.contains("hi"));
	}

}
