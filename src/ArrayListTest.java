import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  ArrayList test class.
 *
 *  @version 1.0 10/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class ArrayListTest 
{
	/**
     * Test ArrayList() 
     */
    @Test
    public void testConstructor1()
    {  	
    	new ArrayList();
    }
    
    /**
     * Test ArrayList(int initialCapacity) 
     */
    @Test
    public void testConstructor2()
    {  	
    	new ArrayList(10);
    	try{new ArrayList(-1);}catch(Exception e){};
    }
    
    /**
     * Test ArrayList(T[] array) 
     */
    @Test
    public void testConstructor3()
    {  	
    	new ArrayList(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	ArrayList<Integer> arrayList = new ArrayList();
    	 
    	assertEquals("Testing size()", 0, arrayList.size());
    	arrayList.add(5);
    	assertEquals("Testing size()", 1, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing size()", 2, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing size()", 3, arrayList.size());
    }
    
	/**
     * Test add(T element)
     */
    @Test
    public void testAdd()
    {
    	ArrayList<Integer> arrayList = new ArrayList();
    	
    	assertEquals("Testing add(T element)", 0, arrayList.size());
    	arrayList.add(5);
    	assertEquals("Testing add(T element)", 1, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing add(T element)", 2, arrayList.size());
    	arrayList.add(10);
    	assertEquals("Testing add(T element)", 3, arrayList.size());
    }
    
    /**
     * Test remove(int index)
     */
    @Test
    public void testRemove()
    {
    	ArrayList<Integer> arrayList = new ArrayList(new Integer[] {5, 10, 15, 20});
    	
    	assertEquals("Testing remove(int index)", null, arrayList.remove(-1));
    	assertEquals("Testing remove(int index)", null, arrayList.remove(4));
    	assertEquals("Testing remove(int index)", 5, (int)arrayList.remove(0));
    	assertEquals("Testing remove(int index)", 10, (int)arrayList.remove(0));
    	assertEquals("Testing remove(int index)", 15, (int)arrayList.remove(0));   
    	assertEquals("Testing remove(int index)", 20, (int)arrayList.remove(0)); 
    }
    
    /**
     * Test get(int index)
     */
    @Test
    public void testGet()
    {
    	ArrayList<Integer> arrayList = new ArrayList(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing get(int index)", null, arrayList.get(-1));
    	assertEquals("Testing get(int index)", null, arrayList.get(3));
    	assertEquals("Testing get(int index)", 5, (int)arrayList.get(0));
    	assertEquals("Testing get(int index)", 10, (int)arrayList.get(1));
    	assertEquals("Testing get(int index)", 15, (int)arrayList.get(2));
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {
    	ArrayList<Integer> arrayList = new ArrayList();
    	
    	assertEquals("Testing toString()", "{}", arrayList.toString());
    	arrayList.add(5);
    	assertEquals("Testing toString()", "{5}", arrayList.toString());
    	arrayList.add(10);
    	assertEquals("Testing toString()", "{5,10}", arrayList.toString());
    	arrayList.add(15);
    	assertEquals("Testing toString()", "{5,10,15}", arrayList.toString());
    }
}
