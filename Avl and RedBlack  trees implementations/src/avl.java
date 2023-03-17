
class avl {
    avlnode root;
    int size;
    public avl()
    {
        this.root = null;
    }
    //////////////////////////////////////////////////////////
    boolean isBalanced(avlnode u) {
//        if (u == null)
//            return false;
        return Math.abs(height(u.left) - height(u.right)) >= 2;
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
            return -1;
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
            if (isBalanced(root)) {
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
            if (isBalanced(root)) {
                if (key < root.left.key)
                    root=rightRotate(root);
                else {
                    root.left = leftRotate(root.left);
                    root=rightRotate(root);
                }
            }
        }
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            return root;
    }

    ///////////////////////////////////////////////////////////////
    avlnode delete(avlnode root, int key){


//testt

        return root;
    }
    ///////////////////////////////////////////////////////////////
    int size(avlnode n)
    {
        return this.size;
    }

    ///////////////////////////////////////////////////////////////////

}