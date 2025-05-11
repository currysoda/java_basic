package java_collections_example;

// Comparable<T> 를 구현해서 정렬 기준을 알려준다.
public class TreeNode implements Comparable<TreeNode> {
	
	private int    i;
	private String name;
	
	public TreeNode() {
	
	}
	
	public TreeNode(int i) {
		this.i = i;
		this.name = "default name" + String.valueOf(i);
	}
	
	public TreeNode(int i, String name) {
		this.i = i;
		this.name = name;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// compareTo 양수(본인이 더 큼) 0(같은 기준) 음수(비교대상이 더 큼)
	@Override
	public int compareTo(TreeNode treeNode) {
		return (this.i - treeNode.getI());
	}
	
	@Override
	public String toString() {
		return "i = " + i + " name = " + name;
	}
}
