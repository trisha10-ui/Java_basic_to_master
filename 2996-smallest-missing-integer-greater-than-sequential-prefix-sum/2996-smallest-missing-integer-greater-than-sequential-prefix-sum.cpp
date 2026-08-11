#include <vector>
#include <unordered_set>

class Solution {
public:
    int missingInteger(std::vector<int>& nums) {
        int sum = nums[0];
        
        // Find the sum of the longest sequential prefix starting at index 0
        for (size_t i = 1; i < nums.size(); ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        
        // Store elements in a hash set for fast lookup
        std::unordered_set<int> st(nums.begin(), nums.end());
        
        // Find the smallest missing integer >= sum
        while (st.count(sum)) {
            sum++;
        }
        
        return sum;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna