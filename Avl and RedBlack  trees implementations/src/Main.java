import java.util.Scanner;

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
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        avl_dictionary dictionary1 = new avl_dictionary();
        redblack_dictionary dictionary2 = new redblack_dictionary();
        System.out.println("Please choose an your preferred type of dictionary");
        System.out.println("1- AVL based Dictionary");
        System.out.println("2- Red Black based Dictionary");
        String option = sc.next();
        while (flag){



            System.out.println("\nPlease choose an option: ");
            System.out.print("1- Insert a word\n2- Delete a word\n3- Search for a word\n4- Batch Insert\n5- Batch Delete\n6- Get a sorted list of words (preorder)\n7- Get dictionary size\n8- Get tree Height\n");
            String option_menu2 = sc.next();
            switch (option_menu2){
                case"1":
                    System.out.print("Enter a word to be inserted");
                    String inserted_word = sc.next();
                    if(option == "1"){
                        if(dictionary1.insert(inserted_word)){
                            System.out.println("Word inserted Successfully\n");
                        }

                        else
                                System.out.println("Word already exist\n");


                    }
                    else {
                        if (dictionary2.insert(inserted_word)) {
                            System.out.println("Word inserted Successfully");
                        } else
                            System.out.println("Word already exist");
                    }

                    break;
                case"2":
                    System.out.print("Enter a word to be deleted");
                    String deleted_word = sc.next();
                    if(option == "1"){
                        if(dictionary1.delete(deleted_word)){
                            System.out.print("Word Successfully deleted");
                        }
                        else
                            System.out.print("Word not found");
                    }
                    else {
                        if (dictionary2.delete(deleted_word)) {
                            System.out.print("Word Successfully deleted");
                        } else
                            System.out.print("Word not found");
                    }
                    break;

            }




        }
 //tree.preorder(tree.root);
    }

}
