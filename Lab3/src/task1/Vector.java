package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Vector {

    private ArrayList<Integer> vector;
    private int dimension;

    public Vector() {
        this.vector = new ArrayList<Integer>();
        this.dimension = 0;
    }

    public Vector(ArrayList<Integer> vector) {
        this.vector = vector;
        this.dimension = this.vector.size();
    }

    public Vector(Integer[] vector) {
        this.vector = new ArrayList<>(Arrays.asList(vector));;
        this.dimension = this.vector.size();
    }

    public void addElement(int element){
        this.vector.add(element);
        this.dimension++;
    }

    public ArrayList<Integer> getVector() {
        return vector;
    }

    public void setVector(ArrayList<Integer> vector) {
        this.vector = vector;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "vector=" + vector +
                ", dimension=" + dimension +
                '}';
    }

    public double calculateModulus(){
        int sumOfSquares = 0;
        for (Integer elem: this.vector) {
            sumOfSquares += Math.pow(elem, 2);
        }
        return Math.sqrt(sumOfSquares);
    }

    public int scalarProduct(Vector other){
        if(this.dimension == other.dimension){
            int sumOfMuls = 0;
            for (int i = 0; i < this.dimension; i++) {
                sumOfMuls += this.vector.get(i) * other.vector.get(i);
            }
            return sumOfMuls;
        } else {
            System.out.println("Different demensions of vectors!");
            return -1;
        }
    }

    public Vector vectorSummation(Vector other){
        if(this.dimension == other.dimension){
            Vector temp = new Vector();
            for (int i = 0; i < this.dimension; i++) {
                temp.addElement(this.vector.get(i) + other.vector.get(i));
            }
            return temp;
        } else {
            System.out.println("Different demensions of vectors!");
            return new Vector();
        }
    }

    public Vector vectorSubtraction(Vector other) {
        if(this.dimension == other.dimension){
            Vector temp = new Vector();
            for (int i = 0; i < this.dimension; i++) {
                temp.addElement(this.vector.get(i) - other.vector.get(i));
            }
            return temp;
        } else {
            System.out.println("Different demensions of vectors!");
            return new Vector();
        }
    }

    public Vector constantMultiplication(int k){
        Vector temp = new Vector();
        for (int i = 0; i < this.dimension; i++) {
            temp.addElement(this.vector.get(i) * k);
        }
        return temp;
    }

    public boolean isCollinear(Vector other){
        if(this.dimension == other.dimension){
            ArrayList<Float> tempArray = new ArrayList<Float>();
            for (int i = 0; i < this.dimension; i++) {
                if(this.vector.get(i) == 0){
                    if(other.vector.get(i) == 0){
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    if(other.vector.get(i) == 0){
                        return false;
                    } else {
                        tempArray.add((float)this.vector.get(i)/other.vector.get(i));
                    }
                }
            }
            boolean isCollinear = true;
            for (int i = 0; i < tempArray.size()-1; i++) {
                if (!Objects.equals(tempArray.get(i), tempArray.get(i + 1))){
                    isCollinear = false;
                    return isCollinear;
                }
            }
            return isCollinear;
        } else {
            System.out.println("Different demensions of vectors!");
            return false;
        }
    }

    public boolean isOrthogonal(Vector other){
        if(scalarProduct(other) == 0){
            return true;
        } else {
            return false;
        }
    }

    public void defineVectorsStatus(Vector other){
        if (this.isCollinear(other)){
            System.out.println("Vectors are collinear");
        } else if(this.isOrthogonal(other)){
            System.out.println("Vectors are orthogonal");
        } else {
            System.out.println("Vectors are neither orthogonal nor collinear");
        }
    }
}
