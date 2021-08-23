class BinaryTree4
{
    Node root;
    static int preIndex = 0;

    Node buildTree(char in[] , char pre[] , int inStart , int inEnd)
    {
        if(inStart > inEnd)
        {
            return null;
        }
        Node tNode = new Node(pre[preIndex++]);
        if(inStart == inEnd)
        {
            return tNode;
        }
        int inIndex = search(in , inStart , inEnd , tNode.data);
        tNode.left = buildTree(in , pre , inStart , inIndex - 1);
        tNode.right = buildTree(in , pre , inIndex + 1 , inEnd);

        return tNode;
    }

    int search (char arr[] , int start , int end , char value)
    {
        int i;
        for(i = start; i <= end; i++)
        {
            if(arr[i] == value)
            {
                return i;
            }
        }
        return i;
    }
    
    void printInorder (Node node)
    {
        if(node == null)
        {
            return;
        }
        printInorder (node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    
    public static void main(String args[])
    {
        BinaryTree4 tree = new BinaryTree4();
        char in[] = new char [] { 'D' , 'B' , 'E' , 'A' , 'F' , 'C'};
        char pre[] = new char []{ 'A' , 'B' , 'D' , 'E' , 'C' , 'F'};
        int length = in.length;
        Node root = tree.buildTree(in , pre , 0 , length-1);
        System.out.println("Inorder Traversal ");
        tree.printInorder(root);
    }
}
 