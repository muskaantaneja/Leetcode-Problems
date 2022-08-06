class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int five =0, ten = 0;
        
        for(int current: bills)
        {
            if(current == 5)
                five++;
            else if(current == 10)
            {
                ten++;
                five--;
                if(five<0)
                    return false;
            }
            else if(current==20)
            {
                if(ten > 0 && five>0)
                {
                    ten--;
                    five--;
                }
                else if(five >= 3)
                    five -= 3;
                else
                    return false;
            }
        }
        
        return true;
    }
}