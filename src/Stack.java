/*************************************************************************
 *  Stack class.
 *
 *  @version 11/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Stack<T>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
    private T[] stack;
    private int size;
	
    /**
     * Create an empty Stack.
     */
    public Stack()
    {
    	stack = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    	size = 0;
    }
    
    /**
     * Create an empty Stack with specified capacity.
     * 
     * @param initialCapacity: initial capacity of the Stack
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public Stack(int initialCapacity)
    {
    	stack = (T[]) new Object[initialCapacity];
    	size = 0;
    }
    
    /**
     * Return the size of the Stack (i.e. the number of elements currently in the Stack).
     * 
     * @return size of the Stack (i.e. the number of elements currently in the Stack)
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Push a given element to the Stack.
     *
     * @param element: the element to push on to the Stack
     */
    public void push(T element)
    {
    	//Resize Stack if it becomes full
    	if(size == stack.length)
    	{
    		resize(2 * stack.length);
    	}
		
    	//Add element to Stack
    	stack[size] = element;
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
    		temp[i] = stack[i];
    	}
    	stack = temp;
    }
	
    /**
     * Pop the element from the top of the Stack.
     *
     * @return the element on the top of the Stack
     */
    public T pop()
    {
    	T element = null;
    	if(size > 0)
    	{
	    	//Remove element from top of Stack
	    	size--;
	    	element = stack[size];
	    	stack[size] = null;
	    	
	    	//Resize Stack if it is only 1/4 full
	    	if((size > 0) && (size == stack.length/4))
	    	{
	    		resize(stack.length/2);
	    	}
    	}
    	
    	return element;
    }
	
    /**
     * Peek the element from the top of the Stack (doesn't change top of stack).
     *
     * @return the element on the top of the Stack
     */
    public T peek()
    {
    	T element = null;
    	if(size > 0)
    	{
    		element =  stack[size - 1];
    	}
    	
    	return element;
    }
    
    /**
     * Get a string representation of the Stack.
     * 
     * @return string representation of the Stack
     */
     @Override
     public String toString()
     {
     	String string = "Top - ";
     	for(int index = size - 1; index >= 0; index--)
     	{
     		string += stack[index] + ((index > 0) ? " " : "");
     	}
     	string += " - Bottom";
     	
     	return string;
     }
}
