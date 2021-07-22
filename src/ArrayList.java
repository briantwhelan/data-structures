/*************************************************************************
 *  {@code ArrayList} class.
 *  
 *  @version 22/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class ArrayList<T>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
	
    private T[] arrayList;
    private int size;
	
    /**
     * Creates an empty {@code ArrayList}.
     */
    public ArrayList()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
	
    /**
     * Creates an empty {@code ArrayList} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code ArrayList} that is being created
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
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
     * Creates an {@code ArrayList} from the specified array.
     * 
     * @param array the array from which to create the {@code ArrayList}
     * @throws NullPointerException if {@code array} is {@code null}
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
     * Returns the size of the {@code ArrayList}. 
     * That is, the number of elements currently in the {@code ArrayList}.
     * 
     * @return the size of the {@code ArrayList}
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Adds the specified element to the {@code ArrayList}.
     * 
     * @param element the element to add to the {@code ArrayList}
     */
    public void add(T element)
    {
    	//Doubles ArrayList size if it becomes full
    	if(size == arrayList.length)
    	{
    	    resize(2 * arrayList.length);
    	}
		
    	//Adds element to ArrayList
    	arrayList[size] = element;
    	size++;
    }
    
    /**
     *  Resizes the array.
     *
     *  @param newSize the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more elements than the size of new array
     *  @throws NegativeArraySizeException if {@code newSize} is negative
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
     * Removes the element at the specified index from the {@code ArrayList}.
     * 
     * @param index the index of the element to remove from the {@code ArrayList}
     * @return the element that was removed (or {@code null} if {@code index} is invalid)
     */
    public T remove(int index)
    {
    	T element = null;
    	if((index >= 0) && (index < size))
    	{
    	    //Removes element from specified index
    	    element = arrayList[index];
    	    arrayList[index] = null;
    	    shiftElements(index);
    	    size--;
    		
    	    //Halves ArrayList size if it is only 1/4 full
    	    if((size > 0) && (size <= arrayList.length/4))
    	    {
	    	    resize(arrayList.length/2);
    	    }
    	}
		
    	return element;
    }
	
    /**
     * Shifts the elements in the {@code ArrayList} (if necessary) to ensure that elements are together
     * That is, not interleaved with {@code null} elements.
     * 
     * @param indexRemoved the index of the element that was previously removed from the {@code ArrayList}
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
    * Gets the element at the specified index from the {@code ArrayList}.
    * 
    * @param index the index of the element to get from the {@code ArrayList}
    * @return the element at the specified {@code index} (or {@code null} if {@code index} is invalid)
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
    * Gets the {@code String} representation of the {@code ArrayList}.
    * 
    * @return the {@code String} representation of the {@code ArrayList}
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