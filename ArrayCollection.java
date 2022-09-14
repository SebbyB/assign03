package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta, Sebastian Barney, and Amelia Neilson.
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	private int maxSize; // Keeps track of the maxSize of the Array



	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
		maxSize = 10;
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		//Instantiates a new array of integers with twice the length of the previous array.
		//Clones the data from the old array into the new array.
		//Makes the Initial Array into the new array.
		//Doubles the Max Size
//		t[] ArrayCollection<T> temp = new ArrayCollection();
		T[] temp = (T[]) new Object[this.size*2];
		for(int i = 0; i < this.size; i++){
			temp[i] = this.data[i];
		}
		this.data = temp;
		this.maxSize = this.maxSize*2;
		// You will need to use something similar to the code in the constructor above to create a new array.
	}

	/**
	 * Adds data to the array if it is not already within the array. Grows array if it doesn't have enough space.
	 * @param arg0 - Argument being added.
	 * @return - True if the arg0 can be added, False if it cannot.
	 */

	public boolean add(T arg0) {
		//Checks if the array is full
		//Grows if it is full. Does nothing if it isn't.
		if(this.size == this.maxSize){
			this.grow();

		}
//		Checks if arg0 is contained in the array by typecasting arg0 to a generic object then calling contains(arg0) method.
		if(!this.contains(((Object)arg0))){

			this.data[size] = arg0;
			size += 1;
			return true;
		}
		return false;
	}

	/**
	 * Adds a list of stuff to the array.
	 * @param arg0 - List to be added.
	 * @return -Returns true if the list was added, returns false otherwise.
	 */
	public boolean addAll(Collection<? extends T> arg0) {
		//Loops through the array of stuff to be added and calls the add method for each index.
		//If anything was not added to the array, return false.
		for(T obj : arg0){
		this.add(obj);
		}
		return true;
	}

	/**
	 * Clears initial Array
	 */
	public void clear() {
		//initializes new array of size 0;
		T[] temp = (T[]) new Object[0];
		//resets size and max size to 0 and sets data of array to new array.
		this.size = 0;
		this.maxSize = 0;
		this.data = temp;

	}

	/**
	 * Checks to see if the object is already contained within the list.
	 * @param arg0 - Object that is being checked
	 * @return - True if object is in the array, False if it is not.
	 */

	public boolean contains(Object arg0) {
		//Loops through the array and if the data at any index in the array is equal to the object return true
		//Otherwise Return False.
		for(int i =0; i < this.size; i++){
			if(arg0 == this.data[i]){
				return true;
			}}
		return false;
	}

	/**
	 * Checks if the Array List Contains Anything from another Array List.
	 * @param arg0 - Array List it is Checking.
	 * @return True if Initial Array List has anything from compared List. Otherwise Return False.
	 */
	public boolean containsAll(Collection<?> arg0) {
		for(Object obj : arg0){
			//Loops through the Array and calls contains() method for every index in the compared array.

			if(!contains(obj)){return false;}
	}
	return true;
	}

	/**
	 * Checks if an Array is Empty
	 * @return -True if it is empty. Otherwise return False.
	 */
	public boolean isEmpty() {
		//Checks if the size of the array equals zero.
		if(this.size == 0){return true;}
		return false;
	}

	public Iterator<T> iterator() {

		return new ArrayCollectionIterator();
	}

	/**
	 * Removes an Object from an Array
	 * @param arg0 - The object Being Removed
	 * @return - Returns false if the object is never in the initial array. Otherwise returns true.
	 */
	public boolean remove(Object arg0) {
//Initial Check for argument in array.
		if(!this.contains(arg0)){
			return false;}
		//creates a new temporary array that is the same size as the initial array.
		T[] temp = (T[]) new Object[this.size];
		//loops through initial array.
		for(int i = 0; i < this.size; i++){
			// if at any point the array's data is equal to the argument, skip it.
			if(this.data[i].equals(arg0)){
				this.size -= 1;
				continue;

			}
			//otherwise add it to the temp array
			else{
				temp[i] = this.data[i];

			}
		}
		//set the initial array equal to the temp array and return true.
		this.data = temp;
		return true;
	}

	/**
	 * removes a collection of items (an array) from the initial array.
	 * @param arg0 - the array being removed from the initial array.
	 * @return False if the initial array doesn't contain arg0, true otherwise.
	 */
	public boolean removeAll(Collection<?> arg0) {
		//Initial check if the initial array contains arg0
		if(!this.containsAll(arg0)){ return false;}
		//if it does, loop through the array and remove each data point from the initial array and return true after they have all been removed.
//		for(int i = 0; i < arg0.size(); i++){
//			this.remove(arg0.data[i]);
//		}
		for(Object obj: arg0){
			remove(obj);
		}

		return true;
	}

	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * finds the size of an array
	 * @return - the size of the array
	 */
	public int size() {

		return this.size;
	}

	/**
	 * Changes the initial array of arbitrary size into an array that is the exact size
	 * @return - an array of exact size
	 */
	public Object[] toArray() {
		//creates a counter
		int counter = 0;
		//loops through the array and increments the counter for every non null entry in the array.
		for(int i = 0; i < this.size(); i++){
			if(this.data[i].equals(null)){
				continue;
			}
			else{
				counter++;
			}

		}
		//creates a new array of size counter (which will be the exact size of valid array entries)
		// for every entry in the array add it to the exact array if it is not null.
		Object[] newArray = new Object[counter];
		for(int j = 0; j <= counter; j++){
			if(!this.data[j].equals(null)){
		newArray[j] = (Object) this.data[j] ;}}
		return newArray;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}



	/*
     
	*/
	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		// TODO fill in this method
		return null;
	}

//	public T[] getData(){
//		return this.data;
//	}
//	public int getSize(){
//		return this.size;
//	}
	/**
	 * 
	 * @author ??
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		int nextIDX = 0;
		public ArrayCollectionIterator()
		{
		//does something that we dont know
		}

		public boolean hasNext() {

			return nextIDX < size;
		}

		public T next() {
			return data[nextIDX++];
		}

		public void remove() {
//			this.remove(nextIDX);
		}

	}

}
