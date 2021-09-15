
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }

  public static int orangesRotting(int[][] grid) {
    
    
    LinkedList<Pair> queue=new LinkedList<>();
    int fresh = 0;
    for(int i = 0; i< grid.length;i++)
    {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j] == 2)
            {
                queue.addLast(new Pair(i,j));
            }
            else if(grid[i][j] == 1)
            {
                fresh++;
            }
        }
    }
    if(fresh == 0)
    {
        return 0;
    }
    int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    int level = -1;
    while(queue.size() > 0)
    {
        int size = queue.size();
        level++;
        while(size-- > 0)
        {
            Pair rem = queue.removeFirst();
            for(int i=0;i<dirs.length;i++)
            {
                int rdash = rem.row + dirs[i][0];
                int cdash = rem.col + dirs[i][1];
                if(rdash >= 0 && cdash >= 0 && rdash < grid.length && cdash < grid[0].length && grid[rdash][cdash] == 1) 
                {
                    queue.addLast(new Pair(rdash,cdash));
                    grid[rdash][cdash] = 0;
                    fresh--;
                }
            }
        }
    }
    if(fresh == 0)
    {
        return level;
    }
    else
    {
        return -1;
    }
    
    
  }
}
