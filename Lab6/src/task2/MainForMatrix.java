package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class MainForMatrix {

    public static void main(String[] args) {

        File inp_file = new File("C:\\Users\\polin\\IdeaProjects\\JavaMagisterCourse\\Lab6\\src\\task2\\matrixAB.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(inp_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean next_matrix = false;
        int row_num = 1;
        int col_num = 1;
        LinkedList<Element> CA = new LinkedList<>();
        LinkedList<Element> CB = new LinkedList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] nums = line.split(" ");
            if (nums.length < 2) {
                next_matrix = true;
                row_num = 1;
            } else {
                col_num = 1;
                for (String num : nums) {
                    if(Integer.parseInt(num) != 0) {
                        if (!next_matrix) {
                            CA.addLast(new Element(row_num, col_num, Integer.parseInt(num)));
                        } else {
                            CB.addLast(new Element(row_num, col_num, Integer.parseInt(num)));
                        }
                    }
                    col_num++;
                }
                row_num++;
            }
        }

        System.out.println(CA);
        System.out.println(CB);

        //----------------Summation

        LinkedList<Element> sum_matrix = new LinkedList<>();
        int ind_a = 0;
        int ind_b = 0;
        boolean sum_flag = true;

        while(sum_flag) {
            if((CA.get(ind_a).getRow() == CB.get(ind_b).getRow()) &&
                    (CA.get(ind_a).getCol() == CB.get(ind_b).getCol())) {
                sum_matrix.addLast(new Element(CA.get(ind_a).getRow(), CA.get(ind_a).getCol(), CA.get(ind_a).getMeaning() + CB.get(ind_b).getMeaning()));
                ind_a++;
                ind_b++;
            } else {
                if (CA.get(ind_a).getRow() == CB.get(ind_b).getRow()) {
                    if (CA.get(ind_a).getCol() > CB.get(ind_b).getCol()) {
                        sum_matrix.addLast(new Element(CB.get(ind_b).getRow(), CB.get(ind_b).getCol(), CB.get(ind_b).getMeaning()));
                        ind_b++;
                    } else {
                        sum_matrix.addLast(new Element(CA.get(ind_a).getRow(), CA.get(ind_a).getCol(), CA.get(ind_a).getMeaning()));
                        ind_a++;
                    }
                } else {
                    if (CA.get(ind_a).getRow() > CB.get(ind_b).getRow()){
                        sum_matrix.addLast(new Element(CB.get(ind_b).getRow(), CB.get(ind_b).getCol(), CB.get(ind_b).getMeaning()));
                        ind_b++;
                    } else {
                        sum_matrix.addLast(new Element(CA.get(ind_a).getRow(), CA.get(ind_a).getCol(), CA.get(ind_a).getMeaning()));
                        ind_a++;
                    }
                }
            }
            if(ind_a == CA.size()) {
                sum_flag = false;
                for (int i = ind_b; i < CB.size(); i++) {
                    sum_matrix.addLast(new Element(CB.get(i).getRow(), CB.get(i).getCol(), CB.get(i).getMeaning()));
                }
            } else if(ind_b == CB.size()){
                sum_flag = false;
                for (int i = ind_a; i < CA.size(); i++) {
                    sum_matrix.addLast(new Element(CA.get(i).getRow(), CA.get(i).getCol(), CA.get(i).getMeaning()));
                }
            }
        }

        System.out.println(sum_matrix);

        //----------------Multiplication
        // A[i, k] * B[k, j]

        LinkedList<Element> mul_matrix = new LinkedList<>();
        int answer = 0;

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                answer = 0;
                for (int k = 1; k < 4; k++) {

                    for (int l = 0; l < CA.size(); l++) {
                        if((CA.get(l).getRow() == i) && (CA.get(l).getCol() == k)){

                            for (int m = 0; m < CB.size(); m++) {
                                if(CB.get(m).getRow() == k && CB.get(m).getCol() == j){
                                    answer += CA.get(l).getMeaning() * CB.get(m).getMeaning();
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                if(answer != 0) {
                    mul_matrix.addLast(new Element(i, j, answer));
                }
            }
        }

        System.out.println(mul_matrix);
    }
}
