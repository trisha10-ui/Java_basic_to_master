import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store (prefixSum, first_occurrence_index)
        HashMap<Long, Integer> map = new HashMap<>();
        
        long prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: If sub-array starts from index 0
            if (prefixSum == k) {
                maxLength = i + 1;
            }

            // Case 2: Check if (prefixSum - k) exists in the map
            if (map.containsKey(prefixSum - k)) {
                int previousIndex = map.get(prefixSum - k);
                maxLength = Math.max(maxLength, i - previousIndex);
            }

            // Store prefixSum in map only if it's not already present 
            // to maximize the length of the subarray
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna