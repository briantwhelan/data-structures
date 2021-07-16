/*************************************************************************
 *  HashTable class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 16/7/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class HashTable<Key, Value> 
{
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private Key[] keys;
	private Value[] values;
    private int size;             
    
    /**
     * Creates an empty {@code HashTable}.
     */
    public HashTable()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Creates an empty {@code HashTable} with the specified initial capacity.
     * 
     * @param initialCapacity the initial capacity of the {@code HashTable}
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public HashTable(int initialCapacity)
    {
    	keys = (Key[]) new Object[initialCapacity];
    	values = (Value[]) new Object[initialCapacity];
    	size = 0;
    }

    /**
     * Returns the size of the {@code HashTable}. 
     * That is, the number of Key-Value pairs in the {@code HashTable}.
     * 
     * @return the size of the {@code HashTable}
     */
    public int size() 
    { 
    	return size;
    }
    
    /**
     *  Puts the specified Key-Value pair into the {@code HashTable}.
     *  If the {@code Key} already exists, update its {@code Value}.
     *
     *  @param key: the {@code Key} to insert/update in the {@code HashTable}
     *  @param value: the {@code Value} to be associated with {@code key}
     */
    public void put(Key key, Value value) 
    {
    	if(value == null) 
        { 
        	delete(key); 
        }
        else
        {
        	//Doubles HashTable size if it's 1/2 full
        	if(size == keys.length/2)
        	{
        		resize(2 * keys.length);
        	}
        	
        	boolean isInserted = false;
        	int indexToInsert = -1;
        	for(indexToInsert = hash(key); keys[indexToInsert] != null; indexToInsert = (indexToInsert + 1) % keys.length)
        	{
        		if(keys[indexToInsert].equals(key))
        		{
        			values[indexToInsert] = value;
        			isInserted = true;
        		}
        	}
        	
        	if(!isInserted)
        	{
        		keys[indexToInsert] = key;
        		values[indexToInsert] = value;
        		size++;
        	}
        }
    }

    /**
     *  Resizes the array.
     *
     *  @param newSize the new size the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more elements than the size of new array
     *  @throws NegativeArraySizeException if {@code newSize} is negative
     */
    private void resize(int newSize)
    {
    	HashTable<Key, Value> temp = new HashTable<Key, Value>(newSize);
    	for(int index = 0; index < keys.length; index++)
    	{
    		if(keys[index] != null)
    		{
    			temp.put(keys[index], values[index]);
    	
    		}
    	}
    	keys = temp.keys;
    	values = temp.values;
    }

    /**
     * Hashes the specified {@code Key} to its appropriate index in the {@code HashTable}.
     * 
     * @param key the {@code Key} to hash to its appropriate index
     * @return the index which {@code key} was hashed to
     */
    private int hash(Key key)
    {
        int hashedIndex = key.hashCode();
        hashedIndex ^= (hashedIndex >>> 20) ^ (hashedIndex >>> 12) ^ (hashedIndex >>> 7) ^ (hashedIndex >>> 4);
        hashedIndex &= keys.length - 1;
        
        return hashedIndex;
    }
    
    /**
     * Deletes the specified {@code Key} and its associated {@code Value} (if it exists) from the {@code HashTable}.
     *
     * @param key the {@code Key} to delete from the {@code HashTable}
     */
    public void delete(Key key) 
    {
    	if(this.contains(key))
    	{
	    	//Finds index of key
	    	int indexToDelete = hash(key);
	    	while(!key.equals(keys[indexToDelete]))
	    	{
	    		indexToDelete = (indexToDelete + 1) % keys.length;
	    	}
	    	
	    	//Deletes key and associated value
	    	keys[indexToDelete] = null;
	    	values[indexToDelete] = null;
	    	
	    	//Rehashes all keys after deleted key but before next null (i.e. in the same cluster)
	    	int index = (indexToDelete + 1) % keys.length;
	    	while(keys[index] != null)
	    	{
	    		//Deletes keys[index] and values[index] and reinserts
	    		Key keyToRehash = keys[index];
	    		Value valueToRehash = values[index];
	    		keys[index] = null;
	    		values[index] = null;
	    		size--;
	    		put(keyToRehash, valueToRehash);
	    		index = (index + 1) % keys.length;
	    	}
	    	
	    	size--;
	    	
	    	//Resizes HashTable if it is only 1/8 full
	    	if((size > 0) && (size <= keys.length/8))
	    	{
	    		resize(keys.length/2);
	    	}
    	}
    }
    
    /**
     * Gets the {@code Value} associated with the specified {@code Key} (if it exists) from the {@code HashTable}.
     * 
     * @param key the {@code Key} to find in the {@code HashTable}
     * @return the {@code Value} associated with {@code key} (or {@code null} if {@code key} does not exist)
     */
    public Value get(Key key) 
    { 
    	Value value = null;
    	for(int index = hash(key); keys[index] != null; index = (index + 1) % keys.length)
    	{
    		if(keys[index].equals(key))
    		{
    			value = values[index];
    		}
    	}
    	
    	return value;
    }

    /**
     * Checks whether the specified {@code Key} is contained within the {@code HashTable}.
     *
     * @param key the {@code Key} to find in the {@code HashTable}
     * @return {@code true} if {@code key} is found and {@code false} otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }
    
    /**
     * Gets the {@code String} representation of the {@code HashTable}.
     * 
     * @return the {@code String} representation of the {@code HashTable}
     */
    @Override
    public String toString() 
    {
    	String string = "index\tkey  \tvalue";
    	for(int index = 0; index < keys.length; index++)
    	{
    		if(keys[index] != null)
    		{
    			string += String.format("\n%-5s\t%-5s\t%-5s", index, keys[index], values[index]);
    		}
    	}
    	
    	return string;
    }
}