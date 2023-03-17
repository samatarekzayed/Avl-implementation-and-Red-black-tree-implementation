public class AvlNode<type> implements Comparable<AvlNode<type>>{
    private type key;
    private AvlNode<type> left;
    private AvlNode<type> right;

    AvlNode(type k1){
        key = k1;
    }

    public boolean isRightChild() {
        return isRightChild;
    }

    public void setIsRightChild(boolean rightChild) {
        isRightChild = rightChild;
    }

    private boolean isRightChild;


    //when you want to compare two nodes call the function compareTo(node);
    @Override
    public int compareTo(AvlNode<type> o) {
        int compare;
        if (o.key instanceof String && this.key instanceof String) {
            if (((String) this.key).compareTo((String) o.key) == 0) {
                return 0;
            } else if (((String) this.key).compareTo((String) o.key) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
        else if (o.key instanceof Integer && this.key instanceof Integer) {
            compare = Integer.compare((Integer) this.key, (Integer) o.key);
            return compare;
        }
        else if (o.key instanceof Double && this.key instanceof Double) {
            compare = Double.compare((Double) this.key, (Double) o.key);
            return compare;
        }
        return 0; // return any other value as per your requirement
    }

    public type getKey() {
        return key;
    }

    public void setKey(type key) {
        this.key = key;
    }

    public AvlNode<type> getLeft() {
        return left;
    }

    public void setLeft(AvlNode<type> left) {
        this.left = left;
    }

    public AvlNode<type> getRight() {
        return right;
    }

    public void setRight(AvlNode<type> right) {
        this.right = right;
    }
}
