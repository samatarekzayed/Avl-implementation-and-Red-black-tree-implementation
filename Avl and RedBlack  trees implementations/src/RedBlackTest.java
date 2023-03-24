import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTest {

    @Test
    void insert_in_empty_tree() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(10);


        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

        //testing the size
        assertEquals(dict.size(),1);

        //testing that the root is the element
        assertEquals(dict.root.key,10);
    }

    @Test
    void insert_right_right() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(10);
        dict.insert(11);
        dict.insert(12);
        dict.insert(13);
        dict.insert(14);
        dict.insert(15);



        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),6);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

    }

    @Test
    void insert_left_left() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(15);
        dict.insert(14);
        dict.insert(13);
        dict.insert(12);
        dict.insert(11);
        dict.insert(10);



        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),6);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

    }

    @Test
    void insert_left_right() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(15);
        dict.insert(14);
        dict.insert(17);


        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),3);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

    }

    @Test
    void insert_right_left() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(15);
        dict.insert(17);
        dict.insert(16);


        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),3);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

    }

    @Test
    void insert_Random_And_Search() {
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();
        dict.insert(15);
        dict.insert(13);
        dict.insert(14);
        dict.insert(17);
        dict.insert(19);
        dict.insert(16);
        dict.insert(8);
        dict.insert(20);
        dict.insert(7);
        dict.insert(22);
        dict.insert(3);
        dict.insert(5);
        dict.insert(27);
        dict.insert(222);
        dict.insert(333);
        dict.insert(555);

        //when insert an existed value it will not be inserted and return false
        assertFalse(dict.insert(222));
        assertFalse(dict.insert(3));
        assertFalse(dict.insert(5));

        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),16);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

        //search true
        assertTrue(dict.search(27));
        assertTrue(dict.search(15));
        assertTrue(dict.search(3));
        assertTrue(dict.search(5));
        assertTrue(dict.search(555));

        //search false
        assertFalse(dict.search(1));
        assertFalse(dict.search(2));
        assertFalse(dict.search(30));
        assertFalse(dict.search(21));
        assertFalse(dict.search(444));


    }

    @Test
    void insert_case_parent_red_uncle_black_inserted_inner(){
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
    void delete_from_empty_tree(){
        RedBlack tree = new RedBlack();
        assertFalse(tree.delete("dog"));

    }


        //tree height = 3


    //          10                    9              9                                 9
    //         /   Right_Rotate      / \            / \                               /  \
    //        9   =====>           8   10 ====>   8     10  =========>               7    10
    //       /                                   /                                  / \
    //      8                                   6                                  6   8
    //                                           \
    //                                             7






}