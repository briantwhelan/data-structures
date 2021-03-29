/*************************************************************************
 *  Maximum Priority Queue class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MaxPQ<Item extends Comparable<Item>>
{
	private Item[] pq;
	private int size;
	
	/**
     * Create an empty maximum priority queue with specified capacity
     * 
     * @param capacity: capacity of maximum priority queue
     */
	public MaxPQ(int capacity)
	{
		pq = (Item[]) new Comparable[capacity];
		size = 0;
	}
	
	/**
     * Insert an item into the maximum priority queue
     * 
     * @param item: item to be added to maximum priority queue
     */
	public void insert(Item item)
	{
		size++;
		pq[size] = item;
		swim(size);
	}
	
	/**
     * Delete the maximum item in the maximum priority queue
     * 
     * @return the maximum item in the maximum priority queue
     */
	public Item deleteMax()
	{
		Item maximumElement = null;
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
     * Check whether the maximum priority queue is empty
     * 
     * @return is the maximum priority queue empty?
     */
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	/**
     * Get the size of the maximum priority queue
     * 
     * @return the size of the maximum priority queue
     */
	public int size()
	{
		return size;
	}
	
	/**
     * Compare two elements in the maximum priority queue to find if one is less than the other
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
     * Exchange two elements in the maximum priority queue
     * 
     * @param index1: index of first element
     * @param index2: index of second element
     */
	private void exchange(int index1, int index2)
	{
		Item temp = pq[index1];
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
     * Get String representation of maximum priority queue
     * 
     * @return String containing information on maximum priority queue
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
