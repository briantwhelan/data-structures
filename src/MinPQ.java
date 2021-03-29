/*************************************************************************
 *  Minimum Priority Queue class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class MinPQ<Item extends Comparable<Item>>
{
	private Item[] pq;
	private int size;
	
	/**
     * Create an empty minimum priority queue with specified capacity
     * 
     * @param capacity: capacity of minimum priority queue
     */
	public MinPQ(int capacity)
	{
		pq = (Item[]) new Comparable[capacity];
		size = 0;
	}
	
	/**
     * Insert an item into the minimum priority queue
     * 
     * @param item: item to be added to minimum priority queue
     */
	public void insert(Item item)
	{
		size++;
		pq[size] = item;
		swim(size);
	}
	
	/**
     * Delete the minimum item in the minimum priority queue
     * 
     * @return the maximum item in the minimum priority queue
     */
	public Item deleteMin()
	{
		Item minimumElement = null;
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
     * Check whether the minimum priority queue is empty
     * 
     * @return is the minimum priority queue empty?
     */
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	/**
     * Get the size of the minimum priority queue
     * 
     * @return the size of the minimum priority queue
     */
	public int size()
	{
		return size;
	}
	
	/**
     * Compare two elements in the minimum priority queue to find if one is greater than the other
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
     * Exchange two elements in the minimum priority queue
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
     * Get String representation of minimum priority queue
     * 
     * @return String containing information on minimum priority queue
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
