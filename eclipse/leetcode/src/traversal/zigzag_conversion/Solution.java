package traversal.zigzag_conversion;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1||s==null||s.length()<=2)return s;
        
        int length = 2*numRows-2;
        int counter = 0,x=0,y=0;
        char[] chars = s.toCharArray();
        char[][] graph = new char[numRows][chars.length/2+numRows];
        for(int i=0;i<chars.length;i++) {
        	if(x>=numRows) {
        		x=numRows-2;
        		y++;
        	}
        	if(x<0) {
        		x=0;
        		y--;
        	}
        	if(counter%length<numRows)
        		graph[x++][y]= chars[i];
        	else
        		graph[x--][y++] = chars[i];
        	counter++;
        }
        for(char[] c:graph) {
        	for(char cc:c)
        		System.out.print(cc);
        	System.out.println();
        }
        s = "";
        for(int i=0;i<numRows;i++) {
        	for(int j=0;j<graph[0].length;j+=(numRows-1)) {
        		if(graph[i][j]==0)break;
        		s+=graph[i][j];
        		if(i==0||i==numRows-1)continue;
        		if(graph[i][j+numRows-i-1]!=0)
        			s+=graph[i][j+numRows-i-1];
        	}
        }

    	return s;
    }
    public static void main(String[] args) {
		char[] c = new char[1];
		System.out.println((int)c[0]);
		new Solution().convert("PAYPALISHIRING", 6);
	}
}
