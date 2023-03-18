
class avl<type> implements Tree<type> {
     avlNode<type> root;
    private int size = 0;
    //private int height;

    avl() {
        this.root = null;
    }

    @Override
    public boolean delete(type k) {
        int prv_size=this.size;
        this.root=delete(this.root,k);
        return  (prv_size!=this.size);
    }

    @Override
    public boolean search(type k) {
        avlNode<type> ptr = root;
        while(ptr != null) {
            if (ptr.compareToKey(k) == 0) {
                return true;
            } else if (ptr.compareToKey(k) == -1) {
                System.out.println(ptr.key);
                ptr = ptr.right;
            } else {
                System.out.println(ptr.key);
                ptr = ptr.left;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int height() {
        if(root!=null)
            return Math.max(height(root.left),height(root.left))+1;
        else
            return -1;
    }



    private int height(avlNode<type> n) {
        if (n == null)
            return -1;
        return n.height;
    }

    //////////////////////////////////////////////////////////
//    boolean isBalanced(avlNode<type> u) {
////        if (u == null)
////            return false;
//        return Math.abs(height(u.left) - height(u.right)) >= 2;
//    }
    private int balanced(avlNode<type> u) {
        if (u == null)
            return 0;
        return height(u.left) - height(u.right);
    }



    private avlNode<type> leftRotate(avlNode<type> n) {
        avlNode<type> node2 = n.right;
        n.right = node2.left;
        node2.left = n;
        n.height = Math.max( height( n.left ), height( n.right ) ) + 1;
        node2.height = Math.max( height( node2.right ), n.height ) + 1;
        return node2;
    }

//    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)
//    {
//        return Math.max(leftNodeHeight, rightNodeHeight);
//    }

    private avlNode<type> rightRotate(avlNode<type> n) {
        avlNode<type> node1 = n.left;
        n.left = node1.right;
        node1.right = n;
        n.height = Math.max( height( n.left ), height( n.right ) ) + 1;
        node1.height = Math.max( height( node1.left ), n.height ) + 1;
        return node1;
    }
    @Override
    public boolean insert(type key){
        int oSize=this.size;
        this.root=insertEllement(root,key);
        return oSize != this.size;
    }
    private avlNode<type> insertEllement(avlNode<type> root, type key) {
        if(root==null){ //reach leaf
            root = new avlNode<type>(key);
            size++;
        }
        //key > root.key
        else if (root.compareToKey(key)==-1) {
            root.right = insertEllement((root.right), key);
            if (Math.abs(balanced(root))==2) {
                //key > root.right.key
                if (root.right.compareToKey(key)==-1)
                    root=leftRotate(root);
                else {
                    root.right = rightRotate(root.right);
                    root=leftRotate(root);
                }
            }
        }
        else if (root.compareToKey(key)==1){
            root.left = insertEllement(root.left, key);
            if (Math.abs(balanced(root))==2) {
                //key < root.left.key
                if (root.left.compareToKey(key)==1)
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
    private avlNode<type> inorderSucessor(avlNode<type> n){
        while (n.left!=null){
            n=n.left;
        }
        return n;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private avlNode<type> delete(avlNode<type> root, type key){
        if (root==null){
            //tree has no nodes or element wasn't found
            return root;
        }
        //key< root.key
        if (root.compareToKey(key)==1){
            root.left=delete(root.left,key);
        }
        //key> root.key
        else if (root.compareToKey(key)==-1){
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
                avlNode<type> temp = inorderSucessor(root.right);
                // swap the value of this internal node with value if its inorder successor
                type t= temp.key;
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
//        this.root=root; //elsatr da mesh by updateeeee en el root bt3t eltree tb2a el root da m3rfshh lehhh!!!!!!!!!!!!  :(
        // f bdtar wna b test a call
        //tree.root=tree.delete(tree.root,7);
        // ba assign el retun value lel root bt3t eltree y3ny
        return root;
    }

    private int size(avlNode<type> n)
    {
        return this.size;
    }



}