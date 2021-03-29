import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  Maximum Priority Queue test class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQTest 
{    
    /**
     * Test constructor 
     */
    @Test
    public void testConstructor()
    {  	
    	new MaxPQ(5);
    }
    
	/**
     * Test insert()
     */
    @Test
    public void testInsert()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test inserting elements 
    	maxPQ.insert(7);
    	assertEquals("Testing insert", 1, maxPQ.size());
    	maxPQ.insert(4);
    	assertEquals("Testing insert", 2, maxPQ.size());
    }
    
    /**
     * Test deleteMax()
     */
    @Test
    public void testDeleteMax()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test deleting maximum element on empty maximum priority queue
    	assertEquals("Testing deleteMax on an empty maximum priority queue", null, maxPQ.deleteMax());
    	
    	//Test deleting maximum element on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing deleteMax on a non-empty maximum priority queue", new Integer(10), maxPQ.deleteMax());
    	assertEquals("Testing deleteMax on a non-empty maximum priority queue", new Integer(7), maxPQ.deleteMax());
    	assertEquals("Testing deleteMax on a non-empty maximum priority queue", new Integer(4), maxPQ.deleteMax());
    	assertEquals("Testing deleteMax on a non-empty maximum priority queue", new Integer(2), maxPQ.deleteMax());
    }
    
    /**
     * Test isEmpty()
     */
    @Test
    public void testIsEmpty()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test isEmpty on empty maximum priority queue
    	assertEquals("Testing isEmpty on an empty maximum priority queue", true, maxPQ.isEmpty());
    	
    	//Test isEmpty on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing isEmpty on a non-empty maximum priority queue", false, maxPQ.isEmpty());
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test getting size in empty maximum priority queue
    	assertEquals("Testing size in an empty maximum priority queue", 0, maxPQ.size());
    	
    	//Test getting size in non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing size in a non-empty maximum priority queue", 4, maxPQ.size());   	
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(5);
    	
    	//Test toString on empty maximum priority queue
    	assertEquals("Testing toString on an empty maximum priority queue", "<- (Next Out) <- (Last In)\n", maxPQ.toString());
    	
    	//Test toString on non-empty maximum priority queue
    	maxPQ.insert(7);
    	maxPQ.insert(4);
    	maxPQ.insert(10);
    	maxPQ.insert(2);
    	assertEquals("Testing toString on a non-empty maximum priority queue", "<- (Next Out) 10 4 7 2 <- (Last In)\n", maxPQ.toString()); 
    }
}
