import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;
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

        services.print2DUtil(dict.root,0);


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
        services.print2DUtil(dict.root,0);

        assertEquals(14,dict.root.key);
        assertFalse(dict.root.isRed);

        assertEquals(12,dict.root.left.key);
        assertTrue(dict.root.left.isRed);

        assertEquals(11,dict.root.left.left.key);
        assertFalse(dict.root.left.left.isRed);

        assertEquals(10,dict.root.left.left.left.key);
        assertTrue(dict.root.left.left.left.isRed);

        assertEquals(13,dict.root.left.right.key);
        assertFalse(dict.root.left.right.isRed);

        assertFalse(dict.root.right.isRed);
        assertEquals(15,dict.root.right.key);


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
        assertEquals(15,dict.root.key);
        assertFalse(dict.root.isRed);
        assertEquals(dict.root.left.key,14);
        assertTrue(dict.root.left.isRed);
        assertEquals(17,dict.root.right.key);
        assertTrue(dict.root.right.isRed);
        services.print2DUtil(dict.root,0);

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
        services.print2DUtil(dict.root,0);
        assertEquals(16,dict.root.key);
        assertFalse(dict.root.isRed);

        assertEquals(15,dict.root.left.key);
        assertTrue(dict.root.left.isRed);

        assertEquals(17,dict.root.right.key);
        assertTrue(dict.root.right.isRed);

        //testing that it is a valid Red Black Tree
        assertTrue(services.isValidRedBlackTree(dict.root));

        //testing the size
        assertEquals(dict.size(),3);

        //testing the upper bound of the red black tree height h <= 2*log2(n+1);
        assertTrue(dict.height() <= 2*(Math.log(dict.size)/Math.log(2)));

    }
    @Test
    void search_missing_value(){
        services<Integer> services = new services<>();
        RedBlack<Integer> dict = new RedBlack<>();

        for(int i = 0; i < 10; i++){
            dict.insert(ThreadLocalRandom.current().nextInt());
        }
        services.print2DUtil(dict.root,0);

        assertFalse(dict.search(5));
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
        assertEquals(14,dict.root.key);


        //when inserting an existing value it will not be inserted and return false
        assertFalse(dict.insert(222));
        assertFalse(dict.insert(3));
        assertFalse(dict.insert(5));


        services.print2DUtil(dict.root,0);
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
        RedBlack<Integer> tree = new RedBlack<>();
        int[] values = {19,17,9,75,24};
        for (int value : values) {
            tree.insert(value);
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
    void insert_case_parent_red_uncle_black_inserted_outer() {
        RedBlack<Integer> tree = new RedBlack<>();
        int[] values = {19, 17, 9, 75, 81};
        for (int value : values) {
            tree.insert(value);
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
        RedBlack<String> tree = new RedBlack<>();
        assertFalse(tree.delete("dog"));

    }
    @Test
    void delete_case_sibling_is_red(){
        RedBlack<Integer> tree = new RedBlack<>();
        tree.insert(19);
        tree.insert(17);
        tree.insert(9);
        tree.insert(85);
        tree.insert(18);
        services<Integer> serve = new services<>();
        serve.print2DUtil( tree.root,0);
        System.out.print("\n");
        assertEquals(17,tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(19,tree.root.right.key);
        assertFalse(tree.root.right.isRed);
        assertEquals(9,tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(85,tree.root.right.right.key);
        assertTrue(tree.root.right.right.isRed);
        assertEquals(18,tree.root.right.left.key);
        assertTrue(tree.root.right.left.isRed);
        //              17 (b)
        //             /  \
        //         9(b)    19(b)
        //                /   \
        //             18(r)   85(r)
        /////Tree checked
        //// Delete 9
        tree.delete(9);
        //                      19(b)
        //                     /     \
        //                17(b)      85(b)
        //                     \
        //                      18(r)
        //
        // / check
        assertEquals(19,tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(17,tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(85,tree.root.right.key);
        assertFalse(tree.root.right.isRed);
        assertEquals(18,tree.root.left.right.key);
        assertTrue(tree.root.left.right.isRed);
        serve.print2DUtil(tree.root,5);
        System.out.print("\n");
        //delete a red node
        tree.delete(18);
        //check
        //                      19(b)
        //                     /     \
        //                17(b)      85(b)
        //
        //
        serve.print2DUtil(tree.root,5);
        System.out.print("\n");
        assertEquals(19,tree.root.key);
        assertFalse(tree.root.isRed);
        assertEquals(17,tree.root.left.key);
        assertFalse(tree.root.left.isRed);
        assertEquals(85,tree.root.right.key);
        assertFalse(tree.root.right.isRed);


    }
    @Test
    void delete_case_sibling_is_black_and_2_children_black(){
        services<Integer> s = new services<>();

        RedBlack<Integer> tree = new RedBlack<>();

        tree.insert(100);
        tree.insert(150);
        tree.insert(50);
        tree.insert(175);
        tree.insert(25);
        tree.insert(27);
        tree.insert(12);
        tree.insert(122);
        tree.insert(130);
        tree.insert(26);
        tree.insert(11);
        s.print2DUtil(tree.root,0);
        System.out.print("\n\n\n");
        tree.delete(27);
        //sibling of 27 is 150 is black and his 2 children 122,175 are black
        s.print2DUtil(tree.root,0);
        assertEquals(11,tree.root.left.left.left.key);
        assertFalse(tree.root.left.left.left.isRed);

        assertEquals(12,tree.root.left.left.key);
        assertTrue(tree.root.left.left.isRed);

        assertEquals(tree.root.left.left.right.key,25);
        assertFalse(tree.root.left.left.right.isRed);

        assertEquals(26,tree.root.left.key);
        assertFalse(tree.root.left.isRed);

        assertEquals(tree.root.left.right.key,50);
        assertFalse(tree.root.left.right.isRed);

        assertEquals(tree.root.key,100);
        assertFalse(tree.root.isRed);

        assertEquals(tree.root.right.left.key,122);
        assertFalse(tree.root.right.left.isRed);

        assertEquals(tree.root.right.left.right.key,130);
        assertTrue(tree.root.right.left.right.isRed);

        assertEquals(tree.root.right.key,150);
        assertFalse(tree.root.right.isRed);

        assertEquals(tree.root.right.right.key,175);
        assertFalse(tree.root.right.right.isRed);

        tree.delete(27);
        s.print2DUtil(tree.root,0);


    }
    @Test
    void delete_u_is_black_s_is_black_v_is_black(){
        services<Integer> s = new services<>();

        RedBlack<Integer> tree = new RedBlack<>();

        tree.insert(100);
        tree.insert(150);
        tree.insert(50);
        tree.insert(175);
        tree.insert(25);
        tree.insert(27);
        tree.insert(12);
        tree.insert(122);

        s.print2DUtil(tree.root,0);

        tree.delete(175);

        s.print2DUtil(tree.root,0);
        assertEquals(100,tree.root.key);
        assertFalse(tree.root.isRed);

        assertEquals(27,tree.root.left.key);
        assertTrue(tree.root.left.isRed);

        assertEquals(150,tree.root.right.key);
        assertFalse(tree.root.right.isRed);

        assertEquals(25,tree.root.left.left.key);
        assertFalse(tree.root.left.left.isRed);

        assertEquals(12,tree.root.left.left.left.key);
        assertTrue(tree.root.left.left.left.isRed);

        assertEquals(50,tree.root.left.right.key);
        assertFalse(tree.root.left.right.isRed);

        assertEquals(150,tree.root.right.key);
        assertFalse(tree.root.right.isRed);

        assertEquals(122,tree.root.right.left.key);
        assertTrue(tree.root.right.left.isRed);
    }

}