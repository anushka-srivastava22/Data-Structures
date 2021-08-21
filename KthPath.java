import java.util.*;
import java.io.*;
public class KthPath
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
    static class Pair implements Comparable<Pair>{
        int wsf;
        String psf;
        Pair(int wsf , String psf)
        {
            this.wsf = wsf;
            this.psf = psf;
        }
        public int compareTo(Pair o)
        {
            return this.wsf - o.wsf;
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
        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        boolean visited[] = new boolean[v];
        
        multisolver(graph,src,dest,visited,criteria,k,src+"",0);
        System.out.println("Smallest Path "+spath+"@"+spathwt);
        System.out.println("Largest Path "+lpath+"@"+lpathwt);
        System.out.println("Smallest Path than "+criteria+"="+cpath+"@"+cpathwt);
        System.out.println("Largest Path than "+criteria+"="+fpath+"@"+fpathwt);
        System.out.println(k+ " Path than "+pq.peek().psf+"@"+pq.peek().wsf);
    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue();
    public static void multisolver(ArrayList<Edge>[] graph , int src , int dest , boolean visited[], int criteria, int k, String psf, int wsf)
    {
        if(src == dest)
        {
            if(wsf < spathwt)
            {
                spathwt = wsf;
                spath = psf;
            }
            if(wsf > spathwt)
            {
                lpathwt = wsf;
                lpath = psf;
            }
            if(wsf > criteria && wsf < cpathwt)
            {
                cpathwt = wsf;
                cpath = psf;
            }
            if(wsf < criteria && wsf > cpathwt)
            {
                fpathwt = wsf;
                fpath = psf;
            }
            if(pq.size() < k)
            {
                pq.add(new Pair(wsf,psf));
            }
            else
            {
                if(wsf > pq.peek().wsf)
                {
                    pq.remove();
                    pq.add(new Pair(wsf,psf));
                }
            }
            return;
        }
        visited[src] = true;
        for(Edge e : graph[src])
        {
            if(visited[e.nbr] == false)
            {
                multisolver(graph,e.nbr,dest,visited,criteria,k,psf+e.nbr,wsf+e.wt);
                
            }
        }
        visited[src] = false;
    }
}
    
