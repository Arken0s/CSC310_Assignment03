import java.util.Random;

public class Assignment03 {

    public static void main(String[] args) {
        //int[] testArray = RandomArray(10);
        int[] testArray = new int[]{5,7,8,1,2,9};
        System.out.println("Test Array before merge sort: ");
        PrintArray(testArray);
        MergeSort(testArray, 0, (testArray.length - 1));
        System.out.println("Test Array after merge sort: ");
        PrintArray(testArray);
    }

    public static void MergeSort(int[] dataList, int firstIndex, int lastIndex) { //TODO: Rewrite to have the firstIndex and lastIndex generated from dataList.length.
        if (firstIndex < lastIndex) { // 0 - 5
            int middleIndex = ((firstIndex + lastIndex) / 2);
            System.out.println("Middle Index: " +  middleIndex);
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
        }
        if (start1 <= end1) {
            for (int i = start1; i > end1; i++) {
                resultList[indexC] = dataList[i];
                indexC += 1;
            }
        } else {
            for (int i = start2; i > end2; i++) {
                resultList[indexC] = dataList[i];
                indexC += 1;
            }
        }
        indexC = 0;
        for (int i = finalStart; i > finalEnd; i++) {
            dataList[i] = resultList[indexC];
            indexC += 1;
        }
        System.out.println("Result Array at end of MergeLists:");
        PrintArray(resultList);
    }

    public static int[] RandomArray(int listSize) {
        int[] returnList = new int[listSize];
        int insertNum = 0;
        for (int i = 0; i < listSize; ++i) {
            returnList[i] = insertNum;
            insertNum += 1;
        }
        ArrayShuffle(returnList);
        return returnList;
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

    public static int[] OrderedList_Low_to_High() {
        int[] orderedList = new int[100];
        for (int i = 1; i <= 100; ++i) {
            orderedList[i - 1] = i;
        }
        return orderedList;
    }

    public static int[] OrderedList_High_to_Low() {
        int[] orderedList = new int[100];
        int value = 100;
        for (int i = 1; i <= 100; ++i) {
            orderedList[i - 1] = value;
            value = value - 1;
        }
        return orderedList;
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


