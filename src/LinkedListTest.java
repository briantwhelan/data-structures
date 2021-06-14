import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  LinkedList test class.
 *
 *  @version 14/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class LinkedListTest 
{
    /**
     * Test LinkedList() 
     */
    @Test
    public void testConstructor1()
    {  	
    	new LinkedList();
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	LinkedList<Integer> linkedList = new LinkedList();
    	 
    	assertEquals("Testing size()", 0, linkedList.size());
    	linkedList.add(5);
    	assertEquals("Testing size()", 1, linkedList.size());
    	linkedList.add(10);
    	assertEquals("Testing size()", 2, linkedList.size());
    	linkedList.add(10);
    	assertEquals("Testing size()", 3, linkedList.size());
    }
    
    /**
     * Test add(T element)
     */
    @Test
    public void testAdd()
    {
    	LinkedList<Integer> linkedList = new LinkedList();
    	 
    	assertEquals("Testing add(T element)", "Head -  - Tail", linkedList.toString());
    	linkedList.add(5);
    	assertEquals("Testing add(T element)", "Head - 5 - Tail", linkedList.toString());
    	linkedList.add(10);
    	assertEquals("Testing add(T element)", "Head - 5,10 - Tail", linkedList.toString());
    	linkedList.add(15);
    	assertEquals("Testing add(T element)", "Head - 5,10,15 - Tail", linkedList.toString());
    }
    
    /**
     * Test remove()
     */
    @Test
    public void testRemove()
    {
    	LinkedList<Integer> linkedList = new LinkedList();
    	
    	assertEquals("Testing remove()", null, linkedList.remove(0));
    	linkedList.add(5);
    	linkedList.add(10);
    	linkedList.add(15);
    	assertEquals("Testing remove()", 15, (int)linkedList.remove(2));
    	assertEquals("Testing remove()", 5, (int)linkedList.remove(0));
    	assertEquals("Testing remove()", 10, (int)linkedList.remove(0));
    }
    
    /**
     * Test get(int index)
     */
    @Test
    public void testGet()
    {
    	LinkedList<Integer> linkedList = new LinkedList();
    	
    	assertEquals("Testing get(int index)", null, linkedList.get(-1));
    	assertEquals("Testing get(int index)", null, linkedList.get(3));
    	linkedList.add(5);
    	linkedList.add(10);
    	linkedList.add(15);
    	assertEquals("Testing get(int index)", 5, (int)linkedList.get(0));
    	assertEquals("Testing get(int index)", 10, (int)linkedList.get(1));
    	assertEquals("Testing get(int index)", 15, (int)linkedList.get(2));
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
    	LinkedList<Integer> linkedList = new LinkedList();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", linkedList.toString());
    	linkedList.add(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", linkedList.toString());
    	linkedList.add(10);
    	assertEquals("Testing toString()", "Head - 5,10 - Tail", linkedList.toString());
    	linkedList.add(15);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", linkedList.toString());
    }
}