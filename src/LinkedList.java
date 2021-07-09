/*************************************************************************
 *  LinkedList class.
 *
 *  @version 9/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class LinkedList<T>
{	
    private Node head;
    private int size;
    
    private class Node
    {
    	private final T data;
    	private Node next;
    	
    	/**
         * Creates a {@code Node} with the specified attributes.
         * @param data the data to be stored within the {@code Node}
         * @param next the next {@code Node} in the {@code LinkedList}
         */
    	public Node(T data, Node next)
    	{
    		this.data = data;
    		this.next = next;
    	}
    }
	
    /**
     * Creates an empty LinkedList.
     */
    public LinkedList()
    {
    	head = null;
    	size = 0;
    }
    
    /**
     * Creates an {@code LinkedList} from the specified array.
     * 
     * @param array the array from which to create the {@code LinkedList}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public LinkedList(T[] array) 
    {
    	this();
    	for(int index = 0; index < array.length; index++)
    	{
    		this.add(array[index]);
    	}    	
    }
    
    /**
     * Returns the size of the {@code LinkedList}. 
     * That is, the number of {@code Node} elements currently in the {@code LinkedList}.
     * 
     * @return the size of the {@code LinkedList}
     */
    public int size()
    {
    	return size;
    }
    
    /**
     * Adds the specified element to the {@code LinkedList}.
     *
     * @param element the element to add to the {@code LinkedList}
     */
    public void add(T element)
    {
    	//Creates a new Node to insert in the LinkedList
    	Node newNode = new Node(element, null);
    	
    	if(head == null)
    	{
    		//New Node is head if LinkedList is empty
    		head = newNode;
    	}
    	else
    	{
    		//New Node gets inserted at end of LinkedList
    		Node currentNode = head;
    		while(currentNode.next != null)
    		{
    			currentNode = currentNode.next;
    		}
    		currentNode.next = newNode;
    	}
    	size++;
    }
    
    /**
     * Removes the element at the specified index from the {@code LinkedList}.
     * 
     * @param index the index of the element to remove from the {@code LinkedList}
     * @return the element that was removed (or null if {@code index} is invalid)
     */
    public T remove(int index)
    {
    	T element = null;
    	if((index == 0) && (index < size))
    	{
    		element = head.data;
    		head = head.next;    	
    		size--;
    	}
    	else if((index > 0) && (index < size))
    	{
    		Node currentNode = head;
    		for(int currentIndex = 0; (currentNode.next != null) && (currentIndex < index - 1); 
    												currentNode = currentNode.next, currentIndex++)
    		{
    			//Traverses LinkedList to element at index before the element to be removed
    		}
    		element = currentNode.next.data;
    		currentNode.next = currentNode.next.next;
    		size--;
    	}
    	
    	return element;
    }
    
    /**
     * Gets the element at the specified index from the {@code LinkedList}.
     * 
     * @param index the index of the element to get from the {@code LinkedList}
     * @return the element at the specified index (or null if {@code index} is invalid)
     */
     public T get(int index)
     {
    	T element = null;
     	if((index >= 0) && (index < size))
     	{
     		Node currentNode = head;
     		for(int currentIndex = 0; (currentNode.next != null) && (currentIndex < index); 
     												currentNode = currentNode.next, currentIndex++)
     		{
     			//Traverses LinkedList to index of element
     		}
     		element = currentNode.data;
     	}
     	
     	return element;
     }
     
     /**
      * Gets the string representation of the {@code LinkedList}.
      * 
      * @return the string representation of the {@code LinkedList}
      */
      @Override
      public String toString()
      {
      	String string = "Head - "; 
      	if(head != null)
      	{
	      	Node currentNode = head;
	      	while(currentNode.next != null) 
	      	{
	      		string += currentNode.data + ",";
	      		currentNode = currentNode.next;
	      	}
	      	string += currentNode.data;
      	}
      	string += " - Tail";
      	
      	return string;
      }
}