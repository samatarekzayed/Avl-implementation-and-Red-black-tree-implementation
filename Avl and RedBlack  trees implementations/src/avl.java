import static sun.swing.MenuItemLayoutHelper.max;

class avl {
    avlnode root = null;
    private int size = 0;
    public avl()
    {
        this.root = null;
    }
    //////////////////////////////////////////////////////////

    int balanced(avlnode u) {
        if (u == null)
            return 0;

        return u.left.height - u.right.height;
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

    avlnode inorderSucessor(avlnode n){

        n=n.right; //e7na mot2kdenn enha internal w 3ndha left w right
        while (n.left!=null){
            n=n.left;
        }
        return n;
    }
    avlnode delete(avlnode root, int key){
        if (root==null){
            //mbda2eyn 3shan a-handle lw elnode mesh mwgoda asln
            return root;
        }
        if (key< root.key){
            root.left=delete(root.left,key);
        }
        else if (key> root.key){
            root.right=delete(root.right,key);
        }
        else{
            //kda e7na la2ena el node w 3ndena 3 cases
            //elnode leaf
            //elnode 3ndha ebn wa7ed
            //elnode internal
            if ((root.left == null) && (root.right == null)){
                root=null;
            }
            else if(root.left == null){
                root=root.right;
            }
            else if(root.right == null){
                root=root.left;
            }
            else {
                //internallllllllllllllllllllllllllllllllllllllll
                avlnode temp = inorderSucessor(root.right);
                root.key=temp.key;
                //ka2en m7slsh hga bkml 3dy 3ndy shakkk fel 4 stor ely t7t dol
                if (key< root.key){
                    root.left=delete(root.left,key);
                }
                else if (key> root.key){
                    root.right=delete(root.right,key);
                }


            }

        }
        //after returning from the recursive call
        //7n-update el height
        root.height=max(root.left.height,root.right.height)+1;
        //n-check lw 7sal moshkla flbalance bt3 elnode
        int diffLR=balanced(root);
        if (diffLR>1){
            //eln7ya el left atwal mshet left el awal
            if (key<root.left.key){

                return rightRotate(root);
                //case left left
            }
            else {
                root.left=leftRotate(root.left);
                return(rightRotate(root));
                //case left right
            }
        }
        else if (diffLR<-1){
            //eln7ya elright atwal
            if (key<root.left.key){
                //right left
                root.right=rightRotate(root.right);
                return leftRotate(root);
            }
            else {
                //right right
                return leftRotate(root);

            }

        }

        //implement deletion 3dy gedan zy el binary
        //search 3la el key elmfrod ams7o bs mesh mstkhdmen methos search 3shan nback track w n update el heights
        //base case
//        if (node.height==1){
//            node=null;
//            //mesh 3rfa elmfrod a update kol el heights ely fl tree wla la
//        }



        return root;
    }
    ///////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////
    int size(avlnode n)
    {
        return this.size;
    }

    ///////////////////////////////////////////////////////////////////

}