// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        
        
        return searchRange(arr , x);
    }
    
    public int searchRange(int[] nums, int target) {
        
        int answer[] = new int[2];
        
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(nums[mid] == target)
            {
                ans = mid;
                end = mid - 1;
            }
            
            if(nums[mid] < target)
                start = mid + 1;
            
            if(nums[mid] > target)
                end = mid - 1;
        }
        
        answer[0] = ans;
        
        if(ans == -1)
        {
            answer[1] = -1;
            return 0;
        }
        ans = -1;
        start = 0;
        end = nums.length - 1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(nums[mid] == target)
            {
                ans = mid;
                start = mid + 1;
            }
            
            if(nums[mid] < target)
                start = mid + 1;
            
            if(nums[mid] > target)
                end = mid - 1;
        }
        
        answer[1] = ans;
        
        ans = answer[1] - answer[0] + 1;
        return ans;
    }
}