import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  Queue test class.
 *
 *  @version 12/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class QueueTest 
{
    /**
     * Test Queue() 
     */
    @Test
    public void testConstructor1()
    {  	
    	new Queue();
    }
    
    /**
     * Test Queue(int initialCapacity) 
     */
    @Test
    public void testConstructor2()
    {  	
    	new Queue(10);
    	try{new Queue(-1);}catch(Exception e){};
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	Queue<Integer> queue = new Queue();
    	 
    	assertEquals("Testing size()", 0, queue.size());
    	queue.add(5);
    	assertEquals("Testing size()", 1, queue.size());
    	queue.add(10);
    	assertEquals("Testing size()", 2, queue.size());
    	queue.add(10);
    	assertEquals("Testing size()", 3, queue.size());
    }
    
    /**
     * Test add(T element)
     */
    @Test
    public void testAdd()
    {
    	Queue<Integer> queue = new Queue();
    	 
    	assertEquals("Testing add(T element)", "Head -  - Tail", queue.toString());
    	queue.add(5);
    	assertEquals("Testing add(T element)", "Head - 5 - Tail", queue.toString());
    	queue.add(10);
    	assertEquals("Testing add(T element)", "Head - 5,10 - Tail", queue.toString());
    	queue.add(15);
    	assertEquals("Testing add(T element)", "Head - 5,10,15 - Tail", queue.toString());
    }
    
    /**
     * Test remove()
     */
    @Test
    public void testRemove()
    {
    	Queue<Integer> queue = new Queue();
    	
    	assertEquals("Testing remove()", null, queue.remove());
    	queue.add(5);
    	queue.add(10);
    	queue.add(15);
    	assertEquals("Testing remove()", 5, (int)queue.remove());
    	assertEquals("Testing remove()", 10, (int)queue.remove());
    	assertEquals("Testing remove()", 15, (int)queue.remove());
    }
    
    /**
     * Test peek()
     */
    @Test
    public void testPeek()
    {
    	Queue<Integer> queue = new Queue();
    	
    	assertEquals("Testing peek()", null, queue.peek());
    	queue.add(5);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    	queue.add(10);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    	queue.add(15);
    	assertEquals("Testing peek()", 5, (int)queue.peek());
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
    	Queue<Integer> queue = new Queue();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", queue.toString());
    	queue.add(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", queue.toString());
    	queue.add(10);
    	assertEquals("Testing toString()", "Head - 5,10 - Tail", queue.toString());
    	queue.add(15);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", queue.toString());
    }
}