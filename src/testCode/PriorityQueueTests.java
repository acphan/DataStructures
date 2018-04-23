package testCode;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.andyphan.queue.PriorityQueue;

@RunWith(value = Parameterized.class)
public class PriorityQueueTests {
	
	PriorityQueue<Integer> queue;
	private int data;

	
	public PriorityQueueTests(int data) {
		//System.out.println("Constructor");
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		this.data = data;
		
	}
	
	@Parameters
	public static Collection<Integer[]> dataStrings() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return Arrays.asList(new Integer[][] {
			{2},
			{3},
			{1}
		});
	}
	
	@Before
	public void setup() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		queue = new PriorityQueue<>();
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
		assertEquals("getLength is expected to be 20", 20, queue.getLength());
	}
	
	//===================================
	// Test General Methods
	//===================================
	
	@Test
	public void testPeek_EmptyQueue() {
		assertNull("Peek should be null, but is " + queue.peek(), queue.peek());
	}
	
	@Test
	public void testDoubleCapacity() {
		queue.doubleCapacity();
		
		assertEquals("Capacity should be 40", 40, queue.getLength());
	}
	
	//===================================
	// Enqueue a Node
	//===================================
	
	@Test
	public void testEnqueue() {
		queue.enqueue(data);
		
		//assertEquals("Peek should return " + data + " but returned " + queue.peek(), data, queue.peek());
	}
	
	@Test
	public void testEnqueue_GetLengthMustBe20() {
		queue.enqueue(data);
		
		assertEquals("Get length should return 20", 20, queue.getLength());
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
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		assertEquals("Peek should return " + insertedData[0] + " but returned " + queue.peek(), insertedData[0], queue.peek());
	}
	
	@Test
	public void testEnqueue_MultipleNodes_GetLengthMustBe20() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		assertEquals("Get length should return " + queue.getLength(), 20, queue.getLength());
	}
	
	@Test
	public void testEnqueue_MultipleNodes_IsEmptyIsFalse() {
		Integer[] insertedData = {2, 6, 4, 1};
		
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
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.clear();
		
		assertNull("Peek should return null, but returned " + queue.peek(), queue.peek());
	}
	
	@Test
	public void testClear_isEmptyIsTrue() {
		Integer[] insertedData = {2, 6, 4, 1};
			
			for (int i = 0; i < insertedData.length; i++) {
				queue.enqueue(insertedData[i]);
			}
			
			queue.clear();
			
			assertTrue("IsEmpty should return true, but returned " + queue.isEmpty(), queue.isEmpty());
	}
	
	@Test
	public void testClear_GetLengthIs20() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.clear();
		
		assertEquals("Get length should return 20, but returned " + queue.getLength(), 20, queue.getLength());
	}
	
	//==================================
	// Dequeue
	//==================================
	
	@Test
	public void testDequeue() {
		queue.enqueue(1);
		queue.dequeue();
		
		assertNull("Peek should be null", queue.peek());
		
	}
	
	@Test
	public void testDequeue_GetLengthIs20() {
		queue.enqueue(1);
		queue.dequeue();
		
		assertEquals("Get Length should be 20, but is " + queue.getLength(), 20, queue.getLength());
	}
	
	@Test
	public void testDequeue_isEmptyMustBeTrue() {
		queue.enqueue(1);
		queue.dequeue();
		
		assertTrue("Is Empty should return true, but is " + queue.isEmpty(), queue.isEmpty());
	}
	
	//======================================
	// Dequeue from Queue with Multiple Items
	//======================================
	
	@Test
	public void testDequeue_QueueWithMultipleNode() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertEquals("Peek should return " + insertedData[1] + " but returned " + queue.peek(), insertedData[1], queue.peek());
	}
	
	@Test
	public void testDequeue_QueueWithMultipleNodes_GetLengthIsReducedBy1() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertEquals("Get Length should be " + 20 + ", but is " + queue.getLength(), 20, queue.getLength());
	}
	
	@Test
	public void testDequeue_QueueWithMultipleNodes_isEmptyMustBeFalse() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeue();
		
		assertFalse("Is Empty should return false, but is " + queue.isEmpty(), queue.isEmpty());
	}
	
	//======================================
	// Dequeue from Queue with Multiple Items with Priority
	//======================================
	
	@Test
	public void testDequeueHighPriority_QueueWithMultipleNode() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeueHighPriority();
		
		assertEquals("Peek should return " + insertedData[0] + " but returned " + queue.peek(), insertedData[0], queue.peek());
	}
	
	@Test
	public void testDequeueHighPriority_QueueWithMultipleNodes_GetLengthIsReducedBy1() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeueHighPriority();
		
		assertEquals("Get Length should be " + 20 + ", but is " + queue.getLength(), 20, queue.getLength());
	}
	
	@Test
	public void testDequeueHighPriority_QueueWithMultipleNodes_isEmptyMustBeFalse() {
		Integer[] insertedData = {2, 6, 4, 1};
		
		for (int i = 0; i < insertedData.length; i++) {
			queue.enqueue(insertedData[i]);
		}
		
		queue.dequeueHighPriority();
		
		assertFalse("Is Empty should return false, but is " + queue.isEmpty(), queue.isEmpty());
	}
}
