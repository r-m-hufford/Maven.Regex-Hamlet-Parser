import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }


    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changePattern(String fileToSearch, String patternToFind, String replacementText) {
        Pattern pattern = Pattern.compile(patternToFind);
        Matcher matcher = pattern.matcher(fileToSearch);
        return (matcher.replaceAll(replacementText));
    }

    public Boolean findPattern(String patternToFind, String fileToSearch) {
        Pattern pattern = Pattern.compile(patternToFind);
        Matcher matcher = pattern.matcher(fileToSearch);
        Boolean patternPresentInFile = matcher.find();
        return patternPresentInFile;
    }

    public void setHamletData(String newText) {
        this.hamletData = newText;
    }

    public void createAFile() {
        try {
            File newFFFile = new File("src/main/resources/newFFFile.txt");
            if (newFFFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    public void writeToAFile(String newHamlet) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/hamlet.txt");
            writer.write(newHamlet);
            writer.close();
            System.out.println("wrote to the file");
        } catch (IOException e){
            System.out.println("an error has occurred");
            e.printStackTrace();
        }
    }
    public void readAFile() {
        try {
            File file = new File("src/main/resources/newFFFile.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
