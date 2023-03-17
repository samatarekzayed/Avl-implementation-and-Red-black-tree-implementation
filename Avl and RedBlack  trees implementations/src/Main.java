class Main{
    public static void main(String[] args) {

        avl tree=new avl();
        services s=new services();
        tree.insertElement(8);
        tree.insertElement(13);
        tree.insertElement(15);
        tree.insertElement(17);
        tree.insertElement(12);
        tree.insertElement(6);
        tree.insertElement(7);
        s.inorderRec(tree.root);
        System.out.println(tree.root.left.height);



    }

}