package Lab10;

/**
 The BubbleSortBenchmarker class performs a
 bubble sort on an int array. It keeps count
 of the number of swaps made.
 Code taken from textBook ARCHIVE
 */

public class BubbleSortBenchmarker
{
    private int array[];  // The array to sort
    private int numSwaps; // To count the number of swaps made
    private int numComps; //To count the number of comparisons made
    private int numAssign; //To count the number of assignments made

    /**
     Constructor
     @param a The array to sort.
     */
    public BubbleSortBenchmarker(int a[])
    {
        array = a;
        numSwaps = 0;
        numComps = 0;
        numAssign = 0;
        bubbleSort();
    }

    /**
     The bubbleSort method uses the bubble sort algorithm
     to sort the array.
     */

    private void bubbleSort()
    {
        int maxElement;   // Marks the last element to compare
        int index;        // Index of an element to compare
        int temp;         // Used to swap to elements

        // The outer loop positions maxElement at the last element
        // to compare during each pass through the array. Initially
        // maxElement is the index of the last element in the array.
        // During each iteration, it is decreased by one.
        numComps++;
        for (maxElement = array.length - 1; maxElement >= 0; maxElement--)
        {
            // The inner loop steps through the array, comparing
            // each element with its neighbor. All of the elements
            // from index 0 thrugh maxElement are involved in the
            // comparison. If two elements are out of order, they
            // are swapped.
            numComps++;
            for (index = 0; index <= maxElement - 1; index++)
            {
                // Compare an element with its neighbor.
                numComps++;
                if (array[index] > array[index + 1])
                {
                    // Swap the two elements.
                    temp = array[index];
                    numAssign++;
                    array[index] = array[index + 1];
                    numAssign++;
                    array[index + 1] = temp;
                    numSwaps++;
                }
                numComps++;
            }
            numComps++;
        }
    }

    /**
     The getNumSwaps method returns the number of
     swaps made.
     @return The number of swaps made.
     */

    public int getNumSwaps()
    {
        return numSwaps;
    }

    public int getNumComps() {return numComps;}

    public int getNumAssign() {return numAssign;}
}