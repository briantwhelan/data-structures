import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  BinarySearchTree test class.
 *
 *  @version 20/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTreeTest
{	
	/**
     * Test {@code BinarySearchTree()} 
     */
	@Test
	public void testConstructor()
	{
		new BinarySearchTree<Integer, Integer>();		     
	}
	
	/**
     * Test {@code size()} 
     */
	@Test
	public void testSize()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing size()", 0, binarySearchTree.size());
		binarySearchTree.put(5, 5);
		assertEquals("Testing size()", 1, binarySearchTree.size());	
		binarySearchTree.put(15, 15);
		assertEquals("Testing size()", 2, binarySearchTree.size());	
		binarySearchTree.put(10, 10);
		assertEquals("Testing size()", 3, binarySearchTree.size());	
	}
	
	/**
     * Test {@code height()}  
     */
	@Test
	public void testHeight()
  	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing height()", -1, binarySearchTree.height());
		binarySearchTree.put(7, 7);
		assertEquals("Testing height()", 0, binarySearchTree.height());
		binarySearchTree.put(8, 8); 
		assertEquals("Testing height()", 1, binarySearchTree.height());
		binarySearchTree.put(3, 3);  
		assertEquals("Testing height()", 1, binarySearchTree.height());
    	binarySearchTree.put(1, 1);      
    	assertEquals("Testing height()", 2, binarySearchTree.height());
    	binarySearchTree.put(2, 2);      
    	assertEquals("Testing height()", 3, binarySearchTree.height());
    	binarySearchTree.put(6, 6);      
    	assertEquals("Testing height()", 3, binarySearchTree.height());
    	binarySearchTree.put(4, 4);      
    	assertEquals("Testing height()", 3, binarySearchTree.height());
    	binarySearchTree.put(5, 5); 
    	assertEquals("Testing height()", 4, binarySearchTree.height());     
  	}
	
	/**
     * Test {@code put(Key key, Value value)}  
     */
	@Test
	public void testPut()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing put(Key key, Value value)", "()", binarySearchTree.printKeysInOrder());
  		binarySearchTree.put(7, 7);   //        _7_
  		binarySearchTree.put(8, 8);   //      /     \
  		binarySearchTree.put(3, 3);   //    _3_      8
  		binarySearchTree.put(1, 1);   //  /     \
  		binarySearchTree.put(2, 2);   // 1       6
  		binarySearchTree.put(6, 6);   //  \     /
  		binarySearchTree.put(4, 4);   //   2   4
  		binarySearchTree.put(5, 5);   //        \
  									  //         5
  		assertEquals("Testing put(Key key, Value value)",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
  		binarySearchTree.put(8, 10);
  		assertEquals("Testing put(Key key, Value value)",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
  		binarySearchTree.put(8, null);
  		assertEquals("\"Testing put(Key key, Value value)\"",
  				"(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
	}
	
	/**
     * Test {@code delete(Key key)} 
     */
    @Test
    public void testDelete() 
    {
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.delete(1);
        assertEquals("Testing delete(Key key)", "()", binarySearchTree.printKeysInOrder());
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
                         			  //         5           
        binarySearchTree.delete(9);
        assertEquals("Testing delete(Key key)",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(8);
        assertEquals("Testing delete(Key key)", "(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(6);
        assertEquals("Testing delete(Key key)",
                "(((()1(()2()))3(()4(()5())))7())", binarySearchTree.printKeysInOrder());
        binarySearchTree.delete(3);
        assertEquals("Testing delete(Key key)",
                "(((()1())2(()4(()5())))7())", binarySearchTree.printKeysInOrder());
        
        binarySearchTree = new BinarySearchTree<Integer, Integer>();
        
        binarySearchTree.put(7, 7);   //        _7_
        binarySearchTree.put(8, 8);   //      /     \
        binarySearchTree.put(3, 3);   //    _3_      8
        binarySearchTree.put(1, 1);   //  /     \
        binarySearchTree.put(2, 2);   // 1       6
        binarySearchTree.put(6, 6);   //  \     /
        binarySearchTree.put(4, 4);   //   2   4
        binarySearchTree.put(5, 5);   //        \
        							  //         5
        binarySearchTree.delete(1);
        assertEquals("Testing delete(Key key)",
                "(((()2())3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
    } 
    
    /**
     * Test {@code deleteMax()} 
     */
	@Test
	public void testDeleteMax()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		binarySearchTree.deleteMax();
		assertEquals("Testing deleteMax()", "()", binarySearchTree.printKeysInOrder());
  		binarySearchTree.put(7, 7);   //        _7_
  		binarySearchTree.put(8, 8);   //      /     \
  		binarySearchTree.put(3, 3);   //    _3_      8
  		binarySearchTree.put(1, 1);   //  /     \    
  		binarySearchTree.put(2, 2);   // 1       6  
  		binarySearchTree.put(6, 6);   //  \     /
  		binarySearchTree.put(4, 4);   //   2   4
  		binarySearchTree.put(5, 5);   //        \
  									  //         5
  		binarySearchTree.deleteMax();
  		assertEquals("Testing deleteMax()",
  				"(((()1(()2()))3((()4(()5()))6()))7())", binarySearchTree.printKeysInOrder());
  		binarySearchTree.deleteMax();
  		assertEquals("Testing deleteMax()",
  				"((()1(()2()))3((()4(()5()))6()))", binarySearchTree.printKeysInOrder());
  		binarySearchTree.deleteMax();
  		assertEquals("Testing deleteMax()",
  				"((()1(()2()))3(()4(()5())))", binarySearchTree.printKeysInOrder());
	}
	
	/**
     * Test {@code max()} 
     */
	@Test
	public void testMax()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing max()", null, binarySearchTree.max());
  		binarySearchTree.put(5, 5); 
  		assertEquals("Testing max()", 5, (int)binarySearchTree.max());
  		binarySearchTree.put(15, 15);
  		assertEquals("Testing max()", 15, (int)binarySearchTree.max());
  		binarySearchTree.put(10, 10); 
  		assertEquals("Testing max()", 15, (int)binarySearchTree.max());
	}
	
	/**
     * Test {@code get(Key key)}  
     */
	@Test
	public void testGet()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing get(Key key)", null, binarySearchTree.get(8));
  		binarySearchTree.put(7, 7);   //        _7_
  		binarySearchTree.put(8, 8);   //      /     \
  		binarySearchTree.put(3, 3);   //    _3_      8
  		binarySearchTree.put(1, 1);   //  /     \
  		binarySearchTree.put(2, 2);   // 1       6
  		binarySearchTree.put(6, 6);   //  \     /
  		binarySearchTree.put(4, 4);   //   2   4
  		binarySearchTree.put(5, 5);   //        \
  									  //         5
		assertEquals("Testing get(Key key)", null, binarySearchTree.get(9));	
		assertEquals("Testing get(Key key)", 8, (int)binarySearchTree.get(8));	
		assertEquals("Testing get(Key key)", 2, (int)binarySearchTree.get(2));	
	}
	
	/**
     * Test {@code contains(Key key)}  
     */
	@Test
	public void testContains()
	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing contains(Key key)", false, binarySearchTree.contains(10));
		binarySearchTree.put(5, 5);
		assertEquals("Testing contains(Key key)", false, binarySearchTree.contains(10));	
		binarySearchTree.put(10, 10);
		assertEquals("Testing contains(Key key)", true, binarySearchTree.contains(10));	
		binarySearchTree.put(15, 15);
		assertEquals("Testing contains(Key key)", true, binarySearchTree.contains(5));	
	}
	
	/**
     * Test {@code select(int numberOfSmallerKeys)} 
     */
	@Test
	public void testSelect()
  	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing select(int numberOfSmallerKeys)", null, binarySearchTree.select(0));
		assertEquals("Testing select(int numberOfSmallerKeys)", null, binarySearchTree.select(-2));		
		binarySearchTree.put(7, 7);
		assertEquals("Testing select(int numberOfSmallerKeys)", 7, (int)binarySearchTree.select(0));
		binarySearchTree.put(8, 8); 
		assertEquals("Testing select(int numberOfSmallerKeys)", 8, (int)binarySearchTree.select(1));
		binarySearchTree.put(3, 3);  
		assertEquals("Testing select(int numberOfSmallerKeys)", 8, (int)binarySearchTree.select(2));
    	binarySearchTree.put(1, 1);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 1, (int)binarySearchTree.select(0));
    	binarySearchTree.put(2, 2);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 2, (int)binarySearchTree.select(1));
    	binarySearchTree.put(6, 6);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 6, (int)binarySearchTree.select(3));
    	binarySearchTree.put(4, 4);      
    	assertEquals("Testing select(int numberOfSmallerKeys)", 4, (int)binarySearchTree.select(3));
    	binarySearchTree.put(5, 5);
    	assertEquals("Testing select(int numberOfSmallerKeys)", 5, (int)binarySearchTree.select(4));    	
  	}

	/**
     * Test {@code median()}  
     */
	@Test
	public void testMedian()
  	{
		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
		
		assertEquals("Testing median()", null, binarySearchTree.median());
		binarySearchTree.put(7, 7);
		assertEquals("Testing median()", 7, (int)binarySearchTree.median());
		binarySearchTree.put(8, 8); 
		assertEquals("Testing median()", 7, (int)binarySearchTree.median());
		binarySearchTree.put(3, 3);  
		assertEquals("Testing median()", 7, (int)binarySearchTree.median());
    	binarySearchTree.put(1, 1);      
    	assertEquals("Testing median()", 3, (int)binarySearchTree.median());
    	binarySearchTree.put(2, 2);      
    	assertEquals("Testing median()", 3, (int)binarySearchTree.median());
    	binarySearchTree.put(6, 6);      
    	assertEquals("Testing median()", 3, (int)binarySearchTree.median());
    	binarySearchTree.put(4, 4);      
    	assertEquals("Testing median()", 4, (int)binarySearchTree.median());
    	binarySearchTree.put(5, 5); 
    	assertEquals("Testing median()", 4, (int)binarySearchTree.median());
  	}

	/**
     * Test {@code printKeysInOrder()} 
     */
  	@Test
  	public void testPrintKeysInOrder() 
  	{
  		BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
  		
  		assertEquals("Testing printKeysInOrder()", "()", binarySearchTree.printKeysInOrder());
  		binarySearchTree.put(7, 7);   //        _7_
  		binarySearchTree.put(8, 8);   //      /     \
  		binarySearchTree.put(3, 3);   //    _3_      8
  		binarySearchTree.put(1, 1);   //  /     \
  		binarySearchTree.put(2, 2);   // 1       6
  		binarySearchTree.put(6, 6);   //  \     /
  		binarySearchTree.put(4, 4);   //   2   4
  		binarySearchTree.put(5, 5);   //        \
  						 			  //         5
  		assertEquals("Testing printKeysInOrder()",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", binarySearchTree.printKeysInOrder());
  	}
   	
  	/**
     * Test {@code toString()} 
     */
 	@Test
 	public void testToString() 
 	{
         BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<Integer, Integer>();
         
         assertEquals("Testing toString()", "-null\n", binarySearchTree.toString());
         binarySearchTree.put(7, 7);
         binarySearchTree.put(8, 8);       
         binarySearchTree.put(3, 3);     
         binarySearchTree.put(1, 1);      
         binarySearchTree.put(2, 2);      
         binarySearchTree.put(6, 6);     
         binarySearchTree.put(4, 4);      
         binarySearchTree.put(5, 5);       
         String expectedString = 
          "-7\n" +
          " |-3\n" + 
          " | |-1\n" +
          " | | |-null\n" + 
          " | |  -2\n" +
          " | |   |-null\n" +
          " | |    -null\n" +
          " |  -6\n" +
          " |   |-4\n" +
          " |   | |-null\n" +
          " |   |  -5\n" +
          " |   |   |-null\n" +
          " |   |    -null\n" +
          " |    -null\n" +
          "  -8\n" +
          "   |-null\n" +
          "    -null\n";
         assertEquals("Testing toString()", expectedString, binarySearchTree.toString());
     }
}