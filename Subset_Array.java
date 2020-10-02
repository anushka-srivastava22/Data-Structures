class Subset_Array
{
    static boolean isSubset(int arr1[] ,int arr2[] , int m , int n)
    {
        int i = 0;
        sort(arr1 , 0 , m-1);
        for(i = 0; i < n; i++)
        {
            if(binarySearch(arr1 , 0 , m-1 , arr2[i]) == -1)
            {
                return false;
            }
        }
        return true;
    }

    static int binarySearch(int arr[] , int low , int high , int x)
    {
        if(high >= low)
        {
            int mid = (low + high)/2;
            if((mid == 0 || x > arr[mid - 1]) && (arr[mid] == x))
            {
                return mid;
            }
            else if(x > arr[mid])
            {
                return binarySearch(arr , (mid + 1) , high , x);
            }
            else
            {
                return binarySearch(arr , low , (mid - 1) , x);
            }
            
        }
        return -1;
    }
    static int partition(int arr[] , int low , int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for(int j = low; j < high; j++)
        {
            if(arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    static void sort(int arr[] , int low , int high)
    {
        if(low < high)
        {
            int pi = partition(arr , low , high);
            sort(arr , low , pi-1);
            sort(arr , pi+1 , high);
        }
    }
    public static void main(String args[])
    {
        int arr1[] = {11 , 1 , 13 , 21 , 3 , 7};
        int arr2[] = {11 , 3 , 7 , 1};
        int m = arr1.length;
        int n = arr2.length;
        if(isSubset(arr1 , arr2 , m , n))
        {
            System.out.print("arr2[] is subset of arr1[]");
        }
        else
        {
            System.out.print("arr2[] is not a subset of arr1[]");
        }
    }
}
        
                
        
        