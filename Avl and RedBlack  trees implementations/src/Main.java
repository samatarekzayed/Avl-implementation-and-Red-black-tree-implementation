class Main{
    public static void main(String[] args) {
    avl tree=new avl();
//        tree.root=   tree.insertEllement(tree.root,41);
//        tree.root=  tree.insertEllement(tree.root,38);
//        tree.root=    tree.insertEllement(tree.root,31);
//        tree.root=    tree.insertEllement(tree.root,12);
//        if(tree.search(12))
//            System.out.println("yes");
//        tree.root=  tree.insertEllement(tree.root,19);
//        tree.root=  tree.insertEllement(tree.root,8);
//        System.out.println(tree.root.key);
//        System.out.println(tree.root.left.key);
//        System.out.println(tree.root.right.key);

//        tree.root=  tree.delete(tree.root,8);
//        tree.root=  tree.delete(tree.root,38);
//        tree.root= tree.delete(tree.root,19);
//        tree.root= tree.delete(tree.root,31);

//        tree.root=   tree.insertEllement(tree.root,1);
//        tree.root=  tree.insertEllement(tree.root,100);
//        tree.root=    tree.insertEllement(tree.root,31);
//        tree.root=    tree.insertEllement(tree.root,12);
//        tree.root=  tree.insertEllement(tree.root,17);
//        tree.root=  tree.insertEllement(tree.root,6);
//        tree.root=   tree.insertEllement(tree.root,53);
//        tree.root=  tree.insertEllement(tree.root,38);
//        tree.root=    tree.insertEllement(tree.root,10);
//        tree.root=    tree.insertEllement(tree.root,2);
//        tree.root=  tree.insertEllement(tree.root,19);
//        tree.root=  tree.insertEllement(tree.root,11);
//        tree.root=  tree.insertEllement(tree.root,11);
//
//        tree.root=  tree.delete(tree.root,12);//root
//        tree.root=  tree.delete(tree.root,100);//leaf
//        tree.root=  tree.delete(tree.root,100);//not found
//        System.out.println(tree.size());
//        tree.root= tree.delete(tree.root,5);//not found
//        System.out.println(tree.size());
//        if(tree.search(17))
//           System.out.println("yes");
//        if(!(tree.search(33)))
//           System.out.println("yes");
//        if(tree.search(33))
//            System.out.println("yes");
    tree.preorder(tree.root);
    }

}
