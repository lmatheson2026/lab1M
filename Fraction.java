public class Fraction implements INumber<Fraction>, Comparable<Fraction> {
    protected double numerator, denominator;
    public Fraction(final double numerator, final double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Fraction plus(final Fraction input) {
        return new Fraction(numerator + input.numerator, denominator + input.denominator);
    }

    @Override
    public Fraction minus(final Fraction input) {
        return new Fraction(numerator - input.numerator, denominator - input.denominator);
    }

    @Override
    public Fraction divide(final Fraction input) {
        return new Fraction(numerator / input.numerator, denominator / input.denominator);
    }

    @Override
    public Fraction multiply(final Fraction input) {
        return new Fraction(numerator * input.numerator, denominator * input.denominator);
    }

    @Override
    public void print() {
        System.out.printf("%f/%f\n", numerator, denominator);
    }
    
    public Fraction findMax(Fraction[] input) {
        Fraction max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].compareTo(max) == 1) {
                max = input[i];
            }
        }
        return max;
    }

    public Fraction findMin(Fraction[] input) {
        Fraction min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].compareTo(min) == -1) {
                min = input[i];
            }
        }
        return min;
    }
    
    
    public int getCountGreater(Fraction[] inputArray, Fraction inputFraction) {
        int count = 0;
        for (Fraction fraction : inputArray) {
            if (fraction.compareTo(inputFraction) == 1) {
                count++;
            }
        }
        return count;
    }
    
    public int getCountGreater(Fraction[] inputArray, Fraction inputFraction, int currentIndex) {
        if (currentIndex >= inputArray.length) {
            return 0;
        }

        int compareResult = inputArray[currentIndex].compareTo(inputFraction);
        int count = 0;

        if (compareResult == 1) {
            count = 1;
        }

        return count + getCountGreater(inputArray, inputFraction, currentIndex + 1);
    }
    
    public int compareTo(Fraction other) {
        // Compare fractions based on their values
        double thisValue = this.numerator / this.denominator;
        double otherValue = other.numerator / other.denominator;
        if (thisValue < otherValue) {
            return -1;
        } else if (thisValue > otherValue) {
            return 1;
        } else {
            return 0;
        }
    }

}
