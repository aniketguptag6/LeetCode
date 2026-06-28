//Solution 1
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;

        arr[0]=1;
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i-1]-arr[i])<=1)
               continue;
            else arr[i]=arr[i-1] + 1;
        }
        return arr[n-1];
    }
}
//Solution 2
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int count[] = new int[n+1];

        for(int a:arr){
            int idx = Math.min(a,n);
            count[idx]++;
        }
        int ans=1;
        for(int i=2;i<=n;i++){
            int curr = ans + count[i];
            ans = Math.min(i,curr);
        }
        return ans;
    }
}
