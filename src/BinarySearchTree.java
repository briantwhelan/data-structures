/*************************************************************************
 *  BinarySearchTree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 18/7/21
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
         * Create a Node with the specified attributes.
         
         */
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
     * That is, the number of Key-Value pairs/{@code Node} elements in the {@code BinarySearchTree}.
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
     * Returns the height of the {@code BinarySearchTree} (i.e. the number of links from the root to 
     * the deepest leaf).
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
     *  Put the Key-Value pair into the BinarySearchTree.
     *  (If the Key already exists, update its Value)
     *
     *  @param key: the Key to insert/update in the BinarySearchTree
     *  @param value: the Value to be associated to the specified Key
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
     *  (Recursively) Put the Key-Value pair into the tree rooted at the specified Node.
     *  (If the Key already exists, update its Value)
     *
     *  @param key: the Key to insert/update in the tree rooted at the specified Node
     *  @param value: the Value to be associated to the specified 
     *  @return the Node that has been added/updated
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
     * Delete the specified Key (if it exists) from the BinarySearchTree.
     * (Similar to Hibbard deletion but uses predecessor instead of successor)
     *
     * @param key: the Key to delete from the BinarySearchTree
     */
    public void delete(Key key) 
    {
    	if(root != null)
    	{
    		root = delete(root, key);
    	}
    }
    
    /**
     * (Recursively) Delete the specified Key (if it exists) from the tree rooted at the specified Node.
     * (Similar to Hibbard deletion but uses predecessor instead of successor)
     *
     * @param node: the root Node from which to delete specified Key
     * @param key: the Key to delete from the the tree rooted at the specified Node
     * @return the Node that has been updated
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
     * Delete the maximum Key (if it exists) from the BinarySearchTree.
     */
    public void deleteMax() 
    {
    	if(root != null)
    	{
    		root = deleteMax(root);
    	}
    }
    
    /**
     * Delete the maximum Key (if it exists) from the tree rooted at the specified Node.
     * 
     * @param node: the root Node from which to delete maximum Key
     * @return the Node that has been updated
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
     * Return the Value associated with the Node with the maximum Key in the BinarySearchTree.
     * 
     * @return the Value associated with the Node with the maximum Key in the BinarySearchTree
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
     * (Recursively) Return the Node with the maximum Key in the tree rooted at the specified Node.
     * 
     * @param node: the root Node from which to get the maximum Key
     * @return the Node with the maximum Key in the tree rooted at the specified Node
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
     *  Get the value associated with a specified Key (if it exists) from the BinarySearchTree.
     *
     *  @param key: the Key to find in the BinarySearchTree
     *  @return the Value associated with the given Key (or null if no such Key exists).
     */
    public Value get(Key key) 
    { 
    	return get(root, key);
    }

    /**
     *  Get the value associated with a specified Key (if it exists) from the tree rooted at the specified Node.
     *
     *  @param node - the root Node from which search for the specified Key
     *  @param key: the Key to find in the tree rooted at the specified Node
     *  @return the Value associated with the given Key (or null if no such Key exists).
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
     *  Check whether a specified Key is contained within the BinarySearchTree.
     *
     *  @param key: the Key to find in the BinarySearchTree
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }
    
   
    
    /**
     *  Select and return the Key (if it exists) with the specified number of keys smaller than it 
     *  in the BinarySearchTree.
     *
     *  @param numberOfSmallerKeys: the number of keys smaller than the desired Key in the BinarySearchTree
     *  @return the Key with a specified number of keys smaller than it (or null if such a Key doesn't exist)
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
     *  (Recursively) Select and return the Key (if it exists) with the specified number of keys 
     *  smaller than it in the tree rooted at the specified Node.
     *
     *  @param node: the root Node from which to select desired Key
     *  @param numberOfSmallerKeys: the number of keys smaller than the desired Key in the tree 
     *  rooted at the specified Node
     *  @return the Key with a specified number of keys smaller than it (or null if such a Key 
     *  doesn't exist)
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
     *  Return the median Key in the BinarySearchTree.
     *
     *  @return the median Key (or null if the BinarySearchTree is empty)
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
     * Return a String containing all keys of the BinarySearchTree in-order with parentheses
     * (i.e. for each Node, the keys in the left subtree appear before the Key in the Node 
     * and the keys in the right subtree appear after the Key in the Node).
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
     * @return a String containing all keys of the BinarySearchTree in-order with parentheses
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
     * (Recursively) Return a String containing all keys of the tree rooted at the specified Node 
     * in-order with parentheses (i.e. for each Node, the keys in the left subtree appear before 
     * the Key in the Node and the keys in the right subtree appear after the Key in the Node).
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
     * @param node: the root Node from which to get a String containing the keys in-order
     * @return a String containing all keys of the tree rooted at the specified Node in-order 
     * with parentheses
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
     * Get a String representation of the BinarySearchTree.
     *
     * @return a String representation of the BinarySearchTree
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
     * (Recursively) Get a String representation of the tree rooted at the specified Node.
     *
     * @param node: the root Node from which to get a String representation
     * @param prefix: the current String representation of the tree rooted at the specified Node 
     * @return a String representation of the tree rooted at the specified Node
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