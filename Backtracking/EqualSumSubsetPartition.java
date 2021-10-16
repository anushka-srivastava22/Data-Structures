import java.util.*;
public class Main
{
    public static void solution(int arr[] , int vidx , int n , int k, int subsetSum[], int sssf , ArrayList<ArrayList<Integer>> ans)
    {
        if(vidx == arr.length)
        {
            if(sssf == k)
            {
                boolean flag = true;
                for(int i=0;i<subsetSum.length-1;i++)
                {
                    if(subsetSum[i] != subsetSum[i+1])
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    for(ArrayList<Integer> part: ans)
                    {
                        System.out.print(part+" ");
                        
                    }
                    System.out.println();
                }
            }
            return;
        }
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i).size() > 0)
            {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,sssf,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
                
            }
            else
            {
                ans.get(i).add(arr[vidx]);
                subsetSum[i] += arr[vidx];
                solution(arr,vidx+1,n,k,subsetSum,sssf,ans);
                subsetSum[i] -= arr[vidx];
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            }
        }
    }
