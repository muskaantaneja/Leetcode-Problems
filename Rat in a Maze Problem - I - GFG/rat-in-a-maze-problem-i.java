// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        pathfinder(m , 0 , 0 , ans , new String(),new HashSet<>());
        
        return ans;
    }
    public static void pathfinder(int[][] m , int row , int col , ArrayList<String> ans , String str,HashSet<String>set){
        if( row == m.length-1 && col == m.length-1 && m[row][col] == 1 ){
            ans.add(str);
            return;
        }
        if(row >= m.length || col>= m.length || row < 0 || col < 0)
        return;
        
        if(m[row][col] == 0)
        return ;
        String key = row + "_" + col;
        
        if(set.contains(key))
        return;
        
        set.add(key);
        pathfinder(m , row + 1 , col , ans , str + 'D' , set);
        pathfinder(m , row  , col + 1 , ans , str + 'R', set);
        pathfinder(m , row  , col - 1 , ans , str + 'L', set);
        pathfinder(m , row - 1 , col , ans , str + 'U', set);
        
        set.remove(key);
        return;
    }

    
}