class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int deficit = 0;
        int balance = 0;
        int start = 0;
        
        for(int current = 0 ; current<gas.length ; current++){
            
            balance += gas[current] - cost[current];
            
            if(balance < 0)
            {
                deficit += balance;
                balance = 0;
                start = current+1;
            }
            
        }
        if(balance + deficit >= 0)
            return start;
        else
            return -1;
    }
}