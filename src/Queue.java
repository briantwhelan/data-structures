/*************************************************************************
 *  Queue class.
 *
 *  @version 12/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Queue<T>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
    private T[] queue;
    private int size;
	
    /**
     * Create an empty Queue.
     */
    public Queue()
    {
    	queue = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    	size = 0;
    }
    
    /**
     * Create an empty Queue with specified capacity.
     * 
     * @param initialCapacity: initial capacity of the Queue
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public Queue(int initialCapacity)
    {
    	queue = (T[]) new Object[initialCapacity];
    	size = 0;
    }
    
    /**
     * Return the size of the Queue (i.e. the number of elements currently in the Queue).
     * 
     * @return size of the Queue (i.e. the number of elements currently in the Queue)
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Add an element to the Queue.
     * 
     * @param element: the element to add to the Queue
     */
    public void add(T element)
    {
    	//Resize Queue if it becomes full
    	if(size == queue.length)
    	{
    		resize(2 * queue.length);
    	}
		
    	//Add element to Queue
    	queue[size] = element;
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
    		temp[i] = queue[i];
    	}
    	queue = temp;
    }
	
    /**
     * Remove the element from the head of the Queue.
     *
     * @return the element at the head of the Queue
     */
    public T remove()
    {
    	T element = null;
    	if(size > 0)
    	{
	    	//Remove element from head of Queue
	    	element = queue[0];
	    	shiftElements();
	    	size--;
	    	
	    	//Resize Queue if it is only 1/4 full
	    	if((size > 0) && (size == queue.length/4))
	    	{
	    		resize(queue.length/2);
	    	}
    	}
    	
    	return element;
    }
    
    /**
     * Shift elements in the Queue to account for element removed at index 0.
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
     * Peek the element from the head of the Queue (doesn't change head of Queue).
     *
     * @return the element on the head of the Queue
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
     * Get a string representation of the Queue.
     * 
     * @return string representation of the Queue
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
