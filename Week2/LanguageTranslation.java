package Week2;

import java.io.File;
import java.util.Scanner;

public class LanguageTranslation {
    public static void main(String[] args) {
        boolean flagFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a language: ");
        sc.close();
        String lang = sc.nextLine();
        try {
            File obj = new File("C:\\Users\\crist\\Desktop\\UEF\\JAVA\\Week2\\dictionary.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String langFile = line.split(",")[1];
                // System.out.print("FILE: "+langFile);
                if (lang.equalsIgnoreCase(langFile)) {
                    System.out.println("Given language: " + lang.toLowerCase());
                    System.out.println("Answer: " + line.split(",")[0]);
                    flagFound = true;
                    break;
                }
            }
            if (!flagFound) {
                System.out.println("Not Found!");
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("An error has ocurred.");
            e.printStackTrace();
        }
    }
}
