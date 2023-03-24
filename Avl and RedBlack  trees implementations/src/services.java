public class services <type>{
    void preorder(avlNode<type> n) {
        if (n != null) {
            System.out.print(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    void preorder(RBNode<type> n) {
        if (n != null) {
            System.out.print(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    ///////////////////////////////////////////////////
    void postorder(avlNode<type> n)
    {
        if (n == null)
            return;
        postorder(n.getLeft());
        postorder(n.getRight());
        System.out.print(n.getKey() + " ");
    }

    ///////////////////////////////////////////////////
    void inorderRec(avlNode<type> root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.print(root.getKey() + " -> ");
            inorderRec(root.getRight());
        }
    }

    ////////////////////////////////////////////////////
    static final int COUNT = 10;
    public void print2DUtil(avlNode<type> root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.getKey() + "\n");

        // Process left child
        print2DUtil(root.getLeft(), space);
    }

    // Wrapper over print2DUtil()
    public void print2D(avlNode<type> root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    public void print2DUtil(RBNode<type> root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
//        System.out.println(root.key);
        print2DUtil(root.getRight(), space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        if(root.isRed){
            System.out.print("\u001B[31m" + root.getKey()+ "\n" + "\u001B[0m");
        }
        else {
            System.out.print(root.getKey()  + "\n");
        }


        // Process left child
        print2DUtil(root.getLeft(), space);
    }


    //function to check if the red black tree is valid or not
    public boolean isValidRedBlackTree(RBNode<type> root) {

        if (root == null) {
            return true;
        }

        // Check if the root node is Red
        if (root.isRed) {
            return false;
        }


        // Check the black height of the tree
        int blackHeight = getBlackHeight(root);
        if (blackHeight == -1) {
            return false;
        }

        // Check if any red node has a red child
        if (hasRedRedChild(root)) {
            return false;
        }

        return true;
    }

    private int getBlackHeight(RBNode<type> node) {
        if (node.key == null) {
            return 0;
        }

        int leftHeight = getBlackHeight(node.left);
        int rightHeight = getBlackHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || leftHeight != rightHeight) {
            return -1;
        }

        return leftHeight + ((!node.isRed) ? 1 : 0);
    }

    private boolean hasRedRedChild(RBNode<type> node) {
        if (node.key == null) {
            return false;
        }

        if (node.isRed) {
            if (node.left.key != null && node.left.isRed) {
                return true;
            }
            if (node.right.key != null && node.right.isRed) {
                return true;
            }
        }

        return hasRedRedChild(node.left) || hasRedRedChild(node.right);
    }



}