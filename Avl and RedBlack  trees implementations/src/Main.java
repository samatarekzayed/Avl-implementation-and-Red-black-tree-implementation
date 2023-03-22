import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class Main{
    public static void main(String[] args) throws InterruptedException {
//   avl tree=new avl();
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
            System.out.print("1- Insert a word\n2- Delete a word\n3- Search for a word\n4- Batch Insert\n5- Batch Delete\n6- Get a sorted list of words\n7- Get dictionary size\n8- Get tree Height\n9-exit\n");
            String option_menu2 = sc.next();
            switch (option_menu2) {
                case "1" -> {
                    System.out.print("Enter a word to be inserted");
                    String inserted_word = sc.next();
                    if (option.equals("1")) {
                        if (dictionary1.insert(inserted_word)) {
                            System.out.println("Word inserted Successfully\n");
                        } else
                            System.out.println("Word already exist\n");


                    } else {
                        if (dictionary2.insert(inserted_word)) {
                            System.out.println("Word inserted Successfully");
                        } else
                            System.out.println("Word already exist");
                    }
                }
                case "2" -> {
                    System.out.print("Enter a word to be deleted: ");
                    String deleted_word = sc.next();
                    if (option.equals("1")) {
                        if (dictionary1.delete(deleted_word)) {
                            System.out.print("Word Successfully deleted");
                        } else
                            System.out.print("Word not found");
                    } else {
                        if (dictionary2.delete(deleted_word)) {
                            System.out.print("Word Successfully deleted");
                        } else
                            System.out.print("Word not found");
                    }
                }
                case "3" ->{
                    System.out.print("Enter a word to search for it: ");
                    String searched = sc.next();
                    if(option.equals("1")) {
                        if (dictionary1.search(searched)) {
                            System.out.print("the word \"" + searched + "\" is found");
                        } else
                            System.out.print("the word \"" + searched + "\" is not found");
                    } else {
                        if(dictionary2.search(searched)){
                            System.out.print("the word \"" + searched + "\" is found");
                        } else
                            System.out.print("the word \"" + searched + "\" is not found");

                    }
                }
                case "4" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
                    if (option.equals("1")) {
                        long start = System.currentTimeMillis();
                        int[] counters = dictionary1.batchInsert(path);
                        long end = System.currentTimeMillis();
                        System.out.println(counters[0] + " words inserted " + counters[1] + " words already existed ");
                        System.out.println("Time taken to insert to avl-based dictionary " + (counters[0] + counters[1]) + " words = " + (end - start) + " ms");
                    } else {
                        long start = System.currentTimeMillis();
                        int[] counters = dictionary2.batchInsert(path);
                        long end = System.currentTimeMillis();
                        System.out.println(counters[0] + " words inserted " + counters[1] + " words already existed ");
                        System.out.println("Time taken to insert to red-black based dictionary = " + (end - start) + " ms");
                    }
                }
                case "5" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
                    if (option.equals("1")) {
                        long start = System.currentTimeMillis();
                        int[] counters = dictionary1.batchDelete(path);
                        long end = System.currentTimeMillis();
                        System.out.print(counters[0] + " words deleted " + counters[1] + " words not found in dictionary\n");
                        System.out.println("Time taken to delete from avl-based dictionary "+(end-start)+" ms");

                    } else {
                        long start = System.currentTimeMillis();
                        int[] counters = dictionary2.batchDelete(path);
                        long end = System.currentTimeMillis();
                        System.out.print(counters[0] + " words deleted " + counters[1] + " words not found in dictionary\n");
                        System.out.println("Time taken to delete from red-black based dictionary"+(end-start)+" ms");

                    }
                }
                case "6" ->{
                    dictionary1.Orderlist();
                }
                case "7" ->{
                    System.out.print("Dictionary contains: "+dictionary1.size()+" words");

                }
                case "8" ->{
                    System.out.print("Height of the tree structuring the dictionary is "+dictionary1.treeHeight());
                }
                case "9" ->{
                    flag = false;

                }
            }




        }
 //tree.preorder(tree.root);
        System.out.print("Closing Dictionary");
        int i = 10;
        while(i>=0){
            System.out.print(".");
            i=i-1;
            TimeUnit.MILLISECONDS.sleep(500);
        }
    return;}

}
