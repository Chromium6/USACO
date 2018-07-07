package contest.usaco.contest;
/**
NAME: agentmz1
LANG: JAVA
PROG: sort
*/

import java.io.*;
import java.util.*;

public class sort {

    /* var dec */
    static String programName = "sort";
    static int n; // array size
    static long[] s; // data, large numbers

    /* func dec */
    static int control() {
        int sum = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            sum ++;
            for (int i = 0; i < n-1; i ++) {
                if (s[i+1] < s[i]) {
                    //k.println("Swapping " + s[i] + " " + s[i+1]);
                    long temp = s[i+1];
                    s[i+1] = s[i];
                    s[i] = temp;
                    sorted = false;
                }
            }
        }
        return sum;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        s = new long[n];
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            long num = get(read, 0, 0);
            s[i] = num;
        }
        /* run */
        //MergeSort lognog = new MergeSort();
        /* exit */
        stderr.println(control());//lognog.sort(s, 0, n-1));
        stdin.close();
        stderr.close();
	}

    static int get(StringTokenizer k, int l) {
        return Integer.parseInt(k.nextToken());
    }

    static String get(StringTokenizer k) {
        return k.nextToken();
    }

    static long get(StringTokenizer k, int l, int j) {
        return Long.parseLong(k.nextToken());
    }

    static int mergeSort(long arr[], int array_size)
    {
        long temp[] = new long[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }
      
    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static int _mergeSort(long arr[], long temp[], int left, int right)
    {
      int mid, inv_count = 0;
      if (right > left)
      {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
        mid = (right + left)/2;
      
        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
        inv_count  = _mergeSort(arr, temp, left, mid);
        inv_count += _mergeSort(arr, temp, mid+1, right);
      
        /*Merge the two parts*/
        inv_count += merge(arr, temp, left, mid+1, right);
      }
      return inv_count;
    }
      
    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static int merge(long arr[], long temp[], int left, int mid, int right)
    {
      int i, j, k;
      int inv_count = 0;
      
      i = left; /* i is index for left subarray*/
      j = mid;  /* j is index for right subarray*/
      k = left; /* k is index for resultant merged subarray*/
      while ((i <= mid - 1) && (j <= right))
      {
        if (arr[i] <= arr[j])
        {
          temp[k++] = arr[i++];
        }
        else
        {
          temp[k++] = arr[j++];
      
         /*this is tricky -- see above explanation/diagram for merge()*/
          inv_count = inv_count + (mid - i);
        }
      }
      
      /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
      while (i <= mid - 1)
        temp[k++] = arr[i++];
      
      /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
      while (j <= right)
        temp[k++] = arr[j++];
      
      /*Copy back the merged elements to original array*/
      for (i=left; i <= right; i++)
        arr[i] = temp[i];
      
      return inv_count;
    }
}