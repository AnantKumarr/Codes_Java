import java.util.ArrayList;
import java.util.List;

class CommonElements {

    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k])
             {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            }
             else if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k])
            {
                i++;
            } 
            else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k])
            {
                j++;
            }
            else 
            {
                k++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {2, 4, 5, 7, 9};
        int[] arr3 = {4, 6, 7, 18, 20};
        
        List<Integer> commonElements = findCommonElements(arr1, arr2, arr3);
        
        System.out.println("Final Array = " + commonElements);
    }
}