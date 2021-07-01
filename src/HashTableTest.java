import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  HashTable test class.
 *
 *  @version 1/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class HashTableTest
{	
	/**
     * Test HashTable() 
     */
	@Test
	public void testConstructor()
	{
		new HashTable<Integer, Integer>();		     
	}
	
	/**
     * Test size() 
     */
	@Test
	public void testSize()
	{
		HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
		
		assertEquals("Testing size()", 0, hashTable.size());
		hashTable.put(5, 5);
		assertEquals("Testing size()", 1, hashTable.size());	
		hashTable.put(15, 15);
		assertEquals("Testing size()", 2, hashTable.size());	
		hashTable.put(10, 10);
		assertEquals("Testing size()", 3, hashTable.size());	
	}
	
	/**
     * Test get(Key key)  
     */
	@Test
	public void testGet()
	{
		HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
		
		assertEquals("Testing get(Key key)", null, hashTable.get(8));
  		hashTable.put(7, 7);   
  		hashTable.put(8, 8);  
  		hashTable.put(3, 3);   
  		hashTable.put(1, 1);   
  		hashTable.put(2, 2);   
  		hashTable.put(6, 6);   
  		hashTable.put(4, 4);  
  		hashTable.put(5, 5);   		
		assertEquals("Testing get(Key key)", null, hashTable.get(9));	
		assertEquals("Testing get(Key key)", 8, (int)hashTable.get(8));	
		assertEquals("Testing get(Key key)", 2, (int)hashTable.get(2));	
	}
	
	/**
     * Test contains(Key key)  
     */
	@Test
	public void testContains()
	{
		HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
		
		assertEquals("Testing contains(Key key)", false, hashTable.contains(10));
		hashTable.put(5, 5);
		assertEquals("Testing contains(Key key)", false, hashTable.contains(10));	
		hashTable.put(10, 10);
		assertEquals("Testing contains(Key key)", true, hashTable.contains(10));	
		hashTable.put(15, 15);
		assertEquals("Testing contains(Key key)", true, hashTable.contains(5));	
	}
	
	
	/**
     * Test put(Key key, Value value)  
     */
	@Test
	public void testPut()
	{
		HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
		
		assertEquals("Testing put(Key key, Value value)", "index\tkey  \tvalue", hashTable.toString());
  		hashTable.put(7, 7);   
  		hashTable.put(8, 8);   
  		hashTable.put(3, 3);   
  		hashTable.put(1, 1);  
  		hashTable.put(2, 2);  
  		hashTable.put(6, 6);  
  		hashTable.put(4, 4);   
  		hashTable.put(5, 5);  					
  		assertEquals("Testing put(Key key, Value value)", "index\tkey  \tvalue"
											       		 + "\n1    \t1    \t1    "
											       		 + "\n2    \t2    \t2    "
											       		 + "\n3    \t3    \t3    "
											       		 + "\n4    \t4    \t4    "
											       		 + "\n5    \t5    \t5    "
											       		 + "\n6    \t6    \t6    "
											       		 + "\n7    \t7    \t7    "
											       		 + "\n8    \t8    \t8    ", 
											       		 hashTable.toString());
  		hashTable.put(8, 10);
  		assertEquals("Testing put(Key key, Value value)", "index\tkey  \tvalue"
											       		 + "\n1    \t1    \t1    "
											       		 + "\n2    \t2    \t2    "
											       		 + "\n3    \t3    \t3    "
											       		 + "\n4    \t4    \t4    "
											       		 + "\n5    \t5    \t5    "
											       		 + "\n6    \t6    \t6    "
											       		 + "\n7    \t7    \t7    "
											       		 + "\n8    \t8    \t10   ", 
											       		 hashTable.toString());
  		hashTable.put(8, null);
  		assertEquals("Testing put(Key key, Value value)", "index\tkey  \tvalue"
											       		 + "\n1    \t1    \t1    "
											       		 + "\n2    \t2    \t2    "
											       		 + "\n3    \t3    \t3    "
											       		 + "\n4    \t4    \t4    "
											       		 + "\n5    \t5    \t5    "
											       		 + "\n6    \t6    \t6    "
											       		 + "\n7    \t7    \t7    ",
											       		 hashTable.toString());
	}
	  
	
	/**
     * Test delete(Key key) 
     */
    @Test
    public void testDelete() 
    {
        HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
        
        hashTable.delete(1);
        assertEquals("Testing delete(Key key)", "index\tkey  \tvalue", hashTable.toString());
        hashTable.put(7, 7);  
        hashTable.put(8, 8);  
        hashTable.put(3, 3); 
        hashTable.put(1, 1);   
        hashTable.put(2, 2);   
        hashTable.put(6, 6);  
        hashTable.put(4, 4);   
        hashTable.put(5, 5);      
        hashTable.delete(9);
        assertEquals("Testing delete(Key key)", "index\tkey  \tvalue"
									       		 + "\n1    \t1    \t1    "
									       		 + "\n2    \t2    \t2    "
									       		 + "\n3    \t3    \t3    "
									       		 + "\n4    \t4    \t4    "
									       		 + "\n5    \t5    \t5    "
									       		 + "\n6    \t6    \t6    "
									       		 + "\n7    \t7    \t7    "
									       		 + "\n8    \t8    \t8    ", 
									       		 hashTable.toString());
        hashTable.delete(8);
        assertEquals("Testing delete(Key key)", "index\tkey  \tvalue"
									       		 + "\n1    \t1    \t1    "
									       		 + "\n2    \t2    \t2    "
									       		 + "\n3    \t3    \t3    "
									       		 + "\n4    \t4    \t4    "
									       		 + "\n5    \t5    \t5    "
									       		 + "\n6    \t6    \t6    "
									       		 + "\n7    \t7    \t7    ", 
									       		 hashTable.toString());
        hashTable.delete(6);
        assertEquals("Testing delete(Key key)", "index\tkey  \tvalue"
									       		 + "\n1    \t1    \t1    "
									       		 + "\n2    \t2    \t2    "
									       		 + "\n3    \t3    \t3    "
									       		 + "\n4    \t4    \t4    "
									       		 + "\n5    \t5    \t5    "
									       		 + "\n7    \t7    \t7    ", 
									       		 hashTable.toString());
        hashTable.delete(3);
        assertEquals("Testing delete(Key key)", "index\tkey  \tvalue"
									       		 + "\n1    \t1    \t1    "
									       		 + "\n2    \t2    \t2    "
									       		 + "\n4    \t4    \t4    "
									       		 + "\n5    \t5    \t5    "
									       		 + "\n7    \t7    \t7    ", 
									       		 hashTable.toString());
    } 

  	/**
     * Test toString() 
     */
 	@Test
 	public void testToString() 
 	{
         HashTable<Integer, Integer> hashTable = new HashTable<Integer, Integer>();
         
         assertEquals("Testing toString()", "index\tkey  \tvalue", hashTable.toString());
         hashTable.put(7, 7);
         hashTable.put(8, 8);       
         hashTable.put(3, 3);     
         hashTable.put(1, 1);      
         hashTable.put(2, 2);      
         hashTable.put(6, 6);     
         hashTable.put(4, 4);      
         hashTable.put(5, 5);       
         String expectedString = "index\tkey  \tvalue"
				        		 + "\n1    \t1    \t1    "
				        		 + "\n2    \t2    \t2    "
				        		 + "\n3    \t3    \t3    "
				        		 + "\n4    \t4    \t4    "
				        		 + "\n5    \t5    \t5    "
				        		 + "\n6    \t6    \t6    "
				        		 + "\n7    \t7    \t7    "
				        		 + "\n8    \t8    \t8    ";
         assertEquals("Testing toString()", expectedString, hashTable.toString());
     }
}