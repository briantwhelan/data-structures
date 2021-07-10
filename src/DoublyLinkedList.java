/*************************************************************************
 *  DoublyLinkedList class.
 *
 *  @version 10/7/21
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
    	private Node previous, next;
    	
    	/**
         * Creates a {@code Node} with the specified attributes.
         * @param data the data to be stored within the {@code Node}
         * @param previous the previous {@code Node} in the {@code DoublyLinkedList}
         * @param next the next Node in the {@code DoublyLinkedList}
         */
    	public Node(T data, Node previous, Node next)
    	{
    		this.data = data;
    		this.next = next;
    		this.previous = previous;
    	}
    }
	
    /**
     * Create an empty {@code DoublyLinkedList}.
     */
    public DoublyLinkedList()
    {
    	head = null;
    	tail = null;
    	size = 0;
    }
    
    /**
     * Creates an {@code DoublyLinkedList} from the specified array.
     * 
     * @param array the array from which to create the {@code DoublyLinkedList}
     * @throws NullPointerException if {@code array} is {@code null}
     */
    public DoublyLinkedList(T[] array) 
    {
    	this();
    	for(int index = 0; index < array.length; index++)
    	{
    		this.add(array[index]);
    	}    	
    }
    
    /**
     * Returns the size of the {@code DoublyLinkedList}. 
     * That is, the number of {@code Node} elements currently in the {@code DoublyLinkedList}.
     * 
     * @return the size of the {@code DoublyLinkedList}
     */
    public int size()
    {
    	return size;
    }
    
    /**
     * Adds the specified element to the {@code DoublyLinkedList}.
     * The element is added at the {@code tail} of the {@code DoublyLinkedList}. 
     *
     * @param element the element to add to the {@code DoublyLinkedList}
     */
    public void add(T element)
    {
    	addLast(element);
    }
    
    /**
     * Adds the specified element to the {@code head} of the {@code DoublyLinkedList}.
     * 
     * @param element the element to add at the {@code head} of the {@code DoublyLinkedList}
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
    	else if(size >= 1)
    	{
    		Node newNode = new Node(element, null, head);
    		head.previous = newNode;
    		head = newNode;
    		size++;
    	}
    }
    
    /**
     * Adds the specified element to the {@code tail} of the {@code DoublyLinkedList}.
     * 
     * @param element the element to add at the {@code tail} of the {@code DoublyLinkedList}
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
    	else if(size >= 1)
    	{
    		Node newNode = new Node(element, tail, null);
    		tail.next = newNode;
    		tail = newNode;
    		size++;
    	}
    }
    
    /**
     * Adds the specified element at the specified index of the {@code DoublyLinkedList}.
     * 
     * @param element the element to add at the specified {@code index} of the {@code DoublyLinkedList}
     * @param index the index at which to add the specified {@code element}
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
     * Removes the element at the specified index from the {@code DoublyLinkedList}.
     * 
     * @param index the index of the element to remove from the {@code DoublyLinkedList}
     * @return the element that was removed (or null if {@code index} is invalid)
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
  
    	return element;
    }
    
    /**
     * Gets the element at the specified index from the {@code DoublyLinkedList}.
     * 
     * @param index the index of the element to get from the {@code DoublyLinkedList}
     * @return the element at the specified {@code index} (or null if {@code index} is invalid)
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
      * Gets the {@code String} representation of the {@code DoublyLinkedList}.
      * 
      * @return the {@code String} representation of the {@code DoublyLinkedList}
      */
      @Override
      public String toString()
      {
      	String string = "Head - ";       	
      	for(Node currentNode = head; currentNode != null; currentNode = currentNode.next)
      	{
      		string += currentNode.data + ((currentNode.next != null) ? "," : "");
      	}
      	string += " - Tail";
      	
      	return string;
      	
      	
//        StringBuilder s = new StringBuilder();
//        boolean isFirst = true; 
//
//        // iterate over the list, starting from the head
//        for(DLLNode iter = head; iter != null; iter = iter.next)
//        {
//          if(!isFirst)
//          {
//            s.append(",");
//          } 
//          else
//          {
//            isFirst = false;
//          }
//          s.append(iter.data.toString());
//        }
//
//        return s.toString();
      }
}