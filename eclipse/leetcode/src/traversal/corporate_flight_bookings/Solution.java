package traversal.corporate_flight_bookings;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] lines: bookings) {
        	res[lines[0]] += lines[2]; 
        	if(lines[1]+1<n)res[lines[1]]-=lines[2];
        }
        for(int i=1;i<n;i++)
        	res[i] += res[i-1];
		return res ;
    }
}
