import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  Stack test class.
 *
 *  @version 11/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class StackTest 
{
    /**
     * Test Stack() 
     */
    @Test
    public void testConstructor1()
    {  	
    	new Stack();
    }
    
    /**
     * Test Stack(int initialCapacity) 
     */
    @Test
    public void testConstructor2()
    {  	
    	new Stack(10);
    	try{new Stack(-1);}catch(Exception e){};
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	Stack<Integer> stack = new Stack();
    	 
    	assertEquals("Testing size()", 0, stack.size());
    	stack.push(5);
    	assertEquals("Testing size()", 1, stack.size());
    	stack.push(10);
    	assertEquals("Testing size()", 2, stack.size());
    	stack.push(10);
    	assertEquals("Testing size()", 3, stack.size());
    }
    
    /**
     * Test push(T element)
     */
    @Test
    public void testPush()
    {
    	Stack<Integer> stack = new Stack();
    	 
    	assertEquals("Testing push(T element)", "Top -  - Bottom", stack.toString());
    	stack.push(5);
    	assertEquals("Testing push(T element)", "Top - 5 - Bottom", stack.toString());
    	stack.push(10);
    	assertEquals("Testing push(T element)", "Top - 10 5 - Bottom", stack.toString());
    	stack.push(15);
    	assertEquals("Testing push(T element)", "Top - 15 10 5 - Bottom", stack.toString());
    }
    
    /**
     * Test pop()
     */
    @Test
    public void testPop()
    {
    	Stack<Integer> stack = new Stack();
    	
    	assertEquals("Testing pop()", null, stack.pop());
    	stack.push(5);
    	stack.push(10);
    	stack.push(15);
    	assertEquals("Testing pop()", 15, (int)stack.pop());
    	assertEquals("Testing pop()", 10, (int)stack.pop());
    	assertEquals("Testing pop()", 5, (int)stack.pop());
    }
    
    /**
     * Test peek()
     */
    @Test
    public void testPeek()
    {
    	Stack<Integer> stack = new Stack();
    	
    	assertEquals("Testing peek()", null, stack.peek());
    	stack.push(5);
    	assertEquals("Testing peek()", 5, (int)stack.peek());
    	stack.push(10);
    	assertEquals("Testing peek()", 10, (int)stack.peek());
    	stack.push(15);
    	assertEquals("Testing peek()", 15, (int)stack.peek());
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
    	Stack<Integer> stack = new Stack();
    	
    	assertEquals("Testing toString()", "Top -  - Bottom", stack.toString());
    	stack.push(5);
    	assertEquals("Testing toString()", "Top - 5 - Bottom", stack.toString());
    	stack.push(10);
    	assertEquals("Testing toString()", "Top - 10 5 - Bottom", stack.toString());
    	stack.push(15);
    	assertEquals("Testing toString()", "Top - 15 10 5 - Bottom", stack.toString());
    }
}