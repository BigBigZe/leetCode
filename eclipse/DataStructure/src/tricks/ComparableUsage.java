package tricks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 广义上的比较，一般有两种方式，一种是实现Comparable接口
 * 另一种则是生成一个Comparator比较器。
 * @author zone
 *
 */
public class ComparableUsage {

	static private Comparator<Node> cmp;
	public static void main(String[] args) {
		List<Node> l = new ArrayList<>();
		l.add(new Node(2));
		l.add(new Node(1));
		l.add(new Node(4));
		l.add(new Node(0));
		l.add(new Node(3));
		cmp = new Comparator<Node>() {
			
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		Collections.sort(l);
		for (Node node : l) {
			System.out.println(node.weight);
		}
	}
}
class Node implements Comparable<Node>{
	int weight;
	public Node(int w) {
		this.weight = w;
	}
	@Override
	/**
	 * Compareble接口的使用：
	 * 当this小于传入对象时，返回负值，
	 * 当this等于传入对象时，返回0，
	 * 当this大于传入对象时，返回正值。
	 */
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		if(this.weight<node.weight)return -1;
		else if(this.weight>node.weight)return 1;
		return 0;
	}
	
}
