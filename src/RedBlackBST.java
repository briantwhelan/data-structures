/*************************************************************************
 *  RedBlackBST class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 29/6/21
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
        private final Key key;          	// sorted by key
        private Value value;         		// associated data
        private Node left, right;  			// left and right subtrees
        private Colour colourOfLinkToParent;// colour of link to parent Node
        private int size;             		// number of nodes in subtree

        /**
         * Create a Node with the specified attributes.
         * @param key: the key to be stored within the Node
         * @param value: the value associated to the specified key
         * @param colourOfLinkToParent: the colour of the link linking Node to parent Node
         * @param size: the size of the tree with its root at this Node
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
     * Create an empty RedBlackBST.
     */
    public RedBlackBST()
    {
    	root = null;
    }

    /**
     * Return the size of the RedBlackBST (i.e. the number of Nodes currently in the RedBlackBST).
     * 
     * @return size of the RedBlackBST (i.e. the number of Nodes currently in the RedBlackBST)
     */
    public int size() 
    { 
    	return size(root); 
    }

    /**
     * Return the size of the tree rooted at the specified Node.
     * 
     * @param node: the root Node from which to get the tree size
     * @return size of the BinarySearchTree rooted at the specified Node
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
     *  Get the value associated with a specified Key (if it exists) from the RedBlackBST.
     *
     *  @param key: the Key to find in the RedBlackBST
     *  @return the Value associated with the given Key (or null if no such Key exists).
     */
    public Value get(Key key) 
    { 
    	return get(root, key);
    }

    /**
     *  Get the value associated with a specified Key (if it exists) from the tree rooted at the specified Node.
     *
     *  @param node: the root Node from which search for the specified Key
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
     *  Check whether a specified Key is contained within the RedBlackBST.
     *
     *  @param key: the Key to find in the RedBlackBST
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }
    
    /**
     *  Put the Key-Value pair into the RedBlackBST.
     *  (If the Key already exists, update its Value)
     *
     *  @param key: the Key to insert/update in the RedBlackBST
     *  @param value: the Value to be associated to the specified Key
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
     *  Check whether the colour of the link from a specified Node to its parent Node is red
     *
     *  @param node: the Node to check whether the colour of the link to its parent Node is red
     *  @return true if link to parent is red and false otherwise
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
     *  Rotate a Node, whose left-child is connected via a red link, right to change 
     *  a left-leaning red link to a right-leaning red link (temporarily).
     *
     *  @param node: the Node to be rotated right
     *  @return the Node that has now become the parent Node following the rotation 
     *  (previously the left-child of node)
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
     *  Rotate a Node, whose right-child is connected via a red link, left to change 
     *  a right-leaning red link to a left-leaning red link.
     *
     *  @param node: the Node to be rotated left
     *  @return the Node that has now become the parent Node following the rotation 
     *  (previously the right-child of node)
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
     *  Flip the cplours of a specified Node and its two children.
     *
     *  @param node: the parent Node which has two children of an opposite colour
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
     * Return the height of the RedBlackBST (i.e. the number of black links from the root 
     * to the deepest leaf).
     * 
     * @return the height of the RedBlackBST (i.e. the number of black links from the root 
     * to the deepest leaf)
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
     * (Recursively) Return the height of the the tree rooted at the specified Node (i.e. the 
     * number of black links from the specified Node to the deepest leaf currently in the tree 
     * rooted at the specified Node).
     * 
     * @param node: the root Node from which to get the tree height
     * @return the height of the tree rooted at the specified Node (i.e. the number of 
     * black links from the specified Node to the deepest leaf currently in the tree 
     * rooted at the specified Node)
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
     *  Select and return the Key (if it exists) with the specified number of keys smaller than it 
     *  in the RedBlackBST.
     *
     *  @param numberOfSmallerKeys: the number of keys smaller than the desired Key in the RedBLackBST
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
     *  Return the median Key in the RedBlackBST.
     *
     *  @return the median Key (or null if the RedBlackBST is empty)
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
     * Return the Value associated with the Node with the maximum Key in the RedBlackBST.
     * 
     * @return the Value associated with the Node with the maximum Key in the RedBlackBST
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
     * Return a String containing all keys of the RedBlackBST in-order with parentheses
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
     * @return a String containing all keys of the RedBlackBST in-order with parentheses
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
     * Get a String representation of the RedBlackBST.
     *
     * @return a String representation of the RedBlackBST
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
    						+ toString(node.left, prefix + (isRed(node.left) ? " /" : " |"))  
    						+ toString(node.right, prefix + "  ");
    	}
    	
    	return string;
    }
}