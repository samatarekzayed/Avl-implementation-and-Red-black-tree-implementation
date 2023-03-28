public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
    private RBNode<type> nil=new RBNode<>();
    public int size;
    private int whichCase=0;
    public RedBlack() {
        this.root = null;
        this.size = 0;
    }

    private RBNode<type> rightRotate(RBNode<type> n) {
//        System.out.println("right rotate " + n.key + "is right child ? " + n.isRightChild);
//        services<type> services = new services<>();
//        services.print2DUtil(this.root,0);
        RBNode<type> temp = n.parent;
        RBNode<type> node1 = n.left;
        n.left= node1.right;

        if(node1.right != this.nil) {
            node1.right.parent = n;
            n.left.isRightChild = false;
        }
        node1.right = n;
        n.parent = node1;
        n.isRightChild = true;


        if(temp != null){
            if(temp.left == n){
                temp.left = node1;
                node1.isRightChild = false;
                node1.parent = temp;
            }
            else{
                temp.right = node1;
                node1.isRightChild = true;
                node1.parent = temp;
            }
        }
        else {
            node1.parent = null;
        }
//        System.out.println(node1.isRightChild + " " + node1.key);
//        System.out.println("/////////////////////////////////////////////////////////////");

        return node1;
    }

    private RBNode<type> leftRotate(RBNode<type> n) {
//        System.out.println("ana b3ml left rotateeee" + n.key);
//        System.out.println(n.key);
        RBNode<type> temp = n.parent;
//        System.out.println(temp.key);
        RBNode<type> node2 = n.right;
        //RBNode<type> al15 = node2.left;

        n.right = node2.left;



        if(node2.left != this.nil) {
            node2.left.isRightChild = true;
            node2.left.parent = n;
        }

        node2.left = n;
        n.parent = node2;
        n.isRightChild = false;

//        if(al15 != null) {
//            System.out.println(al15.key);
//            if (al15.right != null)
//                System.out.println(al15.right.key);
//        }

        if(temp != null){
            if(temp.left == n){
//                System.out.println("if");
                temp.left = node2;
                node2.parent = temp;
                node2.isRightChild = false;
            }
            else{
//                System.out.println("else");
                temp.right = node2;
                node2.parent = temp;
                node2.isRightChild = true;
            }
        }
        else{
            node2.parent = null;
        }

        return node2;
    }

    private boolean handleInsert(RBNode<type> newNode,RBNode<type> root){
        RBNode<type> parent = newNode.parent;
        if(parent!=null && parent.parent!=null){
            RBNode<type> gedo = parent.parent;
            RBNode<type> amo;
            if(parent.isRightChild){
                amo = gedo.left;
            }
            else {
                amo = gedo.right;
            }
            if(amo==this.nil || !amo.isRed()){
                //3mo eswed hn3ml rotate
                if(newNode.isRightChild && parent.isRightChild){
                    //hn3ml left rotate
//                    System.out.println(newNode.key + " b3ml left rotate " + parent.key);
                    parent = leftRotate(gedo);
//                    System.out.println(parent.key);
                    parent.isRed = false;
                    parent.left.isRed = true;
                    parent.right.isRed = true;
                }
                else if (!newNode.isRightChild && !parent.isRightChild) {
                    //hn3ml right rotate
                    parent = rightRotate(gedo);
                    parent.isRed = false;
                    parent.left.isRed = true;
                    parent.right.isRed = true;
                }
                else if(newNode.isRightChild && !parent.isRightChild){
                    //left right rotate
                    parent = leftRotate(parent);
                    gedo = parent.parent;
                    parent = rightRotate(gedo);
                    parent.isRed = false;
                    parent.left.isRed = true;
                    parent.right.isRed = true;
                }
                else {
                    //right left rotate
                    parent = rightRotate(parent);
                    gedo = parent.parent;

                    parent = leftRotate(gedo);
                    parent.isRed = false;
                    parent.left.isRed = true;
                    parent.right.isRed = true;
                }
                if(gedo==root)
                    this.root = parent;
                return true;
            }
            else{
                //3mo a7mar hn3ml colour flip
                gedo.isRed = true;
                amo.isRed = false;
                parent.isRed = false;
                //al mafrod n3ml check l7d al root b2a
//                System.out.println("//////////////////////////////////////////////////////////////////////");
//                services<type> services = new services<>();
//                services.print2DUtil(this.root,0);
//                System.out.println("//////////////////////////////////////////////////////////////////////");
                newNode = gedo;
                parent = newNode.parent;

                if(newNode!=null && parent!=null){
                    if(newNode.isRed && parent.isRed){
                        //handle again
//                        System.out.println("handle again " + newNode.key + " " + newNode.parent.key);
                        handleInsert(newNode,root);
                    }
                }

                return true;
            }

        }
        else{
            //m3ndo4 parent aw gedo yeb2a m4 hn3ml 7aga
            return true;
        }
    }


    @Override
    public boolean insert(type k) {
//        services<type> service = new services();
//        System.out.println(service.isValidRedBlackTree(this.root));
        //System.out.println(size);
        RBNode<type> newNode = new RBNode<type>(k);
        newNode.left = this.nil;
        newNode.right = this.nil;
        if(this.size==0){
            newNode.isRed = false;
            newNode.isRightChild = false;
            this.root = newNode;
            this.size++;
            return true;
        }

        else {
            RBNode<type> ptr1 = this.root;
            RBNode<type> parent = ptr1;
            while (ptr1 != this.nil) {
                parent = ptr1;
                if (newNode.compareTo(ptr1) == 1) {
                    ptr1 = ptr1.right;
                    newNode.isRightChild = true;
                } else if (newNode.compareTo(ptr1) == -1) {
                    ptr1 = ptr1.left;
                    newNode.isRightChild = false;
                } else {
                    return false;
                }
            }

            //al child et7at w f mkano al monasb w lono a7mar
            if (newNode.isRightChild) {
                parent.right = newNode;
                newNode.parent = parent;
            } else {
                parent.left = newNode;
                newNode.parent = parent;
            }
            this.size++;
//            System.out.println("//////////////////////////////////////////////////////////////////////");
//            services<type> services = new services<>();
//            services.print2DUtil(this.root,0);


            //start handle
            if(parent.isRed)
                handleInsert(newNode,this.root);
            this.root.isRed = false;
            return true;
        }
    }
    private void handleDoubleBlack(RBNode <type> node){

        if (node == root) {
            //double black is just removed
            node.isRed=false;
            return;
        }

        RBNode<type> sibling = getsiblings(node);

        // Case 3: Red sibling
        if (sibling.isRed) {
            sibling.isRed = false;
            node.parent.isRed = true;

            // ... and rotate
            if (node == node.parent.left) {
                rotateLeft(node.parent);
            } else {
                rotateRight(node.parent);
            }
            sibling = getsiblings(node); // Get new sibling for fall-through to cases 3-6
        }

        // Cases 1: Black sibling with two black children
        if (!sibling.left.isRed && !sibling.right.isRed) {
            sibling.isRed =true;

            // if parent is red => black
            if (node.parent.isRed) {
                node.parent.isRed = false;
            }

            // if parent is black => double black
            else {
                handleDoubleBlack(node.parent);
            }
        }

        // Case 2: Black sibling with at least one red child
        else {
            handleCaseTwo(node, sibling);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void handleCaseTwo(RBNode<type> node, RBNode<type> sibling) { //black sibling with at least one red child
        boolean nodeIsLeftChild = node == node.parent.left;


        if (nodeIsLeftChild && !sibling.right.isRed) {
            //case LL
            sibling.left.isRed = false;
            sibling.isRed = true;
            rotateRight(sibling);
            sibling = node.parent.right;

        } else if (!nodeIsLeftChild && !sibling.left.isRed) {
            //case RL
            sibling.right.isRed = false;
            sibling.isRed = true;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }


        sibling.isRed = node.parent.isRed;
        node.parent.isRed= false;
        if (nodeIsLeftChild) {
            sibling.right.isRed = false;
            rotateLeft(node.parent);
        } else {
            sibling.left.isRed = false;
            rotateRight(node.parent);
        }
    }
    private RBNode<type> inorderPredecessor(RBNode<type> n){
        while (n.right!=nil){
            n=n.right;
        }
        return n;
    }
    private RBNode<type> searchNode(type k) {
        RBNode<type> ptr = root;
        while(ptr != null && ptr!=nil) {
            if (ptr.compareToKey(k) == 0) {
                return ptr;
            } else if (ptr.compareToKey(k) == -1) {

                ptr = ptr.right;
            } else {

                ptr = ptr.left;
            }
        }
        return null;
    }

    private RBNode <type> getsiblings(RBNode <type> root){
        if(root.parent.right!=root)
            return root.parent.right;
        else
            return root.parent.left;
    }
    private void rotateLeft(RBNode<type> node) {
        RBNode<type> parent = node.parent;
        RBNode<type> rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.left = node;
        node.parent = rightChild;

        setNewChild(parent, node, rightChild);
    }
    //////////////////////////////////////////////////////////////////////
    private void rotateRight(RBNode<type> node) {
        RBNode<type> parent = node.parent;
        RBNode<type> leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        setNewChild(parent, node, leftChild);
    }
    private void setNewChild(RBNode<type> parent, RBNode<type> oldChild, RBNode<type> newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        }
        if (newChild != null) {
            newChild.parent = parent;
        }
    }
    @Override
    public boolean  delete(type key) {
//        System.out.println(key);
//        services s=new services();
//        s.print2DUtil(this.root,0);
        RBNode<type> root = searchNode(key);
        if (root==null){
            //node not found
            return false;
        }
        else {
            size--;
        }
        if (root.parent==null && root.right==nil && root.left==nil){

            this.root=null;
            return true;
        }
        if(root.left!=nil && root.right!=nil)
        {
            //the node is internal
            RBNode<type> temp = inorderPredecessor(root.left);
            // swap the value of this internal node with value if its inorder successor
            type t= temp.key;
            temp.key= root.key;
            root.key=t;
            root=temp;
        }

        if(root.left==nil && root.right==nil)//leaf
        {
            if(root.isRed)//just delete the red node
            {
                setNewChild(root.parent,root,nil);

            }
            else //law soda yb2a el  double black law hwa black w law hwa red n7oto b black 3la tol
            {
                RBNode<type> doubleBlack=new RBNode<>();
                doubleBlack.parent=root.parent; //node to handle double black (this node is deleted after handling and its parent will point to the nil
                setNewChild(root.parent,root,doubleBlack);
                handleDoubleBlack(doubleBlack);
                setNewChild(doubleBlack.parent,doubleBlack,nil);

            }
        }
        else if(root.left==nil ^ root.right==nil)//has only 1 red child easyyyyy caseeeeee
        {

            if(root.left==nil) //right child
            {
                root.right.isRed=false;
                if (root.parent==null){ //if node is root
                    this.root=root.right;
                    this.root.parent=null;
                }
                else {
                    setNewChild(root.parent,root,root.right);
                }

                root.right.parent=root.parent;
            }
            else // left child
            {
                root.left.isRed= false;
                if (root.parent==null){ //if node is root
                    this.root=root.left;
                    this.root.parent=null;
                }
                else {
                    setNewChild(root.parent,root,root.left);
                }
                root.left.parent=root.parent;
            }
        }
        return true;

    }

    @Override
    public boolean search(type k) {
        return (searchNode(k)!=null);

    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public int height() {
        if(this.root!=null)
            return (Math.max(height(this.root.left),height(this.root.right)) + 1);
        else
            return -1;
    }
    private int height(RBNode<type> n) {
        if (n == nil)
            return -1;
        return (Math.max(height(n.left),height(n.right)) + 1);
    }

}

