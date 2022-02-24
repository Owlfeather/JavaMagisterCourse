package task3;

import java.util.Objects;

public class Fraction {

    private Number numerator;
    private Number denominator;

    public Fraction() {
    }

    public Fraction(Number numerator, Number denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction summation(Fraction other){
        Fraction result = new Fraction(other.denominator.multiplication(this.numerator).summation(this.denominator.multiplication(other.numerator)), this.denominator.multiplication(other.denominator));
        result.normalize();
        return result;
    }

    public Fraction subtraction(Fraction other){
        Fraction result = new Fraction(other.denominator.multiplication(this.numerator).subtraction(this.denominator.multiplication(other.numerator)), this.denominator.multiplication(other.denominator));
        result.normalize();
        return result;
    }

    public Fraction multiplication(Fraction other){

        Fraction result = new Fraction(this.numerator.multiplication(other.numerator), this.denominator.multiplication(other.denominator));
        result.normalize();
        return result;

    }

    public Fraction division(Fraction other){

        Fraction temp = new Fraction(other.denominator, other.numerator);
        Fraction result = this.multiplication(temp);
        result.normalize();
        return result;

    }

    public Number getNumerator() {
        return numerator;
    }

    public void setNumerator(Number numerator) {
        this.numerator = numerator;
    }

    public Number getDenominator() {
        return denominator;
    }

    public void setDenominator(Number denominator) {
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Objects.equals(numerator, fraction.numerator) && Objects.equals(denominator, fraction.denominator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                 numerator +
                " / " + denominator +
                '}';
    }

    private void normalize(){

        if(this.numerator.getNumber() > this.denominator.getNumber()){
            if(this.numerator.getNumber() % this.denominator.getNumber() == 0){
                this.numerator = this.numerator.division(this.denominator);
                this.denominator = new Number(1);

            } else {
                int i = 2;
                while (i <= (int) Math.sqrt(this.denominator.getNumber())) {
                    if(this.numerator.getNumber() % i == 0 && this.denominator.getNumber() % i == 0){
                        this.numerator = this.numerator.division(new Number(i));
                        this.denominator = this.denominator.division(new Number(i));
                    } else {
                        i++;
                    }
                }
            }
        }else if(this.numerator.getNumber() < this.denominator.getNumber()) {
            if(this.denominator.getNumber() % this.numerator.getNumber() == 0){
                this.denominator = this.denominator.division(this.numerator);
                this.numerator = new Number(1);
            } else {
                int i = 2;
                while (i <= (int) Math.sqrt(this.numerator.getNumber())) {
                    if(this.numerator.getNumber() % i == 0 && this.denominator.getNumber() % i == 0){
                        this.numerator = this.numerator.division(new Number(i));
                        this.denominator = this.denominator.division(new Number(i));
                    } else {
                        i++;
                    }
                }
            }
        } else {
            this.numerator = new Number(1);
            this.denominator = new Number(1);
        }
    }
}
