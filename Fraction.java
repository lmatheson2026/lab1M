import java.util.Arrays;

public class Fraction implements INumber<Fraction> , Comparable<Fraction> {
    protected double numerator, denominator;

    public Fraction(final double numerator, final double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static void main(String[] args) {
    	// fraction used for comparing
        Fraction X = new Fraction(9, 10);

      
      Fraction [] fractionArray = new Fraction[100];
    
        for (int i = 0; i < fractionArray.length; i++) {
            fractionArray[i] =  new Fraction(i, i + 1);
        }


        // Print min and max fractions in the array
        Fraction minFraction = findMin(fractionArray);
        Fraction maxFraction = findMax(fractionArray);
        System.out.println("Min Fraction:");
        minFraction.print();
        System.out.println("Max Fraction:");
        maxFraction.print();

        // Sort the array using selection sort
        selectionSort(fractionArray);
        //uses loop to print out the sorted array
        System.out.println("Fraction Array -");
        for (Fraction fraction : fractionArray) {
            fraction.print();
        }

        // Calculate the number of Fractions greater than X
        int count = getCountGreater(fractionArray, X);
        System.out.println("Number of Fractions greater than X: " + count);
  
        
        
        myArrayList fractionList = new myArrayList();
      Fraction f =  new Fraction(9, 10);
        // Add fractions to the list

        for (int i = 0; i < fractionArray.length; i++) {
        	Fraction x = new Fraction(i, i + 1);
            fractionList.add(i,x); 
        }
      fractionList.print();
/*calls for myArrayList 
 * 
        fractionList.add(0, f);
        System.out.println("Index of fraction2: " + fractionList.indexOf());

        Fraction removedFraction = fractionList.remove();
 
*/
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

    public int compare(Fraction F) {
        double Fraction1 = F.numerator / F.denominator;
        double Fraction2 = numerator / denominator;

        if (Fraction1 < Fraction2) {
            return 1;
        } else if (Fraction1 > Fraction2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static Fraction findMin(Fraction[] input) {
        Fraction Min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].compare(Min) == -1) {
                Min = input[i];
            }
        }
        return Min;
    }

    public static Fraction findMax(Fraction[] input) {
        Fraction Max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].compare(Max) == 1) {
                Max = input[i];
            }
        }
        return Max;
    }

    public static void selectionSort(Fraction[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
                if (input[i].compare(input[minIndex]) == -1) {
                    minIndex = i;
                }
            
            // Swap input[i] and input[minIndex]
            Fraction temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;
        }
    }

    public static int getCountGreater(Fraction[] inputArray, Fraction inputFraction) {
        int count = 0;
        for (Fraction fraction : inputArray) {
            if (fraction.compare(inputFraction) == -1) {
                count++;
            }
        }
        return count;
    }

    

	public int compareTo(Fraction o) {
		// TODO Auto-generated method stub
		return 0;
	}
}