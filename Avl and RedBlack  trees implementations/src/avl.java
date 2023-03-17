
class avl {
    avlnode root;
    int size;
    public avl()
    {
        this.root = null;
    }
    //////////////////////////////////////////////////////////
    boolean balanced(avlnode u) {
//        if (u == null)
//            return false;
        return Math.abs(getHeight(u.left) - getHeight(u.right)) < 2;
    }

    ////////////////////////////////////////////////////////////
    avlnode search(avlnode root, int key)
    {



        return null;
    }

    //////////////////////////////////////////////////////////////////
    int height(avlnode n)
    {
        if (n == null)
            return 0;
        return n.height;
    }
    ///////////////////////////////////////////////////////////////////
    avlnode rightRotate(avlnode n) {

        return null;
    }

    /////////////////////////////////////////////////////////////
    avlnode leftRotate(avlnode n) {

        return null;
    }

    ///////////////////////////////////////////////////////////////
    private int getHeight(avlnode node )
    {
        if(node==null)
            return -1;
        else
            return node.height;
    }
    //////////////////////////////////////////////////////////////
    public void insertElement(int key){
        this.root=insert(root,key);
    }
    private avlnode insert(avlnode root, int key) {
        if(root==null){ //reach leaf
            root = new avlnode(key);
            size++;
        }
        else if (key > root.key) {
            root.right = insert((root.right), key);
            if (!balanced(root)) {
                if (key > root.right.key)
                    root=leftRotate(root);
                else {
                    root.right = rightRotate(root.right);
                    root=leftRotate(root);
                }
            }
        }
        else {
            root.left = insert(root.left, key);
            if (!balanced(root)) {
                if (key < root.left.key)
                    root=rightRotate(root);
                else {
                    root.left = leftRotate(root.left);
                    root=rightRotate(root);
                }
            }
        }
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
            return root;
    }

    ///////////////////////////////////////////////////////////////
    avlnode delete(avlnode root, int key){




        return root;
    }
    ///////////////////////////////////////////////////////////////
    int size(avlnode n)
    {
        return this.size;
    }

    ///////////////////////////////////////////////////////////////////

}