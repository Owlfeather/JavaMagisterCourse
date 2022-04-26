package task1;

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

public class LetterCorrection {

    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\text_with_mistakes.txt");
        Path out_file_path = Paths.get("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\corrected_text.txt");
        File out_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\corrected_text.txt");

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
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll("РА", "РО");
            line = line.replaceAll("ра", "ро");
            line = line.replaceAll("Ра", "Ро");
            line = line.replaceAll("рА", "рО");

            try {
                Files.write(out_file_path, Collections.singleton(line), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
