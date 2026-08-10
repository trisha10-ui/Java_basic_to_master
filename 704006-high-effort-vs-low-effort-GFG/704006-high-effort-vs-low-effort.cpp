class Solution {
  public:
    int maxTask(vector<int>& h, vector<int>& l) {
        // code here
        int n=h.size();
        if(n==0)
        return 0;
        if(n==1)
        return max(h[0],l[0]);
        
        int prev2=0;
        int prev1=max(h[0],l[0]);
        
        int current=prev1;
        
        for(int i=1;i<n ;i++){
            int lowchoice=prev1+l[i];
            
            int highchoice=prev2+h[i];
            current=max(lowchoice,highchoice);
            prev2=prev1;
            prev1=current;
        }
        return current;
    }
};

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna