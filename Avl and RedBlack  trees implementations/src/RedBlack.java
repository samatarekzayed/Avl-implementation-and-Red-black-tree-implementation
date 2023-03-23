public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
    public RBNode<type> nil=new RBNode<>();
    public int size;

    public RedBlack() {
        this.root = null;
        this.size = 0;
    }

    private RBNode<type> rightRotate(RBNode<type> n) {
        RBNode<type> temp = n.parent;
        RBNode<type> node1 = n.left;
        n.left = node1.right;

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
        RBNode<type> al15 = node2.left;

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


    private RBNode<type> handleDoubleBlack(RBNode <type> root){
        if(!getsiblings(root).isRed)
        {
            if( getsiblings(root).right.isRed==false && getsiblings(root).left.isRed==false )//case 1
            {
                getsiblings(root).isRed=true;

            }
            else if(getsiblings(root).right.isRed==true || getsiblings(root).left.isRed==true)//case 2
            {


            }



        }
        else if(getsiblings(root).isRed==true  )//case 3
        {


        }
        return root ;
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
        if(root!=null)
            return root;
        if (root.compareToKey(key)==1){
            root.left=deleteElement(root.left,key);
        }
        //key> root.key
        else if (root.compareToKey(key)==-1)
        {
            root.right=deleteElement(root.right,key);
        }
        else
        {
            if(root.left==nil && root.right==nil)//leaf
            {
                if(root.isRed==true)//red httmsa7 w wla ay
                {
                    return nil;
                }
                else //law soda yb2a el parent hn7oto double black law hwa black w law hwa red n7oto b black 3la tol
                {
                    if(root.parent.isRed)
                    {
                        root.parent.isRed=false;
                        return nil;
                    }
                    else if(!root.parent.isRed)
                    {
                        handleDoubleBlack(root);
                    }

                }
            }
            else if(root.left==nil ^ root.right==nil)//has only 1 red child
            {
                if(root.left==nil)
                {
                    root.right.isRed=false;
                    return root.right;
                }
                else
                {
                    root.left.isRed= false;
                    return root.left;
                }
            }
            else //internal node
            {
                //the node is internal
                RBNode<type> temp = inorderSucessor(root.right);
                // swap the value of this internal node with value if its inorder successor
                type t= temp.key;
                temp.key= root.key;
                root.key=t;
                root.right=deleteElement(root.right,key);
            }
        }
        return root;
    }


    @Override
    public boolean delete(type k) {
        return false;
    }

    @Override
    public boolean search(type k) {
        RBNode<type> ptr = root;
        while(ptr != null) {
            if (ptr.compareToKey(k) == 0) {
                return true;
            } else if (ptr.compareToKey(k) == -1) {
//                System.out.println(ptr.key);
                ptr = ptr.right;
            } else {
//                System.out.println(ptr.key);
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
