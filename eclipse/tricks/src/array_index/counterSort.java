package array_index;
/**
 * 给你n个无序的int整型数arr，并且这些整数的取值范围都在0-20之间，
 * 要你在 O(n) 的时间复杂度中把这 n 个数按照从小到大的顺序打印出来。
 * @author zone
 *
 */
public class counterSort {
	public void sort(int[] arrays) {
		int[] dict = new int[21];
		for(int i:arrays)
			dict[i]++;
		
		for(int i=0;i<dict.length;i++) {
			if(dict[i]==0)continue;
			for(int j=0;j<dict[i];j++)
				System.out.println(i);
		}
	}
}
