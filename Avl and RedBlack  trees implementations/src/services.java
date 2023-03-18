public class services <type>{
    void preorder(avlNode<type> n) {
        if (n != null) {
            System.out.print(n.key + " ");
            preorder(n.left);
            preorder(n.right);
        }
    }
    ///////////////////////////////////////////////////
    void postorder(avlNode<type> n)
    {
        if (n == null)
            return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.key + " ");
    }


    ///////////////////////////////////////////////////
    void inorderRec(avlNode<type> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " -> ");
            inorderRec(root.right);
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
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D(avlNode<type> root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}