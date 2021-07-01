/*************************************************************************
 *  MinPQ class.
 *
 *  @version 1/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQ<T extends Comparable<T>>
{
	private T[] pq;
	private int size;
	
	/**
     * Create an empty MinPQ with specified capacity
     * 
     * @param capacity: capacity of MinPQ
     */
	public MinPQ(int capacity)
	{
		pq = (T[]) new Comparable[capacity];
		size = 0;
	}
	
	/**
     * Insert an item into the MinPQ
     * 
     * @param item: item to be added to MinPQ
     */
	public void insert(T item)
	{
		size++;
		pq[size] = item;
		swim(size);
	}
	
	/**
     * Delete the minimum item in the MinPQ
     * 
     * @return the maximum item in the MinPQ
     */
	public T deleteMin()
	{
		T minimumElement = null;
		if(size > 0)
		{
			minimumElement = pq[1];
			exchange(1, size);
			pq[size] = null;
			size--;
			sink(1);
		}
		return minimumElement;
	}
	
	/**
     * Find whether an item is in the MinPQ
     * 
     * @param item: item to be found in MinPQ
     */
	public boolean contains(T item)
	{
		boolean itemExists = false;
		for(int i = 1; i < size && !itemExists; i++)
		{
			if(pq[i].compareTo(item) == 0)
			{
				itemExists = true;
			}
		}
		
		return itemExists;
	}
	
	/**
     * Check whether the MinPQ is empty
     * 
     * @return is the MinPQ empty?
     */
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	/**
     * Get the size of the MinPQ
     * 
     * @return the size of the MinPQ
     */
	public int size()
	{
		return size;
	}
	
	/**
     * Compare two elements in the MinPQ to find if one is greater than the other
     * 
     * @param index1: index of first element
     * @param index2: index of second element
     * @return boolean representing whether first element is greater than second element
     */
	private boolean greater(int index1, int index2)
	{
		return (pq[index1].compareTo(pq[index2]) > 0);
	}
	
	/**
     * Exchange two elements in the MinPQ
     * 
     * @param index1: index of first element
     * @param index2: index of second element
     */
	private void exchange(int index1, int index2)
	{
		T temp = pq[index1];
		pq[index1] = pq[index2];
		pq[index2] = temp;
	}
	
	/**
     * Swim node up binary heap
     * 
     * @param index: index of element to swim up binary heap
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
     * Sink node down binary heap
     * 
     * @param index: index of element to sink down binary heap
     */
	private void sink(int index)
	{
		while(2 * index <= size)
		{
			int j = 2 * index;
			if((j < size) && greater(j, j + 1))
			{
				j++;
			}
			
			if(!greater(index, j))
			{
				break;
			}
			
			exchange(index, j);
			index = j;
		}
	}
	
	/**
     * Get String representation of MinPQ
     * 
     * @return String containing information on MinPQ
     */
	@Override
	public String toString()
	{
		String string = "<- (Next Out) ";
		for(int index = 1; index <= size; index++)
		{
			string += pq[index] + " ";
		}
		string += "<- (Last In)\n";
		
		return string;
	}
}
