// java program to find the largest and smallest number simultaneously in an array using divide and conquer
import java.util.*;
public class MinMaxUsingMerge
{
	
	//method to accept array
	int[] createArray()
	{
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter the size of the array: ");
		n = sc.nextInt();
		
		int[] A = new int[n];
		System.out.println("Enter the array");
		int i;
		for(i = 0; i<A.length; i++)
		{
			System.out.print("Enter element: ");
			A[i] = sc.nextInt();
		}
		return A;
	}
	
	//merge method
	void merge(int[] Array, int low, int mid, int high)
	{
		// find size of two subarrays to be merged
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		//create two subarrays
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		//copy data to left array
		for(int i = 0; i<n1; i++)
		{
			left[i] = Array[low+i];
		}
		
		// copy data to right array
		for(int j = 0;j<n2; j++)
		{
			right[j]  = Array[mid + 1 +j];
		}
		
		//merge the temp arrays
		
		//initial indices of first and second subarrays
		int i = 0;
		int j = 0;
		
		//initial index of merged subarray is set to low
		int k = low;
		
		//merging process
		while(i<n1)
		{
			Array[k] = left[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			Array[k] = right[j];
			j++;
			k++;
		}
		
	}
	
	//sort function
	void sort(int[] Array, int low, int high)
	{
		if(low<high)
		{
			//find mid
			int mid = low + (high-low)/2;
			
			//sort first and second half
			sort(Array, low, mid);
			sort(Array, mid + 1, high);
			
			//Merge the sorted halves
			merge(Array, low, mid, high);
		}
	}
	
	
	int[] maxMin(int[] Array)
	{
		int[] maxmin = new int[2];
		
		int min, max;
		min = Array[0];
		max = Array[Array.length-1];
		
		maxmin[0] = min;
		maxmin[1] = max;
		return maxmin;
	}
	
	public static void main(String[] args)
	{
		MinMaxUsingMerge ob = new MinMaxUsingMerge();
		int[] arr = ob.createArray();
		ob.sort(arr, 0, arr.length-1);
		int[] maxmin = ob.maxMin(arr);
		System.out.println("maximum element in the array is " + maxmin[1] + " and minimum element in the array is " +maxmin[0]);
	}
}
