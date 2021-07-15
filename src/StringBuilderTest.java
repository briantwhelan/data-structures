import static org.junit.Assert.assertEquals;
import org.junit.Test;
/*************************************************************************
 *  StringBuilder test class.
 *
 *  @version 16/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class StringBuilderTest 
{
    /**
     * Test {@code StringBuilder()} 
     */
    @Test
    public void testConstructor1()
    {  	
    	new StringBuilder();
    }
    
    /**
     * Test {@code StringBuilder(int initialCapacity)} 
     */
    @Test
    public void testConstructor2()
    {  	
    	new StringBuilder(32);
    	try{new StringBuilder(-1);}catch(Exception e){};
    }
    
    /**
     * Test {@code StringBuilder(String string)} 
     */
    @Test
    public void testConstructor3()
    {  	
    	new StringBuilder("Test");
    }
    
    /**
     * Test {@code size()}
     */
    @Test
    public void testSize()
    {
    	StringBuilder stringBuilder = new StringBuilder();
    	 
    	assertEquals("Testing size()", 0, stringBuilder.size());
    	stringBuilder.add('T');
    	assertEquals("Testing size()", 1, stringBuilder.size());
    	stringBuilder.add('s');
    	assertEquals("Testing size()", 2, stringBuilder.size());
    	stringBuilder.add('t');
    	assertEquals("Testing size()", 3, stringBuilder.size());
    }
    
    /**
     * Test {@code add(T element)}
     */
    @Test
    public void testAdd()
    {
    	StringBuilder stringBuilder = new StringBuilder();
   	 
    	assertEquals("Testing add(T element)", "", stringBuilder.toString());
    	stringBuilder.add('T');
    	assertEquals("Testing add(T element)", "T", stringBuilder.toString());
    	stringBuilder.add('s');
    	assertEquals("Testing add(T element)", "Ts", stringBuilder.toString());
    	stringBuilder.add('t');
    	assertEquals("Testing add(T element)", "Tst", stringBuilder.toString());
    }
    
    /**
     * Test {@code remove(int index)}
     */
    @Test
    public void testRemove()
    {
    	StringBuilder stringBuilder = new StringBuilder("Test");
    	
    	assertEquals("Testing remove(int index) - Removing invalid index (negative)", '\u0000', stringBuilder.remove(-1));
    	assertEquals("Testing remove(int index) - Removing invalid index (positive)", '\u0000', stringBuilder.remove(4));
    	assertEquals("Testing remove(int index)", 'T', stringBuilder.remove(0));
    	assertEquals("Testing remove(int index)", 'e', stringBuilder.remove(0));
    	assertEquals("Testing remove(int index)", 's', stringBuilder.remove(0));   
    	assertEquals("Testing remove(int index)", 't', stringBuilder.remove(0)); 
    }
    
    /**
     * Test {@code get(int index)}
     */
    @Test
    public void testGet()
    {
    	StringBuilder stringBuilder = new StringBuilder("Tst");
    	
    	assertEquals("Testing get(int index) - Getting invalid index (negative)", '\u0000', stringBuilder.get(-1));
    	assertEquals("Testing get(int index) - Getting invalid index (positive)", '\u0000', stringBuilder.get(3));
    	assertEquals("Testing get(int index)", 'T', stringBuilder.get(0));
    	assertEquals("Testing get(int index)", 's', stringBuilder.get(1));
    	assertEquals("Testing get(int index)", 't', stringBuilder.get(2));
    }
    
    /**
     * Test {@code toString()}
     */
    @Test
    public void testToString()
    {
    	StringBuilder stringBuilder = new StringBuilder();
    	
    	assertEquals("Testing toString()", "", stringBuilder.toString());
    	stringBuilder.add('T');
    	assertEquals("Testing toString()", "T", stringBuilder.toString());
    	stringBuilder.add('s');
    	assertEquals("Testing toString()", "Ts", stringBuilder.toString());
    	stringBuilder.add('t');
    	assertEquals("Testing toString()", "Tst", stringBuilder.toString());
    }
}