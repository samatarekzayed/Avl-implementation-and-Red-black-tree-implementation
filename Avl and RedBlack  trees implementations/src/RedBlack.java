public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
    public RBNode<type> nil=new RBNode<>();
    public int size;
    private int whichCase=0;
    public RedBlack() {
        this.root = null;
        this.size = 0;
    }

    private RBNode<type> rightRotate(RBNode<type> n) {
        RBNode<type> temp = n.parent;
        RBNode<type> node1 = n.left;
        n.left= node1.right;

        if(node1.right != null) {
            node1.right.parent = n;
            n.left.isRightChild = false;
        }
        node1.right = n;
        n.isRightChild = true;
        n.parent = node1;

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



        if(node2.left != null) {
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



            if(amo==null || !amo.isRed()){
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

                    parent = rightRotate(gedo);
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
        RBNode<type> newNode = new RBNode<type>(k);
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
            while (ptr1 != null) {
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




    private RBNode<type> inorderSucessor(RBNode<type> n){
        while (n.left!=nil){
            n=n.left;
        }
        return n;
    }


    RBNode <type> getsiblings(RBNode <type> root){
        if(root.parent.right!=root)
            return root.parent.right;
        else
            return root.parent.left;
    }

    public RBNode <type>  deleteElement(RBNode <type>root ,type key) {
        if (root == null)
            return root;
        if (root.compareToKey(key) == 1) {
            root.left = deleteElement(root.left, key); //search
            //case 2
            if(whichCase==2) {
                if (root.isDB && root.parent == null) {
                    root.isDB = false;
                } else if (root.isDB) {
                    RBNode<type> s = getsiblings(root);
                    if (root.isDB && !s.isRed && !s.right.isRed && !s.left.isRed) {
                        s.isRed = true;
                        if (root.parent.isRed)
                            root.parent.isRed = false;
                        else
                            root.parent.isDB = true;
                    }
                }
            }
            else if(whichCase==3) {
                //case 3
                System.out.println("case3");

                if (root.right.isRed) {
                    root.right.isRed = false;
                    root = leftRotate(root);
                    root.left.right.isRed = true;
                }
            }
            //case 4
            else if(whichCase==4){
                if(root.right.left.isRed){
                    root.right.left.isRed=false;
                    root.right.isRed=true;
                    root.right=rightRotate(root.right);
                }
                if (root.right.right.isRed){
                    root.right.right.isRed=false;
                    boolean rColor=root.isRed;
                    root.isRed=root.right.isRed;
                    root.right.isRed=rColor;
                    root=leftRotate(root);
                }
            }
            whichCase=0;
        }
        //key> root.key
        else if (root.compareToKey(key) == -1) {
            root.right = deleteElement(root.right, key); //search
            //System.out.println(root.key+" "+root.parent.key);
            //case 2
            if(whichCase==2) {
                if (root.isDB && root.parent == null) {
                    root.isDB = false;
                } else if (root.isDB) {
                    RBNode<type> s = getsiblings(root);
                    if (root.isDB && !s.isRed && !s.right.isRed && !s.left.isRed) {
                        s.isRed = true;
                        if (root.parent.isRed)
                            root.parent.isRed = false;
                        else
                            root.parent.isDB = true;
                    }
                }
            }
            //case 3
            else if(whichCase==3){
                System.out.println("case3");

                if (root.left.isRed) {
                    root.left.isRed=false;
                    //root.left.right.isRed=true;
                    root = rightRotate(root);
                    root.right.left.isRed=true;
                }
            }
            //case 4
            else if(whichCase==4){
                if(root.left.right!=null && root.left.right.isRed){
                    root.left.right.isRed=false;
                    root.left.isRed=true;
                    root.left=leftRotate(root.left);
                    System.out.println(root.left.left.key+" "+root.left.left.isRed);
                }
                if (root.left.left!=null && root.left.left.isRed){
                    root.left.left.isRed=false;
                    boolean rColor=root.isRed;
                    root.isRed=root.left.isRed;
                    root.left.isRed=rColor;
                    root=rightRotate(root);
                }
            }
            whichCase=0;
        }
        else {
            if (size == 1) {
                size--;
                return null;
            } else if (root.left == nil && root.right == nil)//leaf
            {
                if (root.isRed)//red httmsa7 w wla ay
                {
                    size--;
                    return nil;
                } else //law soda yb2a el parent hn7oto double black law hwa black w law hwa red n7oto b black 3la tol
                {
                    //case 2
                    RBNode<type> s = getsiblings(root);
                    if (!s.isRed && !s.right.isRed && !s.left.isRed) {
                        s.isRed = true;
                        if (root.parent.isRed) {
                            root.parent.isRed = false;
                        } else {
                            root.parent.isDB = true;
                        }
                        whichCase=2;
                        size--;
                        return nil;
                    }
                    //finish case 3
                    else if (s.isRed) {
                        size--;
                        whichCase=3;
                        return nil;
                    }
                    //case4
                    else {
                        size--;
                        whichCase=4;
                        return nil;
                    }
                }
            }
            else if (root.left == nil ^ root.right == nil)//has only 1 red child
            {
                if (root.left == nil) {
                    root.key=root.right.key;
                    root.right=nil;
                } else {
                    root.key=root.left.key;
                    root.left=nil;
                }
                size--;
            }
            else //internal node
            {
                //the node is internal
                RBNode<type> temp = inorderSucessor(root.right);
                // swap the value of this internal node with value if its inorder successor
                type t = temp.key;
                temp.key = root.key;
                root.key = t;
                root.right = deleteElement(root.right, key);
                if(whichCase==2){
                    System.out.println("heeeeeeeeeeeee");
                    if (root.isDB && root.parent == null) {
                        root.isDB = false;
                    } else if (root.isDB) {
                        RBNode<type> s = getsiblings(root);
                        if (root.isDB && !s.isRed && !s.right.isRed && !s.left.isRed) {
                            s.isRed = true;
                            if (root.parent.isRed)
                                root.parent.isRed = false;
                            else
                                root.parent.isDB = true;
                        }
                    }
                }
                //case 3
                if(whichCase==3) {
                    if (root.left.isRed) {
                        root.left.isRed = false;
                        root.left.right.isRed = true;
                        root = rightRotate(root);
                    }
                }
                //case 4
                if(whichCase==4) {
                    if (root.left.right.isRed) {
                        root.left.right.isRed = false;
                        root.left.isRed = true;
                        root.left = leftRotate(root.left);
                    }
                    if (root.left.left.isRed) {
                        root = rightRotate(root);
                        if (!root.isRed)
                            root.left.left.isRed = false;
                        else if (root.isRed & root.left.right.isRed) {
                            root.left.isRed = true;
                            root.isRed = false;
                            root.left.left.isRed = false;
                        }
                    }
                }
                whichCase=0;
            }
        }
        return root;
    }


    @Override
    public boolean delete(type key) {
        int size=this.size;
        this.root=deleteElement(this.root,key);
        return size!=this.size;
    }

    @Override
    public boolean search(type k) {
        RBNode<type> ptr = root;
        while(ptr != null) {
            if (ptr.compareToKey(k) == 0) {
                return true;
            } else if (ptr.compareToKey(k) == -1) {
                ptr = ptr.right;
            } else {
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
        if(this.root!=null)
            return (Math.max(height(this.root.left),height(this.root.right)) + 1);
        else
            return -1;
    }
    private int height(RBNode<type> n) {
        if (n == null)
            return -1;
        return (Math.max(height(n.left),height(n.right)) + 1);
    }

}
