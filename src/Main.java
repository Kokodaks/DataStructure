import Employee.Employee;
import Sort.SelectionSortArray;
import Sort.MergeSortArray;

public class Main {
    public static void main(String[] args){

        Employee[] arr = new Employee[100000];
        Employee[] temp_arr = new Employee[arr.length];

        int first_employee = 111111;
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Employee(first_employee + i);
        }

        int prev_index = -1;
        int counter = arr.length/2;
        Employee temp;
        while(counter >= 0){
            int rand_index = (int)(Math.random()*arr.length-1 + 0);
            int rand_employee = (int)(Math.random()*arr.length-1 + 0);
            if(rand_index != prev_index && rand_index != rand_employee){
                temp = arr[rand_index];
                arr[rand_index] = arr[rand_employee];
                arr[rand_employee] = temp;
                counter--;
            }
            prev_index = rand_index;
        }

        SelectionSortArray sort2 = new SelectionSortArray();
        long S_StartTime = System.currentTimeMillis();
        sort2.selectionSort(arr, arr.length-1);
        long S_EndTime = System.currentTimeMillis();

        MergeSortArray sort1 = new MergeSortArray();
        long M_StartTime = System.currentTimeMillis();
        sort1.mergeSort(arr, temp_arr, 0, arr.length-1);
        long M_EndTime = System.currentTimeMillis();

        System.out.println("Array length: " + arr.length);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i].ssn + " ");
        }
        System.out.println("Selection sort elapsed time: " + (S_EndTime - S_StartTime));
        //System.out.println("Merge sort elapsed time: " + (M_EndTime - M_StartTime));
    }
}