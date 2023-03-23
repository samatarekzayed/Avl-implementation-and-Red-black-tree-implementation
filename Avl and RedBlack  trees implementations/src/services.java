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
}