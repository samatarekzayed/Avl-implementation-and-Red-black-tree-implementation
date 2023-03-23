import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTest {

    @Test
    void insert() {
        RedBlack dict = new RedBlack<>();
        dict.insert(10);
        dict.insert(9);
        dict.insert(8);
        dict.insert(6);
        dict.insert(7);
        dict.insert(5);
        dict.insert(4);
        assertEquals(9,dict.root.key);
        assertEquals(false,dict.root.isRed);
        assertEquals(7,dict.root.left.key);
        assertEquals(true,dict.root.left.isRed);
        assertEquals(10,dict.root.right.key);
        assertEquals(false,dict.root.right.isRed);
        assertEquals(6,dict.root.left.left.right.key);
        assertEquals(true,dict.root.left.left.right.isRed);
        assertEquals(8,dict.root.left.right.key);
        assertEquals(false,dict.root.left.right.isRed);
        assertEquals(4,dict.root.left.left.left.key);
        assertEquals(true,dict.root.left.left.left.isRed);
        assertEquals(5,dict.root.left.left.key);
        assertEquals(false,dict.root.left.left.isRed);
        assertEquals(3,dict.height());

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size+1)/Math.log(2)));
        assertTrue(dict.search(5));
        //testing the delete function
        assertEquals(true,dict.delete(5));
        assertFalse(dict.search(5));
    }

    @Test
    void delete_from_empty_tree(){
        RedBlack tree = new RedBlack();
        assertEquals(false,tree.delete("dog"));

    }

//        assertTrue(tree.height() <= 1.44*Math.log(2,tree.size()));

        //tree height = 3


    //          10                    9              9                                 9
    //         /   Right_Rotate      / \            / \                               /  \
    //        9   =====>           8   10 ====>   8     10  =========>               7    10
    //       /                                   /                                  / \
    //      8                                   6                                  6   8
    //                                           \
    //                                             7
    @Test
    void insert_when_not_existed() {
        RedBlack tree = new RedBlack<>();
        assertEquals(true,tree.insert("bag"));
    }
    @Test
    void insert_when_existed(){
        RedBlack<String> tree = new RedBlack<>();
        tree.insert("bag");
        assertEquals(false,tree.insert("bag"));
    }
    @Test
    void insert_case_parent_uncle_black(){
        RedBlack tree = new RedBlack<>();
        int[] values = {19,17,9,75,18,81};
        for(int i=0;i<values.length;i++){
            tree.insert(values[i]);
        }
        assertEquals(17,tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(19,tree.root.right.key);
        assertTrue(tree.root.right.isRed);
        assertEquals(9,tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(18,tree.root.right.left.key);
        assertFalse(tree.root.right.left.isRed);
        assertEquals(81,tree.root.right.right.key);
        assertFalse(tree.root.right.right.isRed);
    }
    @Test
    void insert_case_parent_red_uncle_black_isnerted_inner(){
        RedBlack tree = new RedBlack<>();
        int[] values = {19,17,9,75,24};
        for(int i=0;i<values.length;i++){
            tree.insert(values[i]);
        }
        assertEquals(17,tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(24,tree.root.right.key);
        assertFalse(tree.root.right.isRed);
        assertEquals(9,tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(19,tree.root.right.left.key);
        assertTrue(tree.root.right.left.isRed);
        assertEquals(75,tree.root.right.right.key);
        assertTrue(tree.root.right.right.isRed);


    }
    @Test
    void insert_case_parent_red_uncle_black_isnerted_outer() {
        RedBlack tree = new RedBlack<>();
        int[] values = {19, 17, 9, 75, 81};
        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
        }
        assertEquals(17, tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(75, tree.root.right.key);
        assertFalse(tree.root.right.isRed);
        assertEquals(9, tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(19, tree.root.right.left.key);
        assertTrue(tree.root.right.left.isRed);
        assertEquals(81, tree.root.right.right.key);
        assertTrue(tree.root.right.right.isRed);

    }

        @Test
    void testing_search_of_an_existing_word(){
        RedBlack<String> tree = new RedBlack<>();
        tree.insert("dog");
        assertEquals(true,tree.search("dog"));
    }
    @Test
    void testing_search_of_an_missing_word(){
        RedBlack<String> tree = new RedBlack<>();

        assertEquals(false, tree.search("book"));

    }

}