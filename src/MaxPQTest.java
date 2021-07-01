import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  MaxPQ test class.
 *
 *  @version 1/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQTest 
{    
    /**
     * Test MaxPQ()
     */
    @Test
    public void testConstructor()
    {  	
    	new MaxPQ(5);
    }
    
	/**
     * Test insert(T item)
     */
    @Test
    public void testInsert()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	maxPQ.insert(7);
    	assertEquals("Testing insert(T item)", 1, maxPQ.size());
    	maxPQ.insert(4);
    	assertEquals("Testing insert(T item)", 2, maxPQ.size());
    }
    
    /**
     * Test deleteMax()
     */
    @Test
    public void testDeleteMax()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test deleting maximum element on empty maximum priority queue
    	assertEquals("Testing deleteMax()", null, maxPQ.deleteMax());
    	
    	//Test deleting maximum element on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing deleteMax()", 10, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax()", 7, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax()", 4, (int)maxPQ.deleteMax());
    	assertEquals("Testing deleteMax()", 2, (int)maxPQ.deleteMax());
    }
    
    /**
     * Test isEmpty()
     */
    @Test
    public void testIsEmpty()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test isEmpty on empty maximum priority queue
    	assertEquals("Testing isEmpty()", true, maxPQ.isEmpty());
    	
    	//Test isEmpty on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing isEmpty()", false, maxPQ.isEmpty());
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test getting size in empty maximum priority queue
    	assertEquals("Testing size()", 0, maxPQ.size());
    	
    	//Test getting size in non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing size()", 4, maxPQ.size());   	
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test toString on empty maximum priority queue
    	assertEquals("Testing toString()", "<- (Next Out) <- (Last In)\n", maxPQ.toString());
    	
    	//Test toString on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing toString()", "<- (Next Out) 10 4 7 2 <- (Last In)\n", maxPQ.toString()); 
    }
}