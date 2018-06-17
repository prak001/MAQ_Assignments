import java.io.*;
import java.util.*;

public class GP {
	public int[] CSCC(){
		int[] top5 = new int[5];
		DL1();
		DL2();
		Arrays.sort(Z);
		for (int i = 0; i < 5; i++){
			top5[i] = Z[Z.length - i - 1];
		}
		return top5;
	}
	public void DQ(){
		tm = 0;
		E = new boolean[R.size()];
		l = new int[V.size()];
		for (int i = R.size()-1; i >= 0; i--){
			if (E[i] == false){
				D1(i);
			}
		}
	}

	
	public void DP(){
		E = new boolean[V.size()];
		Z = new int[V.size()];
		for (int i = l.length - 1; i >= 0; i--){
			int N = l[i];
			if (E[N] == false){
				sc = N;
				D2(N);
			}
		}
	}

	public void D1(int N){
		E[N] = true;
		for (int head : R.get(N)){
			if (E[head] == false){
				D1(head);
			}
		}
		l[tm] = N;
		tm++;
	}
	public void D2(int N){
		E[N] = true;
		Z[sc] ++;
		for (int head : V.get(N)){
			if (E[head] == false){
				D2(head);
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		
		GP g = new GP("SOC.txt");
		int[] topSCCs = g.CSCC();
		for (int n : topSCCs){
			System.out.print(n + " ");
		}
	}
		
	private ArrayList<ArrayList<Integer>> V; 
	private ArrayList<ArrayList<Integer>> R; 
	private int[] l; 
	private int[] Z; 
	private int tm; 
	private int sc; 
	private boolean[] E; 
	public GP(String inputFileName) throws FileNotFoundException{
		V = new ArrayList<ArrayList<Integer>>();
		R = new ArrayList<ArrayList<Integer>>();
		Scanner in = new Scanner(new File(inputFileName));
		//add all V
		while (in.hasNextInt()){
			 int tail = in.nextInt();
			 int head = in.nextInt();
			 int max = Math.max(tail, head);
			 while (V.size() < max){
				 V.add(new ArrayList<Integer>());
				 R.add(new ArrayList<Integer>());
			 }
			 V.get(tail-1).add(head-1);
			 R.get(head-1).add(tail-1);
			 
		}
	}
}