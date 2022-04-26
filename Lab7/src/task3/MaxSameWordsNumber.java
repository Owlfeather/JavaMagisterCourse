package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MaxSameWordsNumber {
    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task3\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<String, Integer> dictionary = new HashMap<>();
        String text = scanner.nextLine();
        String[] sentences = text.split("[.?!]");

        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            HashSet<String> wordsSet = new HashSet<>(Arrays.asList(words));
            for (String word :wordsSet) {
                if (dictionary.containsKey(word)) {
                    dictionary.put(word, dictionary.get(word) + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }
        }

        Set<String> keys = dictionary.keySet();
        String maxPopularWord = sentences[0].split(" ")[0];

        for ( String key : keys) {
            if(dictionary.get(maxPopularWord) < dictionary.get(key)){
                maxPopularWord = key;
            }
        }

        System.out.print("Maximal number of sentences which have same words : ");
        System.out.println(dictionary.get(maxPopularWord));
        System.out.print("Word is : ");
        System.out.println(maxPopularWord);
    }
}
