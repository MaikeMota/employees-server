package util;

import java.util.Collection;
import java.util.Collections;

/**
 * Utility tool to handle collections
 * @author maike
 *
 */
public class CollectionsUtil {
	
	/**
	 *  Verifies if collectionA has any item of collectionB
	 * @param collectionA the target collection to be checked
	 * @param collectionB the collection to be used for search on collectionA
	 * @return {@code true} if the two specified collections have any elements in common.
	 */
	public static boolean hasAny(Collection<String> collectionA, Collection<String> collectionB) {
		return !Collections.disjoint(
				collectionA,
				collectionB
			);
		
	}

}
