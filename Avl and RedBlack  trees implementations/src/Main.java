import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
class Main{

    public static void menu(String option) throws InterruptedException {
        boolean flag = true;

        while (flag){
            IDictionary dictionary;
            Scanner sc = new Scanner(System.in);
//            dictionary dictionary1 = new dictionary();
//            redblack_dictionary dictionary2 = new redblack_dictionary();
//            System.out.println("Please choose an your preferred type of dictionary");
//            System.out.println("1- AVL based Dictionary");
//            System.out.println("2- Red Black based Dictionary");
//            String option = sc.next();
            if(option.equals("1")){
                dictionary = new dictionary("avl");
            } else {
                dictionary = new dictionary("RedBlack");
            }


            System.out.println("\nPlease choose an option: ");
            System.out.print("1- Insert a word\n2- Delete a word\n3- Search for a word\n4- Batch Insert\n5- Batch Delete\n6- Get dictionary size\n7- Get tree Height\n8-exit\n");
            String option_menu2 = sc.next();
            switch (option_menu2) {
                case "1" -> {
                    System.out.print("Enter a word to be inserted");
                    String inserted_word = sc.next();
                    //if (option.equals("1")) {
                    if (dictionary.insert(inserted_word)) {
                        System.out.println("Word inserted Successfully\n");
                    } else {
                        System.out.println("Word already exist\n");


                        //} else {
                        //  if (dictionary2.insert(inserted_word)) {
                        //     System.out.println("Word inserted Successfully");
                        // } else
                        //    System.out.println("Word already exist");
                    }
                }
                case "2" -> {
                    System.out.print("Enter a word to be deleted: ");
                    String deleted_word = sc.next();
                    //if (option.equals("1")) {
                    if (dictionary.delete(deleted_word)) {
                        System.out.print("Word Successfully deleted");
                    } else
                        System.out.print("Word not found");
//                    } else {
//                        if (dictionary2.delete(deleted_word)) {
//                            System.out.print("Word Successfully deleted");
//                        } else
//                            System.out.print("Word not found");
//                    }
                }
                case "3" ->{
                    System.out.print("Enter a word to search for it: ");
                    String searched = sc.next();
                    //if(option.equals("1")) {
                    if (dictionary.search(searched)) {
                        System.out.print("the word \"" + searched + "\" is found");
                    } else
                        System.out.print("the word \"" + searched + "\" is not found");
//                    } else {
//                        if(dictionary2.search(searched)){
//                            System.out.print("the word \"" + searched + "\" is found");
//                        } else
//                            System.out.print("the word \"" + searched + "\" is not found");
//
//                    }
                }
                case "4" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
//                    if (option.equals("1")) {
                    long start = System.currentTimeMillis();
                    int[] counters = dictionary.batchInsert(path);
                    long end = System.currentTimeMillis();

                    System.out.println(counters[0] + " words inserted " + counters[1] + " words already existed ");
                    System.out.println("Time taken to insert " + (counters[0] + counters[1]) + " words = " + (end - start) + " ms");
//                    } else {
//                        long start = System.currentTimeMillis();
//                        int[] counters = dictionary2.batchInsert(path);
//                        long end = System.currentTimeMillis();
//                        System.out.println(counters[0] + " words inserted " + counters[1] + " words already existed ");
//                        System.out.println("Time taken to insert to red-black based dictionary = " + (end - start) + " ms");
//                    }
                }
                case "5" -> {
                    System.out.print("Enter a full path to txt file : ");
                    String path = sc.next();
//                    if (option.equals("1")) {
                    long start = System.currentTimeMillis();
                    int[] counters = dictionary.batchDelete(path);
                    long end = System.currentTimeMillis();
                    System.out.print(counters[0] + " words deleted " + counters[1] + " words not found in dictionary\n");
                    System.out.println("Time taken to delete from avl-based dictionary "+(end-start)+" ms");

//                    } else {
//                        long start = System.currentTimeMillis();
//                        int[] counters = dictionary2.batchDelete(path);
//                        long end = System.currentTimeMillis();
//                        System.out.print(counters[0] + " words deleted " + counters[1] + " words not found in dictionary\n");
//                        System.out.println("Time taken to delete from red-black based dictionary"+(end-start)+" ms");
//
//                    }
                }

                case "6" ->{
                    System.out.print("Dictionary contains: "+dictionary.size()+" words");

                }
                case "7" ->{
                    System.out.print("Height of the tree structuring the dictionary is "+dictionary.treeHeight());
                }
                case "8" ->{
                    flag = false;

                }
            }




        }
        //tree.preorder(tree.root);
        System.out.print("Closing Dictionary");
        int i = 10;
        while(i>=0) {
            System.out.print(".");
            i = i - 1;

            TimeUnit.MILLISECONDS.sleep(500);

        }
    }


    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose an your preferred type of dictionary");
        System.out.println("1- AVL based Dictionary");
        System.out.println("2- Red Black based Dictionary");
        String option = sc.next();

        menu(option);

    }}