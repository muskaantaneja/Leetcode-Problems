class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        String s1 = backspacestring(s);
        String s2 = backspacestring(t);
        
        if(s1.length()==0 && s2.length()==0)
            return true;
        if( s1.compareTo(s2) == 0)
            return true;
        return false;
    }
    public String backspacestring(String s){
        System.out.println(s);
        String h = "";
        String f= "" ;
        for(int i = 0 ;  i>=0 && i<s.length()-1 ; i++){
            if(s.charAt(i) == '#')
            {
                f = f + s.substring(i+1);
                s = f;
                i = i - 1;
            }
           else if( s.charAt(i+1)  ==  '#'){
                f = s.substring(0,i);
                if(i+2 < s.length())
                    f = f + s.substring(i+2);
                s = f;
                i = i - 2;
               if(i<0)
                   i = -1 ;
            }
            f = "";
             System.out.println(i + "_" + s)  ;
        }
        
        return s ;
    }
}