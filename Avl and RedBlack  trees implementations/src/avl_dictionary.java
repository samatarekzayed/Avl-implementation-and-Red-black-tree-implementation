import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class avl_dictionary implements IDictionary{


		avl<String> dictionary = new avl<>();



	/**
	 * @param word string
	 * @return boolean if the insertion is successful, false otherwise.
	 */
	@Override
	public boolean insert(String word) {
		if(!dictionary.search(word)) {
			dictionary.insert(word);
			return true;
		}
		else
			return false;
	}

	/**
	 * @param k a word to search for
	 * @return true if found, false otherwise
	 */
	@Override
	public boolean search(String k) {
		return dictionary.search(k);
	}
	/**
	 * @param k a word to be deleted
	 * @return true if the word is found and deleted, false otherwise
	 */
	@Override
	public boolean delete(String k) {
		//if(dictionary.search(k)){
			return dictionary.delete(k);
			//return true;
		//}
		//else
		//	return false;
	}



	/**
	 * @param path file's full path to read from
	 * @return an array of integers
	 * counters[0] = number of words successfully inserted
	 * counter[1] = number of words that already existed
	 */
	@Override
	public int[] batchInsert(String path) {
		int[] counters = {0,0};
		int insert_count=0;
		int exist_count=0;
		try{
			
			File myfile = new File(path);
			Scanner myReader = new Scanner(myfile);
			while(myReader.hasNextLine()){
				String word = myReader.nextLine();
				boolean inserted = dictionary.insert(word);
				if(inserted){
					insert_count = insert_count+1;
				}
				else
					exist_count = exist_count+1;
			}
			myReader.close();
		}catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    }
		counters[0] = insert_count;
		counters[1] = exist_count;
		return counters;
	}

	/**
	 * @param path a file's full path to open to read from
	 * @return an array of 2 integers
	 * counters[0] = number of successfully deleted words
	 * counters[1] = number of missing words in the dictionary
	 */
	@Override
	public int[] batchDelete(String path) {
		int[] counters = {0,0};
		int deleted_count=0;
		int notexist_count=0;
		try{

			File myfile = new File(path);
			Scanner myReader = new Scanner(myfile);
			while(myReader.hasNextLine()){
				String word = myReader.nextLine();
				boolean deleted = dictionary.delete(word);
				if(deleted){
					deleted_count = deleted_count+1;
				}
				else
					notexist_count = notexist_count+1;
			}
			myReader.close();
		}catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		counters[0] = deleted_count;
		counters[1] = notexist_count;
		return counters;


	}

	/**
	 * @return # of words
	 */
	@Override
	public int size() {
		return dictionary.size();
	}

	/**
	 * @return height of the dictionary tree
	 */
	@Override
	public int treeHeight() {
		return dictionary.height();
	}
	public void Orderlist(){
		dictionary.inorder(dictionary.root);
	}




}
