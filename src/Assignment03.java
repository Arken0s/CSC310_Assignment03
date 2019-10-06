public class Assignment03 {

    public static void main(String[] args) {

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

    }

}
