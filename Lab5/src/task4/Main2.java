package task4;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task4\\Java_program.java");

        File out_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab5\\src\\task4\\Java_program_result.java");

        out_file.delete();

        try {
            out_file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path out_file_path = Path.of(out_file.getPath());

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            //line = line.replaceAll("\\pP", " ");
            String[] words = line.split("[)!(;\\ #.,:\"]");

            for(String word : words){
                if (word.length() > 2) {
                    String word_upper = word.toUpperCase(Locale.ROOT);
                    line = line.replace(word, word_upper);
                };
            }

            try {
                Files.write(out_file_path, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
