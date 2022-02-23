package task2;

import java.util.*;

public class MainForAbiturient {

    public static void main(String[] args) {

        Abiturient[] abiturientsArray = createAbiturientsArray();
        System.out.println("Abiturients:");
        for (Abiturient a: abiturientsArray) {
            System.out.println(a);
        }
        Abiturient[] abiturientsWithNeuds = chooseWithNeuds(abiturientsArray);
        System.out.println();
        System.out.println("Abiturients with neuds:");
        for (Abiturient a: abiturientsWithNeuds) {
            System.out.println(a);
        }

        Abiturient[] abiturientsWithHigherAVG = chooseHigherAVGMark(abiturientsArray, 4f);
        System.out.println();
        System.out.println("Abiturients with average mark higher then 4:");
        for (Abiturient a: abiturientsWithHigherAVG) {
            System.out.println(a);
        }

        Abiturient[] abiturientsBestN = chooseBest(abiturientsArray, 2);
        System.out.println();
        System.out.println("Best 2 abiturients:");
        for (Abiturient a: abiturientsBestN) {
            System.out.println(a);
        }

    }

    private static Abiturient[] createAbiturientsArray(){
        Abiturient a1 = new Abiturient(1,"Ivan", "Ivanov", "Ivanovich", "House 5", "8-968-374-26-47", new ArrayList<Integer>(Arrays.asList(3, 2, 5)));
        Abiturient a2 = new Abiturient(2,"Petr", "Petrov", "Petrovich", "House 3", "8-969-375-27-74", new ArrayList<Integer>(Arrays.asList(4, 4, 5)));
        Abiturient a3 = new Abiturient(3,"Dmitry", "Smirnov", "Ivanovich", "House 9", "8-977-234-86-07", new ArrayList<Integer>(Arrays.asList(5, 4, 5)));
        Abiturient a4 = new Abiturient(4,"Ivan", "Smirnov", "Andreevich", "House 5", "8-978-306-36-43", new ArrayList<Integer>(Arrays.asList(3, 2, 4)));
        Abiturient a5 = new Abiturient(5,"Alexander", "Ivanov", "Ilich", "House 11", "8-961-333-28-17", new ArrayList<Integer>(Arrays.asList(5, 5, 5)));
        return new Abiturient[]{a1, a2, a3, a4, a5};
    }

    private static Abiturient[] chooseWithNeuds(Abiturient[] abiturientsArray){
        ArrayList<Abiturient> newAbiturientsArray = new ArrayList<>();
        for (int i = 0; i < abiturientsArray.length; i++) {
            if(abiturientsArray[i].getMarks().contains(2)){
                newAbiturientsArray.add(abiturientsArray[i]);
            }
        }
        return (Abiturient[]) newAbiturientsArray.toArray(new Abiturient[newAbiturientsArray.size()]);
    }

    private static Abiturient[] chooseHigherAVGMark(Abiturient[] abiturientsArray, float mark){
        ArrayList<Abiturient> newAbiturientsArray = new ArrayList<>();
        for (int i = 0; i < abiturientsArray.length; i++) {
            float avg = 0;
            for (Integer m :abiturientsArray[i].getMarks()) {
                avg += m;
            }
            avg = avg/abiturientsArray[i].getMarks().size();
            if(avg > mark){
                newAbiturientsArray.add(abiturientsArray[i]);
            }
        }
        return (Abiturient[]) newAbiturientsArray.toArray(new Abiturient[newAbiturientsArray.size()]);
    }

    private static Abiturient[] chooseBest(Abiturient[] abiturientsArray, Integer n){
        ArrayList<Abiturient> newAbiturientsArray = new ArrayList<>();

        SortedMap<Float, ArrayList<Abiturient>> map = new TreeMap<>();
        for (int i = 0; i < abiturientsArray.length; i++){
            float avg = 0;
            for (Integer m : abiturientsArray[i].getMarks()) {
                avg += m;
            }
            avg = avg / abiturientsArray[i].getMarks().size();

            if (map.containsKey(avg)){
                map.get(avg).add(abiturientsArray[i]);
            } else {
                map.put(avg, new ArrayList<>());
                map.get(avg).add(abiturientsArray[i]);
            }
        }
        System.out.println(map);

        int j = 0;
        int avg_num = -1;
        List<Float> floatList = new ArrayList<Float>(map.keySet());
        Collections.reverse(floatList);
        while (j < n){
            avg_num++;
            for (int i = 0; i < map.get(floatList.get(avg_num)).size(); i++) {
                newAbiturientsArray.add(map.get(floatList.get(avg_num)).get(i));
                j++;
            }
        }

        return (Abiturient[]) newAbiturientsArray.toArray(new Abiturient[newAbiturientsArray.size()]);
    }


}
