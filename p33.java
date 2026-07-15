import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode rt) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = rt;
        
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        
        return res;
    }
}
