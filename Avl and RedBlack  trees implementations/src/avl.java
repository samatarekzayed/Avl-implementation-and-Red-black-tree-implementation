
class avl {
    avlnode root = null;
    private int size = 0;
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
    avlnode leftRotate(avlnode n) {
        avlnode node2 = n.right;
        n.right = node2.left;
        node2.left = n;
        n.height = getMaxHeight( height( n.left ), height( n.right ) ) + 1;
        node2.height = getMaxHeight( height( node2.right ), n.height ) + 1;
        return node2;
    }
    ////////////////////////////////////////////////////////////
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
    {
        return Math.max(leftNodeHeight, rightNodeHeight);
    }
    /////////////////////////////////////////////////////////////
    avlnode rightRotate(avlnode n) {
        avlnode node1 = n.left;
        n.left = node1.right;
        node1.right = n;
        n.height = getMaxHeight( height( n.left ), height( n.right ) ) + 1;
        node1.height = getMaxHeight( height( node1.left ), n.height ) + 1;
        return node1;
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


//hhhhh

        return root;
    }
    ///////////////////////////////////////////////////////////////
    int size(avlnode n)
    {
        return this.size;
    }

    ///////////////////////////////////////////////////////////////////

}