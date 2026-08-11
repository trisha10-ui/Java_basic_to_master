class Solution {
public:
    void rotateArr(vector<int>& arr, int d) {
        int n = arr.size();
        d %= n; // Handle cases where d >= n
        
        // Step 1: Reverse the first d elements
        reverse(arr.begin(), arr.begin() + d);
        
        // Step 2: Reverse the remaining (n - d) elements
        reverse(arr.begin() + d, arr.end());
        
        // Step 3: Reverse the entire array
        reverse(arr.begin(), arr.end());
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna