public class RedBlack<type> implements Tree<type>{

    public RBNode<type> root;
    public int size;

    public RedBlack() {
        this.root = null;
        this.size = 0;
    }


    @Override
    public boolean insert(type k) {
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
