import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  MinPQ test class.
 *
 *  @version 13/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQTest 
{    
    /**
     * Test {@code MinPQ()}
     */
    @Test
    public void testConstructor1()
    {  	
    	new MinPQ<Integer>();
    }
    
    /**
     * Test {@code MinPQ(int initialCapacity)}
     */
    @Test
    public void testConstructor2()
    {  	
    	new MinPQ<Integer>(5);
    }
    
    /**
     * Test {@code MinPQ(T[] array)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new MinPQ<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {    	
    	MinPQ<Integer> minPQ = new MinPQ<Integer>();
   	 
    	assertEquals("Testing size()", 0, minPQ.size());
    	minPQ.insert(5);
    	assertEquals("Testing size()", 1, minPQ.size());
    	minPQ.insert(10);
    	assertEquals("Testing size()", 2, minPQ.size());
    	minPQ.insert(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, minPQ.size());
    }
    
	/**
     * Test {@code insert(T element)}
     */
    @Test
    public void testInsert()
    {    	
    	MinPQ<Integer> minPQ = new MinPQ<Integer>();
   	 
    	assertEquals("Testing insert(T element)", "Head -  - Tail", minPQ.toString());
    	minPQ.insert(5);
    	assertEquals("Testing insert(T element)", "Head - 5 - Tail", minPQ.toString());
    	minPQ.insert(10);
    	assertEquals("Testing insert(T element)", "Head - 5,10 - Tail", minPQ.toString());
    	minPQ.insert(10);
    	assertEquals("Testing insert(T element) - Adding a duplicate element", "Head - 5,10,10 - Tail", minPQ.toString());
    }
    
    /**
     * Test {@code deleteMin()}
     */
    @Test
    public void testDeleteMin()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing deleteMin()", 5, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin()", 10, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin()", 15, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin() - Deleting from an empty MinPQ", null, minPQ.deleteMin());
    }
    
    /**
     * Test {@code contains(T element)}
     */
    @Test
    public void testContains()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(new Integer[] {5, 10, 15});
    	    	
    	assertEquals("Testing contains(T element)", true, minPQ.contains(10));
    	assertEquals("Testing contains(T element)", false, minPQ.contains(20));
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {    	
    	MinPQ<Integer> minPQ = new MinPQ<Integer>();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", minPQ.toString());
    	minPQ.insert(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", minPQ.toString());
    	minPQ.insert(15);
    	assertEquals("Testing toString()", "Head - 5,15 - Tail", minPQ.toString());
    	minPQ.insert(10);
    	assertEquals("Testing toString()", "Head - 5,10,15 - Tail", minPQ.toString());
    }
}