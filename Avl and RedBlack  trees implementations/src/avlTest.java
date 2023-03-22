import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class avlTest {

    @Test
    void delete_from_empty_tree(){
        avl tree = new avl<>();
        assertEquals(false,tree.delete("dog"));

    }
    //left left case
    @Test
    void insert(){
        avl tree = new avl<>();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);
        assertEquals(9,tree.root.key);
        assertEquals(7,tree.root.left.key);
        assertEquals(10,tree.root.right.key);
        assertEquals(8,tree.root.left.right.key);
        assertEquals(6,tree.root.left.left.key);

        //tree height = 3
        assertEquals(6,tree.root.left.left.key);
        //assertEquals(3,tree.height());
    }
    //          10                    9              9                                 9
    //         /   Right_Rotate      / \            / \                               /  \
    //        9   =====>           8   10 ====>   8     10  =========>               7    10
    //       /                                   /                                  / \
    //      8                                   6                                  6   8
    //                                           \
    //                                             7
    @Test
    void insert_when_not_existed() {
        avl tree = new avl<>();
        assertEquals(true,tree.insert("bag"));
    }
    @Test
    void insert_when_existed(){
        avl<String> tree = new avl<>();
        tree.insert("bag");
        assertEquals(false,tree.insert("bag"));
    }
    @Test
    void testing_search_of_an_existing_word(){
        avl<String> tree = new avl<>();
        tree.insert("dog");
        assertEquals(true,tree.search("dog"));
    }
    @Test
    void testing_search_of_an_missing_word(){
        avl<String> tree = new avl<>();

        assertEquals(false, tree.search("book"));

    }

}