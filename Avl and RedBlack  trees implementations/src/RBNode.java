public class RBNode<type> implements Comparable<RBNode<type>>{

    public type key;
    public avlNode<type> parent;
    public avlNode<type> left;
    public avlNode<type> right;
    public int height;
    public boolean isRed;


    RBNode(type key){
        this.key = key;
        this.isRed = true;
    }

    @Override
    public int compareTo(RBNode<type> o) {
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

    public int compareToKey(type o) {
        int compare;
        if (o instanceof String && this.key instanceof String) {
            if (((String) this.key).compareTo((String) o) == 0) {
                return 0;
            } else if (((String) this.key).compareTo((String) o) > 0) {
                return 1;
            } else {
                return -1;
            }
        }
        else if (o instanceof Integer && this.key instanceof Integer) {
            compare = Integer.compare((Integer) this.key, (Integer) o);
            return compare;
        }
        else if (o instanceof Double && this.key instanceof Double) {
            compare = Double.compare((Double) this.key, (Double) o);
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

    public avlNode<type> getParent() {
        return parent;
    }

    public void setParent(avlNode<type> parent) {
        this.parent = parent;
    }

    public avlNode<type> getLeft() {
        return left;
    }

    public void setLeft(avlNode<type> left) {
        this.left = left;
    }

    public avlNode<type> getRight() {
        return right;
    }

    public void setRight(avlNode<type> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }


}
