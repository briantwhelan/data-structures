import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  BinarySearchTree test class.
 *
 *  @version 21/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTreeTest
{	
	@Test
	public void testConstructor()
	{
		new BinarySearchTree<Integer, Integer>();		     
	}
	
//	@Test
//	public void testIsEmpty()
//	{
//		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
//		assertEquals("Testing isEmpty for an empty tree", true, BinarySearchTree.isEmpty());
//		
//		BinarySearchTree.put(7, 7);
//		assertEquals("Testing isEmpty for a non-empty tree", false, BinarySearchTree.isEmpty());	
//	}
	
	@Test
	public void testSize()
	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing size for an empty tree", 0, BinarySearchTree.size());
		
		BinarySearchTree.put(7, 7);
		assertEquals("Testing size for a non-empty tree with 1 node", 1, BinarySearchTree.size());	
		
		BinarySearchTree.put(8, 8);
		assertEquals("Testing size for a non-empty tree with 2 nodes", 2, BinarySearchTree.size());	
	}
	
	@Test
	public void testContains()
	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing contains for an empty tree", false, BinarySearchTree.contains(8));
		
		BinarySearchTree.put(7, 7);
		assertEquals("Testing contains for a non-empty tree with key", false, BinarySearchTree.contains(8));	
		
		BinarySearchTree.put(8, 8);
		assertEquals("Testing contains for a non-empty tree without key", true, BinarySearchTree.contains(8));	
	}
	
	@Test
	public void testGet()
	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing get for an empty tree", null, (Integer)BinarySearchTree.get(8));
		
  		BinarySearchTree.put(7, 7);   //        _7_
  		BinarySearchTree.put(8, 8);   //      /     \
  		BinarySearchTree.put(3, 3);   //    _3_      8
  		BinarySearchTree.put(1, 1);   //  /     \
  		BinarySearchTree.put(2, 2);   // 1       6
  		BinarySearchTree.put(6, 6);   //  \     /
  		BinarySearchTree.put(4, 4);   //   2   4
  		BinarySearchTree.put(5, 5);   //        \
  						 //         5
  		
		assertEquals("Testing get for a non-empty tree without key", null, (Integer)BinarySearchTree.get(9));	
		
		BinarySearchTree.put(8, 8);
		assertEquals("Testing get for a non-empty tree with key", 8, (int)BinarySearchTree.get(8));	
		
		BinarySearchTree.put(8, 8);
		assertEquals("Testing get for a non-empty tree with key", 2, (int)BinarySearchTree.get(2));	
	}
	
	@Test
	public void testPut()
	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing put for an empty tree", "()", BinarySearchTree.printKeysInOrder());
		
  		BinarySearchTree.put(7, 7);   //        _7_
  		BinarySearchTree.put(8, 8);   //      /     \
  		BinarySearchTree.put(3, 3);   //    _3_      8
  		BinarySearchTree.put(1, 1);   //  /     \
  		BinarySearchTree.put(2, 2);   // 1       6
  		BinarySearchTree.put(6, 6);   //  \     /
  		BinarySearchTree.put(4, 4);   //   2   4
  		BinarySearchTree.put(5, 5);   //        \
  						 //         5
      
  		assertEquals("Testing put for a non-empty tree",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
  		
  		BinarySearchTree.put(8, 10);
  		assertEquals("Testing put when key is reused(should update val))",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
  		
  		BinarySearchTree.put(8, null);
  		assertEquals("Testing put when val is null(should delete)",
  				"(((()1(()2()))3((()4(()5()))6()))7())", BinarySearchTree.printKeysInOrder());
	}
	  
	@Test
	public void testHeight()
  	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing height for an empty tree", -1, BinarySearchTree.height());
	  
		BinarySearchTree.put(7, 7);
		assertEquals("Testing height for a non-empty tree with 1 node", 0, BinarySearchTree.height());
		BinarySearchTree.put(8, 8); 
		assertEquals("Testing height for a non-empty tree with 2 nodes", 1, BinarySearchTree.height());
		BinarySearchTree.put(3, 3);  
		assertEquals("Testing height for a non-empty tree with 3 nodes", 1, BinarySearchTree.height());
    	BinarySearchTree.put(1, 1);      
    	assertEquals("Testing height for a non-empty tree with 4 nodes", 2, BinarySearchTree.height());
    	BinarySearchTree.put(2, 2);      
    	assertEquals("Testing height for a non-empty tree with 5 nodes", 3, BinarySearchTree.height());
    	BinarySearchTree.put(6, 6);      
    	assertEquals("Testing height for a non-empty tree with 6 nodes", 3, BinarySearchTree.height());
    	BinarySearchTree.put(4, 4);      
    	assertEquals("Testing height for a non-empty tree with 7 nodes", 3, BinarySearchTree.height());
    	BinarySearchTree.put(5, 5); 
    	assertEquals("Testing height for a non-empty tree with 8 nodes", 4, BinarySearchTree.height());     
  	}
	
	@Test
	public void testMedian()
  	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing median for an empty tree", null, BinarySearchTree.median());
		
		BinarySearchTree.put(7, 7);
		assertEquals("Testing median for a non-empty tree with 1 node", new Integer(7), BinarySearchTree.median());
		BinarySearchTree.put(8, 8); 
		assertEquals("Testing median for a non-empty tree with 2 nodes", new Integer(7), BinarySearchTree.median());
		BinarySearchTree.put(3, 3);  
		assertEquals("Testing median for a non-empty tree with 3 nodes", new Integer(7), BinarySearchTree.median());
    	BinarySearchTree.put(1, 1);      
    	assertEquals("Testing median for a non-empty tree with 4 nodes", new Integer(3), BinarySearchTree.median());
    	BinarySearchTree.put(2, 2);      
    	assertEquals("Testing median for a non-empty tree with 5 nodes", new Integer(3), BinarySearchTree.median());
    	BinarySearchTree.put(6, 6);      
    	assertEquals("Testing median for a non-empty tree with 6 nodes", new Integer(3), BinarySearchTree.median());
    	BinarySearchTree.put(4, 4);      
    	assertEquals("Testing median for a non-empty tree with 7 nodes", new Integer(4), BinarySearchTree.median());
    	BinarySearchTree.put(5, 5); 
    	assertEquals("Testing median for a non-empty tree with 8 nodes", new Integer(4), BinarySearchTree.median());
  	}
	
	@Test
	public void testSelect()
  	{
		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
		assertEquals("Testing select for an empty tree", null, BinarySearchTree.median());
		
		BinarySearchTree.put(7, 7);
		assertEquals("Testing select for a non-empty tree with 1 node", new Integer(7), BinarySearchTree.select(0));
		BinarySearchTree.put(8, 8); 
		assertEquals("Testing select for a non-empty tree with 2 nodes", new Integer(8), BinarySearchTree.select(1));
		BinarySearchTree.put(3, 3);  
		assertEquals("Testing select for a non-empty tree with 3 nodes", new Integer(8), BinarySearchTree.select(2));
    	BinarySearchTree.put(1, 1);      
    	assertEquals("Testing select for a non-empty tree with 4 nodes", new Integer(1), BinarySearchTree.select(0));
    	BinarySearchTree.put(2, 2);      
    	assertEquals("Testing select for a non-empty tree with 5 nodes", new Integer(2), BinarySearchTree.select(1));
    	BinarySearchTree.put(6, 6);      
    	assertEquals("Testing select for a non-empty tree with 6 nodes", new Integer(6), BinarySearchTree.select(3));
    	BinarySearchTree.put(4, 4);      
    	assertEquals("Testing select for a non-empty tree with 7 nodes", new Integer(4), BinarySearchTree.select(3));
    	BinarySearchTree.put(5, 5);
    	assertEquals("Testing select for a non-empty tree with 8 nodes", new Integer(5), BinarySearchTree.select(4));
    	assertEquals("Testing select for a non-empty tree with 8 nodes", null, BinarySearchTree.select(9));
    	assertEquals("Testing select for a non-empty tree with 8 nodes", null, BinarySearchTree.select(-2));
  	}
  
  	@Test
  	public void testPrintKeysInOrder() 
  	{
  		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
  		BinarySearchTree.printKeysInOrder();
  		assertEquals("Printing keys in an empty tree", "()", BinarySearchTree.printKeysInOrder());
      
  		BinarySearchTree.put(7, 7);   //        _7_
  		BinarySearchTree.put(8, 8);   //      /     \
  		BinarySearchTree.put(3, 3);   //    _3_      8
  		BinarySearchTree.put(1, 1);   //  /     \
  		BinarySearchTree.put(2, 2);   // 1       6
  		BinarySearchTree.put(6, 6);   //  \     /
  		BinarySearchTree.put(4, 4);   //   2   4
  		BinarySearchTree.put(5, 5);   //        \
  						 //         5
      
  		assertEquals("Printing keys in non-empty tree",
  				"(((()1(()2()))3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
  	}
  
  	@Test
 	public void testPrettyPrint() 
 	{
         BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
         assertEquals("Checking pretty printing of empty tree",
                 "-null\n", BinarySearchTree.prettyPrintKeys());
          
                              //  -7
                              //   |-3
                              //   | |-1
                              //   | | |-null
         BinarySearchTree.put(7, 7);       //   | |  -2
         BinarySearchTree.put(8, 8);       //   | |   |-null
         BinarySearchTree.put(3, 3);       //   | |    -null
         BinarySearchTree.put(1, 1);       //   |  -6
         BinarySearchTree.put(2, 2);       //   |   |-4
         BinarySearchTree.put(6, 6);       //   |   | |-null
         BinarySearchTree.put(4, 4);       //   |   |  -5
         BinarySearchTree.put(5, 5);       //   |   |   |-null
                              //   |   |    -null
                              //   |    -null
                              //    -8
                              //     |-null
                              //      -null
         
         String result = 
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
         assertEquals("Checking pretty printing of non-empty tree", result, BinarySearchTree.prettyPrintKeys());
     }

  
     @Test
     public void testDelete() 
     {
         BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
         BinarySearchTree.delete(1);
         assertEquals("Deleting from empty tree", "()", BinarySearchTree.printKeysInOrder());
         
         BinarySearchTree.put(7, 7);   //        _7_
         BinarySearchTree.put(8, 8);   //      /     \
         BinarySearchTree.put(3, 3);   //    _3_      8
         BinarySearchTree.put(1, 1);   //  /     \
         BinarySearchTree.put(2, 2);   // 1       6
         BinarySearchTree.put(6, 6);   //  \     /
         BinarySearchTree.put(4, 4);   //   2   4
         BinarySearchTree.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
         
         BinarySearchTree.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
 
         BinarySearchTree.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", BinarySearchTree.printKeysInOrder());
 
         BinarySearchTree.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", BinarySearchTree.printKeysInOrder());
 
         BinarySearchTree.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", BinarySearchTree.printKeysInOrder());
         
         BinarySearchTree = new BinarySearchTree<Integer, Integer>();
         
         BinarySearchTree.put(7, 7);   //        _7_
         BinarySearchTree.put(8, 8);   //      /     \
         BinarySearchTree.put(3, 3);   //    _3_      8
         BinarySearchTree.put(1, 1);   //  /     \
         BinarySearchTree.put(2, 2);   // 1       6
         BinarySearchTree.put(6, 6);   //  \     /
         BinarySearchTree.put(4, 4);   //   2   4
         BinarySearchTree.put(5, 5);   //        \
                          //         5
         
         BinarySearchTree.delete(1);
         assertEquals("Deleting node with single child",
                 "(((()2())3((()4(()5()))6()))7(()8()))", BinarySearchTree.printKeysInOrder());
     } 
     
 	@Test
 	public void testDeleteMax()
 	{
 		BinarySearchTree<Integer, Integer> BinarySearchTree = new BinarySearchTree<Integer, Integer>();
 		BinarySearchTree.deleteMax();
 		assertEquals("Testing deleteMax for an empty tree", "()", BinarySearchTree.printKeysInOrder());
 		
   		BinarySearchTree.put(7, 7);   //        _7_
   		BinarySearchTree.put(8, 8);   //      /     \
   		BinarySearchTree.put(3, 3);   //    _3_      8
   		BinarySearchTree.put(1, 1);   //  /     \    
   		BinarySearchTree.put(2, 2);   // 1       6  
   		BinarySearchTree.put(6, 6);   //  \     /
   		BinarySearchTree.put(4, 4);   //   2   4
   		BinarySearchTree.put(5, 5);   //        \
   						 //         5
       
   		
   		BinarySearchTree.deleteMax();
   		assertEquals("Testing deleteMax for a non-empty tree",
   				"(((()1(()2()))3((()4(()5()))6()))7())", BinarySearchTree.printKeysInOrder());
   		BinarySearchTree.deleteMax();
   		assertEquals("Testing deleteMax for a non-empty tree",
   				"((()1(()2()))3((()4(()5()))6()))", BinarySearchTree.printKeysInOrder());
   		BinarySearchTree.deleteMax();
   		assertEquals("Testing deleteMax for a non-empty tree",
   				"((()1(()2()))3(()4(()5())))", BinarySearchTree.printKeysInOrder());
 	}
}

