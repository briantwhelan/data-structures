import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  MaxPQ test class.
 *
 *  @version 14/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQTest 
{   
	/**
     * Test {@code MinPQ()}
     */
    @Test
    public void testConstructor1()
    {  	
    	new MaxPQ<Integer>();
    }
    
    /**
     * Test {@code MinPQ(int initialCapacity)}
     */
    @Test
    public void testConstructor2()
    {  	
    	new MaxPQ<Integer>(5);
    }
    
    /**
     * Test {@code MinPQ(T[] array)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new MaxPQ<Integer>(new Integer[] {5, 10, 15});
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {    	
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>();
   	 
    	assertEquals("Testing size()", 0, maxPQ.size());
    	maxPQ.insert(5);
    	assertEquals("Testing size()", 1, maxPQ.size());
    	maxPQ.insert(10);
    	assertEquals("Testing size()", 2, maxPQ.size());
    	maxPQ.insert(10);
    	assertEquals("Testing size() - Adding a duplicate element", 3, maxPQ.size());
    }
    
	/**
     * Test {@code insert(T element)}
     */
    @Test
    public void testInsert()
    {    	
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>();
   	 
    	assertEquals("Testing insert(T element)", "Head -  - Tail", maxPQ.toString());
    	maxPQ.insert(5);
    	assertEquals("Testing insert(T element)", "Head - 5 - Tail", maxPQ.toString());
    	maxPQ.insert(10);
    	assertEquals("Testing insert(T element)", "Head - 10,5 - Tail", maxPQ.toString());
    	maxPQ.insert(10);
    	assertEquals("Testing insert(T element) - Adding a duplicate element", "Head - 10,10,5 - Tail", maxPQ.toString());
    }
    
    /**
     * Test {@code deleteMax()}
     */
    @Test
    public void testDeleteMax()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(new Integer[] {5, 10, 15});
    	
    	assertEquals("Testing deleteMax()", 15, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax()", 10, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax()", 5, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax() - Deleting from an empty MaxPQ", null, maxPQ.deleteMax());
    }
    
    /**
     * Test {@code contains(T element)}
     */
    @Test
    public void testContains()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(new Integer[] {5, 10, 15});
    	    	
    	assertEquals("Testing contains(T element)", true, maxPQ.contains(10));
    	assertEquals("Testing contains(T element)", false, maxPQ.contains(20));
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {    	
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>();
    	
    	assertEquals("Testing toString()", "Head -  - Tail", maxPQ.toString());
    	maxPQ.insert(5);
    	assertEquals("Testing toString()", "Head - 5 - Tail", maxPQ.toString());
    	maxPQ.insert(15);
    	assertEquals("Testing toString()", "Head - 15,5 - Tail", maxPQ.toString());
    	maxPQ.insert(10);
    	assertEquals("Testing toString()", "Head - 15,10,5 - Tail", maxPQ.toString());
    }
}