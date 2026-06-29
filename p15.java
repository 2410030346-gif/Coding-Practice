class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Frequency map for characters in t
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0, right = 0;
        int required = t.length(); // total chars we need to match
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Sliding window
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (targetFreq[rChar] > 0) {
                required--;
            }
            targetFreq[rChar]--;
            right++;

            // When all chars are matched
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                targetFreq[lChar]++;
                if (targetFreq[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
