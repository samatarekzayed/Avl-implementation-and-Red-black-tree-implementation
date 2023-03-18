public class avl_dictionary implements IDictionary{

	avl dictionary = new avl<>();


	/**
	 * @param k 
	 * @return
	 */
	/*@Override
	public boolean insert(String k) {
		if(!search(k)) {
			root.insert(k);
			return true;
		}
		else
			return false;
	}*/

	/**
	 * @param k 
	 * @return False if the value is not located
	 */
	@Override
	public boolean delete(String k) {
		if(search(k)){
			dictionary.delete(k);
		}
		return false;
	}

	/**
	 * @param k 
	 * @return
	 */
	@Override
	public boolean search(String k) {
		return dictionary.search(k);
	}

	/**
	 * @param path 
	 * @return
	 */
	@Override
	public boolean batchInsert(String path) {
		return false;
	}

	/**
	 * @param path 
	 * @return
	 */
	@Override
	public boolean batchDelete(String path) {
		return false;
	}

	/**
	 * @return 
	 */
	@Override
	public int size() {
		return dictionary.size();
	}

	/**
	 * @return 
	 */
	@Override
	public int treeHeight() {
		return dictionary.height();
	}

	@Override
	public boolean insert(String word) {
		if(!search(word)) {
			dictionary.insert(word);
			return true;
		}
		else
			return false;
	}


}
