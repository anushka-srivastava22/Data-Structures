import java.io.*;
import java.util.*;


public class Main {

	public static void main (String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int pre[][] = new int[m][2];
        for(int i=0;i<m;i++)
        {
            st = br.readLine().split(" ");
            pre[i][0] = Integer.parseInt(st[0]);
            pre[i][1] = Integer.parseInt(st[1]);
            
        }
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
            
        }
        for(int i=0;i<pre[0].length;i++)
        {
            int u = pre[i][0];
            int v = pre[i][1];
            graph.get(v).add(u);
        }
        int ans[] = findOrder(n,graph);
        for(int val : ans)
        {
            System.out.print(val+" ");
        }
        
	}
	
	public static int[] findOrder(int n , ArrayList<ArrayList<Integer>> graph)
	{
	    int indegree[] = new int[n];
	    int ans[] = new int[n];
	    for(int i=0;i<n;i++)
	    {
	        for(int nbrs : graph.get(i))
	        {
	            indegree[nbrs]++;
	        }
	    }
	    LinkedList<Integer> queue=new LinkedList<>();
	    for(int i=0;i<n;i++)
	    {
	        if(indegree[i] == 0)
	        {
	            queue.addLast(i);
	        }
	    }
	    int idx = 0;
	    while(queue.size() > 0)
	    {
	        int rem = queue.removeFirst();
	        ans[idx] = rem;
	        idx++;
	        for(int nbrs : graph.get(rem))
	        {
	            indegree[nbrs]--;
	            if(indegree[nbrs] == 0)
	            {
	                queue.addLast(nbrs);
	            }
	        }
	    }
	    if(idx == n) 
	    {
	        return ans;
	    }
	    else
	    {
	        return new int[]{-1};
	    }
	}
	
}


