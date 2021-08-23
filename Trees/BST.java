class BST
{
    Node first , middle , last , prev;
    void correctBSTUtil(Node root)
    {
        if(root != null)
        {
            correctBSTUtil(root.left);
            if(prev != null && root.data < prev.data)
            {
                if(first != null)
                {
                    first = prev;
                    middle = root;
                }
                else
                {
                    last = root;
                }
            }
            prev = root;
            correctBSTUtil(root.right);
        }
    }
    
    void correctBST(Node root)
    {
        first = middle = last = prev = null;
        correctBSTUtil( root );
        if(first != null && last != null)
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first != null && middle != null)
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
    
    void printInorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(" " +node.data);
        printInorder(node.right);
    }
    
    public static void main(String args[])
    {
        BST tree = new BST();
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);
        System.out.println("Inorder Traversal");
        tree.printInorder(root);
        tree.correctBST(root);
        System.out.println("Inorder Traversal after correction");
        tree.printInorder(root);
        
    }
}