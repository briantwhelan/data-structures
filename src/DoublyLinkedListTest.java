import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  DoublyLinkedList test class.
 *
 *  @version 15/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DoublyLinkedListTest 
{
    /**
     * Test DoublyLinkedList() 
     */
    @Test
    public void testConstructor1()
    {  	
    	new DoublyLinkedList();
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	 
    	assertEquals("Testing size()", 0, doublyLinkedList.size());
    	doublyLinkedList.add(5);
    	assertEquals("Testing size()", 1, doublyLinkedList.size());
    	doublyLinkedList.add(10);
    	assertEquals("Testing size()", 2, doublyLinkedList.size());
    	doublyLinkedList.add(10);
    	assertEquals("Testing size()", 3, doublyLinkedList.size());
    }
    
    /**
     * Test add(T element)
     */
    @Test
    public void testAdd1()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	 
    	assertEquals("Testing add(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5);
    	assertEquals("Testing add(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10);
    	assertEquals("Testing add(T element)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(15);
    	assertEquals("Testing add(T element)", "Head - 5,10,15 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test addFirst(T element)
     */
    @Test
    public void testAddFirst()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	 
    	assertEquals("Testing addFirst(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(5);
    	assertEquals("Testing addFirst(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(10);
    	assertEquals("Testing addFirst(T element)", "Head - 10,5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addFirst(15);
    	assertEquals("Testing addFirst(T element)", "Head - 15,10,5 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test addLast(T element)
     */
    @Test
    public void testAddLast()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	 
    	assertEquals("Testing addLast(T element)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(5);
    	assertEquals("Testing addLast(T element)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(10);
    	assertEquals("Testing addLast(T element)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.addLast(15);
    	assertEquals("Testing addLast(T element)", "Head - 5,10,15 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test add(T element, int index)
     */
    @Test
    public void testAdd2()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	 
    	assertEquals("Testing add(T element, int index)", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5, 0);
    	assertEquals("Testing add(T element, int index)", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10, 2);
    	assertEquals("Testing add(T element, int index)", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(15, 1);
    	assertEquals("Testing add(T element, int index)", "Head - 5,15,10 - Tail", doublyLinkedList.toString());
    }
    
    /**
     * Test remove(int index)
     */
    @Test
    public void testRemove()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	
    	assertEquals("Testing remove(int index)", null, doublyLinkedList.remove(0));
    	doublyLinkedList.add(5);
    	doublyLinkedList.add(10);
    	doublyLinkedList.add(15);
    	assertEquals("Testing remove(int index)", 15, (int)doublyLinkedList.remove(2));
    	assertEquals("Testing remove(int index)", 5, (int)doublyLinkedList.remove(0));
    	assertEquals("Testing remove(int index)", 10, (int)doublyLinkedList.remove(0));
    }
    
    /**
     * Test get(int index)
     */
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	
    	assertEquals("Testing get(int index)", null, doublyLinkedList.get(-1));
    	assertEquals("Testing get(int index)", null, doublyLinkedList.get(3));
    	doublyLinkedList.add(5);
    	doublyLinkedList.add(10);
    	doublyLinkedList.add(15);
    	assertEquals("Testing get(int index)", 5, (int)doublyLinkedList.get(0));
    	assertEquals("Testing get(int index)", 10, (int)doublyLinkedList.get(1));
    	assertEquals("Testing get(int index)", 15, (int)doublyLinkedList.get(2));
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
    	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(10);
    	assertEquals("Testing toString()", "Head - 5,10 - Tail", doublyLinkedList.toString());
    	doublyLinkedList.add(15);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", doublyLinkedList.toString());
    }
}