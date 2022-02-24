package task3;

import java.util.ArrayList;
import java.util.Objects;

public class Array1Dim  implements Array{

    private ArrayList<Float> content;

    public Array1Dim() {
    }

    public Array1Dim(ArrayList<Float> content) {
        this.content = content;
    }

    @Override
    public void summation(Object o) {
        if(o.getClass().equals(Array1Dim.class)){
            if(this.content.size() == ((Array1Dim) o).content.size()){
                for (int i = 0; i < content.size(); i++) {
                    this.content.set(i, (this.content.get(i) + ((Array1Dim) o).content.get(i)));
                }
            } else {
                System.out.println("Arrays length mismatch!");
            }
        } else {
            System.out.println("Сlass mismatch!");
        }
    }

    @Override
    public void subtraction(Object o) {
        if(o.getClass().equals(Array1Dim.class)){
            if(this.content.size() == ((Array1Dim) o).content.size()){
                for (int i = 0; i < content.size(); i++) {
                    this.content.set(i, (this.content.get(i) - ((Array1Dim) o).content.get(i)));
                }
            } else {
                System.out.println("Arrays length mismatch!");
            }
        } else {
            System.out.println("Сlass mismatch!");
        }
    }

    @Override
    public void multiplication(Object o) {
        if(o.getClass().equals(Array1Dim.class)){
            if(this.content.size() == ((Array1Dim) o).content.size()){
                for (int i = 0; i < content.size(); i++) {
                    this.content.set(i, (this.content.get(i) * ((Array1Dim) o).content.get(i)));
                }
            } else {
                System.out.println("Arrays length mismatch!");
            }
        } else {
            System.out.println("Сlass mismatch!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array1Dim array1Dim = (Array1Dim) o;
        return Objects.equals(content, array1Dim.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Array1Dim{" +
                "content=" + content +
                '}';
    }

    public Array1Dim getClone(){
        return new Array1Dim((ArrayList)(this.content.clone()));
    }
}
