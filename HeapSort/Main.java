import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0);
        int[] array = {0,5,7,5,2,8,1,9};
        //create heap
        insert(arrayList, array);
        //sort heap
        takeLargest(arrayList, 1);
        for (int num = 1; num < arrayList.size(); num++) {
            System.out.print(arrayList.get(num) + ", ");
        }
    }

    public static void insert(ArrayList<Integer> arrayList, int[] array) {
        for (int num : array) {
            arrayList.add(num);
        }
        Heapify(arrayList, 1, 0);
    }

    public static void takeLargest(ArrayList<Integer> arrayList, int arraySize) {
        swap(1, arrayList.size() - arraySize, arrayList);
        Heapify(arrayList, 1, arraySize);
        if (arrayList.size() - arraySize > 1) {
            takeLargest(arrayList, arraySize + 1);
        }
    }

    public static void Heapify(ArrayList<Integer> arrayList, int pos, int arraySize) {    
        if (pos*2 < arrayList.size() - arraySize) {
            int child = 2*pos;
            if (pos*2+1<arrayList.size() - arraySize && arrayList.get(pos*2) < arrayList.get(pos*2+1))
                child=2*pos+1;
            if  (arrayList.get(child) > arrayList.get(pos)) {
                swap(pos, child, arrayList);
                Heapify(arrayList, 1, arraySize);
            }
            Heapify(arrayList, pos + 1, arraySize);
        }
    }

    public static void swap(int swapTo, int swapFrom, ArrayList<Integer> arrayList) {
        int temp = arrayList.get(swapTo);
        arrayList.set(swapTo, arrayList.get(swapFrom));
        arrayList.set(swapFrom, temp);
    }
}