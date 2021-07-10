import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  DoublyLinkedList test class.
 *
 *  @version 10/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DoublyLinkedListTest 
{
    /**
     * Test {@code DoublyLinkedList()} 
     */
    @Test
    public void testConstructor1()
    {  	
    	new DoublyLinkedList<Integer>();
    }
    
    /**
     * Test {@code DoublyLinkedList(T[] array)} 
     */
    @Test
    public void testConstructor2()
    {  	
    	new DoublyLinkedList<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	 
    	assertEquals("Testing size()", 0, doublyLinkedList.size());
    	doublyLinkedList.add(5);
    	assertEquals("Testing size()", 1, doublyLinkedList.size());
    	doublyLinkedList.add(10);
    	assertEquals("Testing size()", 2, doublyLinkedList.size());
    	doublyLinkedList.add(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, doublyLinkedList.size());
    }
    
    /**
     * Test {@code add(T element)}
     */
    @Test
    public void testAdd1()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	 
    	assertEquals("Testing add(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5);
    	assertEquals("Testing add(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10);
    	assertEquals("Testing add(T element)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10);
    	assertEquals("Testing add(T element) - Adding a duplicate element", "Head - 5,10,10 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test {@code addFirst(T element)}
     */
    @Test
    public void testAddFirst()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	 
    	assertEquals("Testing addFirst(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(5);
    	assertEquals("Testing addFirst(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(10);
    	assertEquals("Testing addFirst(T element)", "Head - 10,5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(10);
    	assertEquals("Testing addFirst(T element) - Adding a duplicate element", "Head - 10,10,5 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test {@code addLast(T element)}
     */
    @Test
    public void testAddLast()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	 
    	assertEquals("Testing addLast(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(5);
    	assertEquals("Testing addLast(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(10);
    	assertEquals("Testing addLast(T element)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(10);
    	assertEquals("Testing addLast(T element) - Adding a duplicate element", "Head - 5,10,10 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test {@code add(T element, int index)}
     */
    @Test
    public void testAdd2()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	 
    	assertEquals("Testing add(T element, int index)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5, 0);
    	assertEquals("Testing add(T element, int index)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10, 2);
    	assertEquals("Testing add(T element, int index)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(15, 1);
    	assertEquals("Testing add(T element, int index)", "Head - 5,15,10 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test {@code remove(int index)}
     */
    @Test
    public void testRemove()
    {    	
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>(new Integer[] {5, 10, 15, 20});
    	
    	assertEquals("Testing remove(int index) - Removing invalid index (negative)", null, doublyLinkedList.remove(-1));
    	assertEquals("Testing remove(int index) - Removing invalid index (positive)", null, doublyLinkedList.remove(4));
    	assertEquals("Testing remove(int index)", 5, (int)doublyLinkedList.remove(0));
    	assertEquals("Testing remove(int index)", 15, (int)doublyLinkedList.remove(1));
    	assertEquals("Testing remove(int index)", 10, (int)doublyLinkedList.remove(0));   
    	assertEquals("Testing remove(int index)", 20, (int)doublyLinkedList.remove(0)); 
    }
    
    /**
     * Test {@code get(int index)}
     */
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing get(int index) - Getting invalid index (negative)", null, linkedList.get(-1));
    	assertEquals("Testing get(int index) - Getting invalid index (positive)", null, linkedList.get(3));
    	assertEquals("Testing get(int index)", 5, (int)linkedList.get(0));
    	assertEquals("Testing get(int index)", 10, (int)linkedList.get(1));
    	assertEquals("Testing get(int index)", 15, (int)linkedList.get(2));
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10);
    	assertEquals("Testing toString()", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(15);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", doublyLinkedList.toString());
    }
}