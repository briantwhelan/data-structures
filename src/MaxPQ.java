/*************************************************************************
 *  MaxPQ class.
 *	Adapted from Sedgewick and Wayne.
 *
 *  @version 14/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQ<T extends Comparable<T>>
{
	private static final int DEFAULT_INITIAL_CAPACITY = 8;
	
	private T[] maxPQ;
	private int size;
		
	/**
     * Creates an empty {@code MaxPQ}.
     */
    public MaxPQ()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
	
    /**
     * Creates an empty {@code MaxPQ} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code MaxPQ}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public MaxPQ(int initialCapacity)
    {
    	maxPQ = (T[]) new Comparable[initialCapacity];
		size = 0;
    }
	
    /**
     * Creates a {@code MaxPQ} from the specified array.
     * 
     * @param array the array from which to create the {@code MaxPQ}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public MaxPQ(T[] array) 
    {
    	this(array.length + 1);
    	for(int index = 0; index < array.length; index++)
    	{
    		this.insert(array[index]);
    	}
    }
    
    /**
     * Returns the size of the {@code MaxPQ}. 
     * That is, the number of elements currently in the {@code MaxPQ}.
     * 
     * @return the size of the {@code MaxPQ}
     */
	public int size()
	{
		return size;
	}

    /**
     * Inserts the specified element into the {@code MaxPQ}.
     * 
     * @param element the element to insert into the {@code MaxPQ}
     */
	public void insert(T element)
	{
		size++;
		maxPQ[size] = element;
		swim(size);
	}
	
	/**
     * Deletes the maximum element from the {@code MaxPQ}.
     *
     * @return the maximum element in the {@code MaxPQ}
     */
	public T deleteMax()
	{
		T maximumElement = null;
		if(size > 0)
		{
			maximumElement = maxPQ[1];
			exchange(1, size);
			maxPQ[size] = null;
			size--;
			sink(1);
		}
		
		return maximumElement;
	}
	
	/**
     * Checks whether a specified element is contained within the {@code MaxPQ}.
     *
     * @param element the element to find in the {@code MaxPQ}
     * @return {@code true} if {@code element} is found and {@code false} otherwise
     */
	public boolean contains(T element)
	{
		boolean elementExists = false;
		for(int index = 1; index <= size && !elementExists; index++)
		{
			if(maxPQ[index].compareTo(element) == 0)
			{
				elementExists = true;
			}
		}
		
		return elementExists;
	}
	
	/**
     * Compares two specified elements in the {@code MaxPQ} to find if one is less than the other.
     * 
     * @param index1 the index of first element
     * @param index2 the index of second element
     * @return {@code true} if the element at {@code index1} is less than the element at {@code index2} and {@code false} otherwise
     */
	private boolean less(int index1, int index2)
	{
		return (maxPQ[index1].compareTo(maxPQ[index2]) < 0);
	}
	
	/**
     * Exchanges two specified elements in the {@code MaxPQ}.
     * 
     * @param index1 the index of first element
     * @param index2 the index of second element
     */
	private void exchange(int index1, int index2)
	{
		T temp = maxPQ[index1];
		maxPQ[index1] = maxPQ[index2];
		maxPQ[index2] = temp;
	}
	
	/**
     * Swims node up the binary heap.
     * 
     * @param index the index of the element to swim up the binary heap
     */
	private void swim(int index)
	{
		while((index > 1) && less(index/2, index))
		{
			exchange(index/2, index);
			index = index/2;
		}
	}
	
	/**
     * Sinks node down the binary heap.
     * 
     * @param index the index of element to sink down the binary heap
     */
	private void sink(int index)
	{
		boolean isSinking = true;
		while((2 * index <= size) && isSinking)
		{
			int j = 2 * index;
			if((j < size) && less(j, j + 1))
			{
				j++;
			}
			
			if(!less(index, j))
			{
				isSinking = false;
			}
			else
			{
				exchange(index, j);
				index = j;
			}
		}
	}
	
	/**
     * Gets the {@code String} representation of the {@code MaxPQ}.
     * 
     * @return the {@code String} representation of the {@code MaxPQ}
     */
	@Override
	public String toString()
	{
		T[] temp = (T[]) new Comparable[size + 1];
		int initialSize = size;
		
		String string = "Head - ";
     	for(int index = 1; index <= initialSize; index++)
     	{
     		temp[index] = this.deleteMax();
     		string += temp[index] + ((index < initialSize) ? "," : "");
     	}
     	string += " - Tail";
		
     	for(int index = 1; index <= initialSize; index++)
     	{
     		this.insert(temp[index]);
     	}
     	
		return string;
	}
}
