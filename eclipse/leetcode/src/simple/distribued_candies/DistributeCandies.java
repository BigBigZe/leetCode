package simple.distribued_candies;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int i:candies) {
        	set.add(i);
        	if(set.size()>=candies.length/2)break;
        }       	
        return set.size()>=candies.length/2?candies.length/2:set.size();
    }
}
