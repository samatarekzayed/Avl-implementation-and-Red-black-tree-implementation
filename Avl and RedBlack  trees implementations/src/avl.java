
class avl {
    avlnode root;
    public avl()
    {
        this.root = null;
    }
    //////////////////////////////////////////////////////////
    int balanced(avlnode u) {
        if (u == null)
            return 0;

        return getHeight(u.left) - getHeight(u.right);
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
        //avlnode newNode=new avlnode(key);
        if(root!=null){
            if (key > root.key) {
                root.right = insert((root.right), key);
                if (balanced(root) == -2){
                    if(key>root.right.right.key)
                        leftRotate(root);
                    else {
                        rightRotate(root.right);
                        leftRotate(root);
                    }
                }
            }
            else {
                root.left = insert(root.left, key);
                if(balanced(root)==2){
                    if(key< root.left.left.key)
                        rightRotate(root);
                    else{
                        leftRotate(root.left);
                        rightRotate(root);
                        {
                }
            }

        }
        else  //reach leaf
            root=new avlnode(key);

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
        return 0;
    }

    ///////////////////////////////////////////////////////////////////

}