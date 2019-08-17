package hash.daily_temperatures;

public class Optimization {
	public int[] dailyTemperatures(int[] T) {
		int[] output = new int[T.length];
		for(int i=output.length-2;i>=0;i--) {
			for(int j=i+1;j<output.length;j+=output[j])
				if(T[i]<T[j]) {
					output[i] = j-i;
					break;
				}else if(output[j]==0) {
					output[i]=0;
					break;
				}
		}
		return output;
	}
}
