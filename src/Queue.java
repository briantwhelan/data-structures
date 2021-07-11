/*************************************************************************
 *  Queue class.
 *
 *  @version 11/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Queue<T>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
	
    private T[] queue;
    private int size;
	
    /**
     * Creates an empty {@code Queue}.
     */
    public Queue()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Creates an empty {@code Queue} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code Queue}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public Queue(int initialCapacity)
    {
    	queue = (T[]) new Object[initialCapacity];
    	size = 0;
    }
    
    /**
     * Creates a {@code Queue} from the specified array.
     * 
     * @param array the array from which to create the {@code Queue}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public Queue(T[] array) 
    {
    	this(array.length);
    	for(int index = 0; index < array.length; index++)
    	{
    		this.add(array[index]);
    	}
    }
    
    /**
     * Returns the size of the {@code Queue}. 
     * That is, the number of elements currently in the {@code Queue}.
     * 
     * @return the size of the {@code Queue}
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Adds the specified element to the {@code Queue}.
     * 
     * @param element the element to add to the {@code Queue}
     */
    public void add(T element)
    {
    	//Resizes Queue if it becomes full
    	if(size == queue.length)
    	{
    		resize(2 * queue.length);
    	}
		
    	//Adds element to Queue
    	queue[size] = element;
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
    		temp[i] = queue[i];
    	}
    	queue = temp;
    }
	
    /**
     * Removes the element from the head of the {@code Queue}.
     *
     * @return the element at the head of the {@code Queue}
     */
    public T remove()
    {
    	T element = null;
    	if(size > 0)
    	{
	    	//Removes element from head of Queue
	    	element = queue[0];
	    	shiftElements();
	    	size--;
	    	
	    	//Resizes Queue if it is only 1/4 full
	    	if((size > 0) && (size == queue.length/4))
	    	{
	    		resize(queue.length/2);
	    	}
    	}
    	
    	return element;
    }
    
    /**
     * Shifts the elements in the {@code Queue} to account for the element that was removed at index 0.
     */
    private void shiftElements()
    {
    	for(int index = 0; index < size - 1; index++) 
    	{
    		queue[index] = queue[index + 1];
    		queue[index + 1] = null;
    	}
    }
	
    /**
     * Peeks the element at the head of the {@code Queue}.
     *
     * @return the element at the head of the {@code Queue}
     */
    public T peek()
    {
    	T element = null;
    	if(size > 0)
    	{
    		element =  queue[0];
    	}
    	
    	return element;
    }
    
    /**
     * Gets the {@code String} representation of the {@code Queue}.
     * 
     * @return the {@code String} representation of the {@code Queue}
     */
     @Override
     public String toString()
     {
     	String string = "Head - ";
     	for(int index = 0; index < size; index++)
     	{
     		string += queue[index] + ((index < size - 1) ? "," : "");
     	}
     	string += " - Tail";
     	
     	return string;
     }
}
