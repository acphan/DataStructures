package testCode;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import com.andyphan.stack.ArrayStack;
import com.andyphan.stack.IStack;

@RunWith(value = Parameterized.class)
public class ArrayStackTests {
	ArrayStack<String> stack;
	private String data;

	
	public ArrayStackTests(String data) {
		//System.out.println("Constructor");
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		this.data = data;
		
	}
	
	@Parameters
	public static Collection<String[]> dataStrings() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return Arrays.asList(new String[][] {
			{""},
			{"morning"},
			{"afternoon"}
		});
	}
	
	@Before
	public void setup() {
		//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
		stack = new ArrayStack<>();
	}
	
	//========================================
		// Initialization Tests
		//========================================
			
		@Test
		public void testInitialization_IsEmptyMustBeTrue() {
			//System.out.println("Running - " + Thread.currentThread().getStackTrace()[1].getMethodName());
			assertTrue("IsEmpty is expected to be true", stack.isEmpty());
		}
		
		//===================================
		// Test General Methods
		//===================================
		
		@Test
		public void testPeek_EmptyStack() {
			assertNull("Peek should be null, but is " + stack.peek(), stack.peek());
		}
		
		@Test
		public void testDoubleCapacity() {
			stack.doubleCapacity();
			
			assertEquals("Capacity should be 40", 40, stack.getCapacity());
		}
		
		//===================================
		// Push a Node into Stack
		//===================================
		
		@Test
		public void testPush() {
			stack.push(data);
			
			assertEquals("Peek should return " + data + ", but returns " + stack.peek(), data, stack.peek());
		}
		
		@Test
		public void testPush_IsEmptyReturnsFalse() {
			stack.push(data);
			
			assertFalse("Is Empty should return false but returns " + stack.isEmpty(), stack.isEmpty());
		}
		
		//====================================
		// Pushing Multiple Nodes into a Stack
		//====================================
		
		@Test
		public void testPush_MultipleNodes() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			
			assertEquals("Peek should return " + insertedData[insertedData.length - 1] + ", but returns " + stack.peek(), insertedData[insertedData.length - 1], stack.peek());
		}
		
		@Test
		public void testPush_MultipleNodes_IsEmptyReturnsFalse() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			
			assertFalse("Is Empty should return false but returns " + stack.isEmpty(), stack.isEmpty());
		}
		
		//=======================================
		// Testing Clear
		//=======================================
		
		@Test
		public void testClear_IsEmptyIsTrue() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			
			stack.clear();
			
			assertTrue("Is Empty should return true but returns " + stack.isEmpty(), stack.isEmpty());
		}
		
		@Test
		public void testClear_PeekReturnsNull() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			
			stack.clear();
			
			assertNull("Peek should return null but returns " + stack.peek(), stack.peek());
		}
		
		//===================================
		// Popping a Node from Stack
		//===================================
		
		@Test
		public void testPop() {
			stack.push("afternoon");
			stack.pop();
			
		assertNull("Peek should return null but returns " + stack.peek(), stack.peek());
		}
		
		@Test
		public void testPop_IsEmptyReturnsTrue() {
			stack.push("afternoon");
			stack.pop();
			
			
			assertTrue("Is Empty should return true but returns " + stack.isEmpty(), stack.isEmpty());
		}
		
		@Test
		public void testPop_MultipleNodesStack() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			stack.pop();
			
			assertEquals("Peek should return " + insertedData[insertedData.length - 2] + ", but returns " + stack.peek(), insertedData[insertedData.length - 2], stack.peek());
		}
		
		@Test
		public void testPop_MultipleNodesSTack_IsEmptyReturnsFalse() {
			String[] insertedData = {"", "hi", "hello", "night"};
			
			for (int i = 0; i < insertedData.length; i++) {
				stack.push(insertedData[i]);
			}
			stack.pop();
			
			assertFalse("Is Empty should return false but returns " + stack.isEmpty(), stack.isEmpty());
		}
}
