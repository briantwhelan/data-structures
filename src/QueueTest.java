import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  Queue test class.
 *
 *  @version 11/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class QueueTest 
{
    /**
     * Test {@code Queue()} 
     */
    @Test
    public void testConstructor1()
    {  	
    	new Queue<Integer>();
    }
    
    /**
     * Test {@code Queue(int initialCapacity)} 
     */
    @Test
    public void testConstructor2()
    {  	
    	new Queue<Integer>(10);
    	try{new Queue<Integer>(-1);}catch(Exception e){};
    }
    
    /**
     * Test {@code Queue(T[] array)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new Queue<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {
    	Queue<Integer> queue = new Queue<Integer>();
    	 
    	assertEquals("Testing size()", 0, queue.size());
    	queue.add(5);
    	assertEquals("Testing size()", 1, queue.size());
    	queue.add(10);
    	assertEquals("Testing size()", 2, queue.size());
    	queue.add(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, queue.size());
    }
    
    /**
     * Test {@code add(T element)}
     */
    @Test
    public void testAdd()
    {
    	Queue<Integer> queue = new Queue<Integer>();
    	 
    	assertEquals("Testing add(T element)", "Head -  - Tail", queue.toString());
    	queue.add(5);
    	assertEquals("Testing add(T element)", "Head - 5 - Tail", queue.toString());
    	queue.add(10);
    	assertEquals("Testing add(T element)", "Head - 5,10 - Tail", queue.toString());
    	queue.add(10);
    	assertEquals("Testing add(T element) - Adding a duplicate element", "Head - 5,10,10 - Tail", queue.toString());
    }
    
    /**
     * Test {@code remove()}
     */
    @Test
    public void testRemove()
    {    	
    	Queue<Integer> stack = new Queue<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing pop()", 5, (int)stack.remove());
    	assertEquals("Testing pop()", 10, (int)stack.remove());
    	assertEquals("Testing pop()", 15, (int)stack.remove());
    	assertEquals("Testing pop() - Popping from an empty stack", null, stack.remove());
    }
    
    /**
     * Test {@code peek()}
     */
    @Test
    public void testPeek()
    {
    	Queue<Integer> queue = new Queue<Integer>();
    	
    	assertEquals("Testing peek() - Peeking an empty queue", null, queue.peek());
    	queue.add(5);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    	queue.add(10);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    	queue.add(15);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {
    	Queue<Integer> queue = new Queue<Integer>();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", queue.toString());
    	queue.add(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", queue.toString());
    	queue.add(10);
    	assertEquals("Testing toString()", "Head - 5,10 - Tail", queue.toString());
    	queue.add(15);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", queue.toString());
    }
}