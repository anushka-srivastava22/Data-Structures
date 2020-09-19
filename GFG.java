class GFG
{
    public static void findWaitingTime(int processor[] , int n , int bt[] , int wt[] , int quantam)
    {
        int rem_bt[] = new int [n];
        for(int i = 0; i < n; i++)
        {
            rem_bt[i] = bt[i];
        }
        int t = 0;
        while (true)
        {
            boolean done = true;
            for(int i = 0; i < n; i++)
            {
                if(rem_bt[i] < 0)
                {
                    done = false;
                }
                if(rem_bt[i] > quantam)
                {
                    t+ = quantam;
                    rem_bt[i]- = quantam;
                }
                else
                {
                    t+ = rem_bt[i];
                    wt[i] = t - bt[i];
                    rem_bt[i] = 0;
                }
            }
        }
        if(done == true)
        {
            break;
        }
    }
    public static void findTurnAroundTime(int processes[] , int n , int bt[] , int wt[] , int tat[])
    {
        for(int i = 0; i < n;i++)
        {
            tat[i] = bt[i] + wt[i];
        }
    }
    public static void findAvgTime(int processes[] , int n , int bt[] , int quantam)
    {
        int wt[] = new int [n] , tat[] = new int [n];
        int total_wt = 0 , total_tat = 0;
        findWaitingTime(processes , n , bt , wt , tat);
        System.out.println("Process " + "Burst Time " +" Waiting Time "+" Turn Around Time ");
        for(int i = 0;i < n;i++)
        {
           total_wt+ = wt[i];
           total_tat+ = tat[i];
           System.out.println(" " +(i+1)+"\t\t"+bt[i]+"\t\t"+wt[i]+ "\t\t"+tat[i]);
        }
        System.out.println("Avg Waiting Time " +(float)total_wt / (float)n);
        System.out.println("Avg TAT "+(float)total_tat/(float)n);
        
    }
    public static void main(String args[])
    {
        int processes[] = {1,2,3};
        int n = processes.length;
        int burst_time[] = {10 , 5 , 8};
        int quantam = 2;
        findAvgTime(processes , n , burst_time , quantam);
    }
}
            