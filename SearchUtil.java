package assign03;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Daniel Kopta and ??
 * A utility class for searching, containing just one method (see below).
 *
 */
public class SearchUtil {

	
	/**
	 * Searches through a List to see if an item is in it.
	 *
	 * 
	 * @param <T>	The type of elements contained in the list
	 * @param list	An ArrayList to search through. 
	 * 				This ArrayList is assumed to be sorted according 
	 * 				to the supplied comparator. This method has
	 * 				undefined behavior if the list is not sorted. 
	 * @param item	The item to search for
	 * @param cmp	Comparator for comparing Ts or a super class of T
	 * @return		true if the item exists in the list, false otherwise
	 */
	public static <T> boolean binarySearch(ArrayList<T> list, T item, Comparator<? super T> cmp) {
//		Initializes a left and right hand side variable.
		int left,right;
//		Sets them equal to the ends of the list
		left = 0;
		right = list.size();

//Loop through the list and if at any point the list has the item return true
	while(left <= right){
		//establish a middle point between left and right.
		int mid = left + ((right - left)/2);
		if(list.get(mid).equals(item)){
			return true;
		}
		//Close in from both sides...
		if(cmp.compare(list.get(mid), item) >0){
			left = mid -1;
		}
		if(cmp.compare(list.get(mid), item) <0){
			right = mid -1;
		}
	}
		return false;
	}	
}