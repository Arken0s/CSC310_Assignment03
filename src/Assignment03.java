import java.util.Random;

public class Assignment03 {

    private static int comparisonCount = 0;

    public static void main(String[] args) {
        MergeSortMultiTest(10,10,6);
        
//        Results:
//        MergeSort with 10 elements completed with a comparison count of **23**
//        MergeSort with 100 elements completed with a comparison count of **535**
//        MergeSort with 1000 elements completed with a comparison count of **8690**
//        MergeSort with 10000 elements completed with a comparison count of **120531**
//        MergeSort with 100000 elements completed with a comparison count of **1536140**
//        MergeSort with 1000000 elements completed with a comparison count of **18673927**

        //************************
        //** MERGE SORT TESTING **
        //************************

//        int[] testArray = new int[]{16,7,10,1,5,11,3,8,14,4,2,12,6,13,9,15};
//        System.out.println("Test Array before merge sort: ");
//        PrintArray(testArray);
//
//        MergeSort(testArray, 0, (testArray.length - 1));
//
//        System.out.println("Test Array after merge sort: ");
//        PrintArray(testArray);

        //************************
        //** QUICK SORT TESTING **
        //************************
//        int[] testArray = new int[]{16,7,10,1,5,11,3,8,14,4,2,12,6,13,9,15};
//        System.out.println("Test Array before quick sort: ");
//        PrintArray(testArray);
//        QuickSort(testArray, 0, (testArray.length - 1));
//        System.out.println("Test Array after quick sort: ");
//        PrintArray(testArray);
    }

    /*
                                                                     **************************************
                                                                     ****          MERGESORT           ****
                                                                     **************************************
     */
    public static void MergeSort(int[] dataList, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = ((firstIndex + lastIndex) / 2);
            MergeSort(dataList, firstIndex, middleIndex);
            MergeSort(dataList, middleIndex + 1, lastIndex);
            MergeLists(dataList, firstIndex, middleIndex, middleIndex +1, lastIndex);
        }
    }

    public static void MergeLists(int[] dataList, int firstIndex, int middleIndex, int midplusoneIndex, int lastIndex) {
        int start1 = firstIndex;
        int end1 = middleIndex;
        int start2 = midplusoneIndex;
        int end2 = lastIndex;
        int finalStart = start1;
        int finalEnd = end2;
        int indexC = 0;
        int[] resultList = new int[dataList.length]; // Placeholder list
        while ((start1 <= end1) && (start2 <= end2)) { // While the first indexes of the split lists are <= the last indexes.
            if (dataList[start1] < dataList[start2]) { // If ListA's first item is less than ListB's first item.
                resultList[indexC] = dataList[start1]; // Place the item in placeholder list at the next open slot.
                start1 += 1; // Now looks to the next item in the list
            } else {
                resultList[indexC] = dataList[start2];
                start2 += 1;
            }
            indexC += 1;
            comparisonCount++;
        }
        if (start1 <= end1) {
            for (int i = start1; i <= end1; i++) {
                resultList[indexC] = dataList[i];
                indexC += 1;
            }
        } else {
            for (int i = start2; i <= end2; i++) {
                resultList[indexC] = dataList[i];
                indexC += 1;
            }
        }
        indexC = 0;
        for (int i = finalStart; i <= finalEnd; i++) {
            dataList[i] = resultList[indexC];
            indexC += 1;
        }
    }

    /*
                                                                    **************************************
                                                                    ****          QUICKSORT           ****
                                                                    **************************************
    */
    public static void QuickSort(int[] dataList, int first, int last) {
        if (first < last) {
            int pivot = PivotList(dataList, first, last);
            QuickSort(dataList, first, pivot-1);
            QuickSort(dataList, pivot + 1, last);
        }
    }

    public static int PivotList(int[] dataList, int first, int last) {
        int pivotValue = dataList[first];
        int pivotPoint = first;
        for (int i = (first+1); i <= (dataList.length - 1); i++) {
            if (dataList[i] < pivotValue) {
                pivotPoint = pivotPoint + 1;
                SwapElements(dataList, pivotPoint, i);
            }
            comparisonCount++;
        }
        SwapElements(dataList, first, pivotPoint);
        return pivotPoint;
    }

/*
                                                                     **************************************
                                                                     ****      SUPPORT FUNCTIONS       ****
                                                                     **************************************
 */
    /**
     * Creates random arrays with values between 1-100,000 and runs them through MergeSort, producing the cost. (1)
     * @param size This value is the amount of elements in each array and will be squared for each run.
     * @param multiVar What value to times the size by each run to increase its size.
     * @param runs How many arrays will be sent to MergeSort. Each run will square the "size" variable.
     */
    public static void MergeSortMultiTest(int size, int multiVar, int runs) {
        System.out.println("DataSize,Cost");
        for (int i = 0; i < runs; i++) {
            comparisonCount = 0;
            MergeSort(RandomList(size, 100000), 0, size - 1);
            System.out.println(size + "," + comparisonCount);
//            System.out.println("MergeSort with 1000 elements completed with a comparison count of **" + comparisonCount + "**");
            size = (size * multiVar);
        }
    }

    public static void ArrayShuffle(int[] data) {
        Random rn = new Random(27);
        for (int i = 0; i < data.length; ++i) {
            int loc = rn.nextInt(data.length);
            int temp = data[loc];
            data[loc] = data[i];
            data[i] = temp;
        }
    }

    public static int[] RandomList(int size, int maxNum) {
        int[] randomList = new int[size];
        Random rn = new Random(27);
        for (int i = 1; i <= size; ++i) {
            randomList[i - 1] = rn.nextInt((maxNum - 0) + 1) + 0;
        }
        return randomList;
    }

    public static int[] OrderedList_Low_to_High(int size) {
        int[] orderedList = new int[size];
        for (int i = 1; i <= size; ++i) {
            orderedList[i - 1] = i;
        }
        return orderedList;
    }

    public static int[] OrderedList_High_to_Low(int size) {
        int[] orderedList = new int[size];
        int value = size;
        for (int i = 1; i <= size; ++i) {
            orderedList[i - 1] = value;
            value = value - 1;
        }
        return orderedList;
    }

    public static void SwapElements(int[] data, int index1, int index2) {
        int tempValue = data[index1];
        data[index1] = data[index2];
        data[index2] = tempValue;
    }

    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (i == (array.length - 1)) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

}


