package tw.com.ej.test;

import java.util.ArrayList;
import java.util.List;

public class Count_Good_Nodes_in_Binary_Tree {
	int goodnums;
	

	public int goodNodes(TreeNode root) {
		int initVal = root.val;
		goodnums = 1;
		count(root,initVal);
		return goodnums;
	}
	//遞迴!!!!!
	private void count(TreeNode node,int bigNumber) {
		if (node.right != null && node.right.val >= bigNumber && node.right.val >= node.val) {
			goodnums++;
		}
		if (node.left != null && node.left.val >= bigNumber && node.left.val >= node.val)
			goodnums++;

		if (node.right != null)
			count(node.right,Math.max(bigNumber, node.val));
		if (node.left != null)
			count(node.left,Math.max(bigNumber, node.val));
	}

	private class TreeNode {
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
