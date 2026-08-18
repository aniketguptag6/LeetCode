import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {

        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;

            int index = lowerBound(products, prefix);

            List<String> suggestions = new ArrayList<>();

            // Take at most 3 products starting from lowerBound
            for (int i = index; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }

    private int lowerBound(String[] products, String target) {
        int left = 0;
        int right = products.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (products[mid].compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
