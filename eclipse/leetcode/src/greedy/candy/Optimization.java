package greedy.candy;

import java.util.Arrays;

public class Optimization {
	public int candy(int[] ratings) {
		int sum = 0;
		int[] dict = new int[ratings.length];
		dict[0]=1;
		for(int i=1;i<ratings.length;i++)
			if(ratings[i]>ratings[i-1])dict[i]=dict[i-1]+1;
			else dict[i] = 1;
		
		for(int i=ratings.length-2;i>=0;i--)
			if(ratings[i]>ratings[i+1])
				dict[i] = dict[i]>dict[i+1]+1?dict[i]:dict[i+1]+1;
				
		for(int i:dict)sum+=i;
		return sum;
	}
}
