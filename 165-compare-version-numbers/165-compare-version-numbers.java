class Solution {
    public int compareVersion(String v1, String v2) {
        String s1="";
        String s2="";
        
        int i = 0;
        int j = 0;
        
        while(i < v1.length() || j<v2.length())
        {
            while(i < v1.length()&& v1.charAt(i) != '.')
            {
                if(i<v1.length())
                s1 = s1 + v1.charAt(i);
                else
                {
                    if(s1.length() == 0)
                    s1="0";
                    break;
                }
                i++;
            }
            
            while(j<v2.length()&& v2.charAt(j) != '.')
            {
                if(j<v2.length())
                s2 = s2 + v2.charAt(j);
                else 
                {
                    if(s2.length() == 0)
                    s2="0";
                    break;
                }
                j++;
            }
            
             int num1 = 0 ;
            if(s1.length()>0)
                     num1 = Integer.parseInt(s1);
            int num2 =  0;
            if(s2.length()>0)
                     num2 = Integer.parseInt(s2);
            
            if(num1 > num2)
                return 1;
            
            if(num2 > num1)
                return -1;
            
            s1 = "";
            s2 ="";
            i++;
            j++;
            
        }
        return 0;
    }
}