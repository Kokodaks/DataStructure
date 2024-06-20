package Sort;

import Employee.Comparable;

public class MergeSortArray <T>{
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr, T[] temp_arr, int first, int last) {
        if(first < last){
            int mid = (first + last)/2;
            mergeSort(arr, temp_arr, first, mid);
            mergeSort(arr, temp_arr, mid + 1, last);
            merge(arr, temp_arr, first, mid, last);
        }
    }
    public static <T extends Comparable<? super T>> void merge(T[] arr, T[] temp_arr, int first, int mid, int last){
        int index = first;
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;

        while(beginHalf1 <= endHalf1 && beginHalf2 <= endHalf2){

            int compare = arr[beginHalf1].compareTo(arr[beginHalf2]);

            if(compare <= 0){
                temp_arr[index] = arr[beginHalf1];
                beginHalf1++;
            }else{
                temp_arr[index] = arr[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        while(beginHalf1 <= endHalf1){
            temp_arr[index] = arr[beginHalf1];
            beginHalf1++;
            index++;
        }
        while(beginHalf2 <= endHalf2){
            temp_arr[index] = arr[beginHalf2];
            beginHalf2++;
            index++;
        }
        for(index = first; index <= last; index++){
            arr[index] = temp_arr[index];
        }
    }
}
