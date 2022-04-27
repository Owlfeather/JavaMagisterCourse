package task1;

import java.util.Arrays;
import java.util.Collection;

public class TwoElementsFromSecond {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("first", "second", "third", "fourth");
        System.out.println("Collection: ");
        System.out.println(collection);
        Object[] first_two = collection.stream().skip(1).limit(2).toArray();
        System.out.println("First two elements (from second): ");
        System.out.println(Arrays.toString(first_two));

    }
}
