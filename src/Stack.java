/*************************************************************************
 *  Stack class.
 *
 *  @version 10/7/21
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
     * Creates an empty {@code Stack}.
     */
    public Stack()
    {
    	stack = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    	size = 0;
    }

    /**
     * Creates an empty {@code Stack} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code Stack}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public Stack(int initialCapacity)
    {
    	stack = (T[]) new Object[initialCapacity];
    	size = 0;
    }
    
    /**
     * Creates a {@code Stack} from the specified array.
     * 
     * @param array the array from which to create the {@code Stack}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public Stack(T[] array) 
    {
    	stack = (T[]) new Object[array.length];
    	for(int index = array.length - 1; index >= 0; index--)
    	{
    		stack[index] = array[index];
    	}
    	size = array.length;
    }
    
    /**
     * Returns the size of the {@code Stack}. 
     * That is, the number of elements currently on the {@code Stack}.
     * 
     * @return the size of the {@code Stack}
     */
    public int size()
    {
    	return size;
    }
	
    /**
     * Pushes the specified element to the {@code Stack}.
     *
     * @param element the element to push on to the {@code Stack}
     */
    public void push(T element)
    {
    	//Resizes Stack if it becomes full
    	if(size == stack.length)
    	{
    		resize(2 * stack.length);
    	}
		
    	//Adds element to Stack
    	stack[size] = element;
    	size++;
    }
    
    /**
     *  Resizes array.
     *
     *  @param newSize the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more elements than size of new array
     *  @throws NegativeArraySizeException if {@code newSize} is negative
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
     * Pops the element from the top of the {@code Stack}.
     *
     * @return the element on the top of the {@code Stack}
     */
    public T pop()
    {
    	T element = null;
    	if(size > 0)
    	{
	    	//Removes element from top of Stack
	    	size--;
	    	element = stack[size];
	    	stack[size] = null;
	    	
	    	//Resizes Stack if it is only 1/4 full
	    	if((size > 0) && (size == stack.length/4))
	    	{
	    		resize(stack.length/2);
	    	}
    	}
    	
    	return element;
    }
	
    /**
     * Peeks the element on the top of the {@code Stack}.
     *
     * @return the element on the top of the {@code Stack}
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
     * Gets the {@code String} representation of the {@code Stack}.
     * 
     * @return the {@code String} representation of the {@code Stack}
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