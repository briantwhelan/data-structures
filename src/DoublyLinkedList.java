/*************************************************************************
 *  DoublyLinkedList class.
 *
 *  @version 15/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DoublyLinkedList<T>
{	
    private Node head, tail;
    private int size;
    
    private class Node
    {
    	private final T data;
    	private Node next, previous;
    	
    	public Node(T data, Node next, Node previous)
    	{
    		this.data = data;
    		this.next = next;
    		this.previous = previous;
    	}
    }
	
    /**
     * Create an empty DoublyLinkedList.
     */
    public DoublyLinkedList()
    {
    	head = null;
    	tail = null;
    	size = 0;
    }
    
    /**
     * Return the size of the DoublyLinkedList (i.e. the number of Nodes currently in the DoublyLinkedList).
     * 
     * @return size of the DoublyLinkedList (i.e. the number of Nodes currently in the DoublyLinkedList)
     */
    public int size()
    {
    	return size;
    }
    
    /**
     * Add an element to the DoublyLinkedList (adds to end/tail of DoublyLinkedList).
     *
     * @param element: the element to add to the DoublyLinkedList
     */
    public void add(T element)
    {
    	addLast(element);
    }
    
    /**
     * Add an element at the head of the DoublyLinkedList.
     *
     * @param element: the element to add at the head of the DoublyLinkedList
     */
    public void addFirst(T element)
    {
    	if(size == 0)
    	{
    		Node newNode = new Node(element, null, null);
    		head = newNode;
    		tail = newNode;
    		size++;
    	}
    	else //if(size >= 1)
    	{
    		Node newNode = new Node(element, null, head);
    		head.previous = newNode;
    		head = newNode;
    		size++;
    	}
    }
    
    /**
     * Add an element to the tail of the DoublyLinkedList.
     *
     * @param element: the element to add to the tail of the DoublyLinkedList
     */
    public void addLast(T element)
    {
    	if(size == 0)
    	{
    		Node newNode = new Node(element, null, null);
    		head = newNode;
    		tail = newNode;
    		size++;
    	}
    	else //if(size >= 1)
    	{
    		Node newNode = new Node(element, tail, null);
    		tail.next = newNode;
    		tail = newNode;
    		size++;
    	}
    }
    
    /**
     * Add an element at a specified index to the DoublyLinkedList.
     *
     * @param element: the element to add to the DoublyLinkedList
     * @param index: the index at which to add the element
     */
    public void add(T element, int index)
    {
    	if(index <= 0)
    	{
    		addFirst(element);
    	}
    	else if(index >= size)
    	{
    		addLast(element);
    	}
    	else
    	{
    		Node newNode = new Node(element, null, null);
    		Node currentNode = head;
    		for(int nodePosition = 1; nodePosition < index; nodePosition++)
    		{
    			currentNode = currentNode.next;
    		}
    		
    		newNode.next = currentNode.next;
    		currentNode.next.previous = newNode;
    		currentNode.next = newNode;
     		newNode.previous = currentNode;
    		size++;
    	}
    }     
    
    /**
     * Remove the element from the specified index from the DoublyLinkedList.
     *
     * @param index: the index of the element to remove from the DoublyLinkedList
     * @return the element at the specified index in the DoublyLinkedList (or null if index is invalid)
     */
    public T remove(int index)
    {
    	T element = null;
    	if((size > 0) && (index < size) && (index >= 0))
    	{
       	  if(size == 1)
       	  {
       		  element = head.data;
       		  head = null;
       		  tail = null;
       		  size--;
       	  }
       	  else if(index == 0)
       	  {
       		  element = head.data;
       		  Node temp = head;
       		  temp.next.previous = null;
       		  head = temp.next;
       		  temp.next = null;
       		  size--;
       	  }
       	  else if(index == size - 1)
       	  {
       		  element = tail.data;
       		  Node temp = tail;
       		  temp.previous.next = null;
       		  tail = temp.previous;
       		  temp.previous = null;
       		  size--;
       	  }
       	  else
       	  {
   		      Node temp = head;
   		      for(int nodePosition = 0; nodePosition < index; nodePosition++)
   		      {
   		    	  temp = temp.next;
   		      }
   	      
   		      temp.previous.next = temp.next;
   		      temp.next.previous = temp.previous;
   		      
   		      element = temp.data;
   		      temp.previous = null;
   		      temp.next = null;
   		      size--;
       	  }
         }
//    	if((index == 0) && (index < size))
//    	{
//    		element = head.data;
//    		head = head.next;    	
//    		size--;
//    	}
//    	else if((index > 0) && (index < size))
//    	{
//    		Node currentNode = head;
//    		for(int currentIndex = 0; (currentNode.next != null) && (currentIndex < index); 
//    												currentNode = currentNode.next, currentIndex++)
//    		{
//    			//Traverse LinkedList to element at index before the element to be removed
//    		}
//    		element = currentNode.data;
//    		currentNode = null;
//    		size--;
//    	}
  
    	return element;
    }
    
    /**
     * Get an element at a specified index from the DoublyLinkedList.
     * 
     * @param index: index of element to get from the DoublyLinkedList
     * @return element at specified index (or null if index is invalid)
     */
     public T get(int index)
     {
    	T element = null;
    	
     	if((index >= 0) && (index < size))
     	{
     		Node currentNode = head;
     		for(int currentIndex = 0; currentIndex < index; currentIndex++)
     		{
     			currentNode = currentNode.next;
     		}
     		element = currentNode.data;
     	}
     	
     	return element;
     }
     
     /**
      * Get a string representation of the DoublyLinkedList.
      * 
      * @return string representation of the DoublyLinkedList
      */
      @Override
      public String toString()
      {
      	String string = "Head - "; 
      	if(head != null)
      	{
	      	Node currentNode = head;
	      	while(currentNode != null) 
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