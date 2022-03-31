package task1;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class SumSetElements {

    public static void main(String[] args) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5, 10);
        for (int i = 0; i < length; i++) {
            set.add(random.nextInt(5, 10));
        }

        System.out.println(set);
        Iterator<Integer> it = set.iterator();

        boolean iteration_done = false, global_done = false;
        int first, second;
        LinkedHashSet<Integer> new_set = new LinkedHashSet<>();

        while (!global_done) {
            new_set.clear();
            iteration_done = false;
            while (!iteration_done) {
                if (it.hasNext()) {
                    first = it.next();
                    if (it.hasNext()) {
                        second = it.next();
                        new_set.add(first + second);
                    } else {
                        new_set.add(first);
                        iteration_done = true;
                    }
                } else {
                    iteration_done = true;
                }
            }
            set = new LinkedHashSet<>(new_set);
            it = set.iterator();
            System.out.println(set);
            if(set.size() == 1) global_done = true;
        }

    }
}
