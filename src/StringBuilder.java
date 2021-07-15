/*************************************************************************
 *  StringBuilder class.
 *
 *  @version 16/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class StringBuilder 
{
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private char[] stringBuilder;
	private int size;
	
	/**
     * Creates an empty {@code StringBuilder}.
     */
	public StringBuilder()
	{
		stringBuilder = new char[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
     * Creates an empty {@code StringBuilder} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code StringBuilder}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public StringBuilder(int initialCapacity)
    {
    	stringBuilder = new char[initialCapacity];
    	size = 0;
    }

    /**
     * Creates a {@code StringBuilder} from the specified {@code String}.
     * 
     * @param string the {@code String} from which to create the {@code StringBuilder}
     * @throws NullPointerException if {@code string} is {@code null}
     */
    public StringBuilder(String string) 
    {
    	stringBuilder = new char[string.length()];
    	for(int index = 0; index < string.length(); index++)
    	{
    		stringBuilder[index] = string.charAt(index);
    	}
    	size = string.length();
    }
    
    /**
     * Returns the size of the {@code StringBuilder}. 
     * That is, the number of characters in the {@code StringBuilder}.
     * 
     * @return the size of the {@code StringBuilder}
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Adds the specified character to the {@code StringBuilder}.
     * 
     * @param character the character to add to the {@code StringBuilder}
     */
    public void add(char character)
    {
    	//Resizes StringBuilder if it becomes full
    	if(size == stringBuilder.length)
    	{
    		resize(2 * stringBuilder.length);
    	}
		
    	//Adds character to StringBuilder
    	stringBuilder[size] = character;
    	size++;
    }
    
    /**
     *  Resizes the array.
     *
     *  @param newSize the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more characters than the size of new array
     *  @throws NegativeArraySizeException if {@code newSize} is negative
     */
    private void resize(int newSize)
    {
    	char[] temp = new char[newSize];
    	for(int index = 0; index < size; index++)
    	{
    		temp[index] = stringBuilder[index];
    	}
    	stringBuilder = temp;
    }
	
    /**
     * Removes the character at the specified index from the {@code StringBuilder}.
     * 
     * @param index the index of the character to remove from the {@code StringBuilder}
     * @return the character that was removed (or the null character if {@code index} is invalid)
     */
    public char remove(int index)
    {
    	char character = '\u0000';
    	if((index >= 0) && (index < size))
    	{	
	    	//Remove element from specified index
    		character = stringBuilder[index];
    		stringBuilder[index] = '\u0000';
    		shiftElements(index);
    		size--;
	    	
	    	//Resize StringBuilder if it is only 1/4 full
	    	if((size > 0) && (size == stringBuilder.length/4))
	    	{
	    		resize(stringBuilder.length/2);
	    	}
    	}
    	
    	return character;
    }
	
    /**
     * Shifts the elements in the {@code StringBuilder} (if necessary) to ensure that characters are together
     * That is, not interleaved with null characters.
     * 
     * @param indexRemoved the index of the character that was previously removed from the {@code StringBuilder}
     */
    private void shiftElements(int indexRemoved)
    {
    	for(int index = indexRemoved; index < size - 1; index++) 
    	{
    		stringBuilder[index] = stringBuilder[index + 1];
    		stringBuilder[index + 1] = '\u0000';
    	}
    }
    
    /**
     * Gets the character at the specified index from the {@code StringBuilder}.
     * 
     * @param index the index of the character to get from the {@code StringBuilder}
     * @return the character at the specified {@code index} (or the null character if {@code index} is invalid)
     */
     public char get(int index)
     {
    	char character = '\u0000';
     	if((index >= 0) && (index < size))
     	{
     		character = stringBuilder[index];
     	}
 		
     	return character;
     }
    
     /**
      * Gets the {@code String} representation of the {@code StringBuilder}.
      * 
      * @return the {@code String} representation of the {@code StringBuilder}
      */
     @Override
     public String toString()
     {
    	char[] string = new char[size];
    	for(int index = 0; index < size; index++)
    	{
    		string[index] = stringBuilder[index];
    	}
     	
    	return String.valueOf(string);   	
     }
}