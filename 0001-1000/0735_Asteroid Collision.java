class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        // List acting as a stack to store surviving asteroids
        List<Integer> st = new ArrayList<>();

        // Traverse through each asteroid
        for (int i = 0; i < n; i++) {

            // If asteroid is moving right, push it to the stack
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }

            // If asteroid is moving left, handle possible collisions
            else {
                // Destroy all smaller right-moving asteroids
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 &&
                       st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                // Destroy both if sizes are equal
                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                // If top of stack is a left-moving or no asteroid, add this one
                else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(asteroids[i]);
                }
            }
        }

        // Convert the list to an array
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }

        // Return the final state of asteroids
        return result;
    }
}
