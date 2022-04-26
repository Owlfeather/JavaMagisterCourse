package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;



public class CharNumber {
    public static void main(String[] args) {
        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab7\\src\\task2\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<Character, Integer> dictionary = new HashMap<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replace("  ", " ");
            line = line.replace("\n", "");
            line = line.toLowerCase(Locale.ROOT);
            char[] chars = line.toCharArray();

            for (char ch: chars) {
                if('а' <= ch && 'я' >= ch) {
                    if (dictionary.containsKey(ch)) {
                        dictionary.put(ch, dictionary.get(ch) + 1);
                    } else {
                        dictionary.put(ch, 1);
                    }
                }
            }
        }

        Comparator<Map.Entry<Character, Integer>> valueComparator = new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return (v2 - v1);
            }
        };

        Set<Map.Entry<Character, Integer>> entries = dictionary.entrySet();
        List<Map.Entry<Character, Integer>> listOfEntries = new ArrayList<Map.Entry<Character, Integer>>(entries);
        Collections.sort(listOfEntries, valueComparator);


        System.out.println("Input number of letters: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(listOfEntries.get(i));

        }
    }
}
