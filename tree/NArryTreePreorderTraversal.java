package tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NArryTreePreorderTraversal {
	
	public List<Integer> preorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        PreOrder(root,ans);
        return ans;
    }
    
    void PreOrder(Node root, List<Integer> ans){
        if(root==null)
            return;
        ans.add(root.val);
        List<Node> children=root.children;
        if(children!=null)
            for(Node node: children)
                PreOrder(node,ans);
    }

}
