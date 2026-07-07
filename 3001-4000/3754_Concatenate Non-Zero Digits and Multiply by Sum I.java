class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long rem=0;
        long x=0;
        int p=1;
        while(n>0){
           rem = n%10;
            if(rem !=0){
                sum = sum + rem;
                x=rem * p + x;
                p *=10;
            }
            n=n/10;
        }
        
        return x*sum;
    }
}
