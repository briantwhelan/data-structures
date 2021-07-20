/*************************************************************************
 *  BinarySearchTree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 20/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
    private Node root;             

    private class Node 
    {
        private final Key key;       
        private Value value;      	
        private Node left, right; 	
        private int size;

        /**
         * Creates a {@code Node} with the specified attributes.
         * @param key the {@code Key} to be stored within the {@code Node}
         * @param value the {@code Value} to be associated with {@code key} 
         * @param size the size of the {@code BinarySearchTree} with its {@code root} at this {@code Node}
         */
        public Node(Key key, Value value, int size) 
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    
    /**
     * Creates an empty {@code BinarySearchTree}.
     */
    public BinarySearchTree()
    {
    	root = null;
    }

    /**
     * Returns the size of the {@code BinarySearchTree}. 
     * That is, the number of {@code Key}-{@code Value} pairs/{@code Node} elements in the {@code BinarySearchTree}.
     * 
     * @return the size of the {@code BinarySearchTree}
     */
    public int size() 
    { 
    	return size(root); 
    }

    /**
     * Returns the size of the {@code BinarySearchTree} rooted at the specified {@code Node}. 
     * 
     * @param node the root {@code Node}
     * @return the size of the {@code BinarySearchTree} rooted at {@code node}
     */
    private int size(Node node) 
    {
    	int size = 0;
        if(node != null) 
        {
        	size = node.size;
        }
        
        return size;
    }
    
    /**
     * Returns the height of the {@code BinarySearchTree}.
     * That is, the number of links from {@code root} to the deepest leaf in the {@code BinarySeatchTree}.
     * 
     * @return the height of the {@code BinarySearchTree}
     */
    public int height() 
    {
      int height = 0;
      if(root == null)
      {
    	  height = -1;
      }
      else if(root.size == 1)
      {
    	  height = 0;
      }
      else
      {
    	  height = height(root) - 1;
      }
      
      return height;
    }

    /**
     * (Recursively) Returns the height of the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * That is, the number of links from the specified {@code Node} to the deepest leaf currently in the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * 
     * @param node the root {@code Node}
     * @return the height of the {@code BinarySearchTree} rooted at {@code node}
     */
    private int height(Node node)
    {
    	int height = 0;
        if(node == null) 
        {
        	height = 0;
        }
        else
        {
        	int leftSubtreeHeight = height(node.left);
        	int rightSubtreeHeight = height(node.right);
        	height = 1 + ((leftSubtreeHeight > rightSubtreeHeight) ? leftSubtreeHeight : rightSubtreeHeight);
        }
        
        return height;
    }
    
    /**
     *  Puts the specified {@code Key}-{@code Value} pair into the {@code BinarySearchTree}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param key the {@code Key} to insert/update in the {@code BinarySearchTree}
     *  @param value the {@code Value} to be associated with {@code key}
     */
    public void put(Key key, Value value) 
    {
        if(value == null) 
        { 
        	delete(key); 
        }
        else
        {
        	root = put(root, key, value);
        }
    }

    /**
     *  (Recursively) Puts the specified {@code Key}-{@code Value} pair into the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param node the root {@code Node}
     *  @param key the {@code Key} to insert/update in the {@code BinarySearchTree} rooted at {@code node}
     *  @param value the {@code Value} to be associated with {@code key} 
     *  @return the {@code Node} that has been added/updated
     */
    private Node put(Node node, Key key, Value value) 
    {
        if(node == null) 
        {
        	node = new Node(key, value, 1);
        }
        else
        {
	        int cmp = key.compareTo(node.key);
	        if(cmp < 0) 
	        {
	        	node.left = put(node.left, key, value);
	        }
	        else if(cmp > 0) 
	        {
	        	node.right = put(node.right, key, value);
	        }
	        else
	        {
	        	node.value = value;
	        }
	        node.size = 1 + size(node.left) + size(node.right);
        }
        
        return node;
    }
    
    /**
     * Deletes the specified {@code Key} (if it exists) from the {@code BinarySearchTree}.
     * Uses Hibbard deletion to replace deleted {@code Node} with its predecessor.
     *
     * @param key the {@code Key} to delete from the {@code BinarySearchTree}
     */
    public void delete(Key key) 
    {
    	if(root != null)
    	{
    		root = delete(root, key);
    	}
    }
    
    /**
     * (Recursively) Deletes the specified {@code Key} (if it exists) from the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * Uses Hibbard deletion to replace deleted {@code Node} with its predecessor.
     *
     * @param node the root {@code Node}
     * @param key the {@code Key} to delete from the {@code BinarySearchTree} rooted at {@code node}
     * @return the {@code Node} that has been updated
     */
    private Node delete(Node node, Key key)
    { 
    	Node updatedNode = null;
    	if(node == null) 
    	{
    		updatedNode = null;
    	}
    	else
    	{
	    	int cmp = key.compareTo(node.key);
	    	if(cmp < 0) 
	    	{
	    		node.left = delete(node.left, key);
	    		node.size = size(node.left) + size(node.right) + 1;
	    		updatedNode = node;
	    	}
	    	else if(cmp > 0) 
	    	{
	    		node.right = delete(node.right, key);
	    		node.size = size(node.left) + size(node.right) + 1;
	    		updatedNode = node;
	    	}
	    	else 
	    	{
	        	if(node.right == null) 
	        	{
	        		updatedNode = node.left;
	        	}
	        	else if(node.left == null)
	        	{
	        		updatedNode = node.right;
	        	}
	        	else
	        	{
		        	Node temp = node;
		        	node = max(temp.left);
		        	node.left = deleteMax(temp.left);
		        	node.right = temp.right;
		        	node.size = size(node.left) + size(node.right) + 1;
		    		updatedNode = node;
	        	}
	    	}
    	}
    	
    	return updatedNode;
    }
    
    /**
     * Deletes the maximum {@code Key} (if it exists) from the {@code BinarySearchTree}.
     */
    public void deleteMax() 
    {
    	if(root != null)
    	{
    		root = deleteMax(root);
    	}
    }
    
    /**
     * (Recursively) Deletes the maximum {@code Key} (if it exists) from the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * 
     * @param node the root {@code Node}
     * @return the {@code Node} that has been updated
     */
    private Node deleteMax(Node node)
    {
    	Node updatedNode = null;
    	if(node.right == null) 
    	{
    		updatedNode = node.left;
    	}
    	else
    	{
    		node.right = deleteMax(node.right);
    		node.size = 1 + size(node.left) + size(node.right);
    		updatedNode = node;
    	}
    	
    	return updatedNode;
    }
    
    /**
     * Returns the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree}.
     * 
     * @return the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree}
     */
    public Value max() 
    {
    	Value max = null;
    	if(root != null)
    	{
    		max = max(root).value;
    	}
    	return max;
    }
    
    /**
     * (Recursively) Returns the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree} rooted at the specified {@code Node}.
     * 
     * @param node: the root {@code Node}
     * @return the {@code Node} with the maximum {@code Key} in the {@code BinarySearchTree} rooted at {@code node}
     */
    private Node max(Node node)
    {
    	Node max;
    	if(node.right == null) 
    	{
    		max = node;
    	}
    	else
    	{
    		max = max(node.right);
    	}
    	
    	return max;
    }

    /**
     * Gets the {@code Value} associated with the specified {@code Key} (if it exists) from the {@code BinarySearchTree}.
     * 
     * @param key the {@code Key} to find in the {@code BinarySearchTree}
     * @return the {@code Value} associated with {@code key} (or {@code null} if {@code key} does not exist)
     */
    public Value get(Key key) 
    { 
    	return get(root, key);
    }

    /**
     *  Gets the {@code Value} associated with the specified {@code Key} (if it exists) from the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *
     *  @param node the root Node
     *  @param key the {@code Key} to find in the {@code BinarySearchTree} rooted at {@code node}
     *  @return the {@code Value} associated with {@code key} (or {@code null} if {@code key} does not exist)
     */
    private Value get(Node node, Key key) 
    {
    	Value value = null;
        if(node != null) 
        {
	        int cmp = key.compareTo(node.key);
	        if(cmp < 0) 
	        {
	        	value = get(node.left, key);
	        }
	        else if(cmp > 0)
	        {
	        	value = get(node.right, key);
	        }
	        else   
	        {
	        	value = node.value;
	        }
        }
        
        return value;
    }

    /**
     * Checks whether the specified {@code Key} is contained within the {@code BinarySearchTree}.
     *
     * @param key the {@code Key} to find in the {@code BinarySearchTree}
     * @return {@code true} if {@code key} is found and {@code false} otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }

    /**
     * Selects and returns the {@code Key} (if it exists) with the specified number of {@code Key} elements smaller than it in the {@code BinarySearchTree}.
     *
     * @param numberOfSmallerKeys the number of {@code Key} elements smaller than the desired {@code Key} in the {@code BinarySearchTree}
     * @return the {@code Key} with {@code numberOfSmallerKeys} {@code Key} elements smaller than it in the {@code BinarySearchTree} (or {@code null} if such a {@code Key} doesn't exist)
     */
    public Key select(int numberOfSmallerKeys)
    {
    	Key key;
    	if(numberOfSmallerKeys < 0 || numberOfSmallerKeys >= size()) 
    	{
    		key = null;
    	}
    	else
    	{
    		Node node = select(root, numberOfSmallerKeys);
    		key = node.key;
    	}
    	
    	return key;
    }
    
    /**
     * (Recursively) Selects and returns the {@code Key} (if it exists) with the specified number of {@code Key} elements smaller than it in the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *
     * @param node: the root {@code Node}
     * @param numberOfSmallerKeys the number of {@code Key} elements smaller than the desired {@code Key} in the {@code BinarySearchTree} rooted at {@code node}
     * @return the {@code Key} with {@code numberOfSmallerKeys} {@code Key} elements smaller than it in the {@code BinarySearchTree} rooted at {@code node} (or {@code null} if such a {@code Key} doesn't exist)
     */
    private Node select(Node node, int numberOfSmallerKeys)
    {	
    	Node select;
    	if(node == null) 
    	{
    		select = null;
    	}
    	else
    	{
    		int t = size(node.left);
    		if(t > numberOfSmallerKeys)
    		{
    			select = select(node.left, numberOfSmallerKeys);
    		}
    		else if(t < numberOfSmallerKeys) 
    		{
    			select = select(node.right, numberOfSmallerKeys - t - 1);
    		}
    		else
    		{
    			select = node;
    		}
    	}
    
    	return select;
    }

    /**
     * Returns the median {@code Key} in the {@code BinarySearchTree}.
     *
     * @return the median {@code Key} (or {@code null} if the {@code BinarySearchTree} is empty)
     */
    public Key median() 
    {
    	Key median;
    	if(root == null)
    	{
    		median = null;
    	}
    	else
    	{
    		median = select((root.size + 1)/2 - 1);
    	}
    	
    	return median;
    }

    /**
     * Returns the {@code String} containing all {@code Key} elements in the {@code BinarySearchTree} in-order with parentheses.
     * That is, for each {@code Node}, the {@code Key} elements in the left subtree appear before the {@code Key} in the {@code Node} 
     * and the {@code Key} elements in the right subtree appear after the {@code Key} in the {@code Node}).
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * @return the {@code String} containing all {@code Key} elements of the {@code BinarySearchTree} in-order with parentheses
     */
    public String printKeysInOrder() 
    {
    	String keysInOrder = "";
    	if(root == null)
    	{
    		keysInOrder = "()";
    	}
    	else
    	{
    		keysInOrder = printKeysInOrder(root);
    	}
    	
    	return keysInOrder;
    }
    
    /**
     * (Recursively) Returns the {@code String} containing all {@code Key} elements in the {@code BinarySearchTree} rooted at the specified {@code Node} in-order with parentheses.
     * That is, for each {@code Node}, the {@code Key} elements in the left subtree appear before the {@code Key} in the {@code Node} 
     * and the {@code Key} elements in the right subtree appear after the {@code Key} in the {@code Node}).
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * @param node the root {@code Node}
     * @return the {@code String} containing all {@code Key} elements of the {@code BinarySearchTree} rooted at {@code node} in-order with parentheses
     */
    private String printKeysInOrder(Node node)
    {
    	String keysInOrder = "";
    	if(node == null)
    	{
    		keysInOrder = "()";
    	}
    	else
    	{
    		keysInOrder = "(" + printKeysInOrder(node.left) + node.key + printKeysInOrder(node.right) + ")";
    	}
    	
    	return keysInOrder;
    }
    
    /**
     * Gets the {@code String} representation of the {@code BinarySearchTree}.
     * 
     * @return the {@code String} representation of the {@code BinarySearchTree}
     */
    @Override
    public String toString() 
    {
    	String string = "";
    	if(root == null)
    	{
    		string = "-null\n";
    	}
    	else
    	{
    		string = toString(root, "");
    	}
    	
    	return string;
    }
    
    /**
     * (Recursively) Gets the {@code String} representation of the {@code BinarySearchTree} rooted at the specified {@code Node}.
     *
     * @param node the root {@code Node}
     * @param prefix the current {@code String} representation of the {@code BinarySearchTree} rooted at {@code node} 
     * @return the {@code String} representation of the {@code BinarySearchTree} rooted at {@code node}
     */
    private String toString(Node node, String prefix)
    {
    	String string = "";
    	if(node == null)
    	{
    		string = prefix + "-null\n";
    	}
    	else
    	{
    		string = prefix + "-" + node.key + "\n"
    						+ toString(node.left, prefix + " |")  
    						+ toString(node.right, prefix + "  ");
    	}
    	
    	return string;
    }
}