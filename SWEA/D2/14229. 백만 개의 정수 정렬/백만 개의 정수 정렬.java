import java.util.Scanner;

public class Solution {
	
	static int[] arr = new int[1000000];
	static int N = arr.length;
	static int[] tmp = new int[N];
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<N; i++) {
        	arr[i] = sc.nextInt();
        }
        
        mergeSort(0, N-1);
        System.out.println(arr[500000]);
    }
    
    static void mergeSort(int left, int right) {
    	if(left >= right) return;
    	
    	if(left < right) {
    		int mid = (left + right) /2;
    		
    		mergeSort(left, mid);
    		mergeSort(mid+1, right);
    		
    		merge(left, mid, right);
    	}
    }
    
    static void merge(int left, int mid, int right) {
    	int l = left;
    	int r = mid+1;
    	
    	int idx = left;
    	
    	while(l<=mid && r<=right) {
    		if(arr[l] <= arr[r]) {
    			tmp[idx] = arr[l];
    			idx++;
    			l++;
    		} else {
    			tmp[idx++] = arr[r++];
    		}
    	}
    	
    	if(l <= mid) {
    		for(int i=l; i<=mid; i++) {
    			tmp[idx++] = arr[i];
    		}
    	} else {
    		for(int i=r; i<=right; i++) {
    			tmp[idx++] = arr[i];
    		}
    	}
    	
    	for(int i=left; i<=right; i++) {
    		arr[i] = tmp[i];
    	}
    }
    
}