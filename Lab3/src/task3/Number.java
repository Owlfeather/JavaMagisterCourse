package task3;

import java.util.Objects;

public class Number {

    private int number;

    public Number() {
        this.number = 0;
    }

    public Number(int number) {
        this.number = number;
    }

    public Number summation(Number other){
        return new Number(this.number + other.number);
    }

    public Number subtraction(Number other){
        return new Number(this.number - other.number);
    }

    public Number multiplication(Number other){
        return new Number(this.number * other.number);
    }

    public Number division(Number other){
        return new Number(this.number / other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    public int getNumber() {
        return number;
    }
}
