import java.util.Iterator;

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
		//Resize stack if it becomes full
		if(index == stack.length)
		{
			resize(2 * stack.length);
		}
		
		//Add item to stack
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
		//Remove item from top of stack
		index--;
		Item item = stack[index];
		stack[index] = null;
		
		//Resize stack if it is only 1/4 full
		if((index > 0) && (index == stack.length/4))
		{
			resize(stack.length/2);
		}
		
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
     *  Resize array
     *
     *  @param size: the new size the array is to be resized to
     */
	private void resize(int size)
	{
		Item[] temp = (Item[]) new Object[size];
		for(int i = 0; i < index; i++)
		{
			temp[i] = stack[i];
		}
		stack = temp;
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
