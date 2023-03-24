import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.*;
class avlTest {

    @Test
    void insert_in_empty_tree() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        dict.insert(10);


        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

        //testing the size
        assertEquals(dict.size(),1);

        //testing that the root is the element
        assertEquals(dict.root.key,10);
    }

    @Test
    void insert_right_right() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        dict.insert(10);
        dict.insert(11);
        dict.insert(12);
        dict.insert(13);
        dict.insert(14);
        dict.insert(15);



        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),6);

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

    }

    @Test
    void insert_left_left() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        dict.insert(15);
        dict.insert(14);
        dict.insert(13);
        dict.insert(12);
        dict.insert(11);
        dict.insert(10);



        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),6);

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

    }

    @Test
    void insert_left_right() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        dict.insert(15);
        dict.insert(14);
        dict.insert(17);


        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),3);

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

    }

    @Test
    void insert_right_left() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        dict.insert(15);
        dict.insert(17);
        dict.insert(16);


        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),3);

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

    }

    @Test
    void insert_Random_And_Search() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
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

        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),16);

        System.out.println(dict.size());
        System.out.println(dict.height());

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

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

    //          10                    9              9                                 9
    //         /   Right_Rotate      / \            / \                               /  \
    //        9   =====>           8   10 ====>   8     10  =========>               7    10
    //       /                                   /                                  / \
    //      8                                   6                                  6   8
    //                                           \
    //                                             7

    @Test
    void delete_in_empty_tree() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();

        assertFalse(dict.delete(10));


        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));


        //testing the size
        assertEquals(dict.size(),0);

        //testing that the root is the element
        assertEquals(dict.root,null);
    }

    @Test
    void random_Delete() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        //insert
        assertTrue(dict.insert(10));
        assertTrue(dict.insert(11));
        assertTrue(dict.insert(12));
        assertTrue(dict.insert(13));
        assertTrue(dict.insert(14));
        assertTrue(dict.insert(15));
        //delete not existed
        assertFalse(dict.delete(5));
        assertFalse(dict.delete(9));
        assertFalse(dict.delete(16));
        //delete existed
        assertTrue(dict.delete(10));
        assertTrue(dict.delete(15));
        //delete not existed
        assertFalse(dict.delete(10));
        assertFalse(dict.delete(15));


        //testing that it is a valid avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),4);

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

    }


    @Test
    void insert_Delete_Random_And_Search() {
        services<Integer> services = new services<>();
        avl<Integer> dict = new avl<>();
        assertTrue(dict.insert(15));
        assertTrue(dict.insert(13));
        assertTrue(dict.insert(14));
        assertTrue(dict.insert(17));
        assertTrue(dict.insert(19));
        assertTrue(dict.insert(16));
        assertTrue(dict.insert(222));
        assertTrue(dict.insert(3));
        assertTrue(dict.insert(5));


        //when insert an existed value it will not be inserted and return false
        assertFalse(dict.insert(222));
        assertFalse(dict.insert(3));
        assertFalse(dict.insert(5));

        //delete elements
        assertTrue(dict.delete(16));
        assertTrue(dict.delete(14));
        assertTrue(dict.delete(222));

        //delete elements not existed
        assertFalse(dict.delete(16));
        assertFalse(dict.delete(14));
        assertFalse(dict.delete(1000));

        //testing that it is a valid Avl Tree
        assertTrue(services.isValidAvlTree(dict.root));

        //testing the size
        assertEquals(dict.size(),6);

        System.out.println(dict.size());
        System.out.println(dict.height());

        //testing the upper bound of the avl tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 1.44*(Math.log(dict.size())/Math.log(2)));

        //search true
        assertTrue(dict.search(13));
        assertTrue(dict.search(15));
        assertTrue(dict.search(3));
        assertTrue(dict.search(5));

        //search false
        assertFalse(dict.search(1));
        assertFalse(dict.search(2));
        assertFalse(dict.search(30));
        assertFalse(dict.search(21));
        assertFalse(dict.search(444));


    }

}