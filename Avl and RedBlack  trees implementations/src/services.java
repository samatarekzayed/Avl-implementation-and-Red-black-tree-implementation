public class services {
    void preorder(avlnode n) {
        if (n != null) {
            System.out.print(n.key + " ");
            preorder(n.left);
            preorder(n.right);
        }
    }
    ///////////////////////////////////////////////////
    void postorder(avlnode n)
    {
        if (n == null)
            return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.key + " ");
    }
    ///////////////////////////////////////////////////

    ////////////////////////////////////////////////////


}
