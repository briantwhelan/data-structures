import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  {@code ArrayList} test class.
 *
 *  @version 22/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class ArrayListTest 
{
    /**
     * Test {@code ArrayList()} 
     */
    @Test
    public void testConstructor1()
    {  	
    	new ArrayList<Integer>();
    }
    
    /**
     * Test {@code ArrayList(int initialCapacity)} 
     */
    @Test
    public void testConstructor2()
    {  	
    	new ArrayList<Integer>(10);
    	try{new ArrayList<Integer>(-1);}catch(Exception e){};
    }
    
    /**
     * Test {@code ArrayList(T[] array)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new ArrayList<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	 
    	assertEquals("Testing size()", 0, arrayList.size());
    	arrayList.add(5);
    	assertEquals("Testing size()", 1, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing size()", 2, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, arrayList.size());
    }
    
    /**
     * Test {@code add(T element)}
     */
    @Test
    public void testAdd()
    {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	
    	assertEquals("Testing add(T element)", "{}", arrayList.toString());
    	arrayList.add(5);
    	assertEquals("Testing add(T element)", "{5}", arrayList.toString());
    	arrayList.add(10);
    	assertEquals("Testing add(T element)", "{5,10}", arrayList.toString());
    	arrayList.add(10);
    	assertEquals("Testing add(T element) - Adding a duplicate element", "{5,10,10}", arrayList.toString());
    }
    
    /**
     * Test {@code remove(int index)}
     */
    @Test
    public void testRemove()
    {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>(new Integer[] {5, 10, 15, 20});
    	
    	assertEquals("Testing remove(int index) - Removing invalid index (negative)", null, arrayList.remove(-1));
    	assertEquals("Testing remove(int index) - Removing invalid index (positive)", null, arrayList.remove(4));
    	assertEquals("Testing remove(int index)", 5, (int)arrayList.remove(0));
    	assertEquals("Testing remove(int index)", 15, (int)arrayList.remove(1));
    	assertEquals("Testing remove(int index)", 10, (int)arrayList.remove(0));   
    	assertEquals("Testing remove(int index)", 20, (int)arrayList.remove(0)); 
    }
    
    /**
     * Test get(int index)
     */
    @Test
    public void testGet()
    {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing get(int index) - Getting invalid index (negative)", null, arrayList.get(-1));
    	assertEquals("Testing get(int index) - Getting invalid index (positive)", null, arrayList.get(3));
    	assertEquals("Testing get(int index)", 5, (int)arrayList.get(0));
    	assertEquals("Testing get(int index)", 10, (int)arrayList.get(1));
    	assertEquals("Testing get(int index)", 15, (int)arrayList.get(2));
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	
    	assertEquals("Testing toString()", "{}", arrayList.toString());
    	arrayList.add(5);
    	assertEquals("Testing toString()", "{5}", arrayList.toString());
    	arrayList.add(10);
    	assertEquals("Testing toString()", "{5,10}", arrayList.toString());
    	arrayList.add(15);
    	assertEquals("Testing toString()", "{5,10,15}", arrayList.toString());
    }
}
