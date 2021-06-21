/*************************************************************************
 *  BinarySearchTree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 21/6/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
    private Node root;             

    private class Node 
    {
        private final Key key;          // sorted by key
        private Value value;         	// associated data
        private Node left, right;  		// left and right subtrees
        private int size;             	// number of nodes in subtree

        /**
         * Create a Node with the specified attributes.
         * @param key: the key to be stored within the Node
         * @param value: the value associated to the specified key
         * @param size: the size of the tree with its root at this Node
         */
        public Node(Key key, Value value, int size) 
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    
    /**
     * Create an empty BinarySearchTree.
     */
    public BinarySearchTree()
    {
    	root = null;
    }

    // return number of key-value pairs in BST
    /**
     * Return the size of the BinarySearchTree (i.e. the number of Nodes currently in the BinarySearchTree).
     * 
     * @return size of the BinarySearchTree (i.e. the number of Nodes currently in the BinarySearchTree)
     */
    public int size() 
    { 
    	return size(root); 
    }

    // return number of key-value pairs in BST rooted at node
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

    //*  Search BST for given key.
   // *  What is the value associated with given key?
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
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation: Theta(N) - my height method will recursively call 
     * the height method for every node in the tree, hence in every case, the asymptotic running time will be 
     * Theta(N). The number of times I call the height method will be roughly 2N as the method calls itself 
     * for both the left and right subtree of each node. However, we can disregard this constant multiple in 
     * our asymptotic running time.
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    
    /**
     * Return the height of the BinarySearchTree (i.e. the number of recursions needed to reach the 
     * deepest Node currently in the BinarySearchTree).
     * 
     * @return the height of the BinarySearchTree (i.e. the number of recursions needed to reach the 
     * deepest Node currently in the BinarySearchTree)
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
     * number of recursions needed to reach the deepest Node currently in the tree rooted at 
     * the specified Node).
     * 
     * @param node: the root Node from which to get the tree height
     * @return the height of the tree rooted at the specified Node (i.e. the number of recursions 
     * needed to reach the deepest Node currently in the tree rooted at the specified Node)
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
     * Deletes a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key) 
    {
    	if(root != null)
    	{
    		root = delete(root, key);
    	}
    }
    
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
     * Deletes the maximum key in the tree
     */
    public void deleteMax() 
    {
    	if(root != null)
    	{
    		root = deleteMax(root);
    	}
    }
    
    private Node deleteMax(Node x)
    {
    	Node node;
    	if(x.right == null) 
    	{
    		node = x.left;
    	}
    	else
    	{
    		x.right = deleteMax(x.right);
    		x.size = 1 + size(x.left) + size(x.right);
    		node = x;
    	}
    	return node;
    }
    
    /**
     * Returns the node with the maximum key in the tree
     * 
     * @return the node with the maximum key in the tree
     */
//    public Node max() 
//    {
//    	Node max = null;
//    	if(root != null)
//    	{
//    		max = max(root);
//    	}
//    	return max;
//    }
    
    private Node max(Node x)
    {
    	Node node;
    	if(x.right == null) 
    	{
    		node = x;
    	}
    	else
    	{
    		node = max(x.right);
    	}
    	return node;
    }


    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
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
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
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
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys() 
    {
    	String treeAsString = "";
    	if(root == null)
    	{
    		treeAsString = "-null\n";
    	}
    	else
    	{
    		treeAsString = prettyPrintKeys(root, "");
    	}
    	return treeAsString;
    }
    
    private String prettyPrintKeys(Node node, String prefix)
    {
    	String treeAsString = "";
    	if(node == null)
    	{
    		treeAsString = prefix + "-null\n";
    	}
    	else
    	{
    		treeAsString = prefix + "-" + node.key + "\n"
    						+ prettyPrintKeys(node.left, prefix + " |")  
    						+ prettyPrintKeys(node.right, prefix + "  ");
    	}
    	return treeAsString;
    }
}