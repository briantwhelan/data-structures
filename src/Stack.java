/*************************************************************************
 *  Stack class.
 *
 *  @version 1.0 11/2/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Stack<Item>
{
	private Item[] stack;
	private int index;
	
	public Stack(int initialCapacity)
	{
		stack = (Item[]) new Object[initialCapacity];
		index = 0;
	}
	
    /**
     *  Push a given item to the stack
     *
     *  @param item: the item to push on to the stack
     */
	public void push(Item item)
	{
		stack[index] = item;
		index++;
	}
	
    /**
     *  Pop the item from the top of the stack
     *
     *  @return the item on the top of the stack
     */
	public Item pop()
	{
		index--;
		Item item = stack[index];
		stack[index] = null;
		return item;
	}
	
	/**
     *  Peek the item from the top of the stack (doesn't change top of stack)
     *
     *  @return the item on the top of the stack
     */
	public Item peek()
	{
		return stack[index - 1];
	}
	
	/**
     *  Is the stack empty?
     *
     *  @return true if there are no items on the stack
     */
	public boolean isEmpty()
	{
		boolean isEmpty = false;
		if(index == 0)
		{
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	/**
     *  Get the number of items on the stack
     *
     *  @return the number of items on the stack
     */
	public int size()
	{
		return index;
	}

}
