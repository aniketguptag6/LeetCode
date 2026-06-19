class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0;
        int sum=0;
        for(int i=0;i<gain.length;i++){
         sum = sum+gain[i];
            if(sum>=high){
                high=sum;
            }
        }
        return high;
    }
}
