/* HashTableChained.java */

package dict;
import list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	public int size = 0;
	public int bucketNum = 0;
	public int collisionNum = 0;
	protected DList[] hashTable;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

	
	public static boolean isPrime(int num) {
		if(num == 2) return true;
		if(num > 2) {
			for(int i = 2; i * i <= num; i++) {
				if(num % i == 0) return false;
			}
			return true;
		}
		return false;
	}
	
	public static int getNearestPrime(int num) {
		while(true) {
			if(isPrime(num)) return num;
			else num++;
		}
	}
	
	public double expectedCollisionNum(int n, int N) {
		return n - N + N * Math.pow((1 - 1.0 / N), n);
		}


  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  bucketNum = getNearestPrime(sizeEstimate);
	  size = 0;
	  hashTable = new DList[bucketNum];
	  for(int i = 0; i < bucketNum; i++) {
		  hashTable[i] = new DList();
	  }
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	  this(100);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
/*	  int i = Math.abs(code) % bucketNum;
	  int a = getNearestPrime(100);
	  int b = getNearestPrime(200);
	  int N = bucketNum;
	  int p = 100 * bucketNum;
	  return ((a * i + b) % p) % N;
*/
      return Math.abs(code) % bucketNum;
	  
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	  int index = compFunction(key.hashCode());
	  Entry entry = new Entry();
	  entry.key = key;
	  entry.value = value;
	  if(hashTable[index].length() != 0) collisionNum++;
	  hashTable[index].insertFront(entry);
	  size++;
	  return entry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	  int index = compFunction(key.hashCode());
	  if(hashTable[index].isEmpty()) {
		  return null;
	  }else {
		DListNode node = (DListNode)hashTable[index].front();
		while(node != null) {
            if(key.equals(((Entry)node.item).key())) {
            	return (Entry)node.item;
            }else {
            	node = hashTable[index].next(node);
            }
		}
		return null;
		}
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	  int index = compFunction(key.hashCode());
	  if(hashTable[index].isEmpty()) {
		  return null;
	  }else {
		DListNode node = (DListNode)hashTable[index].front();
		while(node != null) {
            if(key.equals(((Entry)node.item).key())) {
            	hashTable[index].remove(node);
            	size--;
            	return (Entry)node.item;
            }else {
            	node = hashTable[index].next(node);
            }
		}
		return null;
		}
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	  size = 0;
	  for(int i = 0; i < bucketNum; i++) {
		  hashTable[i] = new DList();
	  }
  }
  
  public String toString() {
	  String result = "[ ";
	  for (int i = 0; i < bucketNum; i++) {
		  result += hashTable[i].length() + " ] ";
		  if((i + 1) % 10 == 0) result += "\n";
		  if(i != (bucketNum - 1))result += "[ ";
		  }
	  return result;
	  }
  
  }

