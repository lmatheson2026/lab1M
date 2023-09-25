import java.util.Arrays;

public class myArrayList {
    private Fraction[] elements;
    private int size;
    private int capacity;

    public myArrayList() {
        this.capacity = 50; // set capacity
        this.elements = new Fraction[capacity]; //new array with size of capacity
        this.size = 0;
    }

    private void grow() {
        int newCapacity = (int)(capacity * 1.2); // store an increase of array size by 20%
        elements = Arrays.copyOf(elements, newCapacity); // create new array with updated capacity
        capacity = newCapacity; // reassign
    }
    
    public void add(int index, Fraction input) {
        if (size == capacity) { // if the array size is at capacity
            grow(); // call grow method
        }

        // out of bounds error handling
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = input;
        size++;
    }


    public int indexOf(Fraction input) {
        // iterate through the elements of the list
        for (int i = 0; i < size; i++) {
            // Compare the current element with the specified Fraction using the compare method
            if (elements[i].compareTo(input) == 0) {
                // If the elements are equal, return the index
                return i;
            }
        }
        // if the specified 'Fraction' is not found, return -1
        return -1;
    }



    public Fraction remove(int index) {
        // out of bounds error handle
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }


            // gets the element to be removed and store it in the removedElement variable
            Fraction removedElement = elements[index];

            // shift elements to the left to fill the gap left by the removed element
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }

            // set the last element to null to clear it (optional, but good practice)
            elements[size - 1] = null;

            // decrement the size of the list to reflect the removal
            size--;

            return removedElement;
        }

    

    // simple print method for the array
    public void print() {
        for (int i = 0; i < size; i++) {
            elements[i].print();
        }
    }
}
