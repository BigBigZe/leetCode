package bfAnddf.broken_calculator;

public class Optimization {
    public int brokenCalc(int X, int Y) {
    	if(X>=Y)return X-Y;
    	int counter = 0;
    	while(Y>X) {
    		counter++;
    		if(Y%2==0) {
    			Y=Y/2;
    		}else {
    			Y++;
    		}
    	}
		return counter+X-Y;
    }
    public static void main(String[] args) {
		System.out.println(new Optimization().brokenCalc(1, 1000000000));
	}
}
