import java.util.Random;

public class Assignment03 {

    public static void main(String[] args) {
        int[] testArray = RandomArray(10);
        PrintArray(testArray);
        MergeSort(testArray, 0, (testArray.length - 1));
        PrintArray(testArray);
    }

    public static void MergeSort(int[] dataList, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middleIndex = (firstIndex + lastIndex / 2);
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
        int[] resultList = new int[dataList.length];
        while ((start1 <= end1) && (start2 <= end2)) {
            if (dataList[start1] < dataList[start2]) {
                resultList[indexC] = dataList[start1];
                start1 += 1;
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


