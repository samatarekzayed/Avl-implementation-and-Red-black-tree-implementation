class Main{
    public static void main(String[] args) {

        avl tree=new avl();
        tree.insertElement(8);
        tree.insertElement(13);
        tree.insertElement(15);
        tree.insertElement(17);
        tree.insertElement(12);
        tree.insertElement(6);
        tree.insertElement(7);
        System.out.println(tree.root.right.right.height);

    }

}