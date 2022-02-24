package task3;

public class MainForFraction {
    public static void main(String[] args) {

        Fraction fr1 = new Fraction(new Number(1), new Number(2));
        Fraction fr2 = new Fraction(new Number(1), new Number(4));

        System.out.println("Fraction 1:");
        System.out.println(fr1);
        System.out.println("Fraction 2:");
        System.out.println(fr2);

        System.out.println();
        Fraction fr_sum = fr1.summation(fr2);
        System.out.println("Summation: ");
        System.out.println(fr_sum);

        System.out.println();
        Fraction fr_sub = fr1.subtraction(fr2);
        System.out.println("Subtraction: ");
        System.out.println(fr_sub);

        System.out.println();
        Fraction fr_mul = fr1.multiplication(fr2);
        System.out.println("Multiplication: ");
        System.out.println(fr_mul);

        System.out.println();
        Fraction fr_div = fr1.division(fr2);
        System.out.println("Division: ");
        System.out.println(fr_div);

    }
}
