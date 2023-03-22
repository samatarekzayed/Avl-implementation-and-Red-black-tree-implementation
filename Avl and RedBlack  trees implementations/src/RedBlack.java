public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
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
