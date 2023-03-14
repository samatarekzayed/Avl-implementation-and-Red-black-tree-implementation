
public class avlnode {
    int key;//value in numbers
    String word;// value in words will be used in dictionary
    int height;
    avlnode left;
    avlnode right;

    avlnode(int value) {
        key = value;
        height = 0;
        word="";
    }
    avlnode(String value) { // constructor for words(dictionary)
        height = 0;
        word=value;
    }
}
