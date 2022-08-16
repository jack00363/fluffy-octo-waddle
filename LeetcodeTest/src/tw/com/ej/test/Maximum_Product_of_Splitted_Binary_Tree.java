package tw.com.ej.test;

public class Maximum_Product_of_Splitted_Binary_Tree {

	long allNodeSum;
	long temp;

	public int maxProduct(TreeNode root) {
		allNodeSum = getTreeNodeSum(root);
		get(root.left);
		get(root.right);
		long answer = temp % (1000000000 + 7);
		return (int) answer;
	}

	private long getTreeNodeSum(TreeNode node) {
		if (node == null)
			return 0;
		return node.val + getTreeNodeSum(node.left) + getTreeNodeSum(node.right);
	}

	private long get(TreeNode node) {
		if (node == null)
			return 0;
		long l = node.val + get(node.left) + get(node.right);
		temp = Math.max(temp, (allNodeSum - l) * l);
		return l;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
