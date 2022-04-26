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

public class LettersToNumbers {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\text.txt");
        Path out_file_path = Paths.get("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\text_with_letter_numbers.txt");
        File out_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task1\\text_with_letter_numbers.txt");

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

        String line_with_letters;
        String line_with_numbers;

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char[] letters = line.toCharArray();

            line_with_letters = "";
            line_with_numbers = "";
            String space = "";

            for (int i = 0; i < letters.length; i++) {
                if(letters[i] >= 'а' && letters[i] <= 'я') {
                    line_with_letters += (letters[i] + "  ");
                    space = ((letters[i] - 'а' + 1) < 10) ? "  " : " ";
                    line_with_numbers += (letters[i] - 'а' + 1) + space;
                } else if(letters[i] >= 'А' && letters[i] <= 'Я') {
                    line_with_letters += (letters[i] + "  ");
                    space = (letters[i] - 'А' + 1) < 10 ? "  " : " ";
                    line_with_numbers += (letters[i] - 'А' + 1) + space;
                } else {
                    line_with_letters += letters[i] + " ";
                    line_with_numbers += "  ";
                }
            }

            try {
                Files.write(out_file_path, Collections.singleton(line_with_letters), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                Files.write(out_file_path, Collections.singleton(line_with_numbers), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
