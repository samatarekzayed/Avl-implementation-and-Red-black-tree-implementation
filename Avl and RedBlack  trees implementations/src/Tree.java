public interface Tree<key> {


// You are required to implement both AVL and Red Black trees that can deal with keys of any
// comparable type (generic). You need to implement the following operations in both of them:

// Insert: Takes a key and inserts it if it is not in the tree. Returns true if it is added and
// false if it already exists. Must run in O(log n)

    public boolean insert(key k);

// Delete: Takes a key and deletes it if it is in the tree. Returns true if it is deleted and false
// if it is not in the tree. Must run in O(log n).

    public boolean delete(key k);

// Search: Takes a key and searches for it returning true if it is found in the tree and false
// otherwise. Must run in O(log n)

    public boolean search(key k);

// Size: Returns the number of keys in the tree. Must run in O(1).

    public int size();

// Height: Returns the height of the tree which is the longest path from the root to a leaf
// node. Can run up to O(n).

    public int height();

}
