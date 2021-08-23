import java.util.*;
import java.io.*;
public class GetComp
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
        int vt = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph =new ArrayList[vt];
        for(int i=0;i<vt;i++)
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
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean visited[] = new boolean[vt];
        for(int v=0;v<vt;v++)
        {
            if(visited[vt] == false)
            {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndGenerateComp(graph , v, comp,visited);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }
    
    public static void drawTreeAndGenerateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean visited[])
    {
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src])
        {
            if(visited[e.nbr] == false)
            {
                drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
            }
        }
    }
}
        
