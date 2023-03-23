import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class dictionaryTest {
    @Test
    void height_upper_bound_for_avl(){
        dictionary dict = new dictionary("avl");
        //inserting 2 words
        dict.insert("green");
        dict.insert("zebra");
        //dict.batchInsert("insertions1.txt")[0] returns the number of words  inserted from the file
        //dict.batchInsert("insertions1.txt")[1] returns the number of words not inserted from the file because they already existed
        //inserting a batch of 500 words.
        assertEquals(500,dict.batchInsert("insertions1.txt")[0]);
        //testing the size of the dict after insertion of 502 words.
        assertEquals(502,dict.size());
        // testing the upper bound condition for AVL tree height h <= 1.44*log2(n)

        assertTrue(dict.treeHeight() <= 1.44*(Math.log(dict.size())/Math.log(2)));
    }
    @Test
    void insert_in_dictionary() {
        dictionary dict = new dictionary("avl");
        assertEquals(true,dict.insert("play"));
    }
    @Test
    void search_in_avl(){
        dictionary dict = new dictionary("avl");
        dict.insert("play");
        dict.insert("car");
        dict.insert("book");
        dict.insert("apple");
        assertEquals(true,dict.search("play"));
        assertEquals(true,dict.search("apple"));
        assertEquals(false,dict.search("free"));
        assertEquals(false,dict.search("fork"));
    }
    @Test
    void batchInsertion_with_words_already_existing_in_avl(){

        dictionary dict = new dictionary("avl");
        dict.insert("deferment");
        dict.insert("worriedness");

        //file contains 1000 words 2 of them already exists in the dictionary
        //dict.batchInsert(path)[0] returns the number of new words inserted from the file
        //2+998 = 1000 words
        assertEquals(998,dict.batchInsert("insertions.txt")[0]);
    }
    @Test
    void batchInsertion_with_empty_dictionary_in_avl(){

        dictionary dict = new dictionary("avl");
        //file contains 1000 words 2 of them already exists in the dictionary
        //dict.batchInsert(path)[0] returns the number of new words inserted from the file
        //2+998 = 1000 words
        assertEquals(1000,dict.batchInsert("insertions.txt")[0]);
        // dict size is now 1000
        assertEquals(dict.batchInsert("insertions.txt")[1],dict.size());
    }
    //////////////////////////////////////// RED BLACK TESTS ///////////////////////////////////////////////////////////////////
    // RedBlack dictionary (Problem)
    @Test
    void batchInsertion_with_redblack(){
        dictionary dict = new dictionary("RedBlack");
        assertEquals(20,dict.batchInsert("insertions1.txt")[0]);
    }
    @Test
    void insert_in_redblack_dictionary() {
        dictionary dict = new dictionary("RedBlack");
        assertEquals(true,dict.insert("play"));
    }
    @Test
    void search_in_redblack(){
        dictionary dict = new dictionary("RedBlack");
        dict.insert("play");
        dict.insert("car");
        dict.insert("book");
        dict.insert("apple");
        assertEquals(true,dict.search("play"));
        assertEquals(true,dict.search("apple"));
        assertEquals(false,dict.search("free"));
        assertEquals(false,dict.search("fork"));
    }
    @Test
    void batchInsertion_with_words_already_existing_in_RedBlack(){

        dictionary dict = new dictionary("RedBlack");
        dict.insert("deferment");
        dict.insert("worriedness");

        //file contains 1000 words 2 of them already exists in the dictionary
        //dict.batchInsert(path)[0] returns the number of new words inserted from the file
        //2+998 = 1000 words
        assertEquals(998,dict.batchInsert("insertions.txt")[0]);
    }
    @Test
    void batchInsertion_with_empty_dictionary_in_redblack(){

        dictionary dict = new dictionary("RedBlack");
        //file contains 1000 words 2 of them already exists in the dictionary
        //dict.batchInsert(path)[0] returns the number of new words inserted from the file
        //2+998 = 1000 words
        assertEquals(1000,dict.batchInsert("insertions.txt")[0]);
        // dict size is now 1000
        assertEquals(dict.batchInsert("insertions.txt")[1],dict.size());
    }



}