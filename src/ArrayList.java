/*************************************************************************
 *  ArrayList class.
 *
 *  @version 11/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class ArrayList<T>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
    private T[] arrayList;
    private int size;
	
    /**
     * Create an empty ArrayList.
     */
    public ArrayList()
    {
    	arrayList = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    	size = 0;
    }
	
    /**
     * Create an empty ArrayList with specified capacity.
     * 
     * @param initialCapacity: initial capacity of the ArrayList
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public ArrayList(int initialCapacity)
    {
    	if(initialCapacity > 0)
    	{
    		arrayList = (T[]) new Object[initialCapacity];
    		size = 0;
    	}
    	else throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
	
    /**
     * Create an ArrayList from specified array.
     * 
     * @param array: array to convert to an ArrayList
     * @throws NullPointerException if array is null
     */
    public ArrayList(T[] array) 
    {
    	arrayList = (T[]) new Object[array.length];
    	for(int index = 0; index < array.length; index++)
    	{
    		arrayList[index] = array[index];
    	}
    	size = array.length;
    }
	
    /**
     * Return the size of the ArrayList (i.e. the number of elements currently in the ArrayList).
     * 
     * @return size of the ArrayList (i.e. the number of elements currently in the ArrayList)
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Add an element to the ArrayList.
     * 
     * @param element: element to add to the ArrayList
     */
    public void add(T element)
    {
    	//Resize ArrayList if it becomes full
    	if(size == arrayList.length)
    	{
    		resize(2 * arrayList.length);
    	}
		
    	//Add element to ArrayList
    	arrayList[size] = element;
    	size++;
    }
    
    /**
     *  Resize array.
     *
     *  @param newSize: the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more elements than size of new array
     *  @throws NegativeArraySizeException if newSize is negative
     */
    private void resize(int newSize)
    {
    	T[] temp = (T[]) new Object[newSize];
    	for(int i = 0; i < size; i++)
    	{
    		temp[i] = arrayList[i];
    	}
    	arrayList = temp;
    }
	
    /**
     * Remove an element at a specified index from the ArrayList.
     * 
     * @param index: index of element to remove from the ArrayList
     * @return element that was removed (or null if index is invalid)
     */
    public T remove(int index)
    {
    	T element = null;
    	if((index >= 0) && (index < size))
    	{
    		//Remove element from specified index
    		element = arrayList[index];
    		arrayList[index] = null;
    		shiftElements(index);
    		size--;
    		
    		//Resize ArrayList if it is only 1/4 full
	    	if((size > 0) && (size <= arrayList.length/4))
	    	{
	    		resize(arrayList.length/2);
	    	}
    	}
		
    	return element;
    }
	
    /**
     * Shift elements in the ArrayList (if necessary) to ensure that elements are together
     * (i.e. not interleaved with null elements).
     * 
     * @param indexRemoved: index of element that was previously removed from the ArrayList
     */
    private void shiftElements(int indexRemoved)
    {
    	for(int index = indexRemoved; index < size - 1; index++) 
    	{
    		arrayList[index] = arrayList[index + 1];
    		arrayList[index + 1] = null;
    	}
    }
	
   /**
    * Get an element at a specified index from the ArrayList.
    * 
    * @param index: index of element to get from the ArrayList
    * @return element at specified index (or null if index is invalid)
    */
    public T get(int index)
    {
    	T element = null;
    	if((index >= 0) && (index < size))
    	{
    		element = arrayList[index];
    	}
		
    	return element;
    }
	
   /**
    * Get a string representation of the ArrayList.
    * 
    * @return string representation of the ArrayList
    */
    @Override
    public String toString()
    {
    	String string = "{";
    	for(int index = 0; index < size; index++)
    	{
    		string += arrayList[index] + ((index < size - 1) ? "," : "");
    	}
    	string += "}";
    	
    	return string;
    }
}
