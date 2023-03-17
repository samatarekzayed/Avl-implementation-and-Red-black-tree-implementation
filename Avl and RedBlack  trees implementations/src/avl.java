//import static sun.swing.MenuItemLayoutHelper.max;

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
        return height(u.left) - height(u.right);
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
            if (Math.abs(balanced(root))==2) {
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
            if (Math.abs(balanced(root))==2) {
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    avlnode inorderSucessor(avlnode n){
        while (n.left!=null){
            n=n.left;
        }
        return n;
    }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
    avlnode delete(avlnode root, int key){
        if (root==null){
            //tree has no nodes or element wasn't found
            return root;
        }
        if (key< root.key){
            root.left=delete(root.left,key);
        }
        else if (key> root.key){
            root.right=delete(root.right,key);
        }
        else{
            // the node is found and we have three cases (leaf/one child/internal)

            if ((root.left == null) && (root.right == null)){
                // the node is a leaf node
                this.size-=1;
                return  null; //a null is assigned to the parent of the node to be deleted

            }
            else if(root.left == null){
                //the node has a right child only
                root = root.right;
                this.size-=1;
            }
            else if(root.right == null){

                //the node has a left child only
                root= root.left;
                this.size-=1;
            }
            else {
                //the node is internal
                avlnode temp = inorderSucessor(root.right);
                // swap the value of this internal node with value if its inorder successor
                int t= temp.key;
                temp.key= root.key;
                root.key=t;
                root.right=delete(root.right,key);
             }
            }
//        if (root==null){
//            return root;
//        }
        //after returning from the recursive call
        //the height is updated and the balance condition is checked

        root.height=Math.max(height(root.left), height(root.right)) + 1;

        int diffLR=balanced(root);
        if (diffLR>1){ // diffLR = height of the left subtree - height of right subtree
            //the left subtree is taller
            if (balanced(root.left)>=0){
                //case left left
                return rightRotate(root);
            }
            else if (balanced(root.left) < 0){
                //case left right
                root.left=leftRotate(root.left);
                return(rightRotate(root));
            }
        }
        else if (diffLR<-1){
            //the right subtree is taller
            if (balanced(root.right) > 0){
                //case right left
                root.right=rightRotate(root.right);
                return leftRotate(root);
            }
            else if (balanced(root.right) <= 0){
                //case right right
                return leftRotate(root);
            }
        }
        this.root=root; //elsatr da mesh by updateeeee en el root bt3t eltree tb2a el root da m3rfshh lehhh!!!!!!!!!!!!  :(
        // f bdtar wna b test a call
        //tree.root=tree.delete(tree.root,7);
        // ba assign el retun value lel root bt3t eltree y3ny
        return root;
    }

    int size(avlnode n)
    {
        return this.size;
    }

    ///////////////////////////////////////////////////////////////////

}