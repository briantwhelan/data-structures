/*************************************************************************
 *  MaxPQ class.
 *
 *  @version 1/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQ<T extends Comparable<T>>
{
	private T[] pq;
	private int size;
	
	/**
     * Create an empty MaxPQ with specified capacity
     * 
     * @param capacity: capacity of MaxPQ
     */
	public MaxPQ(int capacity)
	{
		pq = (T[]) new Comparable[capacity];
		size = 0;
	}
	
	/**
     * Insert an item into the MaxPQ
     * 
     * @param item: item to be added to MaxPQ
     */
	public void insert(T item)
	{
		size++;
		pq[size] = item;
		swim(size);
	}
	
	/**
     * Delete the maximum item in the MaxPQ
     * 
     * @return the maximum item in the MaxPQ
     */
	public T deleteMax()
	{
		T maximumElement = null;
		if(size > 0)
		{
			maximumElement = pq[1];
			exchange(1, size);
			pq[size] = null;
			size--;
			sink(1);
		}
		return maximumElement;
	}
	
	/**
     * Check whether the MaxPQ is empty
     * 
     * @return is the MaxPQ empty?
     */
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	/**
     * Get the size of the MaxPQ
     * 
     * @return the size of the MaxPQ
     */
	public int size()
	{
		return size;
	}
	
	/**
     * Compare two elements in the MaxPQ to find if one is less than the other
     * 
     * @param index1: index of first element
     * @param index2: index of second element
     * @return boolean representing whether first element is less than second element
     */
	private boolean less(int index1, int index2)
	{
		return (pq[index1].compareTo(pq[index2]) < 0);
	}
	
	/**
     * Exchange two elements in the MaxPQ
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
		while((index > 1) && less(index/2, index))
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
			if((j < size) && less(j, j + 1))
			{
				j++;
			}
			
			if(!less(index, j))
			{
				break;
			}
			
			exchange(index, j);
			index = j;
		}
	}
	
	/**
     * Get String representation of MaxPQ
     * 
     * @return String containing information on MaxPQ
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
