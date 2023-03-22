import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class avlTest {

    @Test
    void delete_from_empty_tree(){
        avl tree = new avl<>();
        assertEquals(false,tree.delete("dog"));

    }

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