import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*************************************************************************
 *  Minimum Priority Queue test class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQTest 
{    
    /**
     * Test constructor 
     */
    @Test
    public void testConstructor()
    {  	
    	new MinPQ(5);
    }
    
	/**
     * Test insert()
     */
    @Test
    public void testInsert()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test inserting elements 
    	minPQ.insert(7);
    	assertEquals("Testing insert", 1, minPQ.size());
    	minPQ.insert(4);
    	assertEquals("Testing insert", 2, minPQ.size());
    }
    
    /**
     * Test deleteMin()
     */
    @Test
    public void testDeleteMin()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test deleting minimum element on empty minimum priority queue
    	assertEquals("Testing deleteMin on an empty minimum priority queue", null, minPQ.deleteMin());
    	
    	//Test deleting minimum element on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing deleteMin on a non-empty minimum priority queue", new Integer(2), minPQ.deleteMin());
    	assertEquals("Testing deleteMin on a non-empty minimum priority queue", new Integer(4), minPQ.deleteMin());
    	assertEquals("Testing deleteMin on a non-empty minimum priority queue", new Integer(7), minPQ.deleteMin());
    	assertEquals("Testing deleteMin on a non-empty minimum priority queue", new Integer(10), minPQ.deleteMin());
    }
    
    /**
     * Test isEmpty()
     */
    @Test
    public void testIsEmpty()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test isEmpty on empty minimum priority queue
    	assertEquals("Testing isEmpty on an empty minimum priority queue", true, minPQ.isEmpty());
    	
    	//Test isEmpty on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing isEmpty on a non-empty minimum priority queue", false, minPQ.isEmpty());
    }
    
    /**
     * Test size()
     */
    @Test
    public void testSize()
    {
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test getting size in empty minimum priority queue
    	assertEquals("Testing size in an empty minimum priority queue", 0, minPQ.size());
    	
    	//Test getting size in non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing size in a non-empty minimum priority queue", 4, minPQ.size());   	
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	MinPQ<Integer> minPQ = new MinPQ<Integer>(5);
    	
    	//Test toString on empty minimum priority queue
    	assertEquals("Testing toString on an empty minimum priority queue", "<- (Next Out) <- (Last In)\n", minPQ.toString());
    	
    	//Test toString on non-empty minimum priority queue
    	minPQ.insert(7);
    	minPQ.insert(4);
    	minPQ.insert(10);
    	minPQ.insert(2);
    	assertEquals("Testing toString on a non-empty minimum priority queue", "<- (Next Out) 2 4 10 7 <- (Last In)\n", minPQ.toString()); 
    }
}
