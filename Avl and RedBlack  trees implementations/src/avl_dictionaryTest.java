import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class avl_dictionaryTest {

    @Test
    void insert() {
        avl_dictionary dict = new avl_dictionary("avl");
        assertEquals(true,dict.insert("play"));
    }
    @Test
    void search(){
        avl_dictionary dict = new avl_dictionary("avl");
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
    void batchInsertion_with_words_already_existing(){
        //file contains 13 words 2 of them already exists in the dictionary
        avl_dictionary dict = new avl_dictionary("avl");
        //dict.batchInsert(path)[0] returns the number of new words inserted from the file
        assertEquals(1000,dict.batchInsert("insertions.txt")[0]);
    }
    @Test
    void batchInsertion_with_redblack(){
        avl_dictionary dict = new avl_dictionary("RedBlack");
        assertEquals(20,dict.batchInsert("insertions1.txt")[0]);
    }
    @Test
    void batchInsertion_with_words_not_inserted(){
        avl_dictionary dict = new avl_dictionary("avl");
        dict.insert("green");
        dict.insert("zebra");
        //dict.batchInsert(path)[1] returns the number of words not inserted from the file because they already existed
        assertEquals(2,dict.batchInsert("insertions.txt")[1]);
    }


}