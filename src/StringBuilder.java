/*************************************************************************
 *  StringBuilder class.
 *
 *  @version 17/6/21
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
     * Create an empty StringBuilder.
     */
	public StringBuilder()
	{
		stringBuilder = new char[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
     * Create an empty StringBuilder with specified initial capacity.
     * 
     * @param initialCapacity: initial capacity of the StringBuilder
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public StringBuilder(int initialCapacity)
    {
    	stringBuilder = new char[initialCapacity];
    	size = 0;
    }
    
    /**
     * Create a StringBuilder from the specified String.
     * 
     * @param string: string to convert to StringBuilder
     * @throws NullPointerException if string is null
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
     * Return the size of the StringBuilder (i.e. the number of characters currently in the StringBuilder).
     * 
     * @return size of the StringBuilder (i.e. the number of characters currently in the StringBuilder)
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Add a given character to the StringBuilder.
     *
     * @param character: the character to add to the StringBuilder
     */
    public void add(char character)
    {
    	//Resize StringBuilder if it becomes full
    	if(size == stringBuilder.length)
    	{
    		resize(2 * stringBuilder.length);
    	}
		
    	//Add character to StringBuilder
    	stringBuilder[size] = character;
    	size++;
    }
    
    /**
     *  Resize array.
     *
     *  @param newSize: the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more characters than size of new array
     *  @throws NegativeArraySizeException if newSize is negative
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
     * Remove the character at the specified index from the StringBuilder.
     *
     * @param index: the index of the character to remove from the StringBuilder
     * @return the character that was removed (or the null character if index is invalid)
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
     * Shift elements in the StringBuilder (if necessary) to ensure that characters are together
     * (i.e. not interleaved with null characters).
     * 
     * @param indexRemoved: index of character that was previously removed from the StringBuilder
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
     * Get the character at the specified index from the StringBuilder.
     * 
     * @param index: the index of the character to get from the StringBuilder
     * @return the character at the specified index (or the null character if index is invalid)
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
     * Get a string representation of the StringBuilder.
     * 
     * @return string representation of the StringBuilder
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
