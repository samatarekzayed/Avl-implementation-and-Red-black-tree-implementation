import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class redblack_dictionary implements IDictionary{

        RedBlack<String> dictionary = new RedBlack<>();


    @Override
    public boolean insert(String word) {
        if(!search(word)) {
            dictionary.insert(word);
            return true;
        }
        else
            return false;
    }
    @Override
    public boolean delete(String k) {
        if(search(k)){
            dictionary.delete(k);
        }
        return false;
    }

    @Override
    public boolean search(String k) {
        return dictionary.search(k);
    }

    @Override
    public int[] batchInsert(String path) {
        int[] counters = {0,0};
        int insert_count=0;
        int exist_count=0;
        try{

            File myfile = new File(path);
            Scanner myReader = new Scanner(myfile);
            while(myReader.hasNextLine()){
                String word = myReader.nextLine();
                boolean inserted = dictionary.insert(word);
                if(inserted){
                    insert_count = insert_count+1;
                }
                else
                    exist_count = exist_count+1;
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        counters[0] = insert_count;
        counters[1] = exist_count;
        return counters;
    }

    @Override
    public int[] batchDelete(String path) {
        int[] counters = {0,0};
        int deleted_count=0;
        int notexist_count=0;
        try{

            File myfile = new File(path);
            Scanner myReader = new Scanner(myfile);
            while(myReader.hasNextLine()){
                String word = myReader.nextLine();
                boolean deleted = dictionary.delete(word);
                if(deleted){
                    deleted_count = deleted_count+1;
                }
                else
                    notexist_count = notexist_count+1;
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        counters[0] = deleted_count;
        counters[1] = notexist_count;
        return counters;    }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public int treeHeight() {
        return dictionary.height();
    }
}