class ATM {

    long banknotes[] = new long[5];
    public ATM() {
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i =0;i<5;i++)
        {
            banknotes[i] = banknotes[i] + banknotesCount[i]; 
        }
    }
    
    public int[] withdraw(int amount) {
        int withdrawnotes[] = new int[5];
        for(int i =4;i>=0;i--)
        {
            int r =0;
            if(i==4)r=500;
            if(i==3)r=200;
            if(i==2)r=100;
            if(i==1)r=50;
            if(i==0)r=20;
            long number = amount/r;
            if(banknotes[i] >= number)
            {
                banknotes[i] = banknotes[i] - number;
                withdrawnotes[i] = (int)number;
                amount = amount - (int)number * r;
            }
            else if(banknotes[i] < number)
            {
                withdrawnotes[i] = (int) banknotes[i];
                banknotes[i] = 0 ;
                amount = amount - withdrawnotes[i] * r;
            }
            
            if(amount == 0)
                break;
        }
        if(amount>0)
            {
                int fail[] = new int[1];
                fail[0]=-1;
            for(int i=0;i<=4;i++)
            {
                 banknotes[i] = banknotes[i] +withdrawnotes[i];
              //  System.out.print(banknotes[i]);
            }
            //System.out.println();
                return fail;
            }
        return withdrawnotes;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */