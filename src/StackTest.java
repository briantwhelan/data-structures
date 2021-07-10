import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  Stack test class.
 *
 *  @version 10/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class StackTest 
{
    /**
     * Test {@code Stack()} 
     */
    @Test
    public void testConstructor1()
    {  	
    	new Stack<Integer>();
    }
    
    /**
     * Test {@code Stack(int initialCapacity)} 
     */
    @Test
    public void testConstructor2()
    {  	
    	new Stack<Integer>(10);
    	try{new Stack<Integer>(-1);}catch(Exception e){};
    }
    
    /**
     * Test {@code Stack(T[] array)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new Stack<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	 
    	assertEquals("Testing size()", 0, stack.size());
    	stack.push(5);
    	assertEquals("Testing size()", 1, stack.size());
    	stack.push(10);
    	assertEquals("Testing size()", 2, stack.size());
    	stack.push(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, stack.size());
    }
    
    /**
     * Test {@code push(T element)}
     */
    @Test
    public void testPush()
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	 
    	assertEquals("Testing push(T element)", "Top -  - Bottom", stack.toString());
    	stack.push(5);
    	assertEquals("Testing push(T element)", "Top - 5 - Bottom", stack.toString());
    	stack.push(10);
    	assertEquals("Testing push(T element)", "Top - 10 5 - Bottom", stack.toString());
    	stack.push(10);
    	assertEquals("Testing push(T element) - Adding a duplicate element", "Top - 10 10 5 - Bottom", stack.toString());
    }
    
    /**
     * Test {@code pop()}
     */
    @Test
    public void testPop()
    {
    	Stack<Integer> stack = new Stack<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing pop()", 15, (int)stack.pop());
    	assertEquals("Testing pop()", 10, (int)stack.pop());
    	assertEquals("Testing pop()", 5, (int)stack.pop());
    	assertEquals("Testing pop() - Popping from an empty stack", null, stack.pop());
    }
    
    /**
     * Test {@code peek()}
     */
    @Test
    public void testPeek()
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	assertEquals("Testing peek() - Peeking an empty stack\"", null, stack.peek());
    	stack.push(5);
    	assertEquals("Testing peek()", 5, (int)stack.peek());
    	stack.push(10);
    	assertEquals("Testing peek()", 10, (int)stack.peek());
    	stack.push(15);
    	assertEquals("Testing peek()", 15, (int)stack.peek());
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	assertEquals("Testing toString()", "Top -  - Bottom", stack.toString());
    	stack.push(5);
    	assertEquals("Testing toString()", "Top - 5 - Bottom", stack.toString());
    	stack.push(10);
    	assertEquals("Testing toString()", "Top - 10 5 - Bottom", stack.toString());
    	stack.push(15);
    	assertEquals("Testing toString()", "Top - 15 10 5 - Bottom", stack.toString());
    }
}