/*************************************************************************
 *  Linked List.
 *
 *  @version 15/6/21
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
    	
    	public Node(T data, Node next)
    	{
    		this.data = data;
    		this.next = next;
    	}
    }
	
    /**
     * Create an empty LinkedList.
     */
    public LinkedList()
    {
    	head = null;
    	size = 0;
    }
    
    /**
     * Return the size of the LinkedList (i.e. the number of Nodes currently in the LinkedList).
     * 
     * @return size of the LinkedList (i.e. the number of Nodes currently in the LinkedList)
     */
    public int size()
    {
    	return size;
    }
    
    /**
     * Add an element to the LinkedList.
     *
     * @param element: the element to add to the LinkedList
     */
    public void add(T element)
    {
    	//Create a new Node to insert in LinkedList
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
     * Remove the element from the specified index from the LinkedList.
     *
     * @param index: the index of the element to remove from the LinkedList
     * @return the element at the specified index in the LinkedList (or null if index is invalid)
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
    		for(int currentIndex = 0; (currentNode.next != null) && (currentIndex < index); 
    												currentNode = currentNode.next, currentIndex++)
    		{
    			//Traverse LinkedList to element at index before the element to be removed
    		}
    		element = currentNode.data;
    		currentNode = null;
    		size--;
    	}
    	
    	
    	return element;
    }
    
    /**
     * Get an element at a specified index from the LinkedList.
     * 
     * @param index: index of element to get from the LinkedList
     * @return element at specified index (or null if index is invalid)
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
     			//Traverse LinkedList to index of element
     		}
     		element = currentNode.data;
     	}
     	
     	return element;
     }
     
     /**
      * Get a string representation of the LinkedList.
      * 
      * @return string representation of the LinkedList
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