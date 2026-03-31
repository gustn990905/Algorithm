import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int Asize = Integer.parseInt(st.nextToken());
    	int Bsize = Integer.parseInt(st.nextToken());
    	
    	Set<Integer> A = new HashSet<>();
    	Set<Integer> B = new HashSet<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int a=0; a<Asize; a++) {
    		A.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int b=0; b<Bsize; b++) {
    		int target = Integer.parseInt(st.nextToken());
    		
    		if(A.contains(target)) A.remove(target);
    		else B.add(target);
    	}
    	
    	System.out.println(A.size() + B.size());
    }
}