/*************************************************************************
 *  HashTable class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 1/7/21
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
     * Create an empty HashTable.
     */
    public HashTable()
    {
    	this(DEFAULT_INITIAL_CAPACITY);
    }
    
    /**
     * Create an empty HashTable with specified initial capacity.
     */
    public HashTable(int initialCapacity)
    {
    	keys = (Key[]) new Object[initialCapacity];
    	values = (Value[]) new Object[initialCapacity];
    	size = 0;
    }

    /**
     * Return the size of the HashTable (i.e. the number of Key-Value pairs currently in the HashTable).
     * 
     * @return size of the HashTable (i.e. the number of Key-Value pairs currently in the HashTable)
     */
    public int size() 
    { 
    	return size;
    }

    /**
     * Hash a Key to its appropriate index in the HashTable.
     * 
     * @param key: the key to get a hash code for
     * @return the index of hashed Key
     */
    private int hash(Key key)
    {
        int hashCode = key.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12) ^ (hashCode >>> 7) ^ (hashCode >>> 4);
        hashCode &= keys.length - 1;
        
        return hashCode;
    }
    
    /**
     *  Get the value associated with a specified Key (if it exists) from the HashTable.
     *
     *  @param key: the Key to find in the HashTable
     *  @return the Value associated with the given Key (or null if no such Key exists).
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
     *  Check whether a specified Key is contained within the HashTable.
     *
     *  @param key: the Key to find in the HashTable
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) 
    {
        return get(key) != null;
    }
    
    /**
     *  Put the Key-Value pair into the HashTable.
     *  (If the Key already exists, update its Value)
     *
     *  @param key: the Key to insert/update in the HashTable
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
        	//Double HashTable size if it's 1/2 full
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
     *  Resize array.
     *
     *  @param newCapacity: the new capacity the array is to be resized to
     *  @throws ArrayIndexOutOfBoundsException if existing array has more elements than size of new array
     *  @throws NegativeArraySizeException if newSize is negative
     */
    private void resize(int newCapacity)
    {
    	HashTable<Key, Value> temp = new HashTable<Key, Value>(newCapacity);
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
     * Delete the specified Key (if it exists) from the HashTable.
     *
     * @param key: the Key to delete from the HashTable
     */
    public void delete(Key key) 
    {
    	if(this.contains(key))
    	{
	    	//Find index of key
	    	int indexToDelete = hash(key);
	    	while(!key.equals(keys[indexToDelete]))
	    	{
	    		indexToDelete = (indexToDelete + 1) % keys.length;
	    	}
	    	
	    	//Delete key and associated value
	    	keys[indexToDelete] = null;
	    	values[indexToDelete] = null;
	    	
	    	//Rehash all keys after deleted key but before next null (i.e. in the same cluster)
	    	int index = (indexToDelete + 1) % keys.length;
	    	while(keys[index] != null)
	    	{
	    		//Delete keys[index] and values[index] and reinsert
	    		Key keyToRehash = keys[index];
	    		Value valueToRehash = values[index];
	    		keys[index] = null;
	    		values[index] = null;
	    		size--;
	    		put(keyToRehash, valueToRehash);
	    		index = (index + 1) % keys.length;
	    	}
	    	
	    	size--;
	    	
	    	//Resize HashTable if it is only 1/8 full
	    	if((size > 0) && (size <= keys.length/8))
	    	{
	    		resize(keys.length/2);
	    	}
    	}
    }
    
    /**
     * Get a String representation of the HashTable.
     *
     * @return a String representation of the HashTable
     */
    @Override
    public String toString() 
    {
    	String string = "index\tkey  \tvalue";
    	for(int index = 0; index < keys.length; index++)
    	{
    		if(keys[index] != null)
    		{
    			//string += "\n" + index + "\t" + keys[index] + "\t" + values[index];
    			string += String.format("\n%-5s\t%-5s\t%-5s", index, keys[index], values[index]);
    		}
    	}
    	
    	return string;
    }
}