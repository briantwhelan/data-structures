/*************************************************************************
 *  RedBlackBST class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 21/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class RedBlackBST<Key extends Comparable<Key>, Value> 
{
	private static enum Colour {RED, BLACK};
	
    private Node root;             

    private class Node 
    {
        private final Key key;          	
        private Value value;         		
        private Node left, right;  			
        private Colour colourOfLinkToParent;
        private int size;             		

        /**
         * Creates a {@code Node} with the specified attributes.
         * @param key the {@code Key} to be stored within the {@code Node}
         * @param value the {@code Value} to be associated with {@code key} 
         * @param colourOfLinkToParent the colour of the link linking this {@code Node} to its parent {@code Node}
         * @param size the size of the {@code BinarySearchTree} with its {@code root} at this {@code Node}
         */
        public Node(Key key, Value value, Colour colourOfLinkToParent, int size) 
        {
            this.key = key;
            this.value = value;
            this.colourOfLinkToParent = colourOfLinkToParent;
            this.size = size;
        }
    }
    
    /**
     * Creates an empty {@code RedBlackBST}.
     */
    public RedBlackBST()
    {
    	root = null;
    }

    /**
     * Returns the size of the {@code RedBlackBST}. 
     * That is, the number of {@code Key}-{@code Value} pairs/{@code Node} elements in the {@code RedBlackBST}.
     * 
     * @return the size of the {@code RedBlackBST}
     */
    public int size() 
    { 
    	return size(root); 
    }

    /**
     * Returns the size of the {@code RedBlackBST} rooted at the specified {@code Node}. 
     * 
     * @param node the root {@code Node}
     * @return the size of the {@code RedBlackBST} rooted at {@code node}
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
     * Returns the height of the {@code RedBlackBST}.
     * That is, the number of {@code BLACK} links from {@code root} to the deepest leaf in the {@code RedBlackBST}.
     * 
     * @return the height of the {@code RedBlackBST}
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
     * (Recursively) Returns the height of the {@code RedBlackBST} rooted at the specified {@code Node}.
     * That is, the number of {@code BLACK} links from the specified {@code Node} to the deepest leaf in the {@code RedBlackBST} rooted at that {@code Node}.
     * 
     * @param node the root {@code Node}
     * @return the height of the {@code RedBlackBST} rooted at {@code node}
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
        	height = (isRed(node) ? 0 : 1) + ((leftSubtreeHeight > rightSubtreeHeight) ? leftSubtreeHeight : rightSubtreeHeight);
        }
        
        return height;
    }
    
    /**
     *  Puts the specified {@code Key}-{@code Value} pair into the {@code RedBlackBST}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param key the {@code Key} to insert/update in the {@code RedBlackBST}
     *  @param value the {@code Value} to be associated with {@code key}
     */
    public void put(Key key, Value value) 
    {
    	//if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if(value == null) 
        { 
        	//delete(key); 
        }
        else
        {
        	root = put(root, key, value);
        	root.colourOfLinkToParent = Colour.BLACK;
        }
    }

    /**
     *  (Recursively) Puts the specified {@code Key}-{@code Value} pair into the {@code RedBlackBST} rooted at the specified {@code Node}.
     *  If the specified {@code Key} already exists, update its {@code Value}.
     *
     *  @param node the root {@code Node}
     *  @param key the {@code Key} to insert/update in the {@code RedBlackBST} rooted at {@code node}
     *  @param value the {@code Value} to be associated with {@code key} 
     *  @return the {@code Node} that has been added/updated
     */
    private Node put(Node node, Key key, Value value) 
    {
        if(node == null) 
        {
        	node = new Node(key, value, Colour.RED, 1);
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
	        
	        //Fix-up any right-leaning links
	        //if((node.right.colour == Colour.RED) && (node.left.colour == Colour.BLACK))
	        if(isRed(node.right) && !isRed(node.left))
	        {
	        	node = rotateLeft(node);
	        }
	        if(isRed(node.left) && isRed(node.left.left)) 
	        {
	        	node = rotateRight(node);
	        }
	        if(isRed(node.left) && isRed(node.right)) 
	        {
	        	flipColors(node);
	        }
	        node.size = 1 + size(node.left) + size(node.right);
        }
        
        return node;
    }
    
    /**
     * Checks whether the {@code Colour} of the link from the specified {@code Node} to its parent {@code Node} is {@code RED}.
     *
     * @param node the {@code Node} to check whether the {@code Colour} of the link to its parent {@code Node} is {@code RED}
     * @return {@code true} if link to the parent {@code Node} is {@code RED} and {@code false} otherwise
     */
    private boolean isRed(Node node) 
    {
    	boolean isRed = false;
    	if(node != null)
    	{
    		isRed = (node.colourOfLinkToParent == Colour.RED) ? true : false;
    	}
    	
    	return isRed;
    }
    
    /**
     * Rotates the specified {@code Node}, whose right-child is connected via a red link, left to change a right-leaning red link to a left-leaning red link.
     *
     * @param node the {@code Node} to be rotated left
     * @return the {@code Node} that has now become the parent Node following the rotation (previously the right-child of {@code node})
     */
    // make a right-leaning link lean to the left
    private Node rotateLeft(Node node) 
    {
        assert((node != null) && isRed(node.right));
        // assert (h != null) && isRed(h.right) && !isRed(h.left);  // for insertion only
        Node rightChildNode = node.right;
        node.right = rightChildNode.left;
        rightChildNode.left = node;
        rightChildNode.colourOfLinkToParent = rightChildNode.left.colourOfLinkToParent;
        rightChildNode.left.colourOfLinkToParent = Colour.RED;
        rightChildNode.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        
        return rightChildNode;
    }
    
    /**
     * Rotates the specified {@code Node}, whose left-child is connected via a red link, right to change a left-leaning red link to a right-leaning red link (temporarily).
     *
     * @param node the {@code Node} to be rotated right
     * @return the {@code Node} that has now become the parent Node following the rotation (previously the left-child of {@code node})
     */
    // make a left-leaning link lean to the right
    private Node rotateRight(Node node)
    {
        assert((node != null) && isRed(node.left));
        // assert (h != null) && isRed(h.left) &&  !isRed(h.right);  // for insertion only
        Node leftChildNode = node.left;
        node.left = leftChildNode.right;
        leftChildNode.right = node;
        leftChildNode.colourOfLinkToParent = leftChildNode.right.colourOfLinkToParent;
        leftChildNode.right.colourOfLinkToParent = Colour.RED;
        leftChildNode.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        
        return leftChildNode;
    }
    
    /**
     *  Flips the {@code Colour} of the specified {@code Node} and its two children.
     *
     *  @param node the parent {@code Node} which has two children of an opposite {@code Colour}
     */
    // flip the colors of a node and its two children
    private void flipColors(Node node) 
    {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        node.colourOfLinkToParent = (isRed(node)) ? Colour.BLACK : Colour.RED;
        node.left.colourOfLinkToParent = (isRed(node.left)) ? Colour.BLACK : Colour.RED;
        node.right.colourOfLinkToParent = (isRed(node.right)) ? Colour.BLACK : Colour.RED;
    }
    
    /**
     * Returns the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code RedBlackBST}.
     * 
     * @return the {@code Value} associated with the {@code Node} with the maximum {@code Key} in the {@code RedBlackBST}
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
     * (Recursively) Returns the {@code Node} with the maximum {@code Key} in the {@code RedBlackBST} rooted at the specified {@code Node}.
     * 
     * @param node: the root {@code Node}
     * @return the {@code Node} with the maximum {@code Key} in the {@code RedBlackBST} rooted at {@code node}
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
     * Gets the {@code Value} associated with the specified {@code Key} (if it exists) from the {@code RedBlackBST}.
     * 
     * @param key the {@code Key} to find in the {@code RedBlackBST}
     * @return the {@code Value} associated with {@code key} (or {@code null} if {@code key} does not exist)
     */
    public Value get(Key key) 
    { 
    	return get(root, key);
    }

    /**
     *  Gets the {@code Value} associated with the specified {@code Key} (if it exists) from the {@code RedBlackBST} rooted at the specified {@code Node}.
     *
     *  @param node the root Node
     *  @param key the {@code Key} to find in the {@code RedBlackBST} rooted at {@code node}
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
     * Checks whether the specified {@code Key} is contained within the {@code RedBlackBST}.
     *
     * @param key the {@code Key} to find in the {@code RedBlackBST}
     * @return {@code true} if {@code key} is found and {@code false} otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }

    /**
     * Selects and returns the {@code Key} (if it exists) with the specified number of {@code Key} elements smaller than it in the {@code RedBlackBST}.
     *
     * @param numberOfSmallerKeys the number of {@code Key} elements smaller than the desired {@code Key} in the {@code RedBlackBST}
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
     * (Recursively) Selects and returns the {@code Key} (if it exists) with the specified number of {@code Key} elements smaller than it in the {@code RedBlackBST} rooted at the specified {@code Node}.
     *
     * @param node the root {@code Node}
     * @param numberOfSmallerKeys the number of {@code Key} elements smaller than the desired {@code Key} in the {@code RedBlackBST} rooted at {@code node}
     * @return the {@code Key} with {@code numberOfSmallerKeys} {@code Key} elements smaller than it in the {@code RedBlackBST} rooted at {@code node} (or {@code null} if such a {@code Key} doesn't exist)
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
     * Returns the median {@code Key} in the {@code RedBlackBST}.
     *
     * @return the median {@code Key} (or {@code null} if the {@code RedBlackBST} is empty)
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
     * Returns the {@code String} containing all {@code Key} elements in the {@code RedBlackBST} in-order with parentheses.
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
     * @return the {@code String} containing all {@code Key} elements of the {@code RedBlackBST} in-order with parentheses
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
     * (Recursively) Returns the {@code String} containing all {@code Key} elements in the {@code RedBlackBST} rooted at the specified {@code Node} in-order with parentheses.
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
     * @return the {@code String} containing all {@code Key} elements of the {@code RedBlackBST} rooted at {@code node} in-order with parentheses
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
     * Gets the {@code String} representation of the {@code RedBlackBST}.
     * 
     * @return the {@code String} representation of the {@code RedBlackBST}
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
     * (Recursively) Gets the {@code String} representation of the {@code RedBlackBST} rooted at the specified {@code Node}.
     *
     * @param node the root {@code Node}
     * @param prefix the current {@code String} representation of the {@code RedBlackBST} rooted at {@code node} 
     * @return the {@code String} representation of the {@code RedBlackBST} rooted at {@code node}
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
    						+ toString(node.left, prefix + (isRed(node.left) ? " /" : " |"))  
    						+ toString(node.right, prefix + "  ");
    	}
    	
    	return string;
    }
}