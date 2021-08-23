import java.util.*;
import java.io.*;
public class PathGraph
{
    static class Edge 
    {
        int src;
        int nbr;
        int wt;
        Edge(int src , int nbr , int wt)
        {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph =new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            graph[i] = new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for(int i=0;i<edges;i++)
        {
            String[] part = br.readLine().split(" ");
            int v1 = Integer.parseInt(part[0]);
            int v2 = Integer.parseInt(part[1]);
            int wt = Integer.parseInt(part[2]);
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v1].add(new Edge(v2,v1,wt));
        }
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        boolean visited[] = new boolean[v];
        boolean path = hasPath(graph , src , dest , visited);
        System.out.println(path);
        
    }
    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest , boolean visited[])
    {
        if(src == dest)
        {
            return true;
        }
        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                boolean hasNbrPath = hasPath(graph,edge.nbr,dest,visited);
                if(hasNbrPath == true)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
