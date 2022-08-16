package tw.com.ej.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumArray {
	Map<Integer, Integer> m;
	
	public NumArray(int[] nums) {
		m =new HashMap<>(); 
		int temp=0;
        for(int i =0;i<nums.length;i++) {
        	m.put(i, temp+=nums[i]);
        } 

    }
    
    public int sumRange(int left, int right) {
        return left==0?m.get(right):m.get(right)-m.get(left-1);
    }
}
