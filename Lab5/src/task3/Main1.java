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
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\OriginalText_ABlock.txt");
        Path out_file_path = Paths.get("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\ModifiedText_ABlock.txt");
        File out_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task3\\ModifiedText_ABlock.txt");

        String substring = " улица, ";
        String replacement = " тротуар, ";

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
            int index = 0;
            while (index != -1) {
                index = line.indexOf(substring);
                if (index != -1){
                    line = line.replace(substring, replacement);
                }
            }
            try {
                Files.write(out_file_path, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
