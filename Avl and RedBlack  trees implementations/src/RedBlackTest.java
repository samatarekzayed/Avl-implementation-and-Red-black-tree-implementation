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
//        assertEquals(6,dict.root.left.left.key);
//        assertEquals(false,dict.root.left.left.isRed);
        assertEquals(8,dict.root.left.right.key);
        assertEquals(false,dict.root.left.right.isRed);
//        assertEquals(5,dict.root.left.left.left.key);
//        assertEquals(true,dict.root.left.left.left.isRed);
        assertEquals(5,dict.root.left.left.left.key);
        assertEquals(true,dict.root.left.left.left.isRed);
    }
}