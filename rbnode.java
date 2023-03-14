public class rbnode {
    int key;
    String word;
    boolean color;
    rbnode left;
    rbnode right;
    rbnode parent;

    int height;

    // Constructor
    rbnode(int value)
    {
        key=value;
        height=0;
        word=null;
        left = null;
        right =null;
        parent = null;
        color = true;//red is true and black is false
    }
    rbnode(String value)
    {
        key=0;
        height=0;
        word=value;
        left = null;
        right =null;
        parent = null;
        color = true;//red is true and black is false
    }
}
