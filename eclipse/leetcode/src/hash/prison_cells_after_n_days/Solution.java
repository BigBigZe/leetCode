package hash.prison_cells_after_n_days;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
    	
    	int [] dict = new int[256];
    	int [] days = new int[256];
    	int endPoint = 0;
    	days[0] = convert(cells);
    	dict[convert(cells)] = -1;
        int[] res = new int[8];
        for(int i = 0;i<N;i++) {
        	res = new int[8];
        	for(int j=1;j<7;j++) {
        		if(cells[j-1]==1&&cells[j+1]==1 ||
        				cells[j-1]==0&&cells[j+1]==0)
        			res[j] = 1;
        		else
        			res[j] = 0;
        	}
        	int key = convert(res);
        	if(dict[key]==0) {
        		dict[key] = i+1;
        		days[i+1] = key;
        	}
        	else {
        		endPoint = dict[key]==-1?0:dict[key];
        		break;
        	}
            cells = res;
        }
        int counter = 0;
        for(int i=0;i<dict.length;i++)
        	if(dict[i]!=0)
        	    counter++;
        int key = (N-endPoint)%(counter-endPoint);
   
		return convert(days[key]);
    }
    public int[] convert(int key) {
    	int[] res = new int[8] ;
    	char[] binaryKey = Integer.toBinaryString(key).toCharArray();
    	int diff = 8-binaryKey.length;
    	for(int i=0;i<binaryKey.length;i++) { 
    		res[i+diff] = binaryKey[i]-'0';
    	}
    	return res;
    }
    
    public int convert(int[] cells) {
    	int sum = 0;
    	for(int i = 0;i<8;i++)
    		sum += cells[i]<<(7-i);
    	return sum;
    }
    public static void main(String[] args) {
		int[] cells = {0,0,0,1,1,0,1,0};
		int[] prisonAfterNDays = new Solution().prisonAfterNDays(cells, 14);
		for(int i: prisonAfterNDays)
			System.out.print(i+" ");
	}
}
