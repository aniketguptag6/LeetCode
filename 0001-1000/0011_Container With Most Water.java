class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max=0;
        while(l<r){
           int ans = (r-l) * Math.min(height[l],height[r]);
           max = Math.max(max,ans);
           if(height[l]<height[r]){
            l++;
           }else{
            r--;
           }
           
        }
        return max;
    }
}
