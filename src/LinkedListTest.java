import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  LinkedList test class.
 *
 *  @version 9/7/21
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
     * Test LinkedList(T[] array) 
     */
    @Test
    public void testConstructor2()
    {  	
    	new LinkedList(new Integer[] {5, 10, 15});
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
    	assertEquals("Testing size() - Adding a duplicate element", 3, linkedList.size());
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
    	linkedList.add(10);
    	assertEquals("Testing add(T element) - Adding a duplicate element", "Head - 5,10,10 - Tail", linkedList.toString());
    }
    
    /**
     * Test remove(int index)
     */
    @Test
    public void testRemove()
    {
    	LinkedList<Integer> linkedList = new LinkedList(new Integer[] {5, 10, 15, 20});
    	
    	assertEquals("Testing remove(int index) - Removing invalid index (negative)", null, linkedList.remove(-1));
    	assertEquals("Testing remove(int index) - Removing invalid index (positive)", null, linkedList.remove(4));
    	assertEquals("Testing remove(int index)", 5, (int)linkedList.remove(0));
    	assertEquals("Testing remove(int index)", 15, (int)linkedList.remove(1));
    	assertEquals("Testing remove(int index)", 10, (int)linkedList.remove(0));   
    	assertEquals("Testing remove(int index)", 20, (int)linkedList.remove(0)); 
    }
    
    /**
     * Test get(int index)
     */
    @Test
    public void testGet()
    {
    	LinkedList<Integer> linkedList = new LinkedList(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing get(int index) - Getting invalid index (negative)", null, linkedList.get(-1));
    	assertEquals("Testing get(int index) - Getting invalid index (positive)", null, linkedList.get(3));
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