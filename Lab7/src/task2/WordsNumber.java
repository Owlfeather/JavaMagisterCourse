package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordsNumber {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task2\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> dictionary = new HashMap<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replace("  ", " ");
            line = line.replace("\n", "");
            line = line.toLowerCase(Locale.ROOT);
            String[] words = line.split("[.?!, ]");

            for (String word: words) {
                if(Pattern.matches("[а-яА-Я]+", word)) {
                    if (dictionary.containsKey(word)) {
                        dictionary.put(word, dictionary.get(word) + 1);
                    } else {
                        dictionary.put(word, 1);
                    }
                }
            }
        }

        for (String word : dictionary.keySet()) {
            System.out.println("Слово: " + word + " : " + dictionary.get(word));
        }
    }
}
