package Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class extractQuestionsFromFile {
    ArrayList<String> questionsPlainList = new ArrayList<>();

    extractQuestionsFromFile(){
        getProgrammingFromTextFile();
    }
    public ArrayList<String> getQuestionsPlainList() {
        return questionsPlainList;
    }

    public String splittingPartsOfQuestion(String line){
        return Arrays.toString(line.split(",")) ;
    }
     public void getProgrammingFromTextFile(){
        try {
            File file = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week7\\src\\main\\java\\Task4\\bankOfQuestions.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                questionsPlainList.add((data));
            }
            myReader.close();
        }
        catch (FileNotFoundException E) {
            System.out.println("The file does not exist.");
        }
    }


}
