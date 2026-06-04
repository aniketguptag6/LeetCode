class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int total = nums1.length + nums2.length;

        int previous=0;
        int current = 0;

        for(int k=0;k<=total/2;k++){
            previous=current;

            if(i<nums1.length && ( j>=nums2.length||nums1[i]<=nums2[j])){
               current = nums1[i++];
            }else{
                current = nums2[j++];
            }
        }
            if(total % 2==0){
                return(previous+current)/2.0;
            }
        
        return current;
    }
}