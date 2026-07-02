class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        
        // Stack will store indices of bars
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i <= n; i++) {
            // For the last iteration, treat height as 0 to flush out remaining bars
            int h = (i == n ? 0 : heights[i]);
            
            // Maintain increasing stack
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
