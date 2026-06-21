class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
          int maxCandies = 0;
          for (int i = 0; i < candies.length; i++) {
            if(candies[i]>maxCandies){
                maxCandies = candies[i];
            }
        }

        List result = new ArrayList<Boolean>();
        for (int i = 0; i < candies.length; i++) {
            if(candies[i]+extraCandies >= maxCandies){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
