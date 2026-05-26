/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";
        StringBuilder res=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode temp=q.poll();
            
            if(temp==null)
            {
                res.append("n ");
                continue;
            }
            res.append(temp.val+" ");
            q.add(temp.left);
            q.add(temp.right);

        }
        return res.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0 || data.charAt(0)=='n')
            return null;
        String str[]=data.split(" ");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        int i=0;
       while(!q.isEmpty())
       {
        TreeNode temp=q.poll();
        i++;
        if(!str[i].equals("n"))
        {
            temp.left=new TreeNode(Integer.parseInt(str[i]));
            q.add(temp.left);
        }
        i++;
        if(!str[i].equals("n"))
        {
            temp.right=new TreeNode(Integer.parseInt(str[i]));
            q.add(temp.right);
        }
       }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));