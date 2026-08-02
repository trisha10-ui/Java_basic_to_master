import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Get the 0-based index corresponding to the current element's absolute value
            int index = Math.abs(arr[i]) - 1;
            
            // If the element at this index is negative, it has already been visited
            if (arr[index] < 0) {
                result.add(index + 1);
            } else {
                // Mark as visited by negating the value at this index
                arr[index] = -arr[index];
            }
        }
        
        return result;
    }
}