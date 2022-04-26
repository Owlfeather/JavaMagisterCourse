package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

public class WordsNumberRating {
    public static void main(String[] args) {

        HashMap<String, Integer> dictionary = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text:");
        String text = scanner.nextLine();
        text = text.toLowerCase(Locale.ROOT);
        String[] words = text.split("[.?!, «»—:;]");

        for (String word: words) {
            if(Pattern.matches("[а-яА-Я]+", word)) {
                if (dictionary.containsKey(word)) {
                    dictionary.put(word, dictionary.get(word) + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }
        }

        System.out.println("Input words:");
        String wordSetLine = scanner.nextLine();
        wordSetLine = wordSetLine.toLowerCase(Locale.ROOT);
        String[] wordAr = wordSetLine.split("[.?!, ]");

        HashMap<String, Integer> wordSet = new HashMap<>();

        for (String word : wordAr) {
            if(dictionary.containsKey(word)){
                wordSet.put(word, dictionary.get(word));
            } else {
                wordSet.put(word, 0);
            }
        }

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return (v2 - v1);
            }
        };

        Set<Map.Entry<String, Integer>> entries = wordSet.entrySet();
        List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<Map.Entry<String, Integer>>(entries);
        Collections.sort(listOfEntries, valueComparator);

        System.out.println(listOfEntries);
    }
}
