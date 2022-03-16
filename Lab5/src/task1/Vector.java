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
        try {
            int sumOfMuls = 0;
            int dimention = this.dimension > other.dimension ? this.dimension : other.dimension;
            for (int i = 0; i < dimention; i++) {
                sumOfMuls += this.vector.get(i) * other.vector.get(i);
            }
            System.out.println("Scalar product of vectors: " + sumOfMuls);
            return sumOfMuls;
        } catch (Exception e) {
            System.out.println("scalarProduct exception : Different dimensions!");
            return -1;
        }
    }

    public Vector vectorSummation(Vector other){
        try {
            int dimention = this.dimension > other.dimension ? this.dimension : other.dimension;
            Vector temp = new Vector();
            for (int i = 0; i < dimention; i++) {
                temp.addElement(this.vector.get(i) + other.vector.get(i));
            }
            System.out.println("Summation of vectors: " + temp);
            return temp;
        } catch (Exception e) {
            System.out.println("vectorSummation exception : Different dimensions!");
            return new Vector();
        }

    }

    public Vector vectorSubtraction(Vector other) {
        try {
            int dimention = this.dimension > other.dimension ? this.dimension : other.dimension;
            Vector temp = new Vector();
            for (int i = 0; i < dimention; i++) {
                temp.addElement(this.vector.get(i) - other.vector.get(i));
            }
            System.out.println("Subtraction of vectors: " + temp);
            return temp;
        } catch (Exception e) {
            System.out.println("vectorSubtraction exception : Different dimensions!");
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
        try {
            ArrayList<Float> tempArray = new ArrayList<Float>();
            int dimention = this.dimension > other.dimension ? this.dimension : other.dimension;
            for (int i = 0; i < dimention; i++) {
                if (this.vector.get(i) == 0) {
                    if (other.vector.get(i) == 0) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    try {
                        tempArray.add((float) this.vector.get(i) / other.vector.get(i));
                    } catch (Exception e) {
                        System.out.println("isCollinear exception : Division by zero!");
                    }
                }
            }
            boolean isCollinear = true;
            for (int i = 0; i < tempArray.size() - 1; i++) {
                if (!Objects.equals(tempArray.get(i), tempArray.get(i + 1))) {
                    isCollinear = false;
                    return isCollinear;
                }
            }
            return isCollinear;
        } catch (Exception e) {
            System.out.println("isCollinear exception : Different dimensions!");
            return false;
        }
    }

    public boolean isOrthogonal(Vector other){
        try {
            if (scalarProduct(other) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("isOrthogonal exception : Different dimensions!");
            return false;
        }
    }

    public void defineVectorsStatus(Vector other){
        try {
            if (this.isCollinear(other)) {
                System.out.println("Vectors are collinear");
            } else if (this.isOrthogonal(other)) {
                System.out.println("Vectors are orthogonal");
            } else {
                System.out.println("Vectors are neither orthogonal nor collinear");
            }
        } catch (Exception e) {
            System.out.println("defineVectorsStatus exception : Different dimensions!");
        }
    }
}
