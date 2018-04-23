package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.andyphan.queue.ListQueue;

@RunWith(value = Parameterized.class)
public class QueueTests {
	
	ListQueue<String> queue;
	private String data;

	
	public QueueTests(String data) {
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
		queue = new ListQueue<>();
	}
	
	//========================================
	// Initialization Tests
	//========================================
	
	@Test
	public void testInitialization_IsEmptyMustBeTrue() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		assertTrue("IsEmpty is expected to be true", queue.isEmpty());
	}
	
	@Test
	public void testInitialization_GetLengthMustBe0() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		assertEquals("getLength is expected to be 0", 0, queue.getLength());
	}
	
	//===================================
	// Test General Methods
	//===================================
	
	@Test
	public void testPeek_EmptyQueue() {
		assertNull("Peek should be null, but is " + queue.peek(), queue.peek());
	}
	
	//===================================
	// Enqueue a Node
	//===================================
	
	@Test
	public void testEnqueue() {
		queue.enqueue(data);
		
		assertEquals("Peek should return " + data + " but returned " + queue.peek(), data, queue.peek());
	}
	
	@Test
	public void testEnqueue_GetLengthMustBe1() {
		queue.enqueue(data);
		
		assertEquals("Get length should return 1", 1, queue.getLength());
	}
	
	@Test
	public void testEnqueue_IsEmptyIsFalse() {
		queue.enqueue(data);
		
		assertFalse("Is Empty should return false but returns " + queue.isEmpty(), queue.isEmpty());
	}
	
	//===================================
	// Enqueue Multiple Nodes
	//===================================
	
	@Test
	public void testEnqueue_MultipleNodes() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		assertEquals("Peek should return " + insertedData[0] + " but returned " + queue.peek(), insertedData[0], queue.peek());
	}
	
	@Test
	public void testEnqueue_MultipleNodes_GetLengthMustBe1() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		assertEquals("Get length should return " + insertedData.length, insertedData.length, queue.getLength());
	}
	
	@Test
	public void testEnqueue_MultipleNodes_IsEmptyIsFalse() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		assertFalse("Is Empty should return false but returns " + queue.isEmpty(), queue.isEmpty());
	}
	
	//====================================
	// Clear Queue of Nodes
	//===================================
	
	@Test
	public void testClear() {
	String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.clear();
		
		assertNull("Peek should return null, but returned " + queue.peek(), queue.peek());
	}
	
	@Test
	public void testClear_isEmptyIsTrue() {
		String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				queue.enqueue(insertedData[i]);
			}
			
			queue.clear();
			
			assertTrue("IsEmpty should return true, but returned " + queue.isEmpty(), queue.isEmpty());
	}
	
	@Test
	public void testClear_GetLengthIs0() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.clear();
		
		assertEquals("Get length should return 0, but returned " + queue.getLength(), 0, queue.getLength());
	}
	
	//==================================
	// Dequeue
	//==================================
	
	@Test
	public void testDequeue() {
		queue.enqueue("afternoon");
		queue.dequeue();
		
		assertNull("Peek should be null", queue.peek());
		
	}
	
	@Test
	public void testDequeue_GetLengthIs0() {
		queue.enqueue("afternoon");
		queue.dequeue();
		
		assertEquals("Get Length should be 0, but is " + queue.getLength(), 0, queue.getLength());
	}
	
	@Test
	public void testDequeue_isEmptyMustBeTrue() {
		queue.enqueue("afternoon");
		queue.dequeue();
		
		assertTrue("Is Empty should return true, but is " + queue.isEmpty(), queue.isEmpty());
	}
	
	//======================================
	// Dequeue from Queue with Multiple Items
	//======================================
	
	@Test
	public void testDequeue_QueueWithMultipleNode() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertEquals("Peek should return " + insertedData[1] + " but returned " + queue.peek(), insertedData[1], queue.peek());
	}
	
	@Test
	public void testDequeue_QueueWithMultipleNodes_GetLengthIsReducedBy1() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertEquals("Get Length should be " + (insertedData.length - 1) + ", but is " + queue.getLength(), insertedData.length - 1, queue.getLength());
	}
	
	@Test
	public void testDequeue_QueueWithMultipleNodes_isEmptyMustBeFalse() {
		String[] insertedData = {"", "hi", "hello", "night"};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertFalse("Is Empty should return false, but is " + queue.isEmpty(), queue.isEmpty());
	}
}
