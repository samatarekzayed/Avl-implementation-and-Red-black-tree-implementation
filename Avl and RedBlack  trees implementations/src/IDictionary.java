public interface IDictionary{

// Initialize (constructor): Takes the name of the type of the backend tree as an input and
// create a new empty dictionary based on it.
// either red-black tree or avl tree


// Insert: Takes a single string key and tries to insert it.
    boolean insert(String k);

   // Delete: Takes a single string key and tries to delete it.
     boolean delete(String k);

// Search: Takes a single string key, searches for it and return true if it exists and false otherwise
     boolean search(String k);

// Batch insert: Takes a path to a text file containing multiple words each in a separate line.
// And tries to insert all that words in the dictionary.
     int[] batchInsert(String path);

// Batch delete: Takes a path to a text file containing multiple words each in a separate
// line. And tries to delete all that words from the dictionary.
     int[] batchDelete(String path);


// Size: Returns the number of string keys in the dictionary.
     int size();

// Tree Height: Returns the height of the dictionary backend tree.
     int treeHeight();

// OrderList: Prints out the content of the Dictionary in order (in-order traversal)
}
