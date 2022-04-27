package task2;

import java.util.Arrays;
import java.util.Collection;

public class DeleteFirstCharReturnNums {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.println("Collection: ");
        System.out.println(collection);

        int[] int_array = collection.stream().mapToInt((s) -> Integer.parseInt(s.substring(1))).toArray();
        System.out.println("New collection: ");
        System.out.println(Arrays.toString(int_array));
    }
}
