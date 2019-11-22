package graph.evaluate_division;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    	double[] res = new double[queries.size()];
    	double[][] path;
    	int index = 0;
    	//构图
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(List<String> pair:equations) {
    		String _0 = pair.get(0),_1= pair.get(1);
    		if(!map.containsKey(_0))map.put(_0, index++);
    		if(!map.containsKey(_1))map.put(_1, index++);
    	}
    	path = new double[map.size()][map.size()];
    	for(int i=0;i<values.length;i++) {
    		List<String> pair = equations.get(i);
    		int _0 = map.get(pair.get(0)),_1= map.get(pair.get(1));
    		path[_0][_1] = values[i];
    		path[_1][_0] = 1/values[i];
    		path[_0][_0] = 1;
    		path[_1][_1] = 1;    		
    	}
    	
    	//Floyed
    	for(int k=0;k<map.size();k++) 
    		for(int i=0;i<map.size();i++)
    			for(int j=0;j<map.size();j++) 
    				if(path[i][k]*path[k][j]!=0)
    					path[i][j] = path[i][k]*path[k][j];
    		    		
    	//求解
    	for(int i=0;i<queries.size();i++) {
    		List<String> pair = equations.get(i);
    		String _0 = pair.get(0),_1= pair.get(1);
    		if(!map.containsKey(_0)||!map.containsKey(_1)) {
    			res[i] = -1;    
    			continue;
    		} 		
    		int x = map.get(_0),y = map.get(_1);
    		if(path[x][y]==0)res[i]=-1;
    		else
    			res[i] = path[x][y];
    	}
    	
    	return res;
    }

}
class Node{
	String name;
	double value;
	Node(String name,double value){
		this.name=name;
		this.value=value;
	}
}