import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  RedBlackBST test class.
 *
 *  @version 29/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class RedBlackBSTTest
{	
	/**
     * Test RedBlackBST() 
     */
	@Test
	public void testConstructor()
	{
		new RedBlackBST<Integer, Integer>();		     
	}
	
	/**
     * Test size() 
     */
	@Test
	public void testSize()
	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing size()", 0, redBlackBST.size());
		redBlackBST.put(5, 5);
		assertEquals("Testing size()", 1, redBlackBST.size());	
		redBlackBST.put(15, 15);
		assertEquals("Testing size()", 2, redBlackBST.size());	
		redBlackBST.put(10, 10);
		assertEquals("Testing size()", 3, redBlackBST.size());	
	}
	
	/**
     * Test get(Key key)  
     */
	@Test
	public void testGet()
	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing get(Key key)", null, redBlackBST.get(8));
  		redBlackBST.put(7, 7);   //        _7_
  		redBlackBST.put(8, 8);   //      /     \
  		redBlackBST.put(3, 3);   //    _3_      8
  		redBlackBST.put(1, 1);   //  /     \
  		redBlackBST.put(2, 2);   // 1       6
  		redBlackBST.put(6, 6);   //  \     /
  		redBlackBST.put(4, 4);   //   2   4
  		redBlackBST.put(5, 5);   //        \
  							     //         5
		assertEquals("Testing get(Key key)", null, redBlackBST.get(9));	
		assertEquals("Testing get(Key key)", 8, (int)redBlackBST.get(8));	
		assertEquals("Testing get(Key key)", 2, (int)redBlackBST.get(2));	
	}
	
	/**
     * Test contains(Key key)  
     */
	@Test
	public void testContains()
	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing contains(Key key)", false, redBlackBST.contains(10));
		redBlackBST.put(5, 5);
		assertEquals("Testing contains(Key key)", false, redBlackBST.contains(10));	
		redBlackBST.put(10, 10);
		assertEquals("Testing contains(Key key)", true, redBlackBST.contains(10));	
		redBlackBST.put(15, 15);
		assertEquals("Testing contains(Key key)", true, redBlackBST.contains(5));	
	}
	
	/**
     * Test put(Key key, Value value)  
     */
	@Test
	public void testPut()
	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing put(Key key, Value value)", "()", redBlackBST.printKeysInOrder());
  		redBlackBST.put(7, 7);   
  		redBlackBST.put(8, 8);   
  		redBlackBST.put(3, 3);   
  		redBlackBST.put(1, 1);   
  		redBlackBST.put(2, 2);   
  		redBlackBST.put(6, 6);   
  		redBlackBST.put(4, 4);   
  		redBlackBST.put(5, 5);   
  							     
  		assertEquals("Testing put(Key key, Value value)",
  				"(((()1())2(()3()))4(((()5())6())7(()8())))", redBlackBST.printKeysInOrder());
  		redBlackBST.put(8, 10);
  		assertEquals("Testing put(Key key, Value value)",
  				"(((()1())2(()3()))4(((()5())6())7(()8())))", redBlackBST.printKeysInOrder());
  		//redBlackBST.put(8, null);
  		//assertEquals("Testing put(Key key, Value value)",
  				//"(((()1())2(()3()))4(((()5())6())7()))", redBlackBST.printKeysInOrder());
	}
	  
	/**
     * Test height()  
     */
	@Test
	public void testHeight()
  	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing height()", -1, redBlackBST.height());
		redBlackBST.put(7, 7);
		assertEquals("Testing height()", 0, redBlackBST.height()); 
		redBlackBST.put(8, 8); 
		assertEquals("Testing height()", 0, redBlackBST.height()); //1 with red links
		redBlackBST.put(3, 3);  
		assertEquals("Testing height()", 1, redBlackBST.height());
    	redBlackBST.put(1, 1);      
    	assertEquals("Testing height()", 1, redBlackBST.height()); //2 with red links
    	redBlackBST.put(2, 2);      
    	assertEquals("Testing height()", 1, redBlackBST.height()); //2 with red links
    	redBlackBST.put(6, 6);      
    	assertEquals("Testing height()", 1, redBlackBST.height()); //3 with red links
    	redBlackBST.put(4, 4);      
    	assertEquals("Testing height()", 2, redBlackBST.height());
    	redBlackBST.put(5, 5); 
    	assertEquals("Testing height()", 2, redBlackBST.height()); //3 with red links
  	}
	
	/**
     * Test median()  
     */
	@Test
	public void testMedian()
  	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing median()", null, redBlackBST.median());
		redBlackBST.put(7, 7);
		assertEquals("Testing median()", 7, (int)redBlackBST.median());
		redBlackBST.put(8, 8); 
		assertEquals("Testing median()", 7, (int)redBlackBST.median());
		redBlackBST.put(3, 3);  
		assertEquals("Testing median()", 7, (int)redBlackBST.median());
    	redBlackBST.put(1, 1);      
    	assertEquals("Testing median()", 3, (int)redBlackBST.median());
    	redBlackBST.put(2, 2);      
    	assertEquals("Testing median()", 3, (int)redBlackBST.median());
    	redBlackBST.put(6, 6);      
    	assertEquals("Testing median()", 3, (int)redBlackBST.median());
    	redBlackBST.put(4, 4);      
    	assertEquals("Testing median()", 4, (int)redBlackBST.median());
    	redBlackBST.put(5, 5); 
    	assertEquals("Testing median()", 4, (int)redBlackBST.median());
  	}
	
	/**
     * Test select(int numberOfSmallerKeys) 
     */
	@Test
	public void testSelect()
  	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing select(int numberOfSmallerKeys)", null, redBlackBST.select(0));
		assertEquals("Testing select(int numberOfSmallerKeys)", null, redBlackBST.select(-2));		
		redBlackBST.put(7, 7);
		assertEquals("Testing select(int numberOfSmallerKeys)", 7, (int)redBlackBST.select(0));
		redBlackBST.put(8, 8); 
		assertEquals("Testing select(int numberOfSmallerKeys)", 8, (int)redBlackBST.select(1));
		redBlackBST.put(3, 3);  
		assertEquals("Testing select(int numberOfSmallerKeys)", 8, (int)redBlackBST.select(2));
    	redBlackBST.put(1, 1);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 1, (int)redBlackBST.select(0));
    	redBlackBST.put(2, 2);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 2, (int)redBlackBST.select(1));
    	redBlackBST.put(6, 6);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 6, (int)redBlackBST.select(3));
    	redBlackBST.put(4, 4);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 4, (int)redBlackBST.select(3));
    	redBlackBST.put(5, 5);
    	assertEquals("Testing select(int numberOfSmallerKeys)", 5, (int)redBlackBST.select(4));    	
  	}
	
	/**
     * Test max() 
     */
	@Test
	public void testMax()
	{
		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
		
		assertEquals("Testing max()", null, redBlackBST.max());
  		redBlackBST.put(5, 5); 
  		assertEquals("Testing max()", 5, (int)redBlackBST.max());
  		redBlackBST.put(15, 15);
  		assertEquals("Testing max()", 15, (int)redBlackBST.max());
  		redBlackBST.put(10, 10); 
  		assertEquals("Testing max()", 15, (int)redBlackBST.max());
	}
  
	/**
     * Test printKeysInOrder() 
     */
  	@Test
  	public void testPrintKeysInOrder() 
  	{
  		RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
  		
  		assertEquals("Testing printKeysInOrder()", "()", redBlackBST.printKeysInOrder());
  		redBlackBST.put(7, 7);  
  		redBlackBST.put(8, 8);  
  		redBlackBST.put(3, 3);   
  		redBlackBST.put(1, 1);   
  		redBlackBST.put(2, 2);  
  		redBlackBST.put(6, 6);   
  		redBlackBST.put(4, 4);  
  		redBlackBST.put(5, 5);  
  		assertEquals("Testing printKeysInOrder()",
  				"(((()1())2(()3()))4(((()5())6())7(()8())))", redBlackBST.printKeysInOrder());
  	}
   	
  	/**
     * Test toString() 
     */
 	@Test
 	public void testToString() 
 	{
         RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<Integer, Integer>();
         
         assertEquals("Testing toString()", "-null\n", redBlackBST.toString());
         redBlackBST.put(7, 7);
         redBlackBST.put(8, 8);       
         redBlackBST.put(3, 3);     
         redBlackBST.put(1, 1);      
         redBlackBST.put(2, 2);      
         redBlackBST.put(6, 6);     
         redBlackBST.put(4, 4);      
         redBlackBST.put(5, 5);       
         String expectedString = 
          "-4\n" +
          " |-2\n" + 
          " | |-1\n" +
          " | | |-null\n" + 
          " | |  -null\n" +
          " |  -3\n" +
          " |   |-null\n" +
          " |    -null\n" +
          "  -7\n" +
          "   |-6\n" +
          "   | /-5\n" +
          "   | / |-null\n" +
          "   | /  -null\n" +
          "   |  -null\n" +
          "    -8\n" +
          "     |-null\n" +
          "      -null\n";
         assertEquals("Testing toString()", expectedString, redBlackBST.toString());
     }
	
}