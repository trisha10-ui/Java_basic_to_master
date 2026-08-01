class Solution {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < arr.length; i++) {
            // Found a new largest element
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } 
            // Found an element between largest and secondLargest
            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}