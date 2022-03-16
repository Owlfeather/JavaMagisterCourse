package task3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\OriginalText_ABlock.txt");
        Path out_file_path = Paths.get("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\ModifiedText_ABlock.txt");
        File out_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\ModifiedText_ABlock.txt");

        String vowels = "аоэеиыуёюя";

        if(out_file.delete()) {
            try {
                out_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            line = line.replaceAll("\\pP", "");
            String[] words = line.split(" ");
            String out = "";
            for(String word : words){
                String first_letter = word.length() > 1 ? word.substring(0, 1) : word;
                first_letter = first_letter.toLowerCase(Locale.ROOT);
                if (vowels.contains(first_letter)) {
                    out = out.concat(word).concat(" ");
                };
            }

            try {
                Files.write(out_file_path, Collections.singleton(out), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
