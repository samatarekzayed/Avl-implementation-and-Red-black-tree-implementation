public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
    public RBNode<type> nil=new RBNode<>();
    public int size;

    public RedBlack() {
        this.root = null;
        this.size = 0;
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
        else{
            RBNode<type> ptr1 = this.root;
            RBNode<type> parent = ptr1;
            while(ptr1 != null){
                parent = ptr1;
                if(newNode.compareTo(ptr1)==1){
                    ptr1 = ptr1.right;
                    newNode.isRightChild = true;
                }
                else if (newNode.compareTo(ptr1)==-1) {
                    ptr1 = ptr1.left;
                    newNode.isRightChild = false;
                }
                else{
                    return false;
                }
            }

            //al child et7at w f mkano al monasb w lono a7mar
            if(newNode.isRightChild){
                parent.right = newNode;
                newNode.parent = parent;
            }
            else {
                parent.left = newNode;
                newNode.parent = parent;
            }
            this.size++;

            if(parent!=null && parent.parent!=null){
                RBNode<type> gedo = parent.parent;
                RBNode<type> amo;
                if(parent.isRightChild){
                    //yeb2a 3mha left
                    amo = gedo.left;
                }
                else{
                    //yeb2a 3mha right
                    amo = gedo.right;
                }

                if(amo==null || !amo.isRed()){
                    //3mo eswed hn3ml rotate
                    if(newNode.isRightChild && parent.isRightChild){
                        //hn3ml left rotate
                    }
                    else if (!newNode.isRightChild && !parent.isRightChild) {
                        //hn3ml right rotate
                    }
                    else if(newNode.isRightChild && !parent.isRightChild){
                        //left right rotate
                    }
                    else {
                        //right left rotate
                    }
                }
                else{
                    //3mo a7mar hn3ml colour flip
                    gedo.isRed = true;
                    amo.isRed = false;
                    parent.isRed = false;
                    //al mafrod n3ml check l7d al root b2a
                }




            }
            else{
                //m3ndo4 parent aw gedo yeb2a m4 hn3ml 7aga
                return true;
            }

        }


        return false;
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
    private int height(RBNode<type> n) {
        if (n == null)
            return -1;
        return n.height;
    }

}
