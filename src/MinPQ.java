/*************************************************************************
 *  MinPQ class.
 *	Adapted from Sedgewick and Wayne.
 *
 *  @version 13/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQ<T extends Comparable<T>>
{
	private static final int DEFAULT_INITIAL_CAPACITY = 8;
	
	private T[] minPQ;
	private int size;
	
	/**
     * Creates an empty {@code MinPQ}.
     */
    public MinPQ()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
	
    /**
     * Creates an empty {@code MinPQ} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code MinPQ}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public MinPQ(int initialCapacity)
    {
    	minPQ = (T[]) new Comparable[initialCapacity];
		size = 0;
    }
	
    /**
     * Creates a {@code MinPQ} from the specified array.
     * 
     * @param array the array from which to create the {@code MinPQ}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public MinPQ(T[] array) 
    {
    	this(array.length + 1);
    	for(int index = 0; index < array.length; index++)
    	{
    		this.insert(array[index]);
    	}
    }
    
    /**
     * Returns the size of the {@code MinPQ}. 
     * That is, the number of elements currently in the {@code MinPQ}.
     * 
     * @return the size of the {@code MinPQ}
     */
	public int size()
	{
		return size;
	}
	
    /**
     * Inserts the specified element into the {@code MinPQ}.
     * 
     * @param element the element to insert into the {@code MinPQ}
     */
	public void insert(T element)
	{
		size++;
		minPQ[size] = element;
		swim(size);
	}
	
	/**
     * Deletes the minimum element from the {@code MinPQ}.
     *
     * @return the minimum element in the {@code MinPQ}
     */
	public T deleteMin()
	{
		T minimumElement = null;
		if(size > 0)
		{
			minimumElement = minPQ[1];
			exchange(1, size);
			minPQ[size] = null;
			size--;
			sink(1);
		}
		
		return minimumElement;
	}
	
	/**
     * Checks whether a specified element is contained within the {@code MinPQ}.
     *
     * @param element the element to find in the {@code MinPQ}
     * @return {@code true} if {@code element} is found and {@code false} otherwise
     */
	public boolean contains(T element)
	{
		boolean elementExists = false;
		for(int index = 1; index <= size && !elementExists; index++)
		{
			if(minPQ[index].compareTo(element) == 0)
			{
				elementExists = true;
			}
		}
		
		return elementExists;
	}
		
	/**
     * Compares two specified elements in the {@code MinPQ} to find if one is greater than the other.
     * 
     * @param index1 the index of first element
     * @param index2 the index of second element
     * @return {@code true} if the element at {@code index1} is greater than the element at {@code index2} and {@code false} otherwise
     */
	private boolean greater(int index1, int index2)
	{
		return (minPQ[index1].compareTo(minPQ[index2]) > 0);
	}
	
	/**
     * Exchanges two specified elements in the {@code MinPQ}.
     * 
     * @param index1 the index of first element
     * @param index2 the index of second element
     */
	private void exchange(int index1, int index2)
	{
		T temp = minPQ[index1];
		minPQ[index1] = minPQ[index2];
		minPQ[index2] = temp;
	}
	
	/**
     * Swims node up the binary heap.
     * 
     * @param index the index of the element to swim up the binary heap
     */
	private void swim(int index)
	{
		while((index > 1) && greater(index/2, index))
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
			if((j < size) && greater(j, j + 1))
			{
				j++;
			}
			
			if(!greater(index, j))
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
     * Gets the {@code String} representation of the {@code MinPQ}.
     * 
     * @return the {@code String} representation of the {@code MinPQ}
     */
	@Override
	public String toString()
	{
		T[] temp = (T[]) new Comparable[size + 1];
		int initialSize = size;
		
		String string = "Head - ";
     	for(int index = 1; index <= initialSize; index++)
     	{
     		temp[index] = this.deleteMin();
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