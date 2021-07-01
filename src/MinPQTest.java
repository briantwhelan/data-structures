import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  MinPQ test class.
 *
 *  @version 1/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQTest 
{    
    /**
     * Test MinPQ()
     */
    @Test
    public void testConstructor()
    {  	
    	new MinPQ(5);
    }
    
	/**
     * Test insert(T item)
     */
    @Test
    public void testInsert()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test inserting elements 
    	minPQ.insert(7);
    	assertEquals("Testing insert(T item)", 1, minPQ.size());
    	minPQ.insert(4);
    	assertEquals("Testing insert(T item)", 2, minPQ.size());
    }
    
    /**
     * Test deleteMin()
     */
    @Test
    public void testDeleteMin()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test deleting minimum element on empty minimum priority queue
    	assertEquals("Testing deleteMin()", null, minPQ.deleteMin());
    	
    	//Test deleting minimum element on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing deleteMin()", 2, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin()", 4, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin()", 7, (int)minPQ.deleteMin());
    	assertEquals("Testing deleteMin()", 10, (int)minPQ.deleteMin());
    }
    
    /**
     * Test contains(T item)
     */
    @Test
    public void testContains()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	    	
    	//Test contains for an element that does exist in the minimum priority queue
    	assertEquals("Testing contains(T item)", true, minPQ.contains(4));
    	
    	//Test contains for an element that doesn't exist in the minimum priority queue
    	assertEquals("Testing contains(T item)", false, minPQ.contains(6));
    }
    
    /**
     * Test isEmpty()
     */
    @Test
    public void testIsEmpty()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test isEmpty on empty minimum priority queue
    	assertEquals("Testing isEmpty()", true, minPQ.isEmpty());
    	
    	//Test isEmpty on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing isEmpty()", false, minPQ.isEmpty());
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test getting size in empty minimum priority queue
    	assertEquals("Testing size()", 0, minPQ.size());
    	
    	//Test getting size in non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing size()", 4, minPQ.size());   	
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test toString on empty minimum priority queue
    	assertEquals("Testing toString()", "<- (Next Out) <- (Last In)\n", minPQ.toString());
    	
    	//Test toString on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing toString()", "<- (Next Out) 2 4 10 7 <- (Last In)\n", minPQ.toString()); 
    }
}