import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
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
	public int batchInsert(String path) {
		int insert_count=0;
		try{
			
			File myfile = new File(path);
			Scanner myReader = new Scanner(myfile);
			while(myReader.hasNextLine()){
				String word = myReader.nextLine();
				boolean inserted = dictionary.insert(word);
				if(inserted){
					insert_count = insert_count++;
				}
			}
			myReader.close();
		}catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    }
			
		return insert_count;
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
